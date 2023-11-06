package src.sec05.chap10.ex02;

public class Main {
    public static void main(String[] args) {
        /**
         *  객체를 싱글턴으로 제작하기 위해 할 수 있는 방법
         */

        Setting setting = new Setting();

        // 방법 1. 생성자로 주입을 한다
        // 같은 객체를 넣어서 사용함으로써 하나의 객체만 사용하게 된다.
        Tab tab1 = new Tab(setting);
        Tab tab2 = new Tab(setting);

        // 방법 2. setter 로써 주입
        // set의 인자로 객체를 받아 객체 하나만 적용하게 사용
        Tab tab3 = new Tab();
        tab3.setSetting(setting);

        System.out.println(tab1.getSetting().getVolume());
        System.out.println(tab2.getSetting().getVolume());
        System.out.println(tab3.getSetting().getVolume());

        System.out.println("\n- - - - - - -\n");

        tab1.getSetting().incVolume();
        tab1.getSetting().incVolume();

        System.out.println(tab1.getSetting().getVolume());
        System.out.println(tab2.getSetting().getVolume());
        System.out.println(tab3.getSetting().getVolume());

        /**
         *  생성자에서 인스턴스로 제작된 객체를 넣어주거나 해당 클래스의 set 값을 받게 함으로써 객체를 전달한다.
         *
         *  하지만 이 방법은 외부에서 인스턴스를 제작해서 넣어주어야 하고 협업등의 경우 어떠한 상황에 의해 잘못 사용될 가능성이 있다.
         */

    }
}
