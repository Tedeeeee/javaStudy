package src.sec08.comparatorcomparable.ex01;

import java.util.Comparator;

public class IntDescComp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
        // 원래 o1 이랑 o2 랑 비교해서 음수면 가만히 0도 가만히 양수가 바꾸는건데
        // o2 랑 o1 이랑 바뀌게 되어버린거임

        // 설명하자면 내림차순의 기준이 이렇게 되어있었다 ( 1, 3 )
        // o1(2) > o2(1) return 1  == 양수? 바꿔
        // o1(3) == o2(3) return 0 == 같은 수? 바꾸지마
        // o1(1) < o2(2) return -1 == 음수? 바꾸지마 -> 여기에 걸림

        // 근데 이게 숫자만 바뀌어 버린거야 ( 1, 3 )
        // o2 > o1 return 1 == 양수 ? 바꿔 -> 여기에 걸림 그래서 바뀌어 버림
        // o2 == o1 return 0 == 같은 수? 바꾸지마
        // o2 < o1 return -1 == 음수? 바꾸지마

        // 이렇게 return 값은 같은데 if 의 조건을 바꿔버린거임
    }
}
