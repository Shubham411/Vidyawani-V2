package com.example.vidyawani_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder> {

    private Context context;
    private List<University_Programs> ProgramList;

    public ProgramAdapter(Context context, List<University_Programs> programList) {
        this.context = context;
        ProgramList = programList;
    }

    @NonNull
    @Override
    public ProgramAdapter.ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.program_display, null);
        return new ProgramAdapter.ProgramViewHolder(view);//contains views from notice.xml
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder holder, int position) {

        University_Programs e=ProgramList.get(position);
        holder.pname.setText("Program Name :-"+e.getPname());
        holder.pdate.setText("Date :-"+e.getPdate());
        holder.ptime.setText("Time :-"+e.getPtime());
        holder.pdesc.setText("Description :-"+e.getPdesc());

    }


    @Override
    public int getItemCount() {
        return ProgramList.size();
    }


    public class ProgramViewHolder extends RecyclerView.ViewHolder{
        TextView pname,pdate,ptime,pdesc;
        public ProgramViewHolder(View itemview){
            super(itemview);

            pname=itemview.findViewById(R.id.p_name);
            pdate=itemview.findViewById(R.id.p_date);
            ptime=itemview.findViewById(R.id.p_time);
            pdesc=itemview.findViewById(R.id.p_desc);
        }
    }

}
