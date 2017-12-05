package com.example.dell.volleyjson.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.volleyjson.R;
import com.example.dell.volleyjson.models.StudentInfoModel;

import java.util.ArrayList;

/**
 * Created by Dell on 12/5/2017.
 */

public class StudentInfoAdapter extends RecyclerView.Adapter<StudentInfoAdapter.ViewHolder> {
    View view;
    ArrayList<StudentInfoModel> dataList = new ArrayList<>();
    ArrayList<StudentInfoModel> filterList = new ArrayList<>();
    Context context;

    public StudentInfoAdapter(ArrayList<StudentInfoModel> dataList, Context context) {
        this.dataList = dataList;
        this.filterList = dataList;
        this.context = context;
    }

    @Override
    public StudentInfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.studentinfo_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentInfoAdapter.ViewHolder holder, int position) {
        StudentInfoModel model = filterList.get(position);
        holder.tvId.setText(model.getId());
        holder.tvName.setText(model.getName());
        holder.tvPhoneNo.setText(model.getPhone_number());
        holder.tvSubject.setText(model.getSubject());
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvPhoneNo, tvSubject;

        public ViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPhoneNo = (TextView) itemView.findViewById(R.id.tvPhoneNo);
            tvSubject = (TextView) itemView.findViewById(R.id.tvSubject);

        }
    }
}
