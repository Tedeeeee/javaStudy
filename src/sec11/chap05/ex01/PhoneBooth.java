package src.sec11.chap05.ex01;

public class PhoneBooth {
    synchronized public void phoneCall(SoldierRun soldier) {
        System.out.printf("☎\uFE0F %s 전화 사용중...%n", soldier.title);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }

        System.out.printf("\uD83D\uDC4D %s 전화 사용 완료%n", soldier.title);

        notifyAll();
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
