package src.sec07.chap01.ex02;

public class Click {
    int x;
    int y;
    int timeStamp;

    public Click(int x, int y, int timeStamp) {
        this.x = x;
        this.y = y;
        this.timeStamp = timeStamp;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Click)) return false;
//        return this.x == ((Click) obj).x && this.y == ((Click) obj).y;
//    }
}
