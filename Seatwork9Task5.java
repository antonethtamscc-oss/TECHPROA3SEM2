import java.util.Timer;
import java.util.TimerTask;

public class Seatwork9Task5 {
    public static void main(String[] args) {

        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                System.out.println("Hello!");
            }
        };

        timer.schedule(task, 0, 1000); 
    }
}
