package ch08_Exceptions;

// 예외처리와 관련된 클래스들은 클래스니까 당연히 메서드를 갖고 있다.
// 우리가 가져다 쓰면 좋은 메서드들 중에 두 가지만 살펴보도록 하자.
// 1. printStackTrace()    : 예외 발생 당시의 Call Stack 에 있었던 메서드의 정보와 예외 메시지를 화면에 출력해줌
//                           빨간 글씨 오류 메시지가 바로 이거다.
// 2. getMessage()         : 발생한 예외클래스의 인스턴스 안에 저장된 메시지를 return 함

// 메소드를 쓰려면 객체가 필요한데?
// 사실 예외가 발생할 때 그 예외 클래스에 해당하는 예외객체가 자동으로 생성된다.
// 그 객체는 예외 정보를 갖고 있고, 그 정보 중에는 당연히 printStackTrace()나 getMessage() 같은 메서드들도 포함된다.

// catch 문에 적은 그 참조변수에 바로 그 객체의 주소가 대입된다. 그래서 catch문 괄호 안에 적은 그 참조변수 리모콘을 이용하면
// 객체로부터 예외 정보들(필드나 메소드)을 가져올 수 있다. 그리고 그 참조변수의 유효범위는 그 해당 catch문 내부에 국한된다.

public class _03_ExceptionMethods {
    public static void main(String[] args) {
        System.out.println("================ 1번 예시 ================");
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println("try 블록 내용: " + 3);
            System.out.println("try 블록 내용: " + 0/0); // ArithmeticException 발생.
            System.out.println("try 블록 내용: " + 4);   // 실행 X
        } catch (ArithmeticException ae)	{
            ae.printStackTrace();           // 빨간 글씨 오류메시지 출력
            System.out.println("catch 블록 내용: " + "예외메시지 : " + ae.getMessage());
            // 출력내용 : "catch 블록 내용: 예외메시지 : / by zero"
        }
        System.out.println(6);
    }
}

//  참고: catch 블록 { } 안의 내용이 똑같은 경우가 있다.
//  try {
//    // 예외 발생할 가능성 있는 부분들
//  } catch (ExceptionA e) {
//          e.printStackTrace();
//  } catch (ExceptionB e) {
//          e.printStackTrace();
//  }
//
//  위와 같이 되어 있는 경우 아래처럼 예외 클래스를 묶을 수 있다.
//  try {
//    // 예외 발생할 가능성 있는 부분들
//  } catch (ExceptionA | ExceptionB e) {
//      e.printStackTrace();
//  }
//  처리할 내용이 같을 경우, 위와 같이 파이프 기호(|)로 예외를 묶어주고 블록 { } 하나로 처리할 수 있다.
//  이를 멀티 catch 블록이라 한다. 이렇게 하면
//  ExceptionA 가 발생해도 e.printStackTrace(); 이 호출되고,
//  ExceptionB 가 발생해도 e.printStackTrace(); 가 호출된다.

// 멀티 catch 블록 사용 시 유의할 점:
// 1) 두 예외 클래스가 공통으로 갖는 메서드만 써야 한다.
// A 예외 클래스에만 있는 메서드나 B 예외 클래스에만 있는 메서드를 호출하면 에러가 발생한다.

// 2) 조상 - 자손 관계에 있는 예외 클래스들은 멀티 catch 블록으로 사용할 수 없다.
// 사용할 거면 조상 예외 클래스로 선택해서 사용해야 한다.