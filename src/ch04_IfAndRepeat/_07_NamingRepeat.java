package ch04_IfAndRepeat;

public class _07_NamingRepeat {
    public static void main(String[] args) {
        // 콜론(:) 기호를 사용하면 반복문에는 이름을 붙일 수 있다.
        // break 와 continue 뒤에 해당 반복문의 이름을 입력하면
        // 입력한 그 반복문에 대해서 break 또는 continue 를 수행한다.

        System.out.println();
        System.out.println("------ Loop1 and Loop2 ------");
        Loop1 :
        for (int i = 2; i <= 9; i++) {
            System.out.println("----- " + i + "단 -----");
            Loop2 : for (int j = 1; j <= 9; j++) {
                if (j == 5) { break Loop2; }    // break; 와 동일. 이름 생략 시 안쪽 for 문에만 적용.
                System.out.println(i + " * " + j + " = " + i * j);
            }
        }

        System.out.println("------ Loop3 and Loop4 ------");
        Loop3 :
        for (int i = 2; i <= 9; i++) {
            System.out.println("----- " + i + "단 -----");
            Loop4 : for (int j = 1; j <= 9; j++) {
                if (j == 5) { break Loop3; }
                System.out.println(i + " * " + j + " = " + i * j);
            }
        }

        System.out.println("------ Loop5 and Loop6 ------");
        Loop5 :
        for (int i = 2; i <= 9; i++) {
            System.out.println("----- " + i + "단 -----");
            Loop6 : for (int j = 1; j <= 9; j++) {
                if (j == 5) { continue Loop6; }    // continue; 와 동일. 이름 생략 시 안쪽 for 문에만 적용.
                System.out.println(i + " * " + j + " = " + i * j);
            }
        }

        System.out.println("------ Loop7 and Loop8 ------");
        Loop7 :
        for (int i = 2; i <= 9; i++) {
            System.out.println("----- " + i + "단 -----");
            Loop8 : for (int j = 1; j <= 9; j++) {
                if (j == 5) { continue Loop7; }
                System.out.println(i + " * " + j + " = " + i * j);
            }
        }   // 결과적으로 Loop1 과 Loop2 상황과 동일.
    }
}
