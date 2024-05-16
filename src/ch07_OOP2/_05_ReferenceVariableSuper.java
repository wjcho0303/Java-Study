package ch07_OOP2;

// super. 는 this.과 마찬가지로 객체 자신을 가리키는 참조변수이다.
// 그렇다. 부모를 가리키는 게 아니다. 오해하면 안 된다. super 와 this 둘 다 객체 자기 자신의 것을 가리키는 것이다.

// super. 도 this. 과 마찬가지로 인스턴스 메서드 내에서만 사용할 수 있다.
// 즉, main 같은 static 메서드에서 쓸 수 없다.

// super.도 객체 자신이고, this.도 객체 자신이면 대체 둘의 차이가 뭔가?
// 일단 this.은 지역변수 lv 와 자기 자신의 멤버변수 iv 가 같은 경우가 많으니 혼동하지 말라고 사용했었음을 떠올려보자.
// 그와는 달리 super.은 조상의 멤버를 자신의 멤버와 구분하려는 의도가 있을 때 사용한다.

// 예를 들어 보자.

class Parent1 {
    int x = 10;
}

class Child1 extends Parent1 {
    int x = 20;
    String y = "hello";

    public void childMethod() {
        System.out.println("Child's Method.");
    }

    public void childAndParentFields() {
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
        System.out.println("super.x = " + super.x);
    }
}

// 위와 같이 부모에서 정수형 멤버 x를 선언했는데 자식에서도 정수형 멤버 x를 선언했다.
// 이렇게 필드 이름이 같아도 에러가 발생하지 않는다. 문제는 개발자가 헷갈린다는 것이다.
// 그렇기 때문에 헷갈리지 말라고 super 를 쓰는 것이다. 사실 이렇게 멤버변수의 변수명을 똑같이 'x'로 쓰지 않았다면 쓸 일도 없었을 것이다.
// 이렇게 쓸 경우 메서드를 만들 때 부모로부터 물려받은 x에는 super.x 로 쓰고 자기 자신이 정의한 x는 this.x를 쓰면 되는 것이다.

// 정리하면
// super.은 "물려받은 멤버변수"임을 알리기 위해 적어주는 것이고,
// this.은 "물려받지 않은 나만의 멤버변수"임을 알리기 위해 적어주는 것이다.
// 중요한 건 super. 이든 this. 이든 자기 자신의 필드라는 것이다. 물려받은 것이든, 새로 만든 것이든 둘 다 객체가 가진 필드다.

// 추가로, 만약 Child1 에서 멤버변수 int x 를 선언하지 않았다면 어떻게 될까?
// 그럴 경우 super.x만 써야 하는 것인가? 아니다. this.x를 써도 똑같다. 즉, 그럴 때는 this.x == super.x 똑같다.
// 그리고 심지어 둘 다 쓸 수도 있다.


public class _05_ReferenceVariableSuper {
    public static void main(String[] args) {
        Parent1 p1 = new Parent1();                 // 부모 타입의 참조변수
        System.out.println("p1.x = " + p1.x);       // 10

        Child1 c1 = new Child1();                   // 자손 타입의 참조변수
        System.out.println("c1.x = " + c1.x);       // 20
        c1.childAndParentFields();      // x = 20
                                        // this.x = 20
                                        // super.x = 10

        Parent1 c2 = new Child1();                  // 부모 타입의 참조변수
        System.out.println("c2.x = " + c2.x);       // 10

        // 동일한 이름의 멤버 x가 선언되었으므로 이 경우에는 변수의 타입이 아닌 참조 변수의 타입에 따라 변수가 선택된다.
        // 이게 정상이다. 애초부터 조상 타입의 참조변수로 자손 타입의 필드에 접근하는 거 자체가 말이 안 된다.

/*      System.out.println("c2.y = " + c2.y);*/     // 에러
/*      c2.childMethod();                   */      // 에러



        // 사실 위에 나온 것처럼 부모 리모콘으로 자손만의 필드에 접근을 못하는 원리는 당연한 거고
        // 오버라이딩이 특별한 거였다.

        Parent5 parent = new Child5();
        parent.printMessage();
        // 오버라이딩한 메서드. 출력 내용은 Child's message 이다.
        // 이렇게, 부모 타입의 참조변수로 오버라이딩이 일어난 메서드를 호출하면
        // 부모의 원본 메서드가 아닌 오버라이딩 된 자손의 메서드가 호출된다.

/*      parent.iLoveYou();  */      // 에러.
        // 오버라이딩 되지 않은 자손만 가진 메서드는 이렇게 접근이 안 된다. 이게 당연한 거고 오버라이딩이 특별한 거다.
    }
}

class Parent5 {
    public void printMessage() {
        System.out.println("Parent's message");
    }
}

class Child5 extends Parent5 {
    public void printMessage() {
        System.out.println("Child's message");
    }

    public void iLoveYou() {
        System.out.println("I Love You.");
    }
}