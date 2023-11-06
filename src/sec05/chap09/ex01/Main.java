package src.sec05.chap09.ex01;

public class Main {
    public static void main(String[] args) {
        PolarBear polarBear = new PolarBear();

        // 다형성으로 인해 할 수 있는 조합
        Mamal mamal = polarBear;
        Swimmer swimmer = polarBear;

        GlidingLizard glidingLizard = new GlidingLizard();
        Eagle eagle = new Eagle();

        Hunter[] hunters = {
                polarBear, glidingLizard, eagle
        };

        for (Hunter hunter : hunters) {
            hunter.hunt();
        }
    }
}
