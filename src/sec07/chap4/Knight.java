package src.sec07.chap4;

public class Knight extends SwordMan{
    private enum Weapon {SWORD, SPEAR}

    private Weapon weapon = Weapon.SWORD;

    public Knight(Side side) {
        super(side);
        setHp(getHp() + 40);
    }

    public void switchWeapon() {
        weapon = weapon == Weapon.SWORD ? Weapon.SPEAR : Weapon.SWORD;
    }

    private void spearAttack(Unit target) {
        target.setHp(getHp() - 14);
    }

    @Override
    public void defaultAttack(Unit target) {
        if (weapon == Weapon.SWORD) {
            super.defaultAttack(target);
        } else {
            spearAttack(target);
        }
    }

    @Override
    public String toString() {
        return getSide().getName() + " 진영 기사";
    }
}
