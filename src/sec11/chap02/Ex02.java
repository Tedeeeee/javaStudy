package src.sec11.chap02;

public class Ex02 {
    public static void main(String[] args) {
        Thread thr0 = new Thread(new PrintThrNoRun(0));
        Thread thr1 = new Thread(new PrintThrNoRun(1));
        Thread thr2 = new Thread(new PrintThrNoRun(2));

        /**
         *  💡 쓰레드의 우선 순위 정하기
         *  - 기본적으로 같은 우선권을 가지고 있다
         *  - setPriority 를 통해서 그룹들을 각각 활성화 하여 다시 실행해 볼 수 있다.
         */

        // 클수록 우선 순위가 높다.
        // thr0.setPriority(Thread.MIN_PRIORITY);
        // thr1.setPriority(Thread.NORM_PRIORITY);
        // thr2.setPriority(Thread.MAX_PRIORITY);

        // thr0.setPriority(Thread.MAX_PRIORITY);
        // thr1.setPriority(Thread.NORM_PRIORITY);
        // thr2.setPriority(Thread.MIN_PRIORITY);

        /**
         *   ⭐️ JVM에게 힌트만 주는 것 뿐이다. 실제 컨트롤은 OS가 하게 된다
         *   - 우선순위를 정해준다고 하더라도 OS가 무시하면 그만인 것이다.
         *   - 정말 작은 영향 정도로만 준다.
         */

        //thr0.start();
        //thr1.start();
        //thr2.start();

        // ⭐️ yield : 같은 우선순위가 된다면 다른 쓰레드에 양보하게 된다.

        // Main 이 아닌 같은 우선순위인 다른 쓰레드
        new Thread(() -> {
            for (var i = 0; i < 20; i++) {
                System.out.print(3);
                for (var j = 0; j < Integer.MAX_VALUE; j++) {}

                // 해당 쓰레드가 다른 쓰레드에게 양보한다.
                Thread.yield();
            }
        }).start();

        // Main 쓰레드
        for (var i = 0; i < 20; i++) {
            System.out.print('M');
            for (var j = 0; j < Integer.MAX_VALUE; j++) {}
        }

        // 하지만 결국 JVM 에서 설정하는 우선순위는 OS 에게 힌트만 주는 정도이기 때문에 확실치 않다.
    }


}
