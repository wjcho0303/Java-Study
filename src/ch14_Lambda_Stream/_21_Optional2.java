package ch14_Lambda_Stream;

//
//      OptionalInt, OptionalLong, OptionalDouble 에 대해서 알아 보자.
//      이것들을 기본형 값을 감싸는 래퍼클래스이다. 사실 Optional<T> 를 써도 되긴 하지만
//      Optional<T> 같은 경우는 모든 것을 감싸고 있고 모든 것을 객체로 감쌌기 때문에
//      성능 때문에 이런 것들을 사용하는 것이다. <T> 이런 것들이 어찌됐든 참조형 타입이기 때문에 주소를 찾아서 사용하는
//      방식으로 작동하는 것이기 때문에 참조형 대신 기본형을 직접 사용하는 것이다.
//
//      public final class OptionalInt {
//          ...
//          private final boolean isPresent;
//          private final int value;        <-- T 가 아니라 int 로 되어 있음
//      }
//      참조형이 아니기 때문에 호출되었을 때 주소를 참조할 필요없이 즉각적으로 값을 리턴하기 때문에 참조형보다 빠르다.
//
//      값을 리턴할 때는 아래와 같은 메서드를 사용한다.
//      int getAsInt()
//
//      그러면 이 경우에는 빈 Optional 객체와 초기값이 저장된 Optional 객체를 어떻게 구분할 수 있을까?
//      OptionalInt opt1 = OptionalInt.of(0);
//      OptionalInt opt2 = OptionalInt.empty();
//      얘네 둘을 어떻게 구분할까? 이거 때문에 OptionalInt 클래스에 isPresent 메서드가 존재하는 것이다.
//
//      System.out.println(opt1.isPresent());   // true
//      System.out.println(opt2.isPresent());   // false
//      System.out.println(opt1.equals(opt2));  // false
//

import java.util.*;

public class _21_Optional2 {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
        // Optional 클래스에도 map 이라는 메서드가 있어서 값을 변환할 수 있게 해준다.
        // 매개변수에 들어간 메서드 참조식을 람다식으로 바꾸면? str->str.length()

        System.out.println("optStr : " + optStr.get()); // abcde 출력
        System.out.println("optInt : " + optInt.get()); // 5 출력

        int result1 = Optional.of("123")        // "123" 문자열을 먼저 래퍼클래스로 생성
                .filter(x->x.length()>0)              // 문자열이 존재하지 않으면 걸러냄
                .map(Integer::parseInt).get();        // 값을 변환
    //  람다식:  .map(str->str.parseInt()).get();

        int result2 = Optional.of("")
                .filter(x->x.length()>0)
                .map(Integer::parseInt).orElse(-1); // result2 에 저장된 값이 없어서 orElse 의 파라미터가 출력

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);


        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x-> System.out.printf("result3 : %d%n", x));
        // isPresent 가 아니라 ifPresent 라는 점 주의
        // ifPresent 는 값이 존재할 경우(null 이 아닐 경우) 입력한 람다식을 실행하게 하는 메서드이다.


        OptionalInt optInt1 = OptionalInt.of(0);  // 0 을 값으로 하는 OptionalInt 객체 생성
        OptionalInt optInt2 = OptionalInt.empty();      // 빈 OptionalInt 객체 생성

        // isPresent() 메서드를 통해 값의 존재여부 확인하기
        System.out.println(optInt1.isPresent());    // true 출력
        System.out.println(optInt2.isPresent());    // false 출력

        // getAsInt() 메서드를 통해 값을 리턴 받기
        System.out.println(optInt1.getAsInt());     // 0 출력
//      System.out.println(optInt2.getAsInt());     // NoSuchElementException 예외 발생
        System.out.println("optInt1 : " + optInt1); // OptionalInt[0] 출력
        System.out.println("optInt2 : " + optInt2); // OptionalInt.empty 출력
        System.out.println("optInt1.equals(optInt2) : " + optInt1.equals(optInt2)); // false 출력
    }
}
