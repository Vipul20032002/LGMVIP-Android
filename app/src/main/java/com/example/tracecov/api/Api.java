package com.example.tracecov.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    static final String BASE_URL = "https://data.covid19india.org";

    @GET("state_district_wise.json")
    Call<List<CovidData>> getCovidData();
    /*Call<List<CovidData>> getCovidData;*/
}
