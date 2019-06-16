package com.kys.lg.mocon_btb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SearchScreen extends AppCompatActivity {

    private ArrayList<SearchData> arrayList;
    private SearchAdapter searchAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchscreen);

        recyclerView  = (RecyclerView)findViewById(R.id.rv_showSearch);
        linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        searchAdapter = new SearchAdapter(arrayList);
        recyclerView.setAdapter(searchAdapter);

        Button btn_append = (Button)findViewById(R.id.normal_button);
        btn_append.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchData searchData = new SearchData(R.mipmap.ic_launcher,"full house","scary","Dr.goyunsu","lowyunsu");
                arrayList.add(searchData);
                searchAdapter.notifyDataSetChanged();
            }
        });
    }


}
