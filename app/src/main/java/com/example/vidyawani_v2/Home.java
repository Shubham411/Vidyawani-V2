package com.example.vidyawani_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class Home extends AppCompatActivity {

    String arrayname[]={"Profile","Notices","Programs","Feedback","Posts"};

    ImageButton playpause;
    int i=0;
    MediaPlayer mediaPlayer;
    Uri myUri = Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        playpause=(ImageButton)findViewById(R.id.playpause);

        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(i%2==0){
                    playpause.setImageResource(R.drawable.ic_pause);
                    i++;
                    try{
                        mediaPlayer = new MediaPlayer();
                        mediaPlayer.setDataSource(getApplicationContext(), myUri);
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.prepare(); //don't use prepareAsync for mp3 playback
                        mediaPlayer.start();
                        Toast.makeText(getApplicationContext(), "Play", Toast.LENGTH_SHORT).show();

                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), ""+e, Toast.LENGTH_SHORT).show();
                    }
                }
               else{
                    playpause.setImageResource(R.drawable.ic_play);
                    i++;
                    mediaPlayer.pause();
                    Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_SHORT).show();
                }
            }
        });

        com.airbnb.lottie.LottieAnimationView animation =(LottieAnimationView) findViewById(R.id.music);
        animation.setSpeed((float) 1.2); // How fast does the animation play
        animation.setProgress((float) 50); // Starts the animation from 50% of the beginning
        animation.setRepeatMode(LottieDrawable.RESTART);  // Restarts the animation (you can choose to reverse it as well)


        CircleMenu cm=(CircleMenu)findViewById(R.id.circlemenu);
        cm.setMainMenu(Color.parseColor("#bd81f2"),R.drawable.ic_tap,R.drawable.ic_plus)
                .addSubMenu(Color.parseColor("#bd81f2"),R.drawable.ic_profile)
                .addSubMenu(Color.parseColor("#bd81f2"),R.drawable.ic_notice)
                .addSubMenu(Color.parseColor("#bd81f2"),R.drawable.ic_programs)
                .addSubMenu(Color.parseColor("#bd81f2"),R.drawable.ic_feedback)
                .addSubMenu(Color.parseColor("#bd81f2"),R.drawable.ic_gallery)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        Toast.makeText(getApplicationContext(),"Select Item = "+arrayname[index],Toast.LENGTH_SHORT).show();

                        if(index==0){
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                    if(!user.getDisplayName().equals("null")){
                                        final Intent mainIntent = new Intent(getApplicationContext(), User_Profile.class);
                                        Home.this.startActivity(mainIntent);
                                        Home.this.finish();
                                    }
                                    else{
                                        Toast.makeText(Home.this, "You are guest user", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }, 1700);
                        }
                        if(index==1){
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    final Intent mainIntent = new Intent(getApplicationContext(), User_Events.class);
                                    Home.this.startActivity(mainIntent);
                                    Home.this.finish();
                                }
                            }, 1700);
                        }
                        if(index==2){
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    final Intent mainIntent = new Intent(getApplicationContext(), User_Programs.class);
                                    Home.this.startActivity(mainIntent);
                                    Home.this.finish();
                                }
                            }, 1700);
                        }
                    }
                });


    }
}
