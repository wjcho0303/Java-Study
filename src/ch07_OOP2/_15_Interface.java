package ch07_OOP2;

// 인터페이스는 결론부터 말하면 "추상 메서드의 집합"이다. 그러므로 인터페이스는 구현된 것이 전혀 없는 설계도이다.
// 인터페이스는 클래스가 아니기 생성자도 없고, 그러므로 객체를 만들 수도 없다.
// 인터페이스는 필드를 가질 수 있긴 하지만 public static final 제어자인 필드만 가질 수 있다.
// 즉, 인터페이스의 필드는 implements 하기만 하면 사용할 수는 있지만 변경할 수는 없다.
// 인터페이스를 선언할 때는 접근제어자를 작성하지 않으며, 항상 public 이 기본값이다. 멤버를 변경할 일도 없고 메서드 구현부도 없기 때문이다.
// 즉, 인터페이스는 클래스에 비하면 상당히 개방적이다.

interface InterfaceTest1 {  // interface 의 접근제어자는 항상 public 이다. 접근제어자는 생략해야 하며, 생략하지 않으면 컴파일 에러.
     public static final int constNum1 = 10;  // interface 의 모든 필드는 예외 없이 public static final 이어야 한다.
     public abstract void sayHi();           // interface 의 모든 default 메서드는 예외 없이 public abstract 제어자를 포함해야 한다.
     public static void saySomething() {     // interface 의 static 메서드는 예외 없이 public static 이어야 한다.
         System.out.println("This is static method in interfaceTest1.");
     }

     // static 은 이와 같이 인터페이스라고 해도 무조건 구현부를 적어놓아야 한다.
     // 왜냐하면 인터페이스 내부에 정의한 static 메서드는 추상 메서드가 아니기 때문이다.
     // 실제로 public static abstract void 이런 식으로 제어자를 붙이면 컴파일 에러가 발생한다.
     // static 제어자는 구현부를 작성하도록 강제하는 반면에,
     // abstract 제어자는 구현부를 작성하지 않도록 강제하기 때문에 충돌하는 것이다.
 }

interface InterfaceTest2 {
    int constNum1 = 22;   // 제어자를 생략해도 interface 의 모든 필드는 항상 public static final 이다. 컴파일러가 자동으로 추가한다.
    public int constNum2 = 40;          // public static final 중 일부만 작성해도 컴파일러가 public static final 로 바꾼다.
    static int constNum3 = 48;          // public static final 중 일부만 작성해도 컴파일러가 public static final 로 바꾼다.
    final int constNum4 = 60;           // public static final 중 일부만 작성해도 컴파일러가 public static final 로 바꾼다.
    public final int constNum5 = 17;    // public static final 중 일부만 작성해도 컴파일러가 public static final 로 바꾼다.

    void sayHi();       // 제어자를 생략해도 interface 의 모든 메서드는 항상 public abstract 이다. 컴파일러가 자동으로 추가한다.

    static void saySomeThing() { // 접근제어자를 생략해도 모든 static 메서드는 항상 public 이다. 컴파일러가 자동으로 추가한다.
        System.out.println("This is static method in interfaceTest2.");
    }
}

// 인터페이스의 조상은 class 와는 다르게 Object 가 아니고 인터페이스만 조상이 될 수 있다.
// 인터페이스는 클래스와는 달리 다중상속이 가능하다. 즉, 추상 메서드는 서로 다른 인터페이스의 같은 이름의 추상 메서드가 존재해도 문제가 없다.
// 구현을 안 해놓았기 때문에 메서드 이름이 똑같아도 충돌 문제가 발생하지 않는 것이다.

