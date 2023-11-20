package src.sec11.chap04.ex02;

public class Cache3 {

    // 2. 동기화 사용
    static boolean stop = false;

    synchronized public static boolean isStop() {
        return stop;
    }

    synchronized public static void setStop(boolean stop) {
        Cache3.stop = stop;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;

            while (!isStop()) {
                i++;
            }

            System.out.println("- - - -쓰레드 종료- - - -");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        setStop(true);
    }
}
