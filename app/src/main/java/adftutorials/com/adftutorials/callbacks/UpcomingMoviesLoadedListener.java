package adftutorials.com.adftutorials.callbacks;

import java.util.ArrayList;

import adftutorials.com.adftutorials.pojo.Movie;


/**
 * Created by Windows on 13-04-2015.
 */
public interface UpcomingMoviesLoadedListener {
    public void onUpcomingMoviesLoaded(ArrayList<Movie> listMovies);
}
