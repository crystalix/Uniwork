package com.example.emma.uniwork;

/**
 * Created by Emma on 11/10/2015.
 */
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.annotation.Target;

//This class is used to handle the UI and output of the user preferences screen
public class mcSavingDataOutput extends Activity implements View.OnClickListener
{
    //Variables to handle preferences and UI
    SharedPreferences mcSharedPrefs;
    Button btnBack;
    TextView mcSDODOW;
    TextView mcSDOMonth;
    TextView mcSDODayBorn;
    TextView mcSDStarSign;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        //Buttons and text initialised, and preferences loaded
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mc_display_shared_prefs);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        mcSDODOW = (TextView) findViewById(R.id.tvDOW);
        mcSDOMonth = (TextView) findViewById(R.id.tvMonth);
        mcSDODayBorn = (TextView) findViewById(R.id.tvDayBorn);
        mcSDStarSign = (TextView) findViewById(R.id.tvStarSign);

        mcSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        loadSavedPreferences();
        Log.e("n", "SDOutput msg");
    }

    //Gets the user's saved preferences and displays them on screen
    private void loadSavedPreferences()
    {
        mcSDODOW.setText(mcSDODOW.getText()+String.valueOf(mcSharedPrefs.getInt("mc_DOW",1)));
        mcSDOMonth.setText(mcSDOMonth.getText()+String.valueOf(mcSharedPrefs.getInt("mc_Month",1)));
        mcSDODayBorn.setText((mcSDODayBorn.getText()+String.valueOf(mcSharedPrefs.getString("mc_DayBorn", "Sunday"))));
        mcSDStarSign.setText(mcSDStarSign.getText()+ mcSharedPrefs.getString("mc_StarSign","January"));
    }

    //Button to click to go back to main window
    public void onClick(View view)
    {

        setResult(Activity.RESULT_OK);
        finish();
    }

}

