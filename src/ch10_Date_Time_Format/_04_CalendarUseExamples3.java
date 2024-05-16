package ch10_Date_Time_Format;
import java.util.Calendar;
import java.util.Scanner;

public class _04_CalendarUseExamples3 {

    public static String toString(Calendar day) {
        return day.get(Calendar.YEAR)+"년"+(day.get(Calendar.MONTH)+1) +"월"+ (day.get(Calendar.DATE)) + "일";
    }

    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        date.clear();
        // clear()는 모든 필드값을 초기화한다. 초기화 값은 1970년 1월 1일 00시00분00초이다.
        // 이를 Epoch time 이라 부른다.

        date.set(2020, 7, 31);  // date 가 가리키는 값을 2020년 8월 31일로 설정
        date.add(Calendar.DATE, 1);       // date 의 일(日) 수치를 1만큼 증가
        // 그러면 날짜가 어떻게 될까? 답은 9월 1일이 된다.
        // add() 메서드는 이렇게 다른 필드에 영향을 준다.
        System.out.println(toString(date));


        date.set(2020, 7, 31);  // 다시 date 가 가리키는 값을 2020년 8월 31일로 설정
        date.roll(Calendar.DATE, 1);    // DATE 필드값을 1만큼 증가
        // 이번엔 날짜가 어떻게 될까? 9월 1일일까? 정답은 8월 1일이다.
        // roll() 메서드는 다른 필드에 영향을 주지 않기 때문이다.
        System.out.println(toString(date));


        date.roll(Calendar.MONTH, -8);  // month 필드값을 -8
        // 지금 8월 1일인데 이번엔 날짜가 어떻게 될까? 2019년 12월 1일? 정답은 2020년 12월 1일이다.
        // 다른 필드에 영향을 주지 않기 때문이다.
        System.out.println(toString(date));


        System.out.println("--------------달력 만들기-------------");
        Scanner scanner = new Scanner(System.in);
        String[] calendarArr = new String[2];

        System.out.print("연도를 입력하십시오 : ");
        calendarArr[0] = scanner.next();

        System.out.print("월을 입력하십시오 : ");
        calendarArr[1] = scanner.next();

        int year  = Integer.parseInt(calendarArr[0]);
        int month = Integer.parseInt(calendarArr[1]);
        int START_DAY_OF_WEEK = 0;                     // 시작 요일이 무슨 요일인지 담을 변수를 초기화
        int END_DAY = 0;                               // 그 달의 마지막 날을 담을 변수 초기화 (30일? 31일?)

        Calendar sDay = Calendar.getInstance(); // 시작일
        Calendar eDay = Calendar.getInstance(); // 끝일

        // 월의 경우 0부터 11까지의 값을 가지므로 1을 빼주어야 한다.
        // 예를 들어, 2019년 9월 1일은 sDay.set(2019, 8, 1);과 같이 해줘야 한다.
        sDay.set(year, month-1, 1);  // sDay를 현재 달 첫 날로 설정 (2019년 9월 1일)
        eDay.set(year, month, 1);           // eDay를 댜음 날 첫 날로 설정 (2019년 10월 1일)
        // eDay를 만드는 이유는 여기서 1일을 빼면 현재 달의 마지막 날이 나오기 때문

        // 다음달의 첫날(10월 1일)에서 하루를 빼면 현재달의 마지막 날(9월 말일)이 된다.
        eDay.add(Calendar.DATE, -1);
        // 다른 날짜 필드에 영향을 미치는 add()를 사용한다. <-- roll()은 영향을 주지 않으므로!

        // 첫 번째 요일이 무슨 요일인지 알아낸다. 1일이 무슨 요일인지 알아낸다.
        // 이번 예시에서는 일요일이기 때문에 값이 1이 된다.
        START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

        // eDay에 지정된 날짜를 얻어온다. 말일이 30일인지 31일인지 모르기 때문에 이걸 써야 한다.
        END_DAY = eDay.get(Calendar.DATE);

        System.out.println("      " + year +"년 " + month +"월");
        System.out.println(" SU MO TU WE TH FR SA");

        // 해당 월의 1일이 어느 요일인지에 따라서 공백을 출력한다.
        // 만일 1일이 수요일이라면 공백을 세 번 찍는다.(DAY_OF_WEEK는 일요일 1로 시작하여 토요일 7로 끝난다)
        for(int i=1; i < START_DAY_OF_WEEK; i++) {
            System.out.print("   ");
        }

        for(int i=1, n=START_DAY_OF_WEEK ; i <= END_DAY; i++, n++) {
            System.out.print((i < 10)? "  "+i : " "+i ); // i가 10이 되는 때부터는 공백을 한 칸으로 줄임
            if(n%7==0) System.out.println();    // 토요일(n값이 7의 배수)이 될 때마다 줄바꿈
        }
    }
}
