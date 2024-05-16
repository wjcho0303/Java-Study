package ch12_Generics_Enum_Annotation;

// enum 을 만들고 그 안에 상수를 집어넣으면 자동으로 상수의 value 가 0, 1, 2, 3 이 된다고 했다.
// 근데 만약 이 상수 0, 1, 2, 3 이 맘에 안든다면 어떻게 바꿀까?

// enum Direction {EAST(1, "동"), SOUTH(5), WEST(-1), NORTH(10)}

// 이렇게 상수 옆에 소괄호 안에 value 를 집어넣으면 된다. 그리고 EAST 를 보면 알 수 있듯이,
// 소괄호 안에 콤마(,)를 이용하여 여러 개의 value 를 넣을 수도 있다. 왜냐하면 저 상수명 하나 하나가
// 객체이기 때문에 저렇게 value 를 넣는 것은 곧 멤버를 추가해주는 셈이다.

// 물론 당연히 그냥 바로 저렇게 할 수는 없다.
// 아래와 같이 enum 에 인스턴스 변수도 추가해줘야 하고, 생성자도 당연히 추가해줘야 한다.

//      enum Direction {
//          EAST(1, "동"), SOUTH(5), WEST(-1), NORTH(10);
//
//          private final int value;
//          private final String direction

//          private Direction(inv value) {      // enum 의 생성자는 항상 private 이다. (생략가능)
//              this.value = value;             // 즉, enum 생성자는 외부에서 객체 생성을 못한다.
//          }

//          private Direction(inv value, String direction) {
//              this.value = value;
//              this.direction = direction;
//          }

//          public int getValue() {
//              return value;
//          }
//
//          public String getDirection() {
//              return direction;
//          }
//      }
//
//      main 메서드 내부 {   Direction d = new Direction(1);   }  <-- 에러 발생.
//      enum 생성자는 항상 private 이기 때문에 외부에서 객체 생성을 못한다.
//
//      아래 예시를 살펴보자.

enum Direction2 {
    EAST(1, ">"),
    SOUTH(2,"V"),
    WEST(3, "<"),
    NORTH(4,"^");

    private static final Direction2[] DIR_ARR = Direction2.values();    // values() 는 열거형이 가진 모든 상수명을 리턴한다.
    private final int value;
    private final String symbol;    // >  <  ^   V  그냥 이렇게 방향을 나타낼 String 들.

    Direction2(int value, String symbol) { // 접근 제어자 private이 생략됨
        this.value  = value;
        this.symbol = symbol;
    }

    public int getValue()     { return value;  }
    public String getSymbol() { return symbol; }

    public static Direction2 of(int dir) {      // 상수들 중 하나를 얻어올 수 있게 하는 메서드
        if (dir < 1 || dir > 4)     //
            throw new IllegalArgumentException("Invalid value :" + dir);    // 1 ~ 4 범위를 벗어나면 예외 발생하게 해놓음
        return DIR_ARR[dir - 1];    // 입력한 값에 맞는 DIR_ARR 배열의 index 위치에 해당하는 열거형 상수를 리턴
    }

    // 방향을 회전시키는 메서드. num 의 값만큼 90도씩 시계방향으로 회전한다.
    public Direction2 rotate(int num) {
        num = num % 4;

        if(num < 0) num +=4; // num 이 음수일 때는 시계반대 방향으로 회전

        return DIR_ARR[(value-1+num) % 4];
    }

    public String toString() {
        return name()+getSymbol();
    }
}
public class _11_Enum_Member {
    public static void main(String[] args) {
        for (Direction2 d : Direction2.values())
            System.out.printf("%s=%d%n", d.name(), d.getValue());
            // getValue 는 저장한 value 를 리턴한다. 만역 ordinal() 로 했다면 0,1,2,3 을 리턴했을 것이다.

        Direction2 d1 = Direction2.EAST;
        Direction2 d2 = Direction2.of(1);

        System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());

        // 순서: EAST(1, ">"), SOUTH(2,"V"), WEST(3, "<"), NORTH(4,"^")
        System.out.println(Direction2.EAST.rotate(1));  // rotate 한 번           --> SOUTH
        System.out.println(Direction2.EAST.rotate(2));  // rotate 두 번           --> WEST
        System.out.println(Direction2.EAST.rotate(-1)); // rotate 반대로 한 번     --> NORTH
        System.out.println(Direction2.EAST.rotate(-2)); // rotate 반대로 두 번     --> WEST
        // rotate 는 배열의 시작을 넘겨주는 행위라고 이해하면 된다.
        // 양수면 요소들 전체를 왼쪽으로 옮기고, 음수면 요소들 전체를 오른쪽으로 옮긴다고 생각하면 된다.
        // 사실 처음부터 상수명을 시계방향 순서로 입력하긴 했다. 그러면 rotate 1 당 시계방향 90도, -1 당 반시계방향 90도가 된다.
    }
}
