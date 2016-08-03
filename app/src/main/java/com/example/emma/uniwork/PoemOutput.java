package com.example.emma.uniwork;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Emma on 03/08/2016.
 */
public class PoemOutput extends Activity implements View.OnClickListener
{
    SharedPreferences mcSharedPrefs;
    TextView poemOutput;
    Button backButton;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mc_poem_display);
        backButton = (Button) findViewById(R.id.backBtn);
        backButton.setOnClickListener(this);
        poemOutput = (TextView) findViewById(R.id.poemText);
        mcSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        loadSavedPreferences();
    }


    private void loadSavedPreferences()
    {
       poemOutput.setText(poemOutput.getText()+String.valueOf(mcSharedPrefs.getString("sOutputmsg","empty")));
    }

    public void onClick(View view)
    {

        setResult(Activity.RESULT_OK);
        finish();
    }

}
