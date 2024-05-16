package ch12_Generics_Enum_Annotation;
import java.util.*;
//
//
//      Box<T>      지네릭 클래스. 'T의 Box' 또는 'T Box' 라고 읽는다.
//
//      T           타입변수 또는 타입 매개변수. (T는 타입문자. 알파벳이 꼭 T여야 할 필요는 없다.)
//
//      Box         원시 타입(raw type). 즉, 일반 클래스를 의미한다.
//                  일반 클래스에 <>를 붙이고 그 안에 타입변수를 집어넣으면 지네릭 클래스가 내부적으로 생성된다.
//                  (지네릭 클래스는 겉으로 보이지는 않는다)
//
//
//      class Box<T> {
//                                 <--- 이게 바로 지네릭 클래스를 선언하는 코드다.
//      }
//
//      그러면 이러한 지네릭 클래스의 객체는 어떻게 만드나?
//      예를 들어 String 클래스 타입으로 타입변수를 집어넣는다고 하자.
//
//      Box<String> b = new Box<String>();
//      이때, String 을 "대입된 타입" 또는 "매개변수화 된 타입"(parameterized type)이라고 부른다.
//
//      재밌는 사실은, 이런 매개변수화 된 타입은 객체를 만들 떄마다 다르게 지정해줄 수도 있다.
//      Box<Tv> tvBox = new Box<Tv>();
//      메서드랑 똑같다. 메서드를 호출할 때마다 다른 파라미터를 넣을 수 있는 것처럼 말이다.
//      메서드처럼 지네릭 클래스도 생성할 때마다 다른 타입의 객체를 넣어줄 수 있다.
//
//
//
//      참조변수와 생성자에 대입된 타입은 일치해야 한다.
//      ArrayList<Tv> list = new ArrayList<Tv>();       <--- 올바른 사용
//      ArrayList<Product> list = new ArrayList<Tv>();  <--- 오류 발생
//
//      Product 가 Tv 의 부모라고 할지라도 안 된다.
//      단, 지네릭 클래스 간의 다형성은 성립한다. "매개변수화 된 타입"을 다르게 하면 안되나는 것이다.
//
//      List<Tv> list = new ArrayList<Tv>();            <--- 올바른 사용(List 는 ArrayList 의 조상)
//      List<Tv> list = new LinkedList<Tv>();           <--- 올바른 사용(List 는 LinkedList 의 조상)
//
//      아니 그러면 매개변수는 다형성이 성립하지 않는다는 말인가?
//      다행히도, 매개변수의 다형성이 성립된다. 객체를 생성할 때 꺽쇄 안에 조상 클래스를 넣으면 된다.
//
//      ArrayList<Product> list = new ArrayList<Product>();
//      list.add(new Product());
//      list.add(new Tv());
//      list.add(new Audio());
//      이렇게, Product 의 ArrayList 를 만들면 Product 만 ArrayList 에 넣어야 하는 게 아니라
//      Product 의 자손클래스들인 Tv 와 Audio 도 ArrayList 에 넣을 수 있다는 말이다 ㄷㄷㄷㄷㄷ
//      그러므로 꺽쇄 안에 높은 조상 클래스를 넣을 수록 더 넓은 범위의 객체를 넣을 수 있다.
//
//      다만, 이렇게 자손들을 객체로 넣을 수 있는 대신, 지금 이 지네릭 클래스의 메서드들 중에 반환타입이
//      Product 라고 되어 있는 것들이 많을텐데, 그렇게 객체를 리턴하는 메서드들을 사용할 때는 형변환을 해줘야 한다.
//      예를 들면
//      Tv t = list.get(1);   <--- 이렇게 해버리면 안 된다.
//      왜냐면 get(1) 을 하면 리턴되는 게 Product 라서 Tv 의 참조변수 t 에 담고 싶다면 아래와 같이 해줘야 한다...
//      Tv t = (Tv)list.get(1);
//      이렇게 형변환을 해줘야 한다... 이렇게 해야 리턴된 Product 가 Tv 로 형변환이 되고 t 에 저장될 수 있다.
//
class Product {}
class Tv1 extends Product {}
class Audio1 extends Product {}


public class _03_GenericsType_and_Polymorphism {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<Tv1>      tvList = new ArrayList<Tv1>();
//  	ArrayList<Product> tvList = new ArrayList<Tv1>(); // 에러.
// 		List<Tv1>          tvList = new ArrayList<Tv1>(); // OK. 다형성 (List 가 ArrayList 의 조상이라서)

        productList.add(new Tv1());         // public boolean add(Product e) { ... }
        productList.add(new Audio1());      // public boolean add(Product e) { ... }

        tvList.add(new Tv1());
        tvList.add(new Tv1());
//        tvList.add(new Audio1());         // 에러 발생. 형제는 뭐 당연히 못 넣는다.

        printAll(productList);
//         printAll(tvList); // 컴파일 에러가 발생한다.
        // tvList 가 new ArrayList<Tv1> 이라는 것을 잘 생각해보면 이해가 되는 오류이다.
        // printAll 메서드는 파라미터로 ArrayList<Product> 를 받도록 설정되어 있다.
        // ArrayList<Product> 와 ArrayList<Tv1> 은 다형성이 되지 않아서 오류가 발생하는 것이다.

    }

    public static void printAll(ArrayList<Product> list) {
        for (Product p : list)
            System.out.println(p);
    }
    // 만약 printAll 메서드의 매개변수가 ArrayList<Tv1> 이었다면 printAll(productList)
    // 이게 에러가 발생했을 것이다.
}
