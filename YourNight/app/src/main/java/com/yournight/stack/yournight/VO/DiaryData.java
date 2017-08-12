package com.yournight.stack.yournight.VO;

import io.realm.RealmObject;

/**
 * Created by geni on 2017. 8. 12..
 */

public class DiaryData extends RealmObject {
    private String title;
    private String content;
    private String date;
    private String detailDate;
    private String time;
    private int count;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetailDate() {
        return detailDate;
    }

    public void setDetailDate(String detailDate) {
        this.detailDate = detailDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void addCount(){
        this.count = ++count;
    }
}
