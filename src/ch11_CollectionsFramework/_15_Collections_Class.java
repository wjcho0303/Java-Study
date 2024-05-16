package ch11_CollectionsFramework;
import java.util.*;
import static java.util.Collections.*;
// import static 을 통해 Collections 선언을 생략 가능하게 해준다.


//      여기서 설명하는 것은 Collection interface 가 아니라 Collection"s" 클래스에 대한 것이다. 헷갈리지 말자.
//      Collections 클래스는 Collection interface 를 구현한 객체들을 위해 다양한 static 메서드를 제공한다.
//
//      1. 컬렉션 채우기(fill()), 복사(copy()), 정렬(sort()), 검색(binarySearch()) 등의 메서드가 있다.
//
//      2. 컬렉션을 동기화시키는 메서드가 있다.                     synchronizedXXX()
//          static  Collection   synchronizedCollection(Collection c)
//
//          static  List        synchronizedList(List list)
//
//          static  Set         synchronizedSet(Set set)
//
//          static  Map         synchronizedMap(Map map)
//
//          static  SortedSet   synchronizedSortedSet(SortedSet ss)
//
//          static  SortedMap   synchronizedSortedMap(SortedMap sm)
//
//      옛날의 자료구조 인터페이스나 클래스는 대부분 동기화가 되어 있었다. 그런데 왜 새로 나온 자료구조들은 동기화가 안 되어 있을까?
//      필요없을 때와 필요할 때가 존재하기 때문이다. 필요할 때면 상관 없는데 필요 없는데도 동기화가 되어 있으면 성능을 저하시킨다.
//      그 대신 필요하면 위와 같이 필요하면 동기화 시킬 수 있는 메서드를 구비해놓았다.
//
//      사용 예시는 다음과 같다:
//      List syncList = Collections.synchronizedList(new ArrayList(...));
//      맨 오른쪽 파라미터를 넣는 소괄호 안에는 동기화 되지 않은 List 를 넣은 모습을 보여준다.
//
//
//      3. 변경불가(readOnly) 컬렉션 만들기                       unmodifiableXXX()
//          static  Collection      unmodifiableCollection(Collection c)
//
//          static  List            unmodifiableList(List list)
//
//          static  Set             unmodifiableSet(Set set)
//
//          static  Map             unmodifiableMap(Map map)
//
//          static  NavigableSet    unmodifiableNavigableSet(NavigableSet ns)
//
//          static  SortedSet       unmodifiableSortedSet(SortedSet ss)
//
//          static  NavigableMap    unmodifiableNavigableMap(NavigableMap nm)
//
//          static  SortedMap       unmodifiableSortedMap(SortedMap sm)
//
//
//
//      4. Singleton 컬렉션 만들기 (객체 한 개만 저장하는 컬렉션) -   singletonXXX()
//          static  List    singletonList(Object obj)
//
//          static  Set     singleton(Object obj)   // singletonSet 이 아니라 그냥 singleton 이다. 주의할 것
//
//          static  Map      singletonMap(Object key, Object value)
//
//
//      5. 한 종류의 객체만 저장하는 컬렉션 만들기                   checkedXXX()
//          static  Collection      checkedCollection(Collection c, Class type)
//
//          static  List            checkedList(List list, Class type)
//
//          static  Set             checkedSet(Set set, Class type)
//
//          static  Map             checkedMap(Map map, Class keyType, Class valueType) K-V 구조
//
//          static  Queue           checkedQueue(Queue queue, Class type)
//
//          static  NavigableSet    checkedNavigableSet(NavigableSet ns, Class type)
//
//          static  SortedSet       checkedSortedSet(SortedSet ss, Class type)
//
//          static  NavigableMap    checkedNavigableMap(NavigableMap nm, Class keyType, Class valueType) K-V 구조
//
//          static  SortedMap       checkedSortedMap(SortedMap sm, Class keyType, Class valueType) K-V 구조
//
//          예를 들어 보자.
//          List list = new ArrayList();
//          List checkedList = checkedList(list, String.class);  이렇게 하면 이제 String 만 저장 가능하게 된다.
//          checkedList.add("abc");             <--- 정상 작동
//          checkedList.add(new Integer(3));    <--- 에러 발생 ClassCastException 뜬다.
//
//          사실 이렇게 한 가지 종류의 객체만 넣을 수 있게 해주는 게 바로 지네릭스인데, 다음 파일에서 언급할 것이다.
//          지네릭스는 JDK 1.5 부터 등장하였다. (Java 8 이 JDK 1.8임) 그래서 지네릭스 나오기 전에는
//          한 종류의 객체만 넣게 하고 싶을 때 이렇게 checked~~~() 메서드를 썼어야 했다.


