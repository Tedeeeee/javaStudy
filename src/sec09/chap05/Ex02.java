package src.sec09.chap05;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex02 {
    public static void main(String[] args) {
        String[] names = {
                "강백호", "서태웅", "채치수", "송태섭", "정대만",
                "윤대협", "변덕규", "황태산", "안영수", "허태환",
                "이정환", "전호장", "신준섭", "고민구 ", "홍익현",
                "정우성", "신현철", "이명헌", "최동오", "정성구"
        };

        Stream<String> nameStream = Arrays.stream(names);

        Random random = new Random();
        random.setSeed(4); // 균일한 결과를 위한 지정된 시드값
        var people = nameStream
                .map(name -> new Person(
                        name,
                        random.nextInt(18, 35),
                        random.nextDouble(160, 190),
                        random.nextBoolean()
                ))
                // sorted 는 덮어씌워진다 마지막으로 작성된 sorted 를 기준으로 값이 정렬된다
                //.sorted()
                // 키를 오름차순으로 정렬
                //.sorted((p1, p2) -> p1.getHeight() > p2.getHeight() ? 1 : -1)
                // 기혼과 미혼의 구분
                .sorted((p1, p2) -> Boolean.compare(p1.isMarried(), p2.isMarried()))
                .toList();

        // collect, Collectors 의 기능
        // 이미 다룬 joining 도 이들의 기능 중 하나이다.

        var peopleLastNameSet = people.stream()
                .map(p -> p.getName().charAt(0))
                // 다양한 컬렉션이 존재한다
                //.collect(Collectors.toList());
                .collect(Collectors.toSet());
                //.collect(Collectors.toCollection(ArrayList::new));
                //.collect(Collectors.toCollection(LinkedList::new));
                //.collect(Collectors.toCollection(TreeSet::new));

        var nameAgeMap = people.stream()
                // 의미 없는 작업( 해시 맵은 순서가 정확하지 않다. 그래서 정렬을 하는 이유가 없기 때문에 IDE 에서는 제거를 추천한다. )
                //.sorted((p1, p2) -> p1.getAge() > p2.getAge() ? 1 : -1)
                .collect(Collectors.toMap(Person::getName, Person::getAge));

        // 스트림을 특정 기준에 따라서 그룹핑을 하는 방법을 알아보자
        var peopleHMapByMarried = people.stream()
                .collect(Collectors.groupingBy(Person::isMarried));
        List<Person> marrieds = peopleHMapByMarried.get(true);

        var peopleHMapByHeight = people.stream()
                .collect(Collectors.groupingBy(
                        // 일의 자리 숫자를 지우고 180 대 사람들을 추린다.
                        p -> ((int) p.getHeight() / 10) * 10
                ));

        List<Person> over180s = peopleHMapByHeight.get(180);

        var intHMapByOddEven= IntStream.range(0, 10).boxed()
                .collect(Collectors.groupingBy(
                        i -> i % 2 == 1 ? "홀" : "짝"
                ));
        List<Integer> odds = intHMapByOddEven.get("홀");

        IntSummaryStatistics ageStats = people.stream()
                .map(Person::getAge)
                .collect(Collectors.summarizingInt(Integer::intValue));

        DoubleSummaryStatistics heightStats = people.stream()
                .map(Person::getHeight)
                .collect(Collectors.summarizingDouble(Double::doubleValue));
    }
}
