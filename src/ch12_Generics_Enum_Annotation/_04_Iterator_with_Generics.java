package ch12_Generics_Enum_Annotation;
import java.util.*;

//
//      Iterator 가 일반 클래스일 때는 아래와 같이 되어 있다.
//
//      public interface Iterator {
//          boolean hasNext();
//          Object next();
//          void remove();
//      }
//
//      그런데 여기에 타입변수를 사용해주어 지네릭스 클래스로 바꿔주면 아래와 같이 된다:
//
//      public interface Iterator<E> {
//          boolean hasNext();
//          E next();
//          void remove();
//      }
//
//      지네릭스 클래스로 바꿔줌으로써 Object 가 반환되어야 할 메서드를 타입변수 E를 반환하도록 만들었다.
//
//      일반 클래스일 때 Iterator 사용할 때, 다른 객체 타입의 참조변수에 저장해야 할 때는
//      아래와 같이 형변환을 해줬어야 했다.
//                  Iterator it = list.iterator();
//                  while(it.hasNext()) {
//                      Student s = (Student)it.next();
//                      ...
//                  }
//
//      하지만 Iterator 를 지네릭스를 사용하면
//      아래와 형변환을 적지 않아도 된다.
//                  Iterator<Student> it = list.iterator();
//                  while(it.hasNext()) {
//                      Student s = it.next();
//                      ...
//                  }
//      Iterator<Student> it = list.iterator(); 이걸 실행하는 순간 위에 봤던 Iterator<E>의
//      E next(); 메서드가 Student next(); 메서드로 반환 타입이 바뀐다. 이게 지네릭 클래스의 장점이다.
//      메서드들이 일괄적으로 반환타입이 바뀌기 때문에 일일히 형변환을 안 해 줘도 된다.
//

class Student {
    String name = "";
    int ban;
    int no;

    Student(String name, int ban, int no) {
        this.name = name;
        this.ban = ban;
        this.no = no;
    }
}
public class _04_Iterator_with_Generics {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("자바왕", 1, 1));
        list.add(new Student("자바짱", 1, 2));
        list.add(new Student("홍길동", 2, 1));

        Iterator<Student> it = list.iterator();
//      Iterator it = list.iterator();
        while (it.hasNext()) {
            //  Student s = (Student)it.next(); // 지네릭스를 사용하지 않으면 형변환 필요.
//            Student s = it.next();
//            System.out.println(s.name);
            System.out.println(it.next().name); // <-- 위의 두 줄을 이렇게 한 줄로 써도 된다.
        }
    }
}
