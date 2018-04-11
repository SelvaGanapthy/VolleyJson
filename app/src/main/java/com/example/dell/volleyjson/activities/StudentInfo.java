package com.example.dell.volleyjson.activities;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dell.volleyjson.R;
import com.example.dell.volleyjson.adapters.ContactsInfoAdapter;
import com.example.dell.volleyjson.app.AppController;
import com.example.dell.volleyjson.models.ContactsInfoModel;
import com.example.dell.volleyjson.utils.DataManager;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentInfo extends AppCompatActivity implements Serializable {
    RecyclerView rv;
    ArrayList<ContactsInfoModel> dataList = new ArrayList<>();
    ContactsInfoAdapter adapter;
    public static SwipeRefreshLayout swipeRefreshStudent;
    private static String TAG = StudentInfo.class.getSimpleName();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        AppController.getInstance().studentInfo = this;
        dataList = (ArrayList<ContactsInfoModel>) getIntent().getSerializableExtra("dataList");
        rv = (RecyclerView) findViewById(R.id.rv);
        swipeRefreshStudent = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
//        set_layout_manager();
//        set_adapter();
}
//
//        swipeRefreshStudent.setColorSchemeResources(R.color.swipe1, R.color.swipe2, R.color.swipe3);
//        swipeRefreshStudent.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        DataManager.getInstance().refreshDataLoad();
//
//                        swipeRefreshStudent.setRefreshing(false);
//                    }
//                }, 1000);
//            }
//        });
//    }
//
//    public void set_layout_manager() {
//
//        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        rv.setHasFixedSize(true);
//    }
//
//    public void set_adapter() {
//        adapter = new ContactsInfoAdapter(dataList, StudentInfo.this);
//        rv.setAdapter(adapter);
//    }
//
//    public void refreshData(ArrayList<ContactsInfoModel> hotcasesrefresh) {
//        dataList.clear();
//        dataList.addAll(hotcasesrefresh);
//        adapter.notifyDataSetChanged();
//    }
}
