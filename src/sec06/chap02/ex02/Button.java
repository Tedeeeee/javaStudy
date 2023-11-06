package src.sec06.chap02.ex02;

public class Button {
    String name;

    public Button(String name) {
        this.name = name;
    }

    // 인터페이스를 상속한 클래스 자료형
    // Button 이 OnClickListener 라는 클래스를 하나 가지고 있다.
    // implement 한 것이 아니라는 것이다.
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void func(){
        onClickListener.onClick();
    }
}
