package ch11_CollectionsFramework;
import java.util.*;

// Arrays 는 배열을 다룰 때 사용하면 편리한 static 메서드를 제공하는 util 클래스이다.
// Math 와 같이 static util 메서드를 제공하는 클래스라고 생각하면 된다.


//  1. 배열의 출력: Arrays.toString(arr)
//  static String toString(type)
//  Arrays 클래스에서 Object 클래스의 toString 을 오버라이딩하여 재정의했기 때문에
//  Arrays.toString(type) 을 호출하면 대괄호 안에 배열의 내용들을 넣어서 문자열로 출력해준다.
//  예시: [1, 2, 3, 4, 5]


//  2. 배열의 복사: Arrays.copyOf(),  Arrays.copyOfRange()
//  copyOf(arr, int length) : 입력한 배열을 입력한 길이만큼 복사. 기존 배열의 길이보다 클 경우 초기값으로 채움
//  copyOfRange(arr, int startIndex, int endIndex) : 입력한 배열을 입력한 index 범위만 골라서 복사
//                                                   당연히 범위는  startIndex ≤ x < endIndex
//  int[] arr = {0, 1, 2, 3, 4};
//  int[] arr2 = Arrays.copyOf(arr, arr.length);        결과: arr2 = [0,1,2,3,4]
//  int[] arr3 = Arrays.copyOf(arr, 3);                 결과: arr3 = [0,1,2]
//  int[] arr4 = Arrays.copyOf(arr, 7);                 결과: arr4 = [0,1,2,3,4,0,0]
//  int[] arr5 = Arrays.copyOfRange(arr, 2, 4);         결과: arr5 = [2,3]
//  int[] arr6 = Arrays.copyOfRange(arr, 0, 7);         결과: arr6 = [0,1,2,3,4,0,0]



//  3. 배열 채우기: Arrays.fill(),  Arrays.setAll ()
//  fill(arr, value) : 입력한 배열을 입력한 value 로 가득채움
//  setAll(arr, 람다식) : 입력한 배열을 람다식을 이용해 채움
//
//  int[] arr = new int[5];
//  Arrays.fill(arr, 9);                                    결과: arr = [9,9,9,9,9]
//  Arrays.setAll(arr, (i) -> (int)(Math.random()*5) + 1);  결과: arr = [1,5,2,2,5] (1~5 난수 5개)



//  4. 배열 정렬과 검색: Arrays.sort(), Arrays.binarySearch() - 이진탐색이라고 불림
//  void Arrays.sort(arr)               : 입력한 배열을 오름차순으로 정렬해줌
//  int Arrays.binarySearch(arr, value) : 입력한 배열 내에 value 의 index 위치를 리턴
//                                 단, 정렬이 되어 있는 배열에만 사용가능하다. 그렇기 때문에 sort 를 먼저 하고 사용해야 한다.
//
//  int[] arr = {3, 7, 0, 1, 5};
//  int idx = Arrays.binarySearch(arr, 3);      idx=-5 잘못된 결과. 이진탐색은 정렬이 되어 있을 때만 쓸 수 있다.

//  Arrays.sort(arr);                           결과: arr = [0,1,3,5,7]
//  int idx = Arrays.binarySearch(arr, 3);      idx=2 올바른 결과



//  이진 검색이 왜 정렬이 되어 있어야 할까?
//  이진 검색은 정렬된 데이터를 절반으로 쪼갠 후 그 중앙값을 기점으로 상관 없는 영역은 조회를 아예 안 하고
//  상관 있어 보이는 영역만 찾기 때문이다.
//  예를 들어 7 1 6 9 5 3 8 4 10 2 이런 배열이 있어서 이걸 정렬을 하면
//  1 2 3 4 5 6 7 8 9 10 이렇게 된다.
//  이진 검색으로 10을 찾는다고 해보자.
//  먼저 반으로 자른다. 가운데 5 < 10 이므로 왼쪽의 1 2 3 4 5는 버려진다.
//  그다음 남은 6 7 8 9 10 을 또 반으로 자른다. 그럼 가운데 8 < 10 이므로 6 7 8 이 버려진다.
//  그 다음에 9 와 10이 남는데 여기서 찾는다.
//  이런 식으로 찾을 때까지 반으로 계속 쪼개기 때문에 정렬이 되어 있어야 한다.



//  5. 다차원 배열의 출력: Arrays.deepToString()
//  String Arrays.deepToString(arr) : 입력한 다차원 배열을 낮은 행부터 출력한다.
//
//  int[] arr = {0,1,2,3,4};
//  int[][] arr2D = {{11,12}, {21,22}};
//
//  Arrays.toString(arr);             결과: [0, 1, 2, 3, 4]
//  Arrays.deepToString(arr2D);       결과: [[11, 12], [21, 22]]



//  6. 다차원 배열의 비교: deepEquals()
//  boolean deepEquals(arr1, arr2) : 입력한 두 다차원 배열을 비교하고 내용이 같으면 true, 다르면 false 리턴
//
//  String[][] str2D = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}}
//  String[][] str2D2 = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}}
//
//  Arrays.equals(str2D, str2D2);       결과: false
//  Arrays.deepEquals(str2D, str2D2);   결과: true
//
//  equals 는 다차원 배열에 쓰면 잘못된 결과가 나온다. 그래서 다차원 배열의 비교는 deepEquals 를 써야 한다.



