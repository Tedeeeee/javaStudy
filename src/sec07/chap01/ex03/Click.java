package src.sec07.chap01.ex03;

public class Click {
    int x;
    int y;
    int timeStamp;

    public Click(int x, int y, int timeStamp) {
        this.x = x;
        this.y = y;
        this.timeStamp = timeStamp;
    }

    @Override
    public int hashCode() {
        return x * 100000 + y;
    }
}
