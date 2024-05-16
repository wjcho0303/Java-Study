package ch13_Thread;

public class _04_SingleThread_Example {
    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();

        for(int i=0; i < 300; i++)
            System.out.printf("%s", new String("-"));

        System.out.print("\n" + "소요시간1 : " + (System.currentTimeMillis()- startTime) + "\n");

        System.out.println("");

        for(int i=0; i < 300; i++)
            System.out.printf("%s", new String("|"));

        System.out.print("\n" + "소요시간2 : " + (System.currentTimeMillis() - startTime) + "\n");
    }
}
// 싱글 스레드로 돌리니까 작업이 겹치지 않는다.