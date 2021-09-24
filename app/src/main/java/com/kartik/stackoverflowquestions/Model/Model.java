package com.kartik.stackoverflowquestions.Model;

import android.content.Context;

import androidx.room.Room;

import com.kartik.stackoverflowquestions.Model.Retrofit.Api;
import com.kartik.stackoverflowquestions.Model.Room.AppDatabase;
import com.kartik.stackoverflowquestions.Model.Room.DataDao;
import com.kartik.stackoverflowquestions.Model.Room.Mapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model {

    private Context context;

    AppDatabase db ;
    Root root;
    DataDao userDao;
    public Model(Context context){
        this.context = context;
        db = Room.databaseBuilder(context,AppDatabase.class, "database-name").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        userDao = db.userDao();
    }

    public void getListData(String url, DataRetriever callback){
        Api.getClient().getListData().enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                root = response.body();
                callback.onSuccess(root);
                userDao.insertAll(Mapper.convertListMtoD(root.getItems()));
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                callback.onFailure(t.getStackTrace().toString());
            }
        });
    }
}
