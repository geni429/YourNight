package com.yournight.stack.yournight.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmsys.mywallpaper.R;
import com.yournight.stack.yournight.Post;
import com.yournight.stack.yournight.VO.DiaryData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.RealmResults;

/**
 * Created by geni on 2017. 8. 12..
 */

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {
    private int count = 1;
    private int dates = 0;
    private Context mContext;
    private RealmResults<DiaryData> mRealmResult;
    private int month;

    public CalendarAdapter(Context context, RealmResults<DiaryData> realmResults, int month){
        this.mContext = context;
        this.mRealmResult = realmResults;
        this.month = month;
    }

    @Override
    public CalendarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.date, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, Post.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CalendarAdapter.ViewHolder holder, int position) {
        holder.date.setText(count+"");
        for(int i=0; i<mRealmResult.size(); i++){
            if (mRealmResult.get(i).getDate().equals(count+"")){
                switch ((int)mRealmResult.where().contains("date", count+"").count()) {
                    case 0:
                        break;
                    case 1:
                        holder.date.setBackgroundResource(R.drawable.count1);
                        break;
                    case 2:
                        holder.date.setBackgroundResource(R.drawable.count2);
                        break;
                    case 3:
                        holder.date.setBackgroundResource(R.drawable.count3);
                        break;
                    case 4:
                        holder.date.setBackgroundResource(R.drawable.count4);
                        break;
                    case 5:
                        holder.date.setBackgroundResource(R.drawable.count5);
                        break;
                    default:
                        holder.date.setBackgroundResource(R.drawable.count5);
                        break;
                }
            }
        }
        this.count++;
    }

    @Override
    public int getItemCount() {
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            this.dates = 31;
        } else {
            this.dates = 30;
        }
        return dates;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;

        public ViewHolder(View view){
            super(view);
            this.date = (TextView) view.findViewById(R.id.date);
        }
    }
}
