package com.example.vidyawani_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Admin_Dashboard extends AppCompatActivity {

    ImageView programs,users,posts,feedbacks,notices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__dashboard);

        programs=(ImageView)findViewById(R.id.programs);
        users=(ImageView)findViewById(R.id.users);
        posts=(ImageView)findViewById(R.id.posts);
        feedbacks=(ImageView)findViewById(R.id.feedbacks);
        notices=(ImageView)findViewById(R.id.notices);

        programs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Admin_Programs.class));
            }
        });

        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Admin_Dashboard.this, "Programs", Toast.LENGTH_SHORT).show();
            }
        });

        posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Admin_Dashboard.this, "Programs", Toast.LENGTH_SHORT).show();
            }
        });

        feedbacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Admin_Dashboard.this, "Programs", Toast.LENGTH_SHORT).show();
            }
        });

        notices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Admin_Events.class));
            }
        });


    }
}
