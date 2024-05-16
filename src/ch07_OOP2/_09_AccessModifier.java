package ch07_OOP2;

//  접근 범위가 좁은 순부터 나열하면 다음과 같다:
//  private: 같은 클래스 내에서만 접근 가능. 접근범위 가장 좁음.
//  (default): 같은 패키지 내에서만 접근 가능. 접근범위가 private 보다 조금 넓어짐.
//  protected: 같은 패키지 내에서만 접근 가능. 단, extends 키워드를 통해 상속을 받는다면 다른 패키지라 해도 접근 가능
//  public: 상속 상관 없이 다른 패키지에서도 접근 가능.
//
//
//  * class 앞에는 public 과 (default) 이 두 가지 접근제어자만 적용이 가능하다.
//  * 멤버변수와 메서드에는 public, protected, (default), private 네 가지 접근제어자 모든 종류 적용이 가능하다.
//
//
//  접근 제어자를 사용하는 이유는 외부로부터 데이터를 보호하기 위해서이다. 이를 캡슐화(Encapsulation)라고 한다.
//  프로그래밍에서 일반적으로 멤버변수(필드)에는 보통 private 접근제어자를 사용하고, 메서드에는 public 접근제어자를 사용한다.
//  getter 메서드를 통해 간접적으로 필드에 접근하고, setter 를 사용할 때 조건을 걸어주어서
//  해당 필드의 값이 적절한 범위 내에서 설정될 수 있게 보호할 수 있다.
//
//  private int hour;
//
//  public void setHour(int hour) {
//      if (hour < 0 || hour > 23) return;
//      this.hour = hour;
//  }
//
//
//  위의 setHour 메서드는 아래처럼 쓸 수도 있다.
//  public void setHour(int hour) {
//      if(isValidHour(hour)) return;
//      this.hour = hour;
//  }
//
//  private boolean isValidHour(int hour) {
//      return hour < 0 || hour > 23;
//  }
//  isValidHour 메서드를 보면 private 으로 되어 있는데, 이는 해당 클래스 내부에서만 사용되기 때문에 이렇게 한 것이다.
//  범위가 넓으면 넓을수록 에러가 났을 때 살펴봐야 할 범위가 늘어나서 힘들어진다.
//  private 이랑 관련된 부분이 만약에 오류가 났으면 그 class 만 살펴보면 되니까 더 간편해진다.
//  번외로 위에처럼 바꾸면 코드가 더 길어지긴 했지만, 모듈화라는 장점이 있다.
//  코드를 줄일 것인지 모듈화를 할 것인지 판단하여 선택하면 된다.
//

class MyTestClass {
    private String privateMember;
    // 이렇게 별도의 클래스 안에 private 필드를 만들어 놓고 다른 클래스에서 접근 시도를 해보고 어떤 상황이 벌어지는지 살펴보자.
    // 아래에 있는 _09_AccessModifier 의 main 메서드에 나와 있다.
}


public class _09_AccessModifier {
    public String publicMember;

    private String testMember;
    
    protected void protectedMethod() {
        System.out.println("\" This is : protected void protectedMethod in _09_AccessModifier of ch07_OOP2 package.\"");
    }
    // ch07_OOP_protectedTest 패키지에 있는 클래스를 ProtectedExtendingClass 를 실행해보자.
    // 이 클래스는 본 클래스인 _09_AccessModifier 를 상속 받았으며, 위에서 정의한 protectedMethod 를 호출한다.

    // 이런 식으로 패키지 내부에서만 쓰게 하고 싶긴 한데 다른 패키지에서 상속해서 사용할 일이 생길 거 같은 메서드에는
    // 위와 같이 protected 접근제어자를 걸어주면 유용하다.

    void defaultMethod() {
        System.out.println("\" This is : (default) void defaultMethod in _09_AccessModifier of ch07_OOP2 package.\"");
    }
    // ch07_OOP_protectedTest 패키지에 있는 클래스를 ProtectedExtendingClass 를 살펴보면 컴파일 에러가 발생한다.
    // 이는 default 접근제어자는 _09_AccessModifier 클래스가 속한 'ch07_OOP2' 패키지 안에서만 접근 가능하기 때문이다.


    // _09_AccessModifier 클래스의 내부
    public static void main(String[] args) {
        MyTestClass mtc = new MyTestClass();
        System.out.println("mtc 객체 : " + mtc);
/*      mtc.privateMember = "hello1";                                       */      // 컴파일 에러.
/*      System.out.println("mtc.privateMember = " + mtc.privateMember);     */      // 컴파일 에러.

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        _09_AccessModifier ac = new _09_AccessModifier();
        ac.testMember = "hello2";
        System.out.println("ac.testMember1 = " + ac.testMember);
    }
}
