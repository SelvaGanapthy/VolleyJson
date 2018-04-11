package com.example.dell.volleyjson.app;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.example.dell.volleyjson.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.dell.volleyjson.activities.MainActivity;
import com.example.dell.volleyjson.activities.StudentInfo;

/**
 * Created by Dell on 11/29/2017.
 */

public class AppController extends Application {
    public static final String TAG = AppController.class.getSimpleName();
    RequestQueue mRequestQueue;
    static Context context;
    static AppController mInstance;
    public StudentInfo studentInfo;

    public MainActivity mainActivity;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        context = this.getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null)
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request, String tag) {
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request) {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
