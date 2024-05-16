package ch12_Generics_Enum_Annotation;

//
//      표준 애너테이션 몇 가지를 살펴보겠다.
//
//      @Override
//      - 오버라이드를 올바르게 했는지 컴파일러가 체크하게 해주는 애너테이션이다.
//      - 오버라이딩할 때 메서드 이름의 대소문자를 잘못 적는 실수를 하는 경우가 많다.
//      - 근데 컴파일러는 메서드 이름이 다르다고 인식해도 그냥 새로운 메서드라고 여기고 알려주지 않는다.
//      - 그래놓고 실행할 때 왜 메서드가 호출이 안되지? 이러고 있는 것이다.
//
//      - 위와 같은 문제를 예방하기 위해 @Override 를 붙여주는 것이다.
//      - 만약 @Override 를 붙여놓고 오버라이딩을 했을 때, 문제가 생기면 컴파일러가 경고를 해준다.
//
//
//        class Parent {
//            void parentMethod() { }
//        }
//
//        class Child extends Parent {
//            @Override               // 그러면 @Override 에 빨간 밑줄이 그어진다.
//            void parentmethod() { } // 조상 메서드의 이름을 잘못 적었음.
//        }
//
//
//
//      @Deprecated
//      - 앞으로 사용하지 않을 것을 권장하는 필드나 메서드에 붙인다.
//      - 예시:
//
//      @Deprecated
//      public int getDate() {
//          return normalize().getDayOfMonth();
//      }
//
//      이 예시에서는 getDate() 메서드 사용을 권장하지 않는다는 의미로 쓴 것이다.
//      보통 메서드를 쓰면 문제가 발생하거나, 더 좋은 메서드가 생겨나서 미사용 결정이 난 경우에 사용한다.
//      ??? 안 쓸 거면 없애면 되는 거 아닌가? Java 가 하위호환성을 중요시 하는 언어이다 보니...
//      실제로, @Deprecated 가 붙은 멤버나 메서드를 사용하면 Note 메시지가 뜬다.
//              Note: ~~ uses or overrides a deprecated API.
//              Note: Recompile with -Xlint:deprecation for details.
//      에러는 아니고 그냥 경고다.
//
//
      class Parent {
          void parentMethod() { }
      }

      class Child extends Parent {
          @Override
          @Deprecated
          void parentMethod() { }
      }

public class _13_JavaAnnotation {
    public static void main(String[] args) {
        Child c = new Child();
        c.parentMethod();           // 이걸 쓰려고 paren~ 입력하려고 하면 아래 자동완성이 뜨는데, 거기서
    }                               // parentMethod() 에 중간 취소선이 그어져 있다.
                                    // 이렇게 중간 취소선이 그어져 있다는 것은 @Deprecated 이 붙었다는 뜻이다.

    // 참고로, Note 메시지는 cmd 창에서 볼 수 있음...
    // 현재 프로젝트가 있는 디렉토리에서 cmd 창을 열고 javac _13_JavaAnnotation.java 엔터 치면 Note 메시지 나온다.
    // 그리고 거기서 javac -Xlint:deprecation for details 라고 입력하고 엔터치면 상세한 내용이 뜬다.
}


//
//      @FunctionalInterface
//      함수형 인터페이스에 붙이면, 컴파일러가 올바르게 작성했는지 체크한다.
//      함수형 인터페이스는 "하나의 추상 메서드만 가져야 한다"는 제약이 있다(14장에 나옴).
//      이걸 붙이면 컴파일러가 제대로 작성했는지 체크해준다.
//
//      @FunctionalInterface
//      public interface Runnable {
//          public abstract void run();
//      }
//
//      만약 저기에 메서드를 하나 더 쓰게 되면 @FunctionalInterface 부분에 빨간 줄이 생긴다.
//
//
//
//      @SuppressWarnings(String warning)
//      이 애너테이션을 붙이면 컴파일러의 경고메시지가 나타나지 않게 한다.
//      그리고 괄호 안에 억제하고자 하는 경고의 종류를 문자열로 지정한다.
//
//      @@SuppressWarnings("unchecked")     <-- 지네릭스와 관련된 경고 억제
//      ArrayList list = new ArrayList();   <-- 지네릭 타입을 지정하지 않음. 권장되지 않는 방식임.
//      list.add(obj);                      <-- 원래대로면 여기서 unchecked 경고가 발생함
//
//      둘 이상의 경고를 넣을 수도 있다. @SuppressWarnings("deprecation", "unchecked", "varargs", ... )
//
//      위에서와 마찬가지로 커맨드 창에서 -Xlint 옵션으로 컴파일하면(javac) 경고메시지를 확인할 수 있는데,
//      @SuppressWarnings 의 괄호 안에 넣은 경고 타입을 넣으면 컴파일 했을 때 경고메시지가 안 뜬다.
//      경고는 잠재적 위험이기 때문에 신중하게 사용해야 한다.
//      초보 개발자는 코드 관리에 미숙하기 때문에 쓰지 않는 것이 권장된다.
//
//   * 메타 애너테이션은 영상만 보고 메모는 생략한다. 관련 영상은 아래 링크로 참고:
//   https://www.youtube.com/watch?v=p7KStWk8hWU&list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp&index=146
