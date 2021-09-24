package com.kartik.stackoverflowquestions.Presenter;

import android.content.Context;

import com.kartik.stackoverflowquestions.Model.DataRetriever;
import com.kartik.stackoverflowquestions.Model.Model;
import com.kartik.stackoverflowquestions.Model.Root;

public class Presenter implements DataRetriever {
    private Contract view;
    private Model mModel;

    public Presenter(Contract contract, Context context){
        this.view = contract;
        mModel = new Model(context);
    }

    public static String url = "https://api.stackexchange.com/2.2/search/advanced?pagesize=100&order=desc&sort=relevance&q={android room}&site=stackoverflow&filter=!.UE46pK5nV.kfAr.";

    public void getListData(){
        mModel.getListData(url, this);
    }

    @Override
    public void onSuccess(Root root) {
        view.listData(root.getItems());
    }

    @Override
    public void onFailure(String error) {
        view.makeToast(error);
    }
}
