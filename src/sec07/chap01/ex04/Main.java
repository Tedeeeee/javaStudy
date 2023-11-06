package src.sec07.chap01.ex04;

public class Main {
    public static void main(String[] args) {
        NotCloneable notCloneable = new NotCloneable(
                "클릭들 1", 1, new int[] {1, 2, 3},
                new Click(12, 34),
                new Click[] { new Click(12, 34), new Click(56, 78)}
        );

        NotCloneable clone1 = null;

        // 오류가 발생하는 이유는 NotCloneable 에 Cloneable 이 implements 가 되지 않아서이다.
        try {
            clone1 = (NotCloneable) notCloneable.clone();
        } catch (CloneNotSupportedException e) {
            System.out.printf("복제 중 오류 발생 : %s%n", notCloneable);
        }

        System.out.println("\n- - - - - - -\n");

        ShallowCopied shallowCopied = new ShallowCopied(
                "클릭들 1", 1, new int[] {1, 2, 3},
                new Click(12, 34),
                new Click[] { new Click(12, 34), new Click(56, 78) }
        );

        ShallowCopied clone2 = null;

        // Cloneable 을 implements 한 ShallowCopied 는 이제 오류를 발생하지 않는다.
        try{
            clone2 = (ShallowCopied) shallowCopied.clone();
        } catch (CloneNotSupportedException e) {
            System.out.printf("복제 중 오류 발생 : %s%n", shallowCopied);
        }

        // 카피된 값을 변경해보자
        shallowCopied.title = "제목이 바뀌었다";
        shallowCopied.no = 2;

        // 참조 타입들은 완전히 복사가 되지 않는다.(주소만 복사된다) 그래서 clone2 에도 영향이 간다.
        shallowCopied.numbers[0] = 0;
        shallowCopied.click.x = 99;
        shallowCopied.clicks[0].x = 103;

        System.out.println("\n- - - - - - -\n");

        DeepCopied deepCopied = new DeepCopied(
                "클릭들 1", 1, new int[] {1, 2, 3},
                new Click(12, 34),
                new Click[] { new Click(12, 34), new Click(56, 78) }
        );

        DeepCopied clone3 = null;

        try {
            clone3 = (DeepCopied) deepCopied.clone();
        } catch (CloneNotSupportedException e) {
            System.out.printf("복제 중 문제 발생 : %s%n", deepCopied);
        }

        // 이렇게 바꿔도 clone3 에는 영향이 가지 않는걸 알 수 있다.
        deepCopied.title = "제목 바뀜";
        deepCopied.no = 2;
        deepCopied.numbers[0] = 0;
        deepCopied.click.x = 99;
        deepCopied.clicks[0].x = 99;

    }
}
