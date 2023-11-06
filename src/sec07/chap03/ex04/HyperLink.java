package src.sec07.chap03.ex04;

public class HyperLink implements Clickable{
    @Override
    public void onClick() {
        System.out.println("해당 링크로 이동하기");
    }
}
