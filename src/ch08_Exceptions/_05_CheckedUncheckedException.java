package ch08_Exceptions;

// checked Exception : 컴파일러가 예외 처리 여부를 체크함. Exception 의 자손들
// unchecked Exception : 컴파일러가 예외 처리 여부를 체크하기 않음. RuntimeException 의 자손들

public class _05_CheckedUncheckedException {
    public static void main(String[] args) {
//      throw new Exception();
        // 컴파일 에러 발생. checked Exception 의 특징이다.

        throw new RuntimeException();
        // 컴파일 에러 발생하지 않음. unchecked Exception 의 특징이다.
        // 대신 이 예외는 실행을 하면 예외 메시지가 뜬다.
    }
}
