package com.example.myapplicationexoroommmvm.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationexoroommmvm.OnDeleteButtonAction;
import com.example.myapplicationexoroommmvm.OnLinearClickedAction;
import com.example.myapplicationexoroommmvm.R;
import com.example.myapplicationexoroommmvm.model.User;


public class UserViewHolder extends RecyclerView.ViewHolder {
    private TextView vhEditEmail;
    private TextView vhEditUserName;
    private LinearLayout vhLinearLayout;
    private Integer id;
    private ImageView vhDelete;

    public UserViewHolder(@NonNull View view) {
        super(view);
        vhEditEmail = view.findViewById(R.id.raw_email_user);
        vhEditUserName = view.findViewById(R.id.raw_user_name);
        vhLinearLayout = view.findViewById(R.id.raw_linear);
        vhDelete = view.findViewById(R.id.rawDelete);

    }

    public TextView getVhEditEmail() {
        return vhEditEmail;
    }

    public void setVhEditEmail(TextView vhEditEmail) {
        this.vhEditEmail = vhEditEmail;
    }

    public TextView getVhEditUserName() {
        return vhEditUserName;
    }

    public void setVhEditUserName(TextView vhEditUserName) {
        this.vhEditUserName = vhEditUserName;
    }

    public LinearLayout getVhLinearLayout() {
        return vhLinearLayout;
    }

    public void setVhLinearLayout(LinearLayout vhLinearLayout) {
        this.vhLinearLayout = vhLinearLayout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void bind(User user, OnLinearClickedAction onLinearClickedAction, OnDeleteButtonAction onDeleteButtonAction){
        vhEditEmail.setText(user.getUserEmail());
        vhEditUserName.setText(user.getUserName());
        vhDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDeleteButtonAction.delete(user);
            }
        });
        vhLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLinearClickedAction.goToDescription(user);
            }
        });

    }
}
