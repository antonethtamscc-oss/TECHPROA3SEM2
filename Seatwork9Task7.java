import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Seatwork9Task7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "A Caring Friend.wav";

        while (alarmTime == null) {
            try {
                System.out.print("Enter alarm time (HH:MM:SS): ");
                String inputTime = scanner.nextLine();
                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmTime);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Use HH:MM:SS");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
    }
}

class AlarmClock implements Runnable {

    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;

    AlarmClock(LocalTime alarmTime, String filePath, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    @Override
    public void run() {

        while (true) {
            LocalTime now = LocalTime.now();

            System.out.printf("\r%02d:%02d:%02d",
                    now.getHour(),
                    now.getMinute(),
                    now.getSecond());

            if (now.getHour() == alarmTime.getHour() &&
                now.getMinute() == alarmTime.getMinute() &&
                now.getSecond() == alarmTime.getSecond()) {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }

        System.out.println("\n*ALARM NOISES*");
        playSound(filePath);
    }

    private void playSound(String filePath) {

        File audioFile = new File(filePath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.print("Press Enter to stop alarm: ");
            scanner.nextLine();

            clip.stop();
            clip.close();
            scanner.close();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio format.");
        } catch (LineUnavailableException e) {
            System.out.println("Audio unavailable.");
        } catch (IOException e) {
            System.out.println("Error reading audio file.");
        }
    }
}
