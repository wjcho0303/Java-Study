package ch07_OOP2;

class Point extends Object {
    protected int x;
    protected int y;

    public Point(){}
}

class Circle extends Object {
    protected Point p;
    protected int r;

    protected Circle() {
        Point p = new Point();
    }
}


public class _03_ObjectClass {
    public static void main(String[] args) {
//        Object 클래스는 모든 클래스의 조상이다. 이건 강제 사항이다.
//        즉, extends 를 하지 않았다고 해도 모든 클래스는 Object 의 자손 클래스이다.
//
//
//        class Tv {
//            // 클래스 내용      이렇게 보면 부모 클래스가 없는 클래스 같지만 사실 모든 부모가 없는 class 들은
//        }                     사실 컴파일러가 자동으로 아래의 작업을 수행해준 것이다.
//
//
//        class Tv extends Object {
//            // 클래스 내용
//        }
//
//        그렇다면 Object 클래스에는 어떤 필드가 있고 어떤 메서드들이 있는 것인가?
//        굉장히 많은 메서드가 있지만 많이 사용되는 것 몇 가지만 언급하고자 한다:
//        toString(), equals(Object obj), hashCode() 등

        Circle c1 = new Circle();
        System.out.println(c1.toString());      // ch07_OOP2.Circle@4e50df2e
                                                // toString() 메서드가 문자열을 return 한 것이다.
        Circle c2 = new Circle();
        System.out.println(c2.toString());      // ch07_OOP2.Circle@1d81eb93

//      사실 toString()을 붙이지 않아도 똑같이 출력할 수 있다.
        System.out.println(c1);                 // ch07_OOP2.Circle@4e50df2e

//      즉, c1을 출력하라는 명령과 c1.toString()을 출력하라는 명령이 같은 결과를 낸다는 걸 알 수 있다.
    }
}
