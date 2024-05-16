package ch11_CollectionsFramework;

//  다음과 같은 상속 및 구현 관계가 형성되어 있다. (I는 인터페이스, C는 클래스)
//
//    Collection(I)   <-- List(I)     <-- Vector(C)   <-- Stack(C)
//    Collection(I)   <-- Queue(I)    <-- Deque(I), LinkedList(C)
//
//  - LinkedList 는 List 인터페이스도 구현하고 Queue 인터페이스도 구현한 클래스이다.
//  - Stack 은 클래스이기 때문에 자체적인 객체를 생성할 수 있지만 Queue 는 인터페이스이기 때문에 자체의 객체를 생성할 수 없다.
//  - Stack 과 Queue 둘 다 이러한 상속 및 구현 관계로 인해 상속 받거나 오버라이딩한 메서드를 사용할 경우 기존의 의미가 퇴색될 수 있다.

//
//
//  Stack
//  LIFO 방식 : 밑이 막힌 상자이며, 위에서만 꺼낼 수 있는 상황과 같다.
//  예를 들면 수식계산 또는 수식괄호검사에 활용되기도 하고, 워드프로세서 프로그램의 undo 와 redo 를 구현할 때도 사용된다.
//  그리고 웹 브라우저 뒤로 가기와 앞으로 가기에도 활용된다.
//  boolean empty()            비어있는지 여부 확인
//
//  Object peek()              맨 뒤에 저장된 객체 리턴 (조회만 함)
//
//  Object pop()               맨 뒤에 저장된 객체 리턴하면서 삭제
//
//  Object push(Object item)   맨 뒤에 객체를 저장하고 리턴
//
//  int search(Object item)    입력한 객체의 위치값을 리턴(index 시스템이 아니라서 첫 값이 1로 시작)
//                             못 찾으면 -1 리턴
//                             사용하는 목적은 indexOf 와 동일한데 index 시스템은 아니라는 차이점이 있음
//
//
//
//  Queue
//  FIFO 방식 : 밑이 뚫린 상자이며, 아래로 꺼낼 수 있는 상황과 같다.
//  최근사용문서(recent files 목록 나타내는 기능), 프린터 인쇄대기목록, 버퍼 등을 구현할 때 활용된다.
//  버퍼는 작업을 할 때 미리 쌓아놓는 것을 의미한다.
//  boolean offer(Object o)    입력한 객체를 Queue 에 추가. 성공하면 true. 꽉 차서 못하면 false 리턴. [많이 사용]
//
//  Object remove()            맨 앞에 저장된 객체 리턴하면서 삭제. 비어 있으면 예외 발생. 적게 사용
//
//  Object poll()              맨 앞에 저장된 객체 리턴하면서 삭제. 비어 있으면 null 리턴. [많이 사용]
//
//  Object element()           맨 앞에 저장된 객체 리턴 (조회만 함) / 비어 있으면 예외 발생. 적게 사용
//
//  Object peek()              맨 앞에 저장된 객체 리턴 (조회만 함) / 비어 있으면 null 리턴. [많이 사용]
//
//  앞서 언급했듯이, Queue 는 인터페이스이기 때문에 new 키워드를 통한 자체 인스턴스를 생성할 수 없다.
//  그래서 참조변수는 Queue 로 하고 new 키워드는 LinkedList 타입의 인스턴스로 생성한다.

import java.util.*;

public class _08_StackAndQueue {
    // LinkedList 인스턴스를 담은 Queue 타입의 q 참조변수를 static 변수로 선언
    static Queue q = new LinkedList();

    // Queue 길이를 제한할 용도의 static final 상수 정의 및 초기화
    static final int MAX_SIZE = 5;

    // q 에 원소를 저장하는 것과 관련된 로직을 정의한 static 메서드 정의
    public static void save(String input) {
        // 빈 문자열이 아닐 경우에만 저장하도록 조건 걸기
        if(!"".equals(input))
            q.offer(input);

        // queue 의 최대 크기를 넘으면 제일 처음 입력된 것을 삭제하도록 조건 걸기
        if(q.size() > MAX_SIZE)
            q.remove();
    }

