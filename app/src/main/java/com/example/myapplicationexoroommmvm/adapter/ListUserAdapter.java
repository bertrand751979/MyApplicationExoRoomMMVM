package com.example.myapplicationexoroommmvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationexoroommmvm.OnDeleteButtonAction;
import com.example.myapplicationexoroommmvm.OnLinearClickedAction;
import com.example.myapplicationexoroommmvm.R;
import com.example.myapplicationexoroommmvm.model.User;
import com.example.myapplicationexoroommmvm.viewHolder.UserViewHolder;

import java.util.ArrayList;

public class ListUserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<User> myListUserAdapter = new ArrayList<>();
    private OnLinearClickedAction onLinearClickedAction;
    private OnDeleteButtonAction onDeleteButtonAction;

    public ListUserAdapter(OnLinearClickedAction onLinearClickedAction, OnDeleteButtonAction onDeleteButtonAction) {
        this.onLinearClickedAction = onLinearClickedAction;
        this.onDeleteButtonAction = onDeleteButtonAction;
    }

    public void setMyListUserAdapter(ArrayList<User> myListUserAdapter) {
        this.myListUserAdapter = myListUserAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(myListUserAdapter.get(position),onLinearClickedAction, onDeleteButtonAction);
    }

    @Override
    public int getItemCount() {
        return myListUserAdapter.size();
    }
}
