package ch07_OOP2;

//  제어자는 클래스나 클래스의 멤버(필드, 메서드)에 부가적인 의미를 부여한다.
//  접근제어자와 그 외 제어자들로 나뉜다.
//  접근제어자: public  protected  (default)  private
//  그 외 다른 제어자들: static,  final,  abstract,  native,  transient,  synchronized,  volatile,  strictfp
//
//
//  접근제어자는 네 가지 중 반드시 딱 한 가지만 붙일 수 있다. public protected <----- 오류 발생
//  그 외 다른 제어자는 조건만 맞으면 한 가지 이상 붙일 수 있다. ex) public static final
//  제어자가 여러 개 있을 경우 관례적으로 접근제어자를 가장 왼쪽에 입력해준다.
//  public, static, final 은 순서 상관 없이 작성해도 에러가 발생하지는 않기는 하나,
//  관례적으로 접근제어자, static, final 순서로 작성해주곤 한다.
//
//
//  final 이 붙은 대상이 어떤 것이냐에 따라 다음과 같은 특징을 가진다:
//  1. final class - 변경될 수 없고 확장(extend)될 수 없는 클래스가 된다.
//                   대표적인 final class 는 String 클래스와 Math 클래스가 있다. 이 둘은 상속이 불가능하다.
//                   String 클래스는 보안 문제 때문에 final 클래스로 한 것이다. 문자열 같은 경우 password 를 문자열로 저장할 수
//                   있는데, 만약 상속이 가능하면 자손에서 접근할 수도 있기 때문에 그것을 막기 위해 final 클래스로 한 것이고,
//                   Math 클래스는 전부 static 메서드이기 때문에 상속을 할 이유가 없어서 final 로 해놓은 것이다.
//
//  2. final method() - 변경될 수 없는 메서드. 재정의가 불가능하기 때문에 오버라이딩이 불가능하다.
//                      호출해서 사용하는 것은 가능하다. 다만 맘대로 수정하지 못하도록 막겠다는 거다.
//                      (클래스는 public 인데 메서드에 final 이 붙은 그런 클래스를 상속한 상황을 상상해보자.)
//
//  3. final 필드 - 값을 재정의 할 수 없는 필드가 된다.
//
//  4. final 지역변수 - 값을 재정의할 수 없는 지역변수가 된다.
//
//
//
//  abstract 제어자에 대해 알아보자. 자바에서 "abstract"가 붙으면 "미완성"이라는 단어를 떠올려야 한다.
//  추상 클래스 - 클래스 내에 추상 메서드가 선언되어 있음을 알려줄 때 클래스 앞에 abstract 를 붙인다.
//  추상 메서드 - 매개변수까지만 작성하고 구현부 { }는 작성하지 않은 미완성 메서드이다.


abstract class AbstractClass {
    abstract void testMethod();    // abstract 메서드 = 미완성 메서드
}
    // abstract 클래스 = 미완성 클래스 = 미완성 메서드를 가진 클래스
    // abstract 클래스는 곧 미완성 설계도다. 미완성 설계도로는 제품 생성이 불가능하다.
    // 즉, 추상 클래스로는 객체 생성이 불가능하다.

    // 그럼 이러한 추상 클래스는 절대로 객체를 만들 수 없는 것인가?
    // 꼭 그렇지는 않다. 추상 클래스를 상속 받은 클래스는 객체 생성이 가능하다.
    // 사실 추상 클래스 자체가 상속을 하기 위해 만들어진 클래스이기 때문이다.
    // 추상 클래스를 상속 받은 자손 클래스가 추상 메서드를 오버라이딩 받아서 생략했던 구현부를 채워넣어 사용하면 된다.
    // 이렇게 추상 클래스의 추상 메서드를 상속 받아 실제로 메서드를 구현한 클래스를 "구상 클래스"라고 한다.

class NonAbstractClass extends AbstractClass {
    @Override
    void testMethod() {
        System.out.println("AbstractClass 추상 클래스의 추상 메서드를 상속 받은 NonAbstractClass 의 test_method()");
    }
}

public class _08_Modifier_Abstract {
    public static void main(String[] args) {

        // AbstractTest instance1 = new AbstractTest();   // <--- 에러 발생. 추상 클래스는 객체 생성 불가!!
        NonAbstractClass nonAbstractClass = new NonAbstractClass();
        nonAbstractClass.testMethod();
    }
}
