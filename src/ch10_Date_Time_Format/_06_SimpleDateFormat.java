package ch10_Date_Time_Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//  DecimalFormat 과 마찬가지로 SimpleDateFormat 도 인스턴스를 생성하면서 생성자를 통해 패턴을 등록하고,
//  해당 패턴을 가진 인스턴스로 format() 메서드를 호출하면 날짜 객체에 지정한 패턴을 적용할 수 있다.
//  다만 SimpleDateFormat 은 스레드 안전성이 떨어지기 때문에 여러 스레드에서 동시에 사용될 때 문제가 발생할 수 있다.
//  SimpleDateFormat 은 자바 1.1부터 존재하는 클래스이며, 클래스와 메서드의 네이밍이 이전 스타일을 따르고 있다.
//  그렇기 때문에 요즘은 LocalDateTime 에 호환되는 DateTimeFormatter 를 사용하는 것을 권장하나, 이런 것이 있다 정도 알아두자.

public class _06_SimpleDateFormat {
    public static void main(String[] args) throws ParseException {
        // 패턴을 적용할 클래스는 Date 클래스로 정했다.
        // SimpleDateFormat 을 이용하여 날짜와 시간을 여러 가지 방식으로 바꿔보자.
        Date today = new Date();


        SimpleDateFormat sdf1, sdf2, sdf3, sdf4;                // 일단 참조변수만 선언
        SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9, sdf10;  // 일단 참조변수만 선언


        // 생성자 new SimpleDateFormat()에 문자열을 넣는데, 이 문자열에 특정한 알파벳들은 날짜값으로 자동으로 인식한다.
        // y 또는 yyyy : 연도를 표현. 네 자리로 표현
        // yy : 연도를 표현. 두 자리로 표현
        // M : 월을 표현. 한 자리일 경우 한 자리로 표현
        // MM : 월을 표현. 두 자리로 표현
        // MMM : '월' 단위를 붙여서 표현. 한 자리일 경우 한 자리로 표현
        // d : 일을 표현. 한 자리일 경우 한 자리로 표현
        // dd : 일을 표현. 두 자리로 표현
        // E : 요일을 표현
        // EEEE : '요일'이라는 단위를 붙여서 표현
        // H : 24시간 형식 표현. 한 자리일 경우 한 자리로 표현
        // HH :24시간 형식 표현. 두 자리로 표현
        // h : 12시간 형식 표현. 한 자리일 경우 한 자리로 표현
        // hh :12시간 형식 표현. 두 자리로 표현
        // m : 분 표현. 한 자리일 경우 한 자리로 표현
        // mm : 분 표현. 두 자리로 표현
        // s : 초 표현. 한 자리일 경우 한 자리로 표현
        // ss : 초 표현. 두 자리로 표현
        // w : 해당 연도의 몇 번째 주인지 표현
        // W : 해당 월의 몇 번째 주인지 표현
        // F : 해당 요일이 월 중 몇 번째 맞이하는 요일인지 표현
        // a : 오전 / 오후 표현(한글로 표현)
        // ss.SSS 또는 s.SSS : 밀리세컨드까지 표현


        sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        sdf2 = new SimpleDateFormat("y년 MMM dd일 E요일");
        sdf3 = new SimpleDateFormat("yyyy-MM-dd H:mm:ss.SSS");
        sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        sdf5 = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
        sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
        sdf7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
        sdf8 = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
        sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");
        sdf10 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a HH:mm:ss");

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선1 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  format(날짜객체)
        //  SimpleDateFormat 인스턴스를 문자열로 바꿀 때는 format(날짜 객체) 메서드를 쓴다.
        System.out.println(sdf1.format(today));
        System.out.println(sdf2.format(today));
        System.out.println(sdf3.format(today));
        System.out.println(sdf4.format(today));
        System.out.println();
        System.out.println(sdf5.format(today));
        System.out.println(sdf6.format(today));
        System.out.println(sdf7.format(today));
        System.out.println(sdf8.format(today));
        System.out.println(sdf9.format(today));
        System.out.println(sdf10.format(today));



        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // parse(문자열)
        // SimpleDateFormat 인스턴스를 날짜 객체로 바꿀 때는 parse(문자열) 메서드를 쓴다.
        // 입력된 문자열이 형식에 맞지 않는 경우 ParseException 이 발생하기 때문에
        // 이를 호출하는 main 메서드에 throws ParseException 가 붙어 있는 것을 볼 수 있다.
        try {
            Date dt1 = sdf1.parse("2017-07-26");
            System.out.println("Date dt1 = sdf1.parse(\"2017-07-26\");");
            System.out.println("dt1 = " + dt1);
            System.out.println("sdf10.format(dt1) = " + sdf10.format(dt1));
        } catch (ParseException pe) {
            System.out.println("ParseException 발생");
        }
        // 그러나 보다시피 try-catch 를 해야 하기 때문에 코드 가독성이 떨어지고
        // Date 패키지 자체도 대부분 deprecated 되었기 때문에 사용이 권장되지 않는다.
    }
}
