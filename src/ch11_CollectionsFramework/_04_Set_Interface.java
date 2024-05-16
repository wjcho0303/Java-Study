package ch11_CollectionsFramework;
//
//      Set Interface 는 앞서 살펴봤듯이 순서는 없는데 요소끼리 겹치면 안 된다.
//
//      Set 인터페이스를 구현하는 클래스는 HashSet 과 TreeSet 이 있다.
//      Set 인터페이스의 메서드는 Collection Interface 것과 똑같다고 생각하면 된다.
//      여기에 Set 이 추가로 갖고 있는 메서드는 집합과 관련된 기능들을 약간 소개한다:
//
//      boolean addAll (Collection c)       입력한 Collection 요소들 중 없는 것들을 추가
//                                          (합집합)
//
//      boolean containsAll (Collection c)  입력한 Collection 요소들이 빠짐없이 포함되어 있는지 체크
//                                          (부분집합 여부를 검사)
//
//      boolean removeAll (Collection c)    집합 내에서 입력한 Collection 요소들을 싹 다 삭제
//                                          (차집합)
//
//      boolean retainAll (Collection c)    입력한 Collection 요소들만 남기고 그 외에 다 삭제
//                                          (교집합)
//
//      집합과 관련된 기능이기 때문에 파라미터에 모두 Collection 이 들어가는 모습을 볼 수 있다.
//      반환 타입이 boolean 인 것은 처리를 했을 때 변화가 있으면 true 고, 아무 변화가 없으면 false 이다.
//      합칩합 차집합 같은 것들을 할 때는 HashSet 이나 TreeSet 을 사용하면 매우 편리하다.
//

public class _04_Set_Interface {
}
