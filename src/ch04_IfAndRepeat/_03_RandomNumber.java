package ch04_IfAndRepeat;

public class _03_RandomNumber {
    public static void main(String[] args) {
        // Math.random() : 0.0 과 1.0 사이의 임의의 double 값을 반환
        // 반환하는 값의 범위에 0은 포함되지만 1은 포함되지 않는다.

        // 이것을 활용하여 원하는 범위의 숫자를 얻을 수 있다.
        // 예를 들어, 5 ~ 10 사이의 정수(5와 10도 포함)를 10개 얻고 싶다고 하자.

        int a, b;
        int i = 0;
        while(i < 10) {
            a = (int)(Math.random()*10+1);
            b = (int)(Math.random()*5);
            if(a-b >= 5) {
                System.out.println(a-b);
                i++;
            }
        }

        // 위와 같은 조건의 경우 for 문 보다는 while 문이 더 논리를 구사하기 편리하다.
        // 내부에 if 문을 사용하여 i++ 처리해줄 수 있기 때문이다.


        // 결과를 도출시킬 조건이 복잡할 경우에는 while 문을 사용하는 것이 좋고,
        // 결과값의 조건은 별로 안 중요하고 몇 번 반복시킬 것인지가 더 중요한 경우에는 for 문을 사용하는 것이 좋다.


        // 1부터 N 까지 난수 만들기
        // (int)(Math.random()*N + 1)

        for (int j = 0; j < 10; j++) {
            i = (int)(Math.random()*10 + 1);
            System.out.println("i = " + i);
        }
    }
}
