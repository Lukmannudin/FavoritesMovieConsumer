package com.example.favoritescataloguemovie.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.favoritescataloguemovie.DatabaseContract;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "dbcataloguemovie";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE_FAVORITE = String.format("CREATE TABLE %s"
                    + " (" +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_FAVORITE,
            DatabaseContract.FavoriteColumns._ID,
            DatabaseContract.FavoriteColumns.TITLE,
            DatabaseContract.FavoriteColumns.IMAGE_PATH,
            DatabaseContract.FavoriteColumns.RATING,
            DatabaseContract.FavoriteColumns.POPULARITY,
            DatabaseContract.FavoriteColumns.LANGUAGE,
            DatabaseContract.FavoriteColumns.GENRES,
            DatabaseContract.FavoriteColumns.RELEASE,
            DatabaseContract.FavoriteColumns.OVERVIEW
    );


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_FAVORITE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_FAVORITE);

        onCreate(db);
    }
}
