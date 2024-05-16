package ch07_OOP2;

// 인터페이스는 추상 메서드만 쓸 수 있다는 법칙을 깨고
// default 메서드와 static 메서드를 사용할 수 있게 업그레이드 되었다.
// 기존의 인터페이스는 널리 쓰이는 인터페이스일수록 그 인터페이스에 추가할 메서드가 생겼을 때
// 그것을 구현한 클래스들에게 메서드를 강제하게 되었을 때 생기는 불편함이 컸다.
// 적은 클래스들만 인터페이스를 구현했다면 별로 안 힘들었을 것이다.
// 하지만 하나의 인터페이스를 수십 개에서 수백 개의 클래스들이 구현하는 상황이라면
// 인터페이스에 추상 메서드를 하나만 추가해도 나머지 구현 클래스들에서 그것을 모두 추가해줘야 한다.

// 그러한 문제점에 대한 대안으로 생긴 게 default method 이다.
// default 메서드는 기존의 인터페이스 사용 원칙과는 달리 인터페이스에 구현부까지 넣을 수 있게 한 메서드이다.
// 유의할 점은, 인터페이스의 default 메서드의 "default" 키워드와 접근 제어자 default 는 전혀 다른 의미라는 것이다.
// 인터페이스의 default 메서드는 Java 8부터 도입된 기능으로, 추상 메서드가 아닌 기본 동작을 제공하는 메서드이며,
// 구현의 강제성이 없는 메서드이다. 즉, 사용해도 되고 사용하지 않아도 되는 메서드이다.

// default 메서드의 예시를 살펴보자.
interface MyInterface {
    void abstractMethod();
    default void defaultMethod() {
        System.out.println("이것은 MyInterface 의 defaultMethod 구현부 코드이다.");
    }
    // 인터페이스에 선언하는 default 메서드는 이렇게 "default" 키워드를 명시적으로 적어준다.
    // 이 default 키워드는 접근 제어자 default 와 전혀 다른 카워드라는 점을 유의하자.
}

// default 메서드의 충돌 문제는 다음과 같이 해결한다:
// 1) 인터페이스(implements)와 조상 클래스(extends)의 메서드명이 겹치는 경우
// 그럴 경우에는 인터페이스와 조상 클래스 둘의 메서드 중에 조상 클래스의 메서드를 상속 받는다.
// 진짜 찐 조상님을 따라가는 게 맞지...

// 2) 만약 (implements A, B) A와 B 두 인터페이스의 default 메서드가 겹치는 경우
// 그럴 경우 인터페이스를 구현한 클래스에서 그 default 메서드를 오버라이딩(직접 구현)해야 한다.

class DefaultMethodTestClass implements MyInterface {
    @Override
    public void abstractMethod() {
        System.out.println("인터페이스를 구현 받아야 하기 때문에 필수적으로 구현해야 하는 추상 메서드.");
    }

    // defaultMethod 를 구현하지 않고 이렇게 생략해도 자동으로 상속받게 된다.
}

public class _17_DefaultMethodOfInterface {
    public static void main(String[] args) {
        DefaultMethodTestClass test = new DefaultMethodTestClass();
        test.defaultMethod();   // 출력내용: "이것은 MyInterface 의 defaultMethod 구현부 코드이다."
        // 위와 같이 default 키워드가 붙은 인터페이스 메서드는 구현한 클래스가
        // 직접 구현하지 않아도 자동으로 상속 받아서 이렇게 호출할 수 있다.
    }
}
