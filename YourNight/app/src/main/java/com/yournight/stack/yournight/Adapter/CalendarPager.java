package com.yournight.stack.yournight.Adapter;

import android.content.Context;
import android.support.v4.util.Pools;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmsys.mywallpaper.R;
import com.yournight.stack.yournight.VO.DiaryData;

import io.realm.RealmResults;

/**
 * Created by geni on 2017. 8. 12..
 */

public class CalendarPager extends PagerAdapter {
    private final int MAX_POOL_SIZE = 12;
    private Context mContext;
    private Pools.SimplePool<View> viewPool;
    private RealmResults<DiaryData> mRealmResult;

    public CalendarPager(Context context, RealmResults realmResults) {
        this.mContext = context;
        this.mRealmResult = realmResults;
        viewPool = new Pools.SynchronizedPool<>(MAX_POOL_SIZE);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = getPagerItemView();
        TextView month = (TextView)view.findViewById(R.id.month);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.calendar);
        month.setText(position+1+"");
        recyclerView.setAdapter(new CalendarAdapter(mContext, mRealmResult, position+1));
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 7));
        container.addView(view);
        return view;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        viewPool.release((View) object);
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    private View getPagerItemView() {
        View view = viewPool.acquire();
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.calendar_pager, null);
        }

        return view;
    }
}
