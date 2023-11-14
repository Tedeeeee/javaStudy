package src.sec10.chap03;

import src.sec07.chap4.*;

public class Dragon extends Unit {
    public Dragon(Side side) {
        super(side, 3000);
    }

    @Override
    public String toString() {
        return getSide().toString() + " 진영 드래곤";
    }
}
