package ch05_ArrayAndString;

import java.util.Arrays;
import java.util.Scanner;

public class _04_TwoDimensionalArray {
    public static void main(String[] args) {
        // 1차원 배열은 줄 형태의 데이터 저장 방식이었다.
        // 2차원 배열은 테이블 형태로 데이터를 저장하기 위한 배열이다.

        // 4행 3열의 이차원 배열 테이블 생성
        int[][] score = new int[4][3];
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                score[i][j] = (j+2)*(int)(Math.random()*(50));
                System.out.printf("score[%d][%d] = %d%n", i, j, score[i][j]);
            }
        }



        // Arrays.toString() 을 이용하여 한 행씩 출력하기
        for (int i = 0; i < score.length; i++) {
            System.out.println(Arrays.toString(score[i]));
        }


        int[][] score2 = {
                {100, 100, 100},
                {45, 67, 51},
                {71, 75, 90},
                {80, 100, 95},
                {21, 5, 40}
        };

        int korTotal = 0;
        int engTotal = 0;
        int mathTotal = 0;

        System.out.println("번호   국어   영어    수학    총점    평균");
        System.out.println("=========================================");

        for (int i = 0; i < score2.length; i++) {
            int sum = 0;
            float avg = 0.0f;

            korTotal = korTotal + score2[i][0];
            engTotal = engTotal + score2[i][1];
            mathTotal= mathTotal + score2[i][2];

            System.out.print(" " + (i + 1) + "    ");
            for (int j = 0; j < score2[i].length; j++) {
                sum = sum + score2[i][j];
                avg = (sum / (float)score2[i].length);
                System.out.printf("%3d    ", score2[i][j]);
            }
            System.out.printf("%3d    ", sum);
            System.out.printf("%.1f%n", avg);
        }
        System.out.println("=========================================");



        // 간단한 낱말 퀴즈 만들기
        String[][] questionAndAnswer = {
                {"chair", "의자"},
                {"soap", "비누"},
                {"book", "책"},
                {"food", "음식"},
                {"dog", "개"},
                {"shoes", "신발"},
                {"cloth", "옷"},
                {"money", "돈"},
                {"ball", "공"},
                {"cat", "고양이"},
                {"apple", "사과"},
                {"window", "창문"},
                {"rainbow", "무지개"},
                {"snow", "눈"}
        };

        Scanner scanner = new Scanner(System.in);
        int correct = 0;
        int wrong = 0;

        for (int i = 0; i < questionAndAnswer.length; i++) {
            System.out.printf("다음 단어의 한글 뜻을 맞추어보세요 : %n%s > ", questionAndAnswer[i][0]);
            String answer = scanner.nextLine();
            if(answer.equals(questionAndAnswer[i][1])) {
                System.out.printf("입력하신 내용은 '%s' 입니다. 정답입니다!%n%n", answer);
                correct++;
            } else {
                System.out.printf("입력하신 내용은 '%s' 입니다. 틀렸습니다. 정답은 '%s' 입니다.%n%n", answer, questionAndAnswer[i][1]);
                wrong++;
            }
        }
        System.out.printf("최종 결과를 말씀드리겠습니다. 정답 %d회, 오답 %d회 입니다.%n", correct, wrong);

        if(correct >= 13) {
            System.out.println("우수한 성적을 거두었습니다. 현재의 수준을 유지하기 위해 노력합시다.");
        } else if (correct >= 8) {
            System.out.println("준수한 성적입니다. 조금 더 열심히 하면 더 우수한 성적을 거둘 수 있을 것입니다.");
        } else if (correct < 8) {
            System.out.println("딱히 어려운 단어들이 아닌데 이건 좀;;");
        }

    }

}
