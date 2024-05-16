package ch13_Thread;
//
//      yield() 메서드는 남은 시간을 다음 쓰레드에게 양보하고 자신은 실행대기 한다.
//      여기서 유의할 점은, 실행대기라고 해서 WAITING 상태가 된다는 게 아니라,
//      여전히 RUNNABLE 을 유지하기는 하는데 대기열의 뒤쪽으로 가준다는 뜻이다.
//
//      static void yield()                         실행 중에 자신에게 주어진 실행시간을 다른 쓰레드에게 양보하고,
//                                                  자신은 실행대기상태가 된다. (RUNNABLE 상태는 유지)
//
//      보다시피 static 메서드이기 때문에 당연히 Thread.yield() 이런 식으로 써야 한다.
//      yield() 는 뒤에서 조건부로 해주는 대몬 쓰레드 같은 데에 쓰면 유용하다.
//      while 은 true 상태라 계속 돌아가고 있는데 while 내부의 실행조건 부분이 false 면 반복문만 아무리 실행해도
//      반복문의 구현부에 있는 조건문에는 안 맞으니까 메모리 낭비다. 이걸 busy waiting 이라 한다.
//      그럴 때 조건문의 else 문에 yield() 를 호출시켜서 다른 쓰레드에게 자원을 양보하는 게 더 효율적이다.
//
//      public void run() {
//          while(!stopped) {
//              if(!suspended) {
//                  작업할 내용들
//                  try {
//                      Thread.sleep(1000);
//                  } catch(InterruptException e) { }
//              } else {
//                  Thread.yield();
//              }
//          }
//      }
//
//      다만, yield() 는 OS scheduler 에게 통보를 하는 방식이기 때문에
//      yield 를 썼다고 해서 반드시 개발자가 의도된 대로 동작할 것이라는 보장은 없다.
//


public class _15_Yield {
}
