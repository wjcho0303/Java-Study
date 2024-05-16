package ch14_Lambda_Stream;
import java.util.function.*;

//
//      여러 개의 Predicate 을 하나의 Predicate 으로 합칠 수 있다.
//      합칠 때 사용하는 메서드들은 세 가지이고, 다음과 같다:
//                  and()           or()            negate()
//
//      위 세 가지는 논리연산자 같은 메서드라고 생각하면 된다. 그래서 어렵지 않다.
//
//      예를 들어 아래의 Predicate 들이 있다고 하자
//      Predicate<Integer> p = i -> i < 100;
//      Predicate<Integer> q = i -> i < 200;
//      Predicate<Integer> r = i -> i%2 == 0;
//
//      사실 Predicate 의 참조변수들인 p, q, r 을 이용하면 다른 Predicate 에 사용할 수 있다.
//      사실 그렇게 복잡한 건 아니고 앞에서 배운 함수형 인터페이스를 매개변수로 사용하는 원리를 이용한 것일 뿐이다.
//      Predicate<Integer> notP  = p.negate();          // negate()가 p 에서 입력한 조건의 not 조건으로 만든다.
//      Predicate<Integer> all  = notP.and(q).or(r);    // 이렇게 여러 개를 계속 붙일 수도 있다.
//      Predicate<Integer> all2  = notP.and(q.or(r));   // 이렇게 괄호를 통해 순서를 분명하게 정해줄 수도 있다.
//
//      당연히 위에서 만들어진 notP, all, all2 도 다른 Predicate 조건식에 사용될 수 있다.
//      이런 식으로 여러 개의 Predicate 이 하나의 Predicate 으로 합쳐질 수 있는 것이다.
//
//      Predicate 을 쓸 때는 test() 라는 메서드를 써야 한다고 했다. 한 번 써보자.
//      System.out.println(all.test(2));        // (2 >= 100) && (2 < 200) || (2 % 2 == 0)      true
//      System.out.println(all2.test(2));       // (2 >= 100) && ((2 < 200) || (2 % 2 == 0))  false
//
//
//      등가비교를 위한 Predicate 작성에는 isEqual() 이라는 static 메서드를 사용한다.
//      함수형 인터페이스에 메서드 1개만 들어가야 한다는 제약이 있지만
//      static 메서드나 default 메서드는 들어갈 수 없다는 조건은 없었다. 그래서 이것도 가능한 것이다.
//
//      Predicate<String> p = Predicate.isEqual(str1)
//      static 이라서 Predicate.isEqual(str1) 이런 식으로 Predicate 클래스를 참조변수처럼 사용한다.
//      마치 Thread 에서 직접 Thread. 을 통해 코드를 적어준 것과 비슷한 것이다.
//
//      Boolean result = p.test(str2);
//
//      한 줄로 쭉 쓰면?
//      boolean result = Predicate.isEqual(str1).test(str2);
//      이게 사실 str1.equals(str2); 이거랑 똑같은 문장이다... 흠...
//

public class _08_PredicateCombine {
    public static void main(String[] args) {
        Function<String, Integer>	f  = (s) -> Integer.parseInt(s, 16);
        // f는 입력한 문자열을 16진수로 해석해서 10진수 Integer 형태로 리턴
        Function<Integer, String>	g  = (i) -> Integer.toBinaryString(i);
        // g는 입력한 Integer 를 2진수로 바꾸고 String 으로 리턴

        Function<String, String>    h  = f.andThen(g);
        // andThen 은 두 Function 을 연결해줘서 하나의 Function 처럼 만들어주는 메서드
        // 연결이 가능하려면 f 의 리턴과 g 의 입력이 똑같이 Integer 여야 한다.

        Function<Integer, Integer>  h2 = f.compose(g);
        // f.compose(g) 는 g.andThen(f) 와 똑같다. 순서만 다르게 쓰는 것이다.

        System.out.println(h.apply("FF")); // "FF" → 255 → "11111111"
        System.out.println(h2.apply(2));   // 2 → "10" → 16

        Function<String, String> f2 = x -> x; // 항등 함수(identity function)
        System.out.println(f2.apply("AAA"));  // AAA가 그대로 출력됨

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i%2 == 0;
        Predicate<Integer> notP = p.negate(); // i >= 100

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));       // true

        String str1 = new String("abc");
        String str2 = new String("abc");

        // str1과 str2가 같은지 비교한 결과를 반환
        Predicate<String> p2 = Predicate.isEqual(str1);
        boolean result = p2.test(str2);
        System.out.println(result);
    }
}
