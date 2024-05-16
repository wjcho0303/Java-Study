package ch09_UsefulPackages;

//      char[] append()
//      StringBuffer 클래스의 메서드는 append()는 기본 자료형들을 다 받을 수 있고,
//      어떤 자료형의 값들을 넣어도 모두 char[] 안에 한 글자 한 글자씩 삽입한다.
//      boolean, char, char[], double, int, float, int, long, obj, str 등 모두
//      최종적으로 char[] 요소로 들어온다.
//
//
//      int capacity()
//      capacity 는 StringBuffer 인스턴스가 가진 배열의 총 길이를 반환한다.
//      String 을 입력 받아 생성된 StringBuffer 의 배열 길이는 String 길이 + 16 이다.
//
//
//      int length()
//      length()는 StringBuffer 인스턴스가 가진 배열에서 실제 요소들(char)의 개수를 반환한다.
//
//
//
//      char charAt(int index)
//      지정된 index 위치에 있는 문자를 반환. String class 의 메서드와 완전히 똑같음.
//
//
//
//      StringBuffer delete(int begin, int end)   end 미포함
//      반환형은 처리가 완료된 후의 StringBuffer 참조변수 자기 자신이다.
//
//
//
//      StringBuffer deleteCharAt(int index)
//      지정된 index 위치의 문자 하나만 제거하고 참조변수 자기 자신을 반환한다.
//
//
//
//      StringBuffer insert(int pos, value)
//      입력한 index 위치에 value 를 문자형으로 변환 후 삽입 (value 는 다양한 타입들임)
//      StringBuffer sb = new StringBuffer("0123456");
//      sb.insert(4, ".");
//      sb = "0123.456"
//
//
//
//      StringBuffer replace(int begin, int end, String str)  end 미포함
//      지정된 범위의 문자들을 삭제하고 그 삭제한 자리에 입력한 문자열(str)을 삽입
//      StringBuffer sb = new StringBuffer("0123456789");
//      sb.replace(3, 6, "삽입문자");
//                              sb = "012삽입문자6789"
//                  "345"가 "삽입문자"로 대체된 모습
//
//
//
//      StringBuffer reverse()
//      매개변수는 없음. StringBuffer 인스턴스에 메서드를 쓰면 char[] 요소들의 순서를 거꾸로 바꿈
//      StringBuffer sb = new StringBuffer("0123456789");
//      sb.reverse();
//                  sb = "9876543210"
//
//
//
//      String substring(int begin)
//      String substring(int begin, int end) end 미포함
//      String 클래스와 사용법 같음. 지정한 index 범위의 문자만 추출하여 반환
//
//
//
//      void setCharAt(int index, char ch)
//      입력한 인덱스 위치의 문자를 입력한 char 문자로 치환
//
//
//
//      void setLength(int length)
//      길이를 입력한 정수로 설정함


