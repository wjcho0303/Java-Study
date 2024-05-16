package ch13_Thread;

//      쓰레드의 우선순위라는 게 뭘까?
//      쓰레드는 작업의 중요도에 따라 쓰레드의 우선순위를 다르게 줘서
//      특정 쓰레드가 더 많은 작업시간을 갖게 할 수 있다.
//
//      void setPriority(int number)        쓰레드의 우선순위를 입력한 숫자로 변경한다.
//                                          숫자가 클수록 중요도가 높아 작업시간을 많이 얻게 된다.
//
//      int getPriority()                   쓰레드의 우선순위가 얼마인지 리턴한다.
//
//      public static final int MAX_PRIORITY = 10   // 최대우선순위는 10 이다.
//      public static final int MIN_PRIORITY = 1    // 최소우선순위는 1 이다.
//      public static final int NORM_PRIORITY = 5   // 보통우선순위는 5 이다.
//      기본적으로 쓰레드를 만들게 되면 우선순위가 NORM_PRIORITY, 즉 5로 설정된다.
//      JVM 은 우선순위가 이렇게 10단계로 되어 있는데, OS scheduler 는 우선순위가 32단계로 되어 있다고 한다...
//
//      여기서 내가 우선순위를 만약 7로 올려주고 싶다? th2.setPriority(7) 이런 식으로 쓰면 되는 것이다.
//      쓰레드 우선순위는 프로그램을 실행한 후에도 설정되도록 코드를 짤 수 있어서 코드가 동작할 수 있는 작업시간을
//      입맛대로 늘려주거나 줄여줄 수 있다.
//      물론 어디까지나 이 우선순위는 "희망사항"이다. 결국 OS Scheduler 에게 전달해서 작업이 이루어지는 것이기 때문에
//      우선순위 만으로는 실제로 작업의 우선순위가 결정되는 것은 아니다. 작업할 시간을 늘려주기는 하지만
//      작업의 종료가 누가 먼저 이루어지는 우선순위만으로는 보장되지 않는다.
//


class ThreadEx6_1 extends Thread {              // 첫 번째 꺼가 가로 짝대기 ------
    public void run() {
        for(int i=0; i < 300; i++) {
            System.out.print("-");
            for(int x=0; x < 10000000; x++);    // 단순 시간 지연을 위한 코드
        }                                       // 특정 작업이 너무 일찍 끝나지 않게 하기 위함임
    }
}

class ThreadEx6_2 extends Thread {              // 두 번째 꺼가 세로 짝대기 |||||||
    public void run() {
        for(int i=0; i < 300; i++) {
            System.out.print("|");
            for(int x=0; x < 10000000; x++);    // 단순 시간 지연을 위한 코드
        }                                       // 특정 작업이 너무 일찍 끝나지 않게 하기 위함임
    }
}

public class _07_PriorityOfThread {
    public static void main(String args[]) {
        ThreadEx6_1 th1 = new ThreadEx6_1();
        ThreadEx6_2 th2 = new ThreadEx6_2();

        th2.setPriority(7);                     // 우선순위를 세로 짝대기를 찍는 쓰레드를 높여주었다.

        System.out.println("Priority of th1(-) : " + th1.getPriority());
        System.out.println("Priority of th2(|) : " + th2.getPriority());
        th1.start();
        th2.start();
        // 과연 누가 먼저 작업을 마칠까?
        // 내가 20번을 실행시켜보고 낸 통계는 다음과 같다:
        //      - 가 먼저 종료:  10회
        //      | 가 먼저 종료:  10회
        // ?????????????????? 이렇게 우선순위는 희망사항에 불과하다.
        // 물론 우선순위의 격차를 더 벌어지게 해놓는다면 통계가 좀 더 유의미한 차이를 나타나긴 할 것이다.
        // 실제로 우선순위 차이 1은 거의 차이가 없는 수준이고, 2부터 약간 미세하게 차이가 느껴지는 정도라고 한다.

        // 윈도우의 경우 마우스 포인터의 작업이 상대적으로 우선순위가 높다고 한다.
        // 그래서 어렸을 때 똥컴 쓰면서 렉걸렸을 때 마우스는 움직이는 경우를 자주 보곤 했다...
        // 렉 걸렸을 때 사용자가 답답함을 그나마 덜 느끼라고 그렇게 해놨다고 한다.
        // 마우스까지 안 움직였으면 개화났을 듯 ㄹㅇ
    }
}
