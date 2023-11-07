package src.sec08.comparatorcomparable.ex01;

import src.sec07.chap4.*;

import java.util.Comparator;

public class UnitSorter implements Comparator<Unit> {
    @Override
    public int compare(Unit o1, Unit o2) {
        var result = getClassPoint(o2) - getClassPoint(o1);

        // 인스턴스의 내용이 같을때 해시코드의 내용으로 정렬한다.
        if (result == 0) result = o1.hashCode() - o2.hashCode();

        return result;
    }

    public int getClassPoint(Unit u) {
        int result = u.getSide() == Side.RED ? 10 : 0;

        if (u instanceof SwordMan) result += 1;
        if (u instanceof Knight) result += 2;
        if (u instanceof MagicKnight) result += 3;

        return result;
    }
}
