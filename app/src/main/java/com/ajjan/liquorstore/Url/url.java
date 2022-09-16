package com.ajjan.liquorstore.Url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class url {
    public static final String base_url = "http://10.0.2.2:3000/";
    //public static final String base_url="http://10.1.18.144:3000";
    public static String token = "Bearer ";
    public static String imagePath = base_url + "uploads/";

    public static Retrofit getInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