    public static void main(String[] args) {
        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선1 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  Object push(Object item)   맨 위에 객체를 저장하고 리턴
        Stack st = new Stack();
        st.push("0");
        st.push("1");
        st.push("2");
        System.out.println("Stack st = new Stack();\n" +
                "st.push(\"0\");\n" +
                "st.push(\"1\");\n" +
                "st.push(\"2\");");
        // Stack 은 데이터의 변경이 뒤에서 일어나기 때문에 배열 기반 자료구조(연속적 자료구조)로 구현하는 것이 적합하다.
        System.out.println("st = " + st);



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선2 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  boolean offer(Object o)    입력한 객체를 Queue 에 추가. 성공하면 true. 꽉 차서 못하면 false 리턴.
        Queue queue = new LinkedList();
        queue.offer("0");
        queue.offer("1");
        queue.offer("2");
        System.out.println("Queue queue = new LinkedList();\n" +
                "queue.offer(\"0\");\n" +
                "queue.offer(\"1\");\n" +
                "queue.offer(\"2\");");
        // Queue 는 데이터의 변경이 앞에서 일어나기 때문에 연결 기반 자료구조(연결형 자료구조)로 구현하는 것이 적합하다.
        // 그래서 구현체로 LinkedList 를 사용하고 있는 것이다.
        // 만약 ArrayList 같은 연속적 자료구조를 구현한 Collection 을 쓰면 remove 했을 때 작업이 많아져 비효율적이 된다.
        // 연결형 자료구조를 통해 구현하면 작업을 할 때 Node 의 next 값만 다르게 하면 되기 때문에 성능에 유리하다.
        System.out.println("queue = " + queue);



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선3 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  boolean empty()     비어있는지 여부 확인
        //  Object pop()        맨 뒤에 저장된 객체 리턴하면서 삭제
        System.out.println("st = " + st);
        System.out.println("while(!st.empty()) {\n" +
                "    System.out.println(\"st.pop() = \" + st.pop());\n" +
                "}");
        while(!st.empty()) {
            System.out.println("st.pop() = " + st.pop()); // 스택에서 요소 하나를 꺼내서 출력
        }



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선4 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  Object poll()       맨 앞에 저장된 객체 리턴하면서 삭제. 비어 있으면 null 리턴.
        System.out.println("queue = " + queue);
        System.out.println("while(!queue.isEmpty()) {\n" +
                "    System.out.println(\"queue.poll() = \" + queue.poll()); \n" +
                "}");
        while(!queue.isEmpty()) {
            System.out.println("queue.poll() = " + queue.poll());   // 큐에서 요소 하나를 꺼내서 출력
        }



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선5 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  boolean empty()     비어있는지 여부 확인. 상속 받은 isEmpty() 를 사용해도 무방하다.

        System.out.println("< Stack 의 활용예시 - 괄호검사 >");
        Stack st2 = new Stack();
        Scanner test = new Scanner(System.in);
        System.out.print("괄호를 포함시킨 문자열을 입력해보세요 : ");
        String expression = test.nextLine();

        try {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(') {            // 여는 괄호이면 여는 괄호 '(' 를 push
                    st.push(ch + "");
                } else if (ch == ')') {     // 닫는 괄호이면 여는 괄호 '(' 를 pop
                    st.pop();
                }
            }

            if (st.empty()) {             // 괄호가 서로 짝이 맞으면 stack 이 비어있게 된다.
                System.out.println("괄호 쌍이 맞습니다.");
            } else {                        // 괄호가 짝이 맞지 않으면 여는 괄호가 Stack 에 남기 때문에 비어 있지 않다.
                System.out.println("괄호 쌍이 맞지 않거나 괄호 순서가 올바르지 않습니다.");
            }

        } catch (EmptyStackException e) {
            System.out.println("괄호 쌍이 맞지 않거나 괄호 순서가 올바르지 않습니다.");
        }



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선6 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("< Queue 의 활용예시 - 명령어를 입력했던 History 를 보여주는 프로그램 구현 >");
        // 위에 static 변수로 q 의 Queue 최대 길이를 정해놓았다.
        System.out.print("help를 입력하면 도움말을 볼 수 있습니다 ");

        while(true) {
            System.out.print(">> ");
            try {
                // 화면으로부터 라인단위로 입력받는다.
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim(); // 입력한 내용 중 양 옆의 공백은 제거해줌
                                                    // 공백만 입력한 것은 명령으로 취급 안하게 하는 기능도 담당한다.
                if("".equals(input)) continue;

                if(input.equalsIgnoreCase("q")) {
                    System.exit(0); // q 또는 Q 를 입력하면 프로그램 종료
                } else if(input.equalsIgnoreCase("help")) {
                    // 대소문자 구분 없이 help 라고 입력하고 Enter 칠 때 출력 HelP HElp HeLP 등 상관없음
                    System.out.println(" help - 도움말을 보여줍니다.");
                    System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
                    System.out.println(" history - 최근에 입력한 명령어를 "
                            + MAX_SIZE +"개 보여줍니다.");
                } else if(input.equalsIgnoreCase("history")) {
                    // LinkedList의 내용을 보여준다.
                    LinkedList list = (LinkedList)q;
                    final int SIZE = list.size();

                    for (int i = 0; i < SIZE; i++) {
                        System.out.println((i+1)+"."+list.get(i));
                    }
                } else {
                    // 입력받은 명령어를 저장
                    save(input);
                    System.out.println(input);
                } // if(input.equalsIgnoreCase("q")) {
            } catch(Exception e) {
                System.out.println("입력 오류입니다.");
            }
        } // while(true)
    }
}
