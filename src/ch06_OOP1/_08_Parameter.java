package ch06_OOP1;

class Data3 {
    int x;

    public void change(int x) {
        x = 1000;
        System.out.println("메서드 내부 시작");
        System.out.println("x = " + x);
        System.out.println("메서드 내부 끝");
    }

    public void change2(Data3 data3) {
        data3.x = 1000;
        System.out.println("메서드 내부 시작");
        System.out.println("x = " + data3.x);
        System.out.println("메서드 내부 끝");
    }

    public Data3 copy(Data3 d3) {
        Data3 tmp = new Data3();  // 새로운 인스턴스 tmp 를 만든다. (새로운 heap 영역 메모리 할당)
        tmp.x = d3.x;              // d.x의 값을 tmp.x에 복사하고 있다.
        return tmp;               // 복사한 객체의 주소를 반환하게 되는 메서드이다.
    }
}

public class _08_Parameter {
    public static void main(String[] args) {
        // 매개변수는 크게 두 가지로 나뉜다:
        // 기본형 매개변수: primitive parameter. 변수의 값을 읽기만 할 수 있다(read only)
        // 참조형 매개변수: reference parameter. 변수의 값을 읽고 변경할 수 있다(read & write)
        // 플래시 동영상 PrimitiveParam 과 ReferenceParam 을 참고하라.

        // 먼저 참조형 매개변수를 사용하는 메서드를 보자.
        // 기본형 매개변수 int x 를 사용하는 change 메서드를 살펴보자.
        System.out.println("=========================");
        Data3 d3 = new Data3();
        d3.x = 56;
        System.out.println("d3.x = " + d3.x);       // d3.x = 56

        d3.change(d3.x);                            // x = 1000
        System.out.println("d3.x = " + d3.x);       // d3.x = 56   값이 변하지 않음.

        // 이렇게 change 메서드에서 d3.x = 1000 으로 바꿔주었는데도 d3.x 가 실제로 1000 이 되지 않은 이유는
        // change 메서드의 매개변수 타입이 int 타입, 즉 기본형 타입이기 때문이다.
        // 애초부터 이 메서드에 d3 객체의 필드만 넣었지, d3 객체 자체를 입력해 넣지 않았기 때문에 바뀌지 않는 것이다.




        System.out.println("=========================");
        // 이번엔 참조형 매개변수 타입인 Data3 타입을 매개변수로 받는 change2 메서드를 사용해보자.
        d3.change2(d3);                             // x = 1000
        System.out.println("d3.x = " + d3.x);       // d3.x = 1000

        // 이번엔 실제로 d3 객체의 x 필드 값이 변했다. 이는 매개변수로 참조형 타입 Data3 를 받았기 때문에
        // 실제로 이 Data3 객체의 필드가 바뀔 수 있었던 것이다.
        // 즉, d3의 필드만 집어넣은 것이 아닌, d3 객체 자체를 집어넣었기 때문에 바뀔 수 있었던 것이다.




        System.out.println("=========================");
        // 이번에도 마찬 가지로 참조형 타입의 매개변수를 받는 경우를 살펴보자.
        Data3 d = new Data3();
        d.x = 15;
        System.out.println("d.x = " + d.x);

        Data3 d2 = d.copy(d);
        System.out.println("Data3 d2 = d.copy(d);");
        System.out.println("d2.x = " + d2.x + " , 동일한 x 필드값을 가진 Data3 객체 복사 완료");

        // 이제 d의 메모리가 바뀌어 있다. 그럼 기존에 heap 영역에 잡혀있던 메모리는 날아가는 것이다.
        // 이 메소드는 그러므로 Data3의 참조변수 주소를 바꿔주는 기능을 하는 메소드라고 볼 수 있다.
        // 참조형 매개변수를 사용하면 진짜로 해당 값이 변하게 된다.
    }
}
