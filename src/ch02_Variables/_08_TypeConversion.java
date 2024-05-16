package ch02_Variables;

public class _08_TypeConversion {
    public static void main(String[] args) {

        // 숫자로 된 문자열을 숫자(정수, 실수)로 변환하기 ★★
        // Integer.parseInt("3");       --> 3
        // Double.parseDouble("3.14");  --> 3.14

        // 문자열(string)을 문자(char)로 변환하기 ★★
        // "342".charAt(0)                --> '3'
        // "342".charAt(1)                --> '4'
        // "342".charAt(2)                --> '2'


        // 문자, 문자열, 숫자의 연산
        String str = "3";

        // 참고로, '0'이라는 문자의 문자코드 값은 48이고, '3' 문자의 문자코드 값은 51이다.
        System.out.println('3' - '0');                      // 3    문자를 연산시키면 문자코드가 가진 정수값이 계산된다.
        System.out.println('3' - '0' + 1);                  // 4    문자를 연산시키면 문자코드가 가진 정수값이 계산된다.

        System.out.println(Integer.parseInt("3") + 1);   // 4    parseInt 메서드를 이용해 정수로 형변환
        System.out.println("3" + 1);                        // 31   문자열과 숫자를 연산하면 숫자가 문자열로 흡수된다.

        System.out.println(3 + '0');                        // 51   문자를 연산시키면 문자코드가 가진 정수값이 계산된다.
        System.out.println('3' + 1);                        // 52   문자를 연산시키면 문자코드가 가진 정수값이 계산된다.

        System.out.println((char)('3' + 1));                // 4    문자코드 정수값인 52를 char 로 형변환시켜 '4'를 출력

    }
}
