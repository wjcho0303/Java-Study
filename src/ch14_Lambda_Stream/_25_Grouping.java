package ch14_Lambda_Stream;
//
//
//      groupingBy() 는 스트림을 n분할 해준다.
//
//      메서드는 이렇게 생겼구나 대략적으로 보고, 사용법을 먼저 익혀보도록 하자.
//      Collector groupingBy(Function classifier)
//      Collector groupingBy(Function classifier, Collector downstream)
//      Collector groupingBy(Function classifier, Supplier mapFactory, Collector downstream)
//
//      Student 스트림을 반 별로 그룹화하는 코드
//      Map<Integer, List<Student>> stuByBan = stuStream
//                      .collect(groupingBy(Student::getBan, toList()));
//                                           classifier      downstream
//
//      사용 패턴은 partitioningBy 와 똑같다. partitioningBy 는 classifier 로 predicate 을 줘서
//      항상 Key 가 true 와 false 로 2분할 되었던 거고, 지금 groupingBy 의 경우에는 classifier 를 predicate 외의
//      다른 람다식이라서, 그 classifier 를 통해 나온 결과들의 갯수대로 n 분할 되는 것이다.
//      예를 들어 Student::getBan 에서, 반이 예를 들어 6반까지 있다 하면 6분할 되는 것이다.
//      뒤에 적은 toList() 를 통해 각 반 (1~6반) Key 에 대한 Value 로 toList() 가 만들어져 해당되는 데이터들이
//      들어가는 것이다.
//
//      만들어진 Map 의 Key-Value 구조는 아래와 같다:

//          Key                                     Value
//          1          List<Student>   (인스턴스 변수 int ban 의 값이 1인 Student 들)
//          2          List<Student>   (인스턴스 변수 int ban 의 값이 2인 Student 들)
//          3          List<Student>   (인스턴스 변수 int ban 의 값이 3인 Student 들)
//          4          List<Student>   (인스턴스 변수 int ban 의 값이 4인 Student 들)
//          5          List<Student>   (인스턴스 변수 int ban 의 값이 5인 Student 들)
//          6          List<Student>   (인스턴스 변수 int ban 의 값이 6인 Student 들)
//
//
//      그리고 partitioningBy 와 마찬가지로 다중그룹화도 가능하다.
//      Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan = stuStream
//              .collect(groupingBy(Student::getHak, groupingBy(Student::getBan)));
//
//      위 다중그룹화는 학년 별로 그룹화를 먼저 한 후 학년마다 추가로 반 별로 그룹화하였다.
//      예를 들어 학년이 1~3학년 있고, 1학년은 5반까지, 2학년은 5반까지, 3학년은 6반까지 있다고 하자.
//      그러면 총 5+5+6 = 16 개의 반에 대해 그룹화가 이루어지는 것이다.
//
//
//          Key                                         Value
//          1           Key             Value
//                      1           List<Student>      hak: 1, ban: 1 값을 가진 Student List
//                      2           List<Student>      hak: 1, ban: 2 값을 가진 Student List
//                      3           List<Student>      hak: 1, ban: 3 값을 가진 Student List
//                      4           List<Student>      hak: 1, ban: 4 값을 가진 Student List
//                      5           List<Student>      hak: 1, ban: 5 값을 가진 Student List
//
//          2           Key             Value
//                      1           List<Student>      hak: 2, ban: 1 값을 가진 Student List
//                      2           List<Student>      hak: 2, ban: 2 값을 가진 Student List
//                      3           List<Student>      hak: 2, ban: 3 값을 가진 Student List
//                      4           List<Student>      hak: 2, ban: 4 값을 가진 Student List
//                      5           List<Student>      hak: 2, ban: 5 값을 가진 Student List
//
//          3           Key             Value
//                      1           List<Student>      hak: 3, ban: 1 값을 가진 Student List
//                      2           List<Student>      hak: 3, ban: 2 값을 가진 Student List
//                      3           List<Student>      hak: 3, ban: 3 값을 가진 Student List
//                      4           List<Student>      hak: 3, ban: 4 값을 가진 Student List
//                      5           List<Student>      hak: 3, ban: 5 값을 가진 Student List
//                      6           List<Student>      hak: 3, ban: 6 값을 가진 Student List
//
//          위와 같이 Map 안에 Map 이 들어가는 구조가 되었다.
//
//          위 다중그룹화를 한 단계만 더 나아간다면 원하는 데이터를 걸러낼 수 있다.
//          Map<Integer, Map<Integer, Set<Student.Level>>> stuByHakAndBanByScore = stuStream
//                  .collect(groupingBy(Student::getHak, groupingBy(Student::getBan,     // 여기까진 위의 코드와 비슷
//                      mapping(s->{        //
//                          if (s.getScore() >= 200) return Student.Level.HIGH;
//                          else if (s.getScore() >= 100) return Student.Level.MID;
//                          else return Student.Level.LOW;},
//                          toSet()
//                      )
//                  )));
//
//          다중그룹화는 위와 비슷하게 두 번만 진행했다. 다중그룹화 세 번부터는 좀 힘들다...
//          다중그룹화를 하는 과정에서, 두 번째 그룹화의 downstream 매개변수에 mapping 을 통해
//          Set 에 들어갈 Student 들에 대한 조건을 걸었다.
//          이 사례에선 자료를 걸러내려는 용도로 조건을 건 것은 아니고, 그냥 점수에 따라 세 가지 종류의
//          Level enum 딱지(HIGH, MID, LOW)를 붙여서 자료를 변환하는 mapping 이다.
//          즉, List<Student> 를 Set<Student.Level> 로 변환하는 코드다.

