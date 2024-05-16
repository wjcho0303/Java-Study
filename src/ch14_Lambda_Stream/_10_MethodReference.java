package ch14_Lambda_Stream;
import java.util.function.Function;
//
//      딱 하나의 메서드만 호출하는 람다식의 경우, '메서드 참조'로 더 간단히 할 수 있다.
//
//      static 메서드 참조의 경우
//      람다식:        x -> ClassName.method(x)
//      메서드 참조:    ClassName::method
//
//      인스턴스 메서드 참조의 경우
//      람다식:        (obj, x) -> obj.method(x)
//      메서드 참조:    ClassName::method
//
//      특정 객체 인스턴스 메서드 참조의 경우   (거의 안 씀)
//      람다식:        x -> obj.method(x)
//      메서드 참조:    obj::method
//
//      위에서 보이는 것처럼, 메서드 참조는 클래스이름, 메서드이름 이 두 가지만 있으면 된다...
//      (메서드의 클래스명::해당클래스의 메서드명)
//
//
//      Integer method(String s) {
//          return Integer.parseInt(s);
//      }
//      이런 메서드가 있다고 하자.


//      저걸 람다식으로 표현하면?
//      Function<String, Integer> f = (String s) -> Integer.parseInt(s);
//


//      그런데 저 상태에서 우항에 있는 람다식을 더 간단히 표현할 수 있다고? 그게 바로 메서드 참조다.
//      Function<String, Integer> f = Integer::parseInt;
//
//      자세히 한 번 살펴보자. 먼저 Function<String, Integer> f 부분에서,
//      이미 입력 타입이 String 이고, 출력 타입이 Integer 클래스임을 밝혔다.
//      그래서 (String s) -> Integer.parseInt(s); 부분에서 String 을 없애도 된다. 그럼
//      s -> Integer.parseInt(s);       이렇게 된다.
//      그런데 매개변수를 굳이 표현할 필요가 있을까? 어차피 지역변수인데? 얘도 없애자.
//        -> Integer.parseInt( );       근데 매개변수를 없앴는데 화살표랑 괄호를 쓸 필요가 있을까? 없애자.
//      Integer.parseInt;               이렇게 쓰니까 뭔가 쓰다가 만 것 같다. 저 Integer 클래스명이랑 메서드명 사이에
//                                      알아볼 수 있게 표시하자.
//      Integer::parseInt;              이걸 메서드 참조라고 하자. 클래스이름::메서드이름 이것만 쓰면 된다.
//
//
//      만약 메서드 참조를 딱 보고 그 메서드 참조의 람다식을 쓸 줄 안다면 메서드 참조를 이해한 것이다. 그러므로
//      메서드 참조를 봤을 때 모르겠다 싶으면 메서드 참조를 람다식으로 바꿔보는 연습을 해보자.
//      참고로, 람다식으로 바꿀 때 매개변수는 맘대로 해도 된다는 걸 기억하는 게 좋을 거다.
//      매개변수의 타입은 좌항에 써 있으니 큰 문제는 없을 거다.
//      다만, 메서드명을 봐도 그 메서드의 매개변수가 몇 개인지 모를 수는 있다. 그건 Java API 를 참고하면서 연습해보자.

public class _10_MethodReference {
    public static void main(String[] args) {
//      Function<String, Integer> f = (String s) -> Integer.parseInt(s);  // 람다식
        Function<String, Integer> f = Integer::parseInt;    // 메서드 참조.
        // 입력이 String 이란 건 좌항에서 알 수 있음.
        System.out.println(f.apply("100")+200);

    }
}