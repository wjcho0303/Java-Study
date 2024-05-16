package ch14_Lambda_Stream;

@FunctionalInterface // max2 라는 메소드를 주석처리하지 않으면 메소드가 2개 이상으로 되어
        // 오류경고를 발생시키는 어노테이션.
interface MyFunction {  // 함수형 인터페이스는 단 하나의 추상메서드만 가져야 한다.
//    public abstract int max(int a, int b);
    int max(int a, int b); // public abstract 생략 가능
//    public abstract int max2(int a, int b);
}
public class _04_FuncIntfcePractice {
    public static void main(String[] args) {
//        Object obj = (a,b) -> a > b ? a : b;
//        Object obj = new Object() {
//            int max(int a, int b) {
//                return a > b ? a : b;     // obj를 참조변수로 사용하려고 호출해보면 에러가 뜸...
//            }
//        };
        MyFunction f = new MyFunction() {
            public int max(int a, int b) {  // 함수형 인터페이스를 오버라이딩 할 때는 public 필수(안 붙이면 default)
                 return a > b ? a : b;      // 다른 상황에서도 오버라이딩할 때는 좁게 못 바꾸니까.
            }
        };

        int value = f.max(3,5);     // 이제 참조변수 f가 정상적으로 작동함.

//        int value = obj.max(3,5); // 오류 발생! 람다식을 다루려면 뭔가 필요하다...!

        /*
        MyFunction f = new MyFunction() {
            public int max(int a, int b) {
                 return a > b ? a : b;
            }
        };

        위의 상황을 람다식으로 표현하면?

★★    MyFunction f = (a,b) -> a > b ? a : b
       함수형 인터페이스명, 참조변수, 람다식 이 세 가지만 적어주면 끝 ㄷㄷ ★★★
         */
    }
}



