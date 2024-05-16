package ch10_Date_Time_Format;

//  본 학습 자료는 자바의 정석 유튜브 동영상 강의가 아닌, 빵형의 실전 Java 유튜브 동영상 강의를 바탕으로 작성되었다.

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class _07_LocalDateTimeDateTimeFormatter {
    public static void main(String[] args) {
        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선 1 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // 비교 대상으로 Date 클래스를 사용한다.
        Date dt1 = new Date();
        System.out.println("dt1 = " + dt1 + "\n");

        dt1.setMonth(dt1.getMonth() + 3);
        System.out.println("dt1.setMonth(dt1.getMonth() + 3);");
        System.out.println("dt1 = " + dt1 + "\n");



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선 2 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // LocalDateTime 클래스는 생성자를 private 으로 선언하여 직접적으로 객체를 생성할 수 없도록 설계되었다.
        // 대신 now() 메서드나 of() 메서드와 같은 정적 팩토리 메서드를 사용하여 객체를 생성한다.

        // now()    현재 로컬 시간으로 LocalDateTime 객체 생성
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println("ldt1 = " + ldt1 + "\n");

        // of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond)
        // 지정된 연도, 월, 일, 시, 분, 초 및 나노초로 LocalDateTime 객체를 생성
        LocalDateTime ldt2 = LocalDateTime.of(2024, 5, 10, 15, 30, 15, 0);
        System.out.println("ldt2 = " + ldt2 + "\n");



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선 3 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // LocalDateTime 은 불변성을 가진다(immutable).
        ldt1.plusMonths(3);
        System.out.println("ldt1.plusMonths(3);");
        System.out.println("ldt1 = " + ldt1);
        System.out.println("LocalDateTime 은 immutable 이기 때문에 값 자체를 변경하지는 못하고, 변경된 값을 새로 저장해야 한다." + "\n");

        LocalDateTime ldt3 = ldt1.plusMonths(3);
        System.out.println("LocalDateTime ldt2 = ldt1.plusMonths(3);");
        System.out.println("ldt3 = " + ldt3);
        System.out.println("이렇게 새로운 LocalTimeDate 객체 ldt2에 날짜 연산 값을 저장한다." + "\n");



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선 4 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // LocalDateTime 은 다양한 메서드를 통해 LocalDateTime 객체가 가진 정보들을 반환하는 getter 들이 있다.
        System.out.println("ldt1 = " + ldt1 + "\n");

        // getYear()
        System.out.println("ldt1.getYear() = " + ldt1.getYear() + "\n");

        // getMonth()
        System.out.println("ldt1.getMonth() = " + ldt1.getMonth() + "\n");

        // getDayOfMonth()
        System.out.println("ldt1.getDayOfMonth() = " + ldt1.getDayOfMonth() + "\n");

        // getHour()
        System.out.println("ldt1.getHour() = " + ldt1.getHour() + "\n");

        // getMinute()
        System.out.println("ldt1.getMinute() = " + ldt1.getMinute() + "\n");

        // getSecond()
        System.out.println("ldt1.getSecond() = " + ldt1.getSecond() + "\n");

        // getNano()
        System.out.println("ldt1.getNano() = " + ldt1.getNano() + "\n");

        // getDayOfWeek()
        System.out.println("ldt1.getDayOfWeek() = " + ldt1.getDayOfWeek() + "\n");

        // getDayOfYear()
        System.out.println("ldt1.getDayOfYear() = " + ldt1.getDayOfYear());



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선 5 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // LocalDateTime 에는 시간을 빼거나 추가할 수 있는 메서드들이 있다.
        // 각각 plus 와 minus 중 한 가지만 선택하겠다.
        // 연산 결과 각 시간 단위의 Max 값을 넘기면 앞 단위가 1씩 증가하기 때문에 편리하게 연산이 가능하다.

        // plusYears(), minusYears()
        System.out.println("ldt2 = " + ldt2);
        LocalDateTime ldt4 = ldt2.plusYears(10);
        System.out.println("LocalDateTime ldt4 = ldt2.plusYears(10);");
        System.out.println("ldt4 = " + ldt4 + "\n");

        // plusMonths(), minusMonths()
        System.out.println("ldt2 = " + ldt2);
        LocalDateTime ldt5 = ldt2.minusMonths(7);
        System.out.println("LocalDateTime ldt5 = ldt2.minusMonths(7);");
        System.out.println("ldt5 = " + ldt5 + "\n");

        // plusDays(), minusDays()
        System.out.println("ldt2 = " + ldt2);
        LocalDateTime ldt6 = ldt2.minusDays(45);
        System.out.println("LocalDateTime ldt6 = ldt2.minusDays(45);");
        System.out.println("ldt6 = " + ldt6 + "\n");

        // plusMinutes, minusMinutes
        System.out.println("ldt2 = " + ldt2);
        LocalDateTime ldt7 = ldt2.plusMinutes(90);
        System.out.println("LocalDateTime ldt7 = ldt2.plusMinutes(90);");
        System.out.println("ldt7 = " + ldt7 + "\n");

        // plusSeconds, minusSeconds
        System.out.println("ldt2 = " + ldt2);
        LocalDateTime ldt8 = ldt2.plusSeconds(110);
        System.out.println("LocalDateTime ldt8 = ldt2.plusSeconds(110);");
        System.out.println("ldt8 = " + ldt8 + "\n");

        // plusNanos, minusNanos
        System.out.println("ldt2 = " + ldt2);
        LocalDateTime ldt9 = ldt2.minusNanos(1000000000);   // 10억초
        System.out.println("LocalDateTime ldt9 = ldt2.minusNanos(1000000000);");
        System.out.println("ldt9 = " + ldt9 + "\n");

        // plusWeeks, minusWeeks
        System.out.println("ldt2 = " + ldt2);
        LocalDateTime ldt10 = ldt2.plusWeeks(2);
        System.out.println("LocalDateTime ldt10 = ldt2.plusWeeks(2);");
        System.out.println("ldt10 = " + ldt10 + "\n");



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선 6 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // 시간을 비교하는 메서드도 있다.
        // isEqual(대상)  대상 LocalDateTime 객체와 동일한지 여부를 반환
        System.out.println("ldt1 = " + ldt1);
        LocalDateTime ldt11 = LocalDateTime.now();
        LocalDateTime ldt12 = LocalDateTime.now();
        LocalDateTime ldt13 = LocalDateTime.now();
        LocalDateTime ldt14 = LocalDateTime.now();
        LocalDateTime ldt15 = LocalDateTime.now();
        LocalDateTime ldt16 = LocalDateTime.now();
        LocalDateTime ldt17 = LocalDateTime.now();

        // LocalDateTime 객체 간의 nano 시간차이를 늘리기 위한 코드
        // ldt 17과 ldt18 사이에 반복문으로 인해 인스턴스의 생성 시간 차이가 벌어지게 된다.
        String result = "";
        for (int i = 0; i < 50; i++) {
            result+=i;
        }

        LocalDateTime ldt18 = LocalDateTime.now();
        LocalDateTime ldt19 = LocalDateTime.now();
        LocalDateTime ldt20 = LocalDateTime.now();
        LocalDateTime ldt21 = LocalDateTime.now();
        LocalDateTime ldt22 = LocalDateTime.now();
        LocalDateTime ldt23 = LocalDateTime.now();
        System.out.println("ldt11 = " + ldt11);
        System.out.println("ldt12 = " + ldt12);
        System.out.println("ldt13 = " + ldt13);
        System.out.println("ldt14 = " + ldt14);
        System.out.println("ldt15 = " + ldt15);
        System.out.println("ldt16 = " + ldt16);
        System.out.println("ldt17 = " + ldt17);
        System.out.println("ldt18 = " + ldt18);
        System.out.println("ldt19 = " + ldt19);
        System.out.println("ldt20 = " + ldt20);
        System.out.println("ldt21 = " + ldt21);
        System.out.println("ldt22 = " + ldt22);
        System.out.println("ldt23 = " + ldt23);
        System.out.println("ldt1.isEqual(ldt11) = " + ldt1.isEqual(ldt11));
        System.out.println("ldt1.isEqual(ldt12) = " + ldt1.isEqual(ldt12));
        System.out.println("ldt11.isEqual(ldt12) = " + ldt11.isEqual(ldt12));
        System.out.println("ldt11.isEqual(ldt13) = " + ldt11.isEqual(ldt13));
        System.out.println("ldt11.isEqual(ldt14) = " + ldt11.isEqual(ldt14));
        System.out.println("ldt11.isEqual(ldt15) = " + ldt11.isEqual(ldt15));
        System.out.println("ldt11.isEqual(ldt16) = " + ldt11.isEqual(ldt16));
        System.out.println("ldt11.isEqual(ldt17) = " + ldt11.isEqual(ldt17));
        System.out.println("ldt11.isEqual(ldt18) = " + ldt11.isEqual(ldt18));
        System.out.println("ldt11.isEqual(ldt19) = " + ldt11.isEqual(ldt19));
        System.out.println("ldt11.isEqual(ldt20) = " + ldt11.isEqual(ldt20));
        System.out.println("ldt11.isEqual(ldt21) = " + ldt11.isEqual(ldt21));
        System.out.println("ldt11.isEqual(ldt22) = " + ldt11.isEqual(ldt22));
        System.out.println("ldt11.isEqual(ldt23) = " + ldt11.isEqual(ldt23) + "\n");
        // 일반적으로 now() 를 통해서 생성한 객체들 간에는 나노초까지 같아야 한다는 특성 상 같다는 결과가 나오기 힘들다.
        // 코드가 가까이 있다면 실행 시간의 차이가 얼마 나지 않아서 성능이 좋은 컴퓨터에서는 true 로 나올 수도 있긴 하나,
        // 이는 진짜 같다고 볼 수는 없다. 그래서 보통 Equals() 메서드의 대상은 of() 를 통해 생성된 LocalDateTime 객체들이다.

        // isAfter(대상)  대상 LocalDateTime 객체보다 나중인지 여부를 반환
        System.out.println("ldt2 = " + ldt2);
        System.out.println("ldt9 = " + ldt9);
        System.out.println("ldt2.isAfter(ldt9) = " + ldt2.isAfter(ldt9) + "\n");

        // isBefore(대상) 대상 LocalDateTime 객체보다 이전인지 여부를 반환
        System.out.println("ldt2 = " + ldt2);
        System.out.println("ldt9 = " + ldt9);
        System.out.println("ldt2.isBefore(ldt9) = " + ldt2.isBefore(ldt9) + "\n");



        System.out.println("\n" + "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 구분선 7 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        // 위에서 살펴본 메서드 외에도 DateTimeFormatter 를 매개변수로 받아서
        // LocalDateTime 객체를 String 으로 변환하는 format 메서드도 있다.
        // String format(DateTimeFormatter dtf)

        // 단, 이를 위해서는 DateTimeFormatter.ofPattern(String pattern) 메서드를 통해 패턴을 정의해놓은
        // DateTimeFormatter 객체를 매개 변수로 입력해야 한다.
        System.out.println("ldt23 = " + ldt23);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("y년 MMM dd일 E요일");
        System.out.println("DateTimeFormatter dtf = DateTimeFormatter.ofPattern(\"y년 MMM dd일 E요일\");");
        System.out.println("ldt23.format(dtf) = " + ldt23.format(dtf));
    }
}
