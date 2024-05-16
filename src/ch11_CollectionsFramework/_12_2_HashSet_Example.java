package ch11_CollectionsFramework;
import java.util.*;


// 교집합, 합집합, 차집합을 보여주는 예제
public class _12_2_HashSet_Example {
    public static void main(String[] args) {
        HashSet setA   = new HashSet();
        HashSet setB   = new HashSet();
        HashSet setHab = new HashSet();
        HashSet setKyo = new HashSet();
        HashSet setCha = new HashSet();

        setA.add("1");	setA.add("2");  setA.add("3");
        setA.add("4");  setA.add("5");
        System.out.println("A = "+setA);

        setB.add("4");	 setB.add("5");  setB.add("6");
        setB.add("7");   setB.add("8");
        System.out.println("B = "+setB);


        // 교집합 (사실 retailAll 하면 되긴 함...)
        Iterator it = setB.iterator();  // B의 iterator 를 만들었다는 것은 B의 요소들을 꺼내서 뭔가를 하겠다는 것이다.
        while(it.hasNext()) {
            Object tmp = it.next();     // 일단 B에서 하나를 꺼내서 (맨 처음 4부터) tmp 에 저장한다.
            if(setA.contains(tmp))      // 그 꺼낸 객체 tmp 가 (처음 4) SetA 에 존재하는지 확인해서
                setKyo.add(tmp);        // 있으면 tmp 를 SetKyo 에 포함시킨다.
        }                               // A와 B 의 입장을 바꿔서 해도 결과는 똑같이 나올 것이다.


        // 차집합 A - B (사실 removeAll 하면 되긴 함...)
        it = setA.iterator();           // B의 iterator 를 만들었다는 것은 B의 요소들을 꺼내서 뭔가를 하겠다는 것이다.
        while(it.hasNext()) {
            Object tmp = it.next();     // 일단 A에서 하나를 꺼내서 (맨 처음 1부터) tmp 에 저장한다.
            if(!setB.contains(tmp))     // 그 꺼낸 객체 tmp 가 (처음 1) SetB 에 존재하는지 확인해서
                setCha.add(tmp);        // 포함되지 않아야 setCha 에 포함시킨다.
        }                               // 이 경우는 A와 B의 입장을 바꾸면 안 된다. B - A 와 A - B 는 다르기 때문이다.


        // 합집합 (사실 addAll 하면 되긴 함...)
        it = setA.iterator();           // A의 iterator 를 만들었다는 것은 A의 요소들을 꺼내서 뭔가를 하겠다는 것이다.
        while(it.hasNext())             // 일단 A에서 하나를 꺼내서 setHab 에 포함시킨다.
            setHab.add(it.next());      // 계속 반복해서 A 의 요소 전체를 setHab 에 넣는다.

        it = setB.iterator();           // B의 iterator 를 만들었다는 것은 B의 요소들을 꺼내서 뭔가를 하겠다는 것이다.
        while(it.hasNext())             // 일단 B에서 하나를 꺼내서 setHab 에 포함시킨다.
            setHab.add(it.next());      // 계속 반복해서 B 의 요소 전체를 setHab 에 넣는다.
        // 그럼 A랑 B 둘 다 가져서 중복되는 자료는 어떻게 하지?
        // 상관 없다. 어차피 HashSet 특성상 중복을 허용하지 않아서 false 처리해버려서 지가 알아서 중복 자료 안 넣는다.


        System.out.println("A ∩ B = " + setKyo); // 교집합
        System.out.println("A U B = " + setHab); // 합집합
        System.out.println("A - B = " + setCha); // 차집합
    }
}
