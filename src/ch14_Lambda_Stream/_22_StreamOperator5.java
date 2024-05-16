package ch14_Lambda_Stream;

//
//      이번엔 스트림의 최종연산에 대해 알아본다.
//      최종연산 메서드는 Stream 만 리턴하는 중간연산 메서드들과는 달리 다양한 타입으로 리턴을 한다:
//                              int     boolean     Optional  등등
//
//      최종연산 메서드는 아래와 같은 것들이 있다 (앞에 적은 것 복붙함):
//
//      long count()                                        스트림의 요소가 몇 개인지 리턴
//
//      Optional<T> max(Comparator<? super T> comparator)   스트림 요소 중 최댓값을 리턴. 정렬기준을 줘야 함
//      Optional<T> min(Comparator<? super T> comparator)   스트림 요소 중 최솟값을 리턴. 정렬기준을 줘야 함
//
//
//      Object[] toArray()                                  모든 요소를 객체 배열로 리턴
//      A[] toArray(IntFunction<A[]> generator)             모든 요소를 객체 배열로 리턴. generator 를 주어
//                                                          특정 타입의 배열로 받을 수 있다.
//
//
//
//
//
//
//      먼저, forEach 에 대해 살펴보자.
//      void forEach(Consumer<? super T> action)            각 요소에 입력한 람다식을 수행
//      void forEachOrdered(Consumer<? super T> action)     병렬 스트림으로 처리할 때도 작업 순서를 유지시킬 때 사용
//
//      forEach 는 스트림의 모든 요소에 입력한 작업을 수행하는 메서드이다: forEach(), forEachOrdered()
//      forEach() 메서드는 병렬스트림에서 순서가 보장되지 않지만,
//      forEachOrdered() 메서드는 병렬에서 순서가 보장된다.
//
//      IntStream.range(1,10).sequential().forEach(System.out::print);        // 123456789
//      IntStream.range(1,10).sequential().forEachOrdered(System.out::print); // 123456789
//      * range(1,10) 의 의미는, 1과 10 사이, 10은 포함하지 않는 정수를 가져온다.
//      * sequential() 은 직렬 스트림으로 처리하는 기능을 수행한다. 기본설정이라 생략하면 자동으로 sequential() 이다.
//
//      IntStream.range(1,10).parallel().forEach(System.out::print);        // 683295714
//      IntStream.range(1,10).parallel().forEachOrdered(System.out::print); // 123456789
//      * parallel() 은 병렬 스트림으로 처리하는 기능이다. 병렬은 여러 쓰레드가 나눠서 작업하는 것이다.
//      데이터가 많을 때에는 병렬로 처리할 수도 있다.
//      * parallel() 을 해주었을 때 그냥 forEach 문을 쓰면 스트림 요소들의 순서가 없이 무작위로 나온다.
//      * 그래서 parallel() 을 해주었을 때 순서를 지켜서 forEach 문을 쓰고 싶으면 forEachOrdered() 를 이용해야 한다.
//      순서가 필요 없는 경우에는 그냥 forEach 쓰면 된다. 성능은 순서를 신경쓰지 않는 forEach 가 더 빠르다.
//
//
//
//      이번엔 스트림의 요소를 검사하는 데 사용하는 allMatch(), anyMatch(), noneMatch() 에 대해 알아보자.
//      이 메서드들은 매개변수로 Predicate (=람다식 가능) 조건식을 받는다.
//
//      boolean allMatch(Predicate<T> p)       람다식 조건을 요소들이 모두 만족하는지 여부 확인
//      boolean anyMatch(Predicate<T> p)       람다식 조건을 만족하는 요소가 존재하는지 여부 확인
//      boolean noneMatch(Predicate<T> p)      람다식 조건을 요소들이 모두 피하는지 여부 확인
//
//
//
//      이번엔 조건에 일치하는 요소를 찾는 데에 사용하는 findFirst() 와 findAny() 에 대해 알아보자.
//      이 둘은 그냥 사용되는 게 아니고 filter 와 같이 쓰인다.

//      Optional<T> findFirst()     스트림의 가장 첫 요소를 리턴한다. 순차 스트림(직렬)에서 사용한다.
//                                  주로 filter 조건에 맞는 애들 중 첫 번째 꺼롤 뽑을 때 사용한다.

//      Optional<T> findAny()       스트림 요소 중 아무거나 하나 리턴한다. 병렬 스트림에서 사용한다.
//                                  주로 filter 조건에 맞는 것 아무거나 하나 뽑을 때 사용한다.
//
//      사용 예시: (stuStream 과 parallelStream 은 이미 존재한다고 가정)
//      Optional<Student> result = stuStream.filter(s->s.getTotalScore() >= 90).findFirst();
//      Optional<Student> result = parallelStream.filter(s->s.getTotalScore() >= 90).findAny();
//
//
//
//
//      이번엔 reduce() 에 대해 알아보자.
//      reduce() 는 스트림의 요소를 하나씩 줄여가면서 누적연산을 수행한다.
//      매개변수에는 연산식을 입력하는데(보통 람다식으로), 누적으로 연산을 수행하기 때문에 보통 accumulator 라고 부른다.
//
//      아래에 accumulator 들어가는 곳에 연산식(람다식 or 메서드참조)을 적으면 된다.
//      Optional<T> reduce(BinaryOperator<T> accumulator)
//                                    수행할 연산식

