package src.sec08.iterator;

import src.sec07.chap4.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        Set<Integer> intHSet = new HashSet<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
        );

        // 이터레이터 반환 및 초기화
        // 기타 Collection 인터페이스를 구현한 클래스들에도 존재한다.
        Iterator<Integer> intItor = intHSet.iterator();

        // next : 자리를 옮겨 다니며 다음 요소를 반환한다.
        Integer int1 = intItor.next();
        Integer int2 = intItor.next();
        Integer int3 = intItor.next();

        // hasNext : 순회가 끝났는지 여부 반환
        boolean hasNext = intItor.hasNext();

        // 순회를 초기화 한다.
        intItor = intHSet.iterator();

        // 현 위치에 요소를 삭제
        while (intItor.hasNext()) {
            if (intItor.next() % 3 == 0) {
                intItor.remove();
            }
        }

        // for 문을 사용한 반복문에서는 사용할 수 없다.
        // forEach 문에서 Collection 의 요소를 삭제하는것은 금지되어 있다.
        // 이유는 Collection 을 반복하는 동안 해당 요소를 수정, 삭제가 발생하면서 쓰레드에 의한 동시성 문제가 발생한다.
        for (Integer num : intHSet) {
            if (num % 3 == 0) {
                intHSet.remove(num);
            }
        }

        List<Unit> enemies = new ArrayList<>(
                Arrays.asList(
                        new SwordMan(Side.RED),
                        new Knight(Side.RED),
                        new SwordMan(Side.RED),
                        new SwordMan(Side.RED),
                        new Knight(Side.RED),
                        new Knight(Side.RED),
                        new SwordMan(Side.RED),
                        new MagicKnight(Side.RED),
                        new SwordMan(Side.RED),
                        new MagicKnight(Side.RED),
                        new Knight(Side.RED),
                        new MagicKnight(Side.RED))
        );

        Iterator<Unit> enemyItor = enemies.iterator();

        var thunderBolts = 3;
        var fireBalls = 4;

        while (enemyItor.hasNext() && thunderBolts-- > 0) {
            var enemy = enemyItor.next();
            System.out.printf("%s 벼락 공격%n", enemy);
            enemy.setHp(enemy.getHp() - 50);
        }
        while (enemyItor.hasNext() && fireBalls-- > 0) {
            var enemy = enemyItor.next();
            System.out.printf("%s 파이어볼 공격%n", enemy);
            enemy.setHp(enemy.getHp() - 30);
        }
        while (enemyItor.hasNext()) {
            var enemy = enemyItor.next();
            System.out.printf("%s 화살 공격%n", enemy);
            enemy.setHp(enemy.getHp() - 10);
        }

        System.out.println("\n- - - - - - - -\n");

        Map<Integer, Double> hashMap = new HashMap<>();
        for (var i = 0; i < 10; i++) {
            hashMap.put(i + 1, Math.random() * 10);
        }

        // 맵의 경우 아래와 같이 Iteration
        // 키, 값 또는 엔트리의 컬렉션을 반환받아 Iterate
        Iterator<Integer> hmKeyItor = hashMap.keySet().iterator();
        Iterator<Double> hmValueItor = hashMap.values().iterator();
        Iterator<Map.Entry<Integer, Double>> hmEntryItor = hashMap.entrySet().iterator();

        while (hmKeyItor.hasNext()) {
            System.out.println("hmKeyItor = " + hmKeyItor.next());
        }

        System.out.println("\n- - - - - - - -\n");

        while (hmValueItor.hasNext()) {
            System.out.println("hmValueItor = " + hmValueItor.next());
        }

        System.out.println("\n- - - - - - - -\n");

        while (hmEntryItor.hasNext()) {
            System.out.println("hmEntryItor = " + hmEntryItor.next());
        }

        while (hmKeyItor.hasNext()) {
            Integer next = hmKeyItor.next();
            if (next % 3 == 0) hmKeyItor.remove();
        }
        while (hmValueItor.hasNext()) {
            double d = hmValueItor.next();
            if (d < 5) hmValueItor.remove();
        }
        while (hmEntryItor.hasNext()) {
            Map.Entry<Integer, Double> e = hmEntryItor.next();
            if (e.getKey() % 2 == 0) {
                hmEntryItor.remove();
            }
        }

        System.out.println("hashMap = " + hashMap);
    }
}
