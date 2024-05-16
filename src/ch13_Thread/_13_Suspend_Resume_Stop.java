package ch13_Thread;

//
//      suspend(), resume(), stop() 은 사실 deprecated 처리된 메서드들이다.
//      deadlock(교착상태)을 일으킬 가능성이 있어서 권장되지 않기 때문에 그렇게 되었다(어노테이션 부분 참고).
//
//      물론 간단한 개인 연습용 프로그램에서는 상관 없는데 팀 프로젝트 같은 곳에선 쓰면 욕먹는 수준이다.

class RunImplEx10 implements Runnable {
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
        }
    } // run()
}

public class _13_Suspend_Resume_Stop {
    public static void main(String[] args) {
        RunImplEx10 r = new RunImplEx10();
        Thread th1 = new Thread(r, "*");
        Thread th2 = new Thread(r, "**");
        Thread th3 = new Thread(r, "***");
        th1.start();
        th2.start();
        th3.start();
        // suspend, resume, stop 은 deprecated 된 메서드라 컴파일에서 빨간줄을 그어 경고해준다.
        // 에러가 발생하지는 않아서 실행은 가능하다.
        try {
            Thread.sleep(2000);     // main 쓰레드를 2초 동안 재우려고 한다.

            th1.suspend();	// 쓰레드 th1을 잠시 중단시킨다.
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();	// 쓰레드 th1이 다시 동작하도록 한다.
            Thread.sleep(3000);
            th1.stop();		// 쓰레드 th1을 강제종료시킨다.
            th2.stop();     // 쓰레드 th2을 강제종료시킨다.
            Thread.sleep(2000);
            th3.stop();     // 마지막으로 쓰레드 th3까지 강제종료.
        } catch (InterruptedException e) {}
    }
        // 실제로 위 코드를 실행해보면 교착상태에 빠져 stop 메서드에 도달하지 못한다. 이런 위험 때문에
        // deprecated 된 것이다... 정상적으로 강제종료 시키려면 volatile 처리를 해줘야 한다.
        // CPU 의 코어들이 복사본을 사용하지 않고 메모리에 있는 원본을 직접 읽어오는 방식이 된다.
        // 자세한 내용은 아래 링크 14:45부터 참고:
//    https://www.youtube.com/watch?v=uY_xbLi_cSA&list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp&index=154
}
