package ch07_OOP2;

class ParentExample {

    int x;

    int y;

    public void parentMethod() {
        System.out.println("This is ParentExample's Method.");
    }
}

class ChildExample extends ParentExample {

    int z;

    public void childMethod() {
        System.out.println("This is ChildExample's Method.");
    }
}


public class _01_Inheritance {
    public static void main(String[] args) {
        // 자손은 조상의 모든 필드와 메서드를 상속 받는다. 심지어 부모뿐만 아니라 부모의 부모것까지 상속받는다.
        // 그렇기 때문에 자손의 필드와 메서드 개수는 조상보다 절대 적을 수는 없다.

        // 단, 생성자 메서드와 초기화 블럭은 상속받지 않는다.
        // 그렇다는 것은 자손 클래스의 인스턴스는 참조변수를 통해 조상 클래스의 필드와 메서드에 접근할 수 있다는 것이다★★

        // 조상 클래스의 변경은 자손 클래스에 변경을 주지만 자손 클래스의 변경은 조상 클래스에 영향을 주지 않는다.

        ChildExample ch = new ChildExample();
        ch.x = 1;       // 조상의 멤버변수 x
        ch.y = 2;       // 조상의 멤버변수 y
        ch.z = 3;       // 자신의 멤버변수 z

        ch.parentMethod();     // This is ParentExample's Method.
        ch.childMethod();      // This is ChildExample's Method.



        // 참조변수의 타입은 부모 타입으로 하고 객체의 타입은 자손의 타입으로 할 수 있다.
        // 참조변수의 타입을 부모 것으로 하면 부모의 메서드에는 접근할 수 있지만 자손의 멤버변수와 메서드에는 접근할 수 없다.

        ParentExample ch2 = new ChildExample();
        ch2.x = 4;
        ch2.y = 5;

/*      ch2.z = 6;          // 컴파일 에러 발생. */
/*      ch2.childMethod();  // 컴파일 에러 발생. */

        // 참조변수의 타입이 부모의 것이기 때문에 해당 참조변수로는 자손의 필드인 z 와 childMethod() 메서드에 접근할 수 없다.
        // 그러므로 되도록 많은 필드와 메서드에 접근하고 싶다면 참조변수의 타입을 자손의 것으로 해야한다.
    }
}
