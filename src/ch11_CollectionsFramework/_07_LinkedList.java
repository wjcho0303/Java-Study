package ch11_CollectionsFramework;

//  ArrayList 는 배열을 구조가 간단하고 데이터를 읽는 데 걸리는 시간(access time)이 짧다는 장점이 있다.
//  그러나 배열은 크기를 바꿀 수 없다는 단점이 있다.
//  크기를 늘리려면 더 큰 새로운 배열을 생성 후 데이터를 거기에 복사해서 넣고(addAll 메서드) 참조변수를 새로 지정해야 한다.
//  이 방법이 싫다면 처음부터 배열의 크기를 넉넉하게 생성해야 한다. 그러나 너무 크게 만들어 놓으면 또 메모리 낭비이다.
//  그리고 ArrayList 는 마지막에 있는 데이터를 처리하는 건 빠르지만
//  중간이나 앞쪽에 데이터를 추가 또는 삭제할 때는 리소스를 많이 잡아먹는다.
//
//
//  배열이나 ArrayList 의 단점들을 보완하려고 나온 게 LinkedList 이다.
//  배열이나 ArrayList 와 달리, LinkedList 는 불연속적으로 존재하는 데이터를 연결한다.
//  즉, LinkedList 는 배열이나 ArrayList 과는 달리 저장소 상의 데이터 주소값이 불연속적이다.
//
//
//  저장소 상에서 멀리 떨어져 있는데 어떻게 같은 List 안에 존재하는가? 바로 node 라는 개념을 이용한다.
//  그래서 LinkedList 내부의 element 객체들은 Node 객체가 되고, 실제로 Node 라고 부르기도 한다.
//
//    class Node {
//        Node next;    // 다음 Node 의 주소값을 저장
//        Object obj;   // LinkedList 의 원소
//    }
//
//  Node 객체 내부에는 next 라는 멤버변수가 있어서 그 next 멤버변수의 다음 Node 객체의 주소값을 저장하고 있다.
//  이렇게 하면 순서가 존재한다는 List 의 특징도 유지할 수 있다.
//
//
//  이렇게 Node 객체라는 개념을 도입함으로써 수정 또는 삭제와 같은 데이터 변경에 유연하게 대처할 수 있게 되었다.
//  만약 중간에 있는 객체를 삭제해도 그냥 next 참조 주소값만 바꿔주면 되고, next 참조 주소값을 잃은 Node 는 가비지 컬렉터가 후에 삭제한다.
//  만약 객체를 추가하면 next 참조 주소값을 두 번만 바꿔주면 된다.(앞 순서에 있는 Node 와 추가되는 자기 자신 Node)
//
//
//  그러나 LinkedList 에도 단점이 있다. 바로 데이터 접근성이 좋지 않다는 점이다.
//  주소값이 불연속적이기 때문에 한 번에 찾아가기 힘들다. Node 의 next 멤버변수가 가진 주소값을 계속 체크하면서 찾아가야 한다.
//
//
//  이걸 또 개선한 게 doubly LinkedList 이다. doubly LinkedList 의 Node 들은 주소값을 멤버변수를 두 종류 가진다.
//  일반 LinkedList 는 next 주소값만 있었는데 이제는 previous 주소값도 있는 것이다. 그럼 접근성이 조금은 나아진다.
//  그러나 한 번에 한 Node 씩 참조해서 찾아가야 한다는 건 똑같다. 방향 선택지가 생긴 것일 뿐이다.
//
//    class Node {
//        Node previous;
//        Node next
//        Object obj;
//    }
//
//  doubly LinkedList 를 또 개선한 게 doubly circular LinkedList 이다.
//  맨 처음 Node 와 맨 끝 Node 를 연결시켰다는 차이일 뿐이다.
//  doubly LinkedList 에서는 첫 Node 의 previous 가 null 이었고, 마지막 Node 의 next 가 null 이었는데
//  거기에 서로를 채워 넣는 것이다. 즉, Node 의 연결을 순환적인 구조로 만든 것이다.
//  실제 자바는 위 세 가지 방식 중 일반 doubly LinkedList 로 구현이 되어 있다(비순환적임).
//
//
//  데이터가 많다고 가정했을 때, 단순한 읽기 작업은 ArrayList 가 훨씬 빠르지만 변경 작업은 LinkedList 가 훨씬 유리하다.
//  모든 자료구조는 크게 두 가지로 나뉜다: 배열 기반의 자료구조(연속적)   /   연결 기반의 자료구조(불연속적)
//  ArrayList 는 "배열 기반"의 자료구조의 대표적인 예시이고, LinkedList 는 "연결 기반" 자료구조의 대표적인 예시이다.
//
//
//  관련 메서드들이 무엇이 있는지, 메서드가 하는 일들에 대한 내용들은 ArrayList 의 내용과 크게 다르지 않으므로
//  메서드에 대한 학습은 ArrayList 학습 자료를 통해 반복 학습하면 된다.
//

public class _07_LinkedList {
    public static void main(String[] args) {
    }
}
