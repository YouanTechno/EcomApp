package com.example.ecomapp;

import com.example.ecomapp.models.Factures;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("tresfactures")
    Call<List<Factures>> getFactures();
}
