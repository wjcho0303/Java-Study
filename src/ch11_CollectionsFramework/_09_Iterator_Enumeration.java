package ch11_CollectionsFramework;

//  Iterator 와 Enumeration 은 거의 같은 거고,  Enumeration 은 구버전, Iterator 는 신버전이다.
//  요즘은 또 Iterator 보다는 Stream 을 사용하는 추세이기 때문에 둘 다 참고 정도로만 알아두자.
//  Iterator 와 Enumeration 둘 다 Collection 타입에 저장된 데이터를 "조회"하는 데에 사용되는 인터페이스이고,
//  Map 인터페이스 부류에는 사용되지 않는다.
//  Enumeration 은 Java 1.0부터 존재한 클래스 중 하나이며, Collection 을 순회하기 위한 인터페이스로,
//  출시된지 오래되어 Java 1.2 에 추가된 Iterator 로 거의 대체되었고, 현재는 Enumeration 을 거의 사용하지 않는다.
//  또, Iterator 도 Java 8 에 추가된 Stream 으로 대체되는 추세이다.
//
//  Enumeration, Iterator, Stream 이 중요한 이유는 List, Set 은 서로 자료를 갖고 있는 구조가 다 다른데,
//  이런 요소들을 읽어 오는 공통적인 방법이 필요했다. 요즘은 Stream 을 사용하지만
//  Stream 이 나온 Java 8 이전에는 Iterator 를 많이 사용했다.
//
//  Iterator 는 List, Set 상관 없이 모든 자료를 통일된 방식으로 읽을 수 있게 해준다.
//  읽어 오는 방식이 제각각이면 만약 데이터를 담을 Collection 을 바꿨을 때 읽어오는 코드를 바꿔야 해서 골치아파졌을 것이다.
//  예를 들어, ArrayList 에는 get() 메서드가 있어서 조회할 때 get() 쓰도록 코드를 썼는데,
//  데이터를 HashSet 으로 옮겼다고 하자. 그럼 HashSet 은 get() 메서드가 없기 때문에 수정해줘야 한다.
//  하지만 처음부터 Iterator 를 사용하여 next() 를 써주었다면 HashSet 으로 변경해도 바꿀 필요가 없다.
//
//
//
//  참고 1: enum 클래스와 Enumeration 은 전혀 별개의 것이다.
//  참고 2: ListIterator 라는 것도 있다. 이는 Iterator 에서 previous 랑 관련된 기능만 추가된 거다.
//  이름에서도 알 수 있듯이 List Interface 를 구현한 클래스에서만 사용할 수 있으며, 요즘 잘 사용하지 않는다.
//  ListIterator 라는 게 있다 정도로만 이해하고 넘어가자.
//
//
//
//  Iterator 의 메서드는 다음과 같으며, 특히 hasNext 와 next 이 두 가지 정도만 알아도 된다.
//  boolean hasNext()   읽어 올 요소가 남아 있는지 여부 확인 있으면 true, 없으면 false
//
//  Object next()       다음 요소를 리턴한다. 호출하기 전에 hasNext()를 호출해서 먼저 확인하는 게 안전하다.
//
//  void remove()       next() 로 읽어 온 요소를 삭제한다.
//                      remove() 는 파라미터 입력을 하지 않아서 next()를 호출한 다음에 호출해야 한다.
//
//  void forEachRemaining(Consumer<? super E> action)
//                      Collection 에 남아 있는 요소들에 대해 지정된 작업 action 을 수행한다. 람다식을 사용하는 디폴트 메서드.
//
//
//
//  Enumeration 이 가진 메서드는 다음과 같으며, Iterator 의 기능과 거의 다를 바가 없어서 보통은 Iterator 를 사용한다.
//  boolean hasMoreElements()   읽어 올 요소가 남아 있는지 여부 확인 있으면 true, 없으면 false
//
//  Object nextElement()        다음 요소를 리턴한다. 호출하기 전에 hasMoreElements()를 호출해서 먼저 확인하는 게 안전하다.
//
//  거의 사용할 일이 없으므로 이런 게 있구나 정도로 이해하고 넘어가자.

import java.util.*;

