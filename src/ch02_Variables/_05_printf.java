package ch02_Variables;


public class _05_printf {
    public static void main(String[] args) {
    //  println 의 단점은 출력형식을 지정하기 어렵다는 점이다.
    //    1. 실수의 자리수 조절 불가
    //    예를 들어, 10.0/3 을 println 으로 출력하면 3.333333... 으로 길게 출력한다.
        System.out.println(10.0/3); // 3.3333333333333335

    //    2. 또, 모든 정수를 10진수로만 출력한다는 단점도 있다.
        System.out.println(0x1A);   // 26


        // printf() 는 출력형식을 지정할 수 있다.
        System.out.printf("%.2f %n", 10.0/3);  // %.nf 는 소수점 n째 자리까지 나타내라는 뜻
        System.out.printf("%d %n", 0x1A);      // %d 는 십진수로 나타내라는 뜻
        System.out.printf("%X %n", 0x1A);      // %X 는 16진수로 나타내라는 뜻

        // 이렇게 큰 따옴표 안에 있는 % 기호를 이용한 것들을 '지시자'라고 한다.
        // 값을 어떻게 출력할지 printf 메서드에 지시한다는 의미에서 지시자라고 부른다.


        // printf() 메서드에 사용되는 대표적인 지시자들은 다음과 같다:
        // %b       : boolean 형식으로 출력
        System.out.printf("true? or false? : %b %n", true);     // true? or false? : true


        // %d       : 10진법이면서 정수형으로 출력, decimal (d)
        // 표시하고 싶은 자릿수는 %와 d 사이에 숫자를 입력한다.
        System.out.printf("age:%d year:%d %n", 14, 2017);       // age:14 year:2017

        int number = 123;
        System.out.printf("[%4d] %n", number);                  // 자릿수가 부족한 부분은 앞에 공백을 추가해서 맞춘다.
        System.out.printf("[%5d] %n", number);                  // 자릿수가 부족한 부분은 앞에 공백을 추가해서 맞춘다.
        System.out.printf("[%6d] %n", number);                  // 자릿수가 부족한 부분은 앞에 공백을 추가해서 맞춘다.
        System.out.printf("[%05d] %n", number);                 // 자릿수가 부족한 부분은 앞에 0을 추가해서 맞춘다.
        System.out.printf("[%06d] %n", number);                 // 자릿수가 부족한 부분은 앞에 0을 추가해서 맞춘다.
        System.out.printf("[%-5d] %n", number);                 // 자릿수가 부족한 부분은 뒤에 공백을 추가해서 맞춘다.
        System.out.printf("[%-4d] %n", number);                 // 자릿수가 부족한 부분은 뒤에 공백을 추가해서 맞춘다.
        System.out.printf("[%-3d] %n", number);                 // 자릿수가 부족하지 않으므로 그대로 출력
        System.out.printf("[%-2d] %n", number);                 // 자릿수가 부족하지 않으므로 그대로 출력
//        System.out.printf("[%-05d] %n", number);              // -05 이런 형식은 존재하지 않으므로 에러 발생.


        // %o       : 8진법이면서 정수형으로 출력, octal (o)
        System.out.printf("%o %n", 15);                         // 17 ("십칠"이 아니라 "일칠" 이라고 읽는다.)
        System.out.printf("%#o %n", 15);                        // 017 (8진수식 표현)


        // %x, %X   : 16진법이면서 정수형으로 출력, hexa-decimal (x)
        System.out.printf("%x %n", 15);                         // f
        System.out.printf("%#x %n", 15);                        // 0xf (16진수식 표현, 소문자)
        System.out.printf("%#X %n", 15);                        // 0xF (16진수식 표현, 대문자)


        // %f       : 부동 소수점 형식으로 출력. 자릿수를 별도로 지시하지 않을 경우 소수점 6자리까지 표시
        // 표시하고 싶은 자릿수는 %와 f 사이에 .n 을 껴넣으면 반올림하여 출력된다.  %   .n   f  --> %.nf      ex) %.2f
        // %전체자리.소수점 아래자리 f  여기서 참고로 '전체자리'에서 소수점이 한 자리를 차지한다.
        float f = 123.45678906666f;
        System.out.printf("%f %n", f);                    // 123.456787, float 타입은 앞의 7자리까지만 정확하다.
        System.out.printf("%.2f %n", f);                  // 123.46 (반올림)
        System.out.printf("%.3f %n", f);                  // 123.457 (반올림)
        System.out.printf("%.4f %n", f);                  // 123.4568 (반올림)
        System.out.printf("%.5f %n", f);                  // 123.45679 (반올림)


        // 소수점 포함 전체 18자리, 소수점 10자리, 부족한 앞자리는 0으로 채우기
        System.out.printf("hello = [%018.10f] %n", f);        // hello = [0000123.4567871094]

        // 소수점 포함 전체 18자리, 소수점 10자리, 부족한 앞자리는 공백으로 채우기
        System.out.printf("hello = [%18.10f] %n", f);         // hello = [    123.4567871094]


        double d = 123.456789066667777;
        System.out.printf("%.14f %n", d);                 // 123.45678906666778, double 타입은 앞의 15자리까지만 정확하다.
        // 이러한 정밀도 문제 때문에 사실 %f 지시자를 사용할 경우 거의 대부분 double 타입의 수를 대입한다.


        // %e, %E   : 지수 표현식의 형식으로 출력. 자릿수를 지시하지 않을 경우 소수점 6번째 자리까지 "반올림"
        System.out.printf("%e %n", d);                     // 1.234568e+02, 지수 형식. 소문자
        System.out.printf("%E %n", d);                     // 1.234568e+02, 지수 형식. 대문자


        // %c       : 입력한 정수를 문자코드값으로 해석하여 문자(character)로 출력
        System.out.printf("%c %n", 65);                    // A


        // %s       : 문자열(string)로 출력
        System.out.printf("%s %n", Integer.toBinaryString(15));    // 1111 (문자열로 출력)
        System.out.printf("[%20s]%n", "www.hello.co.kr" );    // [     www.hello.co.kr]  양수: 오른쪽 정렬
        System.out.printf("[%-20s]%n", "www.hello.co.kr" );   // [www.hello.co.kr     ]  음수: 왼쪽 정렬
        System.out.printf("[%8s]%n", "www.hello.co.kr" );     // [www.hello.co.kr]       작은 정수: 전체 문자열 출력
        System.out.printf("[%.8s]%n", "www.hello.co.kr" );    // [www.hell]              .숫자: 입력한 글자수만 잘라서 출력
        System.out.printf("[%.50s]%n", "www.hello.co.kr" );   // [www.hello.co.kr]             숫자가 충분하면 전체 문자열만
    }
}
