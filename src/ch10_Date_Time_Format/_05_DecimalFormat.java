package ch10_Date_Time_Format;

import java.text.DecimalFormat;

public class _05_DecimalFormat {
    public static void main(String[] args) {
        //  DecimalFormat 클래스는 숫자를 사용자가 원하는 특정한 형식으로 표현하려고 할 때 사용한다.
        //  특정 형식을 등록하려면 DecimalFormat 인스턴스를 생성해야 한다.

        //  DecimalFormat DecimalFormat(String pattern)
        //  DecimalFormat() 생성자의 매개변수로 원하는 패턴을 문자열로 입력한다.

        //  double format(value)
        //  생성자를 통해 만들어진 DecimalFormat 객체에 format() 메서드를 호출하여 매개변수에 숫자를 입력하면 된다.

        //  문자열에 들어가는 패턴에는 다음과 같은 규칙이 적용된다:
        //  0 : 0~9까지의 숫자가 들어감. 값이 존재하지 않아도 0을 반드시 표시한다.
        //  # : 0~9까지의 숫자가 들어감. 값이 존재하지 않으면 0을 제거한다.
        //  E : 10의 거듭제곱이 몇 번 이루어지는지 표현해준다.
        //  특히, 형식화에서 자릿수 구분을 위한 , 기호도 쓸 수 있다.
        System.out.println("----------------------------------------");
        DecimalFormat df = new DecimalFormat("#.#E0");
        System.out.println("DecimalFormat df = new DecimalFormat(\"#.#E0\");");



        System.out.println("----------------------------------------");
        //  이렇게 만들어놓은 형식을 적용시키기 위해서는 format() 이라는 메서드를 호출하면 된다.
        System.out.println("이렇게 만들어놓은 형식을 적용시키기 위해서는 format() 이라는 메서드를 호출하면 된다.");
        double num = 1234567.89;
        System.out.println("num = " + num);
        System.out.println("df.format(num) = " + df.format(num));



        System.out.println("----------------------------------------");
        System.out.println("원본값: " + num);
        DecimalFormat df1 = new DecimalFormat("0");
        System.out.println("패턴: 0 (반올림 자동)");
        System.out.println("df1: " + df1.format(num)+"\n");

        System.out.println("원본값: " + num);
        DecimalFormat df2 = new DecimalFormat("0.0");
        System.out.println("패턴: 0.0");
        System.out.println("df2: " + df2.format(num)+"\n");

        System.out.println("원본값: " + num);
        DecimalFormat df3 = new DecimalFormat("00000000000000.0000");
        System.out.println("패턴: 00000000000000.0000");
        System.out.println("df3: " + df3.format(num)+"\n");

        System.out.println("원본값: " + num);
        DecimalFormat df4 = new DecimalFormat("#");
        System.out.println("패턴: # (반올림 자동)");
        System.out.println("df4: " + df4.format(num)+"\n");

        System.out.println("원본값: " + num);
        DecimalFormat df5 = new DecimalFormat("#.#");
        System.out.println("패턴: #.#");
        System.out.println("df5: " + df5.format(num)+"\n");

        System.out.println("원본값: " + num);
        DecimalFormat df6 = new DecimalFormat("##,###,###,###,####,#####.########");
        System.out.println("패턴: ##,###,###,###,####,#####.########");
        System.out.println("df6: " + df6.format(num));
        System.out.println("이렇게 자리 구분을 위해 쉼표를 찍어서 할 수도 있다."+"\n");

        System.out.println("원본값: " + num);
        DecimalFormat df7 = new DecimalFormat("#.#E0");
        System.out.println("패턴: #.#E0");
        System.out.println("df7: " + df7.format(num)+"\n");

        System.out.println("원본값: " + num);
        DecimalFormat df8 = new DecimalFormat("0.0E0");
        System.out.println("패턴: 0.0E0");
        System.out.println("df8: " + df8.format(num)+"\n");

        System.out.println("원본값: " + num);
        DecimalFormat df9 = new DecimalFormat("0.0000000000E0");
        System.out.println("패턴: 0.0000000000E0");
        System.out.println("df9: " + df9.format(num)+"\n");

        System.out.println("원본값: " + num);
        DecimalFormat df10 = new DecimalFormat("00.00000000E0");
        System.out.println("패턴: 00.00000000E0");
        System.out.println("df10: " + df10.format(num)+"\n");

        System.out.println("원본값: " + num);
        DecimalFormat df11 = new DecimalFormat("#.##########E0");
        System.out.println("패턴: #.##########E0");
        System.out.println("df11: " + df11.format(num)+"\n");

        System.out.println("원본값: " + num);
        DecimalFormat df12 = new DecimalFormat("##.##########E0");
        System.out.println("패턴: ##.##########E0");
        System.out.println("df12: " + df12.format(num)+"\n");
    }
}
