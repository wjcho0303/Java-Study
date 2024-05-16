package ch09_UsefulPackages;

// hashCode() 메서드는 Object 클래스의 메서드이다.
// 인스턴스의 주소값을 int 로 변환시켜 반환한다. 이 값을 hash code 라고 부른다.

// 사실 hashCode() 메서드는 자바 자체가 가진 메서드는 아니고,
// native 라는 키워드를 가진 메서드이다.
// 즉, 자바가 가진 메서드가 아니라 OS가 가진 메서드이다. native 키워드가 붙은 메서드들은 주로 C 언어로 작성되었다.
// 그래서 hashCode() 가 어떻게 작성되었는지는 자바에서 볼 수 없다.
// 실제로 Ctrl + 좌클릭해서 들어가보면 구현부가 없다.

class TestClass { }
public class _02_HashCode {
    public static void main(String[] args) {
        TestClass testClass1 = new TestClass();
        System.out.println(testClass1.toString());   // ch09_UsefulPackages.TestClass@2f4d3709
        System.out.println(testClass1.hashCode());   // 793589513

        // toString() 은 객체의 메모리 주소를 포함하는 문자열을 반환하는 것이고,
        // hashCode() 는 객체의 메모리 주소를 기반으로 정수값으로 변환시켜 반환하는 것이다.
        // 두 메서드 모두 객체마다 고유한 값을 가진다.

        // equals() 메서드를 통해 true 가 반환되는 객체들은 서로 같은 hashCode()를 가진다.
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println("str1.hashCode() = " + str1.hashCode());
        System.out.println("str2.hashCode() = " + str2.hashCode());
        System.out.println("System.identityHashCode(str1) = " + System.identityHashCode(str1));
        System.out.println("System.identityHashCode(str2) = " + System.identityHashCode(str2));
        System.out.println(str1.equals(str2));      // true
        System.out.println(str1 == str2);           // false

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        String str3 = "hello";
        String str4 = "hello";
        System.out.println("str3.hashCode() = " + str3.hashCode());
        System.out.println("str4.hashCode() = " + str4.hashCode());
        System.out.println("System.identityHashCode(str3) = " + System.identityHashCode(str3));
        System.out.println("System.identityHashCode(str4) = " + System.identityHashCode(str4));
        System.out.println(str3.equals(str4));      // true
        System.out.println(str3 == str4);           // true

        // equals 는 문자열 자체의 내용이 같은지를 비교하는 것이고,
        // 논리 연산자 == 를 통한 비교는 실제로 같은 참조 메모리 주소를 가리키는지 비교한다.

        // hashCode() 메서드는 객체의 내부 상태를 기반으로 한 해시 코드를 생성하고,
        // System.identityHashCode() 메서드는 객체의 실제 메모리 주소를 기반으로 한 해시 코드를 생성한다.
        // 객체의 실제 동일성을 확인할 때는 후자를 사용한다.
    }
}
