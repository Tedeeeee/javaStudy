package src.sec05.chap08.ex01;

public class TaesikChicken extends TaesikGroup{

    public static String getCreed() {
        return CREED.formatted("튀김옷 은");
    }

    protected static int lastNo = 0;

    public TaesikChicken(String name) {
        super(++lastNo, name);
    }

    @Override
    public void takeOrder() {
        System.out.printf("얄코치킨 %s 치킨을 주문해주세요.%n", super.intro());
    }

}
