package ch11_CollectionsFramework;
import java.util.*;
//      참고 영상: (TreeSet 은 그림 자료가 더 학습효과가 좋아서 그냥 영상을 본 후 읽어보는 걸 권한다.)
//      https://www.youtube.com/watch?v=_4EF-26Ke3o&list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp&index=130


//      TreeSet 은 HashSet 과 마찬가지로 Set interface 를 구현하는 클래스이다.
//
//      TreeSet 은 이진탐색트리, 즉 binary search tree(이진 탐색 트리) 라는 자료구조를 향상 시킨
//      'red-black tree'(레드-블랙 트리) 형태의 데이터를 저장하는 컬렉션 클래스이다.
//      이진 탐색 트리는 뭐고, 이진 탐색 트리는 뭔가?
//
//      일단 이진 트리는 다음과 같은 개념이다:
//      범위탐색과 정렬에 유리하다. binary tree 는 모든 노드가 최대 2개(0~2개)의 하위 node 를 가진다.
//      최상위 요소는 root 라고 부르고 아래 그림과 같은 이진 트리(binary tree) 구조로 노드가 뻗어 나간다.
//
//                                      root
//
//                                1             2
//                             3     4        5    6
//                           7  8  9   10   11 12 13 14
//
//      root : 자식 2개 /  1, 2 : 자식 2개  / 3, 4, 5, 6 : 자식 2개 / 7,8,9,10,11,12,13,14 : 자식 0개
//      root 는 모든 node 의 부모고, 각 node 가 부모-자식 관계로 연결되어 있다.
//      이진 트리에서의 node 는 tree node 라고 부른다.
//      node 를 사용한다는 점에서 LinkedList 와 공통점을 가진다고도 할 수 있다.
//      아무튼 이런 식의 자료구조가 바로 binary tree (이진 트리) 자료구조이다.




//      그럼 binary search tree, 즉 '이진 탐색 트리'는 무슨 말일까?
//      이진 트리이기는 이진 트리인데 부모보다 작은 값은 왼쪽, 부모보다 큰 값은 오른쪽에 저장하는 TreeNode 구조이다.
//
//                                      15
//                                  12       19
//                               9    13  16    22
//
//
//       이진 탐색 트리의 단점은 데이터가 많아질수록 비교 횟수가 증가하여 추가, 삭제에 시간이 더 걸리게 된다는 점이다.
//       이건 LinkedList 처럼 연결방식을 사용하기 때문에 비슷한 이유로 발생하는 단점이라고 볼 수 있다.
//       이진 트리와 이진 탐색 트리의 차이는 위와 같이 숫자의 대소를 기준으로 자료가 정렬된다는 점에 있다.
//       결국 이진 탐색 트리도 이진 트리에 포함되는 것이다.




//      TreeSet 의 각 TreeNode 멤버변수는 다음과 같다:
//      class TreeNode {
//          TreeNode leftNode;      // 왼쪽 자식 노드
//          Object element;     // 저장하고 있는 객체
//          TreeNode rightNode;     // 오른쪽 자식 노드
//      }
//
//      LinkedList 의 경우 previous 와 next Node 를 갖고 있었던 것과 유사하다.
//      차이점은 TreeNode 는 TreeNode 간에 부모와 자식 관계가 존재한다는 것이다.
//
//

//
//      이번엔 TreeSet 의 메서드를 살펴보자. 당연히 Collection interface 와 Set interface 를 구현하기 때문에
//      이들의 메서드를 오버라이드 하고 있고, 이 점에 대해서는 언급을 생략하겠다.
//      그래서 이번에는 TreeSet 자체의 특성이 드러나는 메서드 위주로만 소개한다.
//
//      TreeSet()                           기본 생성자
//
//      TreeSet(Collection c)               입력한 컬렉션의 요소들을 TreeSet 구조로 객체 생성
//
//      TreeSet(Comparator comp)            주어진 정렬기준으로 정렬하는 TreeSet 객체 생성
//
//      Object first()                      오름차순으로 정렬된 순서의 첫 번째 객체 리턴
//
//      Object last()                       오름차순으로 정렬된 순서의 맨 마지막 객체 리턴
//
//      Object ceiling(Object o)            입력한 객체와 같은 객체를 리턴. 만약 없다면 큰 값을 가진 객체 중 제일 가까운 것 리턴
//                                          없으면 null    ≤ 기호를 생각하면 된다.
//
//      Object floor(Object o)              입력한 객체와 같은 객체를 리턴. 만약 없다면 작은 값을 가진 객체 중 제일 가까운 것 리턴
//                                          없으면 null    ≥ 기호를 생각하면 된다.
//
//      Object higher(Object o)             입력한 객체보다 큰 값을 가진 객체들 중 제일 가까운 값의 객체 리턴.
//                                          없으면 null    < 기호를 생각하면 된다.
//
//      Object lower(Object o)              입력한 객체보다 작은 값을 가진 객체들 중 제일 가까운 값의 객체 리턴.
//                                          없으면 null    > 기호를 생각하면 된다.
//
//      SortedSet subSet(Object obj1, Object obj2)      obj1 과 obj2 사이의 결과를 리턴 (obj1 ≤ x < obj2)
//
//      SortedSet headSet(Object obj)                   obj 보다 작은 객체들을 리턴
//
//      SortedSet tailSet(Object obj)                   obj 보다 큰 객체들을 리턴
//

public class _13_TreeSet {
    public static void main(String[] args) {
        Set set1 = new TreeSet();

        for (int i = 0; set1.size() < 6 ; i++) {
            int num = (int)(Math.random()*45) + 1;
            set1.add(num);  // set.add(new Integer(num));
        }

        System.out.println(set1);
        // TreeSet 은 이렇게 별도로 정렬해줄 필요가 없다 ㄷㄷㄷ... 이게 바로 TreeSet 의 장점이다.
        // 자료 자체가 오름차순을 기본적으로 내포한다.

        TreeSet set2 = new TreeSet();

        String from = "b";
        String to	= "d";

        set2.add("abc");      set2.add("alien");    set2.add("bat");
        set2.add("car");      set2.add("Car");      set2.add("disc");
        set2.add("dance");    set2.add("dZZZZ");    set2.add("dzzzz");
        set2.add("elephant"); set2.add("elevator"); set2.add("fan");
        set2.add("flower");

        System.out.println(set2);
        System.out.println("range search : from " + from  +" to "+ to);
        System.out.println("result1 : " + set2.subSet(from, to));           // b 와 d 사이
        System.out.println("result2 : " + set2.subSet(from, to + "zzz"));   // b 와 dzzz 사이






        TreeSet set3 = new TreeSet();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for(int i=0; i < score.length; i++)
            set3.add(new Integer(score[i]));

        System.out.println("50보다 작은 값 :" + set3.headSet(new Integer(50)));
        System.out.println("50보다 큰 값 :"  + set3.tailSet(new Integer(50)));
        System.out.println("40과 80 사이의 값 :"  + set3.subSet(new Integer(40), new Integer(80)));
    }
}
