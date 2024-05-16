package ch09_UsefulPackages;

//  오토박싱(auto-boxing) : 기본형 타입을 래퍼클래스 타입으로 감싸주는 것. 즉, 객체로 만들어 주는 것
//  ex) int   -->   Integer
//      10    -->   new Integer(10)
//  이렇게 객체로 만들면 래퍼 클래스의 여러 메서드들을 호출할 수 있다는 장점이 있다.
//
//
//  언박싱(unboxing) : 래퍼클래스 타입을 기본형으로 바꾸는 것
//  ex) Integer         -->   int
//      new Integer(10) -->   10
//
//
//
//  오토박싱과 언박싱 모두 컴파일러가 자동으로 해준다.
//  JDK1.5 이전에는 오토박싱과 언박싱이 자동으로 되지 않아서 기본형과 참조형 간의 연산이 불가능했었다.
//
//  JDK1.5 이전 :
//  int i = 5;
//  Integer iObj = new Integer(7);
//  int sum = i + iObj;     // 에러 발생
//
//  JDK1.5 이후 :
//  int i = 5;                                              int i = 5;
//  Integer iObj = new Integer(7);      --> 컴파일러         Integer iObj = new Integer(7);
//  int sum = i + iObj;                                     int sum = i + iObj.intValue();
//
//  예를 들어 ArrayList<Integer>를 사용할 때 원래는 add(new Integer(10)) 이런 식으로 객체를 넣어야 한다.
//  하지만 오토박싱 덕분에 add(10) 이렇게 기본형 타입으로 매개변수를 입력해도 자동으로 new Integer(10)이 원소로 들어가는 것이다.
//  또 반대로 int value = list.get(0); 이런 식으로 했을 때는 언박싱 덕분에 Integer 가 아닌 int 타입으로 값을 반환 받는다.


import java.util.ArrayList;

public class _12_Autoboxing_Unboxing {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 자동으로 오토박싱이 일어남
        list.add(new Integer(100)); // 수동 박싱
        list.add(new Integer(50));  // 수동 박싱
        list.add(20);   // 오토 박싱
        list.add(80);   // 오토 박싱
        System.out.println("list.toString() = " + list.toString());

        // 자동으로 언박싱이 일어남
        System.out.println("list.get(0).intValue() = " + list.get(0).intValue()); // 수동 언박싱
        System.out.println("list.get(1).intValue() = " + list.get(1).intValue()); // 수동 언박싱
        System.out.println("list.get(2) = " + list.get(2)); // 자동 언박싱
        System.out.println("list.get(3) = " + list.get(3)); // 자동 언박싱
    }
}
