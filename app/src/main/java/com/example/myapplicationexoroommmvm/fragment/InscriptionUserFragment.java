package com.example.myapplicationexoroommmvm.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplicationexoroommmvm.R;
import com.example.myapplicationexoroommmvm.model.User;
import com.example.myapplicationexoroommmvm.viewModel.InscriptionFragmentViewModel;


public class InscriptionUserFragment extends Fragment {
    private EditText editName;
    private EditText editEmail;
    private EditText editPassword;
    private Button btnSave;
    private Button btnUpLoad;
    private InscriptionFragmentViewModel inscriptionFragmentViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Inscription");
        inscriptionFragmentViewModel = new ViewModelProvider(this).get(InscriptionFragmentViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inscription_user,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editName = view.findViewById(R.id.edit_user_name);
        editEmail = view.findViewById(R.id.edit_email);
        editPassword = view.findViewById(R.id.edit_password);
        btnSave = view.findViewById(R.id.btn_save_user);
        btnUpLoad = view.findViewById(R.id.btn_upload_image);

        btnUpLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUserEmail(editEmail.getText().toString());
                user.setUserName(editName.getText().toString());
                user.setUserPassword(editPassword.getText().toString());
                inscriptionFragmentViewModel.addUser(user,getContext());
                Toast.makeText(InscriptionUserFragment.this.getContext(), "Ajouté", Toast.LENGTH_SHORT).show();
            }
        });

    }





}
