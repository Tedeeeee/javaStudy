package src.sec11.chap07;

import src.sec07.chap4.Side;
import src.sec07.chap4.SwordMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        try {
            //supplyAsyncEx();
            //thenAcceptEx1();
            //thenAcceptEx2();
            thenApplyEx1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void takeTime(boolean error) {

        // 시간이 걸리고 예외 가능성이 있는 작업 시뮬레이션

        try {
            int randMilliSec = new Random().nextInt(1000, 1500);
            Thread.sleep(randMilliSec);
            System.out.printf("....%f 초 경과 ...%n", randMilliSec / 1000.0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (error) throw new RuntimeException("⚠\uFE0F 오류 발생");
    }

    public static void supplyAsyncEx() throws ExecutionException, InterruptedException {

        // supplyAsync : Supplier 를 받아서 비동기 작업을 실행한다.
        // 결과를 CompletableFuture 의 형태로 반환한다.
        CompletableFuture<String> getHello = CompletableFuture.supplyAsync(() -> {
            takeTime(false);
            return "완료";
        });

        System.out.println("- - - -get 사용전- - -");

        // Future 처럼 get 을 사용하면 Blocking 이 발생한다.
        // 값을 받아올 떄까지 다음 코드의 진행을 막는다. ( 비동기가 아니게 된다 )
        String hello = getHello.get();

        System.out.println("- - -get 사용 후- - -");
        System.out.println(hello);
    }

    public static void thenAcceptEx1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> getHello = CompletableFuture.supplyAsync(() -> {
            System.out.println("값을 받아오기 시작");
            takeTime(false);
            return "완료";
        });

        // thenAccept : 받아온 값을 Consumer 로 실행
        // 이전 과정으로부터 얻은 값으로 할 일을 지정한다. ( 비동기 )
        // 여기에서는 일을 정해두기만 할 뿐, 호출은 get으로 ( 동기 )
        // get 으로 호출해도, supplyAsync 작업이 끝나고 나서 실행
        CompletableFuture<Void> printHello = getHello.thenAccept(s -> {
            System.out.println("받아온 값을 처리한다");
            takeTime(false);
            System.out.println(s);
        });

        System.out.println("- - - -thenAcceptEx1 실행 중- - - - -");

        printHello.get();
    }

    public static void thenAcceptEx2 () throws ExecutionException, InterruptedException {
        // 비동기 메소드 체이닝
        CompletableFuture<Void> print5nums = CompletableFuture.supplyAsync(() -> {
            List<Integer> ints = new ArrayList<>();
            IntStream.range(0, 5)
                    .forEach(i -> {
                        takeTime(false);
                        ints.add(i);
                    });
            return ints;
        }).thenAccept(list -> {
            takeTime(false);
            list.stream().forEach(System.out::println);
        });

        System.out.println("- - - -중간에 다른 코드들 진행- - -");

        print5nums.get();
    }

    public static void thenApplyEx1() throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            takeTime(false);
            return new Random().nextInt(0, 6) + 1;
        }).thenApply(
                // thenApply : 얻어온 값을 Function 에 넣어서 다른 값으로 반환
                // 스트림의 map 과 비슷하다.
                i -> {
                    takeTime(false);
                    return "이번 숫자 : " + i;
                }
        ).thenAccept(
                System.out::println
        ).get();
    }

    public static void thenApplyEx2 () throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            takeTime(false);
            return new Random().nextBoolean();

            // Apply 연속 사용
        }).thenApply(b -> {
            takeTime(false);
            return new SwordMan(b ? Side.RED : Side.BLUE);
        }).thenApply(s -> {
            takeTime(false);
            return s.toString();
        }).thenAccept(
                System.out::println
        ).get();
    }
}
