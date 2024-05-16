package ch10_Date_Time_Format;

//  * 참고사항
//  Date
//  java.util.Date 패키지에서 제공하며, 거의 deprecated 되었다.
//
//  Calendar
//  java.util.Calendar 패키지에서 제공하며, 여전히 단점이 존재하지만 17년 정도라는 오랜 기간 동안 사용되어 왔다.
//  오래 사용된 만큼 여전히 사용하는 곳이 많다.
//
//  LocalDateTime
//  java.time 패키지에서 제공하며, Java 8 에 포함되어 출시되었다. 현재 기준으로 사용이 권장되고 있다.

//  동영상 강의는 기초편이라서 Calendar 를 통해 날짜와 시간 관련된 클래스를 설명하고,
//  java.time 패키지는 자바의 정석 3판에서 설명한다. 그렇기 때문에 별도의 학습이 필요하다.
//  Calendar 클래스를 배워두면 LocalDateTime 을 배우는 데 도움이 될 것이다.

import java.util.Calendar;

public class _01_CalendarClass {
    public static void main(String[] args) {
        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선 1 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  Calendar 클래스는 추상 클래스이다. 그래서 객체를 생성하기 위해서는 new Calendar() 가 불가능하며,
        //  getInstance() 라는 메서드를 사용해야 한다.

        //  Calendar.getInstance() 메서드를 통해 Calendar 객체가 생성되면 그 객체는 그 순간의 날짜 및 시간 정보를 담고 있다.
        //  Calendar.getInstance() 를 호출할 때 메서드가 사용자의 OS 정보를 읽어와서
        //  본 시스템이 어떤 달력 체제를 사용하는지 판단하여 (예: 서양력, 불교력, 일본력 등) 그 중 한 가지를 선택하여 저장하는 것이다.
        //  예를 들어 서양력을 사용하면 컴파일러가 자동으로 getInstance()를 new GregorianCalendar() 로 저장한다.
        Calendar cal = Calendar.getInstance();
        System.out.println("cal = " + cal);



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선 2 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  getActualMinimum(Calendar.static 상수)      입력한 필드가 가질 수 있는 최솟값을 반환. 고정 상수이다.
        //  getActualMaximum(Calendar.static 상수)      입력한 필드가 가질 수 있는 최댓값을 반환. 고정 상수이다.
        //  Calendar 의 static 상수들은 다음과 같다 : DATE, YEAR, MONTH, WEEK_OF_YEAR 등

        System.out.println("cal.getActualMinimum(Calendar.YEAR) = " + cal.getActualMinimum(Calendar.YEAR));
        System.out.println("cal.getActualMaximum(Calendar.YEAR) = " + cal.getActualMaximum(Calendar.YEAR) + "\n");
        // 최소 1, 최대 292278994

        System.out.println("cal.getActualMinimum(Calendar.MONTH) = " + cal.getActualMinimum(Calendar.MONTH));
        System.out.println("cal.getActualMaximum(Calendar.MONTH) = " + cal.getActualMaximum(Calendar.MONTH) + "\n");
        // 최소 0, 최대 11
        // 값이 0부터 시작하기 때문에 0은 1월을 의미하고 11은 12월을 의미한다.

        System.out.println("cal.getActualMinimum(Calendar.DATE) = " + cal.getActualMinimum(Calendar.DATE));
        System.out.println("cal.getActualMaximum(Calendar.DATE) = " + cal.getActualMaximum(Calendar.DATE) + "\n");
        // 최소 1, 최대 31
        // DATE 라는 static 상수를 통해 cal 이 가리키는 그 날짜의 달의 마지막 날을 반환한다.
        // static 상수이기 때문에 Calendar.DATE 라고 입력해야 한다.
        // 가능한 값은 28, 29, 30, 31 이 네 가지다. 가리키는 시간이 어떤 시간이냐에 따라 다르다.

        System.out.println("cal.getActualMinimum(Calendar.DAY_OF_WEEK) = " + cal.getActualMinimum(Calendar.DAY_OF_WEEK));
        System.out.println("cal.getActualMaximum(Calendar.DAY_OF_WEEK) = " + cal.getActualMaximum(Calendar.DAY_OF_WEEK) + "\n");
        // 최소 1, 최대 7
        // 1은 일요일이고 7은 토요일이다.

        System.out.println("cal.getActualMinimum(Calendar.WEEK_OF_YEAR) = " + cal.getActualMinimum(Calendar.WEEK_OF_YEAR));
        System.out.println("cal.getActualMaximum(Calendar.WEEK_OF_YEAR) = " + cal.getActualMaximum(Calendar.WEEK_OF_YEAR) + "\n");
        // 최소 1, 최대 52

        System.out.println("cal.getActualMinimum(Calendar.DAY_OF_YEAR) = " + cal.getActualMinimum(Calendar.DAY_OF_YEAR));
        System.out.println("cal.getActualMaximum(Calendar.DAY_OF_YEAR) = " + cal.getActualMaximum(Calendar.DAY_OF_YEAR) + "\n");
        // 최소 1, 최대 366

        System.out.println("cal.getActualMinimum(Calendar.DAY_OF_WEEK_IN_MONTH) = " + cal.getActualMinimum(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("cal.getActualMaximum(Calendar.DAY_OF_WEEK_IN_MONTH) = " + cal.getActualMaximum(Calendar.DAY_OF_WEEK_IN_MONTH) + "\n");
        // 최소 1, 최대 5

        System.out.println("cal.getActualMinimum(Calendar.HOUR) = " + cal.getActualMinimum(Calendar.HOUR));
        System.out.println("cal.getActualMaximum(Calendar.HOUR) = " + cal.getActualMaximum(Calendar.HOUR) + "\n");
        // 최소 0, 최대 11

        System.out.println("cal.getActualMinimum(Calendar.HOUR_OF_DAY) = " + cal.getActualMinimum(Calendar.HOUR_OF_DAY));
        System.out.println("cal.getActualMaximum(Calendar.HOUR_OF_DAY) = " + cal.getActualMaximum(Calendar.HOUR_OF_DAY) + "\n");
        // 최소 0, 최대 23

        System.out.println("cal.getActualMinimum(Calendar.MINUTE) = " + cal.getActualMinimum(Calendar.MINUTE));
        System.out.println("cal.getActualMaximum(Calendar.MINUTE) = " + cal.getActualMaximum(Calendar.MINUTE) + "\n");
        // 최소 0, 최대 59

        System.out.println("cal.getActualMinimum(Calendar.SECOND) = " + cal.getActualMinimum(Calendar.SECOND));
        System.out.println("cal.getActualMaximum(Calendar.SECOND) = " + cal.getActualMaximum(Calendar.SECOND) + "\n");
        // 최소 0, 최대 59

        System.out.println("cal.getActualMinimum(Calendar.MILLISECOND) = " + cal.getActualMinimum(Calendar.MILLISECOND));
        System.out.println("cal.getActualMaximum(Calendar.MILLISECOND) = " + cal.getActualMaximum(Calendar.MILLISECOND) + "\n");
        // 최소 0, 최대 999

        System.out.println("cal.getActualMinimum(Calendar.ZONE_OFFSET) = " + cal.getActualMinimum(Calendar.ZONE_OFFSET));
        System.out.println("cal.getActualMaximum(Calendar.ZONE_OFFSET) = " + cal.getActualMaximum(Calendar.ZONE_OFFSET) + "\n");
        // 최소 -46800000 (-13시간), 최대 50400000 (+14시간)
        // GMT 시차의 최솟값과 최댓값을 말해준다.값의 규모는 밀리세컨드 단위이다.

        System.out.println("cal.getActualMinimum(Calendar.AM_PM) = " + cal.getActualMinimum(Calendar.AM_PM));
        System.out.println("cal.getActualMaximum(Calendar.AM_PM) = " + cal.getActualMaximum(Calendar.AM_PM) + "\n");
        // 최소 0, 최대 1
        // 0은 AM을 의미하고, 1은 PM을 의미한다.


        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선 3 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        //  get(Calendar.static 상수)     Calendar 인스턴스가 가진 값 중 원하는 필드만 반환

        System.out.println("cal.get(Calendar.YEAR) = " + cal.get(Calendar.YEAR) + "\n");

        System.out.println("cal.get(Calendar.MONTH) = " + cal.get(Calendar.MONTH) + "\n");

        System.out.println("cal.get(Calendar.DATE) = " + cal.get(Calendar.DATE) + "\n");

        System.out.println("cal.get(Calendar.DAY_OF_WEEK) = " + cal.get(Calendar.DAY_OF_WEEK) + "\n");

        System.out.println("cal.get(Calendar.WEEK_OF_YEAR) = " + cal.get(Calendar.WEEK_OF_YEAR) + "\n");

        System.out.println("cal.get(Calendar.DAY_OF_YEAR) = " + cal.get(Calendar.DAY_OF_YEAR) + "\n");

        System.out.println("cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) = " + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) + "\n");

        System.out.println("cal.get(Calendar.HOUR) = " + cal.get(Calendar.HOUR) + "\n");

        System.out.println("cal.get(Calendar.HOUR_OF_DAY) = " + cal.get(Calendar.HOUR_OF_DAY) + "\n");

        System.out.println("cal.get(Calendar.MINUTE) = " + cal.get(Calendar.MINUTE) + "\n");

        System.out.println("cal.get(Calendar.SECOND) = " + cal.get(Calendar.SECOND) + "\n");

        System.out.println("cal.get(Calendar.MILLISECOND) = " + cal.get(Calendar.MILLISECOND) + "\n");

        System.out.println("cal.get(Calendar.ZONE_OFFSET) = " + cal.get(Calendar.ZONE_OFFSET) + "\n");
        // 32400000. 한국은 GMT + 9 이므로 32400000/1000/60/60 = 9

        System.out.println("cal.get(Calendar.AM_PM) = " + cal.get(Calendar.AM_PM) + "\n");
    }
}
