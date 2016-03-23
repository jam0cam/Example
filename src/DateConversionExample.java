import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * User: jitse
 * Date: 8/29/14
 * Time: 8:02 PM
 */
public class DateConversionExample {

    public static void main(String[] args) throws ParseException {
        String time = "2016-03-28T16:00:00-07:00";

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        Date date = dateFormatter.parse(time);

        System.out.println(date.toString());

        System.out.println(getDateStringIn(date, "h:mm aaa", "America/Los_Angeles"));
    }


    private static String getDateStringIn(Date date, String format, String timeZone) throws ParseException {
        DateFormat utcFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        utcFormatter.setTimeZone(TimeZone.getTimeZone(timeZone));
        String dateString = utcFormatter.format(date);

        Date newDate = utcFormatter.parse(dateString + " UTC");

        DateFormat customFormatter = new SimpleDateFormat(format);
        customFormatter.setTimeZone(TimeZone.getTimeZone(timeZone));
        return  customFormatter.format(newDate);
    }

}
