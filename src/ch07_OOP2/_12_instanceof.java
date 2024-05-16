package ch07_OOP2;

//  instanceof 는 boolean 값을 반환하는 연산자이며, 참조변수 타입 간의 형변환이 가능한지 확인하기 위해 필수적으로 사용한다.

//  a instanceof B
//  a의 자리에는 참조변수가 오고, B의 자리에는 클래스명이 온다.
//  "참조변수 a가 담고 있는 객체 타입이 B 타입이거나 B의 자손의 타입에 속한다면 true, 아니면 false 를 반환.

//  그러므로 위의 연산을 통해 true 가 반환될 조건은 다음 2가지이다:
//  1) B가 참조변수 a가 담고 있는 객체의 타입과 동일한 타입일 때
//  2) B가 참조변수 a가 담고 있는 객체의 타입의 조상 타입일 때
//  B 자리에 Object 클래스명이 오면 항상 true 가 반환된다는 말이다.

//  참조변수의 형변환은 함부로 사용하면 안 되는 메서드가 있을 때 사용하면 매우 유용하다. 결국 보안과 관련되는 문제다.

//  앞에서 형변환에 대해 다룰 때 특별히 instanceof 라는 연산자를 통해 형변환 가능여부를 확인하지는 않았었다.
//  그러나 그렇게 instanceof 연산자 없이 형변환 가능여부를 확인하지 않고 형변환 시켜버리는 것은 매우 바람직하지 않다.
//  그냥 형변환하면 안 되고, 반드시 형변환 가능여부를 확인한 후에 형변환 해야 한다.

//  결국 실질적으로는 instanceof 연산자를 이용하여 더욱더 안전하게 조상 타입으로 형변환만 허용할 수 있다.
//  그렇게 함으로써 NotFound 에러가 발생하지 않게 조상 타입의 참조변수로만 안전하게 형변환 할 수 있다.

class Car1 {
    String color;
    int door;

    void drive() {
        System.out.println("drive, Brrrr~");
    }
    void stop() {
        System.out.println("Stop!");
    }

    Car1(String color, int door) {
        this.color = color;
        this.door = door;
    }

    void doWorkFire(Car1 c) {
        if (c instanceof FireEngine1) {
            FireEngine1 fe = (FireEngine1)c;
            fe.water();
        } else {
            System.out.println("형변환이 일어나지 않았습니다. 매개변수로 입력한 참조변수 " + c.toString() + "의 타입을 확인하세요.");
        }
    }
    // 이런 식으로 메서드의 매개변수에는 조상타입의 참조변수를 매개변수로 입력 받고,
    // 해당 참조변수에 대해서 적절한 타입인지 확인하기 위해 if 조건문에 instanceof 연산자를 통해 테스트를 한 후,
    // if문 내부에 true 일 때만 입력받은 매개변수를 형변환하고, 형변환 된 타입의 참조변수를 통해 실행할 메서드를 호출한다.

    void doWorkBeep(Car1 c) {
        if (c instanceof Ambulance1) {
            Ambulance1 am = (Ambulance1)c;
            am.beep();
        } else {
            System.out.println("형변환이 일어나지 않았습니다. 매개변수로 입력한 참조변수 " + c.toString() + "의 타입을 확인하세요.");
        }
    }
    // 위의 doWorkFire 와 마찬가지.
}

class FireEngine1 extends Car1 {
    int waterAmount;

    @Override
    void drive() {
        System.out.println("소방차가 달립니다, Brrrr~");
    }

    @Override
    void stop() {
        System.out.println("소방차가 멈춥니다, Stop!");
    }

    FireEngine1(String color, int door, int waterAmount) {
        super(color, door);
        this.waterAmount = waterAmount;
    }

    void water() {
        System.out.println("water!!!");
    }

    @Override
    public String toString() {
        return "FireEngine1";
    }
}

class Ambulance1 extends Car1 {
    String sound;
    Ambulance1(String color, int door, String sound) {
        super(color, door);
        this.sound = sound;
    }

    @Override
    void drive() {
        System.out.println("응급차가 달립니다, Brrrr~");
    }

    @Override
    void stop() {
        System.out.println("응급차가 멈춥니다, Stop!");
    }

    void beep() {
        System.out.println(this.sound + " " + this.sound);
    }

    @Override
    public String toString() {
        return "Ambulance1";
    }
}

public class _12_instanceof {
    public static void main(String[] args) {
        Car1 fe11 = new FireEngine1("red", 4, 7500);
        Car1 am11 = new Ambulance1("white", 7, "삐용~");
        // fe11 과 am11 두 참조변수 모두 현재 Car1 타입이다.

        fe11.drive();   // 소방차가 달립니다, Brrrr~
        am11.drive();   // 응급차가 달립니다, Brrrr~
        System.out.println("신호등이 빨간색이네요~ 정지하세요~");
        fe11.stop();    // 소방차가 멈춥니다, Stop!
        am11.stop();    // 응급차가 멈춥니다, Stop!
        System.out.println("다시 초록불로 바뀌었습니다~ 주행하세요~");
        fe11.drive();   // 소방차가 달립니다, Brrrr~
        am11.drive();   // 응급차가 달립니다, Brrrr~
        System.out.println("달리는 동안에 소방호스를 개방하시면 안 됩니다! 함부로 물을 개방하면 안되요!");
        System.out.println("응급 상황이 아닌데 사이렌을 울리시면 안 됩니다! 함부로 사이렌 켜지 마세요!");
        fe11.drive();   // 소방차가 달립니다, Brrrr~
        am11.drive();   // 응급차가 달립니다, Brrrr~

        System.out.println("화재 발생! 소방차와 응급차 출동하세요!");
        fe11.drive();   // 소방차가 달립니다, Brrrr~
        am11.drive();   // 응급차가 달립니다, Brrrr~
        System.out.println("응급 사이렌을 울리세요!");
        am11.doWorkBeep(am11);  // 삐용~ 삐용~
        am11.doWorkBeep(fe11);  // 형변환이 일어나지 않았습니다. 매개변수로 입력한 참조변수 FireEngine1의 타입을 확인하세요.
        // am11 을 매개변수로 받는 모습. 이때 내부적으로 형변환이 일어난다.
        System.out.println("현장에 도착했습니다! 소방 호스를 개방하여 화재를 진압하세요!");
        fe11.doWorkFire(fe11);  // water!!!
        fe11.doWorkFire(am11);  // 형변환이 일어나지 않았습니다. 매개변수로 입력한 참조변수 Ambulance1의 타입을 확인하세요.
        // fe11을 매개변수로 받는 모습. 이때 내부적으로 형변환이 일어난다.
    }
}

