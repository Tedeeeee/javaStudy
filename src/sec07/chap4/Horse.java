package src.sec07.chap4;

public class Horse<T extends Unit> {
    private int extraHp;
    private T rider;

    public Horse(int extraHp) {
        this.extraHp = extraHp;
    }

    public void setRider(T rider) {
        this.rider = rider;
        rider.setHp(rider.getHp() + extraHp);
    }

    @Override
    public String toString() {
        return "말 (추가 체력 : %d)".formatted(extraHp);
    }
}
