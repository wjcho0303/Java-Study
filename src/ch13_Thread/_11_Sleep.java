package ch13_Thread;

//
//      sleep() 은 static 메서드라 현재 자기 자신 쓰레드에만 사용할 수 있다.
//      내가 잘 수는 있는데 다른 사람을 자게할 수는 없는 것이다.
//
//      static void sleep(Long millis)              설명 생략
//      static void sleep(Long millis, int nanos)   나노 초를 넣기도 하는데, 사용하는 경우는 드물다.
//
//      sleep() 는 예외를 발생시킬 잠재가 있는 메서드이기 때문에 예외처리를 해줘야 한다.
//      그래서 아래와 같은 템플릿으로 사용해야 한다.
//
//      try {
//          Thread.sleep(1, 500000);    // 쓰레드를 0.001 + 0.0005초 (= 0.0015초)동안 멈추게 한다.
//      } catch (InterruptedException e) { }
//      나노 초 사용 예시를 보여주기 위해 저렇게 썼다. 사용법이 저렇다 보니 잘 안 쓴다...
//
//      그렇다면 예외를 발생시킬 잠재가 있다는 것은 무슨 말인가? 그건 바로 interrupt 메서드 호출에 대한 것이다.
//      사실 sleep 이 time-out 될 때까지 가만히 놔두는 건 예외를 던지지는(throw) 않는다.
//      그런데 만약 시간이 다 끝나지 않은 중간에 interrupt() 를 호출하면
//      저 try 문 안에서 throw new InterruptedException 이 일어난다. 즉 예외를 던진다.
//      그러한 상황에 대비하기 위한 catch 문을 쓴 것이다. 근데 딱히 문제가 있어서 발생하는 예외는 아니라서
//      catch 구현부는 저렇게 비워도 된다. 아니면 특정 메세지를 출력하는 코드는 넣을 수도 있고. 암튼 비워도 된다.
//
//      저 try-catch 문을 통한 예외처리는 필수예외라서 해주지 않으면 컴파일 에러가 발생한다...
//      그래서 난 중간에 interrupt 안 할 건데? 소용없다. interrupt 할 계획이 없다고 해도 무조건 적어야 한다.
//      이렇게 sleep 을 사용해주기 위해서는 예외처리를 해줘야 해서 불편하다. 그래서 따로 sleep 예외처리까지 미리
//      작성해놓은 별도의 메서드를 만들어서 쓴다... 예를 들어보자.
//
//      void delay(Long millis) {
//          try {
//              Thread.sleep(millis);
//          } catch (InterruptedException e) { }
//      }
//
//      이렇게 sleep 과 예외처리까지 미리 작성해놓은 새로운 메서드는 예외처리 안쓰고 그냥 사용할 수 있다.
//      실제로 sleep 쓸 때 많은 사람들이 이렇게 쓴다... 이거도 거의 템플릿 수준이니까 필요하면 복붙 해놓고 쓰자.
//
//      그리고 앞서 언급했듯이 sleep 은 특정 쓰레드를 지정해서 사용할 수 없다.
//      th1.sleep(2000) 이렇게 쓰면 안 된다. 에러가 발생하지는 않지만 오해가 발생할 수 있기 때문에 반드시
//      Thread.sleep(2000) 이렇게 써야 한다. static 메서드니까 당연히 이렇게 쓰는 게 맞는 것이다.
//

class ThreadEx8_1 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) System.out.print("-");
        System.out.print("<<th1 종료>>");
    } // run()
}

class ThreadEx8_2 extends Thread {
    public void run() {
        for(int i=0; i < 300; i++) System.out.print("|");
        System.out.print("<<th2 종료>>");
    } // run()
}
public class _11_Sleep {
    public static void main(String args[]) {
        ThreadEx8_1 th1 = new ThreadEx8_1();
        ThreadEx8_2 th2 = new ThreadEx8_2();
        // 이제 쓰레드가 main 쓰레드, th1, th2 이렇게 세 개가 되었다.
        th1.start();
        th2.start();

        // 진짜로 th1 쓰레드를 2초 동안 잠재울 수 있을까?
//        try {
//            th1.sleep(2000);
//        } catch(InterruptedException e) {}

        // 위에를 보면 th1.sleep(2000) 지금 이렇게 쓰고 있다. ★잘못된 표현이다.★
        // 원래는 Thread.sleep(2000); 이렇게 써야 한다.★
        // 만약 th1.sleep(2000) 이게 진짜로 통한다면 항상 th1 가 제일 늦게 끝나야 할 것이다.
        // 그러나 실제로 결과를 보면 th1 이 항상 먼저 끝나지는 않는다. 거의 반반이다.
        System.out.print("<<main 종료>>");
    }

        // 그리고 분명한 점이 하나 있는데, 그건 바로 항상 main 메서드가 제일 늦게 끝나고 있다는 것이다.
        // 왜냐하면 실제로 sleep(2000) 이 적용되는 건 th1 이나 th2 가 아니라 main 쓰레드 이기 때문이다.
        // 실제로 저 try-catch 문에 주석처리하고 실행해보면 main 쓰레드가 이번에는 항상 제일 먼저 끝난다.
        // 왜냐하면 main 쓰레드에 저 try-catch 문에 주석을 달면
        // th1 과 th2 call Stack 을 만들고 run 만 올려놓아주고 바로 출력문을 실행하고 종료되기 때문에
        // 작업할 게 거의 없어서 가장 일찍 끝날 확률이 높아서 그런 거다.
}
