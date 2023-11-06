package src.sec05.chap10.ex03;

public class Setting {

    // 지금까지는 setting을 사용하는 클래스에서 인스턴스 생성과 함께 넣어주었지만
    // 클래스 필드 ( 정적 )를 사용한다면 프로그램 메모리에는 해당 클래스 하나만 존재하게 되는 것이다.
    // 하지만 과연 해당 클래스 안에 해당 클래스를 사용하는 것이 좋은가?
    private static Setting setting;

    // 생성자 또한 private 로 하여 외부에서 생성자를 통해 제작하지 못하게 만들어야 한다.
    private Setting() { }

    // 이 메소드도 static 으로써 메모리에 단 한개만 존재한다.
    // Setting 의 객체를 사용하려 할때 Setting 이 아닌 Setting.getInstance 로 사용하면 된다
    public static Setting getInstance() {
        if (setting == null) {
            setting = new Setting();
        }
        return setting;
    }

    private int volume = 5;

    public int getVolume() {
        return volume;
    }

    public void incVolume() {volume++;}
    public void decVolume() {volume--;}




}
