
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AddSubtractDate {
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

    public AddSubtractDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public AddSubtractDate addOrSubDays(int amount) {
        this.amount = amount;
        return addOrSubDays(this.day + this.amount, this.month, this.year);
    }

    public static void main(String[] args) {
        int amount = 0;
        amount = -15;
//        amount = 21;

        AddSubtractDate addSubtractDate = new AddSubtractDate(11, 8, 2017);
        AddSubtractDate addOrSubDays = addSubtractDate.addOrSubDays(amount);

        System.out.println(addOrSubDays.getDay() + "-" + addOrSubDays.getMonth() + "-" + addOrSubDays.getYear());

        // Testing
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, amount);
        System.out.println(cal.getTime());
    }

    private AddSubtractDate addOrSubDays(int days, int month, int year) {
        if (days > 0 && days <= getNoOfDaysInMonth(month, year)) {
            return new AddSubtractDate(days, month, year);
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
}
