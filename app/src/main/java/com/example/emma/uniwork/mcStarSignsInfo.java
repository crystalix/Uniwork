package com.example.emma.uniwork;

import java.io.Serializable;

/**
 * Created by Emma on 11/11/2015.
 */
public class mcStarSignsInfo implements Serializable {

    //Variables to store star sign info
    private int starSignID;
    private String starSign;
    private String starSignImg;
    private String starSignDates;
    private String starSignCharacteristics;

    private static final long serialVersionUID = 0L;

        //Getters and setters handle the vriables being changed and/or accessed by other classes

    public int getStarSignID()
    {
         return starSignID;
    }

    public void setStarSignID(int starSignID)
    {
         this.starSignID = starSignID;
    }

    public String getStarSign()
    {
         return starSign;
    }

    public void setStarSign(String starSign)
    {
         this.starSign = starSign;
    }

    public String getStarSignImg()
    {
         return starSignImg;
    }

    public void setStarSignImg(String starSignImg)
    {
         this.starSignImg = starSignImg;
    }

    public String getStarSignDates()
    {
         return starSignDates;
    }

    public void setStarSignDates(String starSignDates)
    {
         this.starSignDates = starSignDates;
    }

    public String getStarSignCharacteristics()
    {
         return starSignCharacteristics;
    }

    public void setStarSignCharacteristics(String starSignCharacteristics)
    {
         this.starSignCharacteristics = starSignCharacteristics;
    }

    @Override
     public String toString()
    {
         String starSignData;
         starSignData = "mcStarSignsInfo [starSignID=" + starSignID;
         starSignData = ", starSign=" + starSign;
         starSignData = ", starSignImg=" + starSignImg;
         starSignData = ", starSignDates=" + starSignDates;
         starSignData = ", starSignCharacteristics=" + starSignCharacteristics +"]";
         return starSignData;
    }

             }