//      T reduce(T identity, BinaryOperator<T> accumulator)
//                 초기값              수행할 연산식

//      U reduce(U identity, BiFunction<U,T,U> accumulator, BinaryOperator<U> combiner)
//                 초기값              수행할 연산식              병렬처리 결과를 합치는 연산
//
//
//      초기값과 수행할 연산식 이 두 가지가 핵심이다. combiner 는 일단 신경쓰지 않아도 된다.
//      그리고, 맨 위에는 반환타입이 T 나 U 자체가 아니라 Optional<T> 로 되어 있다.
//      이건 초기값을 입력하지 않았기 때문에, 초기값이 없을 경우를 대비한 것이다.
//
//      사용 예시를 보자.
//      int count = intStream.reduce(0, (a,b) -> a + 1);    // 요소가 몇 개인지 리턴.
//                                                          // count 초기값 0. 요소를 하나 꺼낼 때마다 1씩 더하니까.

//      int sum =   intStream.reduce(0, (a,b) -> a + b));   // 요소들을 모두 합친 값을 리턴
                                                            // sum 초기값 0. 요소를 하나 꺼낼 때마다 더해주니까.
//                                      위 코드는 아래와 같다:
//                                      int a = identity;
//                                      for (int b : stream) {
//                                          a = a + b;
//                                      }
//      reduce 는 결국 까고 보면 반복문에 불과하다. 반복문 밖에 누적 시킬 변수를 미리 준비해놓고,
//      반복문을 통해 그 변수에 대한 연산을 적어주면 되는 것이다.

//      최솟값을 초기값으로 하고 어느 게 더 큰지 확인.
//      int max =   intStream.reduce(Integer.MIN_VALUE, (a,b) -> a > b ? a : b);

//      최댓값을 초기값으로 하고 어느 게 더 작은지 확인
//      int min =   intStream.reduce(Integer.MAX_VALUE, (a,b) -> a < b ? a : b);
//
//

import java.util.*;
import java.util.stream.*;

public class _22_StreamOperator5 {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "superman", "OptionalDouble", "IntStream", "count", "sum"
        };
        System.out.println("-------------직렬------------");
        Stream.of(strArr).forEach(System.out::println);
        System.out.println("-------------병렬------------");
        Stream.of(strArr).parallel().forEach(System.out::println);  // 실행할 때마다 순서 달라짐
        System.out.println("---------병렬(순서유지)--------");
        Stream.of(strArr).parallel().forEachOrdered(System.out::println);  // 순서 유지
        System.out.println("---------------------------");

        // 요소 중에 그 어느 것도 빈 문자열 아닌 거 맞지??
        boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==0);
        System.out.println("noEmptyStr : " + noEmptyStr);   // true 네. 요소 중에 하나라도 빈 문자열인 것 없습니다.


        // 요소 중에 첫 글자가 s 로 시작하는 애들 중 맨 처음 꺼를 Optional 래퍼클래스에 담아서 리턴해줘.
        Optional<String> sWord = Stream.of(strArr)
                .filter(s->s.charAt(0) == 's').findFirst();
        System.out.println("sWord : " + sWord); // Optional[superman] 네. 래퍼클래스에 담아서 드렸습니다.


        // 저 String 배열에 담긴 문자열들에 대해 글자수만 뽑아내서 IntStream 으로 만들어 줘.
        // Stream<String> 해서 객체로 다뤄도 되긴 하는데 기본형 스트림을 쓰는 게 더 성능이 좋아서~
        // 최종연산 하면 어차피 또 만들어야 하니까 그냥 여기서 4개 정도 미리 만들어 줘.
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
        // mapToInt() 메서드를 이용한 모습. 메서드 참조를 람다식으로 바꾸면: (s)->(s.length())


        // 저 String 배열에 담긴 요소가 몇 개인지 reduce() 를 이용해서 출력해줘.
        int count = intStream1.reduce(0, (a,b)->a+1);
        System.out.println("count : " + count);


        // 저 intStream 들의 값을 reduce() 를 이용해서 다 합쳐줘.
        int sum = intStream2.reduce(0, (a,b)->a+b);
        System.out.println("sum : " + sum);


        // 저 intStream 들의 값 중 최댓값과 최솟값을 reduce()를 이용해서 OptionalInt 로 리턴해주고, 출력해줘.
        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);
        System.out.println("max : " + max); // 래퍼클래스에 담아서 줌
        System.out.println("min : " + min); // 래퍼클래스에 담아서 줌
        System.out.println("max : " + max.getAsInt()); // 기본형으로 줌
        System.out.println("min : " + min.getAsInt()); // 기본형으로 줌

    }
}
