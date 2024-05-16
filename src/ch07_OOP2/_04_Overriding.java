package ch07_OOP2;

// 오버라이딩이란? 상속받은 조상의 메서드를 자신에 맞게 변경하는 것!
// 다만 선언부는 바꿀 수 없고 { } 구현부만 변경 가능! 메소드 이름이랑 매개변수도 같아야 한다.
// 접근제어자의 경우 접근 범위가 동일하거나 넓어질 수는 있지만 "좁아지면 안 된다"는 제한이 있다.
// 예를 들어 Object 의 toString() 메서드는 원래 public 이기 때문에 protected 이런 접근제어자를 붙일 수 없다는 말이다.

// 이러한 규칙이 존재하는 이유는 자손 클래스가 상위 클래스의 기능을 모두 포함하고 접근이 가능해야 하기 때문이다.
// 만약 오버라이딩을 하면서 접근 범위를 줄여버리면 조상 타입의 참조 변수를 통해 접근할 때 메서드에 접근할 수 없게 되어버린다.
// 이는 다형성을 위배하는 것이다.

//  왜 오버라이딩을 하면서 접근 범위를 줄이면 문제가 되는지 예시를 통해 알아보자.
//  class Parent {
//      public void printMessage() {
//          System.out.println("Parent's message");
//      }
//  }
//  처음에 조상의 메서드는 접근 제어자가 public 인 상태이다.
//
//
//  class Child extends Parent {
//      private void printMessage() {
//          System.out.println("Child's message");
//      }
//  }
//  자손의 오버라이딩 메서드에서 접근 제어자가 public 에서 private 에서 줄어들었다.
//  실제로 이렇게 하면 컴파일 에러가 나지만 왜 문제가 되는지 설명하기 위해 private 으로 작성했다.
//
//
//  public class Main {
//      public static void main(String[] args) {
//          Parent parent = new Child();
//          이렇게, 참조변수 타입은 조상 클래스의 것으로 하고 인스턴스는 자손의 타입으로 객체를 생성한다.
//
//          parent.printMessage();
//          이 코드를 통해 실행되는 메서드는 어찌됐든 Child 인스턴스로 호출하는 것이므로 Child 의 printMessage()이다.
//          그런데 자손 클래스에서 오버라이딩할 때 private 접근제어자로 설정해버렸기 때문에,
//          오직 Child 타입의 참조변수로만 접근이 가능한 상황이 되어버렸다.
//          또, 이렇게 private 로 접근 범위를 줄여버리면 아예 오버라이딩이 막혀버려 이후의 자손 클래스에 전달하지 못하게 된다.
//      }
//  }
//
//  그런데, 스프링 부트 프로젝트를 하다 보면 BaseEntity 클래스에 private 접근 제어자를 가진 LocalDateTime 타입의
//  createdAt과 updatedAt 필드가 있고, 이것들을 다양한 클래스에 extends 를 통해 상속하는 경우를 많이 볼 수 있다.
//  그리고 이렇게 하면 실제로 해당 자손 엔티티의 DB 상에서 createdAt 과 updatedAt 필드가 생성된 것을 볼 수도 있다.
//  그럼 private 인데도 상속이 된 것인가? 라는 생각이 들 수 있다. 하지만 이는 필드가 진짜로 상속된 것은 아니고,
//  단지 JPA 가 BaseEntity 의 private 필드에 대해 reflection 기능을 사용하여 접근하고 매핑해준 것이다.
//  즉, JPA 의 reflection 기능 덕분에 DB 에 BaseEntity 의 필드들이 생긴 것이지, Java 코드 상에서 필드가 상속된 건 아니다.


class Point01 {
    int x;
    int y;
    String getLocation() {
        return "x: " + x + ", y: " + y;
    }
    public String toString() {      // 지금 이건 Object 클래스의 toString() 메서드를 오버라이딩 하는 것이다.
        String result = "";         // 원래 Object class 의 toString() 메서드에 public 이 붙었기 때문에 사용함.
                                    // 참고로, 예외를 적을 때도 조상 클래스의 메서드보다 많이 선언할 수 없다.

        result = result + "x: " + x + ", y: " + y;
        return result;
    }
}

class Point3D01 extends Point01{
    int z;

    // 조상의 getLocation()을 오버라이딩
    @Override
    String getLocation() {
        return "x: " + x + ", y: " + y + ", z: " + z;
    }

    // 물론 이렇게 오버라이딩을 하지 않았어도 부모로부터 getLocation()을 상속받았기 때문에 쓸 수는 있다. 그런데
    // 현재의 class 기능 상 맞지 않기 때문에 이름을 그대로 쓰되, 기능은 좀 class 상황에 맞게 바꾸고 싶은 것이다.
    // 당연히 이렇게 오버라이딩을 하고 나서 참조변수는 Point3D01의 참조변수(리모컨)로 호출해야 이 오버라이딩 된 메소드가
    // 호출되는 것이다.

    public String toString() {
        String result = "";
        result += "x: " + x + ", y: " + y + ", z: " + z;
        return result;
    }
}


public class _04_Overriding {
    public static void main(String[] args) {

        Point3D01 p = new Point3D01();
        p.x = 3;
        p.y = 5;
        p.z = 7;

        System.out.println(p.getLocation());            // 출력결과     x: 3, y: 5, z: 7

        Point01 originalP = new Point01();
        originalP.x = 8;
        originalP.y = 9;
//        originalP.z = 10;  자신이 가지지 않은 필드이므로 오류 발생
        System.out.println(originalP.getLocation());    // 출력결과     x: 8, y: 9

        // 이와 같이 메서드 이름이 똑같지만 참조변수가 가리키는 class가 부모인지 자손인지에 따라
        // 메서드도 그에 맞게 호출된다.

        System.out.println(p.toString());
        System.out.println(originalP.toString());



        // 오버로딩과 오버라이딩?
        // 둘은 서로 전혀 다른 거다. 용어가 비슷해서 헷갈리는 것일 뿐

        // 오버로딩은 메소드 이름만 똑같지 아예 메서드 자체가 완전 새롭다. 매개변수가 다를 수도 있고
        // 메서드 반환 자료형이 다를 수도 있다. 그리고 오버로딩은 상속과 상관이 없는 개념이다.
        // 오버로딩을 하는 것은 완전히 새로운 메소드를 만드는 것이라고 볼 수 있다.

        // 반면 오버라이딩은 애초부터 상속이랑 깊은 관련이 있는 것이다.
        // 부모로부터 물려받은 메소드를 완전히 똑같은 메소드명과 매개변수까지 똑같이 받아야 하기 때문이다.
        // 다르게 할 수 있는 부분이라곤 구현부 정도만이다.
        // 어떤 메소드가 오버로딩된 것인지 오버라이딩 된 것인지 판단하는 기준은 ?
        // 부모에게서 가져온 메서드(O.R)냐 자기 자신의 것에서 매개변수나 자료형을 다르게 해서 가져왔냐(O.L) 그 차이다.
    }
}

