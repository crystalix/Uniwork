package com.example.emma.uniwork;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;
//import android.R;

//This class handles the UI and horoscope output shown on the output screen
public class mcOutputScreen extends AppCompatActivity implements View.OnClickListener
{
    //Widgets used to create functionality and display data
    Button btnDatePick;
    Button btnShowSavedData;
    Button showPoem;
    ImageView ivStarSign;
    TextView tvStarSign;
    TextView tvStarSignDates;
    TextView tvStarSignChars;
    TextView tvHoroscope;
    TextView tvDayBorn;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mc_output_screen); // app main ui screen
        //setup, access and listen for pick date button
        btnDatePick = (Button) findViewById(R.id.btnPickDate);
        btnDatePick.setOnClickListener(this);
        btnShowSavedData = (Button) findViewById(R.id.btnSavedData);
        btnShowSavedData.setOnClickListener(this);
        showPoem = (Button) findViewById(R.id.btnFortune);
        showPoem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent fortune = new Intent(getApplicationContext(), mcShakeAccCrystalBall.class);
                startActivity(fortune);
            }
        });




        //display text
        tvStarSign = (TextView) findViewById(R.id.tvStarSign);
        tvStarSignDates = (TextView) findViewById(R.id.tvStarSignDates);
        tvStarSignChars = (TextView) findViewById(R.id.tvStarSignChars);

        //display star sign image
        ivStarSign =(ImageView) findViewById(R.id.imgViewStarSign);

        //TextView mcOutput = (TextView) findViewById(R.id.tvOutputMsg);
        Intent iMainAct = getIntent();

        //Sets the text output to the info provided by the user

        //mcOutput.setText(iMainAct.getStringExtra("mcOutputMsg"));
        mcStarSignsInfo starSignsInfo = (mcStarSignsInfo) iMainAct.getSerializableExtra("starSignInfo");
        tvStarSign.setText(starSignsInfo.getStarSign());
        tvStarSignDates.setText(starSignsInfo.getStarSignDates());
        tvStarSignChars.setText(starSignsInfo.getStarSignCharacteristics());
        String sImagePath = "drawable/" + starSignsInfo.getStarSignImg();
        Context appContext = getApplicationContext();
        int imgResID = appContext.getResources().getIdentifier(sImagePath, "drawable","com.example.emma.uniwork");
        ivStarSign.setImageResource(imgResID);

        //get horoscope from RSS feed
        mcRSSDataItem userHoroscope = new mcRSSDataItem();
        String RSSFeedURL = "http://www.findyourfate.com/rss/dailyhoroscope-feed.asp?sign=" + starSignsInfo.getStarSign();
        //The url that had the correct star sign added is now gave to the rss parser class to parse
        mcAsyncRSSParser rssAsyncParse = new mcAsyncRSSParser(this, RSSFeedURL);
        try
        {
            userHoroscope = rssAsyncParse.execute("").get();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        catch(ExecutionException e)
        {
            e.printStackTrace();
        }

        //Horoscope got from parser displayed
        tvHoroscope = (TextView) findViewById(R.id.tvStarSignHoroscope);
        tvHoroscope.setText(userHoroscope.getItemDesc());

    }

    //Handles button clicks
    public void onClick(View view) {
        switch (view.getId()) {

            //If the saved data button is pressed the user will see their saved preferences
            case R.id.btnSavedData:
                Intent mcDataOutput = new Intent(getApplicationContext(), mcSavingDataOutput.class);
                startActivity(mcDataOutput);
                break;
            //If the pick date button is pressed the app will go back to the main screen

            case R.id.btnFortune:
                Intent fortune= new Intent(getApplicationContext(), mcShakeAccCrystalBall.class);
                startActivity(fortune);
                break;

            case R.id.btnPickDate:
                setResult(Activity.RESULT_OK);
                finish();
                break;

        }
    }

}



