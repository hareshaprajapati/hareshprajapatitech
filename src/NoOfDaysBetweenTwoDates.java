

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class NoOfDaysBetweenTwoDates {
    private static final Map<Integer, Integer> daysInMonth;

    static {
        daysInMonth = new HashMap<Integer, Integer>();
        daysInMonth.put(1, 31);
        daysInMonth.put(2, 28);
        daysInMonth.put(3, 31);
        daysInMonth.put(4, 30);
        daysInMonth.put(5, 31);
        daysInMonth.put(6, 30);
        daysInMonth.put(7, 31);
        daysInMonth.put(8, 31);
        daysInMonth.put(9, 30);
        daysInMonth.put(10, 31);
        daysInMonth.put(11, 30);
        daysInMonth.put(12, 31);
    }

    private int day;
    private int month;
    private int year;
    private int amount;

    public NoOfDaysBetweenTwoDates(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public NoOfDaysBetweenTwoDates addOrSubDays(int amount) {
        this.amount = amount;
        return addOrSubDays(this.day + this.amount, this.month, this.year);
    }


    public static int countLeapYears(NoOfDaysBetweenTwoDates d) {

        int years = d.year;


        // Check if the current year needs to be considered
        // for the count of leap years or not
        if (d.month < 2)
            years--;



        // An year is a leap year if it is a multiple of 4,
        // multiple of 400 and not a multiple of 100.
        return years / 4 - years / 100 + years / 400;
    }

    public static long getDifference(NoOfDaysBetweenTwoDates dt1, NoOfDaysBetweenTwoDates dt2) {
        // COUNT TOTAL NUMBER OF DAYS BEFORE FIRST DATE 'dt1'

        // initialize count using years and day
        long n1 = (dt1.year -1) * 365 + dt1.day;

        // Add days for months in given date
        for (int i = 1; i <= dt1.month ; i++)
            n1 += daysInMonth.get(i);

        // Since every leap year is of 366 days,
        // Add a day for every leap year
        n1 += countLeapYears(dt1);

        // SIMILARLY, COUNT TOTAL NUMBER OF DAYS BEFORE 'dt2'

    long n2 = (dt2.year - 1) * 365 + dt2.day;
        for (int i = 1; i <= dt2.month ; i++)
            n2 += daysInMonth.get(i);
        n2 += countLeapYears(dt2);

        // return difference between two counts
        return (n2 - n1);
    }

    public static void main(String[] args) {
        int amount = 0;
        amount = -15;
//        amount = 21;

        NoOfDaysBetweenTwoDates addSubtractDate = new NoOfDaysBetweenTwoDates(8, 1, 2018);
        NoOfDaysBetweenTwoDates myDate1 = new NoOfDaysBetweenTwoDates(13, 2, 2018);

        System.out.println(getDifference(addSubtractDate, myDate1));
        // Testing
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH,0);
        cal.set(Calendar.DAY_OF_MONTH,8);
        long timeInMillis = cal.getTimeInMillis();
        cal.set(Calendar.MONTH,1);
        cal.set(Calendar.DAY_OF_MONTH,13);
        long timeInMillis1 = cal.getTimeInMillis();
        long diff = timeInMillis1 - timeInMillis;
        System.out.println(diff / (24 * 60 * 60 * 1000));
    }

    private NoOfDaysBetweenTwoDates addOrSubDays(int days, int month, int year) {
        if (days > 0 && days <= getNoOfDaysInMonth(month, year)) {
            return new NoOfDaysBetweenTwoDates(days, month, year);
        } else if (days <= 0) {
            month = month - 1;
            if (month == 0) {
                month = 12;
                year = year - 1;
            }
            days = days + getNoOfDaysInMonth(month, year);
        } else {
            days = days - getNoOfDaysInMonth(month, year);
            month = month + 1;
            if (month > 12) {
                month = 1;
                year = year + 1;
            }

        }
        return addOrSubDays(days, month, year);
    }

    private int getNoOfDaysInMonth(int month, int year) {
        if (month == 2 && checkIsLeepYear(year)) {
            return daysInMonth.get(month) + 1;
        }
        return daysInMonth.get(month);
    }

    private boolean checkIsLeepYear(int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        }
        return false;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoOfDaysBetweenTwoDates)) return false;

        NoOfDaysBetweenTwoDates that = (NoOfDaysBetweenTwoDates) o;

        if (day != that.day) return false;
        if (month != that.month) return false;
        return year == that.year;
    }

    @Override
    public int hashCode() {
        int result = day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }
}