package com.kartik.stackoverflowquestions.Model;

import com.kartik.stackoverflowquestions.Model.Root;

public interface DataRetriever {
    public void onSuccess(Root root);
    public void onFailure(String error);
}
