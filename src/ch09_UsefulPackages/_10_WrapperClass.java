package ch09_UsefulPackages;

//  Wrapper Class (래퍼 클래스)는 기본형 값을 감싸는 클래스이다. 기본형이 8가지니까
//  래퍼 클래스의 종류도 8가지이다. 기본형을 객체로 다뤄야 할 때 사용한다.
//  Boolean     Character       Byte        Short
//  Integer     Long            Float       Double
//
//  객체지향언어인 자바에서 기본형을 사용할 수 있게 해놓은 것은 아무래도 성능때문이다.
//  객체는 참조변수를 통해 접근해야 하니까 대량으로 모이면 기본형 변수를 다루는 것보다 메모리에 부담이 될 수밖에 없다.

// 문자열을 각 타입에 해당하는 Wrapper 클래스로 바꿀 때 valueOf()로 통일된다.
// 근데 만약 문자열을 Wrapper 클래스가 아니라 기본형 값으로 바꿀 때는 ?

//              변수명 = WrapperType.parseWrapperType("str")

// [Wrapper]는 그냥 내가 맘대로 쓴 거다. 래퍼클래스에 있는 것들 들어간다는 뜻이다.
// 다만 정수형 Wrapper 의 경우는 parseInteger 가 아니라 parseInt 이다 (어차피 자동완성 되니까 상관없긴 하지만)

public class _10_WrapperClass {
    public static void main(String[] args) {
        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 1번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // parseInt 로 n진법 표현하기
        Integer i = new Integer(100);
        Integer i2 = new Integer(100);

        Integer i3 = Integer.parseInt("100", 2);
        // 입력한 "100"을 2진수로 해석한 후에 10진법으로 나타내라는 의미이다.
        System.out.println("입력한 \"100\"을 2진수로 해석한 후에 10진법으로 나타내라.");
        System.out.println("Integer i3 = Integer.parseInt(\"100\", 2);");
        System.out.println("i3 = " + i3);   // 4



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 2번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // 래퍼클래스의 static final 상수 필드값들
        // MAX_VALUE : 해당 래퍼 클래스가 가질 수 있는 최댓값
        // MIN_VALUE : 해당 래퍼 클래스가 가질 수 있는 최솟값
        // SIZE : 해당 래퍼 클래스가 차지하는 메모리 공간. bit 단위
        // BYTES : 해당 래퍼 클래스가 차지하는 메모리 공간. byte 단위
        // TYPE : 해당 래퍼 클래스의 타입

        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.SIZE = " + Integer.SIZE);
        System.out.println("Integer.BYTES = " + Integer.BYTES);
        System.out.println("Integer.TYPE = " + Integer.TYPE);

        System.out.println();

        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);
        System.out.println("Double.SIZE = " + Double.SIZE);
        System.out.println("Double.BYTES = " + Double.BYTES);
        System.out.println("Double.TYPE = " + Double.TYPE);

        System.out.println();

        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);
        System.out.println("Long.SIZE = " + Long.SIZE);
        System.out.println("Long.BYTES = " + Long.BYTES);
        System.out.println("Long.TYPE = " + Long.TYPE);

        System.out.println();

        System.out.println("Float.MAX_VALUE = " + Float.MAX_VALUE);
        System.out.println("Float.MIN_VALUE = " + Float.MIN_VALUE);
        System.out.println("Float.SIZE = " + Float.SIZE);
        System.out.println("Float.BYTES = " + Float.BYTES);
        System.out.println("Float.TYPE = " + Float.TYPE);

        System.out.println();

        System.out.println("Short.MAX_VALUE = " + Short.MAX_VALUE);
        System.out.println("Short.MIN_VALUE = " + Short.MIN_VALUE);
        System.out.println("Short.SIZE = " + Short.SIZE);
        System.out.println("Short.BYTES = " + Short.BYTES);
        System.out.println("Short.TYPE = " + Short.TYPE);

        System.out.println();

/*      System.out.println("Boolean.MAX_VALUE = " + Boolean.MAX_VALUE); */  // Boolean 은 정의되지 않음
/*      System.out.println("Boolean.MIN_VALUE = " + Boolean.MIN_VALUE); */  // Boolean 은 정의되지 않음
/*      System.out.println("Boolean.SIZE = " + Boolean.SIZE);           */  // Boolean 은 정의되지 않음
/*      System.out.println("Boolean.BYTES = " + Boolean.BYTES);         */  // Boolean 은 정의되지 않음
        System.out.println("Boolean.TYPE = " + Boolean.TYPE);

        System.out.println();

        System.out.println("Character.MAX_VALUE = " + Character.MAX_VALUE);
        System.out.println("Character.MIN_VALUE = " + Character.MIN_VALUE);
        System.out.println("Character.SIZE = " + Character.SIZE);
        System.out.println("Character.BYTES = " + Character.BYTES);
        System.out.println("Character.TYPE = " + Character.TYPE);



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 3번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("i == i2 = " + (i == i2));                   // false
        System.out.println("i.equals(i2) = " + i.equals(i2));           // true
        System.out.println("i.compareTo(i2) = " + i.compareTo(i2));     // 0
        System.out.println("i.toString() = " + i.toString());           // 100



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 4번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // 각 래퍼클래스마다 valueOf 라는 static 메서드를 갖고 있다.
        // parse- 로 시작하는 메서드와 valueOf 메서드의 차이는,
        // parse- 메서드류는 곧바로 기본형 타입의 값을 반환하지만
        // valueOf 메서드류는 래퍼클래스 타입으로 값을 반환한다는 것이다.
        System.out.println("Byte.valueOf(\"127\") = " + Byte.valueOf("127"));
        System.out.println("Byte.parseByte(\"127\") = " + Byte.parseByte("127") + "\n");

        System.out.println("Short.valueOf(\"30000\") = " + Short.valueOf("30000"));
        System.out.println("Short.parseShort(\"30000\") = " + Short.parseShort("30000") + "\n");

        System.out.println("Integer.valueOf(\"100000000\") = " + Integer.valueOf("100000000"));
        System.out.println("Integer.parseInt(\"100000000\") = " + Integer.parseInt("100000000") + "\n");

        System.out.println("Long.valueOf(\"9555555555555555\") = " + Long.valueOf("9555555555555555"));
        System.out.println("Long.parseLong(\"9555555555555555\") = " + Long.parseLong("9555555555555555") + "\n");

        System.out.println("Float.valueOf(\"4.3253\") = " + Float.valueOf("4.3253"));
        System.out.println("Float.parseFloat(\"4.3253\") = " + Float.parseFloat("4.3253") + "\n");

        System.out.println("Double.valueOf(\"1525.2147812924224\") = " + Double.valueOf("1525.2147812924224"));
        System.out.println("Double.parseDouble(\"1525.2147812924224\") = " + Double.parseDouble("1525.2147812924224") + "\n");

        System.out.println("Boolean.valueOf(\"true\") = " + Boolean.valueOf("true"));
        System.out.println("Boolean.parseBoolean(\"ture\") = " + Boolean.parseBoolean("ture") + "\n");
    }
}
