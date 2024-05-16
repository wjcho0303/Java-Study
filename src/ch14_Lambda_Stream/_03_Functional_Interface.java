package ch14_Lambda_Stream;

//        함수형 인터페이스 Functional Interface
//        함수형 인터페이스: 단 하나의 추상 메서드만 선언된 인터페이스이다.
//
//        예시
//        interface MyFunction {
//            public abstract int max (int a, int b);
//        }
//
//        함수형 인터페이스에서는 @FunctionalInterface 라고 어노테이션을 달아주어야 한다.
//        작성하지 않아도 오류는 생기지 않지만 어노테이션을 작성해야 컴파일러에서 함수형 인터페이스에
//        문제가 생겼을 때 알림을 보내준다.
//
//        위에서 선언한 인터페이스를 구현한 것이 다음과 같다:
//
//        MyFunction f = new MyFunction() {           // 익명 클래스의 선언과 객체생성을 동시에 하고 있다.
//            public int max(int a, int a) {          // new 뒤에는 조상클래스가 올 수도 있고 인터페이스가 올 수도 있다.
//                return a > b ? a : b;               // 뭐가 들어온들 구현할 메서드가 있으면 되는 거임.
//            }
//        };
//
//        이전 강의에서 new Object 라고 썼던 그 자리에 이제 인터페이스인 new MyFunction 이 온 것을 볼 수 있다.
//        이렇게 되면 Object 에 max() 라는 메서드가 없었던 것과 달리, MyFunction 에는 max() 라는 메서드를 정의해놓았기 때문에
//        문제가 해결된다.
//
//        함수형 인터페이스를 배운 이유는 람다식을 사용하기 위해서였다. 즉, 함수형 인터페이스 타입의 참조변수를 이용하면
//        람다식을 사용할 수 있다. 그러므로 위에 적었던 f를 다시 써보면 아래와 같다:
//
//                          MyFunction f = (a, b) -> a > b ? a : b;
//
//        이렇게 람다식을 통해 정의한 함수형 인터페이스를 실제로 작성해보면?
//
//                          int value = f.max(3,5);  (오류 안 생김)
//                          실제로는 람다식, 즉 익명함수가 호출된다.
//
//
//        실제 예시를 보자.
//


// 이 어노테이션을 붙여주면 함수형 인터페이스로 쓰겠다는 의미가 되서, 메서드를 여러 개 적었을 때 한 개만 적으라고 경고해준다.
@FunctionalInterface
interface MyFunction2 {
    int max(int a, int b);  // 함수형 인터페이스는 단 하나의 추상 메서드를 가짐.
}                           // 추상 메서드이기 때문에 구현하지 않음.
//                          // 인터페이스에 있는 메서드는 모두 public abstract 라서 제어자 생략함.

public class _03_Functional_Interface {
    public static void main(String[] args) {
        MyFunction2 mf2 = (a, b) -> a > b ? a : b;
        // 작성해 놓은 함수형 인터페이스의 참조변수를 선언하고 그 참조변수에 람다식을 저장.
        // 함수형 인터페이스는 메서드가 단 하나밖에 없기 때문에 int 를 쓰지 않아도 알아서 int 를 리턴하고,
        // 매개변수의 자료형도 이미 함수형 인터페이스에서 메서드를 선언할 때 써놨으므로 람다식에 안 써도 상관없다.


        int value = mf2.max(3,5);
        // 다만, 실제로 참조변수를 이용해서 호출할 때는 이렇게 메서드명인 max 를 꼭 적어줘야 하고,
        // max 의 파라미터를 적어줄 때도 정의한 자료형(예시에서는 int)을 준수해서 써줘야 한다.
        System.out.println("value = " + value);

    }
}
