package src.sec05.chap08.ex01;

public class TaesikCafe extends TaesikGroup{

    public static String getCreed() {
        return CREED.formatted("원두향 은");
    }

    protected static int lastNo = 0;

    private boolean isTakeout;

    public TaesikCafe(String name, boolean isTakeout) {
        super(++lastNo, name);
        this.isTakeout = isTakeout;
    }

    @Override
    public void takeOrder() {
        System.out.printf("태식 카페 %s 음료를 주문해주세요%n", super.intro());
        if (!isTakeout) System.out.println("매장에서 드시나요?");
    }
}
