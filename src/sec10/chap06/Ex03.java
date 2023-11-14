package src.sec10.chap06;

import src.sec09.chap05.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex03 {
    public static void main(String[] args) {
        var numFromOpt = IntStream.range(0, 101)
                // .parallel() // 병렬 실행
                .filter(i -> i % 2 == 1)

                // 첫번째 요소를 반환한다.
                .findFirst() // 항상 순서상 첫번째 것을 반환한다.
                // .findAny() // 병렬 작업 시에 먼저 나오는 것을 반환한다.

                // 병렬 작업을 할 시에 findAny 가 보다 효율적이다.
                // 물론 순서가 중요하지 않는다는 전제가 필요하다.

                // .max()
                // .min()

                // 평균값을 Double 로 반환한다.
                // .average()

                // .reduce((prev, curr) -> prev + curr)
                .orElse(-1); // Optional 이 반환 값이기에 사용한다.
                // 또는 기타 Optional 의 인스턴스 메소드를 사용한다.


        String[] names = {
                "강백호", "서태웅", "채치수", "송태섭", "정대만",
                "윤대협", "변덕규", "황태산", "안영수", "허태환",
                "이정환", "전호장", "신준섭", "고민구", "홍익현",
                "정우성", "신현철", "이명헌", "최동오", "정성구"
        };

        Stream<String> nameStream = Arrays.stream(names);

        Random random = new Random();
        random.setSeed(4);  // 균일한 결과를 위해 지정된 시드값을 셋팅한다.
        var people = nameStream
                .map(name -> new Person(
                        name,
                        random.nextInt(18, 35),
                        random.nextDouble(160, 190),
                        random.nextBoolean()
                ))
                .sorted()
                .toList();

        var personFromOpt = people.stream()
                // .filter(p -> !p.isMarried() && p.getAge() < 20 && p.getHeight() > 189)

                .findFirst()

                // .max(Comparator.comparingDouble(Person::getHeight))
                // .min(Comparator.comparingInt(Person::getAge))

                .orElse(new Person("엄친아", 19, 189.9, false));
    }
}
