package ch09_UsefulPackages;

import java.util.Arrays;

//  String 클래스의 메서드들을 살펴보자:


//  String String(String str)           주어진 문자열 str 을 갖는 String 타입의 인스턴스 생성
//
//  String String(char[] charArray)     char[] 문자 배열을 String 으로 합친다.
//
//  char charAt(int index)              문자열을 char[]로 해석하여 해당 index 위치의 문자를 반환
//
//  int compareTo(String str)           입력 받은 문자열과 사전순서로 비교.
//                                      동일하면 0 을 반환,
//                                      호출한 문자열이 매개변수보다 사전순으로 더 이전이면 음수를 반환,
//                                      호출한 문자열이 매개변수보다 사전순으로 더 이후이면 양수를 반환
//                                      이러한 특성을 이용하여 문자열 정렬 코딩 테스트에 가끔 등장한다.
//  char[] toCharArray(String str)
//
//  String String(StringBuffer sb)      입력 받은 StringBuffer 인스턴스의 문자열을 String 으로 형변환
//
//  String concat(String str)           입력 받은 문자열을 이어 붙인다.
//
//  boolean contains(CharSequence str)  입력 받은 문자열의 포함 여부를 반환
//  여기서 CharSequence 는 인터페이스인데 String, StringBuffer, StringBuilder 모두 이 인터페이스를 구현했다.
//  그러므로 매개변수 자리에 이 세 가지 모두 올 수 있다.
//
//  boolean endsWith(String str)        입력 받은 문자열로 끝나는지 여부를 반환
//  boolean startsWith(String str)      입력 받은 문자열로 시작하는지 여부를 반환
//
//  boolean equalsIgnoreCase(String str)  입력 받은 문자열을 대소문자 구별 없이 같은지 여부 반환
//
//  int indexOf(int number)             입력 받은 정수를 유니코드 문자값으로 해석하고,
//                                      해당 문자의 index 위치를 반환. 존재하지 않는 경우 -1 반환
//
//  int indexOf(int ch, int pos)        입력 받은 ch 정수를 유니코드 문자값으로 해석하고,
//                                      해당 문자의 index 위치를 반환. 존재하지 않는 경우 -1 반환
//                                      단, 입력 받은 pos (position) index 값부터 서치한다.
//
//  int indexOf(String str)             입력 받은 문자열이 존재하는지 확인하여
//                                      해당 문자열의 시작 위치 index 위치를 반환. 존재하지 않는 경우 -1 반환
//
//  int lastIndexOf(int ch)             입력 받은 문자를 문자열의 오른쪽 끝에서부터 찾아서 index 위치를 반환
//                                      가장 오른쪽에 있는 것의 위치가 필요할 때 사용한다.
//                                      없으면 -1 반환
//
//  int lastIndexOf(String str)         입력 받은 문자열을 문자열의 오른쪽 끝에서부터 찾아서 index 위치를 반환
//                                      없으면 -1 반환
//
//  String[] split(String sep)          입력 받은 분리자가 문자열에 포함되면 해당 분리자로 문자열을 분할하고,
//                                      분할한 문자열들을 String[] 배열의 원소로 입력.
//
//  String[] split(String sep, int limit)
//                                      입력 받은 분리자로 문자열을 분할하되,
//                                      입력 받은 정수로 String[] 배열의 길이를 제한함
//
//  String subString(int begin)           문자열을 입력 받은 시작 위치부터 끝 위치까지 추출하여 반환
//  String subString(int begin, int end)  문자열을 입력 받은 시작 위치부터 끝 위치까지 추출하여 반환
//                                        포함 범위:  begin <= x < end
//
//  String toLowerCase()                모든 문자열을 소문자로 변환하여 반환
//  String toUpperCase()                모든 문자열을 대문자로 변환하여 반환
//
//  String trim()                       문자열의 맨 앞과 맨 뒤에 있는 공백들을 모두 제거하여 반환
//
//  static String valueOf(매개변수)      입력 받은 매개변수를 문자열로 변환시켜 반환
//                                      참조형 타입의 매개변수인 경우 toString() 결과로 반환
//
//  static String join(String str, String[] strArr)
//                                      입력 받은 구분자를 이용하여 매개변수 문자열 배열을
//                                      하나의 문자열로 이어붙여서 반환


