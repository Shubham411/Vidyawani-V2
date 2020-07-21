package com.example.vidyawani2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class VerifyOTP extends AppCompatActivity {

    private String mVid;
    EditText editText;
    Button verify;
    String name,mobile,mail,pass;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;



    com.airbnb.lottie.LottieAnimationView val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);


        com.airbnb.lottie.LottieAnimationView animation =(LottieAnimationView) findViewById(R.id.processing);
        animation.setSpeed((float) 1.2); // How fast does the animation play
        animation.setProgress((float) 50); // Starts the animation from 50% of the beginning
        animation.setRepeatMode(LottieDrawable.RESTART);  // Restarts the animation (you can choose to reverse it as well)

        mAuth=FirebaseAuth.getInstance();
        editText=(EditText)findViewById(R.id.editTextOTP);
        verify=(Button)findViewById(R.id.verifyotp);


        Intent i=getIntent();
        name=i.getStringExtra("name");
        mobile=i.getStringExtra("mobile");
        mail=i.getStringExtra("mail");
        pass=i.getStringExtra("pass");

        sendVerificationCode(mobile);


        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code=editText.getText().toString();
                verifyVerificationCode(code);
                finishActivity(0);
            }
        });


    }

    private void sendVerificationCode(String mobile) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91"+mobile,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBacks);
    }

    private void verifyVerificationCode(String code) {
        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(mVid,code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "OTP Verified", Toast.LENGTH_LONG).show();
                    User u=new User(name,mobile,mail,pass);
                    databaseReference= FirebaseDatabase.getInstance().getReference("Users");
                    databaseReference.child(databaseReference.push().getKey()).setValue(u);
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else
                    Toast.makeText(getApplicationContext(), "OTP Not Verifiedddd...!", Toast.LENGTH_SHORT).show();

            }
        });
    }


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            editText.setText(code);
            finishActivity(0);
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(getApplicationContext(), "Error"+e, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            mVid=s;
        }
    };

}
