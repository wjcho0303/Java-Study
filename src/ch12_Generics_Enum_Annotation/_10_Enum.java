package ch12_Generics_Enum_Annotation;

//
//      열거형 enum : 서로 관련된 상수들을 묶어 놓은 것. Java 는 타입에 안전한 열거형을 제공한다.
//
//      class Card {
//          static final int CLOVER = 0;
//          static final int HEART = 1;
//          static final int DIAMOND = 2;
//          static final int SPADE = 3;     // 카드 무늬
//
//          static final int TWO = 0;
//          static final int THREE = 1;
//          static final int FOUR = 2;      // 카드 숫자
//
//          final int kind;
//          final int num;
//      }

//      이렇게 하나씩 일일히 상수를 정의하다보며 너무 많다. 그래서 아래와 같이 바꿀 수 있다.
//
//      class Card {
//          enum Kind   {CLOVER, HEART, DIAMOND, SPADE} // 열거형 Kind 를 정의함
//          enum Value  {TWO, THREE, FOUR}              // 열거형 Value 를 정의함
//
//          final Kind kind;        // 타입이 int 가 아니라 Kind 임을 유의하자.
//          final Value value;
//      }
//
//      저렇게 열거형을 정의해놓으면 값이 자동으로 0, 1, 2, ... 순으로 상수가 매겨진다.
//      자동으로 값이 부여되기 때문에 위와 아래는 같다.
//
//      만약 Card.CLOVER == CARD.TWO 를 한다고 했을 때, 값은 둘 다 0이다. true 가 나올까 false 가 나올까?
//      C 언어는 true 가 나온다. 그런데 Java 는 컴파일 에러로 빨간줄이 그어진다.
//      왜냐하면 Java 의 열거형 enum 은 타입과 값 둘 다 체크하기 때문이다.
//
//
//      열거형을 정의하는 방법은 다음과 같다:
//
//          enum 열거형이름 {상수명1, 상수명2, ... } 구분자는 보다시피 콤마(,)를 사용한다.
//
//          예시:
//          enum Direction {EAST, SOUTH, WEST, NORTH}  이 네 개들은 모두 기본형이 아니라 객체라는 점을 기억하자.
//          이렇게 하면 자동으로 EAST 부터 0, 1, 2, 3 값이 부여된다.
//
//          그러면 열거형 타입의 변수를 선언하고 사용하는 방법을 알아보자.
//
//          class Unit {
//              int x, y;                       // 유닛의 위치를 나타내는 멤버변수
//              Direction dir;                  // 열거형 인스턴스 변수를 선언.
//                                              // 위에 적은 Direction 중 네 개 값만 들어올 수 있다.
//
//              void init() {
//                  dir = Direction.EAST;       // 유닛의 방향을 EAST 로 초기화하는 모습이다.
//              }
//          }
//
//
//          열거형 상수를 비교할 땐 아래 예시와 같이 == 와 compareTo() 메서드를 사용할 수 있다.
//          if(dir==Direction.EAST) {           <-- 가능. dir 이 네 가지 중 EAST 면 x 값 증가
//              x++;
//          } else if (dir > Direction.WEST) {  <-- 불가능. 열거형 상수에는 비교 연산자 사용 불가
//              ...
//          } else if (dir.compareTo(Direction.WEST) > 0) {
//              ...
//          }   이렇게, 열거형 상수에 비교 연산자를 사용하려면 compareTo() 를 사용해야 한다.
//              compareTo() 는 왼쪽이 크면 양수, 같으면 0, 파라미터가 크면 음수가 나온다.
//
//
//
//          java.lang.Enum 은 모든 열거형의 조상이다.
//          그래서 모든 열거형은 아래의 Enum 클래스의 메서드를 상속 받는다:
//
//          Class<E> getDeclaringClass()                열거형 Class 객체를 리턴
//
//          String name()                               열거형 상수의 이름을 문자열로 리턴
//
//          int ordinal()                               열거형 상수가 정의된 순서를 리턴 (0부터 시작)
//
//          T valueOf(Class<T> enumType, String name)   입력한 열거형에서 name 과 일치하는 열거형 상수를 리턴
//
//

enum Direction { EAST, SOUTH, WEST, NORTH }
// 값:           0   ,  1   ,  2   ,  3

public class _10_Enum {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;  // 열거형타입.상수이름
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");
        // 위 세 줄 모두 같은 기능을 한다. 주로 d1 에서 사용된 방법이 사용되나,
        // d2, d3 과 같은 방법도 있다는 것 정도는 기억하자.

        System.out.println("d1="+d1);       // EAST
        System.out.println("d2="+d2);       // WEST
        System.out.println("d3="+d3);       // EAST

        System.out.println("d1==d2 ? "+ (d1==d2));              // false
        System.out.println("d1==d3 ? "+ (d1==d3));              // true
        System.out.println("d1.equals(d3) ? "+ d1.equals(d3));  // true
        // enum 안에 들어간 것들 하나하나가 객체이다. 그래서 equals 로 비교가 가능한 것이다.

//		System.out.println("d2 > d3 ? "+ (d1 > d3)); // 에러 발생
//      객체라서 그냥 쌩 비교연산자로는 비교가 안 되는 것이다. 그래서 아래와 같이 compareTo() 를 써야 한다.

        System.out.println("d1.compareTo(d3) ? "+ (d1.compareTo(d3))); // 0
        System.out.println("d1.compareTo(d2) ? "+ (d1.compareTo(d2))); // -2

        switch(d1) {
            case EAST: // Direction.EAST 라고 쓸 수 없다. 그냥 문법이다. 상수 이름만 써야 한다.
                System.out.println("The direction is EAST."); break;
            case SOUTH:
                System.out.println("The direction is SOUTH."); break;
            case WEST:
                System.out.println("The direction is WEST."); break;
            case NORTH:
                System.out.println("The direction is NORTH."); break;
            default:
                System.out.println("Invalid direction."); break;
        }

        Direction[] dArr = Direction.values();      // 열거형의 모든 상수(상수명)를 dArr 배열 안에 리턴

        for(Direction d : dArr)  // for(Direction d : Direction.values())
            System.out.printf("%s=%d%n", d.name(), d.ordinal());
        // name() 은 상수명을 리턴하고, ordinal() 은 그 상수명의 index 를 리턴한다. (value 가 아님)

    }
}
