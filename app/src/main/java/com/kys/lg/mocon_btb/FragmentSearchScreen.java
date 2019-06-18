package com.kys.lg.mocon_btb;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSearchScreen extends Fragment {

    private ArrayList<SearchData> arrayList;
    private SearchAdapter searchAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    Toolbar toolbar;
    SearchView searchView;



    public FragmentSearchScreen() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_searchscreen, container, false);

        recyclerView  = (RecyclerView)rootView.findViewById(R.id.rv_showSearch);
        linearLayoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        toolbar=rootView.findViewById(R.id.my_toolbar);

        searchView=rootView.findViewById(R.id.search_view);


        arrayList = new ArrayList<>();

        searchAdapter = new SearchAdapter(arrayList);
        recyclerView.setAdapter(searchAdapter);

        MainActivity activity=(MainActivity) getActivity();

        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.toolbaritem,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.menu:




        }
        return true;
    }
}
