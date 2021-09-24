package com.kartik.stackoverflowquestions.Model.Room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DataTable")
public class DataTable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "Question_id")
    public int ques_id;

    @ColumnInfo(name = "Question_Title")
    public String ques_title;

    @ColumnInfo(name = "upcount_vote")
    public int upcount_vote;
}
