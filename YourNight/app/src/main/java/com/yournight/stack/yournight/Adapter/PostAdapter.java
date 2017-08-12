package com.yournight.stack.yournight.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jmsys.mywallpaper.R;

import org.w3c.dom.Text;

/**
 * Created by geni on 2017. 8. 12..
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private String title;
    private String content;
    private Context mContext;

    public PostAdapter(String title, String content, Context context){
        this.title = title;
        this.content = content;
        this.mContext = context;
    }

    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PostAdapter.ViewHolder holder, int position) {
        if(position == 0){
            Glide.with(mContext)
                    .load(R.drawable.first_slide)
                    .fitCenter()
                    .into(holder.background);
        } else if(position == 9){
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
        holder.title.setText(title);
        holder.content.setText(content);
    }

    @Override
    public int getItemCount() {
        return 10;
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
