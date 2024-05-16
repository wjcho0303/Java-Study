package ch08_Exceptions;

import java.io.*;
// ** 유의사항 : 실행 후 프로젝트 최상위 디렉토리에 .txt 파일이 생성될 수 있으므로 확인하여 삭제할 것



// 예외를 처리하는 것은 try-catch 문 말고 다른 방법도 있다.
// 메서드 호출 시 발생 가능한 예외를 호출한 쪽에 알리는 것이다.
// 다음과 같은 문법으로 이것이 실현된다:
class TestClass {
    void method1() throws RuntimeException {
        int x = 10;
        int y = 0;
        int z = x/y;
        System.out.println(z);
        System.out.println("hello");
    }
    // 예외 처리를 하지 않으므로 예외 발생 시 호출한 쪽으로 떠넘기게 된다.

    void method2() throws RuntimeException {
        int x = 10;
        int y = 0;
        try {
            int z = x/y;
            System.out.println(z);
        } catch (RuntimeException re) {
            System.out.println("예외가 발생하였습니다. 코드를 확인하세요. 에러 메세지 : " + re.getMessage());
        }
        System.out.println("hello");
    }
    // 자체적으로 예외 처리를 하고 있다.
}

// 이와 같이, 발생할 것으로 예상되는 예외 클래스를 메서드 구현부 { } 작성 전에 throws 를 통해 적어준다.
// throw 는 곧바로 예외를 발생시키는 것이고, throws 는 던져질 가능성이 있다는 의미이다.

public class _07_ThrowWithMethod {
    public static void main(String[] args) throws Exception {
        TestClass testClass = new TestClass();
        try {
            testClass.method1();
        } catch (RuntimeException re) {
            System.out.println("예외가 발생하였습니다. 코드를 확인하세요. 에러 메세지 : " + re.getMessage());
        }
        // 떠넘겨진 예외를 처리해주는 모습.


        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        testClass.method2();
        // method2 에서 자체적으로 예외처리를 했기 때문에 호출한 쪽에서 예외 처리를 하지 않아도 된다.


        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        try {
            File f = createFile("");    // 여기에 파일명을 String 타입으로 적는다.
        } catch (Exception e) {
            System.out.println(e.getMessage() + " 다시 입력해주시기 바랍니다.");
        }
        // 떠넘겨진 예외를 처리해주는 모습.

        File f2 = createFile2("");

        System.out.println("프로그램 정상 종료");
    }

    static File createFile(String fileName) throws Exception {
        if (fileName == null || fileName.equals("")) {
            throw new Exception("파일 이름이 유효하지 않습니다.");
        }
        File f = new File(fileName);
        f.createNewFile();
        System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
        return f;
    }
    // 예외 처리를 하지 않으므로 예외 발생 시 호출한 쪽으로 떠넘기게 된다.

    static File createFile2(String fileName) throws Exception {
        try{
            if (fileName == null || fileName.equals("")) {
                throw new Exception("파일 이름이 유효하지 않습니다.");
            }
        } catch (Exception e) {
            fileName = "제목없음";
            // 실행 후 최상위 디렉토리에 "제목없음" 파일 생성되는 것 확인 후 삭제할 것
        }

        File f = new File(fileName);
        f.createNewFile();
        System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
        return f;
    }
    // 예외 처리를 직접 처리하여 예외가 발생해도 프로그램이 중단되지 않는다.
}

// 참고:
// 예외 처리를 쪼개서 할 수도 있다. catch 블록에 예외에 대한 처리를 일부만 하고,
// throw 문을 작성하여 호출한 곳에 예외를 보내 나머지 예외 처리는 호출한 곳에서 처리하는 방식이다.
// 이를 예외 되던지기(exception re-throwing)이라고 한다.
// 이는 호출한 곳에서도 부분적으로 예외를 처리해야 할 일이 있을 때 하는 방법이다.