package com.kartik.stackoverflowquestions.Presenter;

import com.kartik.stackoverflowquestions.Model.MyListData;

import java.util.List;

public interface Contract {

    public void listData(List<MyListData> myListData);
    public void makeToast(String str);
}