// 추상 클래스와 인터페이스의 공통점은 무엇일까? 추상 메서드를 포함하고 있다는 것이다.
// 그렇다면 추상 클래스와 인터페이스의 차이점은 무엇일까?
// 1) 인스턴스 변수
// 2) 인스턴스 메서드
// 3) 생성자
// 추상 클래스는 1), 2), 3) 을 모두 가질 수 있지만
// 인터페이스는 오직 추상 메서드, static final 변수, static 메서드, default 메서드만 가질 수 있다는 제한을 받는다.
// 위에서 인터페이스는 "추상 메서드의 집합" 이라고 표현한 이유는 static final 변수 등의 것들은 부수적인 것에 불과하기 때문이다.
// 인터페이스라는 개념의 가장 핵심은 "추상 메서드의 집합"이라고 알아두는 것이 좋다.

class ImplementTestClass1 implements InterfaceTest1 {
     public void sayHi() {
         System.out.println("Hi. This is derived from InterfaceTest1.");
     }
}
// 인터페이스를 implements 하게 되면 해당 인터페이스가 가진 추상 메서드들은 반드시 선언 및 구현되어야 한다.
// implements 한 인터페이스의 추상 메서드들을 선언 또는 구현하지 않으면 컴파일 에러가 발생한다.

class ImplementTestClass2 implements InterfaceTest2 {
     public void sayHi() {
         System.out.println("Hi. This is derived from InterfaceTest2.");
     }
}

public class _15_Interface {
    public static void main(String[] args) {
        ImplementTestClass1 ifc1 = new ImplementTestClass1();
        ImplementTestClass2 ifc2 = new ImplementTestClass2();

        ifc1.sayHi();
        ifc2.sayHi();
        System.out.println("ifc1.constNum = " + ifc1.constNum1);
        System.out.println("ifc2.constNum = " + ifc2.constNum1);
/*      ifc1.constNum = 5;  */      // 컴파일 에러. "cannot assign a value to static final variable constNum"

        InterfaceTest1.saySomething();  // interfaceTest1 의 static 메서드인 saySomething()을 호출한 모습.
                                        // This is static method in interfaceTest1.

        InterfaceTest2.saySomeThing();  // interfaceTest2 의 static 메서드인 saySomething()을 호출한 모습.
                                        // This is static method in interfaceTest2.

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        Marine2 marine = new Marine2();
        Tank tank = new Tank();

        while(tank.hp > 0) {
            marine.attack(tank);
        }
        marine.attack(tank);    // 공격할 대상이 존재하지 않습니다.
        marine.attack(tank);    // 공격할 대상이 존재하지 않습니다.
    }
}

interface Movable {
    void move(int x, int y);
}

interface Attackable {
    void attack(Unit u);
}

class Marine2 extends Unit implements Movable, Attackable {
    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        // 지상유닛이므로 지형의 제한을 받도록 구현하는 내용 생략
        System.out.println("Marine" + " (" + x + ", " + y + ") 위치로 달려갑니다.");
    }

    @Override
    public void attack(Unit u) {
        if (u.isAlive == false) {
            System.out.println("공격할 대상이 존재하지 않습니다.");
        } else if(u.hp > this.power) {
            u.hp = u.hp - this.power;
            System.out.println(this.toString() + " 유닛이 " + u.toString() + " 유닛을 공격했습니다.");
            System.out.println(u.toString() + "의 남은 체력: " + u.hp);

            try {
                Thread.sleep(625);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (u.hp == this.power) {
                u.hp = u.hp - this.power;
                System.out.println(this.toString() + " 유닛이 " + u.toString() + " 유닛을 공격했습니다.");
                System.out.println(u.toString() + "의 남은 체력: " + u.hp);
                u.die();
            }
        }
    }

    void stimPack() {
        System.out.println("스팀팩 사용! 3초간 이동속도와 공격주기가 빨라집니다.");
        speed = 2.8125f;
        attackPeriod = 7.5f;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        speed = 1.875f;
        attackPeriod = 15;
        System.out.println("스팀팩 지속시간이 끝났습니다. 이동속도와 공격주기가 원래 상태로 되돌아옵니다.");
    }

    public String toString() {
        return "Marine";
    }
    public Marine2() {
        super(40, 1.875f, 6, 0, 15, true);
        System.out.println("Marine : \"You wanna piece of me, boy?\"");
    }
}