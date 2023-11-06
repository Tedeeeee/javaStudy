package src.sec07.chap4;

public class MagicKnight extends Knight{

    public int mana = 60;
    public final int MANA_USAGE = 4;
    public MagicKnight(Side side) {
        super(side);
    }

    // 다수 공격
    public void lighteningAttack(Unit[] targets) {
        for (Unit target : targets) {
            if (target instanceof MagicKnight) continue;
            if (mana < MANA_USAGE) break;
            System.out.printf("⚡️ → 💀 %s%n", target);
            target.setHp(target.getHp() - 8);
            mana -= MANA_USAGE;
        }
    }

    @Override
    public String toString() {
        return getSide().getName() + " 진영 마법 기사";
    }
}
