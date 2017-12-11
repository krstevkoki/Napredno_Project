package mk.ukim.finki.lab8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;

/**
 * LocalDateTime tests
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        System.out.println(localDateTimeOf());
        System.out.println(localDateTimeParse());
        System.out.println(localTimeWith());
        System.out.println(localDatePlusMinus());
        System.out.println(localDateTimeFormat());
        System.out.println(toLocalDateAndTime());
        System.out.println(toLocalDateTime());
    }

    private static LocalDateTime localDateTimeOf() {
        /**
         * Create a {@link LocalDateTime} of 2015-06-20 23:07:30 by using {@link LocalDateTime#of}
         */
        return LocalDateTime.of(
                LocalDate.of(2015, 6, 20),
                LocalTime.of(23, 7, 30));
    }

    private static LocalDateTime localDateTimeParse() {
        /**
         * Create a {@link LocalDateTime} of 2015-06-20 23:07:30 by using {@link LocalDateTime#parse}
         */
        return LocalDateTime.parse("2015-06-20T23:07:30");
    }

    private static LocalDateTime localTimeWith() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;
        /**
         * Create a {@link LocalDateTime} from {@link ldt}
         * with first day of the next month and also truncated to hours.
         */
        return ldt.with(TemporalAdjusters.firstDayOfNextMonth()).truncatedTo(ChronoUnit.HOURS);
    }

    private static LocalDateTime localDatePlusMinus() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;
        /**
         * Create a {@link LocalDateTime} from {@link ldt} with 10 month later and 5 hours before
         * by using {@link LocalDateTime#plus*} or {@link LocalDateTime#minus*}
         */
        return ldt.minusHours(5).plusMonths(10);
    }

    private static String localDateTimeFormat() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;
        /**
         * Format {@link ldt} to a {@link String} as "2015_06_18_23_07_30"
         * by using {@link LocalDateTime#format} and {@link DateTimeFormatter#ofPattern}
         */
        return ldt.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
    }

    private static String toLocalDateAndTime() {
        LocalDateTime ldt = DateAndTimes.LDT_20150618_23073050;
        /**
         * Create a {@link LocalDate} and a {@link LocalTime} from {@link ldt}
         * by using {@link LocalDateTime#toLocalDate} and {@link LocalDateTime#toLocalTime}
         */
        LocalDate localDate = ldt.toLocalDate();
        LocalTime localTime = ldt.toLocalTime();
        return localDate.toString() + localTime.toString();
    }

    private static String toLocalDateTime() {
        LocalDate ld = DateAndTimes.LD_20150618;
        LocalTime lt = DateAndTimes.LT_23073050;
        /**
         * Create two equal {@link LocalDateTime} from {@link ld} and {@link lt}
         * by using {@link LocalDate#atTime} and {@link LocalTime#atDate}
         */
        LocalDateTime localDateTime1 = ld.atTime(lt);
        LocalDateTime localDateTime2 = lt.atDate(ld);
        return localDateTime1.toString() + " " + localDateTime2.toString();
    }

    private static class DateAndTimes {
        private static final LocalDate LD_20150618 = LocalDate.of(2015, 6, 18);
        private static final LocalTime LT_23073050 = LocalTime.of(23, 7, 30, 500000000);
        private static final LocalDateTime LDT_20150618_23073050 = LocalDateTime.of(2015, 6, 18,
                23, 7, 30, 500000000);
    }
}
