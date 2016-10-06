package com.mdeveloper.diegoalves.cars.domain;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Diego Alves on 31/05/2016.
 */
public class CarService {

    private static final String URL = "http://www.livroandroid.com.br/livro/carros/carros_{tipo}.json";
    private static String json;

    public static List<Car> getCars(Context context, final String type) throws IOException {
        final String url = URL.replace("{tipo}", type);

        try {
            OkHttpClient httpClient = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Response response = httpClient.newCall(request).execute();
            json = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<Car> cars = parseJson(context, json);
        return cars;
    }

    private static List<Car> parseJson(Context context, String json) {
        List<Car> cars = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(json);
            JSONObject object = root.getJSONObject("carros");
            JSONArray jsonArray = object.getJSONArray("carro");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Car car = new Car();
                car.name = jsonObject.optString("nome");
                car.desc = jsonObject.optString("desc");
                car.urlPhoto = jsonObject.optString("url_foto");
                car.urlInfo = jsonObject.optString("url_info");
                car.urlVideo = jsonObject.optString("url_video");
                car.latitude = jsonObject.optString("latitude");
                car.longitude = jsonObject.optString("longitude");

                cars.add(car);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cars;
    }

}
