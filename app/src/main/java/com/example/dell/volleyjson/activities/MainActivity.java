package com.example.dell.volleyjson.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dell.volleyjson.R;
import com.example.dell.volleyjson.adapters.ContactsInfoAdapter;
import com.example.dell.volleyjson.app.AppController;
import com.example.dell.volleyjson.models.ContactsInfoModel;
import com.example.dell.volleyjson.utils.DataManager;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();
    ArrayList<ContactsInfoModel> ContactsList;
    RecyclerView rv;
    ContactsInfoAdapter adapter;
    SwipeRefreshLayout swipeRefresh;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppController.getInstance().mainActivity = this;
        rv = (RecyclerView) findViewById(R.id.rv);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipseContacts);
        swipeRefresh.setColorSchemeColors(R.color.swipe1, R.color.swipe2, R.color.swipe3);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DataManager.getInstance().DataLoad(true);
                        swipeRefresh.setRefreshing(false);

                    }
                }, 1000);
            }
        });
        DataManager.getInstance().DataLoad(false);
    }

    public void getDataLoad(ArrayList<ContactsInfoModel> ContactsList) {
        this.ContactsList = ContactsList;
        set_rvLayoutManager();
        set_rvAdapter();
    }

    public void set_rvLayoutManager() {
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv.setHasFixedSize(true);
    }

    public void set_rvAdapter() {
        adapter = new ContactsInfoAdapter(MainActivity.this, ContactsList);
        rv.setAdapter(adapter);
    }

    public void refreshData(ArrayList<ContactsInfoModel> hotcasesrefresh) {
        this.ContactsList.clear();
        this.ContactsList.addAll(hotcasesrefresh);
        adapter.notifyDataSetChanged();
    }
}
