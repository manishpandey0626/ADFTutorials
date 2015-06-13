package adftutorials.com.adftutorials.json;


import adftutorials.com.adftutorials.myapp.MyApplication;

import static adftutorials.com.adftutorials.extras.UrlEndpoints.URL_BOX_OFFICE;
import static adftutorials.com.adftutorials.extras.UrlEndpoints.URL_CHAR_AMEPERSAND;
import static adftutorials.com.adftutorials.extras.UrlEndpoints.URL_CHAR_QUESTION;
import static adftutorials.com.adftutorials.extras.UrlEndpoints.URL_PARAM_API_KEY;
import static adftutorials.com.adftutorials.extras.UrlEndpoints.URL_PARAM_LIMIT;
import static adftutorials.com.adftutorials.extras.UrlEndpoints.URL_UPCOMING;
/**
 * Created by Windows on 02-03-2015.
 */
public class Endpoints {
    public static String getRequestUrlBoxOfficeMovies(int limit) {

        return URL_BOX_OFFICE
                + URL_CHAR_QUESTION
                + URL_PARAM_API_KEY + MyApplication.API_KEY_ROTTEN_TOMATOES
                + URL_CHAR_AMEPERSAND
                + URL_PARAM_LIMIT + limit;
    }

    public static String getRequestUrlUpcomingMovies(int limit) {

        return URL_UPCOMING
                + URL_CHAR_QUESTION
                + URL_PARAM_API_KEY + MyApplication.API_KEY_ROTTEN_TOMATOES
                + URL_CHAR_AMEPERSAND
                + URL_PARAM_LIMIT + limit;
    }
}
