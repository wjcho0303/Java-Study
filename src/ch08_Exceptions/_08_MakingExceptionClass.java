package ch08_Exceptions;


// 직접 예외 클래스를 만들 때는 extends 할 예외 클래스를 Exception 또는 RuntimeException 둘 중 선택해야 한다.
// 일반적으로 선택적인 처리를 하는 것이 코드를 유연하게 하므로 RuntimeException 을 상속하여 작성한다.

// 만약 Exception 을 extends 하면 try-catch 블록을 반드시 써주어야 컴파일 에러가 발생하지 않는다.
class MyException extends RuntimeException {
    private final int ERRORCODE;

    public int getERRORCODE() {
        return ERRORCODE;
    }

    // [중요] String 매개변수가 있는 생성자는 필수로 갖고 있어야 한다.
    MyException(String exceptionMessage) {
        this(exceptionMessage, 100);
    }

    MyException(String exceptionMessage, int errorCode) {
        super(exceptionMessage);
        ERRORCODE = errorCode;
    }
}

public class _08_MakingExceptionClass {
}
