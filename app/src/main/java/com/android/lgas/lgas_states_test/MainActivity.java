package com.android.lgas.lgas_states_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.android.lgas.lgainfolist.entitities.LocalGovernmentAreaInfo;
import com.android.lgas.lgainfolist.helpers.LocalGovernmentAreaCoordinates;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  Toolbar toolbar;
  RecyclerView recyclerView;
  RecyclerViewAdapter localGovernmentAreaListAdapter;
  List<LocalGovernmentAreaInfo> localGovernmentAreaInfoList;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setTitle(getString(R.string.app_name));
    localGovernmentAreaInfoList = LocalGovernmentAreaCoordinates.getLocalGovernmentAreasList(this);

    recyclerView = (RecyclerView)findViewById(R.id.local_government_list_recyclerview);
    localGovernmentAreaListAdapter = new RecyclerViewAdapter(this, localGovernmentAreaInfoList);

    final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerView.setLayoutManager(layoutManager);




    recyclerView.setAdapter(localGovernmentAreaListAdapter);


  }
}
