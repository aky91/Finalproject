package com.example.finalproject;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import java.util.Locale;

public class Language extends Application {

    private static Language language = new Language();
    public static Language getInstance(){return language;}

    //https://www.youtube.com/watch?v=zILw5eV9QBQ source for changing the language
    @SuppressWarnings("deprecation")
    //changes the language in configurations and updates it
    public void setLocale(String language, Context cont){
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = cont.getResources().getConfiguration();
        config.locale = locale;
        cont.getResources().updateConfiguration(config, cont.getResources().getDisplayMetrics());

        //setting language to shared preferences and creates a settings file in shared preferences directory so app can load it  when opened again
        SharedPreferences.Editor editor = cont.getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_language", language);
        editor.apply();
    }

    //loading language from shared preferences directory
    public void loadLocale(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = sharedPreferences.getString("My_language","");
        setLocale(language, context);
    }

}
