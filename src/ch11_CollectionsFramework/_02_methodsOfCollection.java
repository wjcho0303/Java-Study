package ch11_CollectionsFramework;

//  Collection 인터페이스는 List 와 Set 을 자손으로 두고 있다고 했다.
//  이 Collection 인터페이스의 메서드들에 대해 알아보자.
//  이는 곧 List 인터페이스와 Set 인터페이스가 가진 메서드들이라고 이해하면 된다.

//  기본적으로 메서드들은 추가, 삭제, 검색 이 세 가지 목적 중 한 가지를 위한 것들이라고 생각하면 된다.
//  List 과 Set 이 이 메서드를 상속 받았으므로 List 라고 생각하고 읽은 후에 Set 이라고 생각하고 읽어보자.
//
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

public class _02_methodsOfCollection {
}
