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

import com.bumptech.glide.Glide;
import com.jmsys.mywallpaper.R;
import com.yournight.stack.yournight.PostItem;
import com.yournight.stack.yournight.VO.DiaryData;

import io.realm.RealmResults;

/**
 * Created by geni on 2017. 8. 12..
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private RealmResults<DiaryData> mRealmResults;
    private Context mContext;

    public PostAdapter(RealmResults<DiaryData> realmResults, Context context){
        this.mRealmResults = realmResults;
        this.mContext = context;
    }

    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PostAdapter.ViewHolder holder, final int position) {
        if(position == 0){
            Glide.with(mContext)
                    .load(R.drawable.first_slide)
                    .fitCenter()
                    .into(holder.background);
        } else if(position == mRealmResults.size()-1){
            Glide.with(mContext)
                    .load(R.drawable.last_slide)
                    .fitCenter()
                    .into(holder.background);
        } else {
            Glide.with(mContext)
                    .load(R.drawable.slide)
                    .fitCenter()
                    .into(holder.background);
        }
        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PostItem.class);
                intent.putExtra("title", mRealmResults.get(position).getTitle());
                intent.putExtra("content", mRealmResults.get(position).getContent());
                mContext.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
        holder.title.setText(mRealmResults.get(position).getTitle());
        holder.content.setText(mRealmResults.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mRealmResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView content;
        ImageView background;

        public ViewHolder(View view){
            super(view);
            this.title = (TextView)view.findViewById(R.id.title);
            this.content = (TextView)view.findViewById(R.id.content);
            this.background = (ImageView)view.findViewById(R.id.background);
        }
    }
}
