package ch04_IfAndRepeat;

import java.util.Scanner;

public class _01_Condition_Repeat {
    public static void main(String[] args) {
        // 조건문: if 문, switch 문 - 조건을 만족할 때만 블럭 { } 구현부 수행
        // 블럭을 사용하지 않은 경우 다음에 있는 하나의 행만 구현부로 인식한다.

        Scanner scanner = new Scanner(System.in);

        System.out.print("score 값을 입력하세요: ");
        int score = scanner.nextInt();
        if (score > 100 || score < 0) {
            System.out.print("결과 메시지: " );
            System.out.println("score 값이 올바르지 않습니다.");
        } else if (score >= 60) {
            System.out.print("결과 메시지: " );
            System.out.println("합격입니다.축하드립니다.");
        } else {
            System.out.print("결과 메시지: " );
            System.out.println("불합격 ㄷㄷ;;");
        }

        // if ~ else if ~ else 문은 전체가 한 묶음이며, 조건에 해당하는 구현부가 하나만 선택되어 실행되며,
        // 선택된 구현부가 실행된 후에는 else 블록까지 포함한 전체 묶음을 모두 빠져나온다.

        // 참고: 중첩 의문문은 if 문의 구현부 안에 또 중첩으로 if 문을 입력하는 것으로,
        // 내부 조건문에 있는 조건문은 외부 조건문을 기본적으로 무조건 만족하는 상태에서 내부 조건문을 검사한다.
        // 그러므로 내부 조건문을 만족한다는 것은 외부 조건문과 내부 조건문 둘 다를 만족한다는 의미이다.


        // 반복문: while 문, for 문 - 조건을 만족하는 동안에만 블럭 { } 구현부 수행

    }
}
