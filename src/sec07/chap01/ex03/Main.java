package src.sec07.chap01.ex03;

public class Main {
    public static void main(String[] args) {
        Click click1 = new Click(123, 456, 5323487);
        Click click2 = new Click(123, 456, 5323487);
        Click click3 = new Click(123, 456, 5323487);
        Click click4 = new Click(234, 555, 352323626);

        // 초반의 해시값은 서로가 다르다. 하지만 hashCode() 를 Override 하여 기준 값을 정해준다면 같은 해시값이 나올 수 있다.
        var clickHash1 = click1.hashCode();
        var clickHash2 = click2.hashCode();
        var clickHash3 = click3.hashCode();
        var clickHash4 = click4.hashCode();

        // 그냥 적은 toString 은 서로 다른 객체 값을 나타낸다
        // 하지만 hashCode() 를 Override 하며 나타난 영향으로 객체의 값을 정하는 반환값이 같아지면서 똑같은 객체값으로 변한다
        var clickStr1 = click1.toString();
        var clickStr2 = click1.toString();
        var clickStr3 = click1.toString();
        var clickStr4 = click1.toString();

        var str1 = new String("Hello");
        var str2 = new String("Hello");
        var str3 = new String("World");

        // String 클래스를 통해 만든 문자열을 조금 다르다.
        // 문자열이 같으면 해시값이 같아지도록 자체적으로 Override 가 되어있다.
        var strHash1 = str1.hashCode();
        var strHash2 = str2.hashCode();
        var strHash3 = str3.hashCode();

        var str1ToStr = str1.toString();
        var str1eq2 = str1.equals(str2);
    }
}
