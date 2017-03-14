import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Stiv on 14/03/2017.
 *
 */
public class DateTime {
    public static void main(String[] args) {
        String times = "3:2";
        DateFormat sdf = new SimpleDateFormat("mm:ss");
        Date dates = null;
        try {
            dates = sdf.parse(times);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Time: " + sdf.format(dates));

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd");
        String text = date.format(formatter);
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        System.out.println(parsedDate);

        LocalTime time = LocalTime.now();
        System.out.println(time);
        System.out.println(DateTimeFormatter.ofPattern("H:m:s"));
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("mm:ss");
//        System.out.println(DateTimeFormatter.ofLocalizedTime(timeFormatter));
//time.

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:m:s");
        String sth = time.format(timeFormatter);
        LocalTime parsedTime = LocalTime.parse(sth, timeFormatter);
        System.out.println(parsedTime);

//        String string ="2013-04-26 08:34:55.705"
//        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string);
//        System.out.println(date);
    }
}
