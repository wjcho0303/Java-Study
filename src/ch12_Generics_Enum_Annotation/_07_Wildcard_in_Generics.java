package ch12_Generics_Enum_Annotation;
import java.util.*;

//      ArrayList<Product> list = new ArrayList<Tv>();     <--- 에러
//
//      일반적으로, 지네릭스는 참조변수(list)하고 생성자( ArrayList() )에 대입된 타입이 일치해야 한다.
//      사실 "일치시켜야 한다"라는 건 코드를 짜는 사람으로하여금 답답함을 느끼게 할 수 있다.
//      이러한 답답함을 해소하기 위해 나온 게 와일드카드 <?> 이다.
//      특히, 객체를 생성하는 경우에는 "참조변수"로 대입된 타입(왼쪽)에 와일드카드를 적어준다.
//      와일드카드를 사용하면 인스턴스를 생성할 때 타입이 일치하지 않아도 된다.
//      와일드카드를 사용하는 목적 자체가 하나의 참조변수로
//      서로 다른 타입이 대입된 여러 "지네릭 객체"를 다루기 위한 것이다.
//
//      와일드 카드는 세 종류가 있다:
//      1.      <? extends T>   : 상한 제한. T와 그 자손 클래스만 지정 가능
//      2.      <? super T>     : 하한 제한. T와 그 조상 클래스만 지정 가능
//      3.      <?>             : 제한 없음. 모든 타입의 클래스 지정 가능
//                                <? extends Object> 이거랑 똑같다.
//      가장 많이 쓰는 건 1번이다.
//
//      <? extends Product> : Product 를 포함한 자손들 (Product, Tv, Audio 가 저장될 수 있음)
//      <? super Tv>        : Tv 를 포함한 조상들 (Tv, Product 가 저장될 수 있음)
//
//      ArrayList<? extends Product> list = new ArrayList<Tv>();        <--- 가능
//      ArrayList<? extends Product> list = new ArrayList<Audio>();     <--- 가능
//
//      이렇게 객체를 생성하는 경우, 와일드카드는 참조변수에 대입되는 타입에 사용하면 된다.
//
//      static Juice makeJuice(FruitBox<? extends Fruit> box) {
//          String tmp = "";
//          for(Fruit f : box.getList()) tmp += f + " ";
//          return new Juice(tmp);
//      }
//
//      위와 같이 메서드의 매개변수(lv)에 와일드카드를 쓸 수도 있다.
//
//      참고로, 이전 소스 파일에서 필기했던 지네릭스 제약사항 1번의 경우는,
//      클래스에 선언된걸 static 메서드에서 못쓰는 것이고, 지금 이 상황은 static 메서드 자체에 선언된 것은 가능하다.
//      iv와 lv의 차이와 비슷한 개념이라고 생각하면 된다.
//      그땐 iv 이기 때문에 못 썼던 경우고, 지금은 lv 처럼 쓰는 상황이다.
//
//      그래서 저 메서드를 아래와 같이 호출해서 사용할 수 있다:
//      System.out.println(Juicer.makeJuice(new FruitBox<Fruit>()));
//      System.out.println(Juicer.makeJuice(new FruitBox<Apple>()));
//      System.out.println(Juicer.makeJuice(new FruitBox<Grape>()));
//      두 경우 모두 인스턴스의 생성자의 타입변수로 Fruit 자신과 Fruit 의 자손을 타입으로 저장한 모습이다.
//
//      만약 메서드 매개변수에 와일드카드를 사용하지 않았다면?
//      static Juice makeJuice(FruitBox<Fruit> box) { 이렇게 되어 있었다면?
//      System.out.println(Juicer.makeJuice(new FruitBox<Fruit>())); 이거 밖에 안 된다.
//      일치하는 것만 쓸 수 있으니까. 이해가 안 되면 GenericsType_and_Polymorphism 을 참고하자.
//

class Fruit2		       	{ public String toString() { return "Fruit";}}
class Apple2 extends Fruit2	{ public String toString() { return "Apple";}}
class Grape2 extends Fruit2	{ public String toString() { return "Grape";}}

class Juice {
    String name;            // 주스 안에 들어간 과일을 의미하는 멤버변수

    Juice(String name)       { this.name = name + "Juice"; } // 매개변수 과일을 넣으면 그 과일 주스가 됨
    public String toString() { return name;                } // 객체를 리턴하면 위에서 만든 이름을 리턴
}



class FruitBox2<T extends Fruit2> extends Box2<T> {}



public class _07_Wildcard_in_Generics {
    public static void main(String[] args) {
        FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();

//      FruitBox2<Fruit2> appleBox = new FruitBox2<Apple2>();           // <-- 오류
//      FruitBox2<? extends Fruit2> appleBox = new FruitBox2<Apple2>(); // <-- 정상

        // appleBox 의 타입이 위와 같이 설정되면? 다음과 같은 지네릭 클래스 객체 생성도 가능하다:
//      appleBox = new FruitBox2<Fruit2>();
//      appleBox = new FruitBox2<Apple2>();
//      appleBox = new FruitBox2<Grape2>();


        FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());
        appleBox.add(new Apple2());
        appleBox.add(new Apple2());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));
        // fruitBox 와 appleBox 둘 다 올 수 있는 이유는 아래 makeJuice 메서드에서
        // 매개변수 타입에 와일드카드를 쓴 것 덕분이다.
    }
}
class Juicer {
    static Juice makeJuice(FruitBox2<? extends Fruit2> box) {
        String tmp = "";

        for(Fruit2 f : box.getList())   // getList() 는 아래에 있음 요소들을 리턴하는 거임.
            tmp += f + " ";
        return new Juice(tmp);
    }
}
class Box2<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) { list.add(item);      }
    T get(int i)     { return list.get(i);  }
    ArrayList<T> getList() { return list;   }
    int size()       { return list.size();  }
    public String toString() { return list.toString();}
}