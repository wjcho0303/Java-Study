package ch14_Lambda_Stream;
import java.util.*;

//
//      함수형 인터페이스를 사용하는 컬렉션 프레임워크의 메서드를 조금만 살펴보자. 와일드카드는 생략했다.
//      식이 너무 복잡하게 보일지 모르겠지만 아래에 함수형 인터페이스로 적혀 있는 곳에 람다식을 넣으면 되는 거다.
//
//      Collection 인터페이스의 경우
//      boolean removeIf(Predicate<E> filter)           입력한 람다식 조건문 filter 을 만족하는 요소 삭제.
//                                                      성공하면 true, 실패하면 false 리턴
//
//
//
//      List 인터페이스의 경우
//      void replaceAll(UnaryOperator<E> operator)      모든 요소를 변환하여 대체함
//
//
//
//      Iterable 인터페이스의 경우★★ 이거 잘 쓰인다.
//      void forEach(Consumer<T> action)                모든 요소에 작업 람다식 action 을 수행
//
//
//
//      Map 인터페이스의 경우
//      V compute(K key, BiFunction<K,V,V> f)           입력한 Key 의 Value 에다가 람다식 f를 수행
//
//      V computeIfAbsent(K key, Function<K,V> f)       입력한 Key 가 없을 경우 람다식 f 수행 후 추가
//
//      V computeIfPresent(K key, BiFunction<K,V,V> f)  입력한 Key 가 있으면 람다식 f 수행
//
//      V merge(K key, V value, BiFunction<V,V,V> f)    모든 요소에 병합작업 람다식 f를 수행
//
//      void forEach(BiConsumer<K,V> action)            모든 요소에 람다식 action 을 수행
//
//      void replaceAll(BiFunction<K,V,V> f)            모든 요소에 치환작업 람다식 f를 수행
//
//      * 참고: f 는 리턴이 있는 경우이고, action 은 리턴이 없는 경우이다.
//
//
//      람다식을 쓰면 컬렉션 프레임워크의 코드가 더 간결해져서 실제로 굉장히 많이 사용한다.
//


public class _09_CollectionAndFncnlItfce {
    public static void main(String[] args) 	{
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++)   // list 에 0 ~ 9 정수 저장
            list.add(i);

        // list 의 모든 요소를 출력
        list.forEach(i->System.out.print(i+","));
        // forEach 와 람다식을 이용하여 출력. 받기만 하니까 Consumer 이다.
        // 근데 굳이 Consumer 를 안 쓰고 람다식만 써도 문제 없이 돌아간다.
        System.out.println();

        //   원래는 iterator it = list.iterator();
        //   while(it.hasNext()) {
        //       System.out.print(it.next());
        //   }
        //   이렇게 했었다. 람다식을 쓰니까 한 줄로 해결된 것이다.




        // list 에서 2 또는 3의 배수를 제거한다.
        list.removeIf(x-> x%2==0 || x%3==0);
        System.out.println(list);

        list.replaceAll(i->i*10); // list의 각 요소에 10을 곱한다.
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        // map의 모든 요소를 {k,v}의 형식으로 출력한다.
        map.forEach((k,v)-> System.out.print("{"+k+","+v+"},"));
        System.out.println();

        // map 에 있는 걸 출력하려면 어떻게 했어야 했나?
        //   Iterator it = map.entrySet().iterator();

        //   while(it.hasNext()) {
        //      System.out.print(it.next());
        //   }
        //  이렇게 작성했어야 했다... 람다식을 쓰니까 매우 간단해졌다.
    }
}
