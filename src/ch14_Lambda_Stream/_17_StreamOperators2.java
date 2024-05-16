package ch14_Lambda_Stream;

//
//      이번엔 앞서 언급했던 중간연산에 대해 조금씩 자세히 살펴보자.
//      Stream<T> limit(Long num)                   입력한 숫자만큼의 요소들만 뽑아 Stream 리턴
//      Stream<T> skip(Long num)                    입력한 숫자만큼의 요소들은 무시하고, 이후의 요소들만 뽑아 Stream 리턴
//
//      이 두 중간연산 메서드는 스트림을 자르는 기능을 한다.
//      limit 은 뒤의 요소를 잘라내버리고, skip 은 앞의 요소를 잘라낸다고 생각하면 쉽다.
//
//      이 외에도 rangeClosed(Long num1, Long num2) 라는 메서드도 있다.
//      유의할 점은 보통 index 범위를 얘기할 때 num2 는 포함되지 않았는데 rangeClosed 의 경우엔 num2 도 포함시킨다.
//
//      IntStream intStream = IntStream.rangeClosed(1, 10); // 스트림 요소: 12345678910
//      intStream.skip(3).limit(5).forEach(System.out::print);  // 출력결과: 45678
//



//      이번엔 스트림 요소를 걸러내는 중간연산에 대해 알아보자.
//      Stream<T> distinct()                        중복을 제거한 Stream 리턴
//      Stream<T> filter(Predicate<T> p)            조건에 맞는 요소만 뽑아낸 Stream 리턴
//
//      IntStream intStream = IntStream.of(1,2,2,3,3,3,4,5,5,6);
//      intStream.distinct().forEach(System.out::print);    // 결과: 123456
//
//      IntStream intStream = IntStream.rangeClosed(1,10); 12345678910
//      intStream.filter(i->i%2==0).forEach(System.out::print);    // 결과: 246810
//
//      intStream = IntStream.rangeClosed(1,10); 12345678910
//      intStream.filter(i-> (i%2 != 0) && (i%3 != 0)).forEach(System.out::print);    // 결과: 157
//
//      intStream = IntStream.rangeClosed(1,10); 12345678910
//      intStream.filter(i->i%2!=0).filter(i->i%3!=0).forEach(System.out::print);    // 결과: 157
//                      13579              157
//      AND 조건으로 써도 되고, filter 를 위와 같이 두 번 써는 것이 AND 조건과 똑같다.
//
//
//
//
//      이번엔 스트림 요소를 정렬하는 중간연산에 대해 알아보자.
//      정렬할 때 필요한 게 무엇이었나.  1. 정렬 대상        2. 정렬 기준
//
//      strStream.sorted()                                                  기본정렬
//      strStream.sorted(Comparator.naturalOrder())                         기본정렬
//      strStream.sorted((s1,s2)->s1.compareTo(s2))                         람다식도 가능
//      strStream.sorted(String::compareTo)                                 위 람다식의 메서드 참조 버전
//      위 네 가지의 결과는 모두 다음과 같음: CCaaabccdd
//      Comparator 클래스에 이미 naturalOrder 라는 게 기본정렬로 정의 되어 있음
//

//      strStream.sorted(Comparator.reverseOrder())                         기본정렬의 역순
//      strStream.sorted(Comparator.<String>naturalOrder().reversed())
//      위 두 가지의 결과는 모두 다음과 같음: ddccbaaaCC
//      마찬가지로 .reversed 도 Comparator 클래스에 정의된 메서드임.
//

//      strStream.sorted(String.CASE_INSENSITIVE_ORDER)                      대소문자 구분 안 함
//      결과: aaabCCccdd
//      CASE_INSENSITIVE_ORDER 도 comparator, 즉 정렬 기준이다.

//      strStream.sorted(String.CASE_INSENSITIVE_ORDER.reversed())           대소문자 구분 안 하고 역순
//      결과: ddCCccbaaa <-- 유의할 점은 이번에도 대문자가 먼저 나왔다는 것이다.

//      strStream.sorted(Comparator.comparing(String::length))               문자열의 길이 순으로 정렬
//      결과: bddCCccaaa  b는 1개, d는 2개, CC 2개, cc 2개, aaa 3개

//      strStream.sorted(Comparator.comparingInt(String::length))            오토박싱 없음
//      결과: bddCCccaaa  b는 1개, d는 2개, CC 2개, cc 2개, aaa 3개

//      strStream.sorted(Comparator.comparing(String::length).reversed())    위에꺼의 역순
//      결과: aaaddCCccb
//
//
//      위와 같이, 스트림에서 정렬 기준은 Comparator 의 comparing() 메서드
//      즉, Comparator.comparing() 이라는 메서드를 이용한다.
//      studentStream.sorted(Comparator.comparing(Student::getBan))
//              .forEach(System.out::println);

//      그리고, 정렬 기준이 더 필요할 때, 즉 정렬 기준을 여러 개 두어야 할 때는 thenComparing() 을 사용한다.
//      studentStream.sorted(Comparator.comparing(Student::getBan))     // 반 별로 정렬
//              .thenComparing(Student::getTotalScore)                  // 총점 별로 정렬
//              .thenComparing(Student::getName)                        // 이름 별로 정렬
//              .forEach(System.out::println);
//

import java.util.*;
import java.util.stream.*;

class Student implements Comparable<Student> {
    // Student 에 Comparable 인터페이스를 구현시켜서 compareTo() 메서드 구현 (맨 아래 있음)
    String name;
    int ban;
    int totalScore;
    Student(String name, int ban, int totalScore) {
        this.name =name;
        this.ban =ban;
        this.totalScore =totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    String getName()     { return name;}
    int getBan()         { return ban;}
    int getTotalScore()  { return totalScore;}

    // 총점 내림차순을 기본 정렬로 한다.
    public int compareTo(Student s) {   // 총점이 높은 것부터 낮은 것 순서로 정렬되도록 함
        return s.totalScore - this.totalScore;
    }
}

public class _17_StreamOperators2 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(  // Student 객체 배열로 Stream 을 생성.
                                                    // of() 메서드를 통해 요소를 직접 입력.
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan)      // 반별 정렬
//              .reversed()
                // 만약 위의 이 코드를 주석처리 하면 위에서 정의한 기본정렬을 따른다.
                .thenComparing(Comparator.naturalOrder()))     	        // 기본 정렬(점수 내림차순)
//              .reversed()
                .forEach(System.out::println);
    }
}       // Student 클래스에 정의해놓은 기본정렬이 점수 내림차순이므로, 반 별로 정렬한 후, 그 상태에서
        // 점수가 높은 사람부터 정렬된다.
        // 정렬을 반전 시키고 싶을 땐 뒤에 .reversed() 를 붙여주면 된다. (차이를 보고 싶으면 주석풀고 테스트 해보기)
