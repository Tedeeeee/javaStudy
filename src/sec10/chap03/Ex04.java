package src.sec10.chap03;

import src.sec07.chap4.MagicKnight;
import src.sec07.chap4.Side;
import src.sec07.chap4.Unit;

public class Ex04 {
    public static void main(String[] args) {
        MagicKnight magicKnight = new MagicKnight(Side.BLUE);
        Dragon dragon = new Dragon(Side.RED);

        superLighteningAttack(magicKnight, dragon);
        superLighteningAttack(magicKnight, dragon);
    }
    public static void superLighteningAttack(MagicKnight magicKnight, Unit enemy) {
        final int MANA_USAGE = 40;
        final int DAMAGE = 500;
        if (magicKnight.mana < MANA_USAGE) {
            throw new NotEnoughManaException(magicKnight, MANA_USAGE);
        }
        System.out.printf("⚡️⚡️⚡️ → 💀 %s%n", enemy);
        enemy.setHp(enemy.getHp() - DAMAGE);
        magicKnight.mana -= MANA_USAGE;
    }
}
