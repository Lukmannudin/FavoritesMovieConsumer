package com.example.favoritescataloguemovie;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.favoritescataloguemovie.Model.Movie;

import java.util.ArrayList;
import java.util.List;

import static com.example.favoritescataloguemovie.DatabaseContract.FavoriteColumns.CONTENT_URI;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_MOVIES = "KEY_MOVIES";
    private ArrayList<Movie> data = new ArrayList<>();
    FavoritesAdapter adapter;
    RecyclerView movieRecyclerView;
    private ProgressBar loading;
    List<Movie> data2;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loading = findViewById(R.id.mainProggressbar);
        swipeRefreshLayout = findViewById(R.id.mySwipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        if (savedInstanceState != null) {
            data = savedInstanceState.getParcelableArrayList(KEY_MOVIES);
            assert data != null;
            data2 = new ArrayList<>(data);
            loading.setVisibility(View.GONE);
        }

        movieRecyclerView = findViewById(R.id.rvMovie);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        movieRecyclerView.setLayoutManager(layoutManager);

        if (data2 != null) {
            adapter = new FavoritesAdapter(this, data2);
            movieRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else {
            getData();
        }
    }

    private void getData() {
        data.clear();
        Cursor mCursor = getApplicationContext().getContentResolver().query(CONTENT_URI, null, null, null, null);
        assert mCursor != null;
        List<Movie> list = MappingHelper.mapCursorToArrayList(mCursor);
        data.addAll(list);
        adapter = new FavoritesAdapter(this, data);
        movieRecyclerView.setAdapter(adapter);
        loading.setVisibility(View.GONE);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(KEY_MOVIES, data);
        super.onSaveInstanceState(outState);
    }
}
