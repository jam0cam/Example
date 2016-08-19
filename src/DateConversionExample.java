import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

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

        String timeZone = "America/Los_Angeles";
        System.out.println(getDateStringIn(date, "h:mm aaa", timeZone));

        TimeZone tz = TimeZone.getTimeZone(timeZone);
        int mGMTOffset = tz.getRawOffset();
        System.out.printf("GMT offset is %s hours", TimeUnit.HOURS.convert(mGMTOffset, TimeUnit.MILLISECONDS));


        Calendar mCalendar = new GregorianCalendar();
        TimeZone mTimeZone = mCalendar.getTimeZone();
        int currentOffset = mTimeZone.getRawOffset();
        System.out.printf("GMT offset is %s hours", TimeUnit.HOURS.convert(currentOffset, TimeUnit.MILLISECONDS));

        System.out.println("\n===================================");

        Calendar now = GregorianCalendar.getInstance();

        System.out.println(now.get(Calendar.HOUR_OF_DAY));
        changeTimeZone(now, tz);
        System.out.println(now.get(Calendar.HOUR_OF_DAY));


        System.out.println("\n Null DATE ========================");
        DateFormat nullFormatter = new SimpleDateFormat(null);
        nullFormatter.format(new Date());

    }


    private static void changeTimeZone(Calendar calendar, TimeZone tz) {
        Calendar now = (Calendar) calendar.clone();
        now.setTimeZone(tz);
        System.out.println(now.get(Calendar.HOUR_OF_DAY));
    }


    private static String getDateStringIn(Date date, String format, String timeZone) throws ParseException {
        DateFormat customFormatter = new SimpleDateFormat(format);
        customFormatter.setTimeZone(TimeZone.getTimeZone(timeZone));
        return  customFormatter.format(date);
    }

}
