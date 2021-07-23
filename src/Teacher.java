import util.DateTimeUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Teacher {
    String rollNumber;
    String name;
    Date dayEat;
    int number;

    public Teacher() {
    }

    public Teacher(String rollNumber, String name, String dayEat, int number) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.dayEat = DateTimeUtil.parseDateString(dayEat);
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("%5s%20s%5s | %1s%21s%14s | %8s%10s%8s ",
                "",getRollNumber(), "",
                "",getName(), "",
                "",getNumber(), "");
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDayEat() {
        return dayEat;
    }

    public void setDayEat(Date dayEat) {
        this.dayEat = dayEat;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
