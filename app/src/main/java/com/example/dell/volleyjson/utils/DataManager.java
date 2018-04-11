package com.example.dell.volleyjson.utils;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dell.volleyjson.app.AppController;
import com.example.dell.volleyjson.models.ContactsInfoModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Dell on 12/5/2017.
 */

public class DataManager {

    private final String SERVER_URL_EX1 = "https://api.androidhive.info/volley/person_object.json";
    private final String SERVER_URL_EX2 = "https://api.androidhive.info/contacts/";

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

    public void DataLoad(final boolean refresh) {

        JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, SERVER_URL_EX2, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                ArrayList<ContactsInfoModel> ContactList = new ArrayList<>();
                try {
                    if (response != null && response.length() != 0) {

                        if (response.getJSONArray("contacts").length() != 0) {
                            JSONArray jaContacts = response.getJSONArray("contacts");
                            for (int i = 0; i < jaContacts.length(); i++) {
                                JSONObject joContact = (JSONObject) jaContacts.getJSONObject(i);
                                ContactsInfoModel model = new ContactsInfoModel();
                                model.setId(joContact.getString("id"));
                                model.setName(joContact.getString("name"));
                                model.setEmail(joContact.getString("email"));
                                model.setAddress(joContact.getString("address"));
                                JSONObject phone = joContact.getJSONObject("phone");
                                model.setPhone_home(phone.getString("home"));
                                model.setPhone_mobile(phone.getString("mobile"));
                                model.setPhone_office(phone.getString("office"));
                                ContactList.add(model);
                            }


                        }


                        if (ContactList!=null)
                        {
                            if (refresh)
                            {
                                AppController.getInstance().mainActivity.refreshData(ContactList);
                            }
                            else
                            {
                                AppController.getInstance().mainActivity.getDataLoad(ContactList);

                            }
                        }


                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Toast.makeText(AppController.getAppContext(),"Failed to Load",Toast.LENGTH_LONG).show();

            }
        });

        AppController.getInstance().addToRequestQueue(jsonReq, "");
    }




}
