package com.example.surahyaseen.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.surahyaseen.calenderUtils.IslamicCalender;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class HGDate {
    private final Calendar calendar;
    private int day;
    private int dayHigri;
    private int month;
    private int monthHigri;
    private int year;
    private int yearHigri;

    public void toGregorian() {
    }

    public void toHigri() {
    }



    public HGDate() {
        Calendar instance = Calendar.getInstance();
        this.calendar = instance;
        getDate(instance);
    }

    private void getDate(Calendar calendar2) {
        this.day = calendar2.get(5);
        this.month = calendar2.get(2) + 1;
        this.year = calendar2.get(1);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.year, this.month - 1, this.day);
        IslamicCalender ummalquraCalendar = new IslamicCalender();
        ummalquraCalendar.setTime(gregorianCalendar.getTime());
        this.dayHigri = ummalquraCalendar.get(5);
        this.monthHigri = ummalquraCalendar.get(2) + 1;
        this.yearHigri = ummalquraCalendar.get(1);
        Log.e("hoang", this.dayHigri + "/" + this.monthHigri + "/" + this.yearHigri);
    }

    public HGDate(HGDate hGDate) {
        this.calendar = hGDate.calendar;
        this.dayHigri = hGDate.dayHigri;
        this.monthHigri = hGDate.monthHigri;
        this.yearHigri = hGDate.yearHigri;
        this.day = hGDate.day;
        this.month = hGDate.month;
        this.year = hGDate.year;
    }

    public void setHijri(int i, int i2, int i3) {
        IslamicCalender ummalquraCalendar = new IslamicCalender(i, i2 - 1, i3);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(ummalquraCalendar.getTime());
        this.day = gregorianCalendar.get(5);
        this.month = gregorianCalendar.get(2) + 1;
        int i4 = gregorianCalendar.get(1);
        this.year = i4;
        this.dayHigri = i3;
        this.monthHigri = i2;
        this.yearHigri = i;
        this.calendar.set(i4, this.month - 1, this.day);
    }

    public void setGregorian(int i, int i2, int i3) {
        this.day = i3;
        this.month = i2;
        this.year = i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(i, i2 - 1, i3);
        IslamicCalender ummalquraCalendar = new IslamicCalender();
        ummalquraCalendar.setTime(gregorianCalendar.getTime());
        this.dayHigri = ummalquraCalendar.get(5);
        this.monthHigri = ummalquraCalendar.get(2) + 1;
        this.yearHigri = ummalquraCalendar.get(1);
        this.calendar.set(this.year, this.month - 1, this.day);
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public int getDayHigri() {
        return this.dayHigri;
    }

    public int getMonthHigri() {
        return this.monthHigri;
    }

    public int getYearHigri() {
        return this.yearHigri;
    }

    public int weekDay() {
        return this.calendar.get(7);
    }

    public void nextDay() {
        this.calendar.add(5, 1);
        getDate(this.calendar);
    }

    public void previousDay() {
        this.calendar.add(5, -1);
        getDate(this.calendar);
    }

    @NonNull
    public String toString() {
        return this.dayHigri + "/" + this.monthHigri + "/" + this.yearHigri;
    }
}
