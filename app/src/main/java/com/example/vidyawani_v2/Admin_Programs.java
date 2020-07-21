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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Admin_Programs extends AppCompatActivity {

    Button add,delete;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__programs);

        add=(Button)findViewById(R.id.addprogram);
        delete=(Button)findViewById(R.id.deleteprogram);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(Admin_Programs.this);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }


    private void showDialog(Admin_Programs programs) {
        final Dialog dialog = new Dialog(programs);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.program_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Button ok,cancle;
        final EditText id,name,desc,time,date;

        id=(EditText)dialog.findViewById(R.id.pno);
        name=(EditText)dialog.findViewById(R.id.pname);
        desc=(EditText)dialog.findViewById(R.id.pdesc);
        time=(EditText)dialog.findViewById(R.id.ptime);
        date=(EditText)dialog.findViewById(R.id.pdate);
        ok=(Button)dialog.findViewById(R.id.pok);
        cancle=(Button)dialog.findViewById(R.id.pcn);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id1= id.getText().toString();
                String name1=name.getText().toString();
                String desc1=desc.getText().toString();
                String time1=time.getText().toString();
                String date1=date.getText().toString();
                databaseReference= FirebaseDatabase.getInstance().getReference("University_Programs");
                University_Programs up=new University_Programs(id1,name1,time1,date1,desc1);
                databaseReference.child(databaseReference.push().getKey()).setValue(up);
                Toast.makeText(getApplicationContext(), "Program Added ", Toast.LENGTH_LONG).show();
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
