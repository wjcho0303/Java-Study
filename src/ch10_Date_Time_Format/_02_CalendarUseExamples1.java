package ch10_Date_Time_Format;
import java.util.Calendar;

//  set() 으로 날짜와 시간을 지정할 수 있다.
//  관련 메서드의 오버로딩 목록들을 보면 다음과 같다:
//
//  void set(int field, int value)
//  void set(int year, int month, int date)
//  void set(int year, int month, int date, int hourOfDay, int minute)
//  void set(int year, int month, int date, int hourOfDay, int minute, int second)
//
//  매개변수를 넣을 수 있는 개수가 2개, 3개, 5개, 6개 이렇게 네 가지가 있는데 결국은 전부 정수형이라서
//  사용자가 원하는 날짜 단위를 넣어도 된다. month, date 이런 식으로 써놓은 건 그냥 추천? 정도로 받아들이면 된다.
//  두 날짜간의 차이를 얻으려면, getTimeInMillis() 천분의 일초 단위로 변환해야한다. 예시 참고.


public class _02_CalendarUseExamples1 {
    public static String toString(Calendar date) {
        return date.get(Calendar.YEAR)+ "년 " + (date.get(Calendar.MONTH)+1) + "월 " + date.get(Calendar.DATE) + "일 ";
    }

    public static void main(String[] args) {
        // 요일은 1부터 시작하기 때문에, DAY_OF_WEEK[0]은 비워두었다.
        final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        // month 의 경우 0부터 시작하기 때문에 4월인 경우, 3로 지정해야한다.
        // date1.set(2019, Calendar.APRIL, 29);와 같이 할 수도 있다.
        date1.set(1993, 2, 3); // 1993년 3월 3일로 날짜를 설정한다.
        System.out.println("date1은 "+ toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고,");
        System.out.println("오늘은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다.");

        // 두 날짜간의 차이를 얻으려면, 두 날짜의 getTimeInMillis()를 호출하여 뺄셈을 하여 차이를 구해야 한다.
        long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
        System.out.println("date1 부터 지금까지 " + difference + "초가 지났습니다.");
        System.out.println("일(day)로 계산하면 " + difference/(24*60*60) + "일입니다."); // 1일 = 24 * 60 * 60
    }
}
