package com.yournight.stack.yournight;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

import com.jmsys.mywallpaper.R;
import com.yournight.stack.yournight.VO.DiaryData;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

public class Widget extends AppWidgetProvider {
    private Realm mRealm;

    private int rNum;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        mRealm.init(context);
        mRealm = Realm.getDefaultInstance();
        RealmResults<DiaryData> realmResults = mRealm.where(DiaryData.class).findAll();
        if(realmResults.size() == 0){
            views.setTextViewText(R.id.title, "");
            views.setTextViewText(R.id.content, "");
            views.setTextViewText(R.id.date, "");
            views.setTextViewText(R.id.time, "");
            views.setTextViewText(R.id.deleteBtn, "삭제");
        } else {
            rNum = (int)(Math.random()*realmResults.size());
            Log.d("RAMDOM", rNum+"");
            views.setTextViewText(R.id.title, realmResults.get(rNum).getTitle());
            views.setTextViewText(R.id.content, realmResults.get(rNum).getContent());
            views.setTextViewText(R.id.date, realmResults.get(rNum).getDetailDate());
            views.setTextViewText(R.id.time, realmResults.get(rNum).getTime());
            views.setTextViewText(R.id.deleteBtn, "삭제");
        }
        appWidgetManager.updateAppWidget(appWidgetIds, views);
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