public class _09_Iterator_Enumeration {
    public static void main(String[] args) {
        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선1 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // Iterator iterator()      Collection 인터페이스에 정의된 메서드로, Iterator 객체를 생성한다
        // boolean hasNext()        읽어 올 요소가 남아 있는지 여부 확인 있으면 true, 없으면 false
        // Object next()            다음 요소를 리턴한다.
        // 일반적으로 hasNext()는 조건문에, next()는 구현부에 들어가며 이 두 메서드는 거의 항상 함께 사용된다.

        List list1 = new ArrayList();
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(8);
        list1.add(10);
        System.out.println("List list1 = new ArrayList();\n" +
                "list1.add(2);\n" +
                "list1.add(4);\n" +
                "list1.add(6);\n" +
                "list1.add(8);\n" +
                "list1.add(10);");
        System.out.println("list1 = " + list1 + "\n");

        System.out.println("Iterator it1 = list1.iterator();\n" +
                "while(it1.hasNext()) {\n" +
                "    System.out.print(it1.next() + \" \");\n" +
                "}");

        Iterator it1 = list1.iterator();
        while(it1.hasNext()) {
            System.out.print(it1.next() + " ");
            if (!it1.hasNext()) {
                System.out.println();
            }
        }
        // 위 코드가 Iterator 를 사용할 때의 기본 템플릿이라고 생각하면 된다.
        // Iterator 를 활용하는 코드들은 대부분 이 템플릿에서 응용 및 확장된다고 보면 된다.



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선2 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("list1.add(12);\n" +
                "while(it1.hasNext()) {\n" +
                "    System.out.print(it1.next() + \" \");\n" +
                "}\n");
        try{
            list1.add(12);
            while(it1.hasNext()) {
                System.out.print(it1.next() + " ");
            }
        } catch (ConcurrentModificationException cme) {
            System.out.println("ConcurrentModificationException 발생" + "\n"
                    + "list1.add(12);\n" +
                    "while(it1.hasNext()) {\n" +
                    "    System.out.print(it1.next() + \" \");\n" +
                    "}\n"
                    + "위 코드를 무시합니다.");
        }
        // 이렇게 iterator 를 생성한 후 Collection 을 수정하려고 하면 ConcurrentModificationException 이 발생한다.
        // 이는 Iterator 를 통해 반복하는 도중에 컬렉션을 수정하려고 할 때 발생한다.
        // Iterator 는 1회용이기 때문에 한 번 순회하고 나면 동일한 Iterator 객체를 재사용할 수 없다.
        // 다만 Iterator 객체가 순회를 마치고 나서 곧바로 메모리에서 해제되는 것은 아니지만
        // 가비지 컬렉터의 작업 대상이 된다. 단, 가비지 컬렉터가 이를 수행하는 시점을 예측하기는 어렵다.



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선3 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // Map 은 Collection 이 아니기 때문에 iterator() 메서드로 Iterator 객체를 생성할 수 없다.
        // 그렇기 때문에 Map 타입의 자료구조는 간접적인 방식으로 Iterator 객체를 생성해야 한다.
        // 즉, Map 을 Collection 형태로 변형시킨 후에 iterator() 메서드를 호출하여 Iterator 객체를 생성해야 한다.
        // 이를 위해 keySet(), entrySet(), values() 메서드가 활용된다.
        // keySet()과 entrySet()은 Set 타입의 자료구조를 생성하고,
        // values()는 Collection 자손들 타입 모두 가능한 자료구조를 생성한다.
        // 얻은 다음에 거기에다가 iterator() 를 붙일 수 있다.

        Map map = new HashMap();
        map.put("1번 회원", "Java");
        map.put("2번 회원", "Python");
        map.put("3번 회원", "C++");
        map.put("4번 회원", "Spring Boot");
        System.out.println("Map map = new HashMap();\n" +
                "map.put(\"1번 회원\", \"Java\");\n" +
                "map.put(\"2번 회원\", \"Python\");\n" +
                "map.put(\"3번 회원\", \"C++\");\n" +
                "map.put(\"4번 회원\", \"Spring Boot\");");
        System.out.println("map = " + map + "\n");



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선4 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  Set entrySet()      Map 에 저장되어 있는 key-value 쌍을 Map.Entry 타입의 객체로 저장한 Set 으로 리턴.
        //                      원소들인 Map.Entry 객체의 필드들은 getKey() 와 getValue()를 통해 접근 가능.

        Set entrySetFromMap = map.entrySet();
        System.out.println("Set entrySetFromMap = map.entrySet();");
        System.out.println("entrySetFromMap = " + entrySetFromMap + "\n");

        Iterator it2 = entrySetFromMap.iterator();
        System.out.println("Iterator it2 = entrySetFromMap.iterator();\n" +
                "while(it2.hasNext()) {\n" +
                "    System.out.print(it2.next() + \" \");\n" +
                "}");
        while(it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }
        System.out.println("\n");


        System.out.println("Set<Map.Entry<String, String>> entrySet = map.entrySet();\n" +
                "for (Map.Entry<String, String> entry : entrySet) {\n" +
                "    System.out.println(\"Key: \" + entry.getKey() + \", Value: \" + entry.getValue());\n" +
                "}");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선5 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // Set keySet()     Map 에 저장된 모든 Key 들을 Set 안에 넣어서 리턴. Value 는 가져오지 않음

        Set keySetFromMap = map.keySet();
        System.out.println("Set keySetFromMap = map.keySet();");
        System.out.println("keySetFromMap = " + keySetFromMap + "\n");

        Iterator it3 = keySetFromMap.iterator();
        System.out.println("Iterator it3 = keySetFromMap.iterator();\n" +
                "while(it3.hasNext()) {\n" +
                "    System.out.print(it3.nexㅁt() + \" \");\n" +
                "}");
        while(it3.hasNext()) {
            System.out.print(it3.next() + " ");
        }
        System.out.println("\n");



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선6 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // Collection values()      저장된 모든 value 들을 Collection 형태로 리턴

        ArrayList arrayListFromMap = new ArrayList(map.values());
        System.out.println("ArrayList arrayListFromMap = new ArrayList(map.values());");
        System.out.println("arrayListFromMap = " + arrayListFromMap + "\n");

        Iterator it4 = arrayListFromMap.iterator();
        System.out.println("Iterator it4 = arrayListFromMap.iterator();\n" +
                "while(it4.hasNext()) {\n" +
                "    System.out.print(it4.next() + \" \");\n" +
                "}");
        while(it4.hasNext()) {
            System.out.print(it4.next() + " ");
        }
        System.out.println("\n");



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선7 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // Collection values()      저장된 모든 value 들을 Collection 형태로 리턴

        LinkedList linkedListFromMap = new LinkedList(map.values());
        System.out.println("LinkedList linkedListFromMap = new LinkedList(map.values());");
        System.out.println("linkedListFromMap = " + linkedListFromMap + "\n");

        Iterator it5 = linkedListFromMap.iterator();
        System.out.println("Iterator it5 = linkedListFromMap.iterator();\n" +
                "while(it5.hasNext()) {\n" +
                "    System.out.print(it5.next() + \" \");\n" +
                "}");
        while(it5.hasNext()) {
            System.out.print(it5.next() + " ");
        }
        System.out.println("\n");
    }
}
