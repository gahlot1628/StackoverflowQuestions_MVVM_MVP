package com.kartik.stackoverflowquestions.Model.Retrofit;

import com.kartik.stackoverflowquestions.Model.Root;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/2.2/search/advanced?pagesize=100&order=desc&sort=relevance&q={android room}&site=stackoverflow&filter=!.UE46pK5nV.kfAr.")
    Call<Root> getListData();

}