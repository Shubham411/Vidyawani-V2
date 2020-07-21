package com.example.vidyawani_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Admin_Events extends AppCompatActivity {

    Button add,delete;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__events);

        add=(Button)findViewById(R.id.addevent);
        delete=(Button)findViewById(R.id.deleteevent);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(Admin_Events.this);
            }
        });

    }


    private void showDialog(Admin_Events events) {
        final Dialog dialog = new Dialog(events);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.event_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Button ok,cancle;
        final EditText id,name,desc,time,loc,date;

        id=(EditText)dialog.findViewById(R.id.eno);
        name=(EditText)dialog.findViewById(R.id.ename);
        date=(EditText)dialog.findViewById(R.id.edate);
        desc=(EditText)dialog.findViewById(R.id.edesc);
        time=(EditText)dialog.findViewById(R.id.etime);
        loc=(EditText)dialog.findViewById(R.id.eloc);
        ok=(Button)dialog.findViewById(R.id.eok);
        cancle=(Button)dialog.findViewById(R.id.ecn);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id1= id.getText().toString();
                String name1=name.getText().toString();
                String desc1=desc.getText().toString();
                String date1=date.getText().toString();
                String time1=time.getText().toString();
                String loc1=loc.getText().toString();
                databaseReference= FirebaseDatabase.getInstance().getReference("University_Events");
                University_Events ue=new University_Events(id1,name1,date1,time1,loc1,desc1);
                databaseReference.child(databaseReference.push().getKey()).setValue(ue);
                Toast.makeText(getApplicationContext(), "Event Added ", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();




    }

}
