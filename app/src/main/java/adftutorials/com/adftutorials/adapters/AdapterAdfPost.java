package adftutorials.com.adftutorials.adapters;

/**
 * Created by JK1306 on 6/8/2015.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import adftutorials.com.adftutorials.R;
import adftutorials.com.adftutorials.anim.AnimationUtils;
import adftutorials.com.adftutorials.extras.Constants;
import adftutorials.com.adftutorials.logging.L;
import adftutorials.com.adftutorials.netework.VolleySingleton;
import adftutorials.com.adftutorials.pojo.Articles;


public class AdapterAdfPost extends RecyclerView.Adapter<AdapterAdfPost.ViewHolderAdfpost> {

    //contains the list of movies
    private ArrayList<Articles> mListMovies = new ArrayList<>();
    private LayoutInflater mInflater;
    private VolleySingleton mVolleySingleton;
    private ImageLoader mImageLoader;
    //formatter for parsing the dates in the specified format below
    private DateFormat mFormatter = new SimpleDateFormat("yyyy-MM-dd");
    //keep track of the previous position for animations where scrolling down requires a different animation compared to scrolling up
    private int mPreviousPosition = 0;


    public AdapterAdfPost(Context context) {
        mInflater = LayoutInflater.from(context);
        mVolleySingleton = VolleySingleton.getInstance();
        mImageLoader = mVolleySingleton.getImageLoader();
    }

   public void setMovies(ArrayList<Articles> listMovies) {
        this.mListMovies = listMovies;

       L.m("inside adapter==>" +this.mListMovies.size());
        //update the adapter to reflect the new set of movies
        notifyDataSetChanged();
    }

    @Override
    public ViewHolderAdfpost onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custome_adf_post, parent, false);
        ViewHolderAdfpost viewHolder = new ViewHolderAdfpost(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderAdfpost holder, int position) {
        Articles currentMovie = mListMovies.get(position);
        //one or more fields of the Movie object may be null since they are fetched from the web
        holder.movieTitle.setText(currentMovie.getTitle());
        L.m("adpater Title==>" +currentMovie.getTitle());
        L.m("adpter date==>"+currentMovie.getDate());

        //retrieved date may be null

            holder.movieReleaseDate.setText(currentMovie.getDate());
        holder.articleexcerpt.setText(currentMovie.getExcerpt());
        holder.postby.setText(" "+currentMovie.getAuthor());



        if (position > mPreviousPosition) {
            AnimationUtils.animateSunblind(holder, true);
//            AnimationUtils.animateSunblind(holder, true);
//            AnimationUtils.animate1(holder, true);
//            AnimationUtils.animate(holder,true);
        } else {
            AnimationUtils.animateSunblind(holder, false);
//            AnimationUtils.animateSunblind(holder, false);
//            AnimationUtils.animate1(holder, false);
//            AnimationUtils.animate(holder, false);
        }
        mPreviousPosition = position;

       // String urlThumnail = currentMovie.getThumb();
       // loadImages(urlThumnail, holder);

    }


    private void loadImages(String urlThumbnail, final ViewHolderAdfpost holder) {
        if (!urlThumbnail.equals(Constants.NA)) {
            mImageLoader.get(urlThumbnail, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.movieThumbnail.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mListMovies.size();
    }

    static class ViewHolderAdfpost extends RecyclerView.ViewHolder {

        ImageView movieThumbnail;
        TextView movieTitle;
        TextView movieReleaseDate;
        TextView articleexcerpt;
        TextView postby;


        public ViewHolderAdfpost(View itemView) {
            super(itemView);
         //   movieThumbnail = (ImageView) itemView.findViewById(R.id.movieThumbnail);
            movieTitle = (TextView) itemView.findViewById(R.id.movieTitle);
            movieReleaseDate = (TextView) itemView.findViewById(R.id.movieReleaseDate);
            articleexcerpt=(TextView)itemView.findViewById(R.id.article_excerpt);
            postby=(TextView)itemView.findViewById(R.id.postby);

        }
    }
}
