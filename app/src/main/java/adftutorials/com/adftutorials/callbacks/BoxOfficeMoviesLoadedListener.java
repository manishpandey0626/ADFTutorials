package adftutorials.com.adftutorials.callbacks;

import java.util.ArrayList;

import adftutorials.com.adftutorials.pojo.Articles;


/**
 * Created by Windows on 02-03-2015.
 */
public interface BoxOfficeMoviesLoadedListener {
    public void onBoxOfficeMoviesLoaded(ArrayList<Articles> listMovies);
}
