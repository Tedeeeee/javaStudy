package src.sec11.chap04.ex01;

import java.util.Random;

public class ATM {
    private int balance = 0;

    public void addMoney(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    // synchronized 를 붙이고 다시 실행해 볼 것
    synchronized public void withdraw(String name, int amount) {
        // this 는 현 쓰레드를 의미한다.
        // 메소드 내의 특정 작업만 동기화가 필요할 때

        if (balance < amount) return;

        System.out.printf(
                "\uD83D\uDCB0 %s 인출 요청 ( 현 잔액 %d )%n",
                name, balance
        );

        try {
            Thread.sleep(new Random().nextInt(700, 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        balance -= amount;
        System.out.printf(
                "✅ %s 인출 완료 ( 현 잔액 %d )%n",
                name, balance
        );
    }
}
