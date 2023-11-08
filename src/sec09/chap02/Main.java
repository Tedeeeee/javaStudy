package src.sec09.chap02;

import src.sec07.chap4.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        // Runnable : run() 메소드 사용
        // 인자도 반환값도 없다.
        Runnable dogButtonFunc = () -> System.out.println("멍멍");
        Runnable catButtonFunc = () -> System.out.println("야옹");
        Runnable cowButtonFunc = () -> System.out.println("음매");

        dogButtonFunc.run();
        catButtonFunc.run();
        cowButtonFunc.run();

        System.out.println("- - - - - - - - - -");

        Button dogButton = new Button("강아지");
        dogButton.setOnClickListener(dogButtonFunc);

        Button catButton = new Button("고양이");
        catButton.setOnClickListener(() -> {
            System.out.println("- - - - - - - -");
            System.out.println(catButton.getText() + " 울음소리 : 야옹야옹");
            System.out.println("- - - - - - - -");
        });

        dogButton.onClick();
        catButton.onClick();

        // Supplier : get() 메소드 사용
        // 인자 값은 없지만 반환값은 존재한다.
        Supplier<String> appName = () -> "얄코 오피스";
        Supplier<Double> rand0to10 = () -> Math.random() * 10;
        Supplier<Boolean> randTF = () -> Math.random() > 0.5;

        var supp1 = appName.get();
        var supp2 = rand0to10.get();
        var supp3 = randTF.get();

        System.out.println(supp1);
        System.out.println(supp2);
        System.out.println(supp3);

        System.out.println("- - - - - - - -");

        // Consumer : accept() 메소드 사용
        // 인자 값은 있지만 반환값 타입은 없다.
        Consumer<Integer> sayOddEven = i -> System.out.printf(
                "%d은 %c수입니다.%n", i, "짝홀".charAt(i % 2)
        );

        Consumer<Button> clickButton = b -> b.onClick();

        // BiConsumer : accept() 메소드 사용
        // 인자는 두 개를 받지만 반환 값 타입은 따로 정해놓지 않는다.
        BiConsumer<Button, Integer> clickButtonNTimes = (b, n) -> {
            for (var i = 0; i < n; i++) { b.onClick();}
        };

        sayOddEven.accept(3);
        sayOddEven.accept(4);
        clickButton.accept(catButton);
        clickButtonNTimes.accept(dogButton, 5);

        System.out.println("- - - - - - - - - -");

        // Function : apply() 메소드를 사용
        // 인자값(T) 가 존재하고 반환값(R) 타입도 존재한다.
        Function<Integer, Boolean> isOdd = i -> i % 2 == 1;
        Function<String, Button> getButton = s -> new Button(s);

        Boolean isOdd3 = isOdd.apply(3);
        Boolean isOdd4 = isOdd.apply(4);

        Button goatButton = getButton.apply("염소");

        // BiFunction : apply() 메소드 사용
        // 인자 값(T, U) 과 반환 값(R) 값이 존재한다
        BiFunction<Unit, Horse, Integer> getFullHp = (u, h) -> {
            h.setRider(u);
            return u.getHp();
        };

        BiFunction<String, Runnable, Button> getButtonWFunc = (s, r) -> {
            var b = new Button(s);
            b.setOnClickListener(r);
            return b;
        };

        Integer unitFullHp = getFullHp.apply(
                new MagicKnight(Side.RED), new Horse(80)
        );

        getButtonWFunc.apply(
                "오리", () -> System.out.println("꽥꽥")
        ).onClick();

        // Predicate : test() 메소드 사용
        // 인자는 받지만 반환값은 boolean 으로 고정이다.
        Predicate<Integer> isOddTester = i -> i % 2 == 1;
        Predicate<String> isAllLowerCase = s -> s.equals(s.toLowerCase());

        boolean isOddT3 = isOddTester.test(3);
        boolean isOddT4 = isOddTester.test(4);
        boolean isAL1 = isAllLowerCase.test("Hello");
        boolean isAL2 = isAllLowerCase.test("world");

        // BiPredicate : test() 메소드 사용
        // 인자 타입은 두 개를 받고 반환값은 boolean 값을 반환한다.
        BiPredicate<Character, Integer> areSameCharNum = (c, i) -> (int) c == i;
        BiPredicate<Unit, Unit> areSameSide = (u1, u2) -> u1.getSide() == u2.getSide();

        boolean areSameCN1 = areSameCharNum.test('A', 64);
        boolean areSameCN2 = areSameCharNum.test('A', 65);

        boolean areSameSide1 = areSameSide.test(
                new Knight(Side.RED), new Knight(Side.BLUE)
        );

        boolean areSameSide2 = areSameSide.test(
                new SwordMan(Side.BLUE), new MagicKnight(Side.BLUE)
        );

        // UnaryOperator : apply() 메소드
        // 인자와 반환값이 존재하고 이는 똑같은 타입이다.
        UnaryOperator<Integer> square = i -> i * i;
        UnaryOperator<SwordMan> respawn = s -> {
            if (s instanceof MagicKnight) return new MagicKnight(s.getSide());
            if (s instanceof Knight) return new Knight(s.getSide());
            return new SwordMan(s.getSide());
        };

        Integer squared = square.apply(3);
        var respawned1 = respawn.apply(new Knight(Side.BLUE));
        var respawned2 = respawn.apply(new MagicKnight(Side.BLUE));

        // BinaryOperator : apply() 메소드
        // 인자와 반환 타입이 같지만 인자를 두개로 받는다. 물론 두개다 같은 타입이다.
        BinaryOperator<Double> addTwo = (i, j) -> i + j;
        BinaryOperator<SwordMan> getWinner = (s1, s2) -> {
            while (s1.getHp() > 0 && s2.getHp() > 0) {
                s1.defaultAttack(s2);
                s2.defaultAttack(s1);
                if (s1 instanceof MagicKnight) {
                    ((MagicKnight) s1).lighteningAttack(new SwordMan[]{s2});
                }
                if (s2 instanceof MagicKnight) {
                    ((MagicKnight) s2).lighteningAttack(new SwordMan[]{s1});
                }
            }
            if (s1.getHp() > 0) return s1;
            if (s2.getHp() > 0) return s2;
            return null;
        };

        Double added = addTwo.apply(12.34, 23.45);

        Unit winner1 = getWinner.apply(new SwordMan(Side.RED), new Knight(Side.BLUE));
        Unit winner2 = getWinner.apply(new MagicKnight(Side.RED), new Knight(Side.BLUE));
        Unit winner3 = getWinner.apply(new SwordMan(Side.RED), new MagicKnight(Side.BLUE));
        Unit winner4 = getWinner.apply(new MagicKnight(Side.RED), new MagicKnight(Side.BLUE));

        System.out.println("- - - - - - - - - - -");

        // Iterable 인터페이스의 forEach 메소드
        // - 곧 배울 스트림의 forEach 와는 다르다. ( 기능은 같다 )
        // - Consumer 를 인자로 받아 실행
        // - Iterator를 쓸 수 있는 클래스에서 사용 가능
        new ArrayList<>(
                Arrays.asList("하나", "둘", "셋", "넷", "댜섯")
        ).forEach(s -> System.out.println(s));

        System.out.println("- - - - - - - - - - -");

        HashMap<String, Character> subjectGradeHM = new HashMap<>();
        subjectGradeHM.put("English", 'B');
        subjectGradeHM.put("Math", 'C');
        subjectGradeHM.put("Programming", 'A');

        // BiConsumer 를 받는다.
        subjectGradeHM.forEach(
                (s, g) -> System.out.println(
                        "%s : %c".formatted(s, g)
                )
        );
    }
}
