package com.yournight.stack.yournight;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import com.jmsys.mywallpaper.R;

public class Widget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        views.setTextViewText(R.id.title, "일기");
        views.setTextViewText(R.id.content, "오늘 정성화가 못생겼다.\n맨날 못생겼지만 오늘은 더 못생겼다\n리얼루다가");
        views.setTextViewText(R.id.date, "2017.8.11.금요일");
        views.setTextViewText(R.id.time, "21:18:23");
        views.setTextViewText(R.id.deleteBtn, "삭제");
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

