package com.yournight.stack.yournight.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmsys.mywallpaper.R;
import com.yournight.stack.yournight.Post;

/**
 * Created by geni on 2017. 8. 12..
 */

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {
    private int count = 1;
    private Context mContext;
    public CalendarAdapter(Context context){
        this.mContext = context;
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
        this.count++;
    }

    @Override
    public int getItemCount() {
        return 31;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;

        public ViewHolder(View view){
            super(view);
            this.date = (TextView) view.findViewById(R.id.date);
        }
    }
}
