package ch14_Lambda_Stream;

//        자바는 객체지향언어인데 JDK 1.8부터 함수형 언어기능을 추가시켰다.
//
//        람다식 (Lambda Expression)
//        - 람다식은 함수(메서드)를 간단한 식(expression)으로 표현하는 방법이다.
//        - 즉, 람다식의 대상은 "메서드"이다.
//        - 람다식은 기본적으로 익명함수이다. anonymous function.
//          실제로 메서드를 람다식으로 바꿀 때 반환타입과 함수의 이름을 지워버린다.
//                (int a, int b) -> {return a>b ? a : b ; }
//
//        함수와 메서드는 기능상 유사하나, 함수는 클래스로부터 독립적이고 메서드는 클래스에 종속적이라 보면 된다.
//        즉, 메서드가 더 객체지향언어라는 점을 드러낸다. 자바에서는 클래스 바깥에 있을 수 없으므로 사실 상 메서드밖에 없다.
//        그러나 대화할 때는 메서드나 함수나 그게 그거라서 함수가 있는 것처럼 얘기하기도 한다.
//
//
//        람다식 작성하기
//        int max (int a, int b) {
//            return a > b ?  a : b ;	만약 이런 함수가 있다면 아래와 같이 바꾸면 끝이다.
//        }
//        1. 메서드의 이름과 반환타입 제거
//        (int a, int b) {
//            return a > b ?  a : b ;
//        }

//        2. 조건식과 중괄호 사이에 -> 화살표 추가 ( + 한 눈에 보기 좋게 을 한 줄로 만들기)
//        (int a, int b) ->  { return a > b ?  a : b ; }

//        3. return 도 안 쓰고, 세미콜론도 안 쓴다.
//        만약 중괄호 안에 문장이 한 줄이라면 중괄호도 생략 가능하다.
//        (int a, int b) -> a > b ? a : b

//        4. 매개변수 타입이 추론 가능하면 생략 가능 ( 대부분의 경우 생략 가능)
//        (a, b) -> a > b ?  a : b
//        이렇게 람다식이 완성 되었다.
//



//        람다식 작성할 때 주의사항
//        1. 매개변수가 하나일 경우 괄호 생략 가능 (타입이 없을 때만)
//                  (a)  ->  a * a      a -> a * a	정상작동
//                (int a)  -> a * a		a -> a * a 	오류발생
//
//        2. 블록 안에 문장이 하나뿐일 때 중괄호와 세미콜론을 셋트로 생략 가능
//                ( int i ) -> {
//                System.out.println(i); 	--->  ( int i )  -> System.out.println(i)
//        }

//        단, 단 하나뿐이라는 그 문장이 만약 return 문이라면 중괄호를 없애면 안 된다.
//                (int a , int b) -> {return a > b ? a : b; } 	정상작동
//                (int a , int b) -> return a > b ? a : b		오류발생
//        그런데 대부분의 경우 return 문 자체도 귀찮아서 안 쓰기 때문에... 신경 쓸 일이 없을듯.
//
//
//        람다식은 익명 함수라고 하긴 했는데 사실상 람다식은 익명 객체이다. 자바에서는 메서드만 따로 존재할 수 없다.
//        그래서 엄밀히 말하면 람다식은 익명 객체라고 해야 하는 것이다.

//          ( a , b ) -> a > b ? a : b
//          이 코드가 사실은 아래의 코드다.

//          new Object() {
//              int max (int a , int b) {
//                  return a > b ? a : b ;
//              }
//          }


//        즉, 람다식은 객체다. 익명 클래스의 객체이다. 이처럼 객체의 선언과 생성을 동시에 한 것이나 다름 없는 것이다.
//        원래 정석은 오른쪽처럼 쓰는 것이다... 근데 왼쪽의 람다식처럼 쓸 수 있게 허용된 것이다...
//        어쨌든 람다식은 "익명 객체" 라는 것이다.

//        그런데 객체를 다루려면 참조변수가 필요한데? 익명객체라서 인스턴스의 참조변수도 안 만들었다...
//        그럼 어떻게 호출할까? Object 클래스로 부르나? 아니다. 사실 호출해서 사용이 불가하다...
//
//            int max(int a, int b) {
//            return a > b ? a : b;
//        }
//
//        public class _01_LambdaExpression {
//            public static void main(String[] args) {
//                // 람다식으로 바꿔보기 1
//            원본메서드 :
//              public static int max(int a, int b) {
//                    return a > b ? a : b;
//               }
//            람다식 :
//              (int a , inb b) -> a > b ? a : b  // 더 간단하게 가능!
//              (a , b) -> a > b ? a : b  // 이게 제일 간단함!
//
//
//            원본메서드 :
//                public int printVar(String name, int i) {
//                    System.out.println(name + "=" + i)
//                }
//
//            람다식 :
//              (String name, int i) -> System.out.println(name + "=" + i) // 더 간단하게 가능!
//              (name, i) -> System.out.println(name + "=" + i) // 이게 더 간단함!
//
//            원본메서드 :
//              int square (int x) {
//                  return x * x;
//                }
//
//            람다식 :
//            (x) -> x * x // 더 간단하게 가능!
//            x -> x * x  // 매개변수가 하나일 땐 소괄호를 지울 수 있다!
//
//            원본메서드 :
//            int roll () {
//                return (int)(Math.random() * 6);
//                }
//
//            람다식 :
//            () -> (int)(Math.random() * 6 // 빈 괄호는 생략 불가! 이대로 하면 됨!

public class _01_LambdaExpression {
    public static void main(String[] args) {
//        Object obj = (a,b) -> a > b ? a : b
        new Object() {
            int max (int a, int b) {
                return a > b ? a : b;
            }
        };

//        int value = obj.max(3,5); <-- 에러. Object 클래스에 max() 메서드가 없기 때문...
//        Object 클래스 말고 다른 것이 필요하다... 그게 바로 함수형 인터페이스다.
    }
}

