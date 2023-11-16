package src.sec11.chap01;

import java.util.stream.IntStream;

public class WrongSleep {
    public static void main(String[] args) {
        Thread sleeper = new Thread(
                () -> IntStream.range(0, 5)
                        .forEach(i -> {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println('잠');
                        })
        );
        sleeper.start();

        try {
            // sleeper 쓰레드를 재우려고 했지만 sleep 은 정적 메소드
            // 현재 Thread 가 잠들어 버린다.
            // sleeper 내부에서 sleep 을 사용해서 sleeper 가 잔다.
            sleeper.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("잘 잤다!");
    }

}
