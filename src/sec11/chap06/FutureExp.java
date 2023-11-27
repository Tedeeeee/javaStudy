package src.sec11.chap06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExp {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        // submit 메소드 : Callable 을 받아서 Future 를 반환한다.
        // String 을 받아올 임무를 가진 것이란 의미이다.
        // execute 메소드와 비교
        Future<String> callAnswer = es.submit( () -> {
            Thread.sleep(2000);
            return "여보세요";
        });

        // get 메소드를 호출하기 전까지는 막히지 않고 동시에 진행한다.
        // Future 의 Callable 은 다른 쓰레드에서 진행된다.

        // isDone 메소드 : Future 의 태스크가 종료되었는지 여부를 확인한다.
        while (!callAnswer.isDone()) {
            System.out.println("\uD83D\uDCDE 따르릉...");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {

            }
        }

        String result = null;

        // get 메소드 : 해당 Future 쓰레드의 작업이 끝난 뒤 결과를 받아올 것이다.
        // 이를 완료하기까지 그 뒤의 작업들이 막힌다. ( Blocking )
        // 대안을 위해 나온 것이 CompletableFuture 이다.
        try {
            result = callAnswer.get();
        } catch (InterruptedException | ExecutionException e) {

        }

        System.out.println("✅ 통화 시작 - " + result);
        System.out.println("- - - 작업 종료 - - -");

        es.shutdown();
    }
}