//  7. 배열을 List 로 변환: asList(Object arr)
//  List asList(Object... a) : 입력한 매개변수들을 객체형 배열인 List 에 넣어서 리턴해준다. (auto-boxing)
//                             가변 매개변수로, 매개변수의 개수가 정해져 있지 않다.
//  만약 매개변수로 기본형 배열을 넣어주면 그 배열을 객체의 배열 List 로 바꿔준다.
//  단, 여기서 만들어진 List 는 읽기 전용 List 이다. 만드는 순간 배열의 길이가 정해지기 때문이다.

//  List list = Arrays.asList(new Integer[]{1,2,3,4,5});            결과: list = [1, 2, 3, 4, 5]
//  List list = Arrays.asList(1,2,3,4,5);                           결과: list = [1, 2, 3, 4, 5]
//  list.add(6);       <-- UnsupportedOperationException 예외 발생
//
//  만약 이 List 에 진짜로 6을 넣고 싶으면 어떻게 해야하나?
//  List list = new ArrayList(Arrays.asList(1,2,3,4,5));
//  이렇게 새로운 ArrayList 로 다시 만들어줘야 한다.
//  그런데 참조변수 list 를 그대로 써도 되는 것인가? 구현체 변경은 가능하다.
//  이렇게 구현체를 변경하고 나면 그 구현체처럼 쓰면 된다.



//  8. 람다와 스트림과 관련된 기능들도 있는데, 이는 후에 다루도록 한다.

public class _10_ArraysClass {
    public static void main(String[] args) {
        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선1 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        int[]	   arr   = {0,1,2,3,4};
        int[][]	arr2D = {{11,12,13}, {21,22,23}};

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        System.out.println("Arrays.toString(arr2D) = "+Arrays.toString(arr2D));
        System.out.println("Arrays.deepToString(arr2D) = "+Arrays.deepToString(arr2D));

        System.out.println("\nint[] arr2 = Arrays.copyOf(arr, arr.length);");
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));

        System.out.println("\nint[] arr3 = Arrays.copyOf(arr, 3);");
        int[] arr3 = Arrays.copyOf(arr, 3);
        System.out.println("Arrays.toString(arr3) = " + Arrays.toString(arr3));

        System.out.println("\nint[] arr4 = Arrays.copyOf(arr, 7);");
        int[] arr4 = Arrays.copyOf(arr, 7);
        System.out.println("Arrays.toString(arr4) = " + Arrays.toString(arr4));

        System.out.println("\nint[] arr5 = Arrays.copyOfRange(arr, 2, 4);");
        int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
        System.out.println("Arrays.toString(arr5) = " + Arrays.toString(arr5));

        System.out.println("\nint[] arr6 = Arrays.copyOfRange(arr, 0, 7);");
        int[] arr6 = Arrays.copyOfRange(arr, 0, 7);
        System.out.println("Arrays.toString(arr6) = " + Arrays.toString(arr6));



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선2 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("int[] arr7 =  new int[5];");
        int[] arr7 =  new int[5];
        System.out.println("Arrays.fill(arr7, 9);");
        Arrays.fill(arr7, 9);  // arr=[9,9,9,9,9]
        System.out.println("Arrays.toString(arr7) = " + Arrays.toString(arr7));

        System.out.println("Arrays.setAll(arr7, i -> (int)(Math.random()*6)+1);");
        Arrays.setAll(arr7, i -> (int)(Math.random()*6)+1);
        System.out.println("Arrays.toString(arr7) = " + Arrays.toString(arr7));

        System.out.println("for(int i : arr7) {\n" +
                "            char[] graph = new char[i];\n" +
                "            Arrays.fill(graph, '*');\n" +
                "            System.out.println(new String(graph)+i);\n" +
                "        }");
        for(int i : arr7) {
            char[] graph = new char[i];
            Arrays.fill(graph, '*');
            System.out.println(new String(graph)+i);
        }



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선3 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("String[][] str2D  = new String[][]{{\"aaa\",\"bbb\"},{\"AAA\",\"BBB\"}};");
        System.out.println("String[][] str2D2 = new String[][]{{\"aaa\",\"bbb\"},{\"AAA\",\"BBB\"}};");
        String[][] str2D  = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
        String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};

        System.out.println("\nArrays.equals(str2D, str2D2) = " + Arrays.equals(str2D, str2D2));           // false
        System.out.println("Arrays.deepEquals(str2D, str2D2) = " + Arrays.deepEquals(str2D, str2D2));   // true



        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선4 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("char[] chArr = { 'A', 'D', 'C', 'B', 'E' };");
        char[] chArr = { 'A', 'D', 'C', 'B', 'E' };
        System.out.println("\n= Before sorting =");
        System.out.println("Arrays.toString(chArr) = "+Arrays.toString(chArr));
        System.out.println("Arrays.binarySearch(chArr, 'B') = " + Arrays.binarySearch(chArr, 'B'));
        System.out.println("\n= After sorting =");
        System.out.println("Arrays.sort(chArr);");
        Arrays.sort(chArr);
        System.out.println("Arrays.toString(chArr) = " + Arrays.toString(chArr));
        System.out.println("Arrays.binarySearch(chArr, 'B') = " + Arrays.binarySearch(chArr, 'B'));
    }
}
