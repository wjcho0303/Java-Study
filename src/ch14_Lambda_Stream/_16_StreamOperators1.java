package ch14_Lambda_Stream;

//      저번에는 스트림을 생성하는 방법에 대해 알아보았다.
//      이번에는 스트림의 연산에 대해 알아본다. 중간연산과 최종연산.
//
//      먼저, 어떤 것들이 있는지부터 보자.
//      중간 연산은 여러 번 가능하고, 최종연산은 스트림 요소를 소모하고 스트림을 닫아버린다.
//
//      중간연산 메서드들은 연산 결과 스트림을 리턴하도록 정의되어 있다. 그렇기 때문에 여러 번 가능한 것이다.
//      최종연산 메서드들은 입력은 당연히 스트림을 받고, 결과가 void 일수도 있고 다른 타입을 리턴할 수도 있다.
//
//
//      중간연산 메서드는 아래와 같은 것들이 있다:
//
//      Stream<T> distinct()                        중복을 제거한 Stream 리턴
//
//      Stream<T> filter(Predicate<T> p)            조건에 맞는 요소만 뽑아낸 Stream 리턴
//
//      Stream<T> limit(Long num)                   입력한 숫자만큼의 요소들만 뽑아 Stream 리턴
//
//      Stream<T> skip(Long num)                    입력한 숫자만큼의 요소들은 무시하고, 이후의 요소들만 뽑아 Stream 리턴
//
//      Stream<T> peek(Consumer<T> action)          요소에 입력한 람다식을 수행. 작업 중간에 잘 되었는지 확인할 때 자주 쓴다.
//
//      Stream<T> sorted()                          요소들을 오름차순으로 정렬
//      Stream<T> sorted(Comparator<T> comparator)  요소들을 입력한 정렬기준 comparator 를 적용하여 정렬

//      아래는 map() 과 flatMap() 이라는 메서드이다. 둘 다 "스트림의 요소를 변환"하는 작업을 수행한다.
//      사실 위에 것들은 이해하기 어렵지 않은데 map() 과 flatMap() 을 이해하려면 유의깊게 봐야 한다.
//      아래를 보면 mapper 라는 게 있는데, 저기에는 각 함수형 인터페이스에 해당하는 "람다식"이 들어간다.

//      Stream<R>       map(Function<T,R> mapper)
//      DoubleStream    mapToDouble(ToDoubleFunction<T> mapper)
//      IntStream       mapToInt(ToIntFunction<T> mapper)
//      LongStream      mapToLong(ToLongFunction<T> mapper)
//
//      Stream<R>       flatMap(Function<T,Stream<R>> mapper)
//      DoubleStream    flatMapToDouble(Function<T,DoubleStream> m)
//      IntStream       flatMapToInt(Function<T,IntStream> m)
//      LongStream      flatMapToLong(Function<T,LongStream> m)
//
//      자세한 내용은 다음 강의에서 살펴보겠다.
//
//
//
//
//      최종연산 메서드는 아래와 같은 것들이 있다:
//
//      void forEach(Consumer<? super T> action)            각 요소에 입력한 람다식을 수행
//      void forEachOrdered(Consumer<? super T> action)     병렬 스트림으로 처리할 때도 작업 순서를 유지시킬 때 사용
//
//      long count()                                        스트림의 요소가 몇 개인지 리턴
//
//      Optional<T> max(Comparator<? super T> comparator)   스트림 요소 중 최댓값을 리턴. 정렬기준을 줘야 함
//      Optional<T> min(Comparator<? super T> comparator)   스트림 요소 중 최솟값을 리턴. 정렬기준을 줘야 함
//
//      Optional<T> findAny()                               스트림 요소 중 아무거나 하나 리턴. 병렬에서 사용한다.
//      Optional<T> findFirst()                             스트림의 가장 첫 요소를 리턴. 직렬에서 사용한다.
//      이 둘은 그냥 사용되는 게 아니고 filter 와 같이 쓰인다. 조건에 맞는 것 아무거나 하나 뽑을 때, 혹은 조건을 맞는 애들 중
//      첫 번째 꺼롤 뽑을 때 filter 와 같이 사용한다.
//      Optional 은 래퍼클래스로, 어떤 타입의 값을 감싸고 있는 클래스이다. 작업 결과를 직접 주는 게 아니라
//      Optional 이라는 객체에 담아서 준다. 비어 있어도 객체에 담을 수 있기 때문에 사용한다.
//
//      boolean allMatch(Predicate<T> p)                    람다식 조건을 요소들이 모두 만족하는지 여부 확인
//      boolean anyMatch(Predicate<T> p)                    람다식 조건을 만족하는 요소가 존재하는지 여부 확인
//      boolean noneMatch(Predicate<T> p)                   람다식 조건을 요소들이 모두 피하는지 여부 확인
//
//      Object[] toArray()                                  모든 요소를 객체 배열로 리턴
//      A[] toArray(IntFunction<A[]> generator)             모든 요소를 객체 배열로 리턴. generator 를 주어
//                                                          특정 타입의 배열로 받을 수 있다.
//

//      reduce 하고 collect 이 두 메서드가 최종연산의 핵심이다.
//      Optional<T> reduce(BinaryOperator<T> accumulator)
//      T reduce(T identity, BinaryOperator<T> accumulator)
//      U reduce(U identity, BiFunction<U,T,U> accumulator, BinaryOperator<U> combiner)
//                                                          요소를 하나씩 줄여가면서(리듀싱하면서) 계산
//      R collect(Collector<T,A,R> collector)
//      R collect(Supplier<R> supplier, BiConsumer<R,T> accumulator, BiConsumer<R,R> combiner)
//                                                          스트림의 요소를 수집.
//      collect 는 주로 요소를 그룹화하거나 분할한 결과를 컬렉션에 담아 리턴하는 데 사용한다.
//
//
//      reduce 에 대한 이해를 돕기 위해, sum 을 예로 들어보자.
//      1, 2, 3, 4, 5 숫자 바구니가 있다고 하자.
//      sum 을 하면 5부터 하나씩 꺼내서 덧셈을 계속한다고 하자.
//      5 + 4 + 3 + 2 + 1
//      다 꺼내면 바구니에 더 이상 숫자가 남아 있지 않다. 이렇게 Stream 의 요소를 하나씩 줄여가면서 작업하는 것이
//      reduce 이다.
//


public class _16_StreamOperators1 {
}
