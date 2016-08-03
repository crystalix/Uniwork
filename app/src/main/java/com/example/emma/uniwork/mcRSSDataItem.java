package com.example.emma.uniwork;

import java.io.Serializable;

public class mcRSSDataItem implements Serializable
{

    //variables to store the horoscope info
    private String itemTitle;
    private String itemDesc;
    private String itemLink;

  //Getters and setters used to get access to the variables to change and retrieve them

    public String getItemTitle()
    {
        return this.itemTitle;
    }

    public void setItemTitle(String sItemTitle)
    {
        this.itemTitle = sItemTitle;
    }


    public String getItemDesc()
    {
        return this.itemDesc;
    }

    public void setItemDesc(String sItemDesc)
    {
        this.itemDesc = sItemDesc;
    }

    public String getItemLink()
    {
        return this.itemLink;
    }

    public void setItemLink(String sItemLink)
    {
        this.itemLink = sItemLink;
    }

//Constructor, sets data to empty
    public mcRSSDataItem()
     {
         this.itemTitle = "";
         this.itemDesc = "";
         this.itemLink = "";
     }

    @Override
    //Breaks down the horoscope data into title, description and link
     public String toString()
    {
         String starSignRSSHoroscopeData;
         starSignRSSHoroscopeData = "mcRSSDataItem [itemTitle=" + itemTitle;
         starSignRSSHoroscopeData = ", itemDesc=" + itemDesc;
         starSignRSSHoroscopeData = ", itemLink=" + itemLink +"]";
         return starSignRSSHoroscopeData;
    }

             }