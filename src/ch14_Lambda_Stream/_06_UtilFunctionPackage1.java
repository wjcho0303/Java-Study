package ch14_Lambda_Stream;


//      java.util.function 패키지는 자주 사용되는 다양한 "함수형 인터페이스"를 제공한다.
//      대표적인 게 java.lang.Runnable 이고,
//      그 외에도 Supplier<T>, Consumer<T>, Function<T>, Predicate<T> 등이 있다.

//      이렇게 자바에서 제공되는 함수형 인터페이스들을 사용하면 개발자가 달라고 동일한 방식으로 사용하니
//      다른 사람이 작업한 것이라도 쉽게 이해할 수 있다.
//      함수형 인터페이스는 단 하나의 추상 메서드만 가지니까 각 인터페이스마다
//      보유한 메서드 딱 한 개만 외워도 되니 학습하기도 어렵지 않고 편하다.

//      다섯 가지만 살펴보도록 하자.

//      함수형 인터페이스 이름      보유한 메서드와 그 반환 타입
//      java.lang.Runnable           void run()              매개변수 입력도 안 하고 리턴도 안 함
//
//      Supplier<T>                  T get()                 매개변수 입력은 안 하고 값을 리턴만 함(제공만 함)
//
//      Consumer<T>                  void accept(T t)        매개변수를 받고 리턴은 안 함(소비만 함)
//
//      Function<T, R>               R apply(T t)            매개변수 T 타입을 받고(소비도 하고) R 타입 리턴함(제공도 함)
//
//      Predicate<T>                 boolean test(T t)       매개변수를 받고 boolean 으로 리턴함
//                                                           ★ T 에는 보통 람다식이 저장된 변수를 입력한다. ★
//                                                           사실 생각해보면 Predicate 은 Function 인 셈이다.
//                                                           Function<T, Boolean> 이런... 근데 항상 Boolean 리턴이라
//                                                           그냥 매개변수의 타입만 입력하는 것이다.
//      예시)
//      Predicate<String> isEmptyStr = s -> s.length() == 0;   // s 를 입력하면 s 의 길이가 0인지 여부를 확인하라.
//      Predicate<타입> 참조변수 = 람다식;

//      String str1 = "";  // str1 을 빈 문자열로 정의해볼까?
//      if(isEmptyStr.test(str1)) System.out.println("This is an empty String.");

//      if(참조변수.test(테스트 대상)) {
//          ...
//      }


//
//      위에서 살펴본 것들은 함수형 인터페이스에 매개변수를 한 개 넣는 경우였다.
//      매개변수를 두 개 넣은 경우는 어떻게 될까?
//
//      함수형 인터페이스 이름      보유한 메서드와 그 반환 타입
//      BiConsumer<T, U>           void accept(T t, U u)        매개변수를 두 개 받고 리턴은 안 함
//
//      BiPredicate<T, U>          boolean test(T t, U u)       매개변수를 두 개 받고 리턴은 Boolean
//
//      BiFunction<T, U, R>        R apply(T t, U u)            매개변수 두 개 받고 리턴은 한 종류
//
//      리턴을 두 개 할 수는 없으므로 BiSupplier 라는 것은 존재하지 않음
//
//
//      매개변수 3개 이상부터는 직접 만들어서 써야 한다. 아래처럼 말이다:
          @FunctionalInterface
          interface TriFunction<T, U, V, R> {
              R apply(T t, U u, V v);
          }
//
//      한 개나 두 개인 경우가 많아서 거기까지는 제공해주는데, 그 이상부터는 알아서 만들어 쓰라는 거다.
//      그 대신, 매개변수가 하나나 두 개인 경우엔 따로 만들지 말고 제공되는 걸 쓰는 게 좋다.
//
//
//
//      매개변수의 타입과 리턴 타입이 동일한 경우인 함수형 인터페이스는 어떤 것이 있을까?
//
//      함수형 인터페이스 이름      보유한 메서드와 그 반환 타입
//      UnaryOperator<T>          T apply(T t)              Function 의 자손이다.
//
//      BinaryOperator<T>         T apply(T t, T t)         BiFunction 의 자손이다.
//
//
//      UnaryOperator 는 "단항 연산자"라고 부르고, BinaryOperator 는 "이항 연산자" 라고 부른다.
//      Operator 라는 말이 붙은 것은 입력과 리턴의 타입이 똑같기 때문에 "연산"을 한 것이나 다름없다고 하여 저렇게 부른다.
//


public class _06_UtilFunctionPackage1 {
}
