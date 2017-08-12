package com.yournight.stack.yournight.VO;

import io.realm.RealmObject;

/**
 * Created by geni on 2017. 8. 12..
 */

public class DiaryData extends RealmObject {
    private String title;
    private String content;
    private String date;
    private String time;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
