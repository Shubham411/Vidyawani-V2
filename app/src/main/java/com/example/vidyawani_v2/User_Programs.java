package com.example.vidyawani_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class User_Programs extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgramAdapter programAdapter;
    List<University_Programs> ProgramList;
    int i;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__programs);

        ProgramList=new ArrayList<>();
        recyclerView=(RecyclerView)findViewById(R.id.program_RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProgramList=new ArrayList<>();
        displayNotice();

    }

    private void displayNotice()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("University_Programs");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Integer count = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String key = ds.getKey();
                    databaseReference.child(key);

                    University_Programs p= dataSnapshot.child(key).getValue(University_Programs.class);


                    ProgramList.add(p);

                    count++;


                }
                programAdapter=new ProgramAdapter(User_Programs.this,ProgramList);
                recyclerView.setAdapter(programAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Home.class));
        super.onBackPressed();
    }

}
