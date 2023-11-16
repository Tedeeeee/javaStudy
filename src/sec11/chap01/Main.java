package src.sec11.chap01;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // 각각의 생성 방식이 다르다
        // Thread 를 상속받은 클래스는 즉석으로 생성
        Thread thread1 = new Thread1();
        // Runnable 은 Thread 의 인자로 넣어준다.
        Thread thread2 = new Thread(new MyRunnable());

        // Runnable 의 익명 클래스로 생성된다.
        // 위의 방법처럼 구현을 따로 해서 생성도 가능하지만 간단한 기능만 존재하기 때문에 익명 클래스를 사용할 수 있다.
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (var i = 0; i < 20; i++) {
                    System.out.print(3);
                }
            }
        });

        // 위의 익명 클래스는 람다식으로도 전환할 수 있다.
        Thread thread4 = new Thread(() -> {
            for (var i = 0; i < 20; i++) {
                System.out.print(4);
            }
        });

        // 해당 쓰레드에 지정된 run 메소드를 현재 메인 쓰레드에서 실행된다.
        // 쓰레드 사용은 의미가 없다.
        // thread1.run();
        // thread2.run();
        // thread3.run();
        // thread4.run();

        // 그렇다면 쓰레드 답게 작동하려면 어떻게 해야 할 까? start 메소드를 사용하면 된다.
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        for (var i = 0; i < 20; i++) {
            System.out.print("M");
        }
    }
}
