package ch14_Lambda_Stream;

//      이번엔 collect() 와 Collectors 에 대해 알아 보자.
//      reduce() 와 collect() 의 차이는,
//      reduce() 는 그냥 스트림 요소 전체를 리듀싱한다면, collect() 는 그룹별로 나눠서 reducing 이 가능하다는 점이다.
//      이 점 외에는 둘이 거의 같다.

//      메서드를 살펴보자.
//      Object collect(Collector collector)     // Collector 라는 인터페이스의 참조변수를 매개변수로 입력한다.
//      Object collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)  // 잘 안 쓰인다.
//
//
//      근데 저 Collector 인터페이스는 뭐지?
//      추상메서드명과 각각의 리턴 타입은 아래와 같다:

//      public interface Collector<T,A,R> {     // Stream 의 요소인 T 를 A 에 누적하고, 결과를 R 타입으로 변환한다.
//          Supplier<A>             supplier();         // 누적할 곳        StringBuilder::new
//          BiConsumer<A,T>         accumulator();      // 누적 방법        (sb, s) -> sb.append(s)
//          BinaryOperator<A>       combiner();         // 결합방법(병렬)    (sb1,sb2) -> sb1.append(sb2)
//          Function<A,R>           finisher();         // 최종변환         sb -> sb.toString()
//          Set<Characteristics>    characteristics();  // 컬렉터의 특성이 담긴 Set 을 리턴
//          ...
//      }
//      supplier() 는 누적해서 저장할 곳을 제공한다.
//      accumulator() 는 누적 방식을 정의하고,
//      combiner() 는 병렬 작업에서 각 쓰레드가 작업한 것을 합치는 메서드다.
//      finisher() 는 최종변환을 한다. T 요소를 A 에 계속 누적한 다음에 R로 변환하는 것.
//      타입을 바꿀 필요가 없으면 안 해도 된다.
//
//      저 5가지 중에 supplier 와 accumulator 가 핵심이다.
//
//      reduce() 랑 매우 비슷한 구조다. supplier 가 reduce 의 초기화 부분에 해당된다.
//
//
//
//
//      그럼 Collectors 는 뭘까? Collector 는 인터페이스였는데.
//      Collectors 는 클래스이고, Collector 인터페이스를 구현한 클래스이다.
//      Collector 는 인터페이스이기 때문에 추상 메서드만 갖고 있어서 구현을 직접 해야했는데,
//      Collectors 클래스는 메서드가 구현이 되어 있어서 그냥 import 만 하면 바로 사용할 수 있다.
//      사실 Collectors 에 웬만한 게 다 구현이 되어 있는 덕분에 우리가 직접 Collector 인터페이스를 구현할 일이 거의 없다.
//
//      Collectors 클래스는 다양한 기능의 컬렉터를 제공한다.
//      변환 - mapping(), toList(), toMap(), toCollection(), ...
//      통계 - counting(), summingInt(), averagingInt(), maxBy(), minBy(), summarizingInt(), ...
//      문자열 결합 - joining()
//      리듀싱 - reducing()
//      그룹화와 분할 - groupingBy(), partitioningBy(), collectingAndThen()
//
//      그러면 이제 이 Collectors 클래스를 이용하여 어떤 작업들을 할 수 있는지 알아 보자.
//      * 참고 Collectors 를 앞에 붙이는 게 귀찮으면
//      import static java.util.stream.Collectors.*; 하면 된다.
//      지금은 그냥 import 안 되었다고 가정하고 Collectors. 을 다 써주겠다.

//      1. 스트림을 컬렉션, 배열로 변환하기
//      (1) 스트림을 컬렉션으로 변환 - toList(), toSet(), toMap(), toCollection()
//
//      // Stream<Student> --> Stream<String> --> List<String> 으로 변환하는 과정 - Collectors.toList() 이용
//      List<String> names = stuStream.map(Student::getName)    // map 을 이용하여 Stream<String> 으로 변환
//                              .collect(Collectors.toList())   // collect 를 이용하여 List<String> 으로 변환
//

