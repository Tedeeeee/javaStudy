package src.sec06.chap01.ex01;

public class Main {
    public static void main(String[] args) {
        Outer.InnerSttcMember staticMember = new Outer.InnerSttcMember();
        staticMember.func();

        System.out.println("\n- - - - - - -\n");

        Outer outer = new Outer();
        outer.innerFuncs();

        System.out.println("\n- - - - - - -\n");

        // 인스턴스 클래스는 정적 클래스의 사용법과는 조금 다르다
        Outer.InnerInstMember innerInstMember = outer.getInnerInstMember();
        innerInstMember.func();

        System.out.println("\n- - - - - - -\n");

        outer.memberFunc();
    }
}
