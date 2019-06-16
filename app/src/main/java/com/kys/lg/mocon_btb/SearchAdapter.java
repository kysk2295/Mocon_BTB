package com.kys.lg.mocon_btb;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.CustomViewHolder> {

    private ArrayList<SearchData> arrayList;

    public SearchAdapter(ArrayList<SearchData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,viewGroup,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder customViewHolder, int i) {
        customViewHolder.iv_profile.setImageResource(arrayList.get(i).getImgSrcOfProfile());
        customViewHolder.tv_title.setText(arrayList.get(i).getTitle());
        customViewHolder.tv_janru.setText(arrayList.get(i).getJanru());
        customViewHolder.tv_publisher.setText(arrayList.get(i).getPublisher());
        customViewHolder.tv_writer.setText(arrayList.get(i).getWriter());

        customViewHolder.itemView.setTag(i);

        customViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName = customViewHolder.tv_title.getText().toString();
                Toast.makeText(view.getContext(),curName,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null!= arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile;
        protected TextView tv_title;
        protected TextView tv_janru;
        protected TextView tv_writer;
        protected TextView tv_publisher;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            this.tv_writer = (TextView) itemView.findViewById(R.id.tv_writer);
            this.tv_publisher = (TextView) itemView.findViewById(R.id.tv_publisher);
            this.tv_janru = (TextView) itemView.findViewById(R.id.tv_janru);

        }
    }
}
