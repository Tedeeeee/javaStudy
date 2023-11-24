package src.sec11.chap06.ex01;

public class VolunteerRun implements Runnable{

    private static int lastNo = 0;
    private static int working = 0;

    private int no;
    private Cave cave;

    public VolunteerRun(Cave cave) {
        this.no = ++lastNo;
        this.cave = cave;

        System.out.printf(
                "🦺 %d번 지원자 투입 (남은 물 양: %d)%n", no, cave.getWater()
        );
    }

    @Override
    public void run() {
        working++;
        System.out.printf(
                "🪣 %d번 지원자 시작 (현재 %d명 펌핑중, 남은 물 %d)%n",
                no, working, cave.getWater()
        );
    }
}
