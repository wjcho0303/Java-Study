package ch07_OOP_protectedTest;

import ch07_OOP2._09_AccessModifier;

public class ProtectedExtendingClass extends _09_AccessModifier {
    public static void main(String[] args) {
        System.out.println("The package of this ProtectedExtendingClass class is 'ch07_OOP_protectedTest'");
        System.out.println("Let me call the protected method which is in other package.");
        System.out.println("객체생성: ProtectedExtendingClass testInstance = new ProtectedExtendingClass();");
        System.out.println("메서드 호출: testInstance.protectedMethod();");
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ출력 결과ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        ProtectedExtendingClass testInstance = new ProtectedExtendingClass();
        testInstance.protectedMethod();

        _09_AccessModifier testInstance2 = new ProtectedExtendingClass();
/*      testInstance2.defaultMethod();                                                                               */
/*      'defaultMethod()' is not public in 'ch07_OOP._09_AccessModifier'. Cannot be accessed from outside package.   */
    }
}
