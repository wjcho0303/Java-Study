package ch07_OOP2;

// 인터페이스도 다형성이 성립한다. 인터페이스를 구현한 클래스가 자손 클래스처럼 취급된다.
// 그래서 앞서 클래스의 다형성을 배울 때 언급했던 것처럼 참조변수 타입, 매개변수 타입, 리턴 타입, 배열 타입 등
// 다양한 상황에서 다형성을 가진다. 즉, 인터페이스의 타입이 마치 조상 클래스의 타입처럼 다형성을 이용한 기능들을 작동시킬 수 있다는 것이다.
//    앞서 배워온 클래스의 다형성과 크게 다르지 않으며, 아래처럼 생각하면 된다:
//    조상 클래스 : 자손 클래스  =  인터페이스 : 이 인터페이스를 구현한 클래스

// 간단한 예시를 살펴보자:

interface Fightable {
    void move(int x, int y);
    void attack();
}

abstract class Unit1 {
    abstract void move(int x, int y);
    void attack() {
        System.out.println("공격");
    }
}

class Fighter extends Unit1 implements Fightable {
    public void move(int x, int y) {
        System.out.println("(" + x + "," + y + ") 좌표로 이동합니다.");
    }
    // move 메서드의 경우 abstract 클래스의 메서드와 인터페이스의 메서드의 이름이 충돌하지만 구현부가 없기 때문에 전혀 상관 없다.
    // 즉, 추상 클래스와 인터페이스 둘 다 오버라이딩 된 것으로 친다.

    public void attack() {
        System.out.println("꽁껵");
    }
    // attack 메서드의 경우에는 조상 클래스의 메서드에서 추상 메서드로 선언된 것은 아니다. 그러나 이름이 같은 메서드를 재정의하기 때문에
    // 조상 클래스의 입장에서는 오버라이딩한 것이다. 동시에, 인터페이스 입장에서도 추상 메서드를 구현한 것이기 때문에 오버라이딩한 것이다.
    // 즉, 이 경우도 마찬가지로 추상 클래스와 인터페이스 둘 다 오버라이딩 된 것이다.
}

public class _16_InterfaceAndPolymorph {
    public static void main(String[] args) {
        Unit1 u = new Fighter();        // 클래스의 다형성
        Fightable f = new Fighter();    // 인터페이스의 다형성
        // 클래스와 유사하게, 인터페이스도 다형성을 갖고 있기 때문에 객체 생성은 안되지만 참조변수 타입으로 사용될 수 있다.
        // 당연히 이 타입의 참조변수로는 해당 인터페이스가 보유한 추상 메서드만 호출이 가능하다.
        // 이 예시에서는 f 참조변수로는 오직 move(x, y), attack() 두 가지 메서드만 호출할 수 있다.

        f.move(1, 5);
        f.attack();

        // 그리고 아래처럼 특정 인터페이스를 타입으로 하는 참조변수를 해당 인터페이스를 implements 한 클래스 타입으로 형변환이 가능하다.
        if (f instanceof Fighter) {
            Fighter fighter = (Fighter)f;
            System.out.println("fighter = " + fighter);
        }
    }
}

//  이상 살펴본 인터페이스의 특징을 살펴볼 때, 인터페이스가 가진 장점은 다음과 같다:
//  1) 개발 시간을 단축할 수 있고, 협업에 유용하다.
//  인터페이스를 사용하면 코드의 재사용성을 높일 수 있다. 인터페이스를 구현하는 클래스들은 동일한 메서드 시그니처를 갖게 되므로,
//  이를 활용하여 다형성을 구현할 수 있다. 이는 새로운 기능을 추가할 때 기존 코드를 변경하지 않고도
//  새로운 클래스를 추가하고 인터페이스를 구현함으로써 개발 시간을 단축할 수 있는 유연성을 제공한다.
//  예를 들어, 여러 데이터 소스 (데이터베이스, 파일, API 등)로부터 데이터를 읽는 동일한 인터페이스를 구현하는 클래스를 만들어,
//  어플리케이션에서는 이 인터페이스만 호출하여 코드를 작성할 수 있다.
//  또, 인터페이스를 만들어 두면 해당 인터페이스를 구현한 클래스를 작성해놓지 않아도
//  일단 인터페이스를 import 해서 가져오면 코드를 작성할 수 있다.
//
//
//  2) 변경에 유리한 설계가 가능하다.
//  인터페이스를 사용하면 시스템의 변경에 유연하게 대응할 수 있다. 인터페이스를 구현하는 클래스는
//  인터페이스에 정의된 메서드를 구현해야 하므로, 구현 세부 내용은 숨겨지고 인터페이스의 메서드 시그니처만 공개된다.
//  이는 클래스의 내부 구현이 변경되더라도 인터페이스를 사용하는 코드에는 영향을 주지 않고 동작을 보장할 수 있게 한다.
//  예를 들어, 파일 시스템이나 데이터베이스를 사용하는 클래스가 변경되더라도 인터페이스를 통해 제공되는 메서드만 사용한다면
//  클라이언트 코드를 변경할 필요가 없다.
//  예를 들면 JDBC 나 JPA 라는 것은 ORM 과 연결해주는 인터페이스들이다.
//  이러한 DB 인터페이스가 없다면 데이터에 접근하는 코드를 ORM 에 맞춰서 작성해야 하기 때문에
//  ORM 을 변경할 일이 생기면 그에 따른 서버의 코드들도 다 바꿔버려야 한다.

