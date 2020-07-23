package sg.edu.rp.c346.id19029489.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie.findViewById(R.id.listViewMovie);

        Calendar date = Calendar.getInstance();
        date.set(2014, 10, 15);

        Calendar date2 = Calendar.getInstance();
        date2.set(2015, 4, 15);

        alMovieList = new ArrayList<>();
        alMovieList.add(new Movie("The Avengers", 2012, "pg13", "Action | Sci-Fi", date, "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army."));
        alMovieList.add(new Movie("Planes", 2013, "pg", "Animation | Comedy", date2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race."));

        caMovie = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                Movie currentMovie = alMovieList.get(position);
                intent.putExtra("title", currentMovie.getTitle());
                intent.putExtra("year", currentMovie.getYear());
                intent.putExtra("rated", currentMovie.getRated());
                intent.putExtra("genre", currentMovie.getGenre());
                intent.putExtra("theatre", currentMovie.getIn_theatre());
                intent.putExtra("description", currentMovie.getDescription());
                startActivity(intent);
            }
        });


    }


}