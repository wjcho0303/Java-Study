package ch13_Thread;

//      쓰레드 그룹은 관련된 쓰레드를 묶어서 다루기 위한 것이다.
//      모든 쓰레드는 반드시 하나의 쓰레드 그룹에 포함되어 있어야 한다.
//
//      쓰레드 생성자를 한 번 살펴보자.
//      Thread(ThreadGroup group, String name)
//
//      Thread(ThreadGroup group, Runnable target)
//
//      Thread(ThreadGroup group, Runnable target, String name)
//
//      Thread(ThreadGroup group, Runnable target, String name, long stackSize)
//
//      보면 쓰레드 생성자의 매개변수 중에 그룹을 지정하는 매개변수가 보인다.
//      근데 지금까지 우리는 저렇게 매개변수를 넣어서 쓰레드를 생성한 적도 없기 때문에 몰랐던 것이다.
//      사실 쓰레드 그룹을 지정하지 않고 생성된 쓰레드는 모두 자동으로 "main 쓰레드 그룹"에 속하게 된다.
//
//      쓰레드가 생성되면 자신을 생성한 쓰레드의 그룹과 우선순위를 상속 받는다.
//      우린 지금까지 메인 메서드 안에서 쓰레드를 생성했었기 때문에 지금까지 만들었던 쓰레드들은 모두
//      메인 쓰레드 그룹에 속했던 것이다.
//
//      쓰레드 그룹과 관련된 메서드는 뭐가 있을까?
//      이것들을 다 외우라는 건 아니고 그냥 어떤 메서드들이 있나 훑어보고 아 이런 메서드도 있구나
//      할 수 있는 정도로만 보자.

//      ThreadGroup getThreadGroup()                    쓰레드 자신이 속한 쓰레드 그룹을 리턴
//
//      void uncaughtException(Thread t, Throwable e)   처리되지 않은 예외에 의해 쓰레드 그룹의 쓰레드가 종료되었을 때,
//                                                      JVM 에 의해 이 메서드가 자동적으로 호출된다.
//      이 메서드는 ThreadGroup 클래스에 있는 메서드이다.
//
//      그 외에도 많은 ThreadGroup 의 메서드가 있다:
//      ThreadGroup(String name)                        입력한 이름으로 새로운 쓰레드 그룹 생성
//
//      ThreadGroup(ThreadGroup parent, String name)    입력한 쓰레드 그룹에 포함되는 새로운 쓰레드 그룹 생성
//
//      int activeCount()                               쓰레드 그룹에 포함된 활성 상태의 쓰레드 수 리턴
//
//      int activeGroupCount()                          쓰레드 그룹에 포함된 활성 상태의 쓰레드 그룹의 수 리턴
//
//      void checkAccess()                              현재 실행중인 쓰레드가 쓰레드 그룹을 변경할 권한이 있는지 체크
//
//      void destroy()                                  쓰레드 그룹과 하위 쓰레드 그룹까지 모두 삭제.
//                                                      단, 비어 있어야 삭제 가능
//
//      int enumerate(Thread[] list)
//      int enumerate(Thread[] list, boolean recurse)
//      int enumerate(ThreadGroup[] list)
//      int enumerate(ThreadGroup[] list, boolean recurse)
//      입력한 배열에 쓰레드 그룹에 속한 쓰레드 또는 하위 쓰레드 그룹의 목록을 담은 후, 그 개수를 리턴한다.
//      두 번째 매개변수 recurse 를 true 로 하면 쓰레드 그룹에 속한 하위 쓰레드 그룹에 쓰레드와 쓰레드 그룹을
//      배열에 담는다.


//      int getMaxPriority()                            쓰레드 그룹의 최대우선순위를 리턴
//
//      String getName()                                쓰레드 그룹의 이름을 리턴
//
//      ThreadGroup getParent()                         쓰레드 그룹의 상위 쓰레드 그룹을 리턴
//
//      void interrupt()                                쓰레드 그룹에 속한 모든 쓰레드를 interrupt
//
//      boolean isDaemon()                              쓰레드 그룹이 데몬 쓰레드 그룹인지 여부 확인
//
//      boolean isDestroyed()                           쓰레드 그룹이 삭제되었는지 여부 확인
//
//      void list()                                     쓰레드 그룹이 속한 쓰레드와 하위 쓰레드 그룹에 대한 정보 출력
//
//      boolean parentOf(ThreadGroup g)                 쓰레드 그룹이 입력한 그룹의 상위 그룹인지 여부 확인
//
//      void setDaemon(boolean daemon)                  쓰레드 그룹을 데몬 쓰레드 그룹으로 설정/해제
//
//      void setMaxPriority(int pri)                    쓰레드 그룹의 최대 우선순위를 결정
//
//


public class _08_ThreadGroup {
}
