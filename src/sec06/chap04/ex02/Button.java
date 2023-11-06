package src.sec06.chap04.ex02;

public class Button {
    enum Mode {LIGHT, DARK}
    enum Space { SINGLE, DOUBLE, TRIPLE}

    private Mode mode;
    private Space space;

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setSpace(Space space) {
        this.space = space;
    }
}
