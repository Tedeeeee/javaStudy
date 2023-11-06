package src.sec07.chap4;

public class SwordMan extends Unit implements Attacker{

    public SwordMan(Side side) {
        super(side, 80);
    }

    private void swordAttack(Unit target) {
        target.setHp(target.getHp() - 10);
    }

    @Override
    public void defaultAttack(Unit target) {
        swordAttack(target);
    }

    @Override
    public String toString() {
        return getSide().getName() + " 진영 검사";
    }
}
