package rx;

public class Main {
    public static void main(String[] args){

        //////First asynchronous non-blocking process
        String message = "Hi 01, learning observer";
        MyObservableProcess myObservableProcess = new MyObservableProcess(message);
        myObservableProcess.subscribe( messageReceived -> {
            int a = 0;
            for (int i = 0; i < 100000; i++) {
                a += i;
            }
            System.out.println( messageReceived + " --- 1");
        });

        //////Second asynchronous non-blocking process
        String message2 = "Hi 02, learning observer";
        MyObservableProcess myObservableProcess2 = new MyObservableProcess(message2);
        myObservableProcess2.subscribe( messageReceived -> {
            System.out.println( messageReceived +" --- 2");
        });

        //////Calling both process
        myObservableProcess.sendMessage();
        myObservableProcess2.sendMessage();

        //Calling a blocking sequential process
        otherProccess();

        System.out.println("Waiting for pending process..");
    }

    private static void otherProccess() {
        int a = 0;
        for (int i = 0; i < 100000; i++) {
            a += i;
        }
        System.out.println("otherProccess finished");
    }
}
