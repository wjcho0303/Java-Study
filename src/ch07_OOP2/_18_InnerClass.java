package ch07_OOP2;

// 내부 클래스는 객체 생성 없이도 외부 클래스의 멤버들에 접근할 수 있다.
// 즉, 접근제어자 상관 없이 (심지어 private 이라 해도) 외부 클래스의 필드와 메서드에 접근이 가능하다.

// 이러한 특성은 또 하나의 캡슐화를 실현하는 하나의 방법이 될 수 있다.
// 즉, 내부 클래스가 외부 클래스라는 캡슐에 감춰지는 것이다.

// 내부 클래스는 외부 클래스의 도움을 받으면 main 메서드에서 객체 생성이 가능하긴 하지만
// 외부 클래스에 내부 클래스 객체를 생성하는 코드가 존재하지 않는다면 내부 클래스 객체는 main 에서 생성할 수 없다.

class A {
    int x = 100;
    B b = new B();
    class B {
        static int cv = 100;
        void methodB() {
            System.out.println(x);
            // 객체생성 없이 A의 필드인 x에 바로 접근 가능
        }
        @Override
        public String toString() {
            return "I'm an instance of B";
        }
    }

    public B makeInstanceB() {
        return b;
    }


}

class C {
    A a = new A();  // A의 필드에 접근하기 위해서는 A 인스턴스를 생성해야 함
    void methodC() {
        System.out.println(a.x);
    }
}

class OuterClass01 {

    // instance inner class : 멤버변수 선언 위치에 존재. 인스턴스 멤버변수처럼 다룬다.
    class InnerInstanceClass01 {
        void innerMethod() {
            System.out.println("This is InnerInstanceClass01's method.");
        }
    }
    InnerInstanceClass01 innerInstanceClassMember = new InnerInstanceClass01();


    // static inner class : 멤버변수 선언 위치에 존재. static 멤버처럼 다루어진다.
    // 특히 static 메서드에 사용될 목적으로 선언된다.
    // 이 static inner class 는 외부 클래스의 인스턴스와 독립적으로 존재한다.
    static class InnerStaticClass01 {
        int innerVariable = 30;
        // 이 변수에는 static 키워드를 붙이지 않았다. OuterClass 와는 별개이므로 static 이 붙든 안 붙든
        // 상관 없다.

        static int innerStaticVariable = 50;
        // 이 변수에는 static 키워드를 붙였다. 그러나 이 static 멤버변수는 내부 클래스 자체에 속하는 것일 뿐,
        // OuterClass 와는 별개이므로 상관 없다.

        static void innerStaticMethod() {
            System.out.println("This is InnerStaticClass01's method.");
        }
    }


    // local inner class : 메서드 내부 또는 초기화 블럭 내부에 선언되며, 선언된 영역 내부에서만 사용 가능
    void instanceMethod() {
        class InnerLocalClass01 {
            void localInnerMethod() {
                System.out.println("This is InnerLocalClass01's method.");
            }
        }

        InnerLocalClass01 innerLocal = new InnerLocalClass01();
        innerLocal.localInnerMethod();

    }
    // 이 외에도 익명 내부 클래스도 있는데, 이는 다른 파일에서 다룬다.
}

public class _18_InnerClass {
    public static void main(String[] args) {
        A a = new A();
/*      B b = new B();  */  // 내부 클래스의 객체를 main 에서 직접적으로 생성할 수는 없다.
        C c = new C();
        System.out.println(a.makeInstanceB());  // I'm an instance of B
        System.out.println(a.b);                // I'm an instance of B
        a.b.methodB();                          // 100
        c.methodC();                            // 100

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        OuterClass01 outer = new OuterClass01();
        outer.innerInstanceClassMember.innerMethod();         // This is InnerInstanceClass01's method.
        OuterClass01.InnerStaticClass01.innerStaticMethod();  // This is InnerStaticClass01's method.
        outer.instanceMethod();                               // This is InnerLocalClass01's method.

        // static inner class 는 위와 같이 외부클래스명.내부클래스명.static 메서드 순으로 참조하여 호출한다.



        // 많은 개발자들은 내부 클래스를 static 으로 선언하도록 권장하고 있다.
        // 1) static 내부 클래스는 외부 클래스의 인스턴스에 대한 참조를 유지하지 않아
        // 외부 클래스의 인스턴스가 없어도 내부 클래스를 사용할 수 있기 때문이다.
        // 이는 외부 클래스와 내부 클래스 간의 결합도를 낮추어 코드를 더 유연하게 하고 재사용 하기에 용이해진다.

        // 2) 내부 클래스가 static 으로 선언되면 컴파일러가 내부 클래스를 외부 클래스와 동등한 수준으로
        // 취급할 수 있게 된다. 이는 일반적으로 내부 클래스의 인스턴스를 생성하는 데 필요한 작업을 줄여주기 때문에
        // 성능을 향상시킬 수 있다.

        // 3) static 내부 클래스는 외부 클래스의 인스턴스와 독립적으로 존재하며, 외부 클래스의 인스턴스를
        // 생성하지 않아도 된다. 따라서 static 내부 클래스는 외부 클래스의 인스턴스에 대한 참조를 유지하지 않는다.
        // 외부 클래스의 인스턴스에 대한 참조가 존재하게 해버리면
        // 가비지 컬렉션이 인스턴스 수거를 하지 못하여 메모리 누수가 생길 수 있다.

        // 사실 static 'inner' class 라는 명칭보다는 static 'member' class 가 적절한 표현이다.
        // 그래서 실제로 static member class 또는 static nested class 라고 불리기도 한다.
    }
}
