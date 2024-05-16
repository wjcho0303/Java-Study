package ch05_ArrayAndString;

import java.util.Arrays;

public class _05_StringClass {
    public static void main(String[] args) {
        // 문자열 String 은 결국 문자 타입 char 의 배열이라고 볼 수 있다.
        // 즉, String 타입은 char[] 라고도 해석할 수 있다.

        // String 클래스는 결국 char[] 와 메서드를 결합한 것이라고 볼 수 있다.
        // 이 메서드들은 문자 배열을 다루는 데에 필요한 메서드들이다.

        // String 클래스는 주소에 담긴 내용을 변경할 수는 없다. 즉, read-only 이다.
        // 예를 들면
        String a = "hel";     // 주소값이 0x100 이라고 가정하자.
        String b = "lo!";     // 주소값이 0x200 이라고 가정하자.

        a = a + b;            // a = "hello!"
        // 이렇게 하면 a 의 주소값은 어떻게 될까? 0x100 을 유지한 채 값만 달라질까?
        // 아니다. 0x100 주소값은 버려지고, 새로운 주소값(0x300 이라고 가정하자)이 생성된다.

        
        
        // 이제 String 클래스에서 가장 많이 사용되는 메서드들에 대해 살펴본다.
        // a = "hello!"
        // 1) 문자열에   .charAt(인덱스값)  를 붙이면 그 인덱스에 해당하는 문자가 반환된다.
        char c = a.charAt(4);
        System.out.println("c = " + c);     // c = o

        // 2) 문자열에   .length()   를 붙이면 그 문자열의 길이가 반환된다.
        int d = a.length();
        System.out.println("d = " + d);     // d = 6


        // 3) 문자열에   .substring(num1, num2)  를 붙이면 그 범위의 문자열을 추출하여 반환한다.
        // 이때, 나중에 적어준 num2 인덱스 범위는 반환되는 문자열에 포함되지 않는다. 그래서  .length()  를 사용할 때 편하다.
        String e = a.substring(0, 3);               // 3을 적었으므로 index 0~2 까지만 추출.
        String part = a.substring(2, a.length());   // .length()  를 활용하면 나머지 뒷부분을 모두 추출할 때 편하다.
        System.out.println("e = " + e);             // e = hel
        System.out.println("part = " + part);       // part = llo!


        // 4) 문자열에   .equals(str)   를 붙이면 입력한 str 과 일치하는지 여부를 true 나 false 로 반환한다.
        boolean f = a.equals("hello!");
        System.out.println("f = " + f);     // f = true


        // 5) 문자열에   .toCharArray()   를 붙이면 문자열을 구성하는 문자들을 원소로 가지는 char[] 타입의 배열을 반환한다.
        char[] g = a.toCharArray();
        System.out.println("g = " + Arrays.toString(g));    // g = [h, e, l, l, o, !]
    }
}
