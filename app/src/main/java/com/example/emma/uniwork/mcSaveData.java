package com.example.emma.uniwork;

/**
 * Created by Emma on 11/10/2015.
 */

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

//This class deals with saving the user's preferences
public class mcSaveData extends Activity {

    //Variables to track the users given date of birth
    SharedPreferences mcSharedPrefs;
    private int mcSDDOW;
    private int mcSDMonth;
    private String mcSDDayBorn;
    private String mcSDStarSign;

    //Getters and setters used to change and relay the data
    private void setMcSDDOW(int isDOW) {
        this.mcSDDOW = isDOW;
    }

    public int getMcSDDOW() {
        return mcSDDOW;
    }

    private void setMcSDMonth(int isMonth) {
        this.mcSDMonth = isMonth;
    }

    public int getMcSDMonth() {
        return mcSDMonth;
    }

    private void setMcSDDayBorn(String isDayBorn) {
        this.mcSDDayBorn = isDayBorn;
    }

    public String getmcSDDayBorn() {
        return mcSDDayBorn;
    }

    //Sets the starsign initially to January
    public void setMcSDStarSign(String mcSDStarSign)
    {
        this.mcSDStarSign = mcSDStarSign;
        setMcSDStarSign("January");
    }

    public String getMcSDStarSign()
    {
        return mcSDStarSign;
    }

    //Sets the data, if no data given, 1st January on a Sunday is used
    public mcSaveData(SharedPreferences mcSharedPrefs) {
        setMcSDDOW(1);
        setMcSDMonth(1);
        setMcSDDayBorn("Sunday");

        try {
            this.mcSharedPrefs = mcSharedPrefs;
        } catch (Exception e) {
            Log.e("n", "Pref Manager is NULL");
        }

        setDefaultPrefs();
    }

    //saves the user's preferences
    public void savePreferences(String key, boolean value) {
        SharedPreferences.Editor editor = mcSharedPrefs.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void savePreferences(String key, String value) {
        SharedPreferences.Editor editor = mcSharedPrefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void savePreferences(String key, int value) {
        SharedPreferences.Editor editor = mcSharedPrefs.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    //Preferences set, default ones given if empty
    public void setDefaultPrefs()
    {
        savePreferences("mc_DOW",1);
        savePreferences("mc_Month",1);
        savePreferences("mc_DayBorn", "Empty");
        savePreferences("mc_StarSign","Empty");
    }

}

