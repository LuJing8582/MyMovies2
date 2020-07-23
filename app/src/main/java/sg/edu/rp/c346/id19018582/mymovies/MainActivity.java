package sg.edu.rp.c346.id19018582.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie>alMovie;
    CustomAdapter caMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie=findViewById(R.id.listViewMovie);

        alMovie=new ArrayList<>();
        final Calendar date1 =Calendar.getInstance();
        date1.set(2014,11,15);
        Movie movie1=new Movie("The Avengers",2012,"pg13","Action | Sci-Fi",date1,"Golden Village - Bishan","Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        alMovie.add(movie1);

        Calendar date2 =Calendar.getInstance();
        date1.set(2013,5,15);
        Movie movie2=new Movie("Planes",2013,"pg","Animation | Comedy",date2,"Cathay - AMK Hub","A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
        alMovie.add(movie2);

        caMovie=new CustomAdapter(this,R.layout.row,alMovie);
        lvMovie.setAdapter(caMovie);


        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentInfo = new Intent(MainActivity.this, sg.edu.rp.c346.id19018582.MovieDetailActivity.MovieDetailActivity.class);
                Movie currentMovie =alMovie.get(position);
                intentInfo.putExtra("title",currentMovie.getTitle());
                intentInfo.putExtra("year",currentMovie.getYear());
                intentInfo.putExtra("rated", currentMovie.getRated());
                intentInfo.putExtra("genre",currentMovie.getGenre());
                intentInfo.putExtra("watched_on",currentMovie.getWatched_on());
                intentInfo.putExtra("theatre", currentMovie.getIn_theatre());
                intentInfo.putExtra("description",currentMovie.getDescription());

                startActivity(intentInfo);
            }
        });
    }
}