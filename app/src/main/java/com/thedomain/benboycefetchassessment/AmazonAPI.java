package com.thedomain.benboycefetchassessment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AmazonAPI {

    @GET("hiring.json")
    Call<List<Item>> getItems();

}
