package sg.edu.rp.c346.id19018582.MovieDetailActivity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;
import android.widget.ImageView;

import android.widget.RatingBar;
import android.widget.TextView;

import sg.edu.rp.c346.id19018582.mymovies.R;

public class MovieDetailActivity extends AppCompatActivity {
    private ImageView image;
    private TextView title,watch, des,thr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        image=findViewById(R.id.imageView);
        title=findViewById(R.id.textViewTitle);
        watch=findViewById(R.id.textViewWatchon);
        des=findViewById(R.id.textViewdes);
        thr=findViewById(R.id.textViewTheatre);



        Intent intendReceived =getIntent();

        String tt= intendReceived.getStringExtra("title");
        String im=intendReceived.getStringExtra("rated");
        String desc= intendReceived.getStringExtra("description");
        String watchDate= intendReceived.getStringExtra("watched_on");
        String Theatre= intendReceived.getStringExtra("theatre");




        title.setText(tt);
        watch.setText("watched On:" + watchDate);
        thr.setText("In Theatre:" + Theatre);
        des.setText("desc:" + desc);



    }
}