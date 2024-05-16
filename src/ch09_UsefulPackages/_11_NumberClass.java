package ch09_UsefulPackages;

public class _11_NumberClass {
    public static void main(String[] args) {
        // Number 클래스는 숫자와 관련된 Wrapper 클래스들의 조상이다.
        // 즉, Byte, Short, Integer, Long, Float, Double 의 조상이다. (BigInteger 와 BigDecimal 도 있음)

        // Number 클래스는 Wrapper 객체가 가진 값을 기본형 타입으로 바꿔주는 메서드들을
        // 추상 메서드 형태로 갖고 있다. 그리고 각각의 추상 메서드들을 Number 클래스를 상속한 Wrapper 클래스들이
        // 오버라이딩하여 정의해놓았다. 단, Boolean 래퍼 클래스의 경우는 숫자와 관련되지 않으므로 제외이다.

        // int intValue(Integer i)          입력 받은 Integer 래퍼클래스를 int 기본형으로 변환시켜 반환
        // double doubleValue(Double d)     입력 받은 Double 래퍼클래스를 double 기본형으로 변환시켜 반환
        // byte byteValue(Byte b)           입력 받은 Byte 래퍼클래스를 byte 기본형으로 변환시켜 반환
        // float floatValue(Float f)        입력 받은 Float 래퍼클래스를 float 기본형으로 변환시켜 반환
        // long longValue(Long l)           입력 받은 Long 래퍼클래스를 long 기본형으로 변환시켜 반환
        // short shortValue(Short s)        입력 받은 Short 래퍼클래스를 short 기본형으로 변환시켜 반환
    }
}
