package ch09_UsefulPackages;

// Object 클래스의 메서드는 다음과 같다:
//
// protected Object clone()             객체 자신의 복사본을 반환
//
// public boolean equals(Object obj)    객체 자신과 같은 객체인지 여부 확인
//
// protected void finalize()            객체가 소멸될 때 GC에 의해 자동으로 호출.
//                                      이때 수행되어야 하는 코드가 있다면 오버라이딩 한다. (거의 사용 안 함)
//
// public Class getClass()              객체 자신의 클래스 정보를 담고 있는 Class 인스턴스를 반환
//
// public int hashCode()                객체 자신의 해시 코드를 반환
//
// public String toString()             객체 자신의 정보를 문자열로 반환
//
// public void notify()                 객체 자신을 사용하려고 기다리는 쓰레드를 1개만 깨운다.
//
// public void notifyAll()              객체 자신을 사용하려고 기다리는 모든 쓰레드를 깨운다.
//
// public void wait()                   다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를
//                                      무한히 기다리게 한다.
//
// public void wait(long timeout)       다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를
//                                      지정된 시간동안 기다리게 한다. (단위: 1/1000초)
//
// public void wait(long timeout, int nanos)
//                                      다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를
//                                      지정된 시간동안 기다리게 한다. (단위: 1/1000초 + 1/10억 초)
//

// 참고로, 클래스 중에는 Class 라는 이름의 클래스가 있다.
// 이 클래스는 어떤 인스턴스의 클래스 정보를 담기 위한 클래스이다.
// 자바 프로그램에서 로드된 클래스의 metadata 를 나타내며, 클래스의 구조, 필드, 메서드 등에 대한 정보를 제공한다.
// 또, Class 클래스를 통해서 객체를 생성할 수도 있다.

// 위에 보면 protected 접근제어자로 되어 있는 메서드들이 있는데, 이러한 메서드들은 호출하려면
// 반드시 public 접근제어자로 오버라이딩해서 써야 한다.

public class _01_ObjectClassMethods {
    public static void main(String[] args) {

    }
}

