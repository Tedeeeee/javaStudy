package src.sec11.chap03;

public class Ex03 {
    public static void main(String[] args) {
        Runnable rythmRun = () -> {
            var index = 0;
            var rythm = "쿵쿵짝";

            while (true) {
                System.out.print(rythm.charAt(index++) + " ");
                index %= rythm.length();

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // SingThread 를 보면 2개의 쓰레드가 운용되는 것을 볼 수 있다.
        Thread SingThread = new Thread(() -> {
            var lines = new String[] {
                    "푸른하늘 은하수", "하얀 쪽배엔",
                    "계수나무 한나무", "토끼 세마리",
                    "한마리는 구워먹고", "한마리는 튀겨먹고",
                    "한마리는 도망간다", "서쪽나라로"
            };

            Thread rythmThread = new Thread(rythmRun);

            // 만약 setDarmon 을 해주지 않는다면 아직 rythmThread 는 종속적이지 않는다.
            // 하지만 setDaemon 을 해준다면 종속적으로 변하는 것이다.
            // 이렇게 되면 SingThread가 종료 되었을때 같이 종료되는 것을 알수 있다.
            rythmThread.setDaemon(true);

            rythmThread.start();

            for (var i = 0; i < lines.length; i++) {
                System.out.println("\n" + lines[i]);
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        SingThread.start();
    }
}
