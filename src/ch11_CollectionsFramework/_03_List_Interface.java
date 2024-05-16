package ch11_CollectionsFramework;

//  List Interface 의 특징은 다음과 같다:
//  1. 저장된 순서를 유지한다.
//  2. 중복된 요소가 들어와도 상관 없다.
//
//
//
//   List Interface 를 구현하는 클래스는 다음과 같다:
//  1. ArrayList
//  2. LinkedList
//  3. Vector <-- 4. Stack
//
//  * Vector 와 ArrayList 는 거의 같은데 Vector 는 옛날 거고 ArrayList 는 Vector 를 개선한 것이다.
//  이 넷 중에서 ArrayList 와 LinkedList 를 눈여겨 볼 필요가 있다.
//
//
//
//  List Interface 가 가진 메서드들을 보면 다음과 같다:
//  - Collection Interface 의 메서드들도 모두 사용 가능
//  - 그리고, List 에 들어가는 element 는 Object 만 가능
//  - 만약 기본형으로 자료를 넣으면 들어가지긴 하는데, 그건 기본형으로 저장할 수 있다는 걸 의미하는 게 아니라 auto-boxing 덕분이다.
//    예를 들어  list1.add(5);  이렇게 입력하면 list1.add(new Integer(5)); 이렇게 컴파일러가 래퍼클래스로 감싸서 저장한다.
//
//
//
//  다음은 List 인터페이스에서 제공하는 메서드들이다:
//  void add(int index, Object element)         입력한 index 에 element 하나를 추가한다.
//
//  boolean addAll(int index, Collection c)     입력한 index 에 컬렉션 전체를 추가하고 성공 여부 반환
//
//  Object remove(int index)                    입력한 index 의 element 를 삭제
//
//  int indexOf(Object obj)                     입력한 element 를 검색하여 index 값을 리턴
//
//  int lastIndexOf(Object obj)                 입력한 element 를 검색하여 index 값을 뒤에서부터 리턴
//
//  ListIterator listIterator()                 List 객체에 접근할 수 있는 ListIterator 리턴
//  ListIterator listIterator(int index)
//
//  Object get(int index)                       입력한 index 의 element 를 리턴한다.
//
//  Object set(int index, Object element)       입력한 index 에 element 를 덮어쓴다. (수정)
//
//  void sort(Comparator c)                     입력한 Comparator 로 List 를 정렬시킨다.
//
//  List subList(int fromIndex, int toIndex)    입력한 index 범위만 List 타입으로 리턴
//

public class _03_List_Interface {
}
