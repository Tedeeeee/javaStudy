package src.sec06.chap01.ex01;

public class Outer {
    private String inst = "인스턴스";
    private static String sttc = "클래스";

    // 멤버 인스턴스 클래스
    class InnerInstMember {
        private String name = inst + " 필드로써의 클래스";

        private InnerSttcMember innerSttcMember = new InnerSttcMember();

        public void func() {
            System.out.println(name);
        }
    }

    // 클래스 내부 정적 클래스
    // 내부 클래스에도 접근자 사용 가능하다.
    public static class InnerSttcMember {

        // Outer 클래스의 클래스 필드에만 접근할 수 있다.
        private String name = sttc + " 필드로써의 클래스";

        // static 이 아닌 멤버( 인스턴스 클래스엔 접근이 불가능 )
        // private InnerInstMember innerInstMember = new InnerInstMember();

        public void func() {
            // 메소드는 인스턴스이지만 클래스 자체가 정적이라 인스턴스 접근 불가능
            // System.out.println(inst);
            System.out.println(name);
        }
    }

    // 메소드 내부 클래스
    public void memberFunc() {

        class MethodMember {
            String instSttc = inst + " " + sttc;
            InnerSttcMember innerSttcMember = new InnerSttcMember();
            InnerInstMember innerInstMember = new InnerInstMember();

            public void func() {
                innerInstMember.func();
                innerSttcMember.func();
                System.out.println("메소드 안의 클래스");
            }
        }

        new MethodMember().func();
    }

    public void innerFuncs() {
        new InnerInstMember().func();
        new InnerSttcMember().func();
    }

    public InnerInstMember getInnerInstMember() {
        return new InnerInstMember();
    }
}