public class _07_StringBufferMethods {
    public static void main(String[] args) {

        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 1번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  char[] append()
        //  StringBuffer 클래스의 메서드는 append()는 기본 자료형들을 다 받을 수 있고,
        //  어떤 자료형의 값들을 넣어도 모두 char[] 안에 한 글자 한 글자씩 삽입한다.
        //  boolean, char, char[], double, int, float, int, long, obj, str 등 모두
        //  최종적으로 char[] 요소로 들어온다.
        StringBuffer sb1 = new StringBuffer("Hello");
        System.out.println("sb1 = " + sb1);
        boolean boolean1 = true;
        System.out.println("boolean1 = " + boolean1);
        System.out.println("sb1.append(boolean1) = " + sb1.append(boolean1));
        char char1 = 'G';
        System.out.println("char1 = " + char1);
        System.out.println("sb1.append(char1) = " + sb1.append(char1));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 2번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  int capacity()
        //  capacity 는 StringBuffer 인스턴스가 가진 배열의 총 길이를 반환한다.
        //  String 을 입력 받아 생성된 StringBuffer 의 배열 길이는 String 길이 + 16 이다.

        //  int length()
        //  length()는 StringBuffer 인스턴스가 가진 배열에서 실제 요소들(char)의 개수를 반환한다.
        StringBuffer sb2 = new StringBuffer("Hava a nice day.");
        System.out.println("sb2 = " + sb2);
        System.out.println("sb2.length() = " + sb2.length());
        System.out.println("sb2.capacity() = sb2.length() + 16 = " + sb2.capacity());



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 3번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  char charAt(int index)
        //  지정된 index 위치에 있는 문자를 반환. String class 의 메서드와 완전히 똑같음.
        StringBuffer sb3 = new StringBuffer("Happy New Year!");
        System.out.println("sb3 = " + sb3);
        System.out.println("sb3.charAt(0) = " + sb3.charAt(0));
        System.out.println("sb3.charAt(1) = " + sb3.charAt(1));
        System.out.println("sb3.charAt(2) = " + sb3.charAt(2));
        System.out.println("sb3.charAt(3) = " + sb3.charAt(3));
        System.out.println("sb3.charAt(4) = " + sb3.charAt(4));
        System.out.println("sb3.charAt(5) = " + sb3.charAt(5));
        System.out.println("sb3.charAt(6) = " + sb3.charAt(6));
        System.out.println("sb3.charAt(7) = " + sb3.charAt(7));
        System.out.println("sb3.charAt(8) = " + sb3.charAt(8));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 4번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  StringBuffer delete(int begin, int end)   end 미포함
        //  반환형은 처리가 완료된 후의 StringBuffer 참조변수 자기 자신이다.
        System.out.println("sb3 = " + sb3);
        sb3.delete(5, sb3.length());
        System.out.println("sb3.delete(5, sb3.length());");
        System.out.println("sb3 = " + sb3);



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 5번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  StringBuffer deleteCharAt(int index)
        //  지정된 index 위치의 문자 하나만 제거하고 참조변수 자기 자신을 반환한다.
        StringBuffer sb4 = new StringBuffer("Good afternoon.");
        System.out.println("sb4 = " + sb4);
        System.out.println("sb4.length() = " + sb4.length());
        System.out.println("sb4.capacity() = " + sb4.capacity());
        System.out.println("sb4.deleteCharAt(2) = " + sb4.deleteCharAt(2));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.deleteCharAt(0) = " + sb4.deleteCharAt(0));
        System.out.println("sb4.length() = " + sb4.length());
        System.out.println("sb4.capacity() = " + sb4.capacity());



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 6번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  StringBuffer insert(int pos, value)
        //  입력한 index 위치에 value 를 문자형으로 변환 후 삽입 (value 는 다양한 타입들임)
        StringBuffer sb5 = new StringBuffer("Java");
        System.out.println("sb5 = " + sb5);
        String dot = ".";
        for (int i = 0; i < 2; i++) {
            System.out.println(sb5.insert(sb5.length() - 3, dot));
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(sb5.insert(sb5.length() - 2, dot));
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(sb5.insert(sb5.length() - 1, dot));
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(sb5.insert(sb5.length(), dot));
        }



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 7번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  StringBuffer replace(int begin, int end, String str)  end 미포함
        //  지정된 범위의 문자들을 삭제하고 그 삭제한 자리에 입력한 문자열(str)을 삽입
        StringBuffer sb6 = new StringBuffer("Spring Boot");
        System.out.println("sb6 = " + sb6);
        String hi = "hi";
        int startIndex = sb6.indexOf("Spring");
        System.out.println("sb6.replace(sb6.indexOf(\"Spring\"), sb6.indexOf(\"Spring\") + \"Spring\".length(), hi) = "
                + sb6.replace(sb6.indexOf("Spring"), sb6.indexOf("Spring") + "Spring".length(), hi));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 8번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  StringBuffer reverse()
        //  매개변수는 없음. 단순히 문자열의 순서를 거꾸로 바꿈
        StringBuffer sb7 = new StringBuffer("Linux, Mac, Windows.");
        System.out.println("sb7 = " + sb7);
        System.out.println("sb7.reverse() = " + sb7.reverse());



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 9번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  String substring(int begin)
        //  String substring(int begin, int end) end 미포함
        //  String 클래스와 사용법 같음. 지정한 index 범위의 문자만 추출하여 반환
        StringBuffer sb8 = new StringBuffer("StringBuffer is useful and efficient.");
        System.out.println("sb8 = " + sb8);
        System.out.println("sb8.substring(sb8.indexOf(\"useful\"), sb8.length()) = "
                + sb8.substring(sb8.indexOf("useful"), sb8.length()));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 10번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  void setCharAt(int index, char ch)
        //  입력한 인덱스 위치의 문자를 입력한 char 문자로 치환
        StringBuffer sb9 = new StringBuffer("I love fox.");
        System.out.println("sb9 = " + sb9);
        sb9.setCharAt(sb9.indexOf("fox"), 'b');
        System.out.println("sb9 = " + sb9);



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 11번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  void setLength(int length)
        //  길이를 입력한 정수로 설정함. 추가적인 길이는 공백 문자 '\n0000'가 들어간다.
        System.out.println("sb9 = " + sb9);
        System.out.println("sb9.length() = " + sb9.length());
        sb9.setLength(sb9.length() + 3);
        System.out.println("sb9.setLength(sb9.length() + 3);");
        System.out.println("sb9 = " + sb9);
        sb9.setLength(3);
        System.out.println("sb9.setLength(3);");
        System.out.println("sb9 = " + sb9);
    }
}
