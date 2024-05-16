package ch08_Exceptions;


// 한 예외가 다른 예외를 발생시킬 수 있다.
// 예외 A가 예외 B를 발생시키면 A는 B 예외의 원인이다. 이럴 경우 예외 A를 Cause Exception (원인 예외)이라고 표현한다.
// 그리고 이렇게 서로 예외 발생이 연결되는 예외들을 Chained Exception (연결된 예외)이라 부른다.


// 아래의 예시를 보자.

//  void install() throws InstallException {
//      try {
//          startInstall();
//          copyFiles();
//      } catch (SpaceException e) {
//          InstallException ie = new InstallException("설치 중 예외 발생");
//          ie.initCause(e);
//          throw ie;
//      } catch (MemoryException me) {
//          ...
//      }
//      ...
//  }
// 예시에서 catch 는 SpaceException 로 했는데 throws 는 InstallException 로 되어 있다.
// 이는 실제로 catch 문의 마지막에 throw ie; 라인 때문이다.
// 그리고 ie.initCause(e); 이 부분에서 initCause() 메서드는 원인 예외로 등록하는 메서드로,
// 이 메서드를 통해 SpaceException 과 InstallException 이 연결된 예외가 된다.
// 그리고 SpaceException 이 발생했을 때 콘솔 창에
// InstallException: 설치 중 예외 발생
// Caused by: SpaceException: 설치할 공간이 부족합니다.
// 이런 식으로 출력된다. 즉, Caused by 부분이 콘솔 창에 추가된다.



// 연결된 예외를 사용하는 이유는 무엇인가?
//
// 1) 여러 예외를 하나로 묶어서 다루기 위해
//    위의 InstallException 처럼, 넓은 범위의 Exception 클래스로 묶어주면 여러 공통적인 특징을 가지는 예외들을
//    하나의 예외로 묶어서 처리할 수 있다.
//    다만, install() 메서드 구현부에 나와 있는 것처럼 catch 블록 안에 initCause() 메서드 처리를 해줘야 하기 때문에
//    메서드 구현부가 복잡해지긴 한다.
//
// 2) checked Exception 을 unchecked Exception 으로 변경하기 위해
//    checked Exception 이 발생할 가능성이 있는 경우 throws 를 통해 필수적으로 예외 선언을 해주어야 한다.
//    그러나 unchecked Exception 이 발생할 가능성이 있는 경우 굳이 throws 를 통해 예외 선언을 필수로 하지는 않는다.
//    SpaceException 은 Exception 을 extends 했다고 하자. 그리고 RuntimeException 의 자손은 아니다.
//    그러면 throws 를 필수적으로 해주어야 한다.
//    그런데 SpaceException 을 RuntimeException 으로 바꿀 수 있을까?
//    throw new RuntimeException(new SpaceException("설치할 공간이 부족합니다."));
//    이렇게 throw 할 때 RuntimeException 으로 감싸면 throws 부분에서 예외 선언을 없앨 수 있다.
//    이런 식으로 생성자의 매개변수로 예외를 넣어주는 것도 원인 예외로 등록하는 것이다.
//    여기선 SpaceException 이 RuntimeException 의 원인 예외가 된 것이고, 둘이 서로 연결된 예외가 된 것이다.
//

public class _09_ChainedException {
    public static void main(String[] args) {

    }
}
