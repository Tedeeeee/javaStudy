package src.sec08.set;

import src.sec07.chap4.Knight;
import src.sec07.chap4.Side;
import src.sec07.chap4.SwordMan;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> intHSet1 = new HashSet<>();
        intHSet1.add(1);
        intHSet1.add(1);
        intHSet1.add(2);
        intHSet1.add(3);

        // 1 이 중복되었기 때문에 이 값은 다시 저장되지 않는다.
        // 때문에 실질적으로 저장은 1,2,3 만 되었다.
        for (var i : intHSet1) {
            System.out.println(i);
        }

        List<Integer> ints1 = new ArrayList<>(
                Arrays.asList(1, 1, 2, 2, 3, 3, 4, 7, 6, 5)
        );

        // 이 또한 Array 배열에 중복값이 존재하기 때문에 중복값은 단 한번만 저장 될 것이다.
        Set<Integer> intHSet2 = new HashSet<>(ints1);

        ints1.clear();
        // addAll 을 하면 intHSet 의 값을 가져오는 것이 아니라 Size 를 가져온다. 그럼 size 만큼의 숫자를 나열해서 저장한다.
        // 떄문에 7개의 사이즈 = 0 ~ 6 까지 저장되는 것이다.
        ints1.addAll(intHSet2);

        /**
         *  HashSet 을 사용하는 방식
         *  - 동일한 입력 값 -> 언제나 동일한 출력 값
         *  - 값마다의 고유한 정수값을 해시값으로 저장한다
         *      - 이 값을 기준으로 정렬하게 된다
         *  - 일정 갯수까지는 정렬을 하고 이를 넘어서게 되면 재조정에 들어간다
         *      - 즉, 정렬을 위해 만들어진 것은 아니라는 것이다.
         */

        // List 에서의 기능과 똑같다 ( 존재 여부 )
        boolean has2 = intHSet1.contains(2);
        boolean has4 = intHSet1.contains(4);

        // 요소를 삭제, 있었는지 여부를 반환한다.
        boolean rm3 = intHSet1.remove(3);
        boolean rm4 = intHSet1.remove(4);

        // 다른 컬렉션 기준으로 내용을 삭제 한다.
        // 이것또한 size 를 기준으로 한다.
        // intHSet.size = 2 이기 때문에 intHSet2 의 size 가 2가 줄면서 5가 되고 안에 값은 0 ~ 4 가 된다.
        intHSet2.removeAll(intHSet1);

        // size , isEmpty, clear, clone 등의 메소드가 있다

        //-------------------------------------------------------------------
        // 참조형 관련
        Set<SwordMan> swordManSet = new HashSet<>();
        SwordMan swordMan = new SwordMan(Side.RED);

        // 인스턴스 생성을 통해 만든 변수로 넣는다면 그 객체를 넣는 것이기 떄문에 중복값으로 찾는다.
        swordManSet.add(swordMan);
        swordManSet.add(swordMan);
        // 하지만 인자에서 new 를 해준다면 생성할때마다 새로운 객체를 저장한다.
        swordManSet.add(new SwordMan(Side.RED));
        swordManSet.add(new SwordMan(Side.RED));

        // 떄문에 remove 또한 변수의 객체를 찾아 지우는 것이다.
        swordManSet.remove(swordMan);

        //-------------------------------------------------------------------
        // HashSet, LinkedHashSet, TreeSet 의 사용

        HashSet<Integer> intHashSet = new HashSet<>();
        LinkedHashSet<Integer> intLinkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> intTreeSet = new TreeSet<>();

        for (int i : new int[] {3, 1, 8, 5, 4, 7, 2, 9, 6}) {
            intHashSet.add(i);
            intLinkedHashSet.add(i);
            intTreeSet.add(i);
        }

        for (var s : new Set[] {intHashSet, intLinkedHashSet, intTreeSet}) {
            System.out.println(s);
        }

        /**
         *  LinkedHashSet : 입력된 순서대로 출력, TreeSet : 오름차순을 기준으로 정렬
         *  HashSet 은 정렬된 것 처럼 보이지만 보장되지 않았다. 특정 조건에 의해 정렬된 것 처럼 보이는 것 뿐이다.
         */

        Set<String> strHashSet = new HashSet<>();
        Set<String> strLinkedHashSet = new LinkedHashSet<>();
        TreeSet<String> strTreeSet = new TreeSet<>();

        for (String s : new String[]{"Fox", "Banana", "Elephant", "Car", "Apple", "Game", "Dice"}) {
            strHashSet.add(s);
            strLinkedHashSet.add(s);
            strTreeSet.add(s);
        }

        for (var s : new Set[]{strHashSet, strLinkedHashSet, strTreeSet}) {
            System.out.println(s);
        }

        /**
         *  여기서 Hash 와 Tree 의 정렬 기준을 볼 수 있다.
         */

        // TreeSet 의 주요 메소드들
        int firstInt = intTreeSet.first();
        String lastStr = strTreeSet.last();

        // ceiling : 같은 것이 없다면 트리 구조상 바로 위의 것의 반환한다 ( 더 큰 것을 반환한다 )
        String foxCeiling = strTreeSet.ceiling("Fox");
        String creamCeiling = strTreeSet.ceiling("Cream");

        // floor : 같은 것이 없다면 트리 구조 상 바로 아래의 것을 반환한다.
        String foxFloor = strTreeSet.floor("Fox");
        String diceFloor = strTreeSet.floor("Cream");

        // 맨 앞에서 or 뒤에서 제거한다
        int pollFirst1 = intTreeSet.pollFirst();
        int pollFirst2 = intTreeSet.pollFirst();

        int pollLast1 = intTreeSet.pollLast();
        int pollLast2 = intTreeSet.pollLast();

        // 오름차순을 기준으로 만든 트리를 내림차순으로 바꿔주는 방법
        Set<String> strTreeSetDesc = (TreeSet<String>) strTreeSet.descendingSet();

        // 요소 추가가 불가능 하다, 같은 객체끼리 서열을 나눠 줄 수가 없다. = 정렬할 방법이 정해지지 않았기 때문에 이런 것이다.
        // Comparable or Comparator 가 필요하다.
        TreeSet<Knight> knightSet1 = new TreeSet<>();
        knightSet1.add(new Knight(Side.BLUE));
        knightSet1.add(new Knight(Side.BLUE));
        knightSet1.add(new Knight(Side.BLUE));
    }
}
