package ch11_CollectionsFramework;

//  Map 인터페이스의 경우 순서가 존재하지 않고 Key 가 동일하게 겹칠 수 없다.
//  그러나 Key 안의 Value 는 겹쳐도 상관 없다.
//  Map 에 담긴 Key-Value 한 쌍을 하나의 Entry 라고 부른다.
//
//  Map 은 여러 가지가 있긴 한데 다음의 두 가지가 대표적이다:
//  1. HashMap          2. TreeMap
//
//  가끔 Key 간의 순서가 필요한 경우
//  3. LinkedHashMap 이 아주 가끔 사용되는 정도이다.
//
//
//  Map 인터페이스의 메서드들은 다음과 같다:
//  void putAll(Map t)                     입력한 Map (참조변수 t) 의 모든 요소를 저장
//
//  void clear()                           Map 의 모든 객체를 삭제
//
//  boolean containsKey(Object key)        입력한 파라미터와 같은 Key 의 존재 여부 확인
//
//  boolean containsValue(Object value)    입력한 파라미터와 같은 value 의 존재 여부 확인
//
//  boolean isEmpty()                      Map 이 비어 있는지 여부 확인
//
//  int size()                             key-value 가 몇 쌍 존재하는지 갯수 리턴
//
//  Object get(Object key)                 입력한 key 의 value 만 리턴
//
//  Object put(Object key, Object value)   입력한 key 와 value 를 Map 에 저장
//
//  Set keySet()                           Map 에 저장된 모든 Key 들을 Set 안에 넣어서 리턴. Value 는 가져오지 않는다.
//
//  Set entrySet()                         Map 에 저장되어 있는 key-value 쌍을 Map.Entry 타입의 객체로 저장한 Set 으로 리턴.
//                                         원소들인 Map.Entry 객체의 필드들은 getKey() 와 getValue()를 통해 접근 가능.
//
//  Collection values()                    저장된 모든 value 들을 Collection 형태로 리턴
//

public class _05_Map_Interface {
}
