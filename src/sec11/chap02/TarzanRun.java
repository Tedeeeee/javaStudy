package src.sec11.chap02;

public class TarzanRun implements Runnable{
    int max;

    public TarzanRun(int max) {
        this.max = max;
    }

    @Override
    public void run() {
        var lyric = "%s번째 %s : 타잔이 %d원 짜리 팬티를 입고 %d원 짜리 칼을 차고 노래를 한다.";

        for (var i = 1; i <= max; i++) {
            try {
                Thread.sleep(2000);
                System.out.printf((lyric) + "%n",i, Thread.currentThread().getName(),
                        i * 10, (i + 1) * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
