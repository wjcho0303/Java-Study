package ch11_CollectionsFramework;

import java.util.*;
import java.util.ArrayList;

//  앞에서 다룬 메서드들
//  boolean add(Object obj)             입력한 객체(obj) 또는 Collection 의 객체(c)들을 Collection 에 추가한다.
//  boolean addAll(Collection c)        그리고 성공여부 boolean 값을 반환한다.
//
//  void clear()                        Collection 의 모든 객체를 삭제한다.
//
//  boolean contains(Object obj)        입력한 객체(obj) 또는 Collection 의 객체(c)들이 Collection 에 포함되었는지
//  boolean containsAll(Collection c)   확인한다.
//
//  boolean isEmpty()                   Collection 이 비어있는지 확인한다.
//
//  Iterator iterator()                 Collection 의 Iterator 를 얻어서 반환한다.
//
//  boolean remove(Object obj)          입력한 객체를 삭제한다.
//  boolean removeAll(Collection c)     입력한 Collection 에 포함된 객체들을 삭제한다.
//
//  boolean retainAll(Collection c)     입력한 Collection 에 포함된 객체만 남기고 그 외 객체들은 삭제한다.
//                                      변돟사항이 있으면 true, 아무 작업도 안 이루어졌으면 false(겹치는 게 없었음)
//                                      * retain : 남기다, 간직하다
//
//  int size()                          Collection 에 현재 저장된 객체의 개수가 몇 개인지 반환한다.
//
//  Object[] toArray()                  Collection 에 저장된 객체들을 객체 배열인 Object[]로 반환한다.
//
//  Object[] toArray(Object[] arr)      입력한 배열 arr 에 Collection 의 객체들을 저장한 후 반환한다.
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


//  ArrayList 는 Vector 의 신버전으로, 동기화가 되어있는 Vector 와는 달리 ArrayList 는 동기화가 안 되어 있다.
//  그리고 ArrayList 는 사실 배열(Array)이다.
//  하지만 일반 배열과의 차이점은 기본형 자료가 아니라 "참조형 타입이 저장되는 배열"이다.
//
//  ArrayList ArrayList(Collection c)        생성자의 매개변수로 List 나 Set 을 넣으면 그 요소를 가진 ArrayList 생성
//
//  ArrayList(int initialCapacity)           매개변수로 정수를 넣으면 배열의 길이를 초기화한다.
//                                           ArrayList 는 길이가 한 번 정해지면 고정으로 정해져 있다는 특징이 있다.
//
//  void trimToSize()                        빈 공간을 제거


