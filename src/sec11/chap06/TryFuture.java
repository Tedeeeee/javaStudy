package src.sec11.chap06;

import src.sec11.chap06.ex02.RollDiceCall;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class TryFuture {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);

        List<Future<Integer>> futList = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> {
            futList.add(
                    es.submit(new RollDiceCall())
            );
        });

        es.shutdown(); // 제거하면 프로그램이 끝나지 않고 계속 실행됨

        ArrayList<Integer> intList = new ArrayList<>();

        for (Future<Integer> future : futList ) {
            try {
                intList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {}
        }

        System.out.println(String.join(
                ",",
                intList.stream().map(String::valueOf).toArray(String[]::new)
        ));
    }
}
