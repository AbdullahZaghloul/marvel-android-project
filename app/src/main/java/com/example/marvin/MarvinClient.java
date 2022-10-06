package com.example.marvin;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvinClient {
    private static MarvinClient instance = null;
    private MyAPI myAPI;

    private MarvinClient()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myAPI = retrofit.create(MyAPI.class);
    }
    public static  synchronized MarvinClient getInstance(){
        if(instance==null) {
            instance = new MarvinClient();
        }
        return instance;
    }
    public MyAPI getMyAPI() {return myAPI;}
}
