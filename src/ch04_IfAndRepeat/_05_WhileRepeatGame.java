package ch04_IfAndRepeat;

import java.util.Scanner;

public class _05_WhileRepeatGame {
    public static void main(String[] args) {

        // while 반복문은 반복의 실제 시행 횟수는 상관 없고, 조건을 정교하게 작성하고 싶을 때 사용한다.
        // 또, do-while 문도 있다.
        int i = 5;
        while (i-- != 0) {
            System.out.println(i + " hello!");
        }


        // 각 자리의 수를 모두 더하기
        int num = 0;
        int sum = 0;

        System.out.print("숫자를 입력하세요 > ");
        Scanner scanner = new Scanner(System.in);

        String tmp = scanner.nextLine();
        num = Integer.parseInt(tmp);

        while(num != 0) {
            // num 을 10으로 나눈 나머지를 sum 에 더하기. 즉, 일의 자리 수만 빼내는 것.
            sum = sum + num%10;
            System.out.printf("sum = %2d,  num = %d%n", sum, num);

            // num 에 num 을 10으로 나눈 후 소수점을 버린 값을 저장 (자연수)
            num = num / 10;
        }

        // do - while 문은 do { } while ( 조건 ) ; 구조로 되어 있다.
        // while 조건문이 구현부 다음에 온다는 것이 기본 while 문과의 차이점이다.

        do {
            System.out.println("do 블록에 있는 출력문입니다. while 조건문의 앞에 있습니다.");
        } while (false);        // do 블록에 있는 출력문입니다.


        int answer = (int)(Math.random()*100 + 1);
        Scanner scanner2 = new Scanner(System.in);

        int input = 0;
        int count = 0;

        System.out.println("----------------------------");
        System.out.println("6번의 기회를 드리겠습니다. 1과 100 사이에 정답이 있습니다.");
        do {
            System.out.print("1과 100 사이의 정수를 입력하세요. > ");
            input = scanner2.nextInt();

            if (input > answer) {
                if (count == 5) {
                    System.out.println("더 이상 기회가 남지 않았습니다.");
                } else {
                    System.out.println("더 작은 수로 시도해보세요.");
                    System.out.println("기회는 " + (5 - count) + " 회 남았습니다.");
                }
                count++;
            } else if (input < answer) {
                if (count == 5) {
                    System.out.println("더 이상 기회가 남지 않았습니다.");
                } else {
                    System.out.println("더 큰 수로 시도해보세요.");
                    System.out.println("기회는 " + (5 - count) + " 회 남았습니다.");
                }
                count++;
            }
        } while((answer != input) && (count < 6));

        if (count == 6) {
            System.out.println("아쉽게도 주어진 기회 안에 정답을 맞추지 못했습니다.");
            System.out.println("정답은 " + answer + " 이었습니다.");
        } else if (count < 6) {
            System.out.println("정답을 맞추셨습니다. 축하합니다.");
            System.out.println("정답은 " + answer + " 이었습니다.");
        }
    }
}
