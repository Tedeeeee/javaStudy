package src.sec11.chap02;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Thread tarzanSong = new Thread(new TarzanRun(10));

        tarzanSong.setName("타장");

        tarzanSong
                //.run(); // 타잔 노래가 끝나야 입력에 응답이 가능하다.
                .start(); // 입력 응답과 동시 진행 가능해진다.

        try (Scanner sc = new Scanner(System.in)){
            while (sc.hasNext()) {
                var line = sc.nextLine();

                // isAlive() : 해당 쓰레드가 종료한지 안한지 확인하는 메소드이다.
                if (line.equalsIgnoreCase("check")) {
                    System.out.println(
                            tarzanSong.isAlive() ? "기다려봐" : "끝났어"
                    );
                }

                // join() : 만약 해당 쓰레드가 start 로 인해 시작되었다면 join 으로 인해 run 처럼 변한다고 생각하면 된다.
                if (line.equalsIgnoreCase("enjoy")) {
                    System.out.println("이 노래 재밌는데? 좀 더 들어보자");

                    // 해당 쓰레드의 작업이 다 끝날 때까지 기다리게 된다.
                    // join 은 예외 처리를 해줘야한다.
                    try {
                        // tarzanSong.join();
                        // 이런식으로 동기화 식으로 바꾸는 작업은 정해진 시간또한 줄 수 있다.
                        tarzanSong.join(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if (line.equalsIgnoreCase("stop")) {
                    System.out.println("아 제발 조용히 좀 해");

                    /**
                     *  해당 쓰레드에 Interrupt 를 발생 시키는 것이다.
                     *  - sleep 으로 해당 쓰레드가 정지가 되어있을때 Interrupt 예외를 발생시키는 방법이다.
                     *  - 이는 강제로 멈추는 것이 아니라 권유하는 것이다. 때문에 해당 쓰레드의 run 메소드에서 InterruptException 에서 처리를 해주어야한다.
                     */

                    tarzanSong.interrupt();

                    /**
                     * 과거에는 쓰레드를 강제종료하는 stop 이 존재했지만 강제종료는 위험하다 때문에 deprecated 되었다.
                     * 데이터 오염, 리소스 누수등 suspend, resume 등도 마찬가지이다.
                     */

                }

                if (line.equalsIgnoreCase("quit")) break;
                System.out.println(line);
            }
        }
    }
}
