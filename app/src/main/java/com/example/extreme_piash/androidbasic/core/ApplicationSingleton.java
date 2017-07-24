package com.example.extreme_piash.androidbasic.core;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;

import com.example.extreme_piash.androidbasic.network.ApiClient;
import com.example.extreme_piash.androidbasic.network.NetworkCallInterface;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Retrofit;


/**
 * Created by Piash on 17-Aug-16.
 */
public class ApplicationSingleton extends Application {

    private static ApplicationSingleton sInstance;
    private SharedPreferences mPref;
    private NetworkCallInterface networkCallInterface;

    public static ApplicationSingleton getInstance() {
        return sInstance;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }



    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sInstance.initializeInstance();
    }

    private void initializeInstance() {
        mPref = this.getApplicationContext().getSharedPreferences("MyApplicationKey", MODE_PRIVATE);
    }

    public void savePrefString(String key, String value){
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public String getPrefString(String key){
        return mPref.getString(key, "");
    }


    public void savePrefBoolean(String key, boolean value){
        SharedPreferences.Editor editor = mPref.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
    public boolean getPrefBoolean(String key){
        return mPref.getBoolean(key, false);
    }

    public void savePrefInteger(String key, int value){
        SharedPreferences.Editor editor = mPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public int getPrefInteger(String key){
        return mPref.getInt(key, 0);
    }


    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public String printHashKey(Context pContext) {
        String hashKey = "";
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                hashKey = new String(Base64.encode(md.digest(), 0));
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("KEY_HASH", "printHashKey()", e);
        } catch (Exception e) {
            Log.e("KEY_HASH", "printHashKey()", e);
        }
        return  hashKey;
    }

    public boolean isUrlExists(String URLName){
        try {
            HttpURLConnection.setFollowRedirects(false);
            // note : you may also need
            //        HttpURLConnection.setInstanceFollowRedirects(false)
            HttpURLConnection con =
                    (HttpURLConnection) new URL(URLName).openConnection();
            con.setRequestMethod("HEAD");
            return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public String getFormattedDateString(String inputFormat, String outputFormat, String value){

        SimpleDateFormat inputPattern = new SimpleDateFormat(inputFormat);
        SimpleDateFormat outputPattern = new SimpleDateFormat(outputFormat);

        Date date = null;
        String str = null;

        try {
            date = inputPattern.parse(value);
            str = outputPattern.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public boolean containsKey(String key){
        return mPref.contains(key);
    }

    public void removeKey(String key){
        SharedPreferences.Editor editor = mPref.edit();
        editor.remove(key);
        editor.apply();
    }

    public String getDeviceID(){
        String android_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return android_id;
    }

    public String convertJsonElementToString(JsonElement jsonElement){
        Gson gson = new Gson();
        JsonElement element = gson.fromJson (jsonElement.toString(), JsonElement.class);
        JsonObject jsonObj = element.getAsJsonObject();

        return jsonObj.toString();
    }

    public NetworkCallInterface getNetworkCallInterface(){
        Retrofit retrofit = ApiClient.getInstance(this);
        networkCallInterface = retrofit.create(NetworkCallInterface.class);

        return networkCallInterface;
    }


    public boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }




}