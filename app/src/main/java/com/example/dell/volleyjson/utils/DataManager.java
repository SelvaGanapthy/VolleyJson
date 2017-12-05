package com.example.dell.volleyjson.utils;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dell.volleyjson.app.AppController;

import org.json.JSONObject;

/**
 * Created by Dell on 12/5/2017.
 */

public class DataManager {
    private String urlJsonObj = "https://api.androidhive.info/volley/person_object.json";
    private String StudentInfo = "http://androidblog.esy.es/jsonData.php";
    Context mContext;
    static DataManager mInstance;


    private DataManager() {
        mContext = AppController.getInstance();
    }

    public static final DataManager getInstance() {
        if (mInstance == null) {
            mInstance = new DataManager();
        }
        return mInstance;
    }


    public void DataLoad() {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, StudentInfo, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response != null) {
                    try {
                        String name = response.getString("name");
                        String email = response.getString("email");
                        JSONObject phone = response.getJSONObject("phone");
                        String home = phone.getString("home");
                        String mobile = phone.getString("mobile");
                        Toast.makeText(AppController.getAppContext(), "" + name + " " + email + "", Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(AppController.getAppContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog


            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

}
