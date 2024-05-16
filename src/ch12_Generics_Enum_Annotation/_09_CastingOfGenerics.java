package ch12_Generics_Enum_Annotation;

//
//      지네릭 타입과 원시 타입 간의 형변환은 바람직하지 않고, 경고가 발생한다.

import java.util.ArrayList;

//      Box<Object> objBox = null;
//      Box box = (Box)objBox;      <-- 지네릭 타입인 Box<Object>를 원시 타입인 Box 로 형변환하려는 시도.
//                                                    objBox                box
//
//      objBox = (Box<Object>)box;  <-- 원시 타입인 Box 를 지네릭 타입인 Box<Object>로 형변환하려는 시도.
//                                                box                 objBox
//
//      위 두 경우 모두 경고가 발생하기는 하지만 예외가 발생하지는 않아서 실행 자체는 된다.
//
// 내용 참고:
// https://www.youtube.com/watch?v=8Ti7Beaq62A&list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp&index=141
//
interface Eatable3 {}

class Fruit3 implements Eatable3 {
    public String toString() { return "Fruit";}
}

class Apple3 extends Fruit3 { public String toString() { return "Apple";}}

class Grape3 extends Fruit3 { public String toString() { return "Grape";}}

class Toy3                 { public String toString() { return "Toy"  ;}}

class Box3<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) { list.add(item);     }
    T get(int i)     { return list.get(i); }
    int size()       { return list.size(); }
    public String toString() { return list.toString();}
}

class FruitBox3<T extends Fruit3 & Eatable3> extends Box3<T> {}


public class _09_CastingOfGenerics {
    public static void main(String[] args) {
        Box3 b = null;
        Box3<String> bStr = null;

        b = (Box3)bStr;             // Box3<String> --> Box3
        bStr = (Box3<String>)b;     // Box3         --> Box3<String>

        // 위 두 형변환 모두 가능은 하지만 바람직하지 못하다. 다른 예를 들어보자.
        Box3 box = new Box3<String>();
        box.add(new Integer(100));
        System.out.println(box);    // [100] 정상출력 됨. 그러나 Integer 에 빨간줄이 표시됨.

        // 이번엔 제네릭을 써보자.
        Box3<String> box2 = new Box3<String>();
//      box2.add(new Integer(100));  // 이번엔 이거 떄문에 실행 자체가 안 된다.
        System.out.println(box2);    // 위 주석을 없애고 실행하면 [] 라고 출력된다. 요소를 안 넣었으니 당연.
//
//      지네릭스가 이렇게 들어갈 타입을 걸러주는 역할을 한다.
//      위와 같이 인스턴스를 생성할 때 지네릭스 타입과 원시 타입을 섞어서 쓰면 안 된다.
//      에러가 나는 것은 아니지만 저렇게 해버리면 보다시피 다른 타입이 들어갈 수 있기 때문에
//      지네릭스를 쓰는 이유가 없어진다. 저렇게 아무거나 다 들어갈 수 있게 할거였으면
//      걍 둘 다 쓰질 말든가 헷갈리기 때문....
    }
}
