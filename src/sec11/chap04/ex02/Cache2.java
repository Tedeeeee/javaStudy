package src.sec11.chap04.ex02;

public class Cache2 {

    // Cache 1 에서 본 것 처럼 JVM 의 캐싱 처리로 인한 stop 이 작동하지 않을때 해결 방법
    // 1. volaile 사용
    volatile static boolean stop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;

                // 이번에는 println 을 넣지 않았다.
            }

            System.out.println("- - - - -쓰레드 종료- - - - -");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        stop = true;

        /**
         *  volatile 연산자
         *  - 변수의 값이 변경 될 때마다 메모리에 업데이트된다
         *  - 멀티 쓰레딩 환경에서 캐싱에 의한 문제를 방지한다.
         *  - 동기화와는 다른 것이다. 값 변경만 배주면 바로 확인을 시켜주는 방식이다.
         */

    }
}
