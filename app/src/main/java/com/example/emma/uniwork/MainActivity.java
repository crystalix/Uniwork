package com.example.emma.uniwork;

        import android.annotation.TargetApi;
        import android.app.DialogFragment;
        import android.app.FragmentManager;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.content.pm.ActivityInfo;
        import android.graphics.Canvas;
        import android.os.Build;
        import android.preference.PreferenceManager;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.graphics.Canvas;

        import java.io.IOException;
//import android.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    DatePicker dpBDay;
    Button submitBtn;
    mcSaveData mcSDPrefs;
    SharedPreferences mySharedPrefs;
    FragmentManager fmAboutDialogue;
    String sOutputMsg;
    mcStarSignsInfo userStarSignInfo;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        dpBDay=(DatePicker)findViewById(R.id.datePickerBDay);
        dpBDay.setCalendarViewShown(false);
        submitBtn=(Button)findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(this);
        userStarSignInfo = new mcStarSignsInfo();

        mySharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mcSDPrefs = new mcSaveData(mySharedPrefs);
        mcSDPrefs.setDefaultPrefs();
        //send data to new activity


        fmAboutDialogue = this.getFragmentManager();
        Log.e("n", "message");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClick(View view)
    {
        mondaysChild mcYourDay = new mondaysChild(dpBDay.getDayOfMonth(),dpBDay.getMonth(),dpBDay.getYear());
        Astrology usersStarSign =new Astrology(dpBDay.getDayOfMonth(),dpBDay.getMonth()+1);

        mcStarSignsInfoDBMgr dbStarSignsMgr = new mcStarSignsInfoDBMgr(this, "starsigns.s3db",null,1);
        try
        {
          dbStarSignsMgr.dbCreate();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //save prefs

        mcSDPrefs.savePreferences("mc_DOW",mcYourDay.getiDOW());
        mcSDPrefs.savePreferences("mcMonth",mcYourDay.getiMonth());
        mcSDPrefs.savePreferences("mcDayBorn",mcYourDay.getsDOW());
        mcSDPrefs.savePreferences("mc_StarSign",usersStarSign.getsStarSign());

        userStarSignInfo =dbStarSignsMgr.findStarSign(usersStarSign.getsStarSign());

        Intent mcOutput_Screen = new Intent(getApplicationContext(),mcOutputScreen.class);
        sOutputMsg =mcYourDay.getsOutputMsg();
        mcOutput_Screen.putExtra("mcOutputMsg",sOutputMsg);

        //mcOutput_Screen.putExtra("mcStarSign",usersStarSign.getsStarSign());

        mcOutput_Screen.putExtra("starSignInfo", userStarSignInfo);

        Log.e("n", mcYourDay.getsOutputMsg());
        startActivity(mcOutput_Screen);
    }

    public void onClick()
    {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.mc_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mBio:
                Intent mcBioDraw = new Intent(this, mcBioActivity.class);
                this.startActivity(mcBioDraw);
                return true;
            case R.id.mQuit:
                finish();
                return true;
            case R.id.mAbout:
                DialogFragment mcAboutDlg = new mcAboutDialogue();
                mcAboutDlg.show(fmAboutDialogue,"mc_About_Dlg");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
