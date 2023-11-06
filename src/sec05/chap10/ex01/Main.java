package src.sec05.chap10.ex01;

public class Main {
    public static void main(String[] args) {
        Tab tab1 = new Tab();
        Tab tab2 = new Tab();
        Tab tab3 = new Tab();

        System.out.println(tab1.getSetting().getVolume());

        System.out.println("\n- - - - - -\n");

        tab1.getSetting().incVolume();
        tab1.getSetting().incVolume();

        System.out.println(tab1.getSetting().getVolume());

        // 각 인스턴스는 서로 다른 Setting 값을 가진다.
        // 설정 값이 공유되지 못하고 있다
        System.out.println(tab2.getSetting().getVolume());
        System.out.println(tab3.getSetting().getVolume());
    }
}
