package src.sec05.chap09.ex01;

public class FlyingSquirrel extends Mamal implements Flyer{


    public FlyingSquirrel() {
        super(false);
    }

    @Override
    public void fly() {
        System.out.println("날개를 비행");
    }
}
