package adftutorials.com.adftutorials.extras;

import com.android.volley.RequestQueue;

import org.json.JSONObject;

import java.util.ArrayList;

import adftutorials.com.adftutorials.json.ArticleParser;
import adftutorials.com.adftutorials.json.Requestor;
import adftutorials.com.adftutorials.logging.L;
import adftutorials.com.adftutorials.pojo.Articles;



/**
 * Created by Windows on 02-03-2015.
 */
public class MovieUtils {
    public static ArrayList<Articles> loadBoxOfficeMovies(RequestQueue requestQueue) {
        JSONObject response = Requestor.requestMoviesJSON(requestQueue, "http://www.adftutorials.com/api-test-2");

        ArrayList<Articles> listMovies = ArticleParser.parseMoviesJSON(response);
        L.m("No of movies==>"+listMovies.size());
      //  MyApplication.getWritableDatabase().insertMovies(DBMovies.BOX_OFFICE, listMovies, true);
        return listMovies;
    }

  /*  public static ArrayList<Movie> loadUpcomingMovies(RequestQueue requestQueue) {
        JSONObject response = Requestor.requestMoviesJSON(requestQueue, Endpoints.getRequestUrlUpcomingMovies(30));
        ArrayList<Movie> listMovies = Parser.parseMoviesJSON(response);
        MyApplication.getWritableDatabase().insertMovies(DBMovies.UPCOMING, listMovies, true);
        return listMovies;
    }*/
}
