package ch14_Lambda_Stream;

//
//      파일로 스트림을 만드는 방법과 비어 있는 스트림을 만드는 방법을 알아보자.
//
//      Stream<Path> Files.list(Path path)   // Path 는 파일 또는 디렉토리의 경로를 의미한다.
//
//      이번엔 lines() 에 대해 알아보자.
//      lines() 메서드는 파일의 내용을 라인 단위로 읽어서 Stream<String> 으로 만들어준다.
//      즉, 파일 내용의 한 줄 한 줄이 Stream 의 요소가 되는 것이다.
//
//      사용 방식은 아래와 같다:
//      Stream<String> Files.lines(Path path)
//
//      이 lines 는 로그 파일 분석이나 다량의 텍스트 파일을 처리할 때 유용하다.
//
//
//
//
//
//      다음은 비어 있는 스트림을 생성하는 것에 대해 알아보자.
//      방법은 간단하다. empty() 라는 메서드를 사용하면 된다.
//      Stream emptyStream = Stream.empty();    // empty() 메서드는 비어 있는 스트림을 생성하여 리턴함
//      long count = emptyStream.count();       // 값: 0
//


public class _15_File_Empty_Stream {
}
