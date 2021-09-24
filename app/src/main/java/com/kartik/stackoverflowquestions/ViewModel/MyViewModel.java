package com.kartik.stackoverflowquestions.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kartik.stackoverflowquestions.Model.DataRetriever;
import com.kartik.stackoverflowquestions.Model.Model;
import com.kartik.stackoverflowquestions.Model.MyListData;
import com.kartik.stackoverflowquestions.Model.Root;
import com.kartik.stackoverflowquestions.Presenter.Presenter;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    public final MutableLiveData<List<MyListData>> mListLiveData;
    public final MutableLiveData<String> errorLiveData;
    private final Model mModel;

    public MyViewModel(@NonNull Application application) {
        super(application);
        mModel = new Model(application);
        mListLiveData = new MutableLiveData<>();
        errorLiveData = new MutableLiveData<>();
        getQuestions();
    }

    public void getQuestions() {
        mModel.getListData(Presenter.url, new DataRetriever() {
            @Override
            public void onSuccess(Root root) {
                mListLiveData.postValue(root.getItems());
            }

            @Override
            public void onFailure(String error) {
                errorLiveData.postValue(error);
            }
        });
    }

}
