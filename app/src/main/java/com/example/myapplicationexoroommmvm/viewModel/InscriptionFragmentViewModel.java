package com.example.myapplicationexoroommmvm.viewModel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplicationexoroommmvm.model.User;
import com.example.myapplicationexoroommmvm.repository.RepositoryUser;
import java.util.List;


public class InscriptionFragmentViewModel extends ViewModel {
    /*public LiveData<List<User>> addUserLiveData(Context context){
        return RepositoryUser.getInstance().getUser(context);
    }*/

    public void addUser(User user, Context context){
        RepositoryUser.getInstance().add(user,context );
    }

    public void updateList(User user, Context context){
        RepositoryUser.getInstance().update(user,context);
    }



}
