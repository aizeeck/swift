package lesson5.Task3_DateDifference;

/**
 *
 * @author aizeeck
 */
public class SwiftDate {

    private int year;
    private int month;
    private int day;

    public SwiftDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isLeapYear() {
        boolean isLeap = false;
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 != 0 && year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLeapYear(int year) {
        boolean isLeap = false;
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 != 0 && year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getCentury() {
        return year / 100 + 1;
    }

    public int getDaysDifference(SwiftDate other) {
        return Math.abs(other.getDays() - this.getDays()) + 1;
    }
    
    private int getDays() {
        int days = 0;

        for (int i = 0; i < getYear(); i++) {
            if (isLeapYear(i)) {
                days += 366;
            } else {
                days += 365;
            }
        }

        for (int i = 0; i < getMonth(); i++) {
            switch (i) {
                case 2:
                    days += isLeapYear() ? 29 : 28;
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days += 31;
                    break;
                default:
                    days += 30;
                    break;
            }
        }
        days += getDay();
        return days;
    }

    public String getInfo() {
        return toString();
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        String info = String.format("%04d %02d %02d - %d century. ", getYear(), getMonth(), getDay(), getCentury());
        if (isLeapYear()) {
            info += "It is LEAP year.";
        }
        return info;
    }
}
