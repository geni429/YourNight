package com.yournight.stack.yournight.VO;

import io.realm.RealmObject;

/**
 * Created by geni on 2017. 8. 12..
 */

public class UtilValue extends RealmObject {
    private boolean check;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
