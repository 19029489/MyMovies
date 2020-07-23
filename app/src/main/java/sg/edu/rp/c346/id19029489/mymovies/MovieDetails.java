package sg.edu.rp.c346.id19029489.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {

    TextView tvTitle, tvYear, tvGenre, tvDescription, tvWatchOn, tvTheatre;
    ImageView ivRated;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        tvTitle = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewYear);
        tvGenre = findViewById(R.id.textViewGenre);
        tvDescription = findViewById(R.id.textViewDescription);
        tvWatchOn = findViewById(R.id.textViewWatchOn);
        tvTheatre = findViewById(R.id.textViewInTheatre);
        ivRated = findViewById(R.id.imageViewRated);
        ratingBar = findViewById(R.id.ratingBar);

        Intent intentReceived = getIntent();

        String title = intentReceived.getStringExtra("title");
        tvTitle.setText(title);

        String year = intentReceived.getStringExtra("year");
        tvYear.setText(year);

        String genre = intentReceived.getStringExtra("genre");
        tvGenre.setText(genre);

        String description = intentReceived.getStringExtra("description");
        tvDescription.setText(description);

        //Watch On

        String theatre = intentReceived.getStringExtra("theatre");
        tvTheatre.setText("In Theatre: " + theatre);

        String rated = intentReceived.getStringExtra("rated");

        if (rated.equalsIgnoreCase("pg")) {
            ivRated.setImageResource(R.drawable.rating_pg);
        } else if(rated.equalsIgnoreCase("m18")) {
            ivRated.setImageResource(R.drawable.rating_m18);
        } else if(rated.equalsIgnoreCase("nc16")) {
            ivRated.setImageResource(R.drawable.rating_nc16);
        } else if(rated.equalsIgnoreCase("r21")) {
            ivRated.setImageResource(R.drawable.rating_r21);
        } else if(rated.equalsIgnoreCase("pg13")) {
            ivRated.setImageResource(R.drawable.rating_pg13);
        } else{
            ivRated.setImageResource(R.drawable.rating_g);
        }

        int rating = intentReceived.getIntExtra("rating", 0);
        ratingBar.setRating(rating);
    }
}