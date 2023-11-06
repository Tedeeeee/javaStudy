package src.sec05.chap10.ex03;

public class Main {
    public static void main(String[] args) {
        Tab tab1 = new Tab();
        Tab tab2 = new Tab();
        Tab tab3 = new Tab();

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
         *  tab 을 생성하는 당시에 setting 객체는 단 한개만 적용된다.
         *
         *  때문에 tab1 에서 setting 으로 인한 볼륨 조절은 같은 setting 객체를 사용하는 tab2, 3 모두 적용되는 것이다.
         */


    }
}