import java.util.Arrays;

public class _05_StringMethods {
    public static void main(String[] args) {
        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 1번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  String String(String str)       주어진 문자열 str 을 갖는 String 타입의 인스턴스 생성
        String str1 = new String("안녕하세요.");
        System.out.println("str1 = " + str1);
        System.out.println("System.identityHashCode(str1) = " + System.identityHashCode(str1));

        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 2번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  String String(char[] charArray)     char[] 문자 배열을 String 으로 합친다.
        char[] charArray = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
        String str2 = new String(charArray);
        System.out.println("str2 = " + str2);

        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 3번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  char charAt(int index)      문자열을 char[]로 해석하여 해당 index 위치의 문자를 반환
        String str3 = "화이팅합시다.";
        System.out.println("str3 = " + str3);
        for (int i = 0; i < str3.length(); i++) {
            System.out.println("str3.charAt(" + i + ") = " + str3.charAt(i));
        }



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 4번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  int compareTo(String str)       입력 받은 문자열과 사전순서로 비교한다.
        //  동일하면 0 을 반환,
        //  호출한 문자열이 매개변수보다 사전순으로 더 이전이면 음수를 반환,
        //  호출한 문자열이 매개변수보다 사전순으로 더 이후이면 양수를 반환
        //  이러한 특성을 이용하여 문자열 정렬 코딩 테스트에 가끔 등장한다.
        String str4 = "aaa";
        System.out.println("str4 = " + str4);
        String str5 = "abc";
        System.out.println("str5 = " + str5);
        String str6 = "bbb";
        System.out.println("str6 = " + str6);
        String str7 = "bbb";
        System.out.println("str7 = " + str7);
        System.out.println("str4.compareTo(str5) = " + str4.compareTo(str5));
        System.out.println("str4.compareTo(str6) = " + str4.compareTo(str6));
        System.out.println("str5.compareTo(str6) = " + str5.compareTo(str6));
        System.out.println("str6.compareTo(str5) = " + str6.compareTo(str5));
        System.out.println("str6.compareTo(str7) = " + str6.compareTo(str7));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 5번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  char[] toCharArray(String str)      입력한 문자열을 char[] 타입 문자 배열로 반환한다.
        String str8 = "Java 공부는 많은 노력이 필요합니다.";
        System.out.println("str8 = " + str8);
        char[] str8CharArray = str8.toCharArray();
        System.out.println("char[] str8CharArray = str8.toCharArray();");
        System.out.println("str8.toCharArray() = " + str8.toCharArray());
        System.out.println("Arrays.toString(str8CharArray) = " + Arrays.toString(str8CharArray));
        System.out.println("subString 메서드를 이용하여 앞 뒤 대괄호 지우기");
        String str9 = Arrays.toString(str8CharArray)
                .substring(1, Arrays.toString(str8CharArray).length()-1);
        System.out.println("str9 = " + str9);



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 6번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // String String(StringBuffer sb)       입력 받은 StringBuffer 인스턴스의 문자열을 String 으로 형변환
        StringBuffer sb = new StringBuffer("StringBufferTest");
        System.out.println("sb = " + sb);
        System.out.println("sb.hashCode() = " + sb.hashCode());
        String str10 = sb.toString();
        System.out.println("String str10 = sb.toString();");
        System.out.println("str10 = " + str10);
        System.out.println("str10.hashCode() = " + str10.hashCode());



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 7번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  String concat(String str)       입력 받은 문자열을 이어 붙인다.
        String str11 = "concat ";
        System.out.println("str11 = " + str11);
        String str12 = "practice!";
        System.out.println("str12 = " + str12);
        String str13 = str11.concat(str12);
        System.out.println("String str13 = str11.concat(str12);");
        System.out.println("str13 = " + str13);



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 8번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  boolean contains(CharSequence str)  입력 받은 문자열의 포함 여부를 반환
        //  여기서 CharSequence 는 인터페이스인데 String, StringBuffer, StringBuilder
        //  모두 CharSequence 인터페이스를 구현했다. 그러므로 매개변수 자리에 이 세 가지 모두 올 수 있다.
        String str14 = "contains 메서드 테스트: String, StringBuffer, StringBuilder.";
        System.out.println("str14 = " + str14);
        StringBuffer sb2 = new StringBuffer("StringBuffer");
        System.out.println("sb2 = " + sb2);
        StringBuilder sbd = new StringBuilder("Hello, StringBuilder");
        System.out.println("sbd = " + sbd);
        StringBuilder sbd2 = new StringBuilder("StringBuilder");
        System.out.println("sbd2 = " + sbd2);
        System.out.println("str14.contains(sb2) = " + str14.contains(sb2));
        System.out.println("str14.contains(sbd) = " + str14.contains(sbd));
        System.out.println("str14.contains(sbd2) = " + str14.contains(sbd2));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 9번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  boolean endsWith(String str)        입력 받은 문자열로 끝나는지 여부를 반환
        //  boolean startsWith(String str)      입력 받은 문자열로 시작하는지 여부를 반환
        String str15 = "Java 는 처음에는 어렵지만 익숙해지면 할 만 합니다.";
        System.out.println("str15 = " + str15);
        System.out.println("str15.endsWith(\"안녕하세요.\") = " + str15.endsWith("안녕하세요."));
        System.out.println("str15.endsWith(\"할 만 합니다.\") = " + str15.endsWith("할 만 합니다."));
        System.out.println("str15.startsWith(\"자바\") = " + str15.startsWith("자바는"));
        System.out.println("str15.startsWith(\"Java\") = " + str15.startsWith("Java"));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 10번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  boolean equalsIgnoreCase(String str)  입력 받은 문자열을 대소문자 구별 없이 같은지 여부 반환
        String str16 = "Rainbow";
        System.out.println("str16 = " + str16);
        String str17 = "RAiNBoW";
        System.out.println("str17 = " + str17);
        System.out.println("str16.equalsIgnoreCase(str17) = " + str16.equalsIgnoreCase(str17));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 11번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  int indexOf(int number)             입력 받은 정수를 유니코드 문자값으로 해석하고,
        //                                      해당 문자의 index 위치를 반환.
        //                                      존재하지 않는 경우 -1 반환
        //
        //  int indexOf(int ch, int pos)        입력 받은 ch 정수를 유니코드 문자값으로 해석하고,
        //                                      해당 문자의 index 위치를 반환. 존재하지 않는 경우 -1 반환
        //                                      단, 입력 받은 pos (position) index 값부터 서치한다.
        //
        //  int indexOf(String str)             입력 받은 문자열이 존재하는지 확인하여
        //                                      해당 문자열의 시작 위치 index 위치를 반환.
        //                                      존재하지 않는 경우 -1 반환
        //
        String str18 = "HAPPY HAPPY NEW YEAR";
        System.out.println("str18 = " + str18);
        char char1 = 65;
        System.out.println("char1 = " + char1);
        System.out.println("str18.indexOf('P', 5) = " + str18.indexOf('P', 5));
        System.out.println("str18.indexOf('P', 1) = " + str18.indexOf('P', 1));
        System.out.println("str18.indexOf('P', 3) = " + str18.indexOf('P', 3));
        System.out.println("str18.indexOf(char1) = " + str18.indexOf(char1));
        System.out.println("str18.indexOf('A') = " + str18.indexOf('A'));
        System.out.println("str18.indexOf(65) = " + str18.indexOf(65));
        System.out.println("str18.indexOf('H') = " + str18.indexOf('H'));
        System.out.println("str18.indexOf(72) = " + str18.indexOf(72));
        System.out.println("str18.indexOf('Z') = " + str18.indexOf('Z'));
        System.out.println("str18.indexOf(\"NEW\") = " + str18.indexOf("NEW"));
        System.out.println("str18.indexOf(\"YEAR\") = " + str18.indexOf("YEAR"));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 12번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  int lastIndexOf(int ch)      입력 받은 문자를 문자열의 오른쪽 끝에서부터 찾아서 index 위치를 반환
        //                               가장 오른쪽에 있는 것의 위치가 필요할 때 사용한다. 없으면 -1 반환
        //
        //  int lastIndexOf(String str)  입력 받은 문자열을 문자열의 오른쪽 끝에서부터 찾아서 index 위치를 반환
        //                               없으면 -1 반환
        System.out.println("str18 = " + str18);
        System.out.println("str18.lastIndexOf('A') = " + str18.lastIndexOf('A'));
        System.out.println("str18.lastIndexOf('E') = " + str18.lastIndexOf('E'));
        System.out.println("str18.lastIndexOf('P') = " + str18.lastIndexOf('P'));
        System.out.println("str18.indexOf(\"HAPPY\") = " + str18.indexOf("HAPPY"));
        System.out.println("str18.lastIndexOf(\"HAPPY\") = " + str18.lastIndexOf("HAPPY"));
        System.out.println("str18.lastIndexOf('T') = " + str18.lastIndexOf('T'));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 13번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  String[] split(String sep)    입력 받은 분리자가 문자열에 포함되면 해당 분리자로 문자열을 분할하고,
        //                                분할한 문자열들을 String[] 배열의 원소로 입력.
        //
        //  String[] split(String sep, int limit)
        //                                입력 받은 분리자로 문자열을 분할하되,
        //                                입력 받은 정수로 String[] 배열의 길이를 제한함
        String str19 = "Cat,Dog,Mouse,Rabbit,Bear,Tiger,Fox";
        System.out.println("str19 = " + str19);

        String[] strArr = str19.split(",");
        System.out.println("String[] StrArr = str19.split(\",\");");
        System.out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));
        System.out.println("마지막 원소 = " + strArr[strArr.length - 1] + "\n");

        String[] strArr2 = str19.split(",", 1);
        System.out.println("String[] strArr2 = str19.split(\",\", 1);");
        System.out.println("Arrays.toString(strArr2) = " + Arrays.toString(strArr2));
        System.out.println("마지막 원소 = " + strArr2[strArr2.length - 1] + "\n");

        String[] strArr3 = str19.split(",", 2);
        System.out.println("String[] strArr3 = str19.split(\",\", 2);");
        System.out.println("Arrays.toString(strArr3) = " + Arrays.toString(strArr3));
        System.out.println("마지막 원소 = " + strArr3[strArr3.length - 1] + "\n");

        String[] strArr4 = str19.split(",", 3);
        System.out.println("String[] strArr4 = str19.split(\",\", 3);");
        System.out.println("Arrays.toString(strArr4) = " + Arrays.toString(strArr4));
        System.out.println("마지막 원소 = " + strArr4[strArr4.length - 1] + "\n");

        String[] strArr5 = str19.split(",", 4);
        System.out.println("String[] strArr5 = str19.split(\",\", 4);");
        System.out.println("Arrays.toString(strArr5) = " + Arrays.toString(strArr5));
        System.out.println("마지막 원소 = " + strArr5[strArr5.length - 1] + "\n");

        String[] strArr6 = str19.split(",", 5);
        System.out.println("String[] strArr6 = str19.split(\",\", 5);");
        System.out.println("Arrays.toString(strArr6) = " + Arrays.toString(strArr6));
        System.out.println("마지막 원소 = " + strArr6[strArr6.length - 1] + "\n");

        String[] strArr7 = str19.split(",", 6);
        System.out.println("String[] strArr7 = str19.split(\",\", 6);");
        System.out.println("Arrays.toString(strArr7) = " + Arrays.toString(strArr7));
        System.out.println("마지막 원소 = " + strArr7[strArr7.length - 1] + "\n");

        String[] strArr8 = str19.split(",", 7);
        System.out.println("String[] strArr8 = str19.split(\",\", 7);");
        System.out.println("Arrays.toString(strArr8) = " + Arrays.toString(strArr8));
        System.out.println("마지막 원소 = " + strArr8[strArr8.length - 1] + "\n");



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 14번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  String subString(int begin)           문자열을 입력 받은 시작 위치부터 끝 위치까지 추출하여 반환
        //  String subString(int begin, int end)  문자열을 입력 받은 시작 위치부터 끝 위치까지 추출하여 반환
        //                                        포함 범위:  begin <= x < end
        System.out.println("str18 = " + str18);     // "HAPPY HAPPY NEW YEAR"
        System.out.println("str18.substring(6) = " + str18.substring(6));
        System.out.println("str18.substring(7) = " + str18.substring(7));
        System.out.println("str18.substring(8) = " + str18.substring(8));
        System.out.println("str18.substring(9) = " + str18.substring(9));
        System.out.println("str18.substring(0,str18.length()) = " + str18.substring(0, str18.length()));
        System.out.println("str18.substring(3,str18.length()) = " + str18.substring(3, str18.length()));
        System.out.println("str18.substring(3,str18.length()-5) = " + str18.substring(3, str18.length() - 5));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 15번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  String toLowerCase()        모든 문자열을 소문자로 변환하여 반환
        //  String toUpperCase()        모든 문자열을 대문자로 변환하여 반환
        String str20 = "Sarah and John went for a walk in the Central Park.";
        System.out.println("str20 = " + str20);
        System.out.println("str20.toLowerCase() = " + str20.toLowerCase());
        System.out.println("str20.toUpperCase() = " + str20.toUpperCase());



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 16번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  String trim()       문자열의 맨 앞과 맨 뒤에 있는 공백들을 모두 제거하여 반환
        String str21 = "     <-- left 5 blanks and right 6 blanks. -->      ";
        System.out.println("str21 = " + str21);
        System.out.println("str21.trim() = " + str21.trim());



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 17번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  static String valueOf(매개변수)      입력 받은 매개변수를 문자열로 변환시켜 반환
        //                                      참조형 타입의 매개변수인 경우 toString() 결과로 반환
        int integer1 = 10;
        System.out.println("integer1 = " + integer1);
        System.out.println("String.valueOf(integer1) = " + String.valueOf(integer1));

        char char2 = 'C';
        System.out.println("char2 = " + char2);
        System.out.println("String.valueOf(char2) = " + String.valueOf(char2));

        boolean boolean1 = true;
        System.out.println("boolean1 = " + boolean1);
        System.out.println("String.valueOf(boolean1) = " + String.valueOf(boolean1));

        double double1 = 3.14;
        System.out.println("double1 = " + double1);
        System.out.println("String.valueOf(double1) = " + String.valueOf(double1));

        float float1 = 3.14f;
        System.out.println("float1 = " + float1);
        System.out.println("String.valueOf(float1) = " + String.valueOf(float1));

        long long1 = 955555555555555555L;
        System.out.println("long1 = " + long1);
        System.out.println("String.valueOf(long1) = " + String.valueOf(long1));

        Object obj = new Object();
        System.out.println("obj = " + obj);
        System.out.println("String.valueOf(obj) = " + String.valueOf(obj));



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 18번 예제 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  static String join(String str, String[] strArr)
        //  입력 받은 구분자를 이용하여 매개변수 문자열 배열을 하나의 문자열로 이어붙여서 반환
        String str22 = "dog,cat,bear";
        System.out.println("str22 = " + str22 + "\n");

        String[] strArr9 = str22.split(",");
        System.out.println("String[] strArr9 = str22.split(\",\");");
        System.out.println("Arrays.toString(strArr9) = " + Arrays.toString(strArr9) + "\n");

        String str23 = String.join("-", strArr9);
        System.out.println("String str23 = String.join(\"-\", strArr9);");
        System.out.println("str23 = " + str23 + "\n");

        String[] strArr10 = str23.split("-");
        System.out.println("String[] strArr10 = str23.split(\"-\");");
        System.out.println("Arrays.toString(strArr10) = " + Arrays.toString(strArr10) + "\n");

        String str24 = String.join("/", strArr10);
        System.out.println("String str24 = String.join(\"/\", strArr10);");
        System.out.println("str24 = " + str24 + "\n");
    }
}
