package src.sec05.chap07;

public final class TaesikChickenDT extends TaesikChicken{
    public TaesikChickenDT(int no, String name) {
        super(no, name);
    }

    // 역시 final 메소드인 fryChicken을 Override 할 수 없다.
/*
    public void fryChicken() {
        System.out.println("염지, 반죽입히기, 미원, 튀김");
    }
*/
}
