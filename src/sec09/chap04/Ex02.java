package src.sec09.chap04;

import src.sec07.chap4.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex02 {
    public static void main(String[] args) {

        // 배열의 생성을 스트림으로 하는 방법
        Integer[] integerAry = {1, 2, 3, 4, 5};
        Stream<Integer> fromArray = Arrays.stream(integerAry);
        var fromArray_Arr = fromArray.toArray();

        System.out.println("fromArray_Arr = " + Arrays.toString(fromArray_Arr));
        System.out.println("- - - - - - - - - - - - - - - - -");

        // Stream 은 Iterator.hasNext 처럼 한번 지나가 버리면 다시 주워담을 수 없다.
        // var ifReuse = fromArray.toArray();

        // 원시값의 배열로부터는 스트림의 클래스가 달라진다.
        // int = IntStream , Double = DoubleStream 과 같이 원시 타입은 Stream 으로써 반환값이 클래스가 따로 정해져있다.
        int[] intAry = {1, 2, 3, 4, 5};
        IntStream fromIntAry = Arrays.stream(intAry);
        int[] fromIntAry_Arr = fromIntAry.toArray();

        System.out.println("fromIntAry_Arr = " + Arrays.toString(fromIntAry_Arr));
        System.out.println("- - - - - - - - - - - - - - - - -");

        double[] dblAry = {1.1, 2.2, 3.3};
        DoubleStream fromDblAry = Arrays.stream(dblAry);
        double[] fromDblAry_Arr = fromDblAry.toArray();

        System.out.println("fromDblAry_Arr = " + Arrays.toString(fromDblAry_Arr));
        System.out.println("- - - - - - - - - - - - - - - - -");

        // 값들로 직접 생성한다
        IntStream withInts = IntStream.of(1, 2, 3, 4, 5);
        Stream<Integer> withIntegers = Stream.of(1, 2, 3, 4, 5);
        Stream<Unit> withUnits = Stream.of(
                new SwordMan(Side.BLUE),
                new Knight(Side.BLUE),
                new MagicKnight(Side.BLUE)
        );

        var withUnits_Arr = withUnits.toArray();

        // 컬렉션으로부터 생성
        // List 의 경우
        List<Integer> intAryList = new ArrayList<>(Arrays.asList(integerAry));
        Stream fromColl1 = intAryList.stream();
        var fromColl1_Arr = fromColl1.toArray();

        System.out.println("fromColl1_Arr = " + Arrays.toString(fromColl1_Arr));
        System.out.println("- - - - - - - - - - - - - - - - -");

        // Map 의 경우
        Map<String, Character> subjectGradeHM = new HashMap<>();
        subjectGradeHM.put("English", 'B');
        subjectGradeHM.put("Math", 'C');
        subjectGradeHM.put("Programming", 'A');
        var fromHashMap_Arr = subjectGradeHM.entrySet().stream().toArray();

        System.out.println("fromHashMap_Arr = " + Arrays.toString(fromHashMap_Arr));
        System.out.println("- - - - - - - - - - - - - - - - -");

        // 빌더로 생성하는 법
        Stream.Builder<Character> builder = Stream.builder();
        builder.accept('스');
        builder.accept('트');
        builder.accept('림');
        builder.accept('빌');
        builder.accept('더');
        Stream<Character> withBuilder = builder.build();
        var array = withBuilder.toArray();

        Stream<Integer> toConcat1 = Stream.of(11, 22, 33);
        Stream<Integer> toConcat2 = Stream.of(44, 55, 66);
        Stream<Integer> withConcatMethod = Stream.concat(toConcat1, toConcat2);
        var withConcatMethod_Arr = withConcatMethod.toArray();

        // 이터레이터로 생성하는 것도 가능하다.
        // - 인자 : 초기값, 다음 값을 구하는 람다 함수
        // - limit 으로 횟수를 지정해야한다.
        Stream<Integer> withIter1 = Stream
                .iterate(0, i -> i + 2)
                .limit(10);
        var withIter1_Arr = withIter1.toArray();

        Stream<String> withIter2 = Stream
                .iterate("홀", s -> s + (s.endsWith("홀") ? "짝" : "홀"))
                .limit(8);
        var withIter2_Arr = withIter2.toArray();

        // 원시자료형 스트림의 기능들로 생성이 가능
        IntStream fromRange1 = IntStream.range(10, 20); // 20은 포함되지 않는다.
        IntStream fromRange2 = IntStream.rangeClosed(10, 20); // 20이 포함되어 만들어진다.

        // 위에 만들어진 값은 원시 타입에 Stream 지원을 해준 것이다.
        // 하지만  int 자체로는 Collection 에 담지 못하기 떄문에 Integer 로 변환하여 toArray() 를 사용해야한다.
        Stream<Integer> fromRangeBox = fromRange1.boxed();
        var fromRangeBox_Arr = fromRangeBox.toArray();

        // Random 클래스의 스트림 생성 메소드들이 있다.
        IntStream randomInts = new Random().ints(5, 0, 100);
        var randomInts_Arr = randomInts.toArray();

        DoubleStream randomDbls = new Random().doubles(5, 2, 3);
        var randomDbls_Arr = randomDbls.toArray();

        // 문자열을 각 문자에 해당하는 정수의 스트림으로
        IntStream fromString = "Hello World".chars();
        var fromString_Arr = fromString.toArray();

        // 주어진 파일을 가지고도 생성할 수 있다.
        // File I/O
        Stream<String> fromFile;
        Path path = Path.of("./src/sec09/chap04/turtle.txt");
        try {
            fromFile = Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var fromFile_Arr = fromFile.toArray();

        // 아무것도 없는 비어있는 파일또한 만들수 있다.
        Stream<Double> emptyDblStream = Stream.empty();
    }
}

