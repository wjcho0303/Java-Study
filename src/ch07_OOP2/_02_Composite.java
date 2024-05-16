package ch07_OOP2;

public class _02_Composite {
    public static void main(String[] args) {
        // 이번에는 포함(composite) 관계에 대해 알아본다.
        // 포함이란 클래스의 멤버로 객체의 참조변수를 선언하는 것이다. 예를 들어 보자:

        //  class Point {        이렇게 평면 상의 점 좌표를 나타내는 class 가 있다고 하자.
        //       int x;
        //       int y;
        //  }

        //  원을 타나내는 클래스를 나타내보자.
        //  class Circle {
        //       int x; 원점 x좌표
        //       int y; 원점 y좌표
        //       int r; 반지름
        //  }
        //
        //  이번에는 다른 방식으로 나타내보자.
        //  class Circle {
        //      Point p = new Point();      // 원점의 (x,y) 좌표
        //      int r; 반지름
        //  }

        // 위의 사례는 Point 와 관계가 없는 거고, 아래의 사례는 Point 타입의 참조변수를 선언하고 있다.


        //  Circle c = new Circle();
        //  Circle 의 참조변수(Circle 의 리모컨) c는 Circle 의 인스턴스의 주소를 갖고 있는 것이고 c의 역할은 그게 다이다.
        //  c의 인스턴스 멤버 중에 Point 인스턴스의 주소를 갖고 있는 지역변수 리모컨 p가 있다.
        //  Point 의 x와 y에 필드에 접근할 때는 c.p.x 그리고 c.p.y 이렇게 접근할 수 있다.



//        다른 예시도 보자.
//
//        class Car {                   이런 사례도 포함이라고 한다.
//          Engine e = new Engine();
//          Door[] d = new Door[4];
//        }
//
//        class Engine {
//            int num;
//            Sting str;
//        }
//
//        Car car = new Car();          각각에 접근할 때는 마찬가지로 아래와 같은 방식으로 접근할 수 있다.
//                                      car.d[0]  car.d[1]  car.d[2]  car.d[3]
//                                      car.e.num   car.e.str
//
//        앞에서 배웠던 "상속관계"는 [is-a 관계]라고 부르고,
//        지금 배우고 있는 "포함관계"는 [has-a 관계]라고 부른다.
//        상속관계는 extends 라는 키워드를 통해 연결되고,
//        포함관계는 한 class 내에 다른 class 의 인스턴스가 생성되는 경우의 관계라고 볼 수 있다.
//
//        자바는 단일상속(Single Inheritance)만 허용한다. (C++ 은 다중상속 허용)
//        즉, class TvDVD extends Tv, DVD  이런식으로 extends 에 여러 개를 적으면 에러가 난다.
//
//        자바는 단일상속을 채택했으며, 다중상속이 장점도 있지만 단점도 있다.
//        특히 조상들의 필드나 메서드의 이름이 같은 경우에 접근할 때 ambiguous 상황이 발생할 수 있다.
//        실제로 자바 이후에 나온 많은 OOP 언어들도 단일상속을 채택했다. 그리고 interface 를 이용하면
//        다중상속과 비슷한 효과를 얻을 수 있기 때문에 굳이 다중상속을 고집할 필요도 없다.
//
//
//
//        하지만 interface 를 사용하지 않아도 상속과 포함관계를 섞어서 쓰면 되는 경우도 있다. 예를 들어 보자.
//
//        class Tv {
//
//            boolean power;
//
//            int channel;
//
//            void power() { power = !power;}
//
//            void channelUp() {++channel;}
//
//            void channelDown() {--channel;}
//
//        }
//
//
//        class DVD {
//
//            boolean power;
//
//            void power() { power = !power; }
//
//            void play() {내용생략;}
//
//            void stop() {내용생략;}
//
//            void rew() {내용생략;}
//
//            void ff() {내용생략;}
//
//        }
//
//        만약에 두 클래스의 속성을 혼합시킨 TvDVD 라는 클래스가 있다고 하자. 근데 다중상속은 안 되니까
//        비중이 높은 클래스를 하나 선택하여 그것만 상속시키고, 나머지는 포함관계를 통해 필요한 것만 가져다 쓴다.
//
//        class TvDVD extends Tv {
//            DVD dvd = new DVD();
//
//            void play() {
//                dvd.play();
//            }
//
//            void stop() {
//                dvd.stop();
//            }
//
//            void rew() {
//                dvd.rew();
//            }
//
//            void ff() {
//                dvd.ff();
//            }
//        }
//
//        필드가 많은 Tv의 경우에는 extends 를 통해 상속을 하고, (is-a 관계)
//        메서드가 많은 DVD 의 경우에는 has-a 관계를 이용하여 메서드를 호출하기만 해도 굳이 구현할 필요가 없어지게 된다.
//
//        만약 다중상속을 했다면 (가능하지도 않지만) 멤버변수 power 가 겹쳐셔 충돌이 났을 것이다.
//        그러나 포함관계를 이용하여 내부에서 다른 클래스의 인스턴스를 생성해서 메서드를 갖다 쓰면 충돌날 일이 없다.
//
//
//        프로그래밍을 할 때 클래스 간의 관계를 어떻게 결정해야 할지 모를 때는 다음의 방법이 도움된다:
//
//        Circle 은 Point 이다.            is - a 관계
//        Circle 은 Point 를 가지고 있다.   has - a 관계
//
//        둘 중에 무엇이 더 자연스러운 말일까? 아래가 더 자연스럽다.
//        즉, Circle extends Point 이렇게 상속을 받는 것보다
//        Circle 의 멤버로 Point 의 인스턴스를 생성해서 갖다 쓰는 게 더 자연스러운 상황이다.
//
//        class Circle {
//            Point p = new Point();
//            int r; 반지름
//        }
//
//        class Circle extends Point {
//            int r;
//        }
//
//        아래의 코드보다 위의 코드가 더 자연스럽다. 자연스럽게 코드를 작성해야
//        어차피 접근만 하면 되는 거 아닌가? 라고 생각할 수도 있겠지만,
//        나중에 가면 의도한 대로 코드가 작동하게 하고, 코드가 더 직관적이고 자연스러워지게 하려면 이렇게 하는 게 좋다.
//
//        is-a 관계, 즉 상속관계는 강력한 결합을 만들어내기 때문에 잘못 사용하면 유연성이 떨어지고 복잡성이 증가할 수 있다.
//        또, is-a 관계는 필드를 공유하고 확장한다는 특징이 있다는 점도 생각해야 한다.
//
//        has-a 관계는 클래스 간의 결합도가 상대적으로 약하므로 객체 간의 관계가 동적으로 변할 수 있는 경우에 유연성을 제공한다.
//
//        어떤 관계를 더 많이 사용하는지는 프로그래밍 분야에 따라 달라질 수 있다.
//
//
//
//        사실 위에서는 참조변수에 "단순 초기화" 방법을 통해 초기화 해주었지만 현업에서는 보통 생성자를 통해 초기화를 해준다.
//
//        class Circle {
//            Point p;
//            int r; 반지름
//
//            public Circle(int x, int y, int r) {
//                this.p = new Point();
//                this.p.x = x;
//                this.p.y = y;
//                this.r = r;
//            }
//        }
    }
}
