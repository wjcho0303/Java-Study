package ch13_Thread;
//
//      이번엔 쓰레드의 상태에 대해 알아보자.
//      쓰레드는 다섯 가지 상태가 있다:
//
//      NEW             쓰레드가 생성되고 아직 start()가 호출되지 않은 상태
//
//      RUNNABLE        실행 중 또는 실행 가능한 상태. start() 가 호출된 상태
//
//      BLOCKED         동기화 블럭에 의해서 일시정지된 상태. Lock 이 풀릴 때까지 대기중
//
//      WAITING         쓰레드 작업을 일시정지한 상태
//      TIMED_WAITING   TIMED_WAITING 은 일시정지할 시간이 지정된 경우임
//
//      TERMINATED      쓰레드 작업이 완료되었고, 종료됨
//
//      그럼 쓰레드들이 생성된 후 어떤 상태의 변화를 겪게 되는지 살펴보자.
//
//      1. 먼저 쓰레드가 생성된다고 하자. 그때의 상태는 NEW 이다.
//      2. 그러다가 start() 를 호출하였다. 그렇게 되면 RUNNABLE 상태가 되어 실행되기 전에 줄을 선다.
//      3. 그러다가 자기 차례가 되면 특정 차례가 되면 실행하게 된다.
//      4. 그런데 실행 중간에 자신에게 주어진(OS scheduler 에 의해) 시간이 다 되면 다시 뒤로 가서 줄을 서게 된다.
//      5. 이렇게 줄섰다가 실행했다를 반복한다. 실행되기를 대기하고 실행을 진행하는 그 두 가지의 상태 모두 RUNNABLE 이다.
//      6. 그러다가 stop() 메서드가 호출되거나, 작업을 다 마치면 TERMINATED 로 상태가 변화한다.
//
//      * start() 를 호출하면 RUNNABLE 이 된다.
//      * stop() 를 호출하면 TERMINATED 가 된다.
//
//      7. 그러면 BLOCKED 와 WAITING 은 어떤 메서드와 관련이 있을까?
//      - suspend(), wait(), sleep(), join() 메서드가 호출되면 WAITING 상태가 되고,
//      - I/O block(입출력 대기) 상태가 되면 BLOCKED 상태가 된다.
//
//      * suspend() 를 걸어놓으면 WAITING(일시정지) 이 되고, RUNNABLE 로 되돌리려면 resume() 를 호출해야 한다.
//      * wait()    를 걸어놓으면 WAITING(일시정지) 이 되고, RUNNABLE 로 되돌리려면 notify() 를 호출해야 한다.
//      * sleep()   를 걸어놓으면 TIME_WAITING 이 된다.
//          - sleep() 에서 입력한 시간(단위: ms)이 다 되면(time-out) 다시 RUNNABLE 로 되돌아간다.
//          - sleep() 시간이 다 되지 않았는데 중간에 일시정지를 풀고 싶을 때는 interrupt() 를 호출한다.
//      * join() 는 다른 쓰레드의 작업이 끝날 때까지 대기하게 하는 메서드이다.
//
//
//      위에서 말한 메서드를 포함하여 쓰레드의 실행제어와 관련된 메서드를 살펴보자:
//      static void sleep(Long millis)              설명 생략
//      static void sleep(Long millis, int nanos)   나노 초를 넣기도 하는데, 사용하는 경우는 드물다.
//
//      void join()                                 다른 쓰레드를 기다린다.
//      void join(Long millis)                      sleep()처럼 시간을 줄 수도 있다.
//      void join(LLong millis, int nanos)
//
//      void interrupt()                            sleep() 이나 join() 에 의해 WAITING 상태인 쓰레드를
//                                                  깨운다. Interrupted Exception 이 발생함으로써 일시정지 상태를
//                                                  벗어나게 된다.

//      void stop()                                 쓰레드 즉시 종료
//
//      void suspend()                              쓰레드 일시정지
//
//      void resume()                               suspend() 에 의해 WAITING 인 상태를 RUNNABLE 로 전환
//
//      static void yield()                         실행 중에 자신에게 주어진 실행시간을 다른 쓰레드에게 양보하고,
//                                                  자신은 실행대기상태가 된다. (RUNNABLE 상태는 유지)
//
//
//      특히, sleep() 과 yield() 는 static 메서드라는 점에 눈여겨 볼 필요가 있다.
//      얘네들은 쓰레드 자기 자신에게만 호출이 가능하다.
//      그 외 나머지 static 이 안 붙은 애들은 다른 쓰레드이든 자신의 쓰레드이든 상관 없이 적용가능하다.
//
//


public class _10_StateOfThread {
}
