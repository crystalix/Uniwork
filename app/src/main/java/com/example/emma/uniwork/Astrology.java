package com.example.emma.uniwork;

/**
 * Created by Emma on 09/11/2015.
 */
public class Astrology {

//Variables used in the class
         private int iStarSign;

         private String sStarSign;

        //getters and setters used to set and retrieve the star sign info

         public void setiStarSign(int iStarSign)
         {
         this.iStarSign = iStarSign;
         }

         public int getiStarSign()
         {
         return iStarSign;
         }

         public void setsStarSign(String sStarSign)
         {
         this.sStarSign = sStarSign;
         }

         public String getsStarSign()
         {
         return sStarSign;
         }


         public Astrology()
         {
         // set default value based on 1st January
        determineStarSign(1,1);
         }

         public Astrology(int aDay, int aMonth)
         {
         // set default value based on 1st January
         determineStarSign(aDay,aMonth);
         }


        //a switch statement is used to figure out the star sign from the date given
    // which depends on the portion of the month
         public void determineStarSign( int ssDay, int ssMonth) {

         switch (ssMonth) {
         case 1:
         if (ssDay > 20) {
         sStarSign = "Aquarius";
         } else {
         sStarSign = "Capricorn";
         }
         break;
         case 2:
         if (ssDay > 19) {
         sStarSign = "Pisces";
         } else {
         sStarSign = "Aquarius";
         }
         break;
         case 3:
         if (ssDay > 20) {
        sStarSign = "Aries";
         } else {
         sStarSign = "Pisces";
         }
         break;
         case 4:
         if (ssDay > 21) {
         sStarSign = "Taurus";
         } else {
         sStarSign = "Aries";
         }
         break;
         case 5:
         if (ssDay > 21) {
         sStarSign = "Gemini";
         } else {
         sStarSign = "Taurus";
         }
         break;
         case 6:
         if (ssDay > 21) {
         sStarSign = "Cancer";
         } else {
         sStarSign = "Gemini";
         }
         break;
         case 7:
         if (ssDay > 22) {
         sStarSign = "Leo";
        } else {
         sStarSign = "Cancer";
         }
         break;
         case 8:
         if (ssDay > 23) {
         sStarSign = "Virgo";
         } else {
         sStarSign = "Leo";
         }
         break;
         case 9:
         if (ssDay > 23) {
         sStarSign = "Libra";
         } else {
         sStarSign = "Virgo";
         }
         break;
         case 10:
         if (ssDay > 23) {
         sStarSign = "Scorpio";
         } else {
         sStarSign = "Libra";
         }
         break;
         case 11:
         if (ssDay > 22) {
         sStarSign = "Sagittarius";
         } else {
         sStarSign = "Scorpio";
         }
         break;
         case 12:
         if (ssDay > 21) {
         sStarSign = "Capricorn";
        } else {
         sStarSign = "Sagittarius";
         }
         break;
         default:
             //error message for date that doesn't exist
         sStarSign = "I'm sorry I don't recognise this date";
         }
         }
         }

