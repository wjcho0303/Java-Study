package ch12_Generics_Enum_Annotation;
import java.util.*;

//
//      HashMap 에도 지네릭스를 활용할 수 있다.
//      특히, HashMap 에 사용할 때는 보통 다음과 같이 타입 변수를 두 개 사용한다.
//      타입 변수는 뭐 꼭 두 개만 사용하는 건 아니고 여러 개 사용해도 된다.
//      다만 여러 개일 때는 콤마(,)로 구분해줘야 한다.
//
//      HashMap<K,V>
//      HashMap<String, Student> map = new HashMap<String, Student>(); // 지네릭스 HashMap 생성
//      지네릭 클래스의 객체를 생성할 때는, 마찬가지로 왼쪽과 오른쪽의 < > 안에 들어가는 내용이 "일치해야" 한다.

//      map.put("자바왕", new Student("자바왕", 1,1,100,100,100)); // HashMap 에 데이터 저장
//              Key         Student 객체 (그냥 생성자 방식으로 쓴 것)
//
//      위와 같이 HashMap 에 타입변수 <K,V> 를 붙이면 아래와 같은 지네릭스 클래스가 만들어 진다.

//      public class HashMap<K, V> extends AbstractMap<K,V> {
//          ...
//          public V get(Object key) { ... }
//          public V put(K key, V value) { ... }
//          public V remove(Object key) { ... }
//          ...
//      }
//      (꼭 K, V를 써야 하는 건 아니다. 그냥 의미를 드러내기 위해 K, V 알파벳을 선택한 것일 뿐.)
//
//      그리고 K와 V에 각각 String 과 Student 를 넣으면서 아래와 같이 지네릭 클래스로 바뀐다.
//      public class HashMap<String, Student> extends AbstractMap<K,V> {
//          ...
//          public Student get(Object key) { ... }
//          public Student put(String key, Student value) { ... }
//          public Student remove(Object key) { ... }
//          ...
//      }
//
//      Student s1 = map.get("1-1");  이렇게 형변환 없이 바로 메서드 사용 가능!
//      지네릭스를 만약 안 썼다면?
//      Student s1 = (Student)map.get("1-1"); 이렇게 했어야 했다.
//      왜? 리턴이 Student 가 아니라 Object 이기 때문에...
//
//
//
class Student1 {
    String name = "";
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    Student1(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}

public class _05_HashMap_with_Generics {
    public static void main(String[] args) {
//      HashMap<String, Student> map = new HashMap<String, Student>();
        HashMap<String, Student1> map = new HashMap<>();  // <-- JDK1.7 부터 오른쪽 생략 가능해졌다.
        map.put("자바왕", new Student1("자바왕", 1, 1, 100, 100, 100));
//      Student1 s = (Student1)map.get("자바왕"); get 의 반환타입이 Object 이기 때문에 옛날엔 해줬어야 했다.
        Student1 s = map.get("자바왕");

        System.out.println(map);
    }
}
