package ch13_Thread;

import java.util.List;
import java.util.stream.IntStream;

public class NormalThread {
    public static void main(String[] args) {
        Long startTimeInSeconds = System.currentTimeMillis()/1000;
        List<Thread> threads = IntStream.range(0, 1_000_000)
                .mapToObj(i -> new Thread(() -> {}))
                .toList();

        threads.forEach(Thread::start);
        Long endTimeInSeconds = System.currentTimeMillis()/1000;
        
        Long intervalInSeconds = (endTimeInSeconds - startTimeInSeconds);
        System.out.println("intervalInSeconds = " + intervalInSeconds);
        
    }
}
