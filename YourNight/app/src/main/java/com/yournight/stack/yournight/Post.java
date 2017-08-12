package com.yournight.stack.yournight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jmsys.mywallpaper.R;
import com.yournight.stack.yournight.Adapter.PostAdapter;

/**
 * Created by geni on 2017. 8. 12..
 */

public class Post extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        imageView = (ImageView)findViewById(R.id.background);
        Glide.with(getApplicationContext())
                .load(R.drawable.background_img)
                .centerCrop()
                .into(imageView);

        recyclerView = (RecyclerView)findViewById(R.id.post_list);
        recyclerView.setAdapter(new PostAdapter("test title", "test content", getApplicationContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
