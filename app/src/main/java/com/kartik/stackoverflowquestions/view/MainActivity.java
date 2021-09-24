package com.kartik.stackoverflowquestions.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import com.kartik.stackoverflowquestions.Presenter.Contract;
import com.kartik.stackoverflowquestions.Model.MyListData;
import com.kartik.stackoverflowquestions.Presenter.Presenter;
import com.kartik.stackoverflowquestions.R;
import com.kartik.stackoverflowquestions.ViewModel.MyViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract {
    //Presenter mPresenter;
    MyViewModel mMyViewModel;
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mPresenter = new Presenter(this,getApplicationContext());
        //mPresenter.getListData();

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.pullToRefresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mMyViewModel.getQuestions();
            }
        });
        mMyViewModel = ViewModelProvider
                .AndroidViewModelFactory.getInstance(getApplication()).create(MyViewModel.class);
        setupObservers();
    }

    private void setupObservers() {
        //observer for list
        mMyViewModel.mListLiveData.observe(this, new Observer<List<MyListData>>() {
            @Override
            public void onChanged(List<MyListData> myListDataList) {
                mSwipeRefreshLayout.setRefreshing(false);
                listData(myListDataList);
            }
        });

        //observer for API error
        mMyViewModel.errorLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mSwipeRefreshLayout.setRefreshing(false);
                makeToast(s);
            }
        });
    }

    @Override
    public void listData(List<MyListData> myListData) {

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void makeToast(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}