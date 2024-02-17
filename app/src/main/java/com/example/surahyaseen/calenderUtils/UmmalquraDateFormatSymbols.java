package com.example.surahyaseen.calenderUtils;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

class UmmalquraDateFormatSymbols {
    Locale locale = null;
    String[] months = null;
    String[] shortMonths = null;

    public UmmalquraDateFormatSymbols() {
        initializeData(Locale.getDefault(Locale.Category.FORMAT));
    }

    public UmmalquraDateFormatSymbols(Locale locale2) {
        initializeData(locale2);
    }

    public String[] getMonths() {
        String[] strArr = this.months;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public String[] getShortMonths() {
        String[] strArr = this.shortMonths;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    private void initializeData(Locale locale2) {
        if ("ar".equalsIgnoreCase(locale2.getLanguage()) || "en".equalsIgnoreCase(locale2.getLanguage())) {
            this.locale = locale2;
            ResourceBundle bundle = ResourceBundle.getBundle("com.github.msarhan.ummalqura.calendar.text.UmmalquraFormatData", locale2);
            this.months = bundle.getStringArray("MonthNames");
            this.shortMonths = bundle.getStringArray("MonthAbbreviations");
            return;
        }
        throw new IllegalArgumentException("Supported locales are 'English' and 'Arabic'");
    }
}
