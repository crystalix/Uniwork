package com.example.emma.uniwork;

/**
 * Created by Emma on 30/11/2015.
 */
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;
import java.net.MalformedURLException;

    public class mcAsyncRSSParser extends AsyncTask<String, Integer, mcRSSDataItem>
    {
        private Context appContext;
        private String urlRSSToParse;

        public mcAsyncRSSParser(Context currentAppContext,String urlRSS)
        {
            appContext = currentAppContext;
            urlRSSToParse = urlRSS;
        }

        // A callback method executed on UI thread on
        //starting the task
       // @Override
        /*
        protected void onPreExecute()
        {
        // Message to indicate start of parsing
        Toast.makeText(appContext,"Parsing started!",
        Toast.LENGTH_SHORT).show();
        }*/

        @Override

        //this method parses the data
        protected mcRSSDataItem doInBackground(String...params)
        {
            //makes a variable to store the parsed data
        mcRSSDataItem parsedData;
            //parser is created
        mcRSSParser rssParser = new mcRSSParser();
        try
        {
            //attempt to parse the data given, the urlRSStoparse field being filled previously by a string urlRSS given to the class on creation
        rssParser.parseRSSData(urlRSSToParse);
        }
        catch(MalformedURLException e)
        {
            //error handled if failed
        e.printStackTrace();
        }
            //if successful, the parsed data is given to the parsed data variable and passed out
        parsedData = rssParser.getRSSDataItem();

        return parsedData;
        }

        // A callback method executed on UI thread, invoked
        //after the completion of the task
        // When doInbackground has completed, the return
        //value from that method is passed into this event
        // handler.

        /*
        @Override
        protected void onPostExecute(mcRSSDataItem result)
        {
        // Message to indicate end of parsing
        Toast.makeText(appContext,"Parsing finished!",
        Toast.LENGTH_SHORT).show();
         }*/
        }