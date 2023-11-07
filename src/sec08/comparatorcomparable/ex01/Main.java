package src.sec08.comparatorcomparable.ex01;

import src.sec07.chap4.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Integer int1 = Integer.valueOf(1);
        Integer int2 = Integer.valueOf(2);
        Integer int3 = Integer.valueOf(3);

        int _1_comp_3 = int1.compareTo(3);
        int _2_comp_1 = int2.compareTo(1);
        int _3_comp_3 = int3.compareTo(3);
        int _t_comp_f = Boolean.valueOf(true).compareTo(Boolean.valueOf(false));
        int _abc_comp_def = "ABC".compareTo("DEF");
        int _def_comp_abc = "efgh".compareTo("abcd");

        Integer[] nums = {3, 8, 1, 7, 4, 9, 2, 6, 5};
        String[] strs = {
                "Fox", "Banana", "Elephant", "Car", "Apple", "Game", "Dice"
        };

        // Arrays 클래스의 sort 메소드
        // 기본적으로 compareTo에 의거하여 정렬한다
        // 인자가 없는 생성자로 생성된 TreeSet, TreeMap 도 마찬가지 이다.
        Arrays.sort(nums);
        Arrays.sort(strs);

        Arrays.sort(nums, new IntDescComp());

        // 인자로 들어간 수와 가까운수 ( 그중에서 큰 값 -> 작은 값 순으로 정렬 )
        Arrays.sort(nums, new CloseToInt(5));

        // 익명 클래스, 이후 람다로 사용할 수도 있다
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        // ArrayList 또한 sort 메소드를 사용할 수 있다.
        ArrayList<Integer> numsAry = new ArrayList<>(Arrays.asList(nums));
        numsAry.sort(new IntDescComp());

        // 짝수가 가장 앞으로 나오고 내림차순 정렬
        numsAry.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 % 2) - (o2 % 2);
            }
        });

        TreeSet<Unit> unitTSet = new TreeSet<>(new UnitSorter());
        for (var u : new Unit[]{
                new Knight(Side.BLUE),
                new Knight(Side.BLUE), // 중복
                new SwordMan(Side.RED),
                new SwordMan(Side.RED), // 중복
                new MagicKnight(Side.BLUE),
                new SwordMan(Side.BLUE),
                new MagicKnight(Side.RED),
                new Knight(Side.RED)
        }) {
            unitTSet.add(u);
        } // 구분되는 기준이 없는 인스턴스는 같은 것으로 인식되어 삽입이 불가능 하다.
    }
}
