package com.yournight.stack.yournight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jmsys.mywallpaper.R;
import com.yournight.stack.yournight.VO.DiaryData;

import java.util.Calendar;

import io.realm.Realm;

/**
 * Created by geni on 2017. 8. 12..
 */

public class Write extends AppCompatActivity {
    private Realm mRealm;
    private EditText title, content;
    private Calendar calendar;
    private FloatingActionButton save;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);
        calendar = Calendar.getInstance();
        mRealm.init(getApplicationContext());
        mRealm = Realm.getDefaultInstance();

        title = (EditText)findViewById(R.id.title);
        content = (EditText)findViewById(R.id.content);
        save = (FloatingActionButton) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContent(title.getText().toString(), content.getText().toString());
            }
        });

    }

    private void saveContent(String title, String content){
        mRealm.beginTransaction();
        DiaryData diaryData = mRealm.createObject(DiaryData.class);
        diaryData.setContent(title);
        diaryData.setTitle(content);
        diaryData.setDate(calendar.get(Calendar.YEAR) + "" + (calendar.get(Calendar.MONTH)+1) + "" + calendar.get(Calendar.DATE) + "");
        diaryData.setTime(calendar.get(Calendar.HOUR_OF_DAY) + "" + calendar.get(Calendar.MINUTE) + "" + calendar.get(Calendar.SECOND) + "");
        mRealm.commitTransaction();
    }
}
