package ch06_OOP1;

//      Tv의 설계도
//      class Tv {
//          String color;
//          boolean power;
//          int channel;
//
//          void power() {
//              power = !power;
//          }
//          void channelUp() {
//              channel++;
//          }
//          void channelDown() {
//              channel--;
//          }
//      }

import java.util.Arrays;

public class _03_ObjectArrays {
    public static void main(String[] args) {
        // 객체의 배열은 참조변수의 배열이라고 생각하면 된다.

        // Tv 타입의 참조변수 tv1, tv2, tv3 선언
         Tv tv1, tv2, tv3;

        // Tv 타입의 원소들을 담는 길이가 3인 배열 생성
         Tv[] tvArr = new Tv[3];

        // tvArr 의 원소들은 아직 객체를 생성하지 않았으므로 null 인 상태이다.
        System.out.println(Arrays.toString(tvArr));     // [null, null, null]


        // tvArr[인덱스값] 자체가 선언되어 있기는 하다.
        System.out.println(tvArr[0]);                   // null
        System.out.println(tvArr[1]);                   // null
        System.out.println(tvArr[2]);                   // null
        // 실제로 출력해보면 null 이 출력된다.


        // 그렇다면 이제는 실제로 객체를 생성해본 후에 출력해보자.
        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i] = new Tv();
            System.out.println(tvArr[i]);
            // ch06_OOP1.Tv@2f4d3709
            // ch06_OOP1.Tv@4e50df2e
            // ch06_OOP1.Tv@1d81eb93
        }

        // Arrays.toString() 메서드를 사용해서 출력할 수도 있다.
        System.out.println(Arrays.toString(tvArr));
        // [ch06_OOP1.Tv@2f4d3709, ch06_OOP1.Tv@4e50df2e, ch06_OOP1.Tv@1d81eb93]


        // 1) 배열 자체도 하나의 객체다.
        // 2) 배열에 있는 원소들(tvArr[0] ~ tvArr[2])은 인스턴스 그 자체, 즉 new Tv()가 아니라
        //    인스턴스의 메모리 주소를 담고 있는 변수들이다.



    }
}
