package ch13_Thread;

// 예제를 살펴보자. 이번엔 동기화를 해주었다. 실행해보면 절대 음수 안 나온다.


class Account2 {
    private int balance = 1000; // private 으로 해야 동기화가 의미가 있다.
                                // 동기화 해놨어도 다른 스레드에서 그냥 접근 가능하게 해놓아버리면 의미가 없다.
    public synchronized int getBalance() {  // 읽을 때도 동기화를 걸어줘야 한다.
        return balance;
    }

    public synchronized void withdraw(int money){ // synchronized 로 메서드를 동기화
        if(balance >= money) {
            try { Thread.sleep(1000);} catch(InterruptedException e) {}
            balance -= money;
        }
    } // withdraw
}
// 위와 같이 읽을 때와 쓸 때 모두 동기화를 걸어줘야 한다.

class RunnableEx13 implements Runnable {
    Account2 acc = new Account2();

    public void run() {
        while(acc.getBalance() > 0) {
            // 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance:"+acc.getBalance());
        }
    } // run()
}
public class _16_3_Example_Sync {
    public static void main(String args[]) {
        Runnable r = new RunnableEx13();
        new Thread(r).start();
        new Thread(r).start();
    }
}
