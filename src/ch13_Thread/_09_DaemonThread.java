package ch13_Thread;

//
//      daemon thread(데몬 쓰레드)는 일반 쓰레드(non-daemon thread)의 작업을 돕는 보조적인 역할을 수행한다.
//      일반 쓰레드의 보조 역할이 목적인 쓰레드이기 때문에 일반 쓰레드가 종료되면
//      자동으로 데몬 쓰레드도 종료된다.
//
//      데몬 쓰레드가 어떤 일을 도와준다는 건가?
//      가비지 컬렉터(자바), 자동저장(워드 프로세서), 화면 자동갱신 등에 사용된다.
//      이렇게 데몬 쓰레드는 자동으로, 그리고 계속 작동하기 때문에 무한루프 코드(while true)로 되어 있다.
//      그리고 특정 조건을 걸어놓고 있다가 조건에 맞는 상황이 오면 자동으로 작업을 수행하고 다시 대기하도록
//      작성되어 있다.
//
//      예를 들어 보자.
//      public void run() {
//          while(true) {
//              try {
//                  Thread.sleep(3 * 1000); // 3초 주기로 현황을 체크하도록 설정하는 코드(단위는 ms 라 3000 으로...)
//              } catch(InterruptedException) { }
//
//          // autoSave 의 값이 true 이면 autoSave() 를 호출하는 조건부 명령
//              if(autoSave) {
//                  autoSave();
//              }
//          }
//      }
//
//      이런 식으로 되어 있다. 일반 쓰레드가 작업을 언제 마칠지 모르니까 조건부 실행을 걸어놓고
//      무한 루프로 계속 돌고 있다. 데몬 쓰레드는 일반 쓰레드가 종료되면 같이 종료되기 때문에
//      무한 루프가 허용되는 것이다. 데몬 쓰레드는 굉장히 다양하지만 작성하는 패턴이나 원리는
//      대부분 위 예시와 비슷하다.
//
//
//      데몬 쓰레드와 관련된 메서드는 다음과 같다:
//      boolean isDaemon()          데몬 쓰레드인지 여부 확인
//
//      void setDaemon(boolean on)  쓰레드 모드를 변경. true 를 넣으면 데몬 쓰레드로 되고,
//                                  false 를 넣으면 사용자 쓰레드가 된다.
//
//      단, setDaemon(boolean on) 메서드의 경우에는 반드시 start() 를 호출하기 전에 미리 실행해놔야 한다.
//      그렇지 않고 start() 가 된 이후에 저 메서드를 호출하면 IllegalThreadStateException 이 발생한다.


class Ex13_7 implements Runnable  {
    // Runnable 을 구현한 모습.
    // Runnable 이 구현되었다는 것은 run() 메서드가 있다는 뜻이다.
    static boolean autoSave = false;
    // static 변수 autoSave 의 초기값을 false 로 설정.

    public void run() {
        while(true) {       // 이 쓰레드는 무한 루프이다.
            try {
                Thread.sleep(3 * 1000); // 3초마다
            } catch(InterruptedException e) {}

            // autoSave의 값이 true이면 autoSave()를 호출한다.
            if(autoSave) autoSave();
        }
    }

    public void autoSave() {
        System.out.println("작업파일이 자동저장되었습니다.");
    }

    public static void main(String[] args) {
        Runnable r = new Ex13_7();  // Runnable 인터페이스의 기능들을 탑재한 Ex13_7 클래스 객체 생성
        Thread t = new Thread(r);   // 해당 객체를 Thread 로 만들어 버림.
//      Thread t = new Thread(new Ex13_7());

        t.setDaemon(true);
        // 위에서 만든 쓰레드를 daemon 쓰레드로 만들었다.
        // 이 부분이 없으면 데몬 쓰레드가 아니라 사용자 쓰레드이기 때문에
        // 메인 쓰레드가 종료되어도 종료되지 않고, 3초마다 계속
        // "작업파일이 자동저장되었습니다."
        // "작업파일이 자동저장되었습니다."
        // "작업파일이 자동저장되었습니다." ㅇㅈㄹ 한다.

        t.start();

        for(int i=1; i <= 30; i++) {
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
            System.out.println(i);

            if(i==5) autoSave = true; // 프로그램 시작 후 5초 시점에 autoSave 를 true 로 바꾸고,
        }
        // 10초 카운트 한다. autoSave 가 true 일 때 autoSave() 를 호출하기로 했으므로
        // 5초 딱 됐을 때 autoSave() 가 처음으로 호출되고, 그 이후 3초마다 계속 무한으로 호출된다.
        // 그러다가 30초가 됐을 때 프로그램이 종료되는데, 이때 데몬 쓰레드도 같이 종료된다.
        // 이렇게 데몬 쓰레드는 사용자 쓰레드가 종료되면 함께 종료되는 특징이 있다.

        System.out.println("프로그램을 종료합니다.");
    }
}

//                출력내용:
//                1
//                2
//                3
//                4
//                5
//                작업파일이 자동저장되었습니다.
//                6
//                7
//                8
//                작업파일이 자동저장되었습니다.
//                9
//                10
//                11
//                작업파일이 자동저장되었습니다.
//                12
//                13
//                14
//                작업파일이 자동저장되었습니다.
//                15
//                16
//                17
//                작업파일이 자동저장되었습니다.
//                18
//                19
//                20
//                작업파일이 자동저장되었습니다.
//                21
//                22
//                23
//                작업파일이 자동저장되었습니다.
//                24
//                25
//                26
//                작업파일이 자동저장되었습니다.
//                27
//                28
//                29
//                작업파일이 자동저장되었습니다.
//                30
//                프로그램을 종료합니다.

public class _09_DaemonThread {
}
