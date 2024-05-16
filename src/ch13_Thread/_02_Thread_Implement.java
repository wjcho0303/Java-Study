package ch13_Thread;
//
//      이번엔 쓰레드를 구현하고 실행하는 방법에 대해 알아보자.
//      일단 쓰레드를 구현하는 방법은 두 가지다: 1. 쓰레드 클래스 상속 받기   2. Runnable 인터페이스 구현하기
//      둘 다 어찌됐든 뭔가를 물려 받는다는 점에서는 공통이다.
//
//      1. Thread 클래스를 상속 받는 방법
//      class MyThread extends Thread {
//          public void run() {             Thread 의 run() 메서드를 오버라이딩
//              ...
//          }
//      }
//      이런 식으로 클래스에다가 Thread 클래스를 상속 받는 방법이 있다.
//      그런데 자바는 단일 상속이기 때문에 이렇게 Thread 의 자손 클래스가 되어버리면
//      다른 클래스로부터 상속은 못 받게 된다. 필요하다면 인터페이스를 구현할 수 있다지만 아무리 그래도
//      상속은 클래스 입장에서는 단 한 번의 기회인데 Thread 를 상속 받아버리는 건 좀 그렇긴 하다.
//
//      이렇게 Thread 클래스를 상속 받는 방법으로 할 경우 실행은 다음과 같다:
//                  MyThread t1 = new MyThread();
//                  t1.start();
//      Thread 클래스 안에 start() 라는 메서드가 있어서 이렇게 하면 된다.
//
//
//
//      2. Runnable interface 구현하는 방법
//      class MyThread2 implements Runnable {
//          public void run() {             Runnable 의 추상메서드인 run() 을 구현
//              ...
//          }
//      }
//      1번 방법보다는 이 방법이 더 유연하다.
//
//      실제로 Runnable interface 는 아래와 같이 생겨 먹었다:
//      public interface Runnable {
//          public abstract void run();
//      }
//      이렇게 run() 이라는 추상메서드가 선언되어 있고, 구현부는 물려받은 클래스에서 알아서 작성하면 된다.
//
//      이 방법에서는 어떻게 쓰레드를 실행할 수 있을까?
//      Runnable r1 = new MyThread2();  // 참조변수는 Runnable 로 선언, 객체는 Runnable 을 구현한 클래스로 생성
//      Thread t2 = new Thread(r1);     // Thread 클래스의 객체를 생성하는데, 생성자 매개변수에 위에서 만든 참조변수 입력
//      t2.start();                     // Thread 클래스 객체를 통해 start() 메서드 호출
//
//      이렇게 하는 것은 외부에서 제공한 run() 메서드를 Thread 의 메서드 start() 를 이용하여 호출하려는 것 때문이다.
//

class ThreadEx1_1 extends Thread {
    public void run() {     // run 메서드의 구현부에 쓰레드에게 시킬 작업들을 입력한다.
        for(int i=0; i < 500; i++) {
            System.out.println(getName()); // Thread 의 메서드인 getName()을 호출
        }   // 참고: getName() 메서드는 쓰레드의 이름을 리턴한다.
    }
}

class ThreadEx1_2 implements Runnable {
    public void run() {     // run 메서드의 구현부에 쓰레드에게 시킬 작업들을 입력한다.
        for(int i=0; i < 500; i++) {
            // Thread.currentThread() - 현재 실행중인 Thread 를 반환한다.
            System.out.println(Thread.currentThread().getName());
        }   // Thread 클래스의 getName 메서드를 쓰기 위해 Thread 를 호출한 후에 사용하는 모습
    }
}

// Thread 를 상속 받은 경우에는 그냥 this.getName() 하면 되는데 (여기서 this. 생략도 가능)
// Runnable 로 구현한 방식은 Thread 를 리턴을 하고 나서야 Thread 의 메서드를 쓸 수 있다는 점...
// 장단점이 확실한듯...

public class _02_Thread_Implement {
    public static void main(String[] args) {
        // Thread 클래스 상속 방식
        ThreadEx1_1 t1 = new ThreadEx1_1();

        // Runnable 인터페이스 구현 방식
        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r);	  // 생성자: Thread(Runnable target)

        // start() 메서드를 호출하면 run 메서드가 호출되어 쓰레드에게 시키려고 했던 작업이 수행된다.
        t1.start(); // Thread-0 500줄 출력.
        t2.start(); // Thread-1 500줄 출력.
        // Thread-0 과 Thread-1 모두 쓰레드의 이름이다.
        // 지금 이렇게 작업한 것이 바로 멀티 쓰레드로 돌린 것이다.

        // 만약 싱글쓰레드였다면 Thread-0 이 500줄 먼저 쭉 출력된 후, 그 후에 Thread-1 이 500줄 출력되었을 것이다.
        // 근데 출력해보면 두 개가 서로 엉켜있다. 이게 멀티 쓰레드라서 그렇게 되는 것이다.

        // 이렇게, 상속을 받든 구현체를 시키든 쓰레드를 생성한 후,
        // 그 쓰레드 객체로 start() 를 호출하면 쓰레드가 작업을 시작한다.

        // 물론 엄밀히 말하면 start() 메서드를 호출하는 것 자체가 작업을 시작시키는 건 아니다.
        // start() 메서드를 호출하면 "실행 가능한 상태가 되는 것이지, 실행 자체가 되는 건 아니다."
        // 그리고 실행 가능 상태가 된 쓰레드를 언제 실행할지는 OS scheduler 가 결정한다.
        // 이 OS scheduler 가 쓰레드의 실행 순서를 결정한다.

        // 이 말은 사실 위에서 처럼 두 개의 쓰레드 모두 start() 를 올렸을 때, 먼저 start() 를 호출했다고 해서
        // 반드시 그 쓰레드가 먼저 실행된다는 것은 아니라는 말이다. 실제로 여러 번 Run 해보면
        // Thread-1 이 먼저 나오는 경우도 있다.
    }
}
//      그럼 run() 은 뭔가? 구현부는 분명 run() 에 작성했는데
//      왜 start() 를 호출하니까 run() 에 적은 구현부가 작동하는 것인가?
//
//      https://www.youtube.com/watch?v=P1zDndoy4pI&list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp&index=149
//      그림과 함께 설명을 보고 싶으면 15:14 부터 확인.
//
//      1. Call stack 에서 main 메서드에서 start() 를 호출한다.
//
//      2. start() 메서드가 새로운 Call stack 을 호출한다.
//
//      3. 그 새로운 Call stack 에 run() 메서드를 올린다.
//
//      즉, start() 메서드가 하는 일은 사실 이 두 가지다:
//      - 새로운 Call stack 을 호출
//      - 그 새로운 Call stack 에 run 메서드 올리기
//      - 종료
//
//      이런 식으로 쓰레드 start() 를 하게 되면
//      각각의 쓰레드가 자기만의 Call stack 을 갖게 되어 독립적으로 작업을 수행할 수 있게 되는 것이다.
