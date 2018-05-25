

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

    public static void main(String[] args) {
        int amount = 0;
        amount = -15;
//        amount = 21;
        int day1= 28 , day2= 25;
        int m1 = 4, m2 = 1;
        int y1= 2000, y2=2018;

        NoOfDaysBetweenTwoDates addSubtractDate = new NoOfDaysBetweenTwoDates(day1, m1, y1);
        NoOfDaysBetweenTwoDates myDate1 = new NoOfDaysBetweenTwoDates(day2, m2, y2);
        System.out.println(getDifference(addSubtractDate, myDate1));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH,m1-1);
        cal.set(Calendar.DAY_OF_MONTH,day1);
        cal.set(Calendar.YEAR,y1);
        long timeInMillis = cal.getTimeInMillis();
        cal.set(Calendar.MONTH,m2-1);
        cal.set(Calendar.DAY_OF_MONTH,day2);
        cal.set(Calendar.YEAR,y2);
        long timeInMillis1 = cal.getTimeInMillis();
        long diff = timeInMillis1 - timeInMillis;
        System.out.println(diff / (24 * 60 * 60 * 1000));

        /*NoOfDaysBetweenTwoDates addSubtractDate = new NoOfDaysBetweenTwoDates(8, 1, 2018);
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
        System.out.println(diff / (24 * 60 * 60 * 1000));*/
    }
    public static long getDifference(NoOfDaysBetweenTwoDates dt1, NoOfDaysBetweenTwoDates dt2) {
        // COUNT TOTAL NUMBER OF DAYS BEFORE FIRST DATE 'dt1'
        long day =0;
            int y1 = dt1.year;
            int y2 = dt2.year;
            int m1 = dt1.month;
            int m2 = dt2.month;
            int d1 = dt1.day;
            int d2 = dt2.day;
            boolean currentMonthCalculated = false;
            if(y1 > y2){
                int temp = y1;
                y1=y2;
                y2=temp;
                temp = m1;
                m1 = m2;
                m2 =temp;
                temp = d1;
                d1 = d2;
                d2 = temp;
            }
            if(y1 <= y2) {
                /*int yearDiff = y2 - y1-1;
                for(int i=y1;i<y2;i++){
                    if(checkIsLeepYear(i)){
                        day++;
                    }
                }
                day+= yearDiff*365;
                y1=y2;*/
                    while (m1 <= 12 && y1 <= y2 ) {
                        System.out.println("calculating day for the month " + m1 + " and year "  + y1);
                        if (m1 == dt1.month && !currentMonthCalculated) {
                            if(checkIsLeepYear(y1) && m1 ==2) day++;
                            day += daysInMonth.get(m1) - d1;
                            currentMonthCalculated = true;
                        }else{
                            if(y1 == y2 && m1 == m2){
                                day+= d2;
                                break;
                            }else{
                                if(checkIsLeepYear(y1) && m1 ==2) day++;
                                day+= daysInMonth.get(m1);
                            }
                        }
                        m1++;
                        if(m1 == 13){
                            y1++;
                            m1=1;
                        }
                    }
            }
        return day;
    }

    private static boolean checkIsLeepYear(int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        }
        return false;
    }
}