package ch14_Lambda_Stream;

@FunctionalInterface    // 람다식으로 표현할 수 있는 단 하나의 추상메서드를 가지는 인터페이스
interface MyFunction3 {
    void run();
    // public abstract void run(); 추상 메서드를 가진다.
}




public class _05_FuncIntfcePractice2 {
    // 매개변수의 타입으로 함수형 인터페이스를 집어넣을 수 있다는 것을 보여주는 예시.
    static void execute(MyFunction3 f) {
        f.run();
    }



    // 리턴 타입이 MyFunction3, 즉 리턴 타입을 함수형 인터페이스로 할 수도 있음을 보여주는 예시
    static MyFunction3 getMyFunction() {
        MyFunction3 f = () -> System.out.println("getMyFunction 출력문 f3.run()");
        return f;   // 람다식 자체를 리턴한다. 리턴된 람다식이 위의 println 출력문을 실행하게 된다.
                    // 결과적으로는 println 출력문을 호출한 것과 동일하게 될 것이다.
    }
//             사실 아래처럼 써도 된다.
//             static MyFunction3 getMyFunction() {
//                 return () -> System.out.println("f3.run()");
//             }

//      이 경우에는 리턴문에 그냥 람다식을 있는 그대로 쓴 경우다.
//      저렇게 함수형 인터페이스를 리턴 타입으로 선언하면 이렇게 return 문에 람다식을 그대로 써도 되는 것이다.



    public static void main(String[] args) {
        // 람다식으로 MyFunction3의 run()을 구현
        MyFunction3 f1 = ()-> System.out.println("첫 번째 출력: f1.run()");

        MyFunction3 f2 = new MyFunction3() {  // 익명클래스로 run()을 구현
            public void run() {   // public 을 반드시 붙여야 함
                System.out.println("두 번째 출력: f2.run()");
            }
        };

        MyFunction3 f3 = getMyFunction();
        // 위에서 getMyFunction() 을 정의할 때부터 리턴 타입이 MyFunction3 이고,
        // return 문에 람다식을 써도 된다고 했었다. 이게 실행되면
        // 바로 "getMyFunction 출력문 f3.run()" 이라는 메시지가 출력된다.

        f1.run();   // "첫 번째 출력: f1.run()" 출력
        f2.run();   // "두 번째 출력: f2.run()" 출력
        f3.run();   // "getMyFunction 출력문 f3.run()" 출력

        execute(f1); // = f1.run() 과 동일함.
        execute( ()-> System.out.println("run()") ); // 참조변수 없이 그냥 곧바로 람다식 입력
    }

    // 이렇게 람다식은 리턴타입으로 사용되기도 하고, 매개변수로 들어가기도 한다!
}
