package com.yournight.stack.yournight;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.jmsys.mywallpaper.R;

/**
 * Created by geni on 2017. 8. 13..
 */

public class PostItem extends AppCompatActivity {
    private TextView title, content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_item);
        title = (TextView)findViewById(R.id.title);
        content = (TextView)findViewById(R.id.content);
        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        content.setText(intent.getStringExtra("content"));
    }
}
