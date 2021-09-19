package com.example.appnghenhac.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnghenhac.Activity.PlayNhacActivity;
import com.example.appnghenhac.Adapter.PlayNhacAdapter;
import com.example.appnghenhac.R;

public class Fragment_PlayDanhSachCacBaiHat extends Fragment {
    View view;
    RecyclerView recyclerView;
    PlayNhacAdapter playNhacAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_danhsachcacbaihat,container,false);
        recyclerView = view.findViewById(R.id.recyclerviewplaydanhsachcacbaihat);
        if(PlayNhacActivity.baiHatArrayList.size()>0){
            playNhacAdapter = new PlayNhacAdapter(getActivity(),PlayNhacActivity.baiHatArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(playNhacAdapter);
        }

        return view;
    }
}
