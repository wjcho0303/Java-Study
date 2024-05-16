package ch06_OOP1;

import java.util.Scanner;

class MyMath {
    // 메서드의 return 문은 다음의 일을 수행한다.
    // 1. 값을 반환
    // 2. 실행중인 메서드를 종료
    // 3. 호출한 곳으로 "복귀"

    // 아래와 같이 void 형 메소드에도 return 을 쓸 수 있다.
    static void printGugudan(int dan) {
        if (!(2 <= dan && dan <= 9)) {
            System.out.printf("입력하신 숫자는 %d 입니다. 해당 숫자는 구구단 숫자가 아닙니다.%n", dan);
            System.out.println("2에서 9까지의 숫자를 입력해주세요.");
            return ;  // 조건 만족 여부에 따라 중간에 메소드를 정지할 경우 아무 것도 입력하지 않고 return 할 수 있다.
        }
        for (int i = 1; i <= 9 ; i++) {
            System.out.printf("%d * %d = %d%n", dan, i, dan*i);
        }
        return;   // 지금은 썼지만 사실 void 메소드는 마지막 return 을 쓰지 않아도 자동으로 입력된 것처럼 된다.
    }

    // 사실은 이렇게 void 메소드의 마지막에도 사실 return 을 써야 한다.
    // 그러나 void 형의 경우 메서드가 작업을 마쳤을 때 컴파일러가 자동으로 return 을 추가하기 때문에
    // return 을 적어주지 않아도 알아서 종료하고 복귀하는 것이다.

    //  int max(int a, int b) {       이 메소드의 경우 "return 이 없다"는 오류가 발생한다. 어? 있는데 왜 없다고 하지?
    //      if (a > b)                왜냐하면 이 경우는 조건이 참일 때만 return 이 존재하고 거짓일 때는 return 이 존재하지
    //          return a;             않기 때문이다.
    //  }

    // 그래서 이런 경우에는 아래와 같이 작성해야 한다:

    static int maxNumber(int a, int b) {
        if (a > b) {
            return a;
        }
        else {
            return b; // 이렇게 만족조건(if)과 불만족조건(else) 전부 return 을 달아줘야 한다.
        }             // 그렇게 하지 않으면 return 을 찾을 수 없다는 오류가 발생한다.
    }
}

public class _06_Return {
    public static void main(String[] args) {
        MyMath.printGugudan(7);   // static 메소드이기 때문에 클래스명으로 메서드를 호출한 모습이다.
        Scanner scanner = new Scanner(System.in);

        System.out.println("===============");
        System.out.print("보기 원하는 구구단 숫자를 입력하세요 > ");

        int input = scanner.nextInt();
        MyMath.printGugudan(input);  // 12는 메소드 내부 if 조건에 만족되지 않기 때문에 아무 것도
                                     // 실행하지 않고 return 되버린다.

        System.out.println("===============");
        System.out.println(MyMath.maxNumber(5,3));  // static 메소드이기 때문에 클래스명을 리모콘으로 하고 호출함

        scanner.close();
    }
}