//          * 참고
//          Student.Level.HIGH 란, Student class 안에 있는 Level 이라는 enum 의 HIGH 라는 값을 부여한다는 의미이다.
//          class Student {
//              ...
//              enum Level {HIGH, MID, LOW}
//              ...
//          }
//



import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;    // Collectors 를 미리 import static 하여 입력 생략할 수 있게 함
                                                // 안 그러면 코드가 너무 길어짐...
import static java.util.Comparator.*;

class Student3 {
    String name;
    boolean isMale; // 성별
    int hak;        // 학년
    int ban;        // 반
    int score;

    Student3(String name, boolean isMale, int hak, int ban, int score) {
        this.name	= name;
        this.isMale	= isMale;
        this.hak   	= hak;
        this.ban	= ban;
        this.score 	= score;
    }

    String	getName() 	 { return name;    }
    boolean isMale()  	 { return isMale;  }
    int		getHak()   	 { return hak;	   }
    int		getBan()  	 { return ban;	   }
    int		getScore()	 { return score;   }

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
    }

    enum Level {
        HIGH, MID, LOW
    }
}

public class _25_Grouping {
    public static void main(String[] args) {
        Student3[] stuArr = {
                // 학생들의 데이터는 Partitioning 학습 자료와 동일함. 학년은 1, 2 / 반은 1,2,3
                new Student3("나자바", true,  1, 1, 300),
                new Student3("김지미", false, 1, 1, 250),
                new Student3("김자바", true,  1, 1, 200),
                new Student3("이지미", false, 1, 2, 150),
                new Student3("남자바", true,  1, 2, 100),
                new Student3("안지미", false, 1, 2,  50),
                new Student3("황지미", false, 1, 3, 100),
                new Student3("강지미", false, 1, 3, 150),
                new Student3("이자바", true,  1, 3, 200),
                new Student3("나자바", true,  2, 1, 300),
                new Student3("김지미", false, 2, 1, 250),
                new Student3("김자바", true,  2, 1, 200),
                new Student3("이지미", false, 2, 2, 150),
                new Student3("남자바", true,  2, 2, 100),
                new Student3("안지미", false, 2, 2,  50),
                new Student3("황지미", false, 2, 3, 100),
                new Student3("강지미", false, 2, 3, 150),
                new Student3("이자바", true,  2, 3, 200)
        };

        System.out.printf("1. 단순그룹화(반별로 그룹화)%n");   // groupingBy 한 번 사용
        Map<Integer, List<Student3>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(Student3::getBan));

        for(List<Student3> ban : stuByBan.values()) {      // 단순 출력을 위한 코드
            for(Student3 s : ban) {
                System.out.println(s);
            }
        }

        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");    // groupingBy 한 번,
        Map<Student3.Level, List<Student3>> stuByLevel = Stream.of(stuArr)  // Key 가 Level 이 되도록 함
                .collect(groupingBy(s-> {   // HIGH, MID, LOW 세 가지 Key 로 그룹화
                    if(s.getScore() >= 200) return Student3.Level.HIGH;
                    else if(s.getScore() >= 100) return Student3.Level.MID;
                    else                         return Student3.Level.LOW;
                }));

        // keySet() 이라는 Map 인터페이스의 메서드를 이용: Set keySet() - Map 에 저장된 모든 Key 들을 Set 에 담아 리턴
        TreeSet<Student3.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        // 위에서 만든 Set 은 어차피 Value 는 없고 Key 밖에 없다. 그냥 제목으로 활용하려고 만든 것이다.
        // 그 대신, 아래와 같이 이중반복문을 통해 Key 별로 Value 를 나열할 수 있게 하였다 :

        // 외부반복문 3회: : HIGH, MID, LOW 를 각 회차에 출력함
        for(Student3.Level key : keySet) {
            System.out.println("["+key+"]");

            // 내부반복문 : Map 이름.get(key) 메서드를 사용하여 해당 Key 가 가진 Value 를 리턴함
            for(Student3 s : stuByLevel.get(key))
                System.out.println(s);
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
        Map<Student3.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s-> {
                    if(s.getScore() >= 200) return Student3.Level.HIGH;
                    else if(s.getScore() >= 100) return Student3.Level.MID;
                    else                         return Student3.Level.LOW;
                }, counting()));        // collect 메서드의 두 번째 매개변수. Key 별 Value 에 요소의 개수를 입력

        for(Student3.Level key : stuCntByLevel.keySet())
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        System.out.println();
/*
		for(List<Student3> level : stuByLevel.values()) {
			System.out.println();
			for(Student3 s : level) {
				System.out.println(s);
			}
		}
*/
        System.out.printf("%n4. 다중그룹화(학년별, 반별)");
        Map<Integer, Map<Integer, List<Student3>>> stuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(Student3::getHak,       // 학년 별로 나눈 걸 또 다시 반 별로 나눔
                                groupingBy(Student3::getBan)
                        ));

//      * 참고:
//      Collection values()      입력해준 Collection 타입에 저장된 모든 value 들을 담아서 리턴
//      ex) List values(), Set values(), ...

        for(Map<Integer, List<Student3>> hak : stuByHakAndBan.values()) {
            for(List<Student3> ban : hak.values()) {
                System.out.println();
                for(Student3 s : ban)
                    System.out.println(s);
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student3>> topStuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(Student3::getHak,
                                groupingBy(Student3::getBan,
                                        collectingAndThen(
                                                maxBy(comparingInt(Student3::getScore))
                                                , Optional::get
                                        )
                                )
                        ));

        for(Map<Integer, Student3> ban : topStuByHakAndBan.values())
            for(Student3 s : ban.values())
                System.out.println(s);

        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
        Map<String, Set<Student3.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s-> s.getHak() + "-" + s.getBan(),
                        mapping(s-> {
                            if(s.getScore() >= 200) return Student3.Level.HIGH;
                            else if(s.getScore() >= 100) return Student3.Level.MID;
                            else                    return Student3.Level.LOW;
                        } , toSet())
                ));

        Set<String> keySet2 = stuByScoreGroup.keySet();

        for(String key : keySet2) {
            System.out.println("["+key+"]" + stuByScoreGroup.get(key));
        }
    }
}
