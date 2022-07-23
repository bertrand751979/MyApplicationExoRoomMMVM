package com.example.myapplicationexoroommmvm.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.myapplicationexoroommmvm.ApplicationDataBase;
import com.example.myapplicationexoroommmvm.model.User;

import java.util.List;
import java.util.concurrent.Executors;

public class RepositoryUser {
    public User newProfil;
    private int saveItemPosition;

    private RepositoryUser(){}
    public static RepositoryUser INSTANCE = null;
    public static RepositoryUser getInstance(){
        if(INSTANCE ==null){
            INSTANCE = new RepositoryUser();
        }
        return INSTANCE;
    }

    public User getNewProfil() {
        return newProfil;
    }

    public void setNewProfil(User newProfil) {
        this.newProfil = newProfil;
    }

    public int getSaveItemPosition() {
        return saveItemPosition;
    }

    public void setSaveItemPosition(int saveItemPosition) {
        this.saveItemPosition = saveItemPosition;
    }


    public void add(User user, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDataBase.getInstance(context).getUserDao().addUser(user);
            }
        });
    }

    public void update(User user, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDataBase.getInstance(context).getUserDao().modifUser(user);
            }
        });
    }

    public void delete(User user, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDataBase.getInstance(context).getUserDao().deleteUser(user);
            }
        });
    }

    public LiveData<List<User>> getUser (Context context){
        return ApplicationDataBase.getInstance(context).getUserDao().getListUsers();
    }
}
