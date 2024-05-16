package ch05_ArrayAndString;

import java.util.Arrays;

public class _01_Array {
    public static void main(String[] args) {
        // 배열 : 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것


        // 이렇게 같은 타입의 변수가 여러 개 있다고 하자.
        int score1, score2, score3, score4, score5;
        // 5개는 이렇게 일일히 써줘도 크게 문제가 없어 보인다.



        // 그러나 같은 타입의 변수가 1000개, 10000개 정도가 된다면 어떻게 될까?
        // 더 이상 일일히 작성할 수 없게 된다.
        // 한 번에 다루는 방법은 간단하다. 아래와 같이 하면 된다.

        int[] score = new int[5];

        // int[] 는 배열에 들어간 원소들의 타입이 모두 int 타입이라는 뜻이다.
        // 만약 String[] 이었다면 배열의 원소들이 전부 String 타입일 것이다.
        // score 는 여기에서 참조변수라고 부른다. 참조변수를 통해 각 배열의 원소에 접근할 수 있다.
        // 배열은 객체이기 때문에 new 키워드를 사용하여 배열 인스턴스를 생성하며,
        // 앞에서 사용했던 대괄호 안에 [개수] 를 입력하면 배열의 길이가 결정된다.
        // 그리고, 배열의 원소들을 담는 메모리 상의 저장공간은 연속적으로 붙어있다.



        // 그리고 필요한 위치는 다음과 같이 불러낼 수 있다.
        // 예를 들어 맨 세 번째 score 값이 60 이라면 아래와 같이 하면 된다.
        score[2] = 60;
        // 참조변수 score 에다가 대괄호에 감싸여진 index 번호를 통해 해당 위치의 배열 원소를 불러올 수 있는 것이다.



        // 배열의 선언과 생성
        // 배열을 선언은 배열을 다루기 위한 참조변수가 만들어지는 것을 의미한다.
        // 배열의 생성은 실제 배열 인스턴스가 만들어지고, 이 배열 인스턴스의 원소들이 메모리 상에서 공간을 차지하는 것을 의미한다.



        // 배열의 선언 스타일은 두 가지 방법이 있다. 하나는 Java 스타일, 다른 하나는 C언어 스타일
        // 1) Java 스타일:     int[] score;        String[] names;
        // 2) C언어 스타일:     int score[];        String names[];
        // 이 참조변수가 메모리 주소를 대체하는 이름으로 사용된다. (score = 0x100)
        // Java 언어를 사용할 때는 1) 방식으로 하는 것이 권장된다.
        // int[] 라고 하는 것은 객체 지향에서 객체의 타입이 중요하듯이 이것 자체도 하나의 type 이기 때문이다.



        // 배열의 생성은 다음과 같다: new 키워드가 핵심이다.
        // score = new int[길이];
        // 이렇게 new 키워드를 통해 배열을 생성하면 이제는 배열이 메모리 상에서 공간을 실제로 차지하게 된다.
        // 그리고 배열의 길이가 정해지면 그 길이를 바꿀 수 없다.
        // 배열은 전체 배열이 메모리 상에서 연속적인 공간을 차지해야 하기 때문에 한 번 정해졌는데
        // 배열의 길이를 늘리려 할 때 연속된 공간을 늘려야 하는데, 그 공간이 이미 다른 곳에서 차지하고 있을 수도 있다.
        // 그렇게 되면 배열이 메모리를 불연속적으로 차지해야 하는데 Java 의 일반 배열은 그렇지 않다.
        // 길이가 바뀔 수 있는 배열을 사용하려면 일반 배열이 아닌 다른 배열을 사용해야 한다.



        // 배열의 길이값 반환하는 방법: 참조변수명에  .length 를 붙여서 반환받을 수 있다.
        for (int i = 0; i < score.length; i++) {
            System.out.print(score[i] + "  ");      // 0  0  60  0  0
        }



        // 배열 값을 초기화하는 방법 :
        // 1) { } 블록을 이용한 방법
        int[] score6 = new int[] {40, 70, 35, 29, 61, 97};  // new int[] 작성 가능. 거의 사용되지 않음
        int[] score7 = {50, 60, 65, 70, 80, 95};            // new int[] 생략 가능. 가장 많이 사용되는 방식

        // 단, 아래 처럼 할 수는 없다.
        int[] score8;
/*      score8 = {50, 60, 65, 70, 80, 95};          (에러 때문에 주석)       */
        // new int[] 를 생략하려면 한 줄에 선언과 생성을 모두 해야한다.


        // 2) 배열[인덱스값] 에 일일히 대입하는 방법
        int[] score9 = new int[5];
        score9[0] = 10;
        score9[1] = 20;
        score9[2] = 30;
        score9[3] = 40;
        score9[4] = 50;
        // 이렇게 일일히 수작업으로 초기화하는 방법은 거의 사용되지 않고,
        
        // 원소들의 값이 일정한 규칙이 있으면서 배열의 길이가 클 경우에 반복문에서는 많이 사용된다.
        double[] score10 = new double[120];
        for (int i = 0; i < score10.length; i++) {
            score10[i] = 10 + 0.75 * i;
            System.out.printf("[%3d]번 학생 = %.1f%n", i+1, score10[i]);
        }

        
        class Car {
        }


        // 배열 객체 자체의 출력 :
        // @ 앞부분은 배열의 타입을 의미한다. 기본형 타입의 경우 정해져 있으며, 참조형 타입은 클래스가 존재하는 위치를 포함한다.
        // @ 뒷부분은 배열 객체의 메모리 상 주소값을 나타낸다.
        String[] strArr = new String[0];
        System.out.println("strArr = " + strArr);           // strArr = [Ljava.lang.String;@6193b845

        float[] floatArr = new float[0];
        System.out.println("floatArr = " + floatArr);       // floatArr = [F@2e817b38

        double[] doubleArr = new double[0];
        System.out.println("doubleArr = " + doubleArr);     // doubleArr = [D@c4437c4

        byte[] byteArr = new byte[0];
        System.out.println("byteArr = " + byteArr);         // byteArr = [B@433c675d

        short[] shortArr = new short[0];
        System.out.println("shortArr = " + shortArr);       // shortArr = [S@3f91beef

        int[] intArr = new int[0];
        System.out.println("intArr = " + intArr);           // intArr = [I@1a6c5a9e

        long[] longArr = new long[0];
        System.out.println("longArr = " + longArr);         // longArr = [J@37bba400

        boolean[] booleanArr = new boolean[0];
        System.out.println("booleanArr = " + booleanArr);   // booleanArr = [Z@179d3b25
        
        Car[] carArr = new Car[0];
        System.out.println("carArr = " + carArr);           // carArr = [L_chap05._01_Array$1Car;@254989ff
        
        
        // 예외적으로, char 타입의 경우에는 배열을 출력해도 원소들이 출력된다.
        // 단, 출력 내용에 오직 해당 배열만 존재하는 경우에만 그렇다.
        char[] charArr = {'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd', '!'};
        System.out.println(charArr);                        // helloworld!
        System.out.println("charArr = " + charArr);         // charArr = [C@5d099f62


        // 배열의 원소들을 반복문을 사용하지 않고도 출력하는 방법이 무엇이 있을까?
        // 바로 Arrays.toString() 메서드를 이용하는 방법이다.
        // 단 Arrays.toString() 은 [ ] 대괄호 안에 감싸주고, 원소 사이에 콤마(,) 구분자를 추가하는 부가기능이 있다.
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(floatArr));
        System.out.println(Arrays.toString(doubleArr));
        System.out.println(Arrays.toString(byteArr));
        System.out.println(Arrays.toString(shortArr));
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(longArr));
        System.out.println(Arrays.toString(booleanArr));
        System.out.println(Arrays.toString(carArr));
        System.out.println(Arrays.toString(charArr));
    }
}
