package rx;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.UUID;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {

        Flowable<UUID> ids = Flowable
                .fromCallable(UUID::randomUUID)
                .repeat()
                .take(100);

        ids
                .parallel(10)
                .runOn(Schedulers.io())
                .map(i -> intenseCalculation(i))
                .sequential()
                .subscribe(val -> System.out.println("Done: "+val.toString()));

        Thread.sleep(5000);

    }

    private static UUID intenseCalculation(UUID id) {
        int a = 0;
        System.out.println("------------ init intenseCalculation: "+id);
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            a += i;
        }
        System.out.println("------------ finish intenseCalculation: "+id);
        return id;
    }
}
