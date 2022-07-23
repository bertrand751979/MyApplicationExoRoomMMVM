package com.example.myapplicationexoroommmvm.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplicationexoroommmvm.model.User;
import com.example.myapplicationexoroommmvm.repository.RepositoryUser;

import java.util.List;

public class UserDetailActivityViewModel extends ViewModel {
    public void updateUser(User user,Context context){
        RepositoryUser.getInstance().update(user,context);
    }


}
