package com.ahududu.ahududu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Tab1Fragment extends Fragment {
    private RecyclerView recyclerView;
    private static final String TAG = "tab1Fragment";
    private VivzAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        recyclerView = view.findViewById(R.id.rwSonEklenenler);
        adapter = new VivzAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }

    public static List<Information> getData(){
        List<Information> data = new ArrayList<>();
         int[] icons = {R.drawable.skonser,R.drawable.sfutbol,R.drawable.saraba,R.drawable.skonser};
         String[] titles = {"Grup Seksendört Konser","Derbiye Beraber Gidelim?","Wv Golf Tutkunları Buyrun","Konser Etkinliği"};

         for (int i = 0;i<titles.length && i<icons.length; i++){
             Information current = new Information();
             current.iconId = icons[i];
             current.title = titles[i];
             data.add(current);
         }

         return data;
    }
}
