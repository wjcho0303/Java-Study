package ch07_OOP2;

    // 다형성: "조상 타입의 참조변수(리모컨)로 자손 타입의 객체를 다루는 것"
    // 즉, 다형성이란 참조변수와 인스턴스의 타입이 서로 상속 관계라면 타입이 불일치해도 허용되는 것을 의미한다.
    // 단, 참조변수의 타입이 인스턴스의 타입보다 더 조상 클래스의 타입이어야 한다.

class Tv1 {
    boolean power;
    int channel;

    void power() {
        power = !power;
    }
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }
}

class SmartTv1 extends Tv1 {
    String text;
    void caption() {} // 내용 생략
}


public class _10_Polymorphism {
    public static void main(String[] args) {

        // 지금까지는 인스턴스를 생성할 때 아래와 같이 부모 클래스든 자손 클래스든 자기 클래스의 참조변수(리모콘)만 사용 했다.
        Tv1 t1 = new Tv1();                // 참조변수 t 사용
        SmartTv1 s1 = new SmartTv1();      // 참조변수 s 사용

        //  그런데 다형성 개념은 아래와 같다:
        Tv1 t2 = new SmartTv1();
        // 참조변수 t2 의 타입은 조상 클래스인 Tv1
        // 그런데 객체 SmartTv1()의 타입은 자손 클래스인 SmartTv1 이다.


        // 이건 무슨 상황인가? 리모콘은 Tv 꺼다. 근데 이 리모콘으로 SmartTv 자손 클래스의 인스턴스를 참조할 수 있다는 것이다.
        // 이렇게, "부모와 자손 클래스의 인스턴스 간의 참조변수 타입이 불일치해도 허용되는 것"이 바로 "다형성"이다.


        // 이렇게 리모컨과 객체가 불일치할 때 장점이 두 가지가 있다. 이 두 가지 장점 때문에 다형성이 중요한 것이다.
        // 이 다형성 덕분에 객체지향 프로그래밍에 엄청난 유연성이 있다.


        // 그럼 Tv1 t와  SmartTv1 s는 무슨 차이가 있나? 바로 호출할 수 있는 멤버의 개수에 차이가 있다는 점이다.
        // t의 멤버(리모컨 버튼)은 (필드2개, 메서드 3개) 5개고,
        // s의 멤버(리모컨 버튼)은 (부모꺼 5개+ 자기꺼 2개) 7개다.
        // s를 통해서는 7가지 모두를 접근할 수 있다. 그런데 t를 통해서는 5가지에밖에 접근하지 못한다.


        // 그 반대로는 안 된다. 즉,
/*      SmartTv1 s = new Tv1();   */    // 컴파일 에러


        // 자손 타입의 리모컨으로 조상타입의 객체에 접근할 수가 없다는 것이다.
        // 버튼이 있어봤자 객체에 그 기능이 없으면 당연히 작동을 안 하는 것이다.
        // 프로그래밍 관점에서 봐도 그 객체에는 없는 메서드인데 호출할 수 있게 허용해주는 거 자체가 논리적인 오류이다.
        // 그래서 처음부터 아예 컴파일러가 자손의 참조변수 SmartTv1 s에 부모의 객체 new Tv1()을 대입하는 것 자체를 막아버린다.


        // 그렇다면 다형성의 장점은 무엇일까? 두 가지다 :
        // 1. 매개변수를 다형적으로 사용할 수 있다.
        //    - 조상타입의 참조변수로 자손 객체를 다루는 것
        //    - 조상의 참조변수 간에 형변환을 해줌으로써 사용가능한 멤버변수를 조절하기
        //
        // 2. 하나의 조상 타입 배열 안에 여러 종류의 자손 타입 객체를 집어넣을 수 있다.
        Buyer buyer = new Buyer(1000, 0);

        Refrigerator refrigerator = new Refrigerator();
        Computer computer = new Computer();
        Audio audio = new Audio();

        // buy(Product p) 이기 때문에 Product 의 자손인 Refrigerator, Computer, Audio 모두 들어갈 수 있다.
        buyer.buy(refrigerator);
        buyer.buy(computer);
        buyer.buy(audio);

        // 이런 식으로 참조변수가 아닌 객체 자체를 넣으면 지역변수 p로 취급되기 때문에 문제없다.
        buyer.buy(new Refrigerator());
        buyer.buy(new Computer());
        buyer.buy(new Audio());
    }
}

class Product {
    int price;
    int bonusPoint;
}

class Refrigerator extends Product {

    public String toString() {
        return "Refrigerator";
    }

    public Refrigerator() {
        super.price = 210;
        super.bonusPoint = 200;
    }

}
class Computer extends Product {

    public String toString() {
        return "Computer";
    }

    public Computer() {
        super.price = 105;
        super.bonusPoint = 90;
    }
}
class Audio extends Product {

    public String toString() {
        return "Audio";
    }

    public Audio() {
        super.price = 12;
        super.bonusPoint = 7;
    }
}

class Buyer {
    int money = 1000;       // 단위: 만 원
    int point = 0;          // 단위: 점

    void buy(Product p) {
        this.money = this.money - p.price;
        this.point = this.point + p.bonusPoint;
        System.out.println(p.toString() + "의 가격은 " + p.price + "만원이며, 보너스 포인트는 " + p.bonusPoint + "점입니다. 구매하셨습니다.");
        System.out.println("현재 남은 잔액은 " + this.money + "만원입니다.");
        System.out.println("현재 보유 포인트는 " + this.point + "점입니다.");
    }
    // 여기서 매개변수로 입력받는 Product p 는 자손 타입의 참조변수도 들어갈 수 있다. 아래에서 예시를 확인하도록 하자.

    public Buyer(int money, int point) {
        this.money = money;
        this.point = point;
    }
}