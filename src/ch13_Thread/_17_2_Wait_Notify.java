package ch13_Thread;
import java.util.ArrayList;


class Customer2 implements Runnable {
    private Table2  table;
    private String food;

    Customer2(Table2 table, String food) {
        this.table = table;
        this.food  = food;
    }

    public void run() {
        while(true) {
            try { Thread.sleep(100);} catch(InterruptedException e) {}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);
        } // while
    }
}

class Cook2 implements Runnable {
    private Table2 table;

    Cook2(Table2 table) { this.table = table; }

    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try { Thread.sleep(10);} catch(InterruptedException e) {}
        } // while
    }
}

class Table2 {  //
    String[] dishNames = { "donut","donut","burger" }; // donut 의 확률을 높인다.
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        while(dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name+" is waiting.");
            try {
                wait(); // 요리사는 테이블이 가득 차면 대기실로 이동 wait() 한다.
                Thread.sleep(500);
            } catch(InterruptedException e) {}
        }
        dishes.add(dish);
        notify();  // 음식을 추가하고 나면 손님에게 통보 notify() 한다. (손님이 lock 을 재획득)
        System.out.println("Dishes:" + dishes.toString());
    }

    public void remove(String dishName) {
        synchronized(this) {
            String name = Thread.currentThread().getName();

            while(dishes.size()==0) {
                System.out.println(name+" is waiting.");
                try {
                    wait(); // 음식이 없으면 손님은 대기실로 이동 wait() 한다. (손님이 lock 을 해제)
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            }

            while(true) {
                for(int i=0; i<dishes.size();i++) {
                    if(dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify(); // 음식을 소비한 후 잠자고 있는 요리사에게 통보 notify() 한다.
                        return;
                    }
                } // for문의 끝

                try {
                    System.out.println(name+" is waiting.");
                    wait(); // 원하는 음식이 없는 CUST 쓰레드 를 기다리게 한다. lock 을 풀고 대기실로 이동.
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            } // while(true)
        } // synchronized
    }
    public int dishNum() { return dishNames.length; }
}
// 근데 위에서 보다시피 wait() 과 notify() 가 적용되는 대상이 불분명하다.
// 손님이 wait 하는 것인지, 요리사가 wait 하는 것인지?
// 손님에게 notify 하는 것인지, 요리사에게 notify 하는 것인지? 대기실에는 손님과 요리사가 둘 다 있는데?
// 이렇게 구분이 안 되는 것 때문에 사용되는 것이 lock 과 condition 이다. 이건 자바의정석 3판 참고.

public class _17_2_Wait_Notify {
    public static void main(String[] args) throws Exception {
        Table2 table = new Table2();

        new Thread(new Cook2(table), "COOK").start();
        new Thread(new Customer2(table, "donut"),  "CUST1").start();
        new Thread(new Customer2(table, "burger"), "CUST2").start();
        Thread.sleep(2000);
        System.exit(0);
    }
}
