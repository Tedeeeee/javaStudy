package src.sec10.chap06;

import src.sec07.chap4.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

public class Ex02 {
    public static void main(String[] args) {
        // Optional 만들기
        // of : 담으려는 것이 확실히 있을 때
        Optional<String> catOpt = Optional.of("Cat");

        // of 로 null 을 담게 되면 NPE 를 발생한다.
        // catOpt = Optional.of(null);

        // 하지만 담으려는 것이 null 일수도 있는데 그때엔 ofNullable 을 사용하면 된다.
        Optional<String> dogOpt = Optional.ofNullable("Dog");
        Optional<String> cowOpt = Optional.ofNullable(null);

        // 명시적으로 null 을 담으려면 empty 메소드를 사용하면 된다.
        Optional<String> henOpt = Optional.empty();

        Optional<String> catOpt1 = getCatOpt();

        // List 안에 객체를 Optional 형태로 받는다. return 값은 물론 Optional 이다.
        List<Optional<Unit>> randomUnitOpts = new ArrayList<>();
        IntStream.range(0, 20).forEach(i -> randomUnitOpts.add(randomUnitOpt()));

        // Optional 값 사용하기
        randomUnitOpts.stream()
                .forEach(opt -> System.out.println(
                        opt.isPresent() // 있다면 true 를 반환한다
                        // opt.isEmpty() // 없다면 true 를 반환한다

                        // opt.get() // 있다면 반환, 없다면 NPE

                        // 없을 시에는 다른 것을 반환한다. ( 기본값으로 사용한다. )
                        // opt.orElse(new SwordMan(Side.RED))
                ));

        System.out.println("\n- - - - - - - - - - - - - - -\n");

        // ifPresent 는 Consumer 를 사용한다. 람다를 많이 사용한다.
        // ifPresentOrElse 는 값이 없다면 runner 로 다른 값을 내보낸다.
        randomUnitOpts.stream()
                .forEach(opt -> {
                    // 있다면 때 실행하게 될 Consumer
                    // opt.ifPresent(unit -> System.out.println(unit));

                    // 있다면 실행할 Consumer, 없다면 실행할 Runner
                    opt.ifPresentOrElse(
                            unit -> System.out.println(unit),
                            () -> System.out.println("(유닛이 없다)")
                    );
                });

        System.out.println("\n- - - - - - - - - - - - - - -\n");

        List<Optional<Integer>> optInts = new ArrayList<>();
        IntStream.range(0, 20)
                .forEach(i -> {
                    optInts.add(Optional.ofNullable(
                            new Random().nextBoolean() ? i : null
                    ));
                });

        System.out.println("optInts = " + optInts);

        // Optional 의 filter 와 map 메소드
        optInts.stream()
                .forEach(opt -> {
                    System.out.println(
                            opt
                                    .filter(i -> i % 2 == 1)
                                    .map(i -> "%d 출력".formatted(i))
                                    .orElse("(SKIP)")
                    );
                });

    }

    public static Optional<String> getCatOpt() {
        return Optional.ofNullable(
                new Random().nextBoolean() ? "Cat" : null
        );
    }

    public static Optional<Unit> randomUnitOpt() {
        switch (new Random().nextInt(0, 3)) {

            // 각각의 return 문을 가지고 있기에 break 필요는 없다.
            case 0:
                return Optional.of(new Knight(Side.BLUE));
            case 1:
                return Optional.of(new MagicKnight(Side.BLUE));
            default:
                return Optional.empty();
        }
        // Optinal 을 반환하는 메소드는 null을 반환하도록 하지 말아야 한다.
        // 대신 빈 Optinal 을 반환한다. ( Optional.empty )
        // NPE 를 방지하기 위한 메소드
    }
}
