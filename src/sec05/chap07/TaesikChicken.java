package src.sec05.chap07;

public class TaesikChicken {
    protected static final String CREED = "우리의 튀김옷은 얇고 바삭하다";

    private final int no;
    public String name;

    public TaesikChicken(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void changeFinalFields() {
        // 불가능한 코드
        // 이유는 역시 final 로 인해 고정된 값을 바꾸려 하는 것이기 때문
        // this.no++;
    }

    public final void fryChicken () {
        System.out.println("염지, 반죽입히기, 튀김");
    }
}
