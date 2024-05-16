package ch11_CollectionsFramework;
import java.util.*;
//  https://www.youtube.com/watch?v=Kcz-z6xTbgk&list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp&index=131
//  TreeSet 에서 Comparator 를 활용하고 있으므로 참고하도록 하자.

//  Comparator 와 Comparable 둘 다 객체를 정렬시킬 때 필요한 메서드를 정의한 인터페이스이다.
//  Comparator 는 기본 정렬기준 외에 다른 기준으로 정렬하려고 할 때 사용하고,
//  Comparable 은 기본 정렬기준을 구현할 때 사용한다.
//
//  Comparator 는 compare() 라는 메서드를 사용하고, compare() 메서드는 파라미터로 입력한 두 객체를 비교한다.
//  Comparable 은 compareTo() 라는 메서드를 사용하한다. compareTo() 메서드는 자기 자신과 입력한 하나의 객체를 비교한다.
//
//  public interface Comparator {
//      int compare(Object obj1, Object obj2);      obj1 과 obj2 두 객체를 비교
//      boolean equals(Object o);                   equals 를 오버라이딩 하라는 의미
//  }
//  어느 쪽이 큰지 정수값으로 리턴한다:
//  값이 0이면 같은 것   /   값이 양수면 왼쪽이 큰 것   /   값이 음수면 오른쪽이 큰 것
//
//
//  public interface Comparable {
//      int compareTo(Object obj);                  obj 와 자기 자신을 비교
//  }
//  어느 쪽이 큰지 정수값으로 리턴한다:
//  값이 0이면 같은 것   /   값이 양수면 왼쪽(자신)이 큰 것   /   값이 음수면 오른쪽(obj)이 큰 것
//
//  compare 와 compareTo 모두 같으면 0, 왼쪽이 크면 양수, 오른쪽이 크면 음수라고 생각하면 쉽다.
//
//
//  정렬이라는 것은 결국 "자리를 바꾸는" 것이다.
//  그런데 컴퓨터가 정렬시키는 방식은 두 대상 씩 집어서 비교하면서 자리를 바꾸고,
//  결국에는 차례대로 전체를 쭉 자리를 바꾸게 되는 방식이다.
//  그리고 이러한 자리 바꿈에는 0, 양수, 음수가 리턴되는 특징을 이용한다는 점을 알아두자.
//  양수 또는 음수가 나오는 이유는 메서드 로직에 뺄셈이 있기 때문이다. (왼쪽 - 오른쪽)
//  ---> 오름차순 정렬이라면 왼쪽이 크면(양수) 자리를 바꾸게 하면 되고, 오른쪽이 크면 가만히 놔둔다.
//  ---> 내림차순 정렬이라면 오른쪽이 크면(음수) 자리를 바꾸게 하면 되고, 왼쪽이 크면 가만히 놔둔다.
//  compare 와 compareTo 는 정렬할 때 자리를 바꿀지 말지를 결정하게 해주는 기능을 담당한다.

//  간혹 내부 로직이 단순 뺄셈이 아닌 삼항 연산자를 통한 비교를 통해 구현한 경우도 있는데,
//  그런 경우는 보통 성능을 높이기 위한 것이다. 뺄셈은 비트 정보가 많이 소모되기 때문에 뺄셈보다는
//  단순 비교 연산인 삼항 연산자가 더 높은 것이다.


class Descending implements Comparator {
    // Comparator 인터페이스를 구현하기 때문에 new Descending() 인스턴스는 곧 Comparator 구현체가 된다.
    public int compare(Object o1, Object o2){
        if(o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable)o1;
            Comparable c2 = (Comparable)o2;
            return c1.compareTo(c2) * -1 ; // -1을 곱해서 기본 정렬방식의 역으로 변경한다.
            //  return c2.compareTo(c1);
            //  이렇게 하는 거랑 똑같다 부호 차이일 뿐이다.
        }
        return -1;
    }
}

public class _11_Comparator_Comparable {
    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};
        // 참고로, 사전 순으로 보면 대문자가 소문자보다 먼저다. 즉, 오름차순일 때 대문자가 먼저 나온다.
        // 큰 문자니까 오름차순이면 대문자가 뒤에 나와야 한다? 아니다. 대문자가 먼저다... ㄷㄷ

        // sort() 메서드를 쓸 때 파라미터는 다음과 같이 넣는다: sort(정렬대상, 정렬기준)
        // 근데 아래를 보면 정렬 대상인 strArr 이거 하나만 썼다?
        Arrays.sort(strArr); // String의 Comparable 구현에 의한 정렬
        System.out.println("strArr=" + Arrays.toString(strArr));
        // 원래는 정렬기준을 써줘야 하는데, 이 경우는 strArr 객체 자체가 Comparable 객체를 갖고 있다.
        // 그렇기 때문에 정렬을 할 수 있는 것이다. 실제로 String 클래스에는 compareTo() 메서드가 존재한다.
        // 그래서 저게 통하는 것이다.

        // Arrays.sort(Object[] objs, Comparator c)
        // 단순 오름차순이 아닌, 원하는 정렬 기준 c에 따라 정렬하는 메서드
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 정렬기준: String.CASE_INSENSITIVE_ORDER
        System.out.println("strArr=" + Arrays.toString(strArr));
        Arrays.sort(strArr, new Descending()); // 정렬기준: new Descending()
        System.out.println("strArr=" + Arrays.toString(strArr));
    }
}


