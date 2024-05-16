package ch14_Lambda_Stream;

//
//      이번엔 Optional<T> 에 대해 배워보자. Optional<T> 는 T타입 객체의 래퍼클래스이다.
//      래퍼클래스가 뭐였더라?

//      chapter 9 의 10번 자료에서 따온 내용은 다음과 같다:
//          Wrapper Class (래퍼 클래스)는 기본형 값을 감싸는 클래스이다. 기본형이 8가지니까
//          래퍼 클래스의 종류도 8가지이다. 기본형을 객체로 다뤄야 할 때 사용한다.
//
//          Boolean     Character       Byte        Short
//          Integer     Long            Float       Double
//
//          객체지향언어인 자바에서 기본형을 사용할 수 있게 해놓은 것은 아무래도 성능때문이다.
//          객체는 참조변수를 통해 접근해야 하니까 대량으로 모이면 기본형 변수를 다루는 것보다
//          메모리에 부담이 될 수밖에 없다.
//
//      래퍼클래스 배웠던 내용을 보니 Integer 나 Long 타입의 값을 갖고 있던 클래스였던 것 같은데,
//      Optional<T> 는 좀 다른 것 같다? Optional<T> 도 래퍼클래스인데,
//      타입을 딱 정해놓은 게 아니라, 어떤 타입이든지 저장할 수 있게 해놓은 래퍼클래스라고 보면 된다.
//      래퍼클래스에 지네릭스의 유연성을 적용한 것이다.

//      public final class Optional<T> {
//          private final T value;      // T 타입의 참조변수. 모든 타입의 객체를 저장할 수 있다.
//          ...                         // 그리고 null 도 저장할 수 있다.
//      }
//
//      그럼 Optional<T> 래퍼클래스가 왜 필요할까?
//      null 을 저장하여 null 을 간접적으로 다루기 위해서다.
//      null 을 직접 다루는 건 NullPointerException 발생 때문에 위험하다.
//      null 을 직접 다루려면 if 문이 필수라서 좀 더 코드를 간결하게 하기 위해 Optional<T> 를 쓰는 게 좋다.
//      일반적으로 객체를 리턴하는 메서드가 있다고 했을 때, 객체가 리턴되거나 null 이 리턴되기 때문에
//      은근히 꿀이다.
//
//      Optional 객체 안에 null 을 넣어도 이 객체 자체는 주소가 있다. 그 안에 담긴 값이 없는 것일 뿐이다.
//      그래서 null 이 나오더라도 NullPointerException 이 발생하지 않는 것이다.
//
//
//
//      그러면 이 Optional 객체를 어떻게 생성할까? 다양한 방법이 있다.
//      String str = "abc";
//      Optional<String> optVal = Optional.of(str);
//
//      Optional<String> optVal = Optional.of("abc");
//
//      Optional<String> optVal = Optional.of(null);            // NullPointerException 발생!!!!!!!!
//      null 을 담을 수 있기는 하지만 이렇게 직접 null 을 입력하는 것은 불가능하다.
//
//      Optional<String> optVal = Optional.ofNullable(null);    // 가능
//      직접 null 을 입력하고 싶다면 ofNullable(null) 이라는 메서드와 매개변수를 입력해야 한다.
//
//
//      쌩 객체가 아니라 Optional 객체를 대신 사용하자는 것일 뿐이다.
//      만약 Optional 객체의 value 를 없애고 초기화하려면 ?
//      Optional<String> optVal = null;                         <-- 가능은 하지만 바람직하지 않음!!
//      Optional<String> optVal = Optional.empty();             <-- 이렇게 해야 됨!!!
//      Optional<String> optVal = Optional.<String>empty();     <-- 이렇게 해야 됨!!! (<String> 생략 가능)
//
//
//
//      그렇다면 위와 같이 이용해서 Optional<T> 래퍼클래스에 객체를 담았다고 하자.
//      그럼 그 래퍼클래스로부터 값을 가져오려면 어떻게 해야 하나?
//      이때 사용하는 메서드들은 다음과 같다: get(), orElse(), orElseGet(), orElseThrow()
//
//      Optional<String> optVal = Optional.of("abc");
//      이렇게 String 래퍼 클래스 Optional 에 "abc" 라는 String 객체를 저장한다고 하자.
//
//      저 "abc" 를 꺼내는 방법은 아래와 같다:
//      String str1 = optVal.get();                     <-- 잘 사용하지 않음. null 일 때 예외가 발생하기 때문.
//                                                          optVal 에 저장된 값을 리턴. null 이면 예외 발생

//      String str2 = optVal.orElse("");                ★ 많이 사용함
//                                                         optVal 에 저장된 값이 null 일 경우, "" 를 리턴

//      String str3 = optVal.orElseGet(String::new)     ★ 많이 사용함. 람다식을 넣을 수 있어서 사용함.
//                                                         람다식은 Supplier<? extends T> 를 넣을 수 있다.

//      String str3 = optVal.orElseGet(()->new String());  (람다식을 사용한 모습)
//

//      String str4 = optVal.orElseThrow(NullPointerException::new)
//      이건 .get 이랑 똑같다. 예외 종류를 지정해줄 수 있다는 차이가 있는데 잘 사용하지 않는다.
//
//
//
//      Optional 래퍼클래스 객체 안에 담긴 값이 null 인지 여부를 확인해주는 메서드도 있다.
//      isPresent() : Optional 래퍼 클래스 객체 안에 값이 잘 담겨 있다면 true, 담긴 값이 null 이면 false 를 리턴함
//
//      if(Optional.ofNullable(str).isPresent()) {
//          System.out.println(str);
//      }
//
import java.util.*;

public class _20_Optional1 {
    public static void main(String[] args) {
        // 배열 초기화. 초기화할 때 이렇게 값을 아예 넣지 않거나, 길이를 0 으로 하든지 하는 방법이 안전하다.
        // null 을 직접 입력하는 일이 없도록 하자.
        int[] arr = new int[0];
//      int[] arr = null;     // 이거 쓰면 에러 발생. 궁금하면 주석 풀고 해보도록 하자.
        System.out.println("arr.length = " + arr.length);

        Optional<String> optStr1 = Optional.empty();
        System.out.println(optStr1);        // "Optional.empty" 라고 출력
//      System.out.println(optStr1.get());  // NoSuchElementException 예외 발생. 이래서 get 을 잘 안 쓴다.
        String str1 = optStr1.orElse("");   // Optional 에 저장된 값이 null 일 때 빈 문자열을 리턴
        String str2 = optStr1.orElse("널"); // Optional 에 저장된 값이 null 일 때 "널"을 리턴

        System.out.println("str1 : " + str1);
        System.out.println("str2 : " + str2);

        // 그럼 이번엔 null 을 주지 말고 값을 넣어보면 어떻게 될까?
        Optional<String> optStr2 = Optional.of("abc");
        String str3 = optStr2.orElse("");   // Optional 에 저장된 값이 null 일 때 빈 문자열을 리턴
        String str4 = optStr2.orElse("널"); // Optional 에 저장된 값이 null 일 때 "널"을 리턴
        System.out.println("str3 : " + str3);
        System.out.println("str4 : " + str4);
    }
}
