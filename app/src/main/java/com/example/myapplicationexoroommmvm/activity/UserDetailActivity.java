package com.example.myapplicationexoroommmvm.activity;


import static com.example.myapplicationexoroommmvm.activity.MainActivity.USER_EXTRA;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplicationexoroommmvm.R;
import com.example.myapplicationexoroommmvm.model.User;
import com.example.myapplicationexoroommmvm.repository.RepositoryUser;
import com.example.myapplicationexoroommmvm.viewModel.UserDetailActivityViewModel;
import java.util.List;


public class UserDetailActivity extends AppCompatActivity {
    private TextView descriptionEmail;
    private EditText descriptionName;
    private EditText descriptionPassword;
    private User user;
    private Button descBtnModification;
    private Button descCancel;
    private UserDetailActivityViewModel userDetailActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        userDetailActivityViewModel = new ViewModelProvider(this).get(UserDetailActivityViewModel.class);
        user = (User) getIntent().getSerializableExtra(USER_EXTRA);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Description");
        setViewItem();
    }
    private void setViewItem(){
        descriptionEmail = findViewById(R.id.desc_email);
        descriptionName = findViewById(R.id.desc_name);
        descriptionPassword = findViewById(R.id.desc_password);
        descBtnModification = findViewById(R.id.des_btn_modification);
        descCancel = findViewById(R.id.desc_btn_cancel);
        descriptionEmail.setText(user.getUserEmail());
        descriptionName.setText(user.getUserName());
        descriptionPassword.setText(user.getUserPassword());
        descBtnModification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setUserName(descriptionName.getText().toString());
                user.setUserPassword(descriptionPassword.getText().toString());
                userDetailActivityViewModel.updateUser(user,UserDetailActivity.this);
            }
        });
        descCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();}
        return super.onOptionsItemSelected(item);
    }
}
