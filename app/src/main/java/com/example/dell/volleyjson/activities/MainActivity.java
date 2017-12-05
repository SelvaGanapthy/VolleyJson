package com.example.dell.volleyjson.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dell.volleyjson.models.StudentInfoModel;
import com.example.dell.volleyjson.utils.DataManager;
import com.example.dell.volleyjson.R;
import com.example.dell.volleyjson.app.AppController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv_response;

    private static String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppController.getInstance().mainActivity = this;
        tv_response = (TextView) findViewById(R.id.tv_response);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

    }

    public void JsonRequest(View view) {
        DataManager.getInstance().DataLoad();

    }

    public void loadStudentInfo(ArrayList<StudentInfoModel> dataList) {
        startActivity(new Intent(MainActivity.this, StudentInfo.class).putExtra("dataList", dataList));
    }


    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();

    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