class JustClassA {
    public void methodOfClassA() {
        System.out.println("methodOfClassA in A");
    }
}

class JustClassB {
    public void methodOfClassB(JustClassA a) {
        a.methodOfClassA();
    }
}

class JustClassC {
    public void methodOfClassA() {
        System.out.println("methodOfClassA in C");
    }
}
// A와 B는 직접적인 관계가 있는 클래스이다.
// 이러한 상황에서는 만약 A의 코드를 변경하게 되면 B의 코드도 수정해야 된다.
// 코드 간의 관계가 직접적이기 때문에 유연성이 떨어진다.
// 실제로 위에서 methodOfClassB(JustClassA a) 매개변수를 'JustClassA a' 에서 'JustClassC c'로 바꿔보자.
// 그러면 구현부를 c.methodOfClassA(); 이렇게 바꿔줘야 한다.


interface JustInterface {
    void methodOfClassD();
}

class JustClassD implements JustInterface {
    public void methodOfClassD() {
        System.out.println("methodOfClassD in D");
    }
}

class JustClassE {
    public void methodOfClassE(JustInterface justInterface) {
        justInterface.methodOfClassD();
    }
}

class JustClassF implements JustInterface {
    public void methodOfClassD() {
        System.out.println("methodOfClassD in F");
    }
}
// C와 D는 JustInterface 라는 interface 를 사이에 둔 간접적인 관계에 있다.
// D는 C에 의존하지 않고 인터페이스를 매개로 C와 관계를 갖고 있기 때문에 C의 내용이 변경되도 D의 코드를 수정할 일은 없게 된다.
// 이렇게 인터페이스를 사용하면 유연한 코드 작성이 가능해진다.
// 실제로 위에서 methodOfClassE 메서드의 매개변수가 JustInterface justInterface 이기 때문에
// JustClassD d 가 들어가도 문제 없고, JustClassF f 가 들어가도 문제가 없다. 즉, JustClassE 클래스 내용을 수정하지 않아도 된다.
// 이러한 유연성을 제공하는 것이 인터페이스의 장점 중 하나이다. 이는 인터페이스의 다형성으로부터 오는 장점이라고 볼 수 있다.


//  3) 표준화가 가능하다.
//  인터페이스를 사용하면 코드의 일관성과 표준화를 유지하기 쉽다. 특정한 기능이나 동작을 제공하는 여러 클래스들이 동일한 인터페이스를
//  구현하게 되면, 이들은 동일한 메서드들을 갖게 된다. 이는 코드의 읽기 쉽고 이해하기 쉬운 구조를 제공하며,
//  팀 내에서 표준화된 개발 방식을 채택하는 데 도움이 된다.
//  예를 들어, 자바 컬렉션 프레임워크의 다양한 컬렉션들은 Collection 인터페이스를 구현하여 표준화된 방법으로 데이터를 관리한다.
//
//  4) 서로 관계 없는 클래스들을 관련이 있게 맺어줄 수 있다.
//  인터페이스를 사용하면 서로 관계 없는 클래스들을 서로 관련 있게 맺어줄 수 있다.
//  인터페이스를 통해 다른 클래스들이 동일한 동작이나 기능을 제공한다는 관계를 형성할 수 있다.
//  이는 클래스 간의 의존성을 낮추고 코드의 유연성을 높이는데 도움이 된다.
//  예를 들어, 자바의 Comparable 인터페이스는 서로 다른 클래스들이 비교 가능하도록 만들어주는 일반적인 방법을 제공하여
//  서로 다른 클래스들 간의 관계를 형성한다.
//  예를 하나 더 들자면, SCV, Tank, DropShip 은 각자 뚜렷한 연결점이 없지만 Repairable 이라는 특성을
//  인터페이스를 통해 부여할 수 있다.


