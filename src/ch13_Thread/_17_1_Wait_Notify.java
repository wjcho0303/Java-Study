package ch13_Thread;
import java.util.ArrayList;
//
//      앞서 살펴보았듯이, 동기화를 하면 데이터가 보호 된다는 장점이 있었다.
//      그러나 문제는 성능 상에 문제를 일으킨다는 점이다.
//      그런데 데이터는 보호해야겠고, 성능도 어느 정도는 됐으면 좋겠다. 그럴 때
//      동기화의 효율을 높이기 위해 사용하는 것이 바로:  wait() 메서드  /  notify() 메서드이다.
//      wait 은 기다리는 거고, notify 는 통보하는 것이다.

//      wait() 과 notify() 는 Object 클래스에 정의되어 있으며, 동기화 블록 내에서만 사용할 수 있다.
//      그리고 객체마다 waiting pool(대기실)이 있는데, 그것도 관련된다.
//
//      wait() : 임계 영역에서 객체의 lock 을 풀고 쓰레드를 해당 객체의 waiting pool 에 넣는다.
//
//      notify() : waiting pool 에서 대기중인 쓰레드 중 하나를 깨운다.
//
//      notifyAll() : waiting pool 에서 대기중인 모든 쓰레드를 깨운다.
//      일반적으로 notify 보다 notifyAll 을 쓰는 것이 더 좋다.
//
//      아래 예제는 wait - notify 를 사용하지 않아 동기화에 문제가 발생한 경우이다.
//      문제를 해결한 예제는 17_2 에서 확인할 것
class Customer implements Runnable {
    private Table  table;
    private String food;

    Customer(Table table, String food) {
        this.table = table;
        this.food  = food;
    }

    public void run() {
        while(true) {
            try { Thread.sleep(10);} catch(InterruptedException e) {}
            String name = Thread.currentThread().getName();

            if(eatFood())
                System.out.println(name + " ate a " + food);
            else
                System.out.println(name + " failed to eat. :(");
        } // while
    }

    boolean eatFood() { return table.remove(food); }
}

class Cook implements Runnable {
    private Table table;

    Cook(Table table) {	this.table = table; }

    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try { Thread.sleep(100);} catch(InterruptedException e) {}
        } // while
    }
}

class Table {
    String[] dishNames = { "donut","donut","burger" };
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();
    public synchronized void add(String dish) { // synchronized 를 추가
        if(dishes.size() >= MAX_FOOD)
            return;
        dishes.add(dish);
        System.out.println("Dishes:" + dishes.toString());
    }

    public boolean remove(String dishName) {
        synchronized(this) {
            while(dishes.size()==0) {
                String name = Thread.currentThread().getName();
                System.out.println(name+" is waiting.");
                try { Thread.sleep(500);} catch(InterruptedException e) {}
            }

            for(int i=0; i<dishes.size();i++)
                if(dishName.equals(dishes.get(i))) {
                    dishes.remove(i);
                    return true;
                }
        } // synchronized

        return false;
    }

    public int dishNum() { return dishNames.length; }
}

public class _17_1_Wait_Notify {
    public static void main(String[] args) throws Exception {
        Table table = new Table(); // 여러 쓰레드가 공유하는 객체

        new Thread(new Cook(table), "COOK").start();
        new Thread(new Customer(table, "donut"),  "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        Thread.sleep(5000);
        System.exit(0);
    }
}
// 문제가 발생하는 이유: 음식이 없을 때 손님이 Table 의 lock 을 쥐고 안 놓고 있기 때문.
//  "나는 음식이 나올 때까지 테이블을 붙잡고 있겠어."
// 문제는 테이블에 lock 이 걸려 있어서 요리사가 음식을 놓을 수도 없다.