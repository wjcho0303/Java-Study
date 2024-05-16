package ch09_UsefulPackages;

//  toString() 메서드도 Object 클래스에 있는 메서드이다.
//  toString()은 인스턴스를 문자열로 변환해주는 메서드이다.

//  구현은 다음과 같이 되어 있다.
//  public String toString() {
//      getClass().getName() + '@' + Integer.toHexString(hashCode())
//  }

// 그래서 toString 을 호출하면 "클래스명@객체의 주소값을 정수로 반환한 것을 16진수 문자열로 변환한 것"이 반환된다.

import java.util.Objects;

// toString 은 오버라이드해서 쓰면 정말 유용하다.
class Card2 {
    String kind;
    int number;

    Card2() {
        this("SPADE", 1);  // Card(String kind, int number)¸¦ È£Ãâ
    }

    Card2(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override
    public String toString() {
        return "kind : " + kind + ", number : " + number;
    }
    // Object class 의 toString() 메서드를 오버라이딩하여 내가 사용하고 싶은 방식대로 재정의

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Card2)) {
            return false;
        }

        Card2 c =(Card2)obj;
        return this.kind.equals(c.kind) && this.number == c.number;
    }
    // kind 필드값과 number 필드값이 모두 같다면 같은 객체라고 판단하도록 로직을 수정하였다.

    @Override
    public int hashCode() {
        return Objects.hash(kind, number);
    }
    // kind 와 number 필드가 모두 같다면 같은 hash 값이 나오도록 로직을 수정하였다.
}
    // [중요] 위와 같이, equals() 메서드를 오버라이딩 할 경우
    // 반드시 hashCode() 메서드도 같이 오버라이딩 해주어야 한다.
    // 왜냐하면 equals() 가 true 이면 hashCode() 반환값도 같아야 하는데
    // 구현 내용을 다르게 해버리면 위의 원칙에 위배되기 때문이다.

public class _03_toString_equals {
    public static void main(String[] args) {
        Card2 c1 = new Card2();
        Card2 c2 = new Card2("HEART", 10);
        Card2 c3 = new Card2("HEART", 10);
        System.out.println(c1.toString());  // kind : SPADE, number : 1
        System.out.println(c2.toString());  // kind : HEART, number : 10
        System.out.println(c1);             // kind : SPADE, number : 1
        System.out.println(c2);             // kind : HEART, number : 10

        System.out.println("c1.hashCode() = " + c1.hashCode()); // -1842861219
        System.out.println("c2.hashCode() = " + c2.hashCode()); // 2127040613
        System.out.println("c3.hashCode() = " + c3.hashCode()); // 2127040613
        System.out.println("c1.equals(c2) = " + c1.equals(c2)); // false
        System.out.println("c2.equals(c3) = " + c2.equals(c3)); // true
    }
}
