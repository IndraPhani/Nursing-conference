package com.example.nursingsymposium;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConferenceAdapter extends RecyclerView.Adapter<ConferenceAdapter.ViewHolder>{

    DashBoardActivity activity;
    ArrayList<ConferenceDataModel> list;

    public ConferenceAdapter(DashBoardActivity dashBoardActivity, ArrayList<ConferenceDataModel> arrayList) {
        this.activity=dashBoardActivity;
        this.list=arrayList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ConferenceDataModel myListData = list.get(position);
        holder.listname.setText(myListData.getName());
        holder.listtime.setText(myListData.getTime());
        holder.listevent.setText(myListData.getEventName());
      /*  holder.layout_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ConferenceSchedulerActivity.class);
                activity.startActivity(intent);

            }
        });
        */
        holder.addtoschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Added to My Schedule", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView listevent;
        public TextView listtime;
        public LinearLayout layout_click;
        public TextView listname;
        public ImageView addtoschedule;
        public ViewHolder(View itemView) {
            super(itemView);
            this.listname = (TextView) itemView.findViewById(R.id.listname);
            this.addtoschedule = (ImageView) itemView.findViewById(R.id.add_to_schedule);
           this.listtime = (TextView) itemView.findViewById(R.id.listtime);
           this.listevent = (TextView) itemView.findViewById(R.id.listevent);
           this.layout_click = (LinearLayout)itemView.findViewById(R.id.layout_click);
        }
    }
}