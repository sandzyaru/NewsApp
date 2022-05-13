package com.example.newsapp.data.remote;

import com.example.newsapp.data.model.MainResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines")
    Call<MainResponse> getTopNews(
         @Query("apiKey") String apiKey,
         @Query("country") String country);
    @GET("top-headlines?category=business")
    Call<MainResponse> getBusinessNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=entertainment")
    Call<MainResponse> getEntertainmentNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=general")
    Call<MainResponse> getGeneralNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=health")
    Call<MainResponse> getHealthNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=science")
    Call<MainResponse> getScienceNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=sport")
    Call<MainResponse> getSportNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=technology")
    Call<MainResponse> getTechnologyNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);

}
