package src.sec11.chap03;

public class Ex01 {
    public static void main(String[] args) {
        // 아무것도 하지 않는 쓰레드를 만든다.
        Thread thr1 = new Thread(() -> {});

        // 따로 그룹을 지정해주지 않은 쓰레드
        // main 쓰레드 그룹에 속한 쓰레드이다.
        ThreadGroup mainThrGroup = thr1.getThreadGroup();
        String mainThrGroupName = mainThrGroup.getName();

        // 새로운 쓰레드 그룹을 하나 만들기
        ThreadGroup threadGroup1 = new ThreadGroup("TG_1");
        String thrGroup1Name = threadGroup1.getName();

        // 아무것도 하지 않는 쓰레드를 생성한 그룹에 넣는다.
        Thread thr2 = new Thread(threadGroup1, () -> {});
        String thr2GroupName = thr2.getThreadGroup().getName();

        // 또 다른 쓰레드 그룹에 속한 쓰레드 그룹을 만들기
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "TG_2");

        // 기존의 쓰레드 그룹을 새로 생성한 쓰레드 그룹에 넣기
        String thrGroup2ParentName = threadGroup2.getParent().getName();

    }
}
