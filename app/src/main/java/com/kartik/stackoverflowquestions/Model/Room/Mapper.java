package com.kartik.stackoverflowquestions.Model.Room;

import com.kartik.stackoverflowquestions.Model.MyListData;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    //To read single row of data from the database
    public static MyListData convertDtoM(DataTable dataTable){
        MyListData myListData = new MyListData();
        myListData.setTitle(dataTable.ques_title);
        myListData.setQuestion_id(dataTable.ques_id);
        myListData.setUp_vote_count(dataTable.upcount_vote);
        return myListData;
    }

    //To read the entire table of the database
    public static List<MyListData> convertListDtoM(List<DataTable> dataTable){
        List<MyListData> myListData = new ArrayList<>();
        for(int i=0;i<dataTable.size();i++){
            myListData.add(convertDtoM(dataTable.get(i)));
        }
        return myListData;
    }

    //To insert single row of data into the database
    public static DataTable convertMtoD(MyListData myListData){
        DataTable dataTable = new DataTable();
        dataTable.ques_id = myListData.getQuestion_id();
        dataTable.ques_title = myListData.getTitle();
        dataTable.upcount_vote = myListData.getUp_vote_count();
        return dataTable;
    }

    //To insert entire list of data into the database
    public static List<DataTable> convertListMtoD(List<MyListData> myListDataList){
        List<DataTable> dataTableList = new ArrayList<>();
        for(int i = 0; i<myListDataList.size();i++){
            dataTableList.add(convertMtoD(myListDataList.get(i)));
        }
        return dataTableList;
    }
}