public class _06_ArrayList {
    public static void main(String[] args) {
        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선1 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  ArrayList(int initialCapacity)      매개변수로 정수를 넣으면 배열의 길이를 초기화한다.
        //                                      길이가 한 번 정해지면 고정으로 정해져 있다는 특징이 있다.

        ArrayList list1 = new ArrayList(10);    // 길이가 10인 ArrayList 생성
        System.out.println("ArrayList list1 = new ArrayList(10);");



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선2 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // boolean add(Object obj)      입력한 타입의 객체를 List 에 요소로 추가
        // void add(Object obj)         입력한 타입의 객체를 List 에 요소로 추가
        // boolean 을 반환할지 void 메서드로 실행할지는 컴파일러가 알아서 판단한다.
        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));
        System.out.println("list1 = " + list1);



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선3 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  List subList (int fromIndex, int toIndex)   입력한 index 범위만 List 타입으로 리턴
        //  ArrayList ArrayList(Collection c)           생성자의 매개변수로 List 나 Set 을 넣으면
        //                                              그 요소를 가진 ArrayList 생성
        ArrayList list2 = new ArrayList(list1.subList(1,4));
        System.out.println("ArrayList list2 = new ArrayList(list1.subList(1,4));");
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선4 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // Collection  Collections.sort(Collection c)
        // Collections 라는 util 패키지에는 Collection 을 다룰 때 유용한 메서드들을 제공한다.
        // 여기서 사용할 메서드는 Collections.sort() 이다. 오름차순으로 정렬 기능을 가진 static 메서드다.
        // boolean containsAll(Collection c)    입력 받은 Collection 을 부분 집합으로 갖고 있는지 여부 확인
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        Collections.sort(list1);
        System.out.println("Collections.sort(list1);");
        Collections.sort(list2);
        System.out.println("Collections.sort(list2);");
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("list1.containsAll(list2) = " + list1.containsAll(list2));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선5 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("list2 = " + list2);
        list2.add("B");
        System.out.println("list2.add(\"B\");");
        list2.add("C");
        System.out.println("list2.add(\"C\");");
        list2.add(3, "A");
        System.out.println("list2.add(3, \"A\");");
        // 이렇게 중간 위치에 원소를 추가하는 작업은 사실 index 4 부터 싹 다 바꾸는 작업이기 때문에 부담이 가는 작업이다.
        System.out.println("list2 = " + list2);



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선6 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // Object set (int index, Object element)       입력한 index 에 element 를 덮어쓴다. (수정)
        // boolean contains(Object obj)     입력한 객체가 포함되었는지 여부 확인
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("list1.contains(5) = " + list1.contains(5));
        System.out.println("list1.contains(new Integer(5)) = " + list1.contains(new Integer(5)));
        list2.set(3, "AA");
        System.out.println("list2.set(3, \"AA\");");
        System.out.println("list2 = " + list2);



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선7 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  boolean retainAll(Collection c)     입력한 Collection 에 포함된 객체만 남기고 그 외 객체들은 삭제한다. (교집합)
        //                                      변돟사항이 있으면 true, 아무 작업도 안 이루어졌으면 false.
        //                                      * retain : 남기다, 간직하다
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("list1.retainAll(list2) = " + list1.retainAll(list2));
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("list1 의 요소들은 삭제되고 list2 의 요소들은 남아 있는 모습을 볼 수 있다.");



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선8 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  int size()                  Collection 에 현재 저장된 객체의 개수가 몇 개인지 반환한다.
        //  Object get(int index)       입력한 index 의 element 를 리턴한다.
        //  Object remove(int index)    입력한 index 의 element 를 삭제
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);

        // 이 코드는 list1 에 있는 요소들을 list2 에서 지워버리는 작업이다.
        for(int i= list2.size()-1; i >= 0; i--) {
            if(list1.contains(list2.get(i)))
                list2.remove(i);
        }
        System.out.println("for(int i= list2.size()-1; i >= 0; i--) {\n" +
                "    if(list1.contains(list2.get(i)))\n" +
                "        list2.remove(i);\n" +
                "}");

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);



        //  숫자로 이루어진 ArrayList 에서 remove 메서드를 호출할 때 주의해야할 점:
        //  boolean remove(Object obj)          입력한 객체를 삭제한다.
        //  Object remove(int index)            입력한 index 의 element 를 삭제
        //
        //  위에서 보다시피, remove 메서드는 매개변수에 객체를 입력할 수도 있고, 정수를 입력할 수도 있다.
        //  그런데 일반적으로 정수를 입력하면 항상 index 를 입력한 것으로 인식한다.
        //  예를 들어 remove(2) 이라고 입력하면 3번째 index 에 위치한 객체를 삭제한다.
        //  하지만 만약 index 를 입력하려고 한 게 아니라 new Integer(2) 를 삭제하려고 했던 거라면 이는 큰 문제이다.
        //  그렇기 때문에 remove() 메서드를 통해 정수 데이터를 삭제할 때는 매개변수를 기본형 정수로 입력하면 안 되고,
        //  new Integer(5) 이런 식으로 래퍼 클래스 타입으로 입력해주어야 한다.


        // 여담
        // ArrayList 의 remove 메서드는 특정 index 의 객체를 삭제한 후 뒤에 있는 것들을 앞으로 끌어오는 방식이기 때문에
        // for 문으로 0부터 list.size() 까지 i++ 방식으로 하면 전부 제거 되지 않는다.
        // 그리고 시행할 때마다 뒤의 데이터들을 다시 갈아 엎는 과정이 반복되기 때문에 성능 상으로도 좋지 않다.
        // 그렇기 때문에 for 문을 이용해서 remove 를 하려면 항상 뒤에서부터 작업하도록 코드를 작성해야 한다.
        //              (int i = list.size();  시행조건 ;  i--)
        //              (int i = list.size() - 원하는 index 지점; 시행조건 ; i--)



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선9 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("나머지 메서드들에 대한 추가 실습 필요!");
        System.out.println("LinkedList, Stack 도 List 인터페이스를 구현했으므로 메서드에 대한 많은 부분이 겹친다.");
    }
}
