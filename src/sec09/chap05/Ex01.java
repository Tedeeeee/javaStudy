package src.sec09.chap05;

import java.util.stream.IntStream;

public class Ex01 {
    public static void main(String[] args) {
        IntStream
                .range(1, 100)
                .filter(i -> i % 2 == 0)
                //.skip(10) // 20의 자리부터 나온다.
                //.limit(10) // 앞에서부터 최대 갯수를 정해서 거기까지만 나오게 한다.
                //.map(i -> i * 10) // 모든 자리의 숫자에 10 을 곱한다.
                .forEach(System.out::println);

        System.out.println("- - - - - - - - - - - - - - -");

        String str1 = "Hello World! Welcome to the world of Java~";

        // 우리가 적은 문자를 char 기준으로 하나씩 추출하는 것이다.
        str1.chars().forEach(System.out::println);

        System.out.println("- - - - - - - - - - - - - - -");

        int str1MaxChar = (char) str1.chars()
                //.max()
                .min()
                .getAsInt(); // max 혹은 min 의 값을 int 로서 나타나오게 한다


        // 들어있는 모든 알파벳 문자들을 정렬해서 프린트한다
        str1.chars()
                //.sorted()
                //.distinct()
                .filter(i -> (i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z'))
                .forEach(i -> System.out.println((char) i));
    }
}
