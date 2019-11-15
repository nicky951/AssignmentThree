package com.example.assignmentthree;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import com.example.assignmentthree.Cat;

@Dao
public interface CatDao {

    @Query("SELECT * FROM Cat")
    List<Cat> getCats();

    @Query("SELECT * FROM Cat WHERE Name LIKE :name || '%' ")
    List<Cat> findCatByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Cat> cats);

    @Query("SELECT * FROM Cat WHERE Name LIKE :name")
    Cat findCat(String name);
}