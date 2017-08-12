package com.yournight.stack.yournight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jmsys.mywallpaper.R;
import com.yournight.stack.yournight.Adapter.CalendarAdapter;

import io.realm.Realm;

/**
 * Created by geni on 2017. 8. 12..
 */

public class Main extends AppCompatActivity {
    private Realm mRealm;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm.init(getApplicationContext());
        mRealm = mRealm.getDefaultInstance();
        setContentView(R.layout.main);
        recyclerView = (RecyclerView)findViewById(R.id.calendar);
        recyclerView.setAdapter(new CalendarAdapter(getApplicationContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 7));
    }
}
