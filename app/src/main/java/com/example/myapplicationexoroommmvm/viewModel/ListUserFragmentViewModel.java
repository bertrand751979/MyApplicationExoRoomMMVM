package com.example.myapplicationexoroommmvm.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplicationexoroommmvm.model.User;
import com.example.myapplicationexoroommmvm.repository.RepositoryUser;

import java.util.List;


public class ListUserFragmentViewModel extends ViewModel {

    public LiveData<List<User>> getDisplayList(Context context){
        return RepositoryUser.getInstance().getUser(context);
    }
    public void deleteUser(User user, Context context){
        RepositoryUser.getInstance().delete(user,context);
    }

}
