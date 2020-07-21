package com.example.vidyawani_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends AppCompatActivity {



    EditText name,mobile,mail,pass;
    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        name=(EditText)findViewById(R.id.editText4);
        mobile=(EditText)findViewById(R.id.editText);
        mail=(EditText)findViewById(R.id.editText2);
        pass=(EditText)findViewById(R.id.editText3);
        login=(Button)findViewById(R.id.btnLogin);
        signup=(Button)findViewById(R.id.button3);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1=name.getText().toString();
                String mobile1=mobile.getText().toString();
                String mail1=mail.getText().toString();
                String pass1=pass.getText().toString();
                Intent i=new Intent(getApplicationContext(),VerifyOTP.class);
                i.putExtra("name",name1);
                i.putExtra("mobile",mobile1);
                i.putExtra("mail",mail1);
                i.putExtra("pass",pass1);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });




    }
}
