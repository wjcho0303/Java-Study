package ch11_CollectionsFramework;
//
//      HashMap 과 Hashtable 은 둘 다 Map interface 를 구현한다.
//      Hashtable 은 옛날부터 있던 것이고 HashMap 의 구버전이라고 생각하면 된다. Hashtable 은 그래서 이제 거의 안 쓴다.
//      둘의 차이는 Hashtable 은 동기화가 되어 있는데 HashMap 은 동기화가 안 되어 있다는 점이다.
//
//      참고로, Properties 라는 것도 있는데, Key 와 Value 로 오직 String 만 저장한다는 점 외에는 똑같다.
//      사실 파일에 읽기와 쓰기가 용이하다는 점에서 이 Properties 를 많이 쓴다.
//
//      TreeMap 도 있는데, TreeSet 과 HashMap 의 짬뽕이라고 생각하면 된다.
//      이진 탐색 구조인데 Key-Value 형태로 객체를 저장한다.
//
//      LinkedHashMap 도 있다. Map 에 순서를 부여해주는 클래스이다. 당연히 Node 멤버를 갖고 있다.
//
//
//      클래스 이름에 'Hash' 가 붙는 것들은 모두 hashing 기법을 사용하는 것인데
//      hashing 기법을 사용하는 것들은 데이터가 많아도 검색이 빠르다는 장점이 있다.
//
//      실제로, HashMap 클래스 내부를 보면
//      transient Entry[] table;        이러한 멤버변수가 선언되어 있다. (transient 는 자료형의 한 종류임)
//                                      여기서 Entry 가 바로 Key 와 Value 로 구성된 한 쌍의 데이터를 의미한다.
//                                      그러므로 HashMap 은 Entry 를 요소로 하는 배열인 셈이다.
//
//
//      hashing 의 원리는 무엇일까? 어떤 key 값을 넣으면 배열의 index, 즉 저장 위치를 알려줌으로써
//      자료를 빠르게 찾는 것이다. (간호사가 환자 정보를 출생연도 기준으로 구분해서 각각의 캐비넷에 관리하는 예시)
//      즉, hashing 이란 hash function 을 이용해서 데이터를 저장하고 읽어오는 것이라고 정의할 수 있다.
//      데이터를 어디에 저장하는가? 그 데이터를 저장하는 곳은 hash table 이라 한다. 이 hash table 에 데이터를 저장하고,
//      필요할 때 이 hash table 에서 데이터를 검색 및 조회하는 것이다.
//
//      hash function 은 key 를 input 값으로 넣으면 output 으로 저장위치를 리턴하는 방식으로 작동한다.
//      이 저장위치를 hashcode 라고 부르고, 이것이 결국 hash table 배열의 index 값이다.
//      배열은 index 값만 알면 간단한 계산을 통해 손쉽게 데이터에 접근할 수 있기 때문에 hashing 방식이 검색 속도가 빠른 것이다.
//
//                                          투입                               결과
//      간단한 과정을 말하자면,           Key ------> [ hash function ] ------> hash code
//
//      hash table 은 array 와 LikedList 가 조합된 형태이며, 2차원 배열 모양이다.
//      각각의 행이 LikedList 로 이루어져 있고, 모든 LinkedList 가 하나의 array 요소로 들어가는 방식이다.
//      그리고 실제적인 Entry(즉, Key 들과 Value 들) 를 갖고 있는 것이 바로 LinkedList 이다.
//                                  ㅁ --> ㅁ --> ㅁ
//                                  ㅁ --> ㅁ
//                                  ㅁ
//                                  ㅁ --> ㅁ
//                                  ㅁ --> ㅁ
//                                  ㅁ --> ㅁ
//                                  ㅁ --> ㅁ --> ㅁ --> ㅁ
//                                  ㅁ
//                                  ㅁ --> ㅁ
//
//      배열기반이 가지는 접근성 장점을 갖고, 연결기반이 가지는 변화에 유연하다는 장점을 둘 다 가졌다고 볼 수 있다.
//      일단 처음에 배열기반에서처럼 빠르게 검색 조건에 부합하는 LinkedList 행으로 찾아간 후, 그 행 내에서
//      LinkedList 검색을 하는 것이다. 처음은 배열방식이라 빠르게 조회한 후 LinkedList node 들을 조회할 때부터는
//      시간 좀 걸린다. 그래도 전체적으로는 구조가 효율적으로 변한 것이다.
//
//      구조가 이렇게 되어 있다 보니 Key 를 같은 것을 넣으면 그 Key 에 대해서는 항상 같은 hash code 를 리턴하는데,
//      Key 가 다름에도 불구하고 같은 hash code 를 리턴할 수도 있다. 그런 경우 별 거 아니고
//      그냥 같은 LinkedList 에 그 Key 들이 존재하는 것 뿐이다.
//      hash code 는 어찌 됐든 원하는 Key-Value 를 갖고 있는 LinkedList 를 안내하는 역할만 하는 것이니
//
//
//      이러한 hash function 작성하는 방법은,
//      Objects.hash() 와 hashCode() 라는 메서드를 이용하면 된다.


public class _14_1_HashMap {
}
