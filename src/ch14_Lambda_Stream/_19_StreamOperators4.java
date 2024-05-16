package ch14_Lambda_Stream;
//
//
//      flatMap() 에 대해 알아보자.
//      flatMap() 은 스트림의 스트림을 스트림으로 변환할 때 사용한다.
//      이 말이 무슨 뜻인지 한 번 살펴보도록 하자.
//
//      Stream<String[]> strArrStream = Stream.of(
//                                          new String[]{"abc","def","ghi"},
//                                          new String[]{"ABC","GHI","JKLMN"}
//                                          );
//
//      예를 들어 위와 같이 스트림의 요소로 기본형 타입의 자료나, 평범한 객체가 아니라 배열이 들어왔다고 하자.
//      일단 이건 배열의 스트림이지, 스트림의 스트림은 아니다.

//      아무튼 난 지금 저 String 배열에 있는 요소들을 다 꺼내서 그냥 Stream<String> 으로 만들고 싶다.
//      한 번 map 메서드를 써볼까? map 으로 변환하면 아래처럼 된다.
//      Stream<Stream<String>> strArrStreamStream = strArrStream.map(Arrays::stream);
//      map() 는 배열을 스트림으로 바꿔주는 기능이지, 배열 내용을 꺼내주는 게 아니다.
//      그래서 그냥 스트림의 스트림이 되어버린다.
//
//      내가 원했던 건 이게 아니다. 나는 String[] 에 있는 것들을 그냥 다 꺼내서 Stream 에 집어 넣고 싶었다.
//      이럴 때 사용하는 게 flatMap() 이다.
//
//      Stream<String> strStream = strArrStream.flatMap(Arrays::stream);    // Arrays.stream(T[])
//
//
//

import java.util.*;
import java.util.stream.*;


public class _19_StreamOperators4 {
    public static void main(String[] args) {
        Stream<String[]> strArrStrm = Stream.of(        // String[] 을 요소로 가진 스트림
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "GHI", "JKL"}
        );

//		Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
        // flatMap(Arrays::stream) 을 이용하여 배열 껍데기를 제거하고 내용물로 스트림을 채움

        strStrm.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);  // 모두 소문자로 만든 후 중복을 제거한 후 정렬한 후 출력
        System.out.println();

        String[] lineArr = {        // 이렇게 String 배열의 하나의 요소가 문장인 경우에 flatMap 이 유용하게 사용된다.
                "Believe or not It is true",
                "Do or do not There is no try",
        };

        // 이제 저 문장에 있는 단어들 하나 하나를 띄어쓰기를 구분자로 하여 스트림의 요소로 넣고 싶다면?
        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))
                // 일단, flatMap 으로 다 꺼내는데, split 메서드와 정규식을 이용하여 띄어쓰기를 구분자로 하고 쪼갰다.
                // 참고로, split 은 입력한 구분자를 기준으로 String 을 쪼개주고,
                // 저 정규식은 split 의 구분자를 입력해준 것인데, "하나 이상의 공백" 을 표현하고 있다.
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();
    }
}
