package com.kys.lg.mocon_btb;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileAdapterOfChatData extends RecyclerView.Adapter<ProfileAdapterOfChatData.CustomViewHolder> {

    private ArrayList<OldChatData> arrayList;

    public ProfileAdapterOfChatData(ArrayList<OldChatData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.oldchat_list,viewGroup,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder customViewHolder, int i) {
        customViewHolder.imgSrcOfProfileOldchat.setImageResource(arrayList.get(i).getImgSrcOfProfileOldchat());
        customViewHolder.name.setText(arrayList.get(i).getName());

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

        protected ImageView imgSrcOfProfileOldchat;
        protected TextView name;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgSrcOfProfileOldchat = (ImageView) itemView.findViewById(R.id.iv_chat_profile);
            this.name = (TextView) itemView.findViewById(R.id.tv_oldchat_name);
        }
    }
}
