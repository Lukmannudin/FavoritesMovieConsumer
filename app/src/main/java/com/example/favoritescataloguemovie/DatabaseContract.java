package com.example.favoritescataloguemovie;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {
    public static String TABLE_FAVORITE = "favorites";
    static String TABLE_STATUS = "status";
    public static final String AUTHORITY = "com.lukmannudin.assosiate.searchmovie";
    private static final String SCHEME = "content";

    public static final class FavoriteColumns implements BaseColumns {
       public static String TITLE = "title";
       public static String IMAGE_PATH = "image_path";
       public static String RATING = "rating";
       public static String POPULARITY = "popularity";
       public static String LANGUAGE = "language";
       public static String GENRES = "genres";
       public static String RELEASE = "release";
       public static String OVERVIEW = "overview";

        public static final Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_FAVORITE)
                .build();
    }

    static String STATUS_RELEASE_FIELD = "status_release";
    static String STATUS_DAILY_FIELD = "status_daily";

    static final class StatusColumns implements BaseColumns {
        static String STATUS_RELEASE_REMINDER = "status_release";
        static String STATUS_DAILY_REMINDER = "status_daily";
        static String TOTAL_ALARM = "total_alarm";
    }

    public static String getColumnString(Cursor cursor, String columnName) {
        return cursor.getString(cursor.getColumnIndex(columnName));
    }

    public static int getColumnInt(Cursor cursor, String columnName) {
        return cursor.getInt(cursor.getColumnIndex(columnName));
    }

    public static long getColumnLong(Cursor cursor, String columnName) {
        return cursor.getLong(cursor.getColumnIndex(columnName));
    }
}