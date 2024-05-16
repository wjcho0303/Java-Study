package ch09_UsefulPackages;

//  앞서 살펴본 StringBuffer 의 경우에는 동기화가 되어 있어 멀티 쓰레드에 안전하다. (thread-safe)
//
//  반면 지금 살펴볼 StringBuilder 는 동기화가 안 되어 있다. 다만, 멀티 쓰레드 프로그램이 아닌 경우
//  동기화가 불필요하며, 그런 경우에는 성능을 낭비하게 된다.
//
//  그래서 싱글 쓰레드 프로그램에서는 StringBuffer 말고 StringBuilder 를 사용하는 것이 좋다.
//  (물론 StringBuffer 써도 대부분 문제 없음)
//
//  StringBuilder 와 StringBuffer 의 기능이나 메서드는 거의 차이가 없다. 내부적으로 동기화를 했느냐의 차이일 뿐이다.
//  그래서 Builder 와 Buffer 이름만 바꿔도 프로그램이 돌아갈 정도이다. 결국 쓰레드와 동기화 차이일 뿐이다.


public class _08_StringBuilder {
}
