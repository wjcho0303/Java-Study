package ch12_Generics_Enum_Annotation;

//
//      애너테이션을 직접 만들어 쓸 수 있다.
//      기본적인 방법은 아래와 같다:
//
//      @interface 애너테이션명 {
//          타입 요소이름();      // 애너테이션의 요소를 선언
//          ...
//      }
//
//      애너테이션의 메서드는 추상 메서드이고, 애너테이션을 적용할 때 지정한다. 순서는 상관없다.
//      또, 애너테이션이 또 다른 애너테이션을 포함시킬 수 있다.
//
//      @interface DateTime {
//          String yymmdd();
//          String hhmmss();
//      }
//
//      @interface TestInfo {
//          int count();
//          String testedBy();
//          String[] testTools();
//          TestType testType();
//          DateTime testDate();    <--- 위에 만든 DateTime 애너테이션을 포함하는 모습
//      }
//
//
//      이렇게 만들어놓으면 애너테이션을 어떻게 사용하나? 사용하는 모습은 아래와 같다:
//      예를 들어 위의 TestInfo 애너테이션을 사용한다고 해보자.
//
//      @TestInfo(
//          count=3, testedBy="Kim", testTools={"JUnit, "AutoTester""},
//          testType=TestType.FIRST, testDate=@DateTime(yymmdd="160101", hhmmss="235959")
//      )
//      public class NewClass {
//          ...
//      }
//      * 참고: testType.FIRST 저 부분은 enum TestType {FIRST, FINAL} 이다.
//      이렇게 NewClass 라는 Class 에 TestInfo 애너테이션을 사용하는 모습을 볼 수 있다.
//      보면 알 수 있듯이, 애너테이션을 적용할 때 애너테이션의 요소가 있다면 그 요소들을 다 적어줘야 한다.
//      적는 순서는 상관 없다. 추상메서드는 구현할 필요는 없고 저렇게 써주면 된다.
//      메서드명=넣을 값 (메서드 옆의 소괄호를 없앰. 반환형에 맞는 값을 대입시키면 됨)
//
//      ★저렇게 추상메서드에 값을 지정해 놓으면, NewClass 의 인스턴스가 저 애너테이션에 있는 추상메서드를 호출했을 때
//      애너테이션 안에 써 놓았던 값이 리턴된다.★ 이런 메커니즘으로 되어 있다...
//      보통은 메서드를 개발자가 호출할 일은 없을 거고 저렇게 값을 채워 넣을 일은 있을 것이다.
//
//      애너테이션에 저렇게 값을 집어넣는다는 것은 알았다.
//      그런데 처음에 애너테이션을 만들어 놓을 때 default 값을 설정해줄 수 있다.
//      이렇게 말이다:
//
//      @interface TestInfo {
//          int count() default 1;      이렇게 추상메서드 옆에 default 키워드를 입력한 후 값을 쓰면 된다.
//      }
//      이렇게 되면 애너테이션을 실제로 class 위에 사용할 때 count=숫자 이렇게 적지 않는다면 자동으로 1이 적용된다.
//      참고로, default 값으로 null 은 사용할 수 없다.

//      @TestInfo       <--- default 1 이거 덕분에 @TestInfo(count=1) 이거랑 동일한 효과
//      public class NewClass {
//          ...
//      }
//




//      그리고 만약 요소가 하나인데 그 이름이 value 일 때, 요소의 이름을 생략하고 사용할 수 있다.
//      아래처럼 말이다:
//
//      @interface TestInfo {
//          String value();     <--- 이렇게 요소는 추상메서드 하나인데 그 추상 메서드가 value() 인 상황.
//      }
//      이런 경우는 특수한 경우로 취급하여 애너테이션을 사용할 때 value="넣고 싶은 값" 이렇게 안 써도 되고
//      그냥 바로 "넣고 싶은 값"을 쓰면 된다.
//
//      @TestInfo("넣고 싶은 값")    <--- 이런 식으로 말이다.
//      public class NewClass {
//          ...
//      }
//      원래대로면 @TestInfo(value="넣고 싶은 값") 이렇게 했어야 하는데 추상메서드명을 value 라고 해서 가능한 것이다.
//



//      요소의 타입이 배열인 경우, 괄호를 적용할 때 사용해야 한다.
//      @interface TestInfo {
//          String[] testTools();
//      }
//
//      @TestInfo(testTools={})     <--- 이런 식으로 말이다. 값이 있어도 꼭 써야하지만 값이 없어도 꼭 써야 한다.
//      public class NewClass {     <--- 단, 예외적으로 값이 딱 하나일 때는 괄호 안 써도 된다.
//          ...
//      }
//
//      @TestInfo(testTools="JUnit")    <--- 단, 예외적으로 값이 딱 하나일 때는 괄호 안 써도 된다.
//      public class NewClass {
//          ...
//      }
//
//      @TestInfo(testTools={"JUnit", "AutoTester"})
//      public class NewClass {
//          ...
//      }
//




