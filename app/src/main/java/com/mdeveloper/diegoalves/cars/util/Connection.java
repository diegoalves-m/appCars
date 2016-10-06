package com.mdeveloper.diegoalves.cars.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Diego Alves on 22/09/2016.
 */

public class Connection {

    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo infoActive = connectivity.getActiveNetworkInfo();
        if (infoActive == null) {
            return false;
        } else {
            if (infoActive.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            } else if (infoActive.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true;
            }
        }
      return false;
    }

}
