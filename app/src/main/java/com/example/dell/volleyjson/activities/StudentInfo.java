package com.example.dell.volleyjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dell.volleyjson.R;
import com.example.dell.volleyjson.adapters.StudentInfoAdapter;
import com.example.dell.volleyjson.models.StudentInfoModel;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentInfo extends AppCompatActivity implements Serializable {
    RecyclerView rv;
    ArrayList<StudentInfoModel> dataList = new ArrayList<>();
    StudentInfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        //intent
        dataList = (ArrayList<StudentInfoModel>) getIntent().getSerializableExtra("dataList");
        rv = (RecyclerView) findViewById(R.id.rv);
        set_layout_manager();
        set_adapter();

    }

    public void set_layout_manager() {

        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true);
    }

    public void set_adapter() {
        adapter = new StudentInfoAdapter(dataList, StudentInfo.this);
        rv.setAdapter(adapter);
    }
}
