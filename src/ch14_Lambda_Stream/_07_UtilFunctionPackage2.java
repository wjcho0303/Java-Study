package ch14_Lambda_Stream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class _07_UtilFunctionPackage2 {
    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        // Function<Integer, Integer> f = i -> (i / 10) * 10;
        // list 는 1~100 까지의 난수 열 개를 갖고 있는 List<Integer> 임
        List<T> newList = new ArrayList<T>(list.size());
        for (T i : list) {
            newList.add(f.apply(i));
            // f.apply(i) 를 통해 list 에 있는 요소들을 Function 의 매개변수로 집어넣고
            // 리턴한 결과들을 newList 에 넣는다.
        }
        return newList; // Function 을 거쳐서 일의자리가 0이 되어 나온 i 들이 담긴 newList 를 최종적으로 리턴함
    }
    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for(T i : list) {
            if(p.test(i)) {     // Predicate<Integer> p = i -> i % 2 == 0;
                c.accept(i);    // Consumer<Integer> c = i -> System.out.print(i + ", ");
            }
            // list 에 있는 요소들을 검사하면서 짝수면 출력하고 짝수가 아니면 출력하지 않음
        }
        System.out.println("]");
    }
    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());          // Supplier<Integer> s = () -> (int)(Math.random()*100) + 1;
        }                               // 난수를 제공
    }




    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random()*100) + 1; // 1부터 100까지의 난수 Integer 를 리턴하는 Supplier
        Consumer<Integer> c = i -> System.out.print(i + ", "); // Integer i 를 매개변수로 받아서 출력하는 Consumer
        Predicate<Integer> p = i -> i % 2 == 0; // Integer i 가 짝수인지 여부를 확인해주는 Predicate
        Function<Integer, Integer> f = i -> (i / 10) * 10; // Integer i 의 1의 자리를 0 으로 바꾼 Integer 를 리턴

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);    // 람다식 s 로부터 1~100의 난수를 받아서 list 에 10번 추가
        System.out.println(list);   // list 출력
        printEvenNum(p, c, list);   // list 중에서 짝수인지 검사하고 열거
        List<Integer> newList = doSomething(f, list); // 1의 자리 숫자 제거
        System.out.println(newList);
    }
}
