package src.sec09.chap05;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
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
                .sorted()  // 정렬하기 ( 값 : 대문자 < 소문자 )
                //.distinct() // 중복된 값을 없애기
                .filter(i -> (i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z'))
                .forEach(i -> System.out.println((char) i));

        System.out.println("- - - - - - - - - - - - -");

        // 대소문자 구분 없이 중복 제거를 한 뒤에 정렬하고 쉼표로 구분한다
        var fromStr1 = str1.chars().boxed()
                // chars() 가 타입을 IntStream 으로 바꿔준다.
                // 박스를 사용하여 Stream<Integer>로 변환
                // 요소를 다른 타입으로 바꾸려면 Stream<T> 를 사용해야한다.
                .map(i -> String.valueOf((char) i.intValue()))
                //.map(String::toUpperCase)
                //.filter(s -> Character.isLetter(s.charAt(0)))
                //.sorted()
                //.distinct()
                .collect(Collectors.joining(", "));


        var oddSquareR = IntStream.range(0, 10).boxed()
                .peek(i -> System.out.println("초기값 : " + i))
                .filter(i -> i % 2 == 1)
                .peek(i -> System.out.println("홀수만 : " + i))
                .map(i -> i * i)
                .peek(i -> System.out.println("제곱 : " + i))
                .sorted((i1, i2) -> i1 < i2 ? 1 : -1)
                .peek(i -> System.out.println("역순 : " + i))
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("- - - - - - - - - - - -");

        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // allMatch / anyMatch : 모든 요소가 / 어느 한 요소라도
        // 주어진 Predicate 에 부합하는가? 여부를 반환한다.
        boolean intsMatch = Arrays.stream(ints)
                //.allMatch(i -> i > 0)
                //.allMatch(i -> i % 2 == 0)
                //.anyMatch(i -> i < 0)
                .anyMatch(i -> i % 2 == 0);


        // takeWhile / dropWhile 주어진 Predicate 를 충족시킬 때까지 취함 / 건너뛴다.
        // count : 중간 과정을 거친 요소들의 갯수를 반환한다.
        long afterWhileOp = Arrays.stream(ints)
                //.takeWhile(i -> i < 4)
                .dropWhile(i -> i < 4)
                .peek(System.out::println)
                .count();

        System.out.println("- - - - - - -");

        // sum : IntStream, LongStream, DoubleStream 요소의 총합 반환
        int intsSum = IntStream.rangeClosed(0 , 100)
                //.filter(i -> i % 2 == 1)
                .filter(i -> i % 2 == 0)
                //.filter(i -> i % 3 == 0)
                .peek(System.out::println)
                .sum();

        System.out.println("- - - - - - - - -");

        double doubleSum = DoubleStream.iterate(3.14, i -> i * 2)
                .limit(10)
                .peek(System.out::println)
                .sum();

        System.out.println("- - - - - - - -");

        // reduce : 주어진 BiFunction 으로 값을 접어나간다
        // seed 값이 없다면 : Optional 반환을 한다 ( 빈 스트림일 가능성이 있다 )
        int intReduce = IntStream.range(1, 10)
                //.filter(i -> i % 2 == 1)
                .reduce((prev, curr) -> {
                    System.out.printf("prev : %d, cur : %d%n", prev, curr);
                    return prev * curr;
                })
                .getAsInt(); // 혹시 빈 스트임을 위해서 필요함

        // 만약 seed 값을 정해준 상태로 진행한다면
        // 이곳에 getAsInt() 메소드가 안붙는 이유는 seed 가 2 로 정해져 있기때문에 getAsInt 로 만약 없다는 가정이 필요가 없기 때문에 안붙어도 된다.
        int intReduceWithDeed = IntStream.range(1, 10)
                .reduce(2,(prev, curr) -> prev * curr);

        StringStat stringStat = "Hello World! Welcome to the world of Java~"
                .chars()
                .boxed()
                .reduce(
                        new StringStat(),
                        (ss, i) -> {
                            ss.length++;
                            if (i >= 'A' && i <= 'Z') {
                                ss.upperCases++;
                            } else if (i >= 'a' && i <= 'z') {
                                ss.lowerCases++;
                            } else {
                                ss.nonLetters++;
                            }
                            return ss;
                        },
                        // 아래의 combiner 인자는 병렬 연산에서만 작용한다
                        // 요소와 다른 타입을 반환하는 오버로드의 필수 인자이므로 임의로 넣을수 있다.
                        (ss1, ss2) -> ss1
                );

    }
    public static class StringStat {
        int length = 0;
        int upperCases = 0;
        int lowerCases = 0;
        int nonLetters = 0;
    }

}
