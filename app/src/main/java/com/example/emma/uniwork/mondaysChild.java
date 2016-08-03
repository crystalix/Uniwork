package com.example.emma.uniwork;

import android.content.SharedPreferences;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.CharArrayReader;

/**
 * Created by Emma on 11/10/2015.
 */

//This class is no longer used.
    //It used to show the user the
public class mondaysChild {


        private int iDOW;
        private int iMonth;
        private int iYear;
        private int iDayOfWeek;

        private String sDOW;
        private String sLineFromPoem;
        private String[] saLinesOfPoem;
        private String[] saDOW;
        private String sOutputMsg;

    SharedPreferences mcSharedPrefs;

        private void setIDOW(int isDOW) {
            this.iDOW = isDOW;
        }

        public int getiDOW() {
            return iDOW;
        }

        private void setiMonth(int isMonth) {
            this.iMonth = isMonth;
        }

        public int getiMonth()
        {
            return iMonth;
        }

        private void setiYear(int isYear)
        {
            this.iYear = isYear;
        }

        public int getiYear()
        {
            return iYear;
        }

        private void setiDayOfWeek(int isDayOfWeek)
        {
            this.iDayOfWeek =isDayOfWeek;
        }

        public int getiDayOfWeek()
        {
            return iDayOfWeek;
        }

        private void setsDOW(int iDay)
        {
            this.sDOW = saDOW[iDay];
        }

        public String getsDOW()
        {
            return sDOW;
        }

        private void setsLineFromPoem(int iPoemLine)
        {
            this.sLineFromPoem = saLinesOfPoem[iPoemLine];
        }

        public String getsLineFromPoem()
        {
            return sLineFromPoem;
        }

        private void setSaLinesOfPoem()
        {
            saLinesOfPoem = new String[7];
            saLinesOfPoem[0] = "And the child that is born on the Sabbath day, Is bonny and blithe, and good and gay.";
            saLinesOfPoem[1] = "Monday's child is fair of face";
            saLinesOfPoem[2] = "Tuesday's child is full of grace";
            saLinesOfPoem[3] = "Wednesday's child is full of woe";
            saLinesOfPoem[4] = "Thursday's child has far to go";
            saLinesOfPoem[5] = "Friday's child is loving and giving";
            saLinesOfPoem[6] = "Saturday's child works hard for his living";
        }

        public String[] getSaLinesOfPoem()
        {
            return saLinesOfPoem;
        }

        private void setSaDOW()
        {
            saDOW = new String[7];
            saDOW[0] = "Sunday";
            saDOW[1] = "Monday";
            saDOW[2] = "Tuesday";
            saDOW[3] = "Wednesday";
            saDOW[4] = "Thursday";
            saDOW[5] = "Friday";
            saDOW[6] = "Saturday";
        }

        public String[] getSaDOW()
        {
            return  saDOW;
        }

        private void setsOutputMsg(String sOutMsg)
        {
            this.sOutputMsg = sOutMsg;
        }

        public String getsOutputMsg()
        {
            return sOutputMsg;
        }

        public mondaysChild()
        {
            setSaDOW();
            setSaLinesOfPoem();
            Calendar cCal = Calendar.getInstance();
            setIDOW(cCal.get(Calendar.DAY_OF_WEEK));
            setiMonth(cCal.get(Calendar.MONTH));
            setiYear(cCal.get((Calendar.YEAR)));
        }

        public mondaysChild(int mcDOW, int mcMonth, int mcYear)
        {
            setSaDOW();
            setSaLinesOfPoem();
            setIDOW(mcDOW);
            setiMonth(mcMonth);
            setiYear(mcYear);
            GregorianCalendar gcBDay = new GregorianCalendar(mcYear,mcMonth,mcDOW);
            setiDayOfWeek(gcBDay.get(Calendar.DAY_OF_WEEK)-1);
            setsDOW(getiDayOfWeek());
            setsLineFromPoem(getiDayOfWeek());
            String sTempStr = "You were born on a" + getsDOW() + "\n" + getsLineFromPoem();
            setsOutputMsg(sTempStr);
        }

    public void savePreferences(String key, String value) {
        SharedPreferences.Editor editor = mcSharedPrefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void setDefaultPrefs()
    {
        savePreferences("sOutputMsg","empty");
    }
    }

