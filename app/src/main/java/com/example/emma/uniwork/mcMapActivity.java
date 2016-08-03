package com.example.emma.uniwork;

/**
 * Created by Emma on 11/12/2015.
 */

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.MapFragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//this class doesn't work as the method getMaps() claims to not exist
public class mcMapActivity extends AppCompatActivity
{
    //initial variables including a google maps to store everything in, a list of data, cooordinates and a marker to point to places on the map
    private GoogleMap mapStarSigns;
    List<mcMapData> mapDataList;
    private Marker[] mapDataMarkerList = new Marker[5];
    private float markerColours[] = {210.0f,120.0f,300.0f,270.0f};
    private LatLng latLangEKCentre = new LatLng(55.7591402,-4.1883331);


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        //screen set to portrait and mc_map_view used as the layout
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.mc_map_view);

        //data initialised, map list to put the data in and the database that will be accessed
        mapDataList = new ArrayList<mcMapData>();
        mcMapDataDBMgr mapDB = new mcMapDataDBMgr(this, "mapEKFamous5.s3db", null, 1);

        //makes the database
        try
        {
            mapDB.dbCreate();
        }

        catch (IOException e)
        {
            //handles errors in creating database
            e.printStackTrace();
        }

        //puts the data from the database into the data list variable
        mapDataList = mapDB.allMapData();
        SetUpMap();
        AddMarkers();
    }

    //this method initalises the map, focusing on the correct location and allowing UI functions to be enabled
        public void SetUpMap()
         {
             //mapStarSigns =((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            if(mapStarSigns!=null)
            {
            mapStarSigns.moveCamera(CameraUpdateFactory.newLatLngZoom(latLangEKCentre,12));
            //mapStarSigns.setMyLocationEnabled(true);
            mapStarSigns.getUiSettings().setCompassEnabled(true);
            mapStarSigns.getUiSettings().setMyLocationButtonEnabled(true);
            mapStarSigns.getUiSettings().setRotateGesturesEnabled(true);
             }
         }

    //This method adds markers to the map
    //This allows the user to see the places the people the database has info on as well as details about them
        public void AddMarkers()
        {
            MarkerOptions marker;
            mcMapData mapData;
            String mrkTitle;
            String mrkText;

            for(int i =0; i <mapDataList.size();i++)
            {
                mapData =mapDataList.get(i);
                mrkTitle =mapData.getFirstname()+"" +mapData.getSurname() +" Occupation: " + mapData.getOccupation();
                mrkText = "Star Sign: " + mapData.getStarSign();
                marker = SetMarker(mrkTitle, mrkText, new LatLng(mapData.getLatitude(), mapData.getLongitude()), markerColours[i], true);
                mapDataMarkerList[i] =mapStarSigns.addMarker(marker);

            }


        }

    public MarkerOptions SetMarker(String title, String snippet, LatLng position, float markerColour, boolean centreAnchor)
    {
        float anchorX;
        float anchorY;

        if (centreAnchor)
        {
            anchorX = 0.5f;
            anchorY = 0.5f;
        }
        else
        {
            anchorX = 0.5f;
            anchorY = 1.0f;
        }

        MarkerOptions marker  = new MarkerOptions().title(title).snippet(snippet).icon(BitmapDescriptorFactory.defaultMarker(markerColour)).anchor(anchorX,anchorY).position(position);

        return marker;

    }
}

