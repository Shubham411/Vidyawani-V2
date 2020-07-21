package com.example.vidyawani2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText mobile,pass;
    Button signin,login,guest;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobile=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.button);
        guest=(Button)findViewById(R.id.button3);
        signin=(Button)findViewById(R.id.btnSignup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference= FirebaseDatabase.getInstance().getReference("Users");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int f=0;
                        for (DataSnapshot ds: dataSnapshot.getChildren())
                        {
                            String key = ds.getKey();
                            databaseReference.child(key);

                            User u= dataSnapshot.child(key).getValue(User.class);

                            if((mobile.getText().toString().equals(u.mobile))&&(pass.getText().toString().equals(u.pass))){
                                f=1;
                                final FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                                UserProfileChangeRequest request=new UserProfileChangeRequest.Builder().setDisplayName(u.name).build();
                                user.updateProfile(request)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {

                                         Toast.makeText(getApplicationContext(), "Log in succes   "+user.getDisplayName(), Toast.LENGTH_SHORT).show();
                                            }

                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {

                                            }
                                        });



                            }

                        }
                        if(f==0)
                            Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Guest", Toast.LENGTH_SHORT).show();
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), com.example.vidyawani2.signin.class));
            }
        });

    }
}
