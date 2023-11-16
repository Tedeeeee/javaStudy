package src.sec11.chap02;

public class Ex01 {
    public static void main(String[] args) {
        Thread tarzanThread = new Thread(new TarzanRun(5));

        // 쓰레드에 이름을 붙여보자
        tarzanThread.setName("타잔송");

        tarzanThread.start();
    }



}