public class _15_Collections_Class {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list + " 아직 list에 아무것도 담지 않음");

        addAll(list, 1,2,3,4,5);
        System.out.println(list + " <--- addAll(list, 1,2,3,4,5); 의 결과");

        rotate(list, 2);  // 모든 요소의 순서를 오른쪽으로 두 칸씩 이동시킨다
        System.out.println(list + " <--- rotate(list, 2); 의 결과");

        swap(list, 0, 2); // index 0 과 index 3 value 의 위치를 서로 교환(swap)
        System.out.println(list + " <--- swap(list, 0, 2); 의 결과");

        shuffle(list);    // 저장된 요소의 위치를 임의로 변경
        System.out.println(list + " <--- shuffle(list); 의 결과. 순서가 랜덤으로 바뀌었다.");

        sort(list, reverseOrder()); // 역순 정렬 reverse(list);와 동일
        System.out.println(list + " <--- sort(list, reverseOrder()); 의 결과. 역순으로 정렬되었다.");

        sort(list);       // 정렬
        System.out.println(list + " <--- sort(list); 의 결과");

        int idx = binarySearch(list, 3);  // 3이 저장된 위치(index)를 반환
        System.out.println("index of 3 = " + idx + " <--- (binarySearch(list, 3); 의 결과)");

        System.out.println("max="+max(list) + " <--- max(list) 메서드 사용");
        System.out.println("min="+min(list) + " <--- min(list) 메서드 사용");
        System.out.println("min="+max(list, reverseOrder())  + " <--- max(list, reverseOrder()) 메서드 사용. min(list)와 같음");

        fill(list, 9); // list를 9로 채운다.
        System.out.println("list="+list + " <--- fill(list, 9); 의 결과");

        // nCopies(int size, Object value)
        List newList = nCopies(list.size(), 2); // list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 단, 결과는 변경불가
        System.out.println("List newList = nCopies(list.size(), 2);");
        System.out.println("newList="+newList);

        // boolean disjoint(Collection c1, Collection c2) : c1 과 c2 가 서로 공통점이 "없는지" 여부 확인
        System.out.println(disjoint(list, newList) + " <--- disjoint(list, newList) 의 결과"); // 공통요소가 없으면 true

        // copy(Collection c1, Collection c2) : c1 에다가 c2 를 복사 (오른쪽이 복사 대상임)
        copy(list, newList);
        System.out.println("newList="+newList + " <--- copy(list, newList); 의 결과. 오른쪽이 복사 대상임");
        System.out.println("list="+list);

        replaceAll(list, 2, 1);
        System.out.println("list="+list + " <--- replaceAll(list, 2, 1); 의 결과. value 가 2인 것들을 모두 1 로 변경");

        // enumeration(Collection c) : iterator 와 같음. 자주 쓰이지는 않는다.
        Enumeration e = enumeration(list);
        ArrayList list2 = list(e);

        System.out.println("Enumeration e = enumeration(list);" + "\n" + "ArrayList list2 = list(e);");
        System.out.println("list2="+list2);
    }
}
