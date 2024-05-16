package ch14_Lambda_Stream;
//
//
//      이번엔 배열의 스트림의 메서드를 살펴보자. 왼쪽에 적은 건 반환타입이라는 걸 기억하자.
//      참고로, of() 메서드는 가변인자이기 때문에 매개변수의 수가 정해져 있지 않다.

//      Stream<T>    Stream.of(T... values)    입력한 value 들을 stream 으로 생성. 매개변수에 요소들을 직접 입력
//
//      Stream<T>    Stream.of(T[])            입력한 배열 stream 생성
//
//      Stream<T>    Arrays.stream(T[])        입력한 배열 stream 생성
//
//      Stream<T>    Arrays.stream(T[] array, int num1, int num2)
//                                             입력한 배열 array 중 입력한 index 범위로 stream 생성
//

//      위의 예시는 기본형 배열이 아닌 객체 배열의 경우이다. 예시를 보자:
//      Stream<String> strStream = Stream.of("a","b","c");
//
//      Stream<String> strStream = Stream.of(new String[]{"a","b","c"});
//
//      Stream<String> strStream = Arrays.stream(new String[]{"a","b","c"})
//
//      Stream<String> strStream = Arrays.stream(new String[]{"a","b","c"}, 0, 2);  // 0, 1 만 들어감
//
//
//
//
//      이번엔 기본형 배열로 스트림을 생성하는 경우를 살펴보자. int 를 예로 들어보자.
//      IntStream IntStream.of(int... values)       of 메서드의 파라미터로 요소를 직접 입력 (가변인자)
//
//      IntStream IntStream.of(int[])               입력한 int 배열의 스트림 생성
//
//      IntStream Arrays.stream(int[])              입력한 int 배열의 스트림 생성
//
//      IntStream Arrays.stream(int[] array, int num1, int num2)
//                                                  입력한 int 배열 중 num1 <= x < num2 index 범위 요소로 스트림 생성
//

import java.util.*;
import java.util.stream.*;


public class _14_CreatingStream {
    public static void main(String[] args) {
        Stream<String> strStream = Stream.of("a","b","c");
        strStream.forEach(System.out::println);

        Stream<String> strStream2 = Stream.of(new String[] {"a","b","c","d"});
        strStream2.forEach(System.out::println);

        String[] strArr = new String[] {"e","f","g","h"};
        Stream<String> strStream3 = Stream.of(strArr);
        strStream3.forEach(System.out::println);

        Stream<String> strStream4 = Arrays.stream(strArr, 2, 4);
        strStream4.forEach(System.out::print);
        System.out.println("");
        // 사실상 Stream.of 를 쓰나 Arrays.stream 을 쓰나 차이가 없어서... 그냥
        // 회사에서 어떻게 쓰는가에 따라 다르다...
        // 단, 부분적인 index 범위만 골라서 스트림을 생성하려면 Arrays.stream 으로 해야 한다.


        Integer[] integerArr = {new Integer(10), new Integer(20), new Integer(30)};
        Stream<Integer> integerStream = Arrays.stream(integerArr);
        integerStream.forEach(System.out::println);
        // 이런 식으로 정수 배열의 스트림을 만들 수도 있지만 권장되지 않는다. 기능이 별로 없기 때문이다.

        int[] intArr = new int[]{1,2,3,4,5,6,7};
        IntStream intStream = Arrays.stream(intArr);
        intStream.forEach(System.out::print);
        System.out.println("");
        // 이 방식으로 정수 배열 스트림을 만드는 것을 추천한다.
        // IntStream, DoubleStream 등의 기본형 스트림은 처음부터 수를 다루도록 제공되는 스트림이기 때문에
        // 수와 관련된 기능들이 몇 가지 제공된다.
        intStream = Arrays.stream(intArr);
        System.out.println("intStream.count() = " + intStream.count());

        intStream = Arrays.stream(intArr);
        System.out.println("intStream.sum() = " + intStream.sum());

        intStream = Arrays.stream(intArr);
        System.out.println("intStream.average() = " + intStream.average());

        intStream = Arrays.stream(intArr);
        System.out.println("intStream.max() = " + intStream.max());

        intStream = Arrays.stream(intArr);
        System.out.println("intStream.min() = " + intStream.min());



        // 난수 스트림 만드는 방법: ints() , longs() , doubles() 메서드 활용하기
        // ints(), longs(), doubles() 는 무한 스트림을 생성한다. 그래서 이 메서드를 쓰면
        // limit() 을 통해 잘라줘야 한다. 안 그러면 끝도 없이 계속 나온다...

        IntStream ranIntStream = new Random().ints();
        ranIntStream
                .limit(5)
                .forEach(System.out::println);

        DoubleStream ranDoubleStream = new Random().doubles();
        ranDoubleStream
                .limit(5)
                .forEach(System.out::println);

        LongStream ranLongStream = new Random().longs();
        ranLongStream
                .limit(5)
                .forEach(System.out::println);

        // 위에 사용한 난수는 범위를 제한하지 않아서 숫자들이 들쑥날쑥하다.
        // 난수의 범위를 지정해주려면 아래의 메서드를 사용하면 된다. 범위는 num1 <= x < num2
        //          ints(int num1, int num2)
        //          longs(long num1, long num2)
        //          doubles(double num1, double num2)
        //          이렇게 범위만 주면 "무한스트림"


        //          ints(long streamSize, int num1, int num2)
        //          longs(long streamSize, long num1, long num2)
        //          doubles(long streamSize, double num1, double num2)
        //          이렇게 streamSize 값을 맨 앞에 줘서 총 3개의 매개변수를 적으면 "유한스트림"
        //          streamSize 값을 주면 limit() 을 해줄 필요가 없어진다.


        ranIntStream = new Random().ints(5, 0, 11);
        ranIntStream
//                .limit(5)
                .forEach(System.out::println);

        ranDoubleStream = new Random().doubles(5, 0, 5);
        ranDoubleStream
//                .limit(5)
                .forEach(System.out::println);

        ranLongStream = new Random().longs(5, 1000000, 30000000);
        ranLongStream
//                .limit(5)
                .forEach(System.out::println);





        // 람다식을 통해 스트림을 만들 수도 있다. iterate() 와 generate() 메서드를 이용한다.
        // iterate() 는 이전 요소를 초기값(seed)으로 하여 다음 요소를 계산한다. 요소가 독립적이지 않다.
        Stream<Integer> evenStream = Stream.iterate(2, n->n+2);
        evenStream
                .limit(9)
                .forEach(System.out::println);
        // iterate(T 초기값, UnaryOperator 람다식)




        // generate() 는 seed 를 사용하지 않는다. 이전 결과와 관련 없고 각 요소가 서로 독립적이다.
        Stream<Double> ranDoubleStream2 = Stream.generate(Math::random);
        Stream<Integer> oneStream = Stream.generate(()->1);

        ranDoubleStream2
                .limit(5)
                .forEach(System.out::print);

        System.out.println("");

        oneStream
                .limit(20)
                .forEach(System.out::print);
        // generate() 는 이렇게 입력은 없고 출력만 있는 경우이다. 입력이 없으니 seed 도 없을 수밖에 없다.

    }
}
