package ch12_Generics_Enum_Annotation;

//
//      지네릭 메서드가 뭔가? "메서드에 지네릭 타입이 선언된 경우"를 지네릭 메서드라고 한다.
//      static <T> void sort(List<T> list, Comparator<? super T> c)
//      이런 식으로 메서드에 지네릭 타입을 선언한 것이 지네릭 메서드이다.
//      여기서 사용된 타입변수들은 당연히 그냥 지역변수(lv)처럼 사용된다.
//
//      class FruitBox<T> {    <-- 지네릭 클래스
//          ...
//          static <T> void sort (List<T> list, Comparator<? super T> c) {      <-- 지네릭 메서드
//              ...
//          }
//          ...
//      }
//      그렇다 보니 클래스의 타입 매개변수 <T>와 메서드의 타입 매개변수 <T>는 같은 T를 쓰더라도 별개이다.
//      마치 iv 와 lv 의 차이처럼 생각하면 된다.
//
//
//      이러한 지네릭 메서드는 메서드를 호출할 때마다 타입을 대입해야 한다. 원래는 그렇다.
//          makeJuice() 라는 메서드를 살펴보자.
//          static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
//              String tmp = "";
//              for(Fruit f : box.getList())
//              tmp += f + " ";
//              return new Juice(tmp);
//          }
//          이렇게 메서드의 반환 타입을 지네릭 타입으로 써서 makeJuice 는 지네릭 메서드이다.
//          이러한 지네릭 메서드는 호출할 때 다음과 같이 지네릭타입을 적어줘야 한다:
//
//          FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
//          FruitBox<Apple> fruitBox = new FruitBox<Apple>();
//              ...
//          System.out.println(Juicer.<Fruit>makeJuice(fruitBox)); //<--- fruitBox 의 지네릭 타입을 명시함
//          System.out.println(Juicer.<Apple>makeJuice(appleBox)); //<--- appleBox 의 지네릭 타입을 명시함
//          근데 사실 이렇게 지네릭 타입과 매개변수에 들어가는 지네릭 타입이 일치하는 경우 생략해도 된다.
//
//          System.out.println(Juicer.makeJuice(fruitBox));
//          System.out.println(Juicer.makeJuice(fruitBox));
//          이렇게 말이다.
//
//
//      기본적으로
//      와일드카드는 하나의 참조변수로 서도 다른 타입이 대입된 여러 지네릭 객체를 다룰 수 있게 하기 위한 거고,
//      지네릭 메서드는 호출할 때마다 다른 타입을 대입할 수 있게 하기 위한 목적이다.
//      현실적으로는 와일드카드가 안 될 때 지네릭 메서드를 쓰는 경우가 많다.


public class _08_GenericMethod {
    public static void main(String[] args) {

    }
}
