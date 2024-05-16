package ch05_ArrayAndString;

import java.util.Arrays;

public class _06_ArraysClass {
    public static void main(String[] args) {

        // < 배열을 출력시켜주는 메서드와 배열을 비교해주는 Arrays 클래스의 메서드들 >
        // Arrays.toString() : 1차원 배열의 요소들을 [ , , , ] 형식으로 반환

        // Arrays.deepToString() : 다차원 배열의 요소들을 [ [ ], [ ], [ ], [ ], [ ], ... ] 형식으로 반환
        //                         일차원 배열에는 사용할 수 없는 메서드이다.

        // Arrays.equals(arr) : 1차원 배열의 요소들까지 모두 같은지 여부를 true false 로 반환

        // Arrays.deepEquals(arr1, arr2) : 두 개의 다차원 배열이 요소들까지 모두 같은지 여부를 true false 로 반환

        int[] arr1D1 = {0, 1, 2, 3, 4};
        int[][] arr2D1 = {{11, 12}, {21, 22}};
        System.out.println(Arrays.toString(arr1D1));                // [0, 1, 2, 3, 4]
        System.out.println(Arrays.deepToString(arr2D1));            // [[11, 12], [21, 22]]


        int[] arr1D2 = {0, 1, 2, 3, 4};
        int[][] arr2D2 = {{11, 11}, {11, 11}};
        System.out.println(Arrays.equals(arr1D1, arr1D2));          // true
        System.out.println(Arrays.deepEquals(arr2D1, arr2D2));      // false



        // < 배열을 복사해주는 Arrays 클래스의 메서드 - 1차원 배열 전용>
        // Arrays.copyOf(arr, length) : 입력한 배열을 왼쪽의 요소부터 입력한 길이만큼만 반환함.
        //                              인덱스 값이 아니라 길이다.

        // Arrays.copyOfRange(arr, idx1, idx2) : 입력한 배열을 반환하되, 입력한 index 범위만 반환
        // 단, idx2 역시 마찬가지로 length 값( ~.length )을 고려하여 해당 인덱스 값은 범위에 포함되지 않는다.

        int[] arr1D3 = Arrays.copyOf(arr1D1, 3);
        System.out.println(Arrays.toString(arr1D3));                // [0, 1, 2]

        int[] arr1D4 = Arrays.copyOfRange(arr1D1, 3, arr1D1.length);
        System.out.println(Arrays.toString(arr1D4));                // [3, 4]



        // < 배열을 정렬해주는 Arrays 클래스의 메서드>
        // Arrays.sort() : 왼쪽부터 오름차순으로 정렬

        int[] arr1D5 = {51, 17, 33, 81, 4, 6, 18, 99, 8, 6, 4, 1, 100};
        Arrays.sort(arr1D5);
        System.out.println(Arrays.toString(arr1D5));        // [1, 4, 4, 6, 6, 8, 17, 18, 33, 51, 81, 99, 100]
    }
}
