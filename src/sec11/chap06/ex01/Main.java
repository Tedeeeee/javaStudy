package src.sec11.chap06.ex01;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        // 쓰레드 풀을 관리하는 라이브러리 클래스
        ExecutorService es = Executors.newFixedThreadPool(5);

        Cave cave = new Cave();

        while (cave.getWater() > 20) {
            // execute : Runnable ( 일하는 사람 ) 을 대기열에 추가한다.
            es.execute(new VolunteerRun(cave));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }

        // shutdown : 풀 닫기 ( 투입 중단, 더 투입시 예외 )
        // shutdown 을 생략하면 프로그램이 원하는 조건으로 끝나지 않는다.
        // 이미 안에서 일하는 쓰레드는 계속해서 일을 하게 되는것이다
        //es.shutdown();

        // 한번 shutdown 된 쓰레드 풀에는 쓰레드를 다시 집어 넣을 수 없다.
        //es.execute(new VolunteerRun(cave));

        // shutdownNow : 풀 닫고 투입된 쓰레드까지 모두 해산을 하는 것이다. ( 진행중인 일도 모두 끝마친다 )
        // 진행중인 업무 강제 종료는 보장이 되는 것은 아니다.
        // 각 쓰레드에 InterruptedException 을 유발할 뿐이다.
        // 각 Runnalbe 에서 해당 예외 발생 후 종료 되도록 조취를 취해줘야한다.
        // 투입되어 대기 중인 지원자들은 리스트 형태로 반환된다.
        List<Runnable> waitings = es.shutdownNow();
        System.out.println(waitings);
    }
}
