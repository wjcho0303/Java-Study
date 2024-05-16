package ch12_Generics_Enum_Annotation;
import java.util.*;

//      타입변수를 이용하여 지네릭스 클래스를 만들 때 처음부터 타입에 조건을 걸 수 있다.
//      예를 들면
//
//      class FruitBox<T extends Fruit> {
//          ArrayList<T> list = new ArrayList<T>();
//          ...
//      }
//
//      위와 같이 <> 꺽쇄 안에 타입변수를 쓰고 옆에 extends 상속을 쓰면 그 클래스의 자손 클래스만 쓸 수 있다는 뜻이 된다.
//
//      FruitBox<Apple> appleBox = new FruitBox<Apple>();       // Apple 이 Fruit 의 자손이라서 허용
//      FruitBox<Toy> toyBox = new FruitBox<Toy>();             // Toy 는 Fruit 의 자손이 아니라서 오류
//
//      위에 T 만 썼다면 Toy 도 넣을 수 있었을 텐데 extends Fruit 을 써서 Fruit 및 Fruit 의 자손만 쓸 수 있게 된다.
//
//      그리고, Interface 를 상속할 때도 extends 를 쓴다.
//      주의할 점은, interface 니까 implements 를 써야 하는 것 아닌가? 생각이 들겠지만
//      interface 를 상속할 때도 extends 를 써야 한다.
//
//      interface Eatable { ... }
//
//      class FruitBox<T extends Eatable> { ... }
//      그러므로 이 경우에는 Eatable interface 를 구현한 클래스만 T 에 삽입할 수 있다.
//
//      예제를 살펴보자.
//


interface Eatable {}

class Fruit implements Eatable {
    public String toString() { return "Fruit";}
}

class Apple extends Fruit { public String toString() { return "Apple";}}

class Grape extends Fruit { public String toString() { return "Grape";}}

class Toy                 { public String toString() { return "Toy"  ;}}

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) { list.add(item);     }
    T get(int i)     { return list.get(i); }
    int size()       { return list.size(); }
    public String toString() { return list.toString();}
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}
 // 사실 "& Eatable" 이거 안 써도 된다. Fruit 이 Eatable 을 구현하고 있기 때문이다.

public class _06_LimitationInGenerics {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Grape> grapeBox = new FruitBox<Apple>(); // 에러. 타입 불일치
//		FruitBox<Toy>   toyBox   = new FruitBox<Toy>();   // 에러. FruitBox 지네릭 클래스는 Fruit 의 자손이어야 하기 때문.

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
//		appleBox.add(new Grape());  // 에러. Grape 는 Apple 의 자손이 아님
        grapeBox.add(new Grape());

        System.out.println("fruitBox-"+fruitBox);
        System.out.println("appleBox-"+appleBox);
        System.out.println("grapeBox-"+grapeBox);
        System.out.println(fruitBox.get(0));
        System.out.println(fruitBox.get(1));
        System.out.println(fruitBox.get(2));
        System.out.println(appleBox.get(0));
        System.out.println(grapeBox.get(0));
    }
}

//      지네릭스의 제약 사항 1
//      만약 어떤 클래스를 지네릭 타입변수에 저장하고 싶다? 근데 어떤 클래스나 다 저장되는 게 아니다.
//      타입변수에 저장되는 그 클래스가 만약에 멤버 중에 static 멤버변수나 static 메서드를 갖고 있다면?
//      못 넣는다. 왜 못 넣을까?
//      타입 변수 대입은 인스턴스를 생성할 때마다 다르게 할 수 있었다. 아래처럼 말이다:
//      Box<Apple> appleBox = new Box<Apple>();
//      Box<Grape> grapeBox = new Box<Grape>();
//
//      그런데 static 멤버변수나 static 메서드는 모든 인스턴스에 공통이기 때문에, 즉 클래스 멤버이기 때문에
//      어떤 특정한 인스턴스들이 누구나 다 접근하게 되면 큰 혼란이 일어날 수 있다.
//      그래서 static 멤버가 있는 클래스는 지네릭 클래스를 만들 수 없다. 그래서 오류가 발생한다.
//
//
//      지네릭스의 제약 사항 2
//      타입변수의 배열 생성 선언은 가능하지만 배열을 생성할 때는(new 키워드 쓸 때) 타입 변수 사용 불가하다.
//
//      class Box<T> {
//          T[] itemArr;                                <-- 이건 가능 (배열의 참조변수 선언만 하는 것)
//          ...
//
//          T[] toArray() {
//              T[] tmpArr = new T[itemArr.length];     <-- 이건 불가능 (new 쓰고 배열 생성하는 것)
//              ...
//          }
//      }
//
//      사실 배열 뿐만 아니라 객체 생성이나 배열 생성 둘 다 저렇게 쓸 수 없다...
//                      new T();            new T[5];   <-- 이거 둘 다 불가능
//      왜냐하면 new 키워드를 써서 생성자를 호출할 때는 타입이 확정되어 있어야 하기 때문이다.
//
