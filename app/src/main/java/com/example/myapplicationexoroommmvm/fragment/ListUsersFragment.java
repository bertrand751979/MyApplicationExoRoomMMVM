package com.example.myapplicationexoroommmvm.fragment;


import static com.example.myapplicationexoroommmvm.activity.MainActivity.USER_EXTRA;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationexoroommmvm.OnDeleteButtonAction;
import com.example.myapplicationexoroommmvm.OnLinearClickedAction;
import com.example.myapplicationexoroommmvm.R;
import com.example.myapplicationexoroommmvm.activity.UserDetailActivity;
import com.example.myapplicationexoroommmvm.adapter.ListUserAdapter;
import com.example.myapplicationexoroommmvm.model.User;
import com.example.myapplicationexoroommmvm.viewModel.ListUserFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListUsersFragment extends Fragment {
    private RecyclerView recyclerView;
    private ListUserAdapter listUserAdapter;
    private ListUserFragmentViewModel listUserFragmentViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Liste des Utilisateurs");
        listUserFragmentViewModel = new ViewModelProvider(this).get(ListUserFragmentViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_user,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_list_user);
        setViewitem();
    }

    public void setViewitem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        OnLinearClickedAction onLinearClickedAction = new OnLinearClickedAction() {
            @Override
            public void goToDescription(User user) {
                Intent intent = new Intent(ListUsersFragment.this.getContext(), UserDetailActivity.class);
                intent.putExtra(USER_EXTRA, user);
                startActivity(intent);
            }
        };
        OnDeleteButtonAction onDeleteButtonAction = new OnDeleteButtonAction() {
            @Override
            public void delete(User user) {
                listUserFragmentViewModel.deleteUser(user,getContext());
            }
        };
        listUserAdapter = new ListUserAdapter(onLinearClickedAction, onDeleteButtonAction);
        recyclerView.setAdapter(listUserAdapter);
        listUserFragmentViewModel.getDisplayList(getContext()).observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                listUserAdapter.setMyListUserAdapter(new ArrayList<>(users));
            }
        });
    }
}
