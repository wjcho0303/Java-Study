package ch13_Thread;

// 예제를 살펴보자. 동기화가 안 된 케이스이다. 실행해보면 가끔 음수가 나온다.

class Account {
    private int balance = 1000;

    public  int getBalance() {
        return balance;
    }

    public void withdraw(int money){
        if(balance >= money) {   // 출금하려는 돈보다 잔고가 커야지만 작업을 하도록 설정
            try { Thread.sleep(1000);} catch(InterruptedException e) {}
            balance -= money;
        }
    } // withdraw
}

// 어떤 쓰레드가 들어와서 이걸 실행하다가 조건문을 통과한 후에 중간에 중지되고 다른 쓰레드가 이걸 실행하게 된다면
// 잔고가 없는 쓰레드가 실행을 해버리게 될 수도 있다. 그 때문에 이걸 실행해보면 balance 가 음수인 경우도 종종 생긴다.
// 잔고 검사를 제대로 거치지 않은 쓰레드의 작업이 수행되어 balance 보다 큰 값이 깎이기 때문이다.

class RunnableEx12 implements Runnable {
    Account acc = new Account();

    public void run() {
        while(acc.getBalance() > 0) {
            // 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance:"+acc.getBalance());
        }
    } // run()
}

public class _16_2_Example_NonSync {
    public static void main(String args[]) {
        Runnable r = new RunnableEx12();
        new Thread(r).start(); // ThreadGroup 에 의해 참조되므로 gc 대상이 아니다.
        new Thread(r).start(); // ThreadGroup 에 의해 참조되므로 gc 대상이 아니다.
    }
}
