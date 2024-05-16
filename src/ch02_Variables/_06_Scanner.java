package ch02_Variables;

import java.util.Scanner;

public class _06_Scanner {
    public static void main(String[] args) {
        // Scanner 란, 화면으로부터 데이터를 입력받는 기능을 제공하는 클래스이다.
        // Scanner 를 사용하기 위해서는 Scanner 객체를 생성해야 한다.

        Scanner scanner = new Scanner(System.in);

        // 매개변수로는 System 클래스의 in 필드가 입력된다. 이 필드의 타입은 InputStream 타입이다.
        // InputStream 개체는 화면 입력을 위한 객체라고 생각하면 된다.
        // 스캐너 클래스는 화면 뿐만 아니라 파일로부터 입력을 받을 수도 있는데, 여기서는 화면을 통해 입력을 받기 때문에
        // System.in 을 매개변수로 입력한 것이다.

//        int num1 = scanner.nextInt();
//        int num2 = scanner.nextInt();
//
//        System.out.println("num1 = " + num1);
//        System.out.println("num2 = " + num2);

        // 화면에서 입력받은 정수를 변수 num 에 저장한다. nextInt() 라는 메서드는 정수를 입력 받게 해주는 메서드이다.
        // 만약 실수를 입력받고 싶다면 nextDouble() 메서드를 사용하고,
        // 한 행의 문자열을 입력받고 싶다면 nextLine() 메서드를 사용한다.

        String str = scanner.nextLine();
        int num = Integer.parseInt(str);
        System.out.printf("str = '%s'%n", str);
        System.out.printf("num = %d%n", num);
        
        double d = scanner.nextDouble();
        System.out.println("d = " + d);

        // System.in 과 같은 화면 입력 객체는 기본적으로 JVM 에 의해 자동으로 관리되기 때문에 닫을 필요가 없긴 하다.
        // 그러나 수동으로 닫을 수 있으며, 아래와 같이 꼼꼼하게 닫아주는 것이 더 권장된다.
        scanner.close();
    }
}
