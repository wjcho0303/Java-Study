package ch13_Thread;
//
//      join() 메서드가 하는 일은 "다른 스레드의 작업을 기다려라"이다.
//
//      void join()                                 다른 모든 쓰레드의 작업이 끝날 때까지 기다려준다.
//      void join(Long millis)                      다른 모든 쓰레드를 입력한 시간 동안만 기다려준다.
//      void join(LLong millis, int nanos)          다른 모든 쓰레드를 입력한 시간 동안만 기다려준다.
//
//
//      사용 패턴은 sleep 처럼 interrupted 멤버변수와 연동되는 메서드기 때문에 try-catch 문을 써야 한다.
//      try {
//          th1.join();
//          th2.join();
//      } catch(InterruptException e) { }
//
//
class ThreadEx13_1 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    } // run()
}

class ThreadEx13_2 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    } // run()
}

public class _14_Join {
    static long startTime = 0;

    public static void main(String args[]) {
        ThreadEx13_1 th1 = new ThreadEx13_1();
        ThreadEx13_2 th2 = new ThreadEx13_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

//        try {
//            th1.join();	// main 쓰레드가 th1의 작업이 끝날 때까지 기다린다.
//            th2.join();	// main 쓰레드가 th2의 작업이 끝날 때까지 기다린다.
//        } catch(InterruptedException e) {}

        System.out.print("\n" + "소요시간:" + (System.currentTimeMillis() - _14_Join.startTime));
    } // main
}
// join 을 그대로 두고 실행하면 소요시간이 맨 마지막에 뜨고, join 에 주석처리를 하면 소요시간 0 이 뜬다.
// join 을 할 때 맨 소요시간이 맨 마지막에 뜬 다는 것은 지금 이 main 쓰레드가 th1 과 th2 를 기다려줬다가 맨 마지막에
// 작업을 했다는 의미이다. 이게 join 메서드의 기능이다.

// 이 join 메서드를 쓸 때 유의하고 있어야 할 점은, 이 메서드가 호출되고 있는 그 장소의 쓰레드에서 양보하겠다는 것이다.
// 위에서 join 메서드가 호출된 장소가 main 메서드 내부이기 때문에 main 이 제일 늦게 끝난 것이다.
// th1.join() 은 th1 에게 양보하겠다는 것이지, th1 이 양보를 해준다는 뜻이 아니다.
// 이걸 헷갈리지 않도록 하자.