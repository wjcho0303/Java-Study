package ch11_CollectionsFramework;
import java.util.*;

//      HashSet 이 Set 인터페이스의 대표적이면서도 기본적인 구현체라고 볼 수 있다.
//      Set 은 데이터가 중복되지 않고, 데이터 간의 순서가 존재하지 않는다고 했는데, HashSet 이 그렇다.
//      만약 중복을 허용하지는 않으면서 순서는 부여하고 싶다면 LinkedHashSet 를 쓰면 된다.
//
//      HashSet 클래스가 가진 메서드를 살펴보자. 먼저 생성자 메서드부터 보자:
//      HashSet()
//      기본생성자
//
//      HashSet(Collection c)
//      입력한 컬렉션으로 HashSet 을 만드는 생성자
//
//      HashSet(int number)
//      HashSet 의 초기용량(initial Capacity) 입력하여 만드는 생성자 (배열의 길이와 같음)
//
//      HashSet(int number, float loadFactor)
//      int number 로 초기용량을 입력하고, loadFactor 는 0에서 1 사이의 소수를 입력하는데, 만약 0.8 을 입력하면
//      용량의 80%가 찼을 때 입력한 number 만큼 용량이 추가된다.
//
//      그 외 HashSet 의 메서드를 보자
//      boolean add(Object obj)             추가하고 성공여부 리턴
//      
//      boolean addAll(Collection c)        추가하고 성공여부 리턴
//
//      boolean remove(Object obj)          삭제하고 성공여부 리턴
//
//      boolean removeAll(Collection c)     삭제하고 성공여부 리턴
//
//      boolean retainAll(Collection c)     겹치는 것만 남기고 변화 여부 리턴
//
//      void clear()                        모두 삭제
//
//      Set 은 집합이니까 집합과 관련된 연산이 있는 것은 당연하다.
//
//
//      boolean contains(Object obj)        포함 여부 확인
//
//      boolean containsAll(Collection c)   포함 여부 확인
//
//      Iterator iterator()                 조회를 위한 iterator 객체 생성
//
//      boolean isEmpty()                   비어있는지 여부 확인
//
//      int size()                          들어 있는 데이터가 몇 개인지 확인 (용량이 아니다)
//
//      Object[] toArray()                  Set 에 저장된 객체를 배열로 리턴
//
//      Object[] toArray(Object[] a)        Set 에 저장된 객체를 배열로 리턴
//
//


public class _12_1_HashSet {
    public static void main(String[] args) {
        Object[] objArr = {"1",new Integer(1),"2","2","3","3","4","4","4"};
        // 중복된 요소들로 이루어진 객체 배열을 생성한 모습. 이 때까진 중복이 허용된다.
        // 문자열 "1"과 Integer 1 둘 다 존재한다는 점을 주의하자.

        Set set = new HashSet();
        // HashSet 을 생성한 모습

        for(int i=0; i < objArr.length; i++) { // HashSet 에 objArr 의 요소들을 저장하는 모습
            System.out.println(objArr[i] + " = " + set.add(objArr[i]));
            // 중복된 요소들이 버려지게 된다. 중복된 애들의 경우 false 가 return 된다.
        }
        // HashSet 에 저장된 요소들을 출력
        System.out.println(set);

        // HashSet 에 저장된 요소들을 출력할 Iterator 조회용 객체 생성 (Iterator 이용)
        Iterator it = set.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
        // 참고로, 출력을 해보면 저장한 순서를 유지한 것이라 착각할 수 있는데,
        // 순서를 유지하는 것이 보장되지 않으므로 이 점은 주의하도록 하자.

        System.out.println("------------------------------");

        Set set2 = new HashSet();

        for (int i = 0; set2.size() < 6 ; i++) {    // 데이터를 5개만 넣기로 설정
            int num = (int)(Math.random()*45) + 1;  // 1 과 45 를 포함한 범위의 정수 저장
            set2.add(new Integer(num));             // 위에서 정의한 난수를 객체형 정수 형태로 데이터 삽입
        }// set2.add(num) 이렇게 써도 컴파일러가 자동으로 위와 같이 auto-boxing 해줌.

        System.out.println("정렬하기 전 상태의 set2: "  + set2 + "\n");


        List list = new LinkedList(set2); // LinkedList(Collection c)
                                          // 위에서 만들어진 set2 를 LinkedList 로 생성. 순서가 존재하게 됨.

        Collections.sort(list);          // 순서가 존재하게 한 후 Collections.sort(List list)
                                         // static 메서드를 이용해서 오름차순으로 정렬
        System.out.println("순서를 저장할 수 있는 LinkedList 를 새로 생성하여 거기에 set2의 모든 요소 저장");
        System.out.println("List list = new LinkedList(set2);"+"\n");

        System.out.println("Collections.sort(list);"+"\n");

        System.out.println("System.out.println(list);");
        System.out.println(list);

        System.out.println("------------------------------");

        HashSet set3 = new HashSet();

        set3.add("abc");
        set3.add("abc");    // String 을 두 번 저장
        set3.add(new Person("David",10));
        set3.add(new Person("David",10));   // Person 객체를 두 번 저장

        System.out.println(set3);
        // 출력해보면 문자열 abc 는 한 개만 존재하고 David 은 두 명이 존재한다.
        // 이렇게 객체는 중복 제거가 되지 않는다. 왜 그러냐면 equals()와 hashCode() 를
        // Person Class 에 @Override 하지 않았기 때문이다.

        // HashSet 이 바르게 동작하게 하려면 equals() 메서드와 hashCode() 메서드를
        // 오버라이딩 해주는 게 정석이다. 사실 HashSet 뿐만 아니라 웬만한 클래스 만들 때도 만들어둔다.
        // 그래서 IDE 프로그램에 hashCode() 와 equals() 메서드를 자동으로 만들어주는 기능이 있을 정도다.
        // 아래에 hashCode() 와 equals() 를 주석처리하고 실행해보면서 있을 때와 없을 때의 차이를 비교해보자.
    }
}
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name +":"+ age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age); // <--- hash() 메서드 안에 iv 들을 모두 넣으면 된다.
    }                                   // 객체의 동일함 여부를 판단할 때는 iv 값이 모두 같아야 같은 객체이기 때문이다.
    // 물론 현실에서는 이름과 나이만으로는 같은 사람인지 판단하기 어렵지만 간단한 예시라서 이렇게 하는 것이다.

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person)) return false;
        // 일단 obj 가 Person 클래스 객체인지 먼저 확인하고 진행해야 한다.
        Person p = (Person)obj;
        // Person 객체인 게 확인되었으면 obj 참조변수를 Person 의 참조변수로 형변환 한다.
        // 왜냐하면 파라미터 obj 를 넣을 때 Object 인 상태이기 때문이다.
        // name 과 age 라는 멤버변수는 Object 에 있는 게 아니라 Person 에 있는 것이기 때문에
        // 이렇게 형변환을 하지 않으면 에러가 난다.
        return
                (this.name.equals(p.name)) &&
                (this.age == p.age);
        // 지금은 조건이 두 개이지만 iv 가 많을 수록 return 문에 들어가는 식이 더 길어질 것이다.
        // 이렇게 하면 이제 David 이 두 개가 안 뜨고 한 개만 뜬다.
    }
}