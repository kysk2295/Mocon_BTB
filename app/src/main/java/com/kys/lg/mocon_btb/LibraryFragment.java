package com.kys.lg.mocon_btb;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class LibraryFragment extends Fragment {

    RecyclerView recyclerView;
    NiceSpinner niceSpinner;
    String genre="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.activity_main, container, false);

        recyclerView=v.findViewById(R.id.recyclerview);
        niceSpinner = v.findViewById(R.id.spinner);
        niceSpinner.setOnSpinnerItemSelectedListener(OnItemSelected);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter());

        return v;
    }

    OnSpinnerItemSelectedListener OnItemSelected = new OnSpinnerItemSelectedListener() {
        @Override
        public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
            Toast.makeText(getActivity(),genre,Toast.LENGTH_SHORT).show();
            genre=niceSpinner.getSelectedItem().toString();
            Log.i("tag",genre);
            Toast.makeText(getActivity(),genre,Toast.LENGTH_SHORT).show();
        }
    };


    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        ArrayList<Images> images;

        RecyclerViewAdapter(){

        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item1,viewGroup,false);

            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 7;
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            public MyViewHolder(View v) {
                super(v);
                imageView=v.findViewById(R.id.recycle_item_image);

            }
        }
    }
}
