package ch04_IfAndRepeat;

public class _06_Break_Continue {
    public static void main(String[] args) {
        // break 문과 continue 문 모두 그 자체가 명령문이기 때문에
        // break; continue; 이런 식으로 바로 뒤에 세미콜론(;)을 붙인다.

        // break 문은 switch 문에서 살펴보았지만 다른 반복문에도 사용되어 반복문을 벗어나는 데에 사용된다.

        int sum = 0;
        int i = 0;

        while (true) {
            if (sum > 100) { break; }
            ++i;
            sum = sum + i;
            System.out.println("sum = " + sum);
        }


        // continue 문은 자신이 포함된 반복문의 끝으로 이동하여 다음 반복으로 넘어간다.
        // 전체 반복 중 특정 조건에서 반복을 건너뛸 때 유용하다.

        for (int j = 1; j <= 10; j++) {
            if (j % 3 == 0) { continue; }       // j가 3의 배수일 경우 명령문을 수행하지 않고 다음 반복으로 건너 뜀.
            System.out.print(j + " ");          // 1 2 4 5 7 8 10    (3, 6, 9 가 무시됨)
        }
    }
}
