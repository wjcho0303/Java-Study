package ch11_CollectionsFramework;

//  Collection 이란?
//  여러 객체(데이터)를 모아 놓은 것
//
//  Library 란?
//  내가 직접 프로그래밍하지 않아도 다른 누군가가 만들어 놓은 프로그래밍을 간단하게 이용할 수 있게 모아놓아 준 것
//
//  Framework 이란?
//  직역해보면 '틀작업' 이라는 뜻으로 풀이되는데, 의미는 '체계적으로 표준화 및 정형화시킨 프로그래밍 방식'이다.
//  프레임워크는 라이브러리를 제공하되, 프로그래밍 방식을 정형화된 방식으로 할 것을 요구한다.
//  자유도가 떨어지는 대신 보편성으로 인해 협업과 유지보수에 용이하다.
//
//  예전에는 개발자마다 코드 방식이 다르기 때문에 정형화된 방식이 필요했다.
//  그래서 등장한 게 프레임웍이다. Spring Framework 도 프레임웍 중 하나다.
//  국내에서는 자바와 스프링 프레임웍이 지배적이다.
//
//  그럼 Collection Framework 은 무엇인가?
//  "여러 객체를 모아 놓은 객체를 다루는 체계적으로 표준화시킨 프로그래밍 방식"이다.
//  Collection Framework 는 Collection 을 쉽고 편리하게 다룰 수 있는 다양한 클래스를 제공한다.
//  Collection Framework 을 통해 객체를 저장하고 삭제하고 검색하고 정렬한다.
//  java.util 패키지에 포함되며, JDK1.2부터 표준화가 완료된 형태로 제공되었다.
//
//  Collection Framework 는 다음의 세 가지 인터페이스들로 구성된다 : List   Set   Map
//  List 와 Set 인터페이스는 Collection 이라는 interface 를 공통 조상으로 두고 있다.

//  Map 은 Collection 의 자손이 아니다.
//  왜냐하면 Key 와 Value 값을 한 쌍으로 묶는 거라 단일 값만 저장하는 List 와 Set 하고는 특성이 다르기 때문이다.
//  Collection 의 자손은 List, Set, Queue 이렇게 세 가지다.
//
//  이 세 가지 데이터들 각각의 특성을 이해하는 것이 중요하다.
//  1. List : 순서가 있는 데이터의 집합. 중복 허용
//     구현 클래스 : ArrayList, LinkedList, Stack, Vector 등
//     ex) 식당 대기자 명단 (순서가 있고, 동명이인이 있을 수 있으니까)
//
//
//  2. Set : 순서가 없는 데이터의 집합, 중복은 허용하지 않는다.
//     구현 클래스 : HashSet, TreeSet 등
//     ex) 사족보행 동물의 집합, 물고기 종류의 집합

//  3. Map : Key-Value 를 데이터 단위로 하는 데이터의 집합. 순서가 없으며, Key 의 중복은 허용하지 않고 Value 의 중복은 허용한다.
//     구현 클래스 : HashMap, TreeMap, Hashtable, Properties 등
//     단, HashMap 을 상속하는 LinkedHashMap 은 순서가 있다.
//     ex) ID와 password (ID는 중복이 안 되지만 비밀번호는 중복이 가능하다)
//
//
//  * 참고사항: 구현 클래스명에 -List, -Set, -Map 와 같은 명칭이 포함된 것들은 표준화 이후에 나온 것들이고,
//            이런 단어들이 포함되지 않은 것들은 표준화 이전에 존재하던 것들이다.
//


public class _01_CollectionsFramework {
}
