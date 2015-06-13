package adftutorials.com.adftutorials.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import adftutorials.com.adftutorials.extras.Constants;
import adftutorials.com.adftutorials.logging.L;
import adftutorials.com.adftutorials.pojo.Articles;

import static adftutorials.com.adftutorials.extras.Keys.ArticleKey.KEY_ARTICLES;
import static adftutorials.com.adftutorials.extras.Keys.ArticleKey.KEY_AUTHOR;
import static adftutorials.com.adftutorials.extras.Keys.ArticleKey.KEY_EXCERPT;
import static adftutorials.com.adftutorials.extras.Keys.ArticleKey.KEY_ID;
import static adftutorials.com.adftutorials.extras.Keys.ArticleKey.KEY_POST_DATE;
import static adftutorials.com.adftutorials.extras.Keys.ArticleKey.KEY_THUMB;
import static adftutorials.com.adftutorials.extras.Keys.ArticleKey.KEY_TITLE;

/**
 * Created by Windows on 02-03-2015.
 */
public class ArticleParser {
    public static ArrayList<Articles> parseMoviesJSON(JSONObject response) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Articles> listarticle = new ArrayList<>();
        if (response != null && response.length() > 0) {
            try {
                JSONArray arrayMovies = response.getJSONArray(KEY_ARTICLES);
                for (int i = 0; i < arrayMovies.length(); i++) {
                    long id = -1;
                    String title = Constants.NA;
                    String thumb = Constants.NA;
                    String date = Constants.NA;
                    String author = Constants.NA;
                    String excerpt = Constants.NA;

                    JSONObject currentArticle = arrayMovies.getJSONObject(i);
                    //get the id of the current movie
                    if (Utils.contains(currentArticle, KEY_ID)) {
                        id = currentArticle.getLong(KEY_ID);
                    }
                    //get the title of the current movie
                    if (Utils.contains(currentArticle, KEY_TITLE)) {
                        title = currentArticle.getString(KEY_TITLE);
                    }

                    //get the date in theaters for the current movie
                    if (Utils.contains(currentArticle, KEY_THUMB)) {
                        thumb = currentArticle.getString(KEY_THUMB);


                    }

                    if (Utils.contains(currentArticle, KEY_POST_DATE)) {
                        date = currentArticle.getString(KEY_POST_DATE);


                    }

                    //get the audience score for the current movie

                    if (Utils.contains(currentArticle, KEY_AUTHOR)) {
                        author = currentArticle.getString(KEY_AUTHOR);

                    }

                    if (Utils.contains(currentArticle, KEY_EXCERPT)) {
                        excerpt = currentArticle.getString(KEY_EXCERPT);

                    }

                    Articles article = new Articles(id,title,thumb,date,author,excerpt);


                    L.m("my id======>"+id+"  "+title);
                    if (id != -1 && !title.equals(Constants.NA)) {
                        listarticle.add(article);
                    }
                }

            } catch (JSONException e) {

            }
//                L.t(getActivity(), listMovies.size() + " rows fetched");
        }
        return listarticle;
    }


}
