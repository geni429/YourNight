package com.yournight.stack.yournight;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jmsys.mywallpaper.R;

/**
 * Created by geni on 2017. 8. 13..
 */

public class Tutorial extends AppCompatActivity {
    private ImageView imageView;
    private int count = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorials);
        imageView = (ImageView)findViewById(R.id.img);
        Glide.with(getApplicationContext())
                .load(R.drawable.tutorial1)
                .centerCrop()
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count != 5){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.tutorial1+count)
                            .centerCrop()
                            .crossFade()
                            .into(imageView);
                    count++;
                } else {
                    startActivity(new Intent(getApplicationContext(), Main.class));
                    finish();
                }
            }
        });
    }
}
