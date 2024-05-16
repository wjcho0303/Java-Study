package ch08_Exceptions;

// 예외 발생시키는 방법은 예외 클래스의 인스턴스 앞에 'throw' 키워드를 사용하는 것이다.
// 흔히 다음과 같이 예외가 발생한다 : throw new Exception();

public class _04_Throw {
    public static void main(String[] args) {
        try {
            Exception e = new Exception("Exception message String");
            System.out.println(e.getMessage());
            throw e;    // 이 throw 문으로 인해 catch 블록이 실행된다.
        } catch (Exception exception) {
            System.out.println("catch 블록 내용: " + exception.getMessage());
            exception.printStackTrace();
        }
        System.out.println("프로그램 정상 종료");
    }
}