package src.sec09.chap04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex01 {
    public static void main(String[] args) {
        // 이렇게 받아온 리스트를 Stream 을 통해 홀수만 골라내어 보자
        List<Integer> int0To9 = new ArrayList<>(
                Arrays.asList(5, 2, 0, 8, 4, 1, 7, 9, 3, 6)
        );

        List<Integer> odds = new ArrayList<>();
        for (var i : int0To9) {
            if (i % 2 == 1) odds.add(i);
        }
        odds.sort(Integer::compare);

        List<String> oddsStrs = new ArrayList<>();
        for (var i : odds) {
            oddsStrs.add(String.valueOf(i));
        }

        String oddsStr = String.join(", ", oddsStrs);
        System.out.println("oddsStr = " + oddsStr);

        // 위의 과정을 스트림을 통해 한번에 해결 할 수 있다.
        var oddsStrStreamed = int0To9
                .stream()
                .filter(i -> i % 2 == 1)
                .sorted(Integer::compareTo)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("oddsStrStreamed = " + oddsStrStreamed);


    }

}
