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

public class User_Events extends AppCompatActivity {


    RecyclerView recyclerView;
    EventAdapter eventAdapter;
    List<University_Events> EventList;
    int i;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__events);

        EventList=new ArrayList<>();
        recyclerView=(RecyclerView)findViewById(R.id.event_RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        EventList=new ArrayList<>();
        displayNotice();

    }


    private void displayNotice()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("University_Events");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Integer count = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String key = ds.getKey();
                    databaseReference.child(key);

                    University_Events u= dataSnapshot.child(key).getValue(University_Events.class);


                    EventList.add(u);

                    count++;


                }
                eventAdapter=new EventAdapter(User_Events.this,EventList);
                recyclerView.setAdapter(eventAdapter);

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
