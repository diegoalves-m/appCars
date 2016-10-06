package com.mdeveloper.diegoalves.cars.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Diego Alves on 23/09/2016.
 */

public class Prefs {

    public static final String PREF_ID = "prefsUser";

    public static void setBoolean(Context context, String chave, boolean on) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(chave, on);
        editor.commit();
    }

    public static boolean getBoolean(Context context, String chave) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        return pref.getBoolean(chave, true);
    }

    public static void setInteger(Context context, String chave, int valor) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(chave, valor);
        editor.commit();
    }

    public static int getInteger(Context context, String chave) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        return pref.getInt(chave, 0);
    }

    public static void setString(Context context, String chave, String valor) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(chave, valor);
        editor.commit();
    }

    public static String getString(Context context, String chave) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        return pref.getString(chave, "");
    }


}
