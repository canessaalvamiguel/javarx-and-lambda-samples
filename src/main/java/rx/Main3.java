package rx;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Integer> fw = Flowable.range(0,10);
        fw
                .parallel()
                .runOn(Schedulers.io())
                .map(i -> intenseCalculation(i, "$$"))
                .sequential()
                .subscribe(System.out::println);

        Thread.sleep(5000);
    }

    private static String intenseCalculation(Integer id, String idx) {
        int a = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println("process: "+id+" item:"+i);
            a += i;
        }
        return "";
    }
}
