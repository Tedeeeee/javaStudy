package src.sec11.chap04.ex02;

public class Cache1 {
    static boolean stop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;

                //System.out.println(i);
            }

            System.out.println("- - - -쓰레드 종료- - - -");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        stop = true;

        /**
         *  JVM 의 캐시 방식에 따라 멈출 수도 안 멈출 수도 있다.
         *  - stop 으로 접근이 동기화되지 않았을 시
         *  - 한 쓰레드가 그 값을 바꿔도 다른 쓰레드는 캐시에 저장된 바뀌기 이전 값을 참조하고 있을 가능성이 높다.
         *  - println 메소드는 위 코드에서 캐시를 비우는 이유를 제공한다.
         */

    }
}
