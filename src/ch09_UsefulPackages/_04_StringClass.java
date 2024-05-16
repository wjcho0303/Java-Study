package ch09_UsefulPackages;

//  String 클래스는 문자열을 당아주는 char[] 배열, 그리고 다양한 문자열 관련한 메서드들로 이루어져 있다.
//      public final class String implements java.io.Serializable, Comparable {
//          private char[] value;
//              ...
//          }
//
//  문자열을 덧셈연산시켜 문자열을 합칠 때마다 새로운 문자열 메모리 주소가 저장된다.
//  String a = "hello ";     <-- hello 라는 값을 0x100 메모리에 저장하고 그 주소를 변수 a에 담기
//  String b = "world";     <-- world 라는 값을 0x200 메모리에 저장하고 그 주소를 변수 b에 담기
//  a = a + b ;         <-- hello world 문자열이 0x300 메모리에 저장, 그 메모리의 주소를 변수 a에 담기

//  이러한 원리 때문에 덧셈 연산자( + )를 통한 문자열 결합은 프로그램의 성능을 떨어뜨린다.
//  왜냐하면 위와 같이 문자열은 메모리 상에서 내용을 변경시키는 게 아니라,
//  연산 결과 나타난 새로운 문자열을 새로운 메모리에 할당시키는 방식이기 때문이다.
//  덧셈 연산으로 hello world 를 만들었지만 hello 와 world 가 여전히 메모리 공간을 차지하고 있다.

//  문자열의 결합이나 변경을 자주 해야하는 상황에는 내용을 변경시키는 StringBuffer class 를 사용한다.
//  String str1 = "abc";
//  string str2 = "abc";                이렇게 문자열 리터럴로 만드는 방법과
//  String str3 = new String("abc");
//  String str4 = new String("abc");    이렇게 new 키워드로 문자열을 만드는 방법은 차이가 있다.

//  문자열 리터럴 방식은 "abc"의 주소가 참조변수 str 에 저장되는 거라
//  str1과 str2가 가리키는 주소가 똑같다.

//                   str1 = str2 = 0x100
//                   str1 == str2 --> true          주소가 같기 때문에 true 가 나온다.
//                   str1.equals(str2) --> true     값도 같기 때문에 true 가 나온다.

//  리터럴 방식은 이렇게 참조변수의 주소값만 바꾸고 메모리에 할당된 문자열 값은 불변이다.
//  그 변하지 않는 불변의 문자열 값을 갖고 있는 곳을 constant pool 이라 부른다.



//  반면 인스턴스화 방식은 abc 문자열을 멤버로 가지는 String 객체의 주소가 str3, str4 에 저장되는 것이다.
//          str3 = 0x200
//          str4 = 0x300
//          str3 == str4 (false)        // 이는 주소비교이기 때문에 false 가 나온다.
//          str3.equals(str4) --> true  // equals() 는 value 를 비교하는 메서드라서 true 나옴

//  하지만 사용성은 리터럴 방식이 더 편리하기 때문에 대부분의 경우 그냥 리터럴 방식을 쓰는 것이다.
//  실제로 StringBuffer class 를 이용하는 경우는 특수한 상황들이 아니라면 별로 안 쓴다.
//  그리고 인스턴스화 방식도 너무 남발하면 메모리를 많이 잡아 먹는다.


public class _04_StringClass {
    public static void main(String[] args) {
        char c = '\u0000';      // null 문자
        System.out.println(c);

        String str1 = "abc";
        String str2 = "def";
        // 프로그램을 실행하면 프로그램에 있는 모든 종류의 상수들은 constant pool 에 자동으로 저장된다.
        // 위와 같은 리터럴 문자열 값도 상수이기 때문에 마찬가지로 constant pool 에 저장된다.


        // 빈 문자열과 빈 문자를 사용할 때 팁
        String emptyString1 = "";
        System.out.println(System.identityHashCode(emptyString1));  // 해시값 존재
        // 바람직하다. 빈 문자열도 메모리에 할당되기 때문에 참조하는 주소가 존재한다.

        String emptyString2 = null;
        System.out.println(System.identityHashCode(emptyString2));  // 해시값 0
        // 바람직하지 않다. 왜냐하면 이것은 단순히 빈 문자열을 나타내는 것이 아니라
        // 문자열 변수가 아무런 값도 참조하지 않는다는 뜻이기 때문에 NullPointerException 이 발생할 수 있다.

        char emptyChar1 = ' ';
        System.out.println(System.identityHashCode(emptyChar1));    // 해시값 존재
        // 바람직하다.

        char emptyChar2 = '\u0000';
        System.out.println(System.identityHashCode(emptyChar2));    // 해시값 존재
        // 이 경우엔 메모리에 할당은 되기 때문에 참조 주소가 존재한다.
        // 그래서 NullPointerException 문제가 발생하지는 않는다.
        // 그러나 코드의 가독성이 떨어질 수 있으며, 실용적으로 보면 전혀 쓸 이유가 없다.
    }
}
