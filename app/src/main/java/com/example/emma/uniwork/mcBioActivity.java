package com.example.emma.uniwork;

/**
 * Created by Emma on 30/11/2015.
 */
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;

public class mcBioActivity extends Activity
{
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    //@Override
    protected void OnCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mc_bio_draw_screen);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    setContentView(new mcBiorhythmsSurfaceView(this));
}
}
