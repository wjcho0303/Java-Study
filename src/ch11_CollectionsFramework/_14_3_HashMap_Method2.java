package ch11_CollectionsFramework;
import java.util.*;

public class _14_3_HashMap_Method2 {
    public static void main(String[] args) {
        String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };
        // 문자열의 배열 생성

        HashMap map = new HashMap();
        // HashMap 생성 (아직 자료 없음)

//      Object put(Object key, Object value)        put 은 입력한 Key 와 Value 를 갖는 Entry 를 요소로 추가
//      Object get(Object key)                      get 은 입력한 Key 의 Value 를 리턴

        for(int i=0; i < data.length; i++) {
            if(map.containsKey(data[i])) {  // HashMap 이 문자열 배열의 요소를 Key 로 갖고 있는지 여부 확인
                int value = (int)map.get(data[i]);
                map.put(data[i], value+1);  // 기존에 존재하는 Key 면 기존 값을 1증가
            } else {
                map.put(data[i], 1);	    // 기존에 존재하지 않으면 Key 의 값을 1로 저장
            }
        }
        // 일단 처음에는 HashMap 에 자료가 전혀 없으니 Key 는 A, K, D, Z 순으로 추가되고,
        // A, K, D, Z 모두 value 가 1로 시작할 것이다. 그러다가 중복된 알파벳이 나오면 value 값이 1 더해질 것이다.
        // 그럼 결국 결과물에는 Key 로 A, K, D, Z 가 있을 것이고, 그리고 그 알파벳의 갯수가 바로 Value 가 될 것이다.


        // 최종 출력을 위해 위에서 만든 HashMap 을 iterator 로 만들자.
        // entrySet() 을 이용해서 Set 구조로 해볼까?
        Iterator it = map.entrySet().iterator();

//      while(it.hashNext()) { } 구문을 통해 반복문의 횟수를 명확하게 구분해주자.

        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            int value = (int)entry.getValue();
            // int 로 형변환 해주는 이유는 안에 있는 Value 숫자들은 기본형 정수가 아니라 Integer 객체이기 때문이다.
            System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value );
        }
    } // main

    public static String printBar(char ch, int value) {
        char[] bar = new char[value];   // 위 HashMap 에 들어간 Value 숫자를 배열의 길이로 선언한다.

        for(int i=0; i < bar.length; i++)
            bar[i] = ch;

        return new String(bar); // String(char[] chArr)
    }
}