package ch11_CollectionsFramework;
import java.util.*;

//
//      HashMap 의 주요 메서드를 살펴보자.
//
//      먼저, 생성자부터 살펴본다.
//      HashMap()                           기본 생성자
//
//      HashMap(int number)                 int 값을 입력하면 initial Capacity 가 설정되어 있는 HashMap 객체가 생성된다.
//
//      HashMap(int number, float Factor)   HashSet 에서처럼 0 ~ 1 사이의 숫자(로드팩터)를 같이 입력해주면
//                                          해당 % 에 도달했을 때 initial Capacity 만큼 용량이 추가된다.
//
//      HashMap(Map map)                    다른 Map 자료구조를 넣으면 HashMap 으로 바꿔준다.
//
//
//      이번엔 그 외 메서드이다.
//      Object put(Object key, Object value)        입력한 Key 와 Value 를 갖는 Entry 를 요소로 추가
//
//      void putAll(Map m)                          입력한 Map 의 모든 Entry 를 요소로 추가
//
//      Object remove(Object key)                   입력한 Key 에 해당하는 Entry 삭제
//
//      Object replace(Object key, Object value)    입력한 Key 의 Value 를 value 로 수정
//
//      boolean replace(Object key, Object oldValue, Object newVlaue)
//                                                  입력한 Key 의 oldValue 를 newValue 로 수정후 성공여부 return
//
//      Set entrySet()                              Key-Value 쌍으로 이루어진 데이터를 집어 넣은 Set 을 리턴
//
//      Set keySet()                                Key 만 가져와서 집어 넣은 Set 을 리턴
//
//      Collection values()                         Value 만 가져와서 집어 넣은 List 또는 Set 을 리턴
//
//      Object get(Object key)                      입력한 Key 의 Value 를 리턴
//
//      Object getOrDefault(Object key, Object defaultValue)
//                                                  입력한 Key 가 존재하지 않는 Key 일 경우 defaultValue 를 리턴
//
//      boolean containsKey(Object key)             입력한 Key 가 존재하는지 여부 확인
//
//      boolean containsValue(Object value)         입력한 Value 가 존재하는지 여부 확인
//
//
//
//
//      int size()                                  존재하는 데이터(Entry)의 개수 리턴
//
//      boolean isEmpty()                           데이터가 존재하는지 여부 확인
//
//      void clear()                                모든 데이터를 삭제
//
//      Object clone()                              모든 데이터를 복제
//


public class _14_2_HashMap_Method {
    public static void main(String[] args) {
        HashMap map1 = new HashMap();   // HashMap 생성
        map1.put("myId", "1234");       // Key 와 Value 추가
        map1.put("asdf", "1111");       // Key 와 Value 추가
        System.out.println("asdf, 1111 입력: " + map1);
        map1.put("asdf", "1234");       // Key 와 Value 추가 (기존에 동일한 asdf 라는 Key가 있기 때문에 Value 를 갱신함)
        System.out.println("asdf, 1234 입력: " + map1);
        Scanner s = new Scanner(System.in);	// 화면으로부터 라인단위로 입력받는다.

        while(true) {       // 조건을 만족할 때까지 계속 입력 요구
            System.out.println("\n" + "id와 password를 입력해주세요.");
            System.out.println("id 를 입력 후 password 를 입력할 때까지 계속 입력 가능합니다.");
            System.out.print("id : ");
            String id = s.nextLine().trim(); // .trim() 을 통해 사용자가 입력한 공백은 무시해줌

            System.out.print("password : ");
            String password = s.nextLine().trim();
            System.out.println();

            if(!map1.containsKey(id)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 id부터 입력해주세요.");
                continue;
            }

            if(!(map1.get(id)).equals(password)) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 id부터 입력해주세요.");
            } else {
                System.out.println("id와 비밀번호가 일치합니다. 프로그램을 종료합니다.");
                break;
            }
        } // while

        // 두 번째 예제 시작. 위 예제의 올바른 아이디와 비밀번호를 입력해야 실행됨
        System.out.println("-------------------------------------");
        HashMap map2 = new HashMap();
        map2.put("김자바", 90);
        map2.put("김자바", 100);
        map2.put("이자바", 100);
        map2.put("강자바", 80);
        map2.put("안자바", 90);        // Key 가 한 번 중복되서 5개를 입력했지만 자료는 4개로 된다.

        Set set2 = map2.entrySet();     // map2 를 entrySet() 메서드를 통해 Set 으로 변경
        Iterator it = set2.iterator();  // 그리고 그 Set 을 조회하기 위해 iterator 객체 it 생성

        while(it.hasNext()) {    // Key-Value Entry 객체를 요소로 가지는 Set 을 조회하기 위한 iterator 메서드 반복문
            Map.Entry e = (Map.Entry)it.next();
            // Map.Entry? 이건 뭐지?
            // Entry 는 Map 인터페이스 내부에 있는 내부 인터페이스다. 그리고 static 이다. 그래서 Map.Entry 이런 식으로 쓰는 것이다.
            // Key 와 Value 한 쌍을 이루는 Entry 구조 자료형을 의미하기 때문에 위와 같이 소괄호 안에 명시적 형변환 하듯이 쓰면
            // 뒤의 자료가 Map.Entry 자료형으로 형변환 된다.

            System.out.println("이름 : "+ e.getKey() + ", 점수 : " + e.getValue());
            // ??? getKey() 랑 getValue() 는 뭔 메서드지?
            // 아 ~ 이건 Map.Entry 클래스가 갖고 있는 메서드이다. 이 메서드를 쓰기 위해 형변환을 해줬던 거고,
            // getKey() 는 말 그대로 Key 를 리턴하고, getValue() 는 말 그대로 Value 를 리턴한다.

            // iterator next() 메서드를 반복문 안에 썼으니 iterator 객체의 요소를 싹 다 꺼내는 행위를 하는 코드다.
        }

        set2 = map2.keySet();
        System.out.println("참가자 명단 : " + set2);

        Collection values = map2.values();
        it = values.iterator();

        int total = 0;

        while(it.hasNext()) {
            int i = (int)it.next();
            total += i;
        }

        System.out.println("총점 : " + total);
        System.out.println("평균 : " + (float)total/set2.size());     // 나눗셈할 때 float 명시적 형변환 꼭 해주자.
        System.out.println("최고점수 : " + Collections.max(values));
        System.out.println("최저점수 : " + Collections.min(values));
    }
}
