package ch09_UsefulPackages;

//  이번 자료에서는 StringBuffer 클래스의 기본 개념과 특징에 대해 다루고,
//  StringBuffer 의 메서드들은 다음 자료에서 다룬다.

//  StringBuffer 클래스는 문자열을 저장하고 다루기 위한 클래스이다.
//  StringBuffer 클래스도 String 처럼 char[]을 내부적으로 갖고 있다.
//  String 은 주소에 담긴 value 자체를 변경시킬 수는 없다. 이를 'immutable' 하다고 표현한다.
//  반면에, StringBuffer 는 주소에 담긴 value 자체를 변경할 수 있다. 이를 'mutable' 하다고 표현한다.


public class _06_StringBuffer {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abc");
        // 참조변수 sb가 담은 주소값을 0x100 이라 하자.
        // 그러면 이 0x100 주소에서 가진 value 는 'a', 'b', 'c' 라는 char[] 문자 배열이다.


        sb.append("hello");
        //  이렇게 하면 참조변수 sb가 담은 주소값 0x100에 있는 char[] 배열이 다음과 같이 변경된다.
        //  char[] = 'a', 'b', 'c', 'h', 'e', 'l', 'l', 'o'
        //  즉, 이렇게 StringBuffer 는 참조변수에 할당된 주소값을 변경시키지 않는 대신
        //  그 주소가 가리키는 메모리 공간에 담긴 value 자체를 바꿔버린다.


        // 결국 StringBuffer 인스턴스를 만든다는 것은 char[] 배열을 만든다는 것이다.
        // 그런데 배열이라는 것은 처음 생성할 때 길이가 고정적으로 정해져있다.


        // 그렇다면 StringBuffer 로 만든 배열의 길이는 얼마인가? 기본적으로는 16이다.
        //      public StringBuffer(int length) {
        //          value = new char[length];
        //          shared = false;
        //      }
        //
        //      public StringBuffer() {
        //          this(16);
        //      }


        // 하지만 StringBuffer 인스턴스를 생성할 때, 생성자에 매개변수로 문자열을 입력하면
        // 그 문자열의 길이보다 16을 추가하게 되어 있다.
        //      public StringBuffer(String str) {
        //          this(str.length() + 16);
        //          append(str);
        //      }
        // 그러므로 위에서 만든 sb가 가리키는 char[]의 길이는 19이다.


        // append() 메서드는 지정된 내용을 StringBuffer 에 추가 후,
        // StringBuffer 의 참조주소를 똑같이 그대로 반환한다.
        // 즉, 내용을 변경해도 참조 주소가 그대로라는 것이다.
        StringBuffer sb2 = sb.append("world");
        System.out.println("sb = " + sb);
        System.out.println("sb2 = " + sb2);

        StringBuffer sb3 = new StringBuffer("abchelloworld");
        System.out.println("sb3 = " + sb3);
        // 위에서 sb2라는 참조변수에 sb.append()를 통해 예전과 똑같이 반환되는 참조 주소를 대입하기 때문에
        // 결국 sb1과 sb2 둘 다 담은 주소값이 0x100 이 된다.


        // '+' 연산자를 통해 문자열을 합치면 사용하지 않는 문자들이 메모리에 남아 있으면서
        // 매번 새로운 문자열을 생성하기 때문에 메모리를 낭비하게 되는 반면,
        // StringBuffer 또는 StringBuilder 의 append 메서드를 사용하면
        // 문자열 자체를 수정하기 때문에 낭비되는 메모리가 줄어든다.
        // 특히, 문자열 연산이 많은 경우이거나 반복문을 통한 문자열 연결이 이루어지는 경우에는
        // append 메서드를 사용하는 것이 더 효율적이다.


        // StringBuffer 를 통해 문자열의 내용이 같은지 비교할 때는 equals() 메서드를 그냥 사용하면 안 된다.
        // 왜냐하면 StringBuffer 의 equals 메서드는 오버라이딩 되어 있지 않아
        // 문자열 내용을 비교하는 것이 아닌, Object 의 equals()가 하는 일처럼 객체 주소를 비교하는 것이기 때문에,
        // 내용이 같은지 비교하려면 toString() 메서드를 통해 String 으로 변환시킨 후 비교해야 한다.
        System.out.println("sb2.equals(sb3) = " + sb2.equals(sb3));
        System.out.println("sb2.toString().equals(sb3.toString()) = "+ sb2.toString().equals(sb3.toString()));
    }
}
