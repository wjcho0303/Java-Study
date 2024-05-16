package ch13_Thread;
import javax.swing.JOptionPane;


class ThreadEx5_1 extends Thread {
    public void run() {
        for(int i=10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch(Exception e ) {}
        }
    } // run()
}

public class _06_2_IO_Blocking_Multi {
    public static void main(String[] args) throws Exception  {
        ThreadEx5_1 th1 = new ThreadEx5_1();    // 카운트 다운 작업
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요."); // 입력
        System.out.println("입력하신 값은 " + input + "입니다.");
    }
}

// 멀티 쓰레드에서는 작업이 별도로 이루어진다. 카운트가 돌아가는 동안에 입력 대기상태 및 입출력이 가능하다.
// 이게 바로 멀티 쓰레드의 장점이다.
// 실행을 해놓고 카운트가 끝나도 계속 입력을 하지 말아보자. 그러면 프로그램이 종료되지 않는다.
// 그러다가 뒤늦게라도 입력을 해주면 그제서야 입력하신 값은 ~~ 입니다 라고 뜨면서 프로그램이 종료된다.