package adftutorials.com.adftutorials.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import adftutorials.com.adftutorials.logging.L;

/**
 * Created by JK1306 on 6/10/2015.
 */
public class Articles implements Parcelable {

    private long id;
    private String title;
    private String thumb;
    private String date;
    private String author;
    private String excerpt;


    public static final Parcelable.Creator<Articles> CREATOR
            = new Parcelable.Creator<Articles>() {
        public Articles createFromParcel(Parcel in) {
            L.m("create from parcel :Movie");
            return new Articles(in);
        }
        public Articles[] newArray(int size) {
            return new Articles[size];
        }


    };

    public Articles(long id, String title, String thumb, String date, String author, String excerpt) {
        this.id = id;
        this.title = title;
        this.thumb = thumb;
        this.date = date;
        this.author = author;
        this.excerpt = excerpt;

    }


    public Articles(Parcel input) {
        id = input.readLong();
        title = input.readString();
        thumb=input.readString();
        date=input.readString();
        author=input.readString();
        excerpt=input.readString();
    }



    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        L.m("writeToParcel Movie");
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(thumb);
        dest.writeString(date);
        dest.writeString(author);
        dest.writeString(excerpt);

    }
}
