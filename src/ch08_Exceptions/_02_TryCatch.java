package ch08_Exceptions;

// 프로그래머가 예외 처리(exception handling)하는 방식은 보통 try - catch 문을 통해 진행된다.
// 예외 처리는 예외가 발생했을 상황임에도 불구하고 프로그램이 멈추지 않고 그냥 Run 하게 해주는 방식으로 진행한다.

// 기본 문법은 아래와 같다:

//    try {
//        예외가 발생할 가능성이 있는 문장들
//    } catch (Exception1 e1) {
//        if (e1 instanceof Exception1)  <--- 필수는 아니지만 하면 좋다.
//        Exception1이 발생했을 경우 수행할 문장들
//    } catch (Exception2 e2) {
//        if (e2 instanceof Exception2)  <--- 필수는 아니지만 하면 좋다.
//        Exception2이 발생했을 경우 수행할 문장들
//    } catch (ExceptionN eN) {
//        if (eN instanceof ExceptionN)  <--- 필수는 아니지만 하면 좋다.
//        ExceptionN이 발생했을 경우 수행할 문장들
//    }

//  위와 같이, 하나의 try 에 대해 catch 블록 { }이 여러 개 올 수 있다. 발생할 수 있는 예외가 여러 개일 수 있기 때문이다.
//  try - catch 문에 적어놓은 Exception 들 중 하나가 발생했고, 그것에 해당하는 catch 문의 블록에 있는 것을 실행하면
//  다른 catch 블록 { }들을 무시하고 빠져나온다. 즉, 여러 개의 catch 블록이 있어도 그 중에 발생한 예외 한 개만 실행된다.
//  catch 블록은 if 문과는 달리 문장이 한 줄이어도 { } 괄호를 생략할 수 없다.


public class _02_TryCatch {
    public static void main(String[] args) {
        System.out.println("================ 1번 예시 ================");
        System.out.println(1);
        try {
            System.out.println("try 블록 내용: " + 2);
            System.out.println("try 블록 내용: " + 3);
        } catch (Exception e)    {
            System.out.println("catch 블록 내용: " + 4);
        } // try-catch 의 끝
        System.out.println(5);
        // 출력결과: 1 2 3 5
        // exception 이 발생하지 않아 catch { } 을 실행하지 않고 온전히 try 부분을 모두 실행한다.


        System.out.println("================ 2번 예시 ================");

        System.out.println(1);
        try {
            System.out.println("try 블록 내용: " + 0/0);
            System.out.println("try 블록 내용: " + 2); 	// 실행되지 않는다.
        } catch (ArithmeticException ae)	{
            System.out.println("catch 블록 내용: " + 3);
        }
        System.out.println(4);
        // 출력결과: 1 3 4
        // try 블록에서 ArithmeticException 이 발생하여 catch 가 실행된다.
        // 4가 출력될 수 있었던 이유는 실행할 문장을 catch 블록으로 대체시키고 프로그램을 종료시키지 않은 덕분이다.
        // catch 에서 어떤 예외 클래스를 입력해야 할지 알아내는 것은 프로그램을 테스트 하면서 확인한다.


        System.out.println("================ 3번 예시 ================");

        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println("try 블록 내용: " + 3);   // 예외가 발생하기 전 부분은 실행된다.
            System.out.println("try 블록 내용: " + 0/0); // 예외 발생. 실행 X
            System.out.println("try 블록 내용: " + 4); 	// 예외가 발생한 아래 코드도 실행 X
        } catch (ArithmeticException ae)	{
            if (ae instanceof ArithmeticException)  // --> 예외처리 클래스 해당여부를 확인하기 위해 instanceof 사용
                                                    // --> 정말 이 예외가 맞는지 확실하게 검증하기 위해서 쓴다.
                System.out.println("catch 블록 내용: " + "true");
            System.out.println("catch 블록 내용: " + "ArithmeticException 발생. 0으로 나눌 수 없음.");
        } catch (Exception e){
            // ArithmeticException 이 아닌 다른 Exception 일 경우에 처리
            // 이와 같이, Exception 을 잡아주는 catch 블록은 모든 catch 블록의 맨 마지막에 적는다.
            // 왜냐하면 컴파일러가 위에서부터 코드를 확인하기 때문이다.
            // 만약 해당되는 자손 예외 클래스에 캐치되지 않는 경우 실행이 안 되기 때문에 Exception 의 최고 조상인
            // Exception e 는 거의 항상 추가시킨다고 보면 된다.
            System.out.println("catch 블록 내용: " + "알 수 없는 오류입니다.");
        }
        System.out.println(6);


        System.out.println("================ 4번 예시 ================");
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println("try 블록 내용: " + 3);   // 예외가 발생하기 전에는 실행된다.
            System.out.println("try 블록 내용: " + args[0]); // ArrayIndexOutBoundsException 예외 발생. 실행 X
            System.out.println("try 블록 내용: " + 4); 	// 예외가 발생한 아래 코드도 실행 X
        } catch (ArithmeticException ae)	{   // ---> ArrayIndexOutBounds 에 대한 예외처리가 아니다.
            if (ae instanceof ArithmeticException)  //
                System.out.println("catch 블록 내용: " + "true");
            System.out.println("catch 블록 내용: " + "ArithmeticException");
        } catch (Exception e){
            System.out.println("catch 블록 내용: " + "알 수 없는 오류입니다.");
        }
        System.out.println(6);


        System.out.println("================ 5번 예시 ================");
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println("try 블록 내용: " + 3);   // 예외가 발생하기 전에는 실행된다.
            System.out.println("try 블록 내용: " + args[0]); // ArrayIndexOutBoundsException 발생. 실행 X
            System.out.println("try 블록 내용: " + 4); 	// 예외가 발생한 아래 코드도 실행 X
        } catch (ArithmeticException ae)	{   // ---> ArrayIndexOutBounds 에 대한 예외처리가 아니다.
            if (ae instanceof ArithmeticException)  //
                System.out.println("catch 블록 내용: " + "true");
            System.out.println("catch 블록 내용: " + "ArithmeticException");
        }       // ---> catch (Exception e) 클래스를 작성하지 않았다.
        System.out.println(6);
        // 출력결과: 1 2 3 + ArrayIndexOutBounds 에러메시지
        // 이와 같이 Exception 클래스를 마지막에 적어주지 않으면 에러메시지가 발생하고 에러 발생 시점부터
        // 프로그램이 중단되어 밑에 있는 6이 출력되지 않고 프로그램이 종료된다.
    }
}

