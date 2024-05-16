package ch14_Lambda_Stream;

//      * Remind *
//      Stream 을 이용한 작업의 패턴
//      1. Stream 만들기
//      2. 중간연산 (0번 ~ n번)
//      3. 최종연산
//
//      Collection 인터페이스에는 stream() 이라는 메서드가 있다. 메서드가 생긴 모양을 보면 다음과 같다:
//
//      Stream<E> stream()          컬렉션을 스트림으로 변환하고, 변환한 스트림을 리턴
//
//      stream() 의 사용 예시를 보자. List 컬렉션 list 가 있다고 하자.
//      List<Integer> list = Arrays.asList(1,2,3,4,5);

//      이 list 에다가 stream() 메서드를 사용하여 스트림을 만들어보자 : list.stream()
//      아주 간단하다.

//      물론 저렇게만 하면 만들기만 하는 거고, 변수에 담아서 사용해야 하니까 실제로는 이런 식으로 사용된다.
//      Stream<Integer> intStream = list.stream();
//
//      이 스트림의 모든 요소를 출력하려면 forEach 문을 쓰면 된다. 최종연산의 한 방식이다.
//      intStream.forEach(System.out::print);   // 출력내용: 12345
//      intStream.forEach(System.out::print);   // 에러 발생. 스트림이 이미 소모되어 닫혔음.

//      이거랑 상관 없긴 하지만 메서드 참조를 아래처럼 람다식으로 바꿀 수도 있다. 그냥 복습임.
//      intStream.forEach((i)->System.out.print(i));
//
//
//

import java.util.*;
import java.util.stream.*;

public class _13_Stream2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream();

        intStream.forEach(System.out::print);
    //  intStream.forEach(System.out::print);
        // 이 코드는 아래의 예외를 발생시킨다.
        //  Exception in thread "main" java.lang.IllegalStateException:
        //  stream has already been operated upon or closed

        //스트림을 또 사영하고 싶으면 스트림을 또 생성하면 된다.
        intStream = list.stream();      // 두 번째로 스트림을 생성할 때부터는 기존에 쓰던 참조변수를 그대로 쓰면 된다.
        intStream.forEach(System.out::print);
        // 이렇게, 스트림은 1회용이기 때문에 한 번 최종연산을 하고나면 닫힌다.
    }
}
