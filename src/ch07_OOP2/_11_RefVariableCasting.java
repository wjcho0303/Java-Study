package ch07_OOP2;

// 참조변수의 형변환 : 사용할 수 있는 멤버의 갯수를 조절하는 것. 그 외에는 아무 것도 변하지 않는다.
// 주소값, 필드, 메서드 모두 전혀 변하지 않는다.

// 참조변수의 형변환은 조상과 자손 사이에서만 가능하다. 이건 다형셩 개념과도 연결되는 논의이다.
// 자손 타입에서 조상 타입으로 형변환할 수도 있고(upcasting), 조상 타입에서 자손 타입으로 형변환 할 수도 있다(down-casting).

class Car {
    String color;
    int door;

    void drive() {
        System.out.println("drive, Brrrr~");
    }
    void stop() {
        System.out.println("Stop!");
    }

    Car(String color, int door) {
        this.color = color;
        this.door = door;
    };
}

class FireEngine extends Car {
    int waterAmount;

    void water() {
        System.out.println("water!!!");
    }

    FireEngine(String color, int door, int waterAmount) {
        super(color, door);
        this.waterAmount = waterAmount;
    }
}

class Ambulance extends Car {
    String sound;

    void beep() {
        System.out.println("beep beep!!!");
    }

    Ambulance(String color, int door, String sound) {
        super(color, door);
        this.sound = sound;
    }
}

public class _11_RefVariableCasting {
    public static void main(String[] args) {
        FireEngine fire1 = new FireEngine("red", 4, 6000);

        // 현재 부모의 객체는 존재하지 않는 상황이다. 이걸 기억하면 헷갈릴 일이 없다.
        // 그러면 FireEngine() 객체 입장에서 봤을 때 부모의 리모컨이랑도 호환되고 자손의 리모컨이랑도 호환된다.
        // water() 메서드를 딱히 쓸 일이 없을 때 Car 리모컨을 쓰면 되는 거고,
        // water() 메서드를 자주 써야할 때 FireEngine 의 리모컨을 쓰면 되는 거다.
        // 그리고 원래는 사실 참조변수의 형변환을 하기 전에는 반드시 instnaceof 로 확인을 해야 한다.

        Car car = fire1;
        // 이 코드는 기존의 FireEngine 타입이었던 fire1 참조변수 타입을 Car 타입으로 바꾼다는 뜻이다.
        // 즉, 다음의 코드와 같은 말이다 :    Car car = (Car)fire1;
        // 이렇게 자손 타입의 참조변수에서 조상 타입의 참조변수로 형변환할 때는 ()를 통한 형변환 코드를 생략할 수 있다.
        // 자손 타입의 인스턴스는 조상 타입의 참조변수로 이해될 수 있기 때문에 안전한 형변환이다.
        // 그러므로 upcasting 은 암묵적인 형변환이 가능하다.

        car.color = "red";         // 정상 작동
        car.drive();               // 정상 작동
/*      car.water()    */          // 컴파일 에러. 참조변수가 Car 타입이기 때문에 water() 메서드가 없음.


        // 자동형변환을 이와 같이 자손 타입의 객체를 생성하면서 동시에 할 수도 있다.
        Car fire2 = new FireEngine("red", 4, 6000);
/*      fire2.water(); */          // 컴파일 에러. 참조변수가 Car 타입이기 때문에 water() 메서드가 없음.



        // 이번에는 Car 타입의 참조변수 car 를 자손 타입인 FireEngine 타입으로 형변환 시켜보자.
        FireEngine fire3 = (FireEngine)car;
        fire3.water();              // 정상 작동
        // 이렇게 자손 타입으로 형변환 시킬 때는 명시적으로 형변환 시켜주어야 한다.
        // 왜냐하면 참조변수끼리 형변환 시키는 것은 객체의 존재 여부 상관 없이도 컴파일 에러가 발생하지 않는다.
        // 그런데 만약 객체는 조상의 객체인데 참조변수는 자손의 것으로 형변환 시켜버리면 안 되기 때문에
        // 이렇게 down-casting 할 때는 형변환 기호( )를 생략할 수 없다.
        // 참조변수 타입이 가진 멤버의 갯수가 객체 타입이 가진 멤버의 갯수보다 많으면 안 되기 때문에,
        // 즉, 참조변수는 자손의 타입인데 객체는 조상의 타입이 되버리면 안 되기 때문에
        // 에러가 나는 것을 방지하기 위한 시스템이라고 이해하면 된다.

        System.out.println(car.toString());
        System.out.println(fire3.toString());
        // 참조변수 car 와 fire3 는 동일한 FireEngine 객체 ch07_OOP2.FireEngine@4e50df2e 를 가리킨다.



        // 팁을 주자면: 어떨 때는 암묵적으로 가능하고 어떨 때는 명시적으로만 해야하기 때문에
        // 암묵적으로 가능한 상황이든 불가능한 상황이든 그냥 무조건 명시적으로 형변환 해준다면 사실 전혀 헷갈릴 일이 없다.
        // 자손 타입과 조상 타입의 참조변수 간에 서로 형변환이 가능하다는 것만 알면 되는 것이다.
        // 후에 다시 언급되지만, 사실 참조변수 간의 형변환을 해줄 때 이렇게 그냥 해주면 안 되고,
        // 반드시 instanceof 라는 연산자를 이용한 if문 내부에서 true 일 경우에만 형변환 처리를 해주어야 한다.
    }
}
