package ch04_IfAndRepeat;

import java.util.Scanner;

public class _02_Switch {
    public static void main(String[] args) {

        // switch 문: 처리해야 하는 경우의 수가 많을 때 사용하면 유용한 조건문.
        // 각 case 마다 결과를 하나만 나오게 하고 싶으면 break 문을 작성해주어야 한다.
        // break 문을 작성하지 않으면 break 가 나오기 전 까지의 모든 다음 케이스들이 실행된다.
        // 마지막에는 default 를 적어주며, 보통 조건식이 일치하지 않을 때 실행할 내용들을 작성한다.

        // switch 문의 조건식 안에 들어갈 값은 정수, 문자, 문자열 이 세 가지만 허용되며,
        // case 를 중복되지 않게 작성해야 한다.

        Scanner scanner = new Scanner(System.in);
        System.out.print("1부터 7까지 숫자를 입력해보세요: ");
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                System.out.println("당신은 바보이며, 이름은 일꿍이입니다!");
                break;

            case 2:
                System.out.println("당신은 바보이며, 이름은 이뚱이입니다!");
                break;

            case 3:
                System.out.println("당신은 바보이며, 이름은 삼똥이입니다!");
                break;

            case 4:
                System.out.println("당신은 바보이며, 이름은 사삑이입니다!");
                break;

            case 5:
                System.out.println("당신은 바보이며, 이름은 오깍이입니다!");
                break;

            case 6:
                System.out.println("당신은 바보이며, 이름은 육짱이입니다!");
                break;

            case 7:
                System.out.println("당신은 천재이며, 이름은 Goodman 입니다!");
                break;

            default:
                System.out.println("당신은 1부터 7까지의 숫자도 모르는 바보입니다!");
        }


        System.out.print("숫자를 입력하시면 입력하신 숫자의 월이 한국에서 어떤 계절인지 말씀드립니다: ");
        int month = scanner.nextInt();
        switch(month) {
            case 12:
            case 1:
            case 2:
            case 3:
                System.out.println("입력하신 " + month + "월은 한국에서 겨울에 해당합니다.");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("입력하신 " + month + "월은 한국에서 봄에 해당합니다.");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("입력하신 " + month + "월은 한국에서 여름에 해당합니다.");
                break;
            case 10:
            case 11:
                System.out.println("입력하신 " + month + "월은 한국에서 가을에 해당합니다.");
                break;
            default:
                System.out.println("올바르지 않은 입력값입니다. 1 ~ 12 숫자 중에 궁금하신 달의 숫자를 입력해주세요.");
        }
    }
}
