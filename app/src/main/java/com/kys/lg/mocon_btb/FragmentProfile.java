package com.kys.lg.mocon_btb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfile extends Fragment {

    private ArrayList<OldChatData> arrayList_oldOldChatData;
    private ArrayList<AnnounceData> arrayList_AnnounceData;

    private ProfileAdapterOfChatData profileAdapterOfChatData;
    private ProfileAdapterOfAnnounce profileAdapterOfAnnounce;

    private RecyclerView recyclerView_oldchat;
    private RecyclerView recyclerView_annaounce;

    private LinearLayoutManager linearLayoutManager_oldchat;
    private LinearLayoutManager linearLayoutManager_announce;


    public FragmentProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_profile,container,false);

        recyclerView_oldchat = (RecyclerView)rootview.findViewById(R.id.rv_oldChatted);
        recyclerView_annaounce = (RecyclerView)rootview.findViewById(R.id.rv_announce);

        linearLayoutManager_oldchat = new LinearLayoutManager(getActivity());
        recyclerView_oldchat.setLayoutManager(linearLayoutManager_oldchat);

        linearLayoutManager_announce = new LinearLayoutManager(getActivity());
        recyclerView_annaounce.setLayoutManager(linearLayoutManager_announce);

        arrayList_oldOldChatData = new ArrayList<>();
        arrayList_AnnounceData = new ArrayList<>();

        profileAdapterOfChatData = new ProfileAdapterOfChatData(arrayList_oldOldChatData);
        recyclerView_oldchat.setAdapter(profileAdapterOfChatData);

        profileAdapterOfAnnounce = new ProfileAdapterOfAnnounce(arrayList_AnnounceData);
        recyclerView_annaounce.setAdapter(profileAdapterOfAnnounce);

        return rootview;
    }

}
