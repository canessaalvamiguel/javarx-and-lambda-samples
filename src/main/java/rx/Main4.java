package rx;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Main4 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Integer> flowable = Flowable.fromArray(new Integer[] {1, 2, 3, 4, 5});

        flowable
                .parallel()
                .runOn(Schedulers.computation())
                .map(x -> intenseCalculation(x))
                .sequential()
                .subscribe(System.out::println);

        System.out.println("Waiting for pending tasks...");

        Thread.sleep(5000);

        System.out.println("Time is over...");

    }

    private static String intenseCalculation(Integer i) {
        return "procesing item: "+i;
    }
}
