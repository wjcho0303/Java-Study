package ch14_Lambda_Stream;

//
//      스트림의 분할에 대해 알아보자:
//      partitioningBy(), groupingBy(). 둘 다 Collectors 클래스에 있다.
//      앞서 배운 collect() 가 바로 이 메서드들과 같이 쓰는 것이다.
//
//      partitioningBy() 는 스트림을 2분할 해준다. 2분할이라서 true 와 false 로 나누기 위해 Predicate 를 사용한다.
//      Collector partitioningBy(Predicate p)
//      Collector partitioningBy(Predicate p, Collector downstream)
//
//      2분할 예시
//      Map<Boolean, List<Student>> stuBySex = StuStream
//                          .collect(Collectors.partitioningBy(Student::isMale));
//      stuBySex 라는 Map 이 생기고,
//      그 Map 의 Key 는 true 와 false 로, Value 는 둘 다 List<Student> 로 두 가지의 Entry 를 갖게 된다.
//
//
//      List<Student> maleStudent = stuBySex.get(true);
//      true Key 에 해당하는 List<Student> Value 를 maleStudent 참조변수에 저장

//      List<Student> femaleStudent = stuBySex.get(false);
//      false Key 에 해당하는 List<Student> Value 를 femaleStudent 참조변수에 저장
//
//      결과적으로 아래와 같이 된다:
//      Key: true,      Value: List<Student>  - 남학생
//      Key: false,     Value: List<Student>  - 여학생
//
//
//      분할과 통계를 동시에 할 수도 있다.
//      Map<Boolean, Long> stuNumBySex = stuStream
//                          .collect(Collectors.partitioningBy(Student::isMale, Collectors.counting()));
//                                                  매개변수 2개:  Predicate(Key)       통계작업(Value)
//
//      System.out.println("남학생 수 : " + stuNumBySex.get(true));     // 8
//      System.out.println("여학생 수 : " + stuNumBySex.get(false));    // 10
//
//
//      Map<Boolean, Optional<Student>> topScoreBySex = stuStream
//           .collect(Collectors.partitioningBy(Student::isMale, Collectors.maxBy(comparingInt(Student::getScore))));
//                                  매개변수 2개:   Predicate(Key)                   통계작업(Value)
//
//      System.out.println("1등 남학생 : " + topScoreBySex.get(true));  // Optional[[홍길동, 남, 1, 1, 300]]
//      System.out.println("1등 여학생 : " + topScoreBySex.get(false)); // Optional[[심청이, 여, 1, 1, 300]]
//
//
//      partitioningBy() 를 두 번하면 4분할도 가능하다.
//      Map< Boolean, Map<Boolean,List<Student>> > failedStuBySex = stuStream
//      .collect(Collectors.partitioningBy(Student::isMale, Collectors.partitioningBy(s->s.getScore() < 150)));
//                    성별 분할(남학생/여학생)             성적으로 분할(불합격/합격)
//      첫 번째 partitioningBy 는 매개변수 2개, 두 번째 partitioningBy 는 매개변수 1개이다.

//      List<Student> failedMaleStu     = failedStuBySex.get(true).get(true);   남/불합격
//      List<Student> failedMaleStu     = failedStuBySex.get(true).get(false);  남/합격
//      List<Student> failedFemaleStu   = failedStuBySex.get(false).get(true);  여/불합격
//      List<Student> failedFemaleStu   = failedStuBySex.get(false).get(false); 여/합격
//
//      Map 의 Value 로 Map 을 넣은 것이다. Map 속의 Map ㄷㄷ
//
//

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;    // 이 import 를 통해 Collectors. 을 앞에 붙이는 것을 생략한다.
import static java.util.Comparator.*;

class Student2 {
    String name;
    boolean isMale; // 성별
    int hak;        // 학년
    int ban;        // 반
    int score;

    Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name	= name;
        this.isMale	= isMale;
        this.hak	= hak;
        this.ban	= ban;
        this.score  = score;
    }
    String	getName()    { return name;	}
    boolean  isMale()     { return isMale;	}
    int      getHak()     { return hak;	}
    int      getBan()     { return ban;	}
    int      getScore()   { return score;	}

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]",
                name, isMale ? "남":"여", hak, ban, score);
    }
    // groupingBy()에서 사용
    enum Level { HIGH, MID, LOW }  // 성적을 상, 중, 하 세 단계로 분류
}


public class _24_Partitioning {
    public static void main(String[] args) {
        Student2[] stuArr = {
                new Student2("나자바", true,  1, 1, 300),
                new Student2("김지미", false, 1, 1, 250),
                new Student2("김자바", true,  1, 1, 200),
                new Student2("이지미", false, 1, 2, 150),
                new Student2("남자바", true,  1, 2, 100),
                new Student2("안지미", false, 1, 2,  50),
                new Student2("황지미", false, 1, 3, 100),
                new Student2("강지미", false, 1, 3, 150),
                new Student2("이자바", true,  1, 3, 200),
                new Student2("나자바", true,  2, 1, 300),
                new Student2("김지미", false, 2, 1, 250),
                new Student2("김자바", true,  2, 1, 200),
                new Student2("이지미", false, 2, 2, 150),
                new Student2("남자바", true,  2, 2, 100),
                new Student2("안지미", false, 2, 2,  50),
                new Student2("황지미", false, 2, 3, 100),
                new Student2("강지미", false, 2, 3, 150),
                new Student2("이자바", true,  2, 3, 200)
        };

        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<Student2>> stuBySex =  Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale));

        List<Student2> maleStudent   = stuBySex.get(true);
        List<Student2> femaleStudent = stuBySex.get(false);

        for(Student2 s : maleStudent)   System.out.println(s);
        for(Student2 s : femaleStudent) System.out.println(s);



        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student2::isMale, counting()));

        System.out.println("남학생 수 :"+ stuNumBySex.get(true));
        System.out.println("여학생 수 :"+ stuNumBySex.get(false));



        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<Student2>> topScoreBySex = Stream.of(stuArr)  // Value 가 Optional<T>
                .collect(partitioningBy(Student2::isMale,
                        maxBy(comparingInt(Student2::getScore))
                ));
        System.out.println("남학생 1등 :"+ topScoreBySex.get(true));
        System.out.println("여학생 1등 :"+ topScoreBySex.get(false));

        Map<Boolean, Student2> topScoreBySex2 = Stream.of(stuArr)       // Value 가 Student2
                .collect(partitioningBy(Student2::isMale,
                        collectingAndThen(  // collectingAndThen 은 collecting 을 진행한 후 그 결과로 메서드를
                                            // 하나 더 호출할 수 있게 해준다. Optional::get 부분이 해당된다.
                                maxBy(comparingInt(Student2::getScore)), Optional::get
                        )       // Optional::get 을 통해 Optional<Student2> 래퍼클래스에서 내용을 꺼낸다.
                ));

        System.out.println("남학생 1등 :"+ topScoreBySex2.get(true));
        System.out.println("여학생 1등 :"+ topScoreBySex2.get(false));



        System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");

        Map<Boolean, Map<Boolean, List<Student2>>> failedStuBySex =
                Stream.of(stuArr).collect(partitioningBy(Student2::isMale,  // 첫 번째 분핧
                        partitioningBy(s -> s.getScore() <= 100))           // 두 번째 분할. 총 4분할된다.
                );
        List<Student2> failedMaleStu   = failedStuBySex.get(true).get(true);
        List<Student2> failedFemaleStu = failedStuBySex.get(false).get(true);

        for(Student2 s : failedMaleStu)   System.out.println(s);
        for(Student2 s : failedFemaleStu) System.out.println(s);
    }
}
