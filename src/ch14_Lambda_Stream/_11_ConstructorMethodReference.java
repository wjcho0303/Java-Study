package ch14_Lambda_Stream;
import java.util.function.*;

//
//      앞에서 메서드 참조에 대해 배웠다.
//      그런데 생성자도 메서드이기 때문에 생성자에도 메서드 참조를 쓸 수 있다.
//
//      생성자의 메서드 참조를 살펴보기 전에 먼저, 생성자 메서드를 람다식으로 표현하는 것부터 보자.
//      참고로, 이건 기본 생성자의 경우이다. 기본 생성자는 매개변수를 입력하지 않기 때문에
//      함수형 인터페이스로 Supplier 를 이용한다.
//      Supplier<MyClass> s = () -> new MyClass();
//      생성자는 객체를 생성해서 준다.
//
//      이걸 어떻게 메서드 참조로 쓸까?
//      Supplier<MyClass> s = MyClass::new;
//      Supplier 의 경우 꺽쇄 안에 적어 놓는 것이 출력형의 타입만 존재하기 때문에
//
//      Supplier<클래스명> 객체 참조변수 = 클래스명::new;
//      이렇게 쓰면 된다. 필요한 정보는 오직 클래스명 하나이다. 객체 참조변수는 원하는 것으로 적으면 된다.
//
//
//
//      만약 입력값이 존재하는 생성자의 경우에는 어떻게 할까? 큰 차이는 없다. 그냥 Supplier 대신 Function 을 쓰면 된다.
//      Function<Integer, MyClass> s = i -> new MyClass(i);  // 람다식
//      Function<Integer, MyClass> s = MyClass::new         // 메서드 참조

//      질문: ?? 매개변수가 있는데 왜 매개변수에 대한 정보를 쓰지 않은 건가?
//      답변: ?? 뭔 소리? 매개변수 좌항에 있잖아 Integer 라고 써 있잖아...
//
//      메서드 참조의 핵심은 위에서 볼 수 있다시피,
//      "람다식에서 매개변수까지 없애는 것"... 이것이 바로 메서드 참조의 핵심이라 할 수 있다..
//
//
//      매개변수가 두 개면?
//      BiFunction<Integer, String, MyClass> s = MyClass::new;
//
//      매개변수가 세 개면?
//      TriFunction<Integer, String, Boolean, MyClass> s = MyClass::new;
//
//      좌항만 바뀌고 메서드 참조 부분은 유지됨...
//
//
//
//      그런데 new 가 나와서 생각나는 건데, 그러면 객체 생성 말고 배열을 생성할 때도 new 를 쓰는데 비슷하게 할 수 있을까?
//      ㅇㅇ
//
//      Function <Integer, int[]> f = x -> new int[x];      // 람다식
//      Function <Integer, int[]> f = x -> int[]::new;      // 메서드 참조
//      생성자에서 MyClass 라고 썼던 부분이 타입명[] 으로 바뀌었을 뿐이다.
//      심지어 배열의 길이가 곧 좌항의 Integer 이기 때문에 별도로 입력할 필요도 없다.
//      이 배열도 많이 쓴다.

class MyClass {
    int iv;

    MyClass() {};
    MyClass(int iv) {
        this.iv = iv;
    }
}

public class _11_ConstructorMethodReference {
    public static void main(String[] args) {
        Supplier<MyClass> s = () -> new MyClass();
        System.out.println("1: " + s.get());
        System.out.println("2: " + s.get());
        System.out.println("3: " + s.get());
        System.out.println("4: " + s.get());
        System.out.println("5: " + s.get());
        // 해쉬코드가 모두 다르다. 왜냐하면 s.get() 을 선언할 때마다 새로운 객체가 만들어지는 것이기 때문

        // 이번엔 메서드 참조 방식으로 줄여서 써보자.
        Supplier<MyClass> s1 = MyClass::new;
        System.out.println("6: " + s1.get());
        System.out.println("7: " + s1.get());
        // 마찬가지로 위와 동일한 현상이다.


        // 이번엔 매개변수를 입력하면서 생성자를 호출해보자.
        Function<Integer, MyClass> f = MyClass::new;
        System.out.println("8: " + f.apply(10).iv);
        System.out.println("9: " + f.apply(20).iv);


        // 이번엔 메서드 참조로 배열을 만들어 보자.
        Function<Integer, int[]> f2 = int[]::new;
        int[] arr = f2.apply(10);
        System.out.println(arr);
        arr[0] = 5;
        System.out.println(arr[0]);
        System.out.println(arr.length);
    }
}


