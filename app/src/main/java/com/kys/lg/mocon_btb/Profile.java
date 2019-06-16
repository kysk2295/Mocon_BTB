package com.kys.lg.mocon_btb;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    private ArrayList<OldChatData> arrayList_oldOldChatData;
    private ArrayList<AnnounceData> arrayList_AnnounceData;

    private ProfileAdapterOfChatData profileAdapterOfChatData;
    private ProfileAdapterOfAnnounce profileAdapterOfAnnounce;

    private RecyclerView recyclerView_oldchat;
    private RecyclerView recyclerView_annaounce;

    private LinearLayoutManager linearLayoutManager_oldchat;
    private LinearLayoutManager linearLayoutManager_announce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        recyclerView_oldchat = (RecyclerView)findViewById(R.id.rv_oldChatted);
        recyclerView_annaounce = (RecyclerView)findViewById(R.id.rv_announce);

        linearLayoutManager_oldchat = new LinearLayoutManager(this);
        recyclerView_oldchat.setLayoutManager(linearLayoutManager_oldchat);

        linearLayoutManager_announce = new LinearLayoutManager(this);
        recyclerView_annaounce.setLayoutManager(linearLayoutManager_announce);

        arrayList_oldOldChatData = new ArrayList<>();
        arrayList_AnnounceData = new ArrayList<>();

        profileAdapterOfChatData = new ProfileAdapterOfChatData(arrayList_oldOldChatData);
        recyclerView_oldchat.setAdapter(profileAdapterOfChatData);

        profileAdapterOfAnnounce = new ProfileAdapterOfAnnounce(arrayList_AnnounceData);
        recyclerView_annaounce.setAdapter(profileAdapterOfAnnounce);

    }
}
