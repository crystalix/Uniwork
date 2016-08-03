package com.example.emma.uniwork;

/**
 * Created by Emma on 31/07/2016.
 */
import java.io.Serializable;

/**
 * Created by rla on 10/10/2014.
 */
public class mcMapData implements Serializable{

//data to be stored

    private int entryID;
    private String Surname;
    private String Firstname;
    private String StarSign;
    private String Occupation;
    private float Latitude;
    private float Longitude;

    private static final long serialVersionUID = 0L;

//getters and setters that allow the information on the people to be set and retrieved

    public int getEntryID() {
        return entryID;
    }

    public void setEntryID(int entryID) {
        this.entryID = entryID;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public String getStarSign() {
        return StarSign;
    }

    public void setStarSign(String starSign) {
        this.StarSign = starSign;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        this.Occupation = occupation;
    }

    public float getLatitude()
    {
        return Latitude;
    }

    public void setLatitude(float Lat)
    {
        this.Latitude = Lat;
    }

    public float getLongitude()
    {
        return Longitude;
    }

    public void setLongitude(float fLongitude)
    {
        this.Longitude = fLongitude;
    }

    @Override
    public String toString()
    {
        String mapData;
        mapData = "mcStarSignsInfo [entryID=" + entryID;
        mapData = ", Surname=" + Surname;
        mapData = ", Firstname=" + Firstname;
        mapData = ", StarSign=" + StarSign;
        mapData = ", Occupation=" + Occupation;
        mapData = ", Latitude=" + Latitude;
        mapData = ", Longitude=" + Longitude +"]";
        return mapData;
    }

}
