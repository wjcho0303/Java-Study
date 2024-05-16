package ch06_OOP1;

public class _07_CallStack {
    public static void main(String[] args) {
        // 호출스택 CallStack 은 모든 프로그래밍 언어에서 공통적인 것이고 매우 중요한 개념이다.
        // CallStack 을 이해하지 못하면 기본형 매개변수, 참조형 매개변수, 예외처리 등을 이해하지 못한다.

        // Stack 은 무엇인가? 밑이 막혀있는 상자다. 그래서 뭔가를 집어넣으면 위로 차곡차곡 쌓인다.
        // 그래서 기본적으로 Stack 은 Last In First Out(LIFO) 방식이다. 나중에 입력된 것일수록 가장 빨리 출력된다.

        // CallStack 은 무엇인가? CallStack 은 메서드와 관련이 있는 장소로,
        // 메서드를 수행하는 데에 필요한 메모리가 제공되는 공간이다.
        // 메서드의 작업들을 적재하면 적재할수록 위쪽으로 차곡차곡 쌓인다.

        // 클래스(static method) 또는 인스턴스 참조변수에 의해 메서드가 호출되면 CallStack 에 메모리가 할당되고,
        // 모든 메서드가 종료되면 CallStack 에 할당된 메모리가 해제된다.

        // 자바 소스파일을 실행하면 거의 대부분의 경우 CallStack 의 맨 밑바닥에는 main 메서드가 메모리를 할당받고 있다.

        // 상황을 한 번 만들어 보자.
        // 프로그램이 실행되면 먼저 main 메서드가 CallStack 의 가장 아래에 적재된다.
        // 만약 코드 상에서 main 메서드의 구현부의 맨 첫 줄에 println() 이 있다고 하자.
        // 그러면 CallStack 상에서 main() 위에 println() 메서드가 적재된다.
        // 이렇게 되면 아래에 있는 main()는 "대기상태"가 되고 가장 위에 있는 println()은 "실행상태"가 된다.
        // println()가 올라가기 전에는 main()가 "실행상태"였다. 그런데 "main()이 println()를 호출"하면서
        // main()은 "대기상태", println()는 "실행상태"가 되는 것이다.
        // 그리고 println()이 작업을 마치면 다시 main()만 남게 되어 실행상태로 된다. 이런 식으로 맨 위에서부터 실행을 한다.

        // CallStack 은 쓰레드와도 연관이 되는데, 싱글 쓰레드는 CallStack 이 한 개인 것이고,
        // 멀티 쓰레드는 이런 CallStack 이 여러 개 존재하는 것이다.

    }
}
