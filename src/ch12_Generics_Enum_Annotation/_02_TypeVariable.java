package ch12_Generics_Enum_Annotation;
import java.util.*;

//
//      클래스를 작성할 때 Object 타입 대신 지네릭스 타입변수 E 를 선언해서 사용하는 것이다.
//      이렇게 타입 변수를 선언한 것들을 "지네릭스"라고 부른다. 지네릭 클래스도 있고 지네릭 메서드도 있다.

//      타입변수를 표시하는 방법은: <E> 이런 식으로 표시한다. 사실 E 말고 다른 알파벳을 써도 아무 상관 없다.
//      T로 써도 되고, X라고 써도 상관 없다. 다만 E가 좀 인기가 있다. E는 Element 를 줄인 말이다.
//      즉, Object 를 포함한 클래스는 모두 이 타입변수를 사용하여 지네릭 클래스를 사용한다.
//
//      근데 왜 타입"변수"라고 부를까? 왜냐하면 객체를 생성할 때 타입 변수 대신 실제 타입을 대입해야 하기 때문이다.
//
//      ArrayList<Tv> tvList = new ArrayList<Tv>();
//
//      이런 식으로 원래 E 가 있던 자리에 Tv 가 저장되는 것이라 생각하면 된다. 그래서 타입변수라고 부른다.
//      즉, E에 Tv 가 대입된 것이다. 원래 Tv 가 들어가기 전에는 Object 클래스였다.
//      이렇게 타입변수 대신 실제 타입이 저장되면, 그제서야 형변환이 생략 가능해지는 것이다.

class Tv {
}

class Audio {

}

public class _02_TypeVariable {
    public static void main(String[] args) {
        ArrayList<Tv> list = new ArrayList<Tv>(); // <-- 지네릭스로 Tv 저장
        // 이렇게 지네릭스 타입변수에 타입을 저장해서 컬렉션을 만든 순간부터 이 컬렉션 클래스의
        // 메서드들이 다 Tv 클래스에 맞게 내부적으로 만들어진다. 예를 들면 get 메서드의 경우 return 타입이
        // Tv 로 되는... 그렇게 내부적으로 다 만들어진다... ㄷㄷ 그렇게 내부적으로 다 만들어진 클래스를
        // "지네릭스 클래스(Generics Class)" 라고 부른다.

        list.add(new Tv());
//      list.add(new Audio()); // <-- 에러 발생

//      ArrayList<Object> list = new ArrayList<Tv>(); // <-- 이건 안 된다. 반드시 똑같아야 한다.
        // 부모-자손이니까 되야 하는 거 아닌가? 아니다. 지네릭스는 둘을 똑같이 적어줘야 한다.


//      ArrayList list = new ArrayList();
//      Tv t = (Tv)list.get(0); list 의 첫 번째 요소를 리턴하는 명령어.
//                              지네릭스를 안 썼으면 이렇게 형변환 해줬어야 함...

        Tv t = list.get(0);

    }
}
