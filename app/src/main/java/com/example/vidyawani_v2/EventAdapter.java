package com.example.vidyawani_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder>
{
    private Context context;
    private List<University_Events> EventList;

    public EventAdapter(Context context, List<University_Events> eventList) {
        this.context = context;
        EventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.event_display, null);
        return new EventViewHolder(view);//contains views from notice.xml
    }


    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {

      University_Events e=EventList.get(position);
      holder.ename.setText("Event Name :-"+e.getName());
      holder.date.setText("Date :-"+e.getDate());
      holder.etime.setText("Time :-"+e.getTime());
      holder.eloc.setText("Location :-"+e.loc);
      holder.edesc.setText("Description :-"+e.desc);

    }

    @Override
    public int getItemCount() {
        return EventList.size();
    }


    public class EventViewHolder extends RecyclerView.ViewHolder{
        TextView ename,date,etime,eloc,edesc;
        public EventViewHolder(View itemview){
            super(itemview);

            ename=itemview.findViewById(R.id.e_name);
            date=itemview.findViewById(R.id.e_date);
            etime=itemview.findViewById(R.id.e_time);
            eloc=itemview.findViewById(R.id.e_loc);
            edesc=itemview.findViewById(R.id.e_description);
        }
    }
}