//      // List<String> --> ArrayList<String> 으로 변환하는 과정 - Collectors.toCollection(구현체::new) 이용
//      ArrayList<String> list = names.stream()
//                              .collect(Collectors.toCollection(ArrayList::new));
//
//
//      // Stream<Person> --> Map<String, Person> 으로 변환하는 과정 - Collectors.toMap(key, value) 이용
//      // Map<String, Person> map = personStream
//                              .collect(Collectors.toMap(person->person.getRegId(), person->person));
//
//
//
//
//      (2) 스트림을 배열로 변환 - toArray(배열타입::new)
//
//      Student[] stuNames = studentStream.toArray(Student::new);   // OK. 매개변수 있는 경우. ★많이 사용
//                                                (i) -> new Student[i] 메서드 참조를 람다식으로 바꿔봄. i는 배열의 길이
//
//      Student[] stuNames = studentStream.toArray();               // 에러 발생.
//      Object[] stuNames = studentStream.toArray();                // OK. 매개변수 없는 경우. Object[] 타입으로 리턴.
//      toArray() 는 자동형변환이 안 되기 때문에 매개변수를 입력해주지 않으려면 리턴 타입을 Object[] 로 해야 한다.
//      근데 세 번째 방식대로는 웬만하면 안 한다. 어차피 형변환 해줘야 하는데 첨부터 타입을 매개변수에 넣어주는 게 낫지...
//      Object 로 리턴받고 싶다 해도 (Object::new) 하면 그만이니까.
//
//
//
//
//      (3) 스트림의 통계 정보 얻기 - counting(), summingInt(), maxBy(), minBy(), ...
//      Collectors.counting()
//      long count = stuStream.count();                         // count() 는 스트림의 요소가 몇 개인지 리턴
//      long count = stuStream.collect(Collectors.counting());  // Collectors.counting() 은 스트림의 요소가
//                                                                 몇 개인지 리턴
//      count() 는 전체 스트림 카운트밖에 안 되는데, Collectors.counting() 은 그룹 별로 카운트 가능
//
//
//      Collectors.summingInt()
//      long totalScore = stuStream.mapToInt(Student::getTotalScore).sum();     // IntStream 의 sum()
//      long totalScore = stuStream.collect(Collectors.summingInt(Student::getTotalScore));
//
//      sum() 는 전체 스트림 카운트밖에 안 되는데, Collectors.summingInt() 은 그룹 별로 카운트 가능
//
//
//      Collectors.mayBy(비교기준)
//      OptionalInt topScore = stuStream
//                              .mapToInt(Student::getTotalScore)
//                              .max();
//
//      Optional<Student> topStudent = stuStream
//                              .max(Comparator.comparingInt(Student::getTotalScore));
//
//      Optional<Student> topStudent = stuStream
//                              .collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
//
//
//
//
//      (4) 스트림을 리듀싱 하기 - reducing()
//      하는 일이 reduce() 와 똑같다. 차이점은 그룹별 reducing 이 가능한가 아닌가의 차이다.
//      Collectors.reducing()

//      매개변수 1개인 경우
//      Collector reducing(BinaryOperator<T> op)
//                         accumulator 누적작업
//
//      매개변수 2개인 경우
//      Collector reducing(T identity, BinaryOperator<T> op)        <-- 대부분의 경우 이거 쓴다.
//                          초기값       accumulator 누적작업
//
//      매개변수 3개인 경우
//      Collector reducing(T identity, Function<T,U> mapper, BinaryOperator<U> op)
//                          초기값       누적 작업 전 변환작업     accumulator 누적작업
//
//
//      IntStream intStream = new Random().ints(1,46).distinct().limit(6);
//
//      OptionalInt         max = intStream.reduce(Integer::max);       // 전체 스트림 리듀싱
//      Optional<Integer>   max = intStream.boxed().collect(Collectors.reducing(Integer::max));    // 그룹 별 리듀싱
//
//      long sum = intStream.reduce(0, (a,b) -> a + b);
//      long sum = intStream.boxed().collect(Collectors.reducing(0, (a,b) -> a + b));
//
//      int grandTotal = stuStream.map(Student::getTotalScore).reduce(0, Integer::sum);
//      int grandTotal = stuStream.collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
//                                                          초기값,        변환작업            누적작업
//
//
//
//
//      (5) 문자열 스트림의 요소를 연결하기 - joining()
//      String studentNames = stuStream.map(Student::getName).collect(Collectors.joining());
//      map 을 이용하여 Student 스트림을 String 스트림으로 변환 / 변환한 String 들을 모두 이어줌.
//
//      String studentNames = stuStream.map(Student::getName).collect(Collectors.joining(",");
//      map 을 이용하여 Student 스트림을 String 스트림으로 변환 / 변환한 String 들을 중간중간 구분자를 넣고 이어줌.
//
//      String studentNames = stuStream.map(Student::getName).collect(Collectors.joining(",", "[", "]");
//      map 을 이용하여 Student 스트림을 String 스트림으로 변환 / String 사이에 구분자 , 를 넣고 최종결과물을 [ ] 로 감싸기
//
//      String studentInfo  = stuStream.colect(Collectors.joining(","));
//
//
//
//
//
//
//
//
//
//
//
//
//


public class _23_StreamOperator6 {
}
