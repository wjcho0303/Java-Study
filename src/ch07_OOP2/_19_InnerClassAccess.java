package ch07_OOP2;

// 일반적으로 class 앞에 올 수 있는 접근제어자는 public 과 (default)이다.
// 하지만 내부 클래스는 멤버로 취급하기 때문에 public, protected, (default), private 모두 올 수 있다.

class OuterClass {
    static int outercv = 500;
    protected class InnerInstanceClass {
        private int privateInnerIv = 300;   // private 으로 인해 외부 클래스에서도 접근 불가능
        static final int INNERCONST = 100;
        protected void innerMethodWithOuterStaticVariable() {
            System.out.println("This is InnerInstanceClass's method. outercv : " + outercv);
            System.out.println("This is InnerInstanceClass's method. INNERCONST : " + INNERCONST);
            System.out.println("This is InnerInstanceClass's method. privateInnerIv : " + privateInnerIv);
        }
    }

    protected InnerInstanceClass innerInstanceClass = new InnerInstanceClass();

    static class InnerStaticClass {
        int iv = 200;
        static int cv = 200;
    }

    void outerMethod() {
        class LocalInner {
            int iv = 300;
            static int cv = 300;
            final static int CONST = 300;
        }
    }
}

public class _19_InnerClassAccess {
    public static void main(String[] args) {
        System.out.println(OuterClass.InnerInstanceClass.INNERCONST);   // 100 출력
        // InnerInstanceClass 는 static inner class 는 아니지만
        // 내부 클래스의 static 변수는 위와 같이 내부 클래스의 인스턴스를 생성하지 않아도 호출 가능하다.

        System.out.println(OuterClass.InnerStaticClass.cv);             // 200 출력
//      System.out.println(OuterClass.InstanceInner.iv);    // 내부 클래스의 객체가 생성되지 않아 iv 사용 불가
//      System.out.println(OuterClass.InnerStaticClass.iv); // 내부 클래스의 객체가 생성되지 않아 iv 사용 불가

        OuterClass out = new OuterClass();



        // 내부 클래스 메서드 호출하기 1 : 외부 클래스에 내부 클래스 인스턴스를 생성해 놓은 것에 접근
        out.innerInstanceClass.innerMethodWithOuterStaticVariable();
        // This is InnerInstanceClass's method. outercv : 500
        // This is InnerInstanceClass's method. INNERCONST : 100
        // This is InnerInstanceClass's method. privateInnerIv : 300



        // 내부 클래스 메서드 호출하기 2 : main 에서 생성하여 내부 클래스 참조변수로 호출
        OuterClass.InnerInstanceClass instanceOfInnerInstanceClass = out.new InnerInstanceClass();
        // 인스턴스 내부클래스는 이와 같이 외부클래스의 객체를 먼저 생성해야 인스턴스를 생성할 수 있다.

        instanceOfInnerInstanceClass.innerMethodWithOuterStaticVariable();
        // This is InnerInstanceClass's method. outercv : 500
        // This is InnerInstanceClass's method. INNERCONST : 100
        // This is InnerInstanceClass's method. privateInnerIv : 300
    }
}
