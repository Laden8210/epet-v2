package com.example.epet.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epet.R;
import com.example.epet.adapter.CardMissingPetAdapter;
import com.example.epet.calback.GetCallback;
import com.example.epet.calback.PostCallback;

public class HomeFragment extends Fragment implements GetCallback, PostCallback {


    private RecyclerView rvMissingPet;
    private CardMissingPetAdapter cardMissingPet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvMissingPet = view.findViewById(R.id.rvMissingPet);
        rvMissingPet.setLayoutManager(new LinearLayoutManager(getContext()));


        cardMissingPet = new CardMissingPetAdapter();

        rvMissingPet.setAdapter(cardMissingPet);

        return view;
    }


    @Override
    public void onGetSuccess(String responseData) {

    }

    @Override
    public void onGetError(String errorMessage) {

    }

    @Override
    public void onPostSuccess(String responseData) {

    }

    @Override
    public void onPostError(String errorMessage) {

    }
}
