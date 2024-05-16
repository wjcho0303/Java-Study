package ch14_Lambda_Stream;
//
//
//      중간연산을 마저 다뤄보겠다.
//      저번 자료에서는 skip, limit, distinct, filter, sorted 에 대해 다루었다.
//
//      이번에는 map, peek, flatMap 에 대해 알아보자.
//      peek 은 forEach 와 비슷한데 중간연산이라는 점에서 다르다.
//      map 과 flatMap 은 스트림을 변환시키는 거고 둘이 서로 비슷하다.
//      flatMap 의 특징을 간단히 말하자면, "스트림의 차원을 줄여준다" 정도가 되겠다.
//      즉, 스트림의 스트림을 스트림으로 바꿔준다.
//
//      먼저, map() 메서드를 살펴보자.
//      Stream<R> map(Function<? super T, ? extends R> mapper)   //   Stream<T> -> Stream<R>
//      map 의 기능을 요약하면 어떤 타입 T 타입의 Stream 을 R 타입의 스트림으로 바꿔주는 것이다.
//
//      Stream<File> fileStream = Stream.of(                // File 객체를 요소로 갖는 스트림 생성
//                                  new File("Ex1.java"),
//                                  new File("Ex1"),
//                                  new File("Ex1.bak"),
//                                  new File("Ex2.java"),
//                                  new File("Ex1.txt")
//                                  )
//      이렇게 만들어진 File 객체를 요소라 갖는 스트림을 String 을 요소로 갖는 스트림으로 바꿀 수 있을까?
//      map 메서드를 이용하면 가능하다. 방법은 아주 간단하다.
//      map 안에 File 이름을 String 으로 반환하는 람다식을 적어주면 끝.

//      Stream<String> fileNameStream = fileStream.map(File::getName);
//      File::getName 부분을 람다식으로 고쳐볼까?
//      (file) -> file.getName();

//      fileNameStream.forEach(System.out::println);    // 스트림의 모든 파일 이름 출력
//
//      그럼 파일 스트림 Stream<File> 에서 대문자로 되어 있는 파일 확장자를 중복없이 뽑아내려면 어떻게 해야 할까?
//      fileStream.map(File::getName)
//          .filter(s->s.indexOf(".")!=-1)              // 확장자가 없는 파일 제외
//          .map(s->s.substring(s.indexOf(".") + 1))    // . 뒤에 있는 글자만 추출(substring) = 확장자명
//          .map(String::toUpperCase)                   // 대소문자 상관 없이 확인(모두 대문자로 통일시키기)
//          .distinct()                                 // 중복제거
//          .forEach(System.out::println);              // 결과: JAVABAKTXT
//


//       이번엔 peek() 에 대해 알아보자. peek() 는 forEach 와 똑같은데 스트림의 요소를 소모하지 않는다는 차이가 있다.
//       그냥 요소를 그냥 잠깐 볼 수 있게 해주는 기능이다. 요소들을 보고 싶은데 forEach 를 써버리면 스트림이 닫히고
//       다시 스트림을 생성해줘야 하기 때문에 번거로운데, 그럴 때 유용하다.
//       사용방식도 forEach 랑 똑같이 그냥 System.out::println 뭐 이런 거 쓰면 된다.

import java.io.*;
import java.util.stream.*;


public class _18_StreamOperators3 {
    public static void main(String[] args) {
        File[] fileArr = {
                new File("Ex1.java"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1"),
                new File("Ex1.txt")
        };

        Stream<File> fileStream = Stream.of(fileArr);

        //★★★★    map()으로 Stream<File>을 Stream<String>으로 변환
//        Stream<String> filenameStream = fileStream.map(File::getName);   // 이건 메서드 참조
      Stream<String> filenameStream = fileStream.map((f)->f.getName());   // 이건 람다식
        // 둘이 번갈아서 주석 풀면 결과 똑같이 나온다.

        filenameStream.forEach(System.out::println); // 모든 파일의 이름을 출력

        System.out.println("--------------------------");
        fileStream = Stream.of(fileArr);  // 최종연산을 했으니 다시 스트림을 생성
        fileStream.map(File::getName)               // Stream<File> → Stream<String>
           .filter(s -> s.indexOf('.') != -1)       // 확장자가 없는 것은 제외. 찾는 값이 없는 경우 -1 을 리턴하기 때문
           .peek(s->System.out.println(s))
           .map(s -> s.substring(s.indexOf('.')))   // "."을 포함하여 확장자만 추출
           .peek(s->System.out.println(s))
           .map(String::toUpperCase)                // 모두 대문자로 변환. 중복을 제거하기 위해 해주는 일이다.
           .distinct()                              //  중복 제거
           .forEach(System.out::println);           // .JAVA.BAK.TXT

        System.out.println();
        // peek 를 잘 활용하면 중간에 스트림이 어떻게 변환이 되었는지 확인할 수 있어서 오류 수정에 유용하다.

    }
}