//      모든 애너테이션은 조상이 있다. 바로 Annotation 이다.
//      Annotation 자신은 interface 이다.
//
//      public interface Annotation {       // Annotation 자신은 interface 이다.
//          boolean equals(Object obj);
//          int hashCode();
//          String toString();
//
//          Class<? extends Annotation> annotationType();   // 애너테이션의 타입을 반환
//      }
//
//      모든 애너테이션들이 위와 같은 메서드들을 물려받는다는 말이다. 근데 이 Annotation 의 추상메서드들은
//      애너테이션을 생성할 때 필수로 구현할 필요는 없다. 사용은 가능하다.
//
//      그리고, extends Annotation 이런 표현은 사용되지 않는다. 쓰면 에러난다. 아래를 참고하자:
//
//      @interface TestInfo extends Annotation {        <--- 에러 발생
//          ...
//      }
//


//
//      Marker Annotation (마커 애너테이션)은 요소를 하나도 정의하지 않은 애너테이션이다.
//      앞서 살펴보았던 @Override 라든지, @Deprecated 이런 애들 처럼 말이다.
//      얘네들은 클래스 위에 사용할 때 소괄호 ()를 입력하지 않고 그냥 띡 쓴다.
//      프로그램에 정보를 제공하는 역할을 하기 때문에 의미가 없는 것은 아니다.
//




//      애너테이션 요소를 선언할 때는 아래의 규칙을 지켜야 한다:
//      요소의 타입은 기본형, String, enum, 애너테이션, class 만 허용된다.
//          - class 는 설계도 객체라고 생각하면 된다.
//          - 괄호 안에 매개변수를 선언하면 안 된다.
//          - 예외를 선언할 수 없다.
//          - 요소를 타입 매개변수(지네릭스)로 정의할 수 없다.
//
//                  아래에서 틀린 점들을 찾아보자.
//                  @interface AnnoTest {
//                      int id = 100;                       상수 OK static final 의 생략이니 가능함.
//                                                          단, default 메서드는 안 된다는 것을 기억하자.
//                      String major(int i, int j);         에러. 매개변수
//                      String minor() throws Exception;    에러. 예외 선언
//                      ArrayList<T> list();                에러. 타입 매개변수 정의
//                  }
//
//      사실 이거 거의 안 써서 그냥 이런 특징들이 있구나 하고 넘어가기만 해도 충분하다.
//

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)  // 실행 시에 사용가능하도록 지정
@interface TestInfo {
    int       count()	  	default 1;
    String    testedBy();
    String[]  testTools() 	default {"JUnit", "AutoTester"};
    TestType  testType()    default TestType.FIRST;
    DateTime  testDate();
}

@Retention(RetentionPolicy.RUNTIME)  // 실행 시에 사용가능하도록 지정
@interface DateTime {
    String yymmdd();
    String hhmmss();
}

enum TestType { FIRST, FINAL }


@Deprecated
@SuppressWarnings("1111") // 1111과 같은 유효하지 않은 애너테이션은 무시된다. 주석처리 해도 똑같다.
@TestInfo(testedBy="aaa", testDate=@DateTime(yymmdd="160101",hhmmss="235959"))
// 위에서 default 로 설정한 내용들은 생략한 모습
public class _14_MakingAnnotation {
    public static void main(String[] args) {
        // _14_MakingAnnotation 의 Class 객체를 얻는다. getAnnotation 메서드를 쓰기 위한 것임.
        Class<_14_MakingAnnotation> cls = _14_MakingAnnotation.class;

        // getAnnotation 메서드는 아래와 같이 사용한다.
        TestInfo        anno        =           cls.getAnnotation(TestInfo.class);
//      애너테이션 이름    참조변수명   =    클래스참조변수.getAnnotation(애너테이션명.class);
//      이렇게 하면 anno 에 _14_MakingAnnotation 클래스의 애너테이션 메서드들을 호출할 수 있게 된다.

//      아래는 실제로 anno 가 TestInfo 애너테이션을 정의한 곳에 있는 메서드들을 호출하는 모습이다. 세 종류만 호출했다.
        System.out.println("anno.testedBy()="+anno.testedBy()); // aaa
        System.out.println("anno.testDate().yymmdd()=" +anno.testDate().yymmdd()); // 160101
        System.out.println("anno.testDate().hhmmss()=" +anno.testDate().hhmmss()); // 235959
        for(String str : anno.testTools())
            System.out.println("testTools="+str);
            // JUnit
            // AutoTester
        System.out.println();


        // 이번엔 배열에 클래스에 붙은 애너테이션들을 넣는 방법이다.
        // 이번 사례에선 3개가 붙었다. 근데 실제로 출력해보면 2개밖에 안 나올 것이다.
        // 왜냐하면 SuppressWarnings 애너테이션을 잘못 썼기 때문이다.

        // 아무튼 클래스에 적용된 애너테이션들을 배열에 넣으려면 getAnnotations 라는 메서드를 사용한다.
        // 복수형 s 가 붙은 것에 유의하자.

        // cls 가 참 요긴하게 쓰인다.
        // _14_MakingAnnotation 에 적용된 모든 애너테이션을 가져온다.
        Annotation[] annoArr = cls.getAnnotations();
        for(Annotation a : annoArr)
            System.out.println(a);
        // @java.lang.Deprecated(forRemoval=false, since="")
        // @_chap12.TestInfo(
        //      count=1,
        //      testType=FIRST,
        //      testTools={"JUnit", "AutoTester"},
        //      testedBy="aaa",
        //      testDate=@_chap12.DateTime(yymmdd="160101", hhmmss="235959")
        //      )

//      이렇게 두 개가 나오는데, 눈여겨 볼 점은 default 값을 설정해놔서 입력하지 않았던 애너테이션도 나온다는 점이다.
    }
}
