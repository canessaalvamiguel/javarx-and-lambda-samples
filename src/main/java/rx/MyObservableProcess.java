package rx;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MyObservableProcess extends Observable<String> {
    private List<Observer<? super String>> myObservers = new LinkedList<>();
    private String message;

    public MyObservableProcess(String message) {
        this.message = message;
    }

    @Override
    protected void subscribeActual(Observer<? super String> observer) {
        myObservers.add(observer);
    }

    public void sendMessage(){
        Timer timerMessage = new Timer();
        timerMessage.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                myObservers.forEach(obs -> obs.onNext(message));
                myObservers.forEach(obs -> obs.onComplete());
                timerMessage.cancel();
            }
        },
                0,
                1);
    }
}
