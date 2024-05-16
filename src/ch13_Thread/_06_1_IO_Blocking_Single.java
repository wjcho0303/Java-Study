package ch13_Thread;
import javax.swing.JOptionPane;

//
//      I/O 는 input 과 output 통틀어서 말하는 것이다.
//      그럼 I/O blocking 은 입출력을 막는 것인가? 맞다.
//      I/O blocking 은 "입출력 시 작업을 중단하는 것"을 의미한다.
//
//      어떤 경우에 I/O blocking 이 일어날까?
//      예를 들어 실행되다가 사용자로부터 값을 입력받아야 다음 단계로 넘어갈 수 있는 그런 코드를 만났다고 하자.
//      사용자가 값을 입력해야 다음 코드가 쭉 실행되는 그런 상황이다.
//      이때 만약 사용자가 입력을 하지 않으면? 프로그램은 사용자의 입력을 여전히 대기하게 될 것이다.
//      이렇게 사용자로부터 입력을 기다리는 동안 프로그램이 아무 일도 하지 않는 것이 I/O blocking 이다.
//
//      싱글 쓰레드에서 I/O blocking 상태라면 어떻게 될까? 프로그램이 멈춰 있게 된다.
//      근데 만약 멀티 스레드라면 하나의 쓰레드가 I/O blocking 상태라고하더라도 다른 쓰레드는 여전히
//      독립적으로 작업을 수행하여 프로그램이 정지 상태에 머무르지 않게 할 수 있다.
//
//

public class _06_1_IO_Blocking_Single {
    public static void main(String[] args) throws Exception {
                        // 싱글 쓰레드인 상황
        // 작업 A : 입력
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");

        // 작업 B : 카운트 다운
        for(int i=10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);  // 1초간 시간을 지연한다.
            } catch(Exception e ) {}
        }
    }
}
