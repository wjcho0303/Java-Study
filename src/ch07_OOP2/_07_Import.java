package ch07_OOP2;

//  Package : 서로 관련된 클래스들을 묶어 놓은 것. 폴더 또는 디렉토리 개념이라고 생각하면 된다.
//  package 문은 해당 클래스 파일이 어느 패키지에 속해 있는지 표시해줄 때 사용하며, 일반적으로 IDE 가 자동으로 작성해준다.
//
//  모든 클래스(.class)는 패키지에 속해 있어야 하며, 클래스의 이름은 패키지명까지 포함한 이름이어야 한다.
//  예를 들면 String 클래스도 사실은 java.lang.String 이 실제 클래스명이다.
//
//  rt.jar 파일은 클래스들을 압축한 압축파일이며, JDK 설치경로\jre\lib 에 위치한다. 여기서 rt 란 runtime 을 줄여쓴 것이며,
//  자바 프로그램이 실행하는 데 필요한 .class 파일들을 묶어 놓은 것이 이 jar 파일이다.
//  그러나 Java 9 부터 module 개념이 추가되면서 rt.jar 파일이 없어졌다.
//  참고로, .jar 파일은 jar.exe 라는 프로그램으로 압축을 해제할 수 있다.
//
//  만약 위와 같이 package ch07_OOP2; 이렇게 패키지문을 선언하는 코드가 없으면 이름없는 패키지에 속하게 된다.
//  이러한 이름없는 패키지를 default package 라고 한다.
//
//  커맨드 창으로 클래스 파일을 실행시키는 방법:
//  1) 실행시키고자 하는 클래스파일이 있는 패키지의 상위 폴더로 이동 (cd 명령어)
//  2) java 패키지명.클래스명
//
//  만약 환경변수 '시스템 변수'에 classpath 를 추가하여 설정해주면 커맨드 창에서도 편리하게 실행시킬 수 있다.
//  classpath 에 패키지 루트를 등록해주면 커맨드 창에서 실행할 때 만약 현재 디렉토리에서 실행할 파일을 찾지 못할 경우
//  그 후에는 시스템이 classpath 에 등록된 디렉토리에서 실행을 시도하게 된다. 커스텀 지름길 같은 개념이다.
//  즉, classpath 는 cd 명령어를 통해 해당 .class 파일이 있는 위치로 이동하지 않고도
//  원격에서 .class 파일을 실행시킬 수 있도록 설정해주는 환경변수다.
//  만약 classpath 를 여러 개 등록하고 싶다면 변수 이름을 새로 만들 필요는 없고,
//  변수 값에 세미콜론(;) 구분자를 통해 여러 개 등록하면 된다.

//  만약 classpath 에 .jar 파일을 등록하면 해당 압축파일 내부를 서치한다.


import java.util.UUID;

public class _07_Import {
    public static void main(String[] args) {
        // import 문은 클래스를 호출할 때 패키지명을 생략할 수 있게 해준다.
        // 만약 import 문을 적지 않는다면 외부의 클래스를 가져와서 쓸 때마다 그 클래스명 앞에 그 클래스의 패키지명까지 붙여서 써야 한다.


        // 예를 들면, java.util.Date 클래스를 사용할 때 원래는 다음과 같이 해야 한다:
        java.util.Date today = new java.util.Date();
        System.out.println("today = " + today);         // today = Wed Apr 17 10:23:26 KST 2024


        // 하지만 import 문을 사용하면 호출할 클래스의 패키지명까지 다 붙여주지 않아도 사용할 수 있게 된다.
        // 위에 import java.util.UUID;  라는 import 문이 적혀 있다.
        UUID uuidtest = UUID.randomUUID();              // java.util.UUID uuid test = java.util.UUID.randomUUID();
        System.out.println("uuidtest = " + uuidtest);   // uuidtest = 988cad94-16b1-4014-a0bd-0799c2ac8112


        // 예외적으로, java.lang 패키지의 경우는 import 하지 않고 사용할 수 있게 되어 있다.
        // java.lang 패키지의 클래스들은 Java 언어의 가장 기본 패키지이고, 핵심 클래스들을 넣어 놓은 것이기 때문에
        // import 문을 사용하지 않고도 패키지명을 생략할 수 있게 해놓았다.
        // 즉, 다음의 코드가 자동으로 수행된다는 것이다:   import java.lang.*;
        // java.lang 패키지의 클래스는 다음의 것들이 포함된다: String, Object, System, Thread 등


        // import 문의 위치는 package 문과 class 선언 "사이"에 와야 한다.


        // import 문은 컴파일 시에 처리되므로 프로그램의 성능에 영향을 주지 않는다.
        // import 문에 * 을 찍어서 모든 클래스를 import 하면 프로그램의 성능에 영향이 가지 않을까 걱정하지 않아도 된다.
        // 사실 성능의 문제가 아니라 '어떤 클래스들이 사용되었는가를 알 수 있는가'와 '편리한가'의 경쟁이라 보면 된다.
        // 다만 오해해서는 안 되는 것은 * 은 모든 클래스를 의미하는 것이며, 하위 패키지까지 포함하지 않는다는 것이다.
        // 즉, java.* 이렇게 적는다고 해서 java.util.* 이 적용받는 것이 아니다. 이 점을 유의해야 한다.


        // import static 문에 대해서도 알아보자. import static 은 메서드에 대한 import 이다.
        // import static java.lang.System.out; 이런 식으로 import static 을 통해 특정 메서드를 import 할 수 있다.
        // 이렇게 하면 out.println("내용"); 이렇게 앞에 특정 메서드를 사용할 때 클래스명을 생략하고 싶을 때 사용하면 된다.

        // 다른 예시를 보자:
        // import static java.lang.Math.random; 이렇게 하면 Math.random() 메서드를 random() 이렇게만 써도 된다.
        // random(); 이렇게만 써주면 Math.random(); 이라고 쓴 것과 똑같다. Math. 을 생략한 것이다.
        // 특정 메서드를 자주 사용해야 하는데 클래스 이름을 붙이게 되면 코드가 복잡해지는 경우
        // 이러한 import static 문을 활용하면 코드가 간결해져서 유용하다.
    }
}
