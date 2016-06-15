package com.tenforwardconsulting.cordova.bgloc.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by rushabh on 5/9/14.
 */
public class PreferenceHelper {


    public static final String DISTANCE_IN_KM = "distance_travelled";
    public static final String IS_DISTANCE_TO_BE_CALCULATED ="distance_calculation_enabled";
    private SharedPreferences preference;




    public float getTravelledDistance(){
        return getFloat(DISTANCE_IN_KM,0f);
    }


    public PreferenceHelper(Context context){
        try {
            preference=context.getSharedPreferences("com.quifers.deliveryboy", Context.MODE_PRIVATE);
        }
        catch (Exception e)
        {

        }


    }



    public void removeSession()
    {
        SharedPreferences.Editor editor = preference.edit();

        editor.clear();
        editor.apply();
    }



    public int getInt(String key,int returnValue)
    {
        return preference.getInt(key,returnValue);
    }

    public int getInt(String key)
    {
        return  preference.getInt(key, -1);
    }

    /*Saving & getting string from preference*/
    public void saveString(String key,String value)
    {
        preference.edit().putString(key,value).apply();
    }

    public String getString(String key,String returnVale)
    {
        return preference.getString(key,returnVale);
    }

    public String getString(String key)
    {
        return  preference.getString(key, null);
    }

    /*saving getting boolean*/

    public void saveBoolean(String key,boolean value)
    {
        preference.edit().putBoolean(key,value).apply();
    }

    public boolean getBoolean(String key)
    {
        return preference.getBoolean(key, false);
    }
    public boolean getBoolean(String key,boolean value)
    {
        return preference.getBoolean(key,value);
    }

    /*getting and saving float*/

    public void saveFloat(String key,float value)
    {
        preference.edit().putFloat(key,value).apply();
    }


    public float getFloat(String key,float returnValue)
    {
        return preference.getFloat(key, returnValue);
    }
    public float getFloat(String key)
    {
        return  preference.getFloat(key, -1.0f);
    }

    public boolean contains(String key){
        return preference.contains(key);
    }


    public boolean isDistanceToBeCalculated(){
        return getBoolean(IS_DISTANCE_TO_BE_CALCULATED,false);

    }

    public void startDistanceCalculation(){
        setDistanceCalculationFlag(true);
    }

    public void stopDistanceCalculation(){
        setDistanceCalculationFlag(false);
    }

    public void setDistanceCalculationFlag (boolean value){
        this.saveBoolean(this.IS_DISTANCE_TO_BE_CALCULATED,value);
    }

}
