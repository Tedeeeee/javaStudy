package src.sec10.chap05;

import java.util.Random;

public class Ex02 {
    public static void main(String[] args) {
        for (var i = 0; i < 10; i++) {
            dirtyOperation();
        }


    }
    public static void dirtyOperation () {
        try (SuicideSquad sc = new SuicideSquad()) {
            sc.doSecretTask();
        } catch (OpFailException e) {
            // 예외 상황은 아만다 윌러가 책임진다
            e.printStackTrace();
            System.out.println("\uD83D\uDDD1\uFE0F 증거 인멸\n- - - - - - - - -\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
