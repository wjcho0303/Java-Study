package ch06_OOP1;

// 지역변수는 수동으로 초기화해주어야 한다.
// 왜냐하면 지역변수까지 프로그램에서 자동으로 초기값을 부여해주면 메모리 낭비이기 때문이다.

// 멤버변수의 명시적 초기화

//  흔히 멤버변수를 적을 때는 초기화를 하지 않고 선언만 한다:
//  class Car {
//      int door;     primitive type 변수 선언
//      Engine e;     reference type 변수 선언
//  }

//  그런데 이번에는 명시적 초기화를 해보자
//  class Car {
//      int door = 4;             primitive type 변수의 명시적 초기화
//      Engine e = new Engine();  reference type 변수의 명시적 초기화
//  }

//  여기서 잠깐!
//  멤버변수로 객체를 둘 때는 Engine e; 이렇게 하는 거 아닌가?
//  아니다. 지금은 명시적 초기화이기 때문에 진짜 초기화 값을 넣고 싶다면 new Engine(); 명령을 통해 객체를 생성하는 것까지
//  진행을 해줘야 초기화를 해주는 것이라 할 수 있다.
//  물론 생성자에서 Engine e = new Engine(); 이렇게 해줘도 되긴 하다. 편한대로 하면 된다.

//  그리고 블럭 { } 을 사용한 방식의 초기화 방식도 있다. 복잡한 초기화가 필요할 때 사용할 수도 있다.
//  { } : 인스턴스 초기화 블럭  --> 근데 이건 거의 안 쓴다. 사실 생성자가 있기 때문에 전혀 쓸 이유가 없다.
//  static { } : 클래스 초기화 블럭  --> 안 쓰진 않는다.

//  static 블록을 이용한 클래스 초기화의 예시 ::
class StaticBlockExample {
    static int[] arr = new int[10];  // arr[0]  ~  arr[9]  까지를 static 변수로 선언
    static {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10) + 1;
        }   // 10개의 배열요소들이 모두 이 클래스의 static 변수가 되며, 초기값은 1 ~ 10까지의 난수가 되었다.
    }
}

//  이런 식으로 하면 arr 의 요소들에 대한 static 참조변수 arr[0] ~ arr[9]를 초기화할 수 있다.

public class _10_Initialization {
    public static void main(String[] args) {
        for (int i = 0; i < StaticBlockExample.arr.length; i++) {
            System.out.printf("%d번째 static 변수 : %d%n", i+1, StaticBlockExample.arr[i]);
        }
    }
}