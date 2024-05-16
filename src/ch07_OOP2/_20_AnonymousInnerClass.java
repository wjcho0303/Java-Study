package ch07_OOP2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

// 익명 내부 클래스는 이름이 없는 일회용 클래스이다. 딱 한 번 객체를 생성해서 쓰는 용도이기 때문에 굳이 이름을 안 짓는다.
// 사용할 때는 클래스 정의와 인스턴스 생성을 동시에 하면 된다.



public class _20_AnonymousInnerClass {
    public static void main(String[] args) {

        // 익명 내부 클래스를 생성하는 문법은 다음과 같이 new 키워드와 조상 클래스의 생성자를 사용한다.
        Object anonymousClassInstance = new Object() {
            public void anonymousClassInstanceMethod() {
                System.out.println("This is anonymousClassInstanceMethod.");
            }
        };
        // 익명 내부 클래스는 중괄호 {}로 감싸인 부분에 클래스의 내용을 정의한다.
        // 익명 클래스이기 때문에 클래스의 이름은 없다. 그러나 메서드의 이름은 있다.
        // 그리고 익명 내부 클래스는 다형성을 이용하기 때문에 항상 조상의 타입이다.
        // 참고로, 조상 클래스의 타입이 올 수도 있고 구현 인터페이스의 타입이 올 수도 있다.

        try {
            // 익명 내부 클래스의 메서드 호출
            ((Object) anonymousClassInstance).getClass().getDeclaredMethods()[0].invoke(anonymousClassInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");


        Button button = new Button("Start");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent occurred!!!");
            }
        });

        // Button 클래스는 AWT나 Swing과 같은 GUI 프로그래밍에서 사용되는 버튼을 나타내는 클래스이다.
        // 이 예제에서는 Button 클래스의 인스턴스를 생성하고,
        // addActionListener 메서드를 사용하여 버튼의 클릭 이벤트를 처리하는 리스너를 등록하고 있다.

        // 등록된 리스너는 익명 내부 클래스로 정의되어 있으며, ActionListener 인터페이스를 구현하여
        // 버튼의 클릭 이벤트가 발생했을 때 실행될 동작을 정의하고 있다.

        // 버튼을 클릭하면 AWT 나 Swing 과 같은 GUI 라이브러리가 이벤트를 감지하고,
        // 등록된 리스너의 actionPerformed 메서드를 호출하여 "ActionEvent occurred!!!" 메시지가 콘솔에 출력된다.
    }
}
