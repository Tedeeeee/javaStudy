package src.sec10.chap05;

import java.util.Random;

public class SuicideSquad implements AutoCloseable{
    public void doSecretTask() throws OpFailException {
        if (new Random().nextBoolean()) {
            throw new OpFailException();
        };
        System.out.println("\uD83D\uDD2B 비밀 작전 수행");
    }
    @Override
    public void close() throws Exception {
        System.out.println("\uD83D\uDCA3 전원 폭사\n- - - - - - -\n");
    }
}
