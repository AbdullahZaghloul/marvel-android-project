package com.example.marvin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPI {
    String BASE_URL = "https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<MarvinModel>>getMarvin();

}
