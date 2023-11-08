package src.sec09.chap03;

import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        // 클래스의 클래스 메소드에 인자를 적용해서 실행한다.
        Function<Integer, String> intToStrLD = i -> String.valueOf(i);
        Function<Integer, String> intToStrMR = String::valueOf;
        String intToStr = intToStrMR.apply(123);

        UnaryOperator<String> toLCaseLD = s -> s.toLowerCase();
        UnaryOperator<String> toLCaseMR = String::toLowerCase;
        String toLCase = toLCaseMR.apply("HELLO");

        // 클래스의 생성자 실행
        Function<String, Button> strToButtonLD = s -> new Button(s);
        Function<String, Button> strToButtonMR = Button::new;
        Button button1 = strToButtonMR.apply("Dog");

        BiFunction<String, String, Button> twoStrToButtonLD = (s1, s2) -> new Button(s1, s2);
        BiFunction<String, String, Button> twoStrToButtonMR = Button::new;
        Button button2 = twoStrToButtonMR.apply("고양이", "야용");
        button2.onClick();

        System.out.println("- - - - - - - - - -");

        Runnable catCryLD = () -> button2.onClick();
        Runnable catCryMR = button2::onClick;
        catCryMR.run();

        // 임의의 인스턴스의 메소드 참조
        TreeSet<String> treeSetLD = new TreeSet<>((s1, s2) -> s1.compareTo(s2));
        TreeSet<String> treeSetMR = new TreeSet<>(String::compareTo);
    }
}
