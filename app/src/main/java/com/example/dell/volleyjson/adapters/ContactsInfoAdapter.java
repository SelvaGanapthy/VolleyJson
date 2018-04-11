package com.example.dell.volleyjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.volleyjson.R;
import com.example.dell.volleyjson.models.ContactsInfoModel;

import java.util.ArrayList;

/**
 * Created by Dell on 12/5/2017.
 */

public class ContactsInfoAdapter extends RecyclerView.Adapter<ContactsInfoAdapter.ViewHolder> {
    View view;
    ArrayList<ContactsInfoModel> dataList = new ArrayList<>();
    ArrayList<ContactsInfoModel> filterList = new ArrayList<>();
    Context context;

    public ContactsInfoAdapter(Context context, ArrayList<ContactsInfoModel> dataList) {
        this.dataList = dataList;
        this.filterList = dataList;
        this.context = context;
    }

    @Override
    public ContactsInfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.studentinfo_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsInfoAdapter.ViewHolder holder, int position) {
        ContactsInfoModel model = filterList.get(position);
        holder.tvId.setText(model.getId());
        holder.tvName.setText(model.getName());
        holder.tvEmail.setText(model.getEmail());

    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);

        }
    }
}
