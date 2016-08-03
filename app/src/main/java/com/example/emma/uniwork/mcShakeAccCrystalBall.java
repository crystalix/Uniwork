package com.example.emma.uniwork;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by Emma on 03/08/2016.
 */


//The accelerometer part didn't seem to work so I just left it as a random number generated fortune
public class mcShakeAccCrystalBall extends Activity
{
    Button backBtn;
    String futureList[] = {"Your future looks bright as a lightbulb", "Be careful, dangers lie ahead", "Don't trust new friends", "It's time for a change"};

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mc_crystalball_output);
        backBtn= (Button) findViewById(R.id.btnBack);
        //This generates a random number between 1 and 4
        Random randNumber = new Random();
        int iNumber = randNumber.nextInt(4)+1;

        //This sets the text in the textview to the text that matches the random number given
        TextView futureText = (TextView) findViewById(R.id.cb_out_msg);
        futureText.setText(""+futureList[iNumber]);

    }

    //This sends the user back to the previous context
    public  void onClick(View view)
    {
        setResult(Activity.RESULT_OK);
        finish();
    }


}
