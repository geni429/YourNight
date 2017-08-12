package com.yournight.stack.yournight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jmsys.mywallpaper.R;
import com.yournight.stack.yournight.Adapter.CalendarAdapter;
import com.yournight.stack.yournight.Adapter.CalendarPager;

import io.realm.Realm;

/**
 * Created by geni on 2017. 8. 12..
 */

public class Main extends AppCompatActivity {
    private Realm mRealm;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mRealm.init(getApplicationContext());
        mRealm = mRealm.getDefaultInstance();

        viewPager = (ViewPager)findViewById(R.id.calendar_pager);
        CalendarPager adapter = new CalendarPager(getApplicationContext());
        viewPager.setAdapter(adapter);
    }
}
