package com.example.emma.uniwork;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)

/**
 * Created by Emma on 13/10/2015.
 */

//this class gives a pop up showing the about message with an ok button to close it when read
public class mcAboutDialogue extends DialogFragment
{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder mcAboutDialog = new AlertDialog.Builder(getActivity());
        mcAboutDialog.setMessage("This app will tell you your horoscope").setPositiveButton("Ok",new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog,int id)
            {

            }
        });

        mcAboutDialog.setTitle("About");
        mcAboutDialog.setIcon(R.drawable.ic_menu_action_about);
        return mcAboutDialog.create();
    }


}
