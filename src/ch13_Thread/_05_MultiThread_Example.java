package ch13_Thread;

class ThreadEx3_1 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++)
            System.out.printf("%s", new String("|"));

        System.out.print("\n" + "소요시간2 : " + (System.currentTimeMillis() - _05_MultiThread_Example.startTime) + "\n");
    }
}
public class _05_MultiThread_Example {
    static long startTime = 0;
    public static void main(String args[]) {
        ThreadEx3_1 th1 = new ThreadEx3_1();
        th1.start();
        startTime = System.currentTimeMillis();

        for(int i=0; i < 300; i++)
            System.out.printf("%s", new String("-"));

        System.out.print("\n" + "소요시간1 : " + (System.currentTimeMillis() - _05_MultiThread_Example.startTime) + "\n");
    }
}


// 소요시간1 이 먼저 나오기도 하고 소요시간2가 먼저 나오기도 한다.
// OS scheduler 에 의해 결정되는 거라서 실행할 때마다 결과도 다르다.

// 그리고 눈여겨 볼 점은, _04_SingleThread_Example.java 를 실행해보면 알겠지만,
// 싱글 쓰레드로 작업한 시간보다 멀티 쓰레드로 작업한 시간이 더 걸린다.
// 왜냐하면 멀티 쓰레드에서 어떤 작업을 하다가 다른 작업으로 넘어가는 것을 "context switching" 라고 부르는데,
// 이 context switching 에 걸리는 시간도 포함되기 때문이다.
// 한 작업만 쭉 하는 것보다 번갈아가면서 작업을 수행하는 게 당연히 시간이 더 걸리는 것이다.

// 그럼 멀티쓰레드를 왜 쓰는거지? 더 느린데?
// 다른 작업들을 동시에 돌릴 수 있다는 장점 때문에 하는 것이다.
// 채팅하면서 사진도 다운 받고 이모티콘도 쓰는 등등 여러 가지 작업을 동시에 하려면 솔직히 조금 느려도 괜찮다.
// 아무리 각각의 작업의 속도가 좀 더 빠르더라도 한 번에 하나씩만 하게 되면 불편하다.

// 사실 현실적으로 싱글 쓰레드로 빠른 결과를 얻으려면 쓰레드 안에 작업들을 미리 예약을 걸어놓아야 한다.
// 근데 그마저도 빨리 수행하기 원하는 작업들을 우선순위에 먼저 두는 등 사용 방법이 오히려 더 복잡해질 것이다.
// 그럼 그런 것들에 예약을 걸어놓는 시간, 우선순위를 생각하는 시간 등등을 포함하면 멀티 쓰레드가 훨씬 효율적이다.