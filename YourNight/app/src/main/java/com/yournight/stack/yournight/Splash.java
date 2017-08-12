package com.yournight.stack.yournight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.yournight.stack.yournight.VO.UtilValue;

import io.realm.Realm;

/**
 * Created by geni on 2017. 8. 12..
 */

public class Splash extends Activity {
    private Realm mRealm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm.init(getApplicationContext());
        mRealm = Realm.getDefaultInstance();
        if(mRealm != null){
            initializing();
        }

        if(!mRealm.where(UtilValue.class).findFirst().isCheck()){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startActivity(new Intent(getApplicationContext(), Main.class));
            finish();
        }
    }

    private void initializing(){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                UtilValue utilValue = mRealm.createObject(UtilValue.class);
                utilValue.setCheck(false);
            }
        });
    }
}
