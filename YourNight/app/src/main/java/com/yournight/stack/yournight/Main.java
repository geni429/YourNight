package com.yournight.stack.yournight;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jmsys.mywallpaper.R;
import com.yournight.stack.yournight.Adapter.CalendarAdapter;
import com.yournight.stack.yournight.Adapter.CalendarPager;
import com.yournight.stack.yournight.VO.DiaryData;

import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by geni on 2017. 8. 12..
 */

public class Main extends AppCompatActivity {
    private Realm mRealm;
    private ViewPager viewPager;
    private FloatingActionButton write;
    private RealmResults<DiaryData> realmResults;
    private Calendar calendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        calendar = Calendar.getInstance();
        mRealm.init(getApplicationContext());
        mRealm = mRealm.getDefaultInstance();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realmResults = realm.where(DiaryData.class).findAll();
            }
        });

        viewPager = (ViewPager)findViewById(R.id.calendar_pager);
        write = (FloatingActionButton)findViewById(R.id.write);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Write.class));
                finish();
            }
        });

        CalendarPager adapter = new CalendarPager(getApplicationContext(), realmResults);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(calendar.get(Calendar.MONTH));
    }
}
