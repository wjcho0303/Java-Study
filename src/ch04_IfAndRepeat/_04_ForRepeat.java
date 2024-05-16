package ch04_IfAndRepeat;

public class _04_ForRepeat {
    public static void main(String[] args) {

        // 증감식은 여러 가지 방식으로 작성할 수 있다.

        System.out.println("------i = i+3--------");
        for (int i = 0; i < 15; i = i+3) {
            System.out.println(i);      // 0  3  6  9  12
        }

        System.out.println("------i = i+4--------");
        for (int i = 0; i < 15; i = i+4) {
            System.out.println(i);      // 0  4  8  12
        }

        System.out.println("------i += 2--------");
        for (int i = 0; i < 15; i += 2) {
            System.out.println(i);      // 0  2  4  6  8  10  12  14
        }

        System.out.println("------i = 1; i *= 2 ----");
        for (int i = 1; i < 15; i *= 2) {
            System.out.println(i);      // 1  2  4  8
        }


        // 하나의 for 문에 여러 개의 변수를 동시에 선언할 수도 있고,
        // 반복 조건에 각종 논리 연산자를 사용할 수도 있다.
        for (int i = 0, j = 10; (i < 6) && (j > 3); i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }

        // 무한반복문이 되는 조건은 반복 조건문이 항상 true 인 경우이다.
        /*
        for (; true;) {
            System.out.println("출력1");
        }
        */

        // 이렇게 조건문에 아무 것도 작성하지 않아도 항상 true 로 간주하여 무한반복한다.
                            /*
        for (;;) {
            System.out.println("출력2");
        }
                            */



        // for 문의 반복 조건에 외부의 변수가 들어와도 상관 없다.
        int sum = 0;
        int lasti = 0;
        for (int i = 1; sum < 100; i++) {
            System.out.println("i = " + i);
            sum = sum + i;
            lasti = i;
        }
        sum = sum - lasti;
        System.out.println("sum = " + sum);
        // sum 의 값이 105 가 된 이후에 반복문을 탈출하고,
        // 그 때의 i 를 저장해둔 후 100 이 넘기 전의 sum 값을 구할 수 있다.




        // for 문 안에 또 for 문을 넣을 수 있다. 중첩 if 문이 있듯이 중첩 for 문도 있는 것이다.
        for (int i = 2; i <= 9 ; i++) {
            System.out.println("-------" + i + "단 -------");
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " x " + j + " = " + i*j);
            }
            System.out.println();
        }
        // 보통 삼중 까지 가는 일은 없고 이중 중첩 for 문은 자주 사용된다.
    }
}
