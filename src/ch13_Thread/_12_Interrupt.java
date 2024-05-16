package ch13_Thread;
import javax.swing.JOptionPane;
//
//      interrupt() 메서드는 WAITING 상태(일시정지)인 쓰레드를 RUNNABLE 상태(실행대기 또는 실행중)로 만든다.
//                                interrupt: "뭐 해 그만 꾸물대고 빨리 작업해!!"

//      Thread 클래스 안에는 interrupted 라는 boolean 자료형의 멤버변수가 있다. 초기값은 false 이다.
//      해석하면 "쉬지 못하게 했는가" 를 보여주는 boolean 값이라 이해하면 된다.

//      interrupted 가 true  이면 RUNNABLE 상태이고,   (쉬지 못하게 함: true   --> 안 쉬고 있으니 RUNNABLE)
//      interrupted 가 false 이면 WAITING 상태이다.    (쉬지 못하게 함: false  --> 쉬고 있으니 WAITING)
//
//
//      interrupted 상태와 관련한 메서드들은 다음과 같다:
//      void interrupt()                쓰레드의 interrupted 상태를 false 에서 true 로 변경
//
//      boolean isInterrupted()         쓰레드의 현재 interrupted 상태를 리턴
//
//      static boolean interrupted()    쓰레드의 현재 interrupted 상태를 리턴하고, false 로 초기화한다.
//                                      static 메서드이기 때문에 반드시 Thread.interrupted() 이렇게 써야 한다.
//
//      이러한 interrupted 는 진행 중이던 작업을 취소시킬 때 자주 사용된다.
//
//      class Download extends Thread {
//          public void run() {
//              ...
//              while (isDownloaded && !isInterrupted()) {
//                  다운로드를 진행시키는 코드들
//              }
//              System.out.println("다운로드 작업 종료");
//          }
//      }

//      위에서 !isInterrupted() 를 주목하라. interrupt() 를 호출하면 interrupted 상태가 true 가 되는데,
//      앞에 ! 가 붙었으므로 !true 는 false 가 되어 while 조건문의 결과가 false 가 되고, 반복문을 탈출하게 되면서
//      다운로드 작업이 종료된다.
//      취소 버튼을 클릭했을 때 interrupt() 메서드를 호출시키도록 코드를 짜놓고는 한다.
//
class ThreadEx9_1 extends Thread {
    public void run() {
        int i = 10;

        while(i!=0 && !isInterrupted()) {   // 이렇게 AND 조건문을 통해 interrupted 의 boolean 값과 엮이게 함.
            System.out.println(i--);
            for(long x=0;x<2500000000L;x++); // 시간 지연
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}

public class _12_Interrupt {
    public static void main(String[] args) throws Exception {
        ThreadEx9_1 th1 = new ThreadEx9_1();

        // th1 Thread 가 하는 일: 카운트 10초 세기
        // th1 쓰레드를 RUNNABLE 로 바꾸어 활성화
        th1.start();

        // th1 카운트가 진행되는 동안 입력하라는 창이 뜬다.
        // 입력을 하지 않으면 그 동안 카운트는 계속 진행된다.
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");

        // 입력을 완료하면 내용을 출력하고 th1 쓰레드에 inturrupt() 를 하여 반복문을 탈출시켜 카운트를 중단시킨다.
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt();

        // interrupt()를 호출하면, interrupted 상태가 true 가 된다.
        System.out.println("isInterrupted():"+ th1.isInterrupted()); // true

        // 오락실 게임에서도 사용된다. 게임에서 실패했을 때 Continue? 물으면서 카운트 셀 때.
        // 남아 있는 코인 count 를 사용하겠다고 하면 다시 while 문을 true 로 바꾸고 재작업에 들어간다.
    }
}
