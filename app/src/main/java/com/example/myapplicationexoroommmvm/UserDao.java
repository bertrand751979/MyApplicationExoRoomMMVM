package com.example.myapplicationexoroommmvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplicationexoroommmvm.model.User;

import java.util.List;
@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    LiveData<List<User>> getListUsers();

    @Insert
    void addUser(User user);

    @Update
    void modifUser(User user);

    @Delete
    void deleteUser(User user);


}
