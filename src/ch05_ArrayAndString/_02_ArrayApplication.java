package ch05_ArrayAndString;

import java.util.Arrays;

public class _02_ArrayApplication {
    public static void main(String[] args) {
        int sum = 0;            // 총점
        float average = 0f;     // 평균

        int[] scores = {100, 88, 100, 100, 90};

        for (int i = 0; i < scores.length; i++) {
            sum = sum + scores[i];
        }
        average = sum / (float)scores.length;

        System.out.println("sum = " + sum);             // sum = 478
        System.out.println("average = " + average);     // average = 95.6


        System.out.println("-----------------------------");


        int[] scores2 = {79, 88, 91, 33, 100, 55, 95};
        int max = scores2[0];
        int min = scores2[0];

        for (int i = 1; i < scores2.length; i++) {
            if(scores2[i] > max) {              // 기존 max 보다 크면 그 값을 max 로 대체
                max = scores2[i];
            } else if (scores2[i] < min) {      // 기본 min 보다 작으면 그 값을 min 으로 대체
                min = scores2[i];
            }
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);


        System.out.println("-----------------------------");
        // 배열의 원소 위치 섞기 - Math.random()과 tmp 를 이용한 변수 바꾸기
        String[] cardNumber = {"K", "Q", "J", "9", "8", "7", "6", "5", "4", "3", "2", "A"};

        for (int i = 0; i < 100; i++) {
            int n = (int)(Math.random()*(cardNumber.length));
            String tmp = cardNumber[0];

            cardNumber[0] = cardNumber[n];
            cardNumber[n] = tmp;
        }
        System.out.println(Arrays.toString(cardNumber));
        // 임의의 두 카드를 뽑아서 위치를 서로 바꾸는 행위를 100번 반복한 결과
        // ex) [7, 8, A, Q, 9, 4, J, 2, 6, K, 3, 5]
        // ex) [Q, A, 4, 2, 8, 6, K, J, 7, 5, 3, 9]
        // ...


        System.out.println("-----------------------------");
        // 로또 번호 6개 뽑기 (1 ~ 45 숫자)
        int[] lotto = new int[45];
        int[] selectedNumArr = new int[6];

        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = i+1;
        }

        int selectedNum = 0;
        int tmp = lotto[0];

        for (int i = 0; i < 6; i++) {
            selectedNum = (int)(Math.random()*45);
            tmp = selectedNumArr[i];
            selectedNumArr[i] = lotto[selectedNum];
        }
        System.out.print("로또 당첨 번호 6개를 뽑겠습니다! ");
        System.out.println("중복된 숫자가 있을 경우 다시 돌려주십시오.");
        System.out.println("결과 > " + Arrays.toString(selectedNumArr));
    }
}
