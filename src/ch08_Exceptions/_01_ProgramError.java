package ch08_Exceptions;

// 프로그램 오류의 종류로는 크게 두 가지로 구분할 수 있다.
// 1. Compile-time Error :  컴파일 할 때 발생하는 에러. javac.exe 라는 컴파일러 프로그램이 체크해준다.
// 보통 코드를 작성하다가 IDE 에서 빨간색으로 밑줄을 그어준다. 컴파일 에러가 발생하면 실행 자체가 안 된다.

// 컴파일러가 하는 일은 다음과 같다: (1) 구문체크  (2) 번역  (3) 최적화  (4) 계산기  (5) 생략된 코드 추가

// 2. Runtime Error : 컴파일 할 때는 조용하다가 실행하면 발생하는 에러.
// 컴파일 할 때 문제가 발생하지 않았다고 해서 문제가 없는 게 아니다.
// 컴파일러는 기본적인 체크만 해주는 것이기 때문에 런타임 에러가 발생하면 Run 이 종료되고 에러 메시지가 출력된다.

// 3. Logical Error : 에러가 발생하지 않지만 개발자가 원하지 않는 방식으로 동작하는 경우

public class _01_ProgramError {
    public static void main(String[] args) {
//      system.out.println(args[0]);      <-- System 인데 system 으로 오타. 컴파일 에러가 발생한다.
        System.out.println(args[0]);
//      만약 위의 메시지를 System 으로 고치고 실행한다면? 그래도 에러가 발생한다.
//      이렇게 빨간 줄이 없다가 Run 을 했을 때 발생하는 에러를 runtime error 라고 한다.
//      런타임 에러는 문법적으로는 이상이 없지만 JVM 이 코드를 실행하면서 문제가 발생하기 때문에 뒤늦게 발생한다.
    }
}

//  자바의 Runtime Error 는 두 가지로 나뉜다.
//  1. Error : 프로그램 코드에 의해서 "수습될 수 없는 심각한" 오류.
//  ex) OutOfMemoryError. 줄여서 'OOM' 이라고도 한다. 메모리 부족으로 인해 발생하는 에러.

//  2. Exception : 프로그램 코드에 의해서 "수습될 수 있는 다소 미약한" 오류.
//  "예외 처리"를 하는 이유는 가능하면 프로그램이 죽지않고 실행상태를 유지할 수 있게 하기 위함이다.
//  그렇게 하기 위해서는 예외가 발생할 것이라는 예상을 미리 해야 한다.

//  예외 처리를 할 때 예외 클래스를 별도로 프로그래머가 만들어서 사용하기도 하지만,
//  자바에서 기본적으로 제공하는 예외 클래스들에 대해서도 알아야 한다.
//  Throwable 이라는 클래스가 있다. 이 클래스로부터 Exception 클래스와 Error 클래스라는 자손이 생긴다.
//  이 중 Exception 클래스는 또 여러 가지 자손 예외 클래스로 갈라진다.
//  예를 들면 IOException, ClassNotFoundException, RuntimeException 등이 있다.

//  대부분의 Exception 클래스 자손 클래스들은 클라이언트들이 행하는 실수와 같은 외적인 요인에 의해 발생하는 예외이다.
//  그런데 RuntimeException 클래스는 이례적으로 프로그래머의 실수로 발생하는 예외이다.
//  RuntimeException 을 예로 들면,
//    ArithmeticException - 산술계산과 관련. 0으로 나눌 때 등
//    ClassCastException - 형변환과 관련
//    NullPointerException - 객체 주소가 가리키는 값이 null 일 때
//    IndexOutOfBoundsException - 배열의 길이를 벗어났을 때
//  등등

