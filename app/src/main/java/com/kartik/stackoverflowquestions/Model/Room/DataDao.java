package com.kartik.stackoverflowquestions.Model.Room;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataDao {
    @Query("SELECT * FROM DATATABLE")
    List<DataTable> getAll();

    @Insert
    void insertAll(List<DataTable> dataTableList);

}
