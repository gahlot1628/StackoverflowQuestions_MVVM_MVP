package com.kartik.stackoverflowquestions.Model.Room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DataTable.class},version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataDao userDao();
}
