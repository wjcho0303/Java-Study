package ch09_UsefulPackages;

// Math 클래스는 수학 관련 static method 의 집합이다. iv가 없기 때문에 객체를 만들 필요도 없다.

public class _09_Math {
    public static void main(String[] args) {
        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 1번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("Math.E = " + Math.E);
        System.out.println("Math.PI = " + Math.PI);


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 2번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // static long round(value)
        // 입력한 숫자 데이터를 소수점 첫째 자리에서 반올림하여 long 타입으로 반환
        int intNumber = 1700;
        double doubleNumber = 90.7552;
        double doubleNumber2 = -50.285221;
        System.out.println("doubleNumber = " + doubleNumber);
        System.out.println("doubleNumber2 = " + doubleNumber2);
        System.out.println("Math.round(doubleNumber) = " + Math.round(doubleNumber));


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 3번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // static double ceil(value)
        // 입력한 숫자 데이터를 소수점 첫째 자리에서 올림하여 double 타입으로 반환
        System.out.println("doubleNumber = " + doubleNumber);
        System.out.println("Math.ceil(doubleNumber) = " + Math.ceil(doubleNumber));


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 4번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // static type abs(type)
        // 입력한 타입의 숫자 데이터를 절대값(양수)으로 반환. 입력한 매개변수의 타입을 그대로 따른다.
        System.out.println("doubleNumber2 = " + doubleNumber2);
        System.out.println("Math.abs(doubleNumber2) = " + Math.abs(doubleNumber2));


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 5번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // static double floor(type number)
        // 입력한 숫자 데이터를 소수 첫째 자리에서 버림하여 double 타입으로 반환
        System.out.println("doubleNumber = " + doubleNumber);
        System.out.println("intNumber = " + intNumber);
        System.out.println("Math.floor(doubleNumber) = " + Math.floor(doubleNumber));
        System.out.println("Math.floor(intNumber) = " + Math.floor(intNumber));


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 6번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // static double max/min(type number1, type number2)
        // 입력한 숫자 데이터들을 비교하여 더 큰/더 작은 값을 반환.
        // 표현 범위가 더 넓은 타입으로 반환하기 때문에 일반적으로 double 타입으로 반환
        // 단, 타입이 같은 숫자 데이터끼리 비교할 경우 해당 타입으로 반환
        System.out.println("Math.max(101L, 100.5) = " + Math.max(101L, 100.5));
        System.out.println("Math.max(40.25f, 40.24) = " + Math.max(40.25f, 40.24));


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 7번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // static double random()
        // 0.0 ~ 1.0 범위의 임의의 double 값 반환. 0은 포함되지만 1은 포함되지 않는다.
        System.out.println("Math.random() = " + Math.random());


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 8번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // static double rint(double number)
        // 입력한 double 값과 가장 가까운 정수를 double 타입으로 반환
        // 단, .5인 경우 절대값 기준으로 더 가까운 짝수쪽로 반환
        System.out.println("Math.rint(-2.5) = " + Math.rint(-2.5));
        System.out.println("Math.round(-2.5) = " + Math.round(-2.5) + "\n");
        System.out.println("Math.rint(-1.5) = " + Math.rint(-1.5));
        System.out.println("Math.round(-1.5) = " + Math.round(-1.5) + "\n");
        System.out.println("Math.rint(0.5) = " + Math.rint(0.5));
        System.out.println("Math.round(0.5) = " + Math.round(0.5) + "\n");
        System.out.println("Math.rint(1.5) = " + Math.rint(1.5));
        System.out.println("Math.round(1.5) = " + Math.round(1.5) + "\n");
        System.out.println("Math.rint(2.5) = " + Math.rint(2.5));
        System.out.println("Math.round(2.5) = " + Math.round(2.5) + "\n");
        System.out.println("Math.rint(1.4) = " + Math.rint(1.4));
        System.out.println("Math.round(1.4) = " + Math.round(1.4) + "\n");
        System.out.println("Math.rint(25.32) = " + Math.rint(25.32));
        System.out.println("Math.round(25.32) = " + Math.round(25.32) + "\n");


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 9번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // static double sqrt(type)
        // 입력한 타입의 제곱근 값을 double 타입으로 반환
        System.out.println("Math.sqrt(4) = " + Math.sqrt(4));


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 10번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // static double pow(number1, number2)
        // 입력한 타입의 number1 숫자를 number2 만큼 거듭제곱하여 double 타입으로 반환
        System.out.println("Math.pow(2, 4) = " + Math.pow(2, 4));
        System.out.println("Math.pow(2, 4.1) = " + Math.pow(2, 4.1));
        System.out.println("Math.pow(1.5, 2.7) = " + Math.pow(1.5, 2.7));


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 11번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // static double log(number)
        // 입력한 숫자 데이터의 자연로그 값을 double 타입으로 반환
        System.out.println("Math.log(Math.E) = " + Math.log(Math.E));


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 12번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // static double log10(number)
        // 입력한 숫자 데이터의 상용로그 값을 double 타입으로 반환
        System.out.println("Math.log10(1000) = " + Math.log10(1000));
    }
}
