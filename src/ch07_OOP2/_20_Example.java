package ch07_OOP2;
import java.awt.*;
import java.awt.event.*;

// 처음상태는 아래와 같았다.
//class Ex7_18 {
//    public static void main(String[] args) {
//        Button b = new Button("Start");
//        b.addActionListener(new EventHandler());
//    }
//}
//
//class EventHandler implements ActionListener {
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("ActionEvent occurred!!!");
//    }
//}

class Ex7_18 {
    public static void main(String[] args) {
        Button b = new Button("Start");
        b.addActionListener(new ActionListener() {   // 익명클래스니까 기존 클래스이름 없애고 조상껄로 대체
            public void actionPerformed(ActionEvent e) {  // 내용물은 그대로 복붙
                System.out.println("ActionEvent occurred!!!");
            }
        });     // 이렇게, 클래스의 정의와 객체 생성을 동시에 하는 예제를 살펴보았다.
    }
}

public class _20_Example {
}
