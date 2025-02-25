package drip;

import java.time.LocalTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class VideoLengthHomeWork {
    public static int minutesToSeconds(String videoLength) {
        videoLength = "00:" + videoLength;
        LocalTime time = LocalTime.parse(videoLength);
        int minutes = time.getMinute();
        int seconds = time.getSecond();

        if (minutes > 60){
            return -1;
        }

        return minutes * 60 + seconds;
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите время в формате mm:ss");
        String input = scanner.nextLine();
        System.out.println(minutesToSeconds(input));
    }
}