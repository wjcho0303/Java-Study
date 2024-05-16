package ch13_Thread;
//
//      이번 장의 앞 글자를 소문자로 적은 이유는, main 이 main 메서드를 의미하기 때문이다.
//      지금까지 우리가 실행시켜온 그 main 맞다.
//
//      main thread 란, main 메서드의 코드를 수행하는 쓰레드이다.
//      예를 들어, 인젤리제이를 예로 들어서 Shift + F10 을 눌러 프로그램을 실행한다고 하자.
//      그렇게 되면 java interpreter 가 public static 에 있는 main 메서드를 호출한다.
//      그러면 쓰레드가 그 main 메서드가 있는 그 Call stack 을 쭈욱 위에서부터 실행하게 된다.
//
//      쓰레드에는 '사용자 쓰레드' 와 '데몬 쓰레드' 이렇게 두 종류가 있다.
//      main thread 는 사용자 쓰레드고, 데몬 쓰레드는 보조 역할을 해주는 쓰레드다.
//      만약 이 사용자 쓰레드가 하나도 없다면 프로그램은 종료된다.
//      보조 쓰레드인 데몬 쓰레드가 실행 중이라 하더라도 사용자 쓰레드가 없으면 프로그램은 그냥 종료하는 것이다.
//
//      항상 우리는 자바 공부를 하면서 싱글 쓰레드만 써왔고, 반복문을 쓰지 않는 이상 메인 메서드가 끝나면
//      프로그램이 종료되는 것을 경험하였다. 그런데 사용자 쓰레드를 여러 개 사용하는 멀티 쓰레드 상황이라면
//      main 메서드가 끝났다고 해도 (메인 쓰레드가 동작하지 않는다고 해도) 다른 사용자 쓰레드가 실행중이면
//      프로그램은 종료되지 않는다는 말이다. run 을 처리하고 있는 쓰레드까지 작업을 다 마쳐야
//      비로소 프로그램이 종료된다.
//



// 가로 짝대기를 찍는 쓰레드
class ThreadEx11_1 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) {        // 300번 찍는다.
            System.out.print(new String("-"));
        }
    } // run()
}

// 세로 짝대기를 찍는 쓰레드
class ThreadEx11_2 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) {        // 300번 찍는다.
            System.out.print(new String("|"));
        }
    } // run()
}


// 가로 짝대기와 세로 짝대기 각각 300번씩 총 600개의 짝대기를 출력하는 run 을 해보자.
public class _03_main_Thread {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx11_1 th1 = new ThreadEx11_1();
        ThreadEx11_2 th2 = new ThreadEx11_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        // join 메서드는 다른 쓰레드가 하는 일을 기다리게 하는 메서드이다.
//        try {
//            th1.join();	// main 쓰레드가 th1의 작업이 끝날 때까지 기다린다.
//            th2.join();	// main 쓰레드가 th2의 작업이 끝날 때까지 기다린다.
//        } catch(InterruptedException e) {}

        // join 메서드 주석을 걸면 소요시간이 0 이라고 뜨고,
        // 주석을 풀면 소요시간이 맨 마지막에 뜨고 10 ~ 14 정도가 뜬다.
        // join 메서드를 사용하면 th1 과 th 2 쓰레드의 작업을 우선순위로 올리기 때문이다.

        System.out.print("소요시간:" + (System.currentTimeMillis() - _03_main_Thread.startTime));
    }
}
// 메인 메서드가 하는 일이 바로 소요시간을 출력하는 일인데, 이게 먼저 나오냐 나중에 나오냐를 통해
// join() 메서드가 어떤 일을 하는지 알 수 있다.

// 소요시간이 뜬다는 말은 main 메서드의 마지막 줄에 쓰인 명령이 실행되었고, 메인 메서드의 할 일이 종료되었다는 뜻인데,
// 소요시간이 뜬 이후에 계속 짝대기들 ||||| ------ 이런 애들이 나온다는 것은 아직 프로그램이 종료되지 않았다는 뜻이다.
// 이렇게 사용자 쓰레드가 남아 있으면 메인 쓰레드가 작업을 다 마쳐도 프로그램이 마저 동작한다.