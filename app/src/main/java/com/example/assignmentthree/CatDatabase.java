package com.example.assignmentthree;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.assignmentthree.Cat;

@Database(entities =  {Cat.class}, version =1)
public abstract class CatDatabase extends RoomDatabase {
    public abstract CatDao catDao();

    private static CatDatabase instance;
    public static CatDatabase getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context, CatDatabase.class, "catDb")
//                    .allowMainThreadQueries()   // <== IMPORTANT TO NOTE:
                    //     This is NOT correct to do in a completed app.
                    //     Next week we will fix it, but for now this
                    //     line is necessary for the app to work.
                    //     This line will basically allow the database
                    //     queries to freeze the app.
                    .build();
        }
        return instance;
    }
}
