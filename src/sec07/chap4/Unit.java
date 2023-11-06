package src.sec07.chap4;

public abstract class Unit {
    private Side side;
    private int hp;

    public Unit(Side side, int hp) {
        this.side = side;
        this.hp = hp;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
