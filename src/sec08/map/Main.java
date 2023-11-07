package src.sec08.map;

import src.sec07.chap4.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> numNameHMap = new HashMap<>();
        // put 메소드를 사용하여 key 와 value 삽입
        numNameHMap.put(1, "홍길동");
        numNameHMap.put(2, "전우치");
        numNameHMap.put(3, "임꺽정");

        Map<String, Double> nameHeightHMap = new HashMap<>();
        nameHeightHMap.put("김철수", 176.8);
        nameHeightHMap.put("이장신", 187.4);
        nameHeightHMap.put("박숏달", 152.3);
        nameHeightHMap.put("정기준", 171.2);

        Map<Side, ArrayList<Unit>> sideUnitsHMap = new HashMap<>();
        sideUnitsHMap.put(
                Side.BLUE,
                new ArrayList<>(
                        Arrays.asList(
                                new SwordMan(Side.BLUE),
                                new Knight(Side.BLUE),
                                new MagicKnight(Side.BLUE)
                        )
                )
        );

        sideUnitsHMap.put(
                Side.RED,
                new ArrayList<>(
                        Arrays.asList(
                                new Knight(Side.RED),
                                new Knight(Side.RED),
                                new Knight(Side.RED)
                        )
                )
        );

        Map<Integer, String> numNameHMapClone = new HashMap<>();
        // putAll : 대상 맵으로부터 전부 가져온다.
        numNameHMapClone.putAll(numNameHMap);

        // get 메소드에 key 를 넣어 값을 접근한다.
        String no2 = numNameHMap.get(2);
        Double leeHeight = nameHeightHMap.get("이장신");
        // 잘못된 key 를 입력한다면 null 을 반환한다.
        String wrong1 = numNameHMap.get(0);
        Double wrong2 = nameHeightHMap.get(3);

        // KeySet 메소드 - key 들의 Set(인터페이스)을 반환한다.
        Set<Integer> numSet = numNameHMap.keySet();
        Set<Integer> numHSet = new HashSet<>();
        numHSet.addAll(numSet);

        // keySet 을 활용한 값 가져오기
        for (var n : numNameHMap.keySet()) {
            System.out.println(numNameHMap.get(n));
        }

        for (var side : sideUnitsHMap.keySet()) {
            for (var unit : sideUnitsHMap.get(side)) {
                System.out.println(unit);
            }
        }

        // containsKey & containsValue : 키 / 값 포함되는 쌍이 있는지 확인한다.
        boolean contains1 = nameHeightHMap.containsKey("박숏딜");
        boolean contains2 = nameHeightHMap.containsKey("장롱달");
        boolean contains3 = nameHeightHMap.containsValue(171.2);

        System.out.println("\n- - - - - - - - -\n");

        Map<Attacker, Horse> atkrHrsHMap = new HashMap<>();

        SwordMan kenshin = new SwordMan(Side.RED);
        Knight lancelot = new Knight(Side.BLUE);

        atkrHrsHMap.put(kenshin, new Horse(40));
        atkrHrsHMap.put(lancelot, new Horse(50));
        atkrHrsHMap.put(new MagicKnight(Side.BLUE), new Horse(60));

        // key 의 값이 참조형일 경우 변수 등에 저장되어 있어야 한다.
        // set 에서 보았듯이 참조형을 기준으로 값을 가져올때는 변수로 저장되어 있어야 한다는 것이다. 그래야 그 객체를 기준으로 저장되어있는 Map 형태의 값을 가져올 수 있다.
        Horse kenshinHorse = atkrHrsHMap.get(kenshin);
        Horse lancelotHorse = atkrHrsHMap.get(lancelot);

        // new 를 통해 저장되어 있는 값을 꺼낼 순 없음
        // 위에서 MagicKnight 를 저장했지만 new 를 통해 저장되었기 때문에 꺼낼 방법이 없다.
        Horse wrongHorse = atkrHrsHMap.get(new MagicKnight(Side.BLUE));

        // 꺼내려면 전체를 뒤짚어 엎어서 그중 하나만 찾아내야한다.
        for (var u : atkrHrsHMap.keySet()) {
            System.out.println(u + " : " + atkrHrsHMap.get(u));
        }

        
    }
}
