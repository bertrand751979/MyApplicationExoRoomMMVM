package com.example.myapplicationexoroommmvm;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.myapplicationexoroommmvm.model.User;

@Database(entities = {User.class},version = 1)
public abstract class ApplicationDataBase extends RoomDatabase {
    private static ApplicationDataBase INSTANCE;
    public abstract UserDao getUserDao();
    public static synchronized ApplicationDataBase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ApplicationDataBase.class, "user_app").build();
        }
        return INSTANCE;
    }



}
