package ch06_OOP1;

//  오버로딩은 메서드 이름을 똑같이 쓸 수 있게 허용해주는 자바의 기능이다.
//  오버로딩이 가능하려면 아래 두 가지 기준을 만족 해야 한다:
//      1) 메서드명이 같다. (오버로딩을 하는 목적 그 자체이긴 함.)
//      2) 매개변수의 패턴이 다르다. (매개변수의 타입, 순서, 개수가 다르다.)
//
//  참고로, 반환 타입이 다르면 오버로딩이 아예 허용되지 않는다. 즉, 반환 타입이 다르면 메서드 이름도 다르게 해야 한다.
//
//  오버로딩 된 메서드는 이름만 같지, 사실상 서로 다른 메서드이긴 하다.
//  실제로도 각 오버로딩 메서드에 전혀 다른 로직을 구현시킬 수도 있다.
//  하지만 프로그래밍에서 오버로딩을 하는 목적은 다양한 패턴으로 매개변수를 입력 받아 동일한 또는 유사한 기능을 하는 함수를
//  똑같은 이름으로 작성하는 것이다. 그렇기 때문에 오버로딩 메서드(이름이 똑같은 메서드)를 정의할 때는 혼동이 없도록
//  동일하거나 유사한 기능을 작동시키도록 로직을 짜는 것이 자연스럽다.


class ExampleClass {
    int value;

    public String helloMethod(int x, int y, String z) {
        // 구현 내용
        return "";
    }

/*    public int helloMethod(int x, int y, String z) {
        // 구현 내용
        return 0;
  }                                                     */
    // 컴파일 에러 발생: helloMethod(int, int, String) is already defined in 'ch06_OOP1.ExampleClass'

    public int helloMethod2(int x, int y, String z) {
        // 구현 내용
        return 0;
    }
    // 이렇게, 반환타입이 다르면 다른 조건이 모두 맞아도 오버로딩이 불가하다.
}


//      1) this 는 현재 객체를 가리키는 참조변수 대신에 쓰는 것이다. 자기 객체의 주소값을 저장한다.
//      this. 을 사용하면 매개변수로 들어온 지역변수의 이름과 객체의 필드이름이 같을 경우에 구분이 가능해진다.
//
//      2) this() 는 같은 클래스 내에서 다른 오버로딩 생성자를 호출하기 위해 사용한다.
//      this() 안에 매개변수들을 입력하면 컴파일러가 알아서 매개변수 패턴에 맞게 해당 오버로딩 생성자를 찾아준다.
//      (ambiguous 문제에 유의할 것)


public class _09_Overloading_Constructor_This {
    public static void main(String[] args) {
        // new 키워드 : 인스턴스를 생성하는 것은 new 키워드가 해주는 것이다.
        // 생성자: 인스턴스를 초기화하는 기능을 담당한다.
        // 생성자에는 필드 자체를 초기화하는 작업을 넣을 수도 있고, 내부에 다른 메서드를 호출할 수도 있다.
        // new 키워드를 통해 인스턴스를 생성할 때는 항상 new 뒤에 생성자가 와야 하기 때문에 이 점을 분명히 구분해서 생각해야 한다.

        // 지금까지 Tv tv1 = new Tv(); 라고 할 때 new Tv(); 부분이 바로 인스턴스 생성이라고 했엇다.
        // 모든 클래스는 반드시 생성자를 가져야 한다. 만약 생성자를 작성하지 않으면 컴파일러가 자동으로 기본생성자를 생성해준다.
        // 생성자 자체가 객체를 만드는 것이 아니라, new 가 객체를 만든다는 것을 꼭 기억하자!!

        // Tv 라는 class 이렇게 있다고 하자.

//  class Tv {
//      String color;
//      boolean power;
//      int channel;
//
//      void power() { power = !power; }
//
//      void channelUp() { channel++; }
//
//      void channelDown() {channel--;}
//
//      여기 Tv 클래스 내부에 생성자 메서드를 만들 것이다.
//      * 생성자 메서드 이름은 클래스명과 같아야 한다. :                   Tv() {};
//      * 생성자 메서드는 리턴값이 없다. 그런데 void 도 붙이지 않는다.
//      * 일반적으로 생성자 구현부는 대입문으로 이루어져 있다.
//
//
//      Tv() {
//          this("black", false, 0);
//      }
//
//      Tv(String color) {
//          this(color, false, 0);
//      }
//
//      Tv(int channel) {
//          this("white", false, channel);
//      }
//
//      Tv(String color, boolean power, int channel) {
//          this.color = color;                       보통 생성자 메서드를 오버로딩할 때 이런식으로 this() 메서드를 쓰는데,
//          this.power = power;                       다른 생성자를 호출할 때 this() 메서드를 쓴다.
//          this.channel = channel;                   사실 this() 에서 this 는 생성자 자신이다. 즉, Tv 이다.
//      }
//      이렇게 this. 을 사용하면 매개변수로 들어온 지역변수의 이름과 객체의 필드이름이 같을 경우에 구분이 가능해진다.
//      만약 this 를 사용하지 않으면 color = color, power = power, channel = channel 이렇게 되는데
//      이렇게 되면 안 되니까 객체 자기 자신의 특정 필드를 나타내기 위해 참조변수 this 를 사용하는 것이다.



//      그렇기 때문에 this() 메서드가 없으면 아래와 같이 써야 한다:
//
//      Tv() {
//          Tv("black", false, 0);
//      }
//
//      Tv(String color) {
//          Tv(color, false, 0);
//      }
//
//      Tv(int channel) {
//          Tv("white", false, channel);
//      }
//
//      Tv(String color, boolean power, int channel) {
//          this.color = color;
//          this.power = power;
//          this.channel = channel;
//      }
//
//      지금은 클래스명이 Tv 라서 별로 어렵지 않아 보이지만 클래스명이 길었다면 귀찮았을 것이다.
    }
}
