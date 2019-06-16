package com.kys.lg.mocon_btb;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileAdapterOfAnnounce extends RecyclerView.Adapter<ProfileAdapterOfAnnounce.CustomViewHolder> {

    private ArrayList<AnnounceData> arrayList;

    public ProfileAdapterOfAnnounce(ArrayList<AnnounceData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.announce_list,viewGroup,false);

        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.tv_announce.setText(arrayList.get(i).getAnnounce());
        customViewHolder.tv_day.setText(arrayList.get(i).getDay());

        customViewHolder.itemView.setTag(i);
        customViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return (null!= arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_announce;
        protected TextView tv_day;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_announce = (TextView)itemView.findViewById(R.id.tv_anounnce);
            this.tv_day = (TextView)itemView.findViewById(R.id.tv_day);

        }
    }
}
