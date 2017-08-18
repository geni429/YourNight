package com.yournight.stack.yournight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.yournight.stack.yournight.VO.UtilValue;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by geni on 2017. 8. 12..
 */

public class Splash extends Activity {
    private Realm mRealm;
    private RealmResults<UtilValue> realmResults;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        mRealm = Realm.getDefaultInstance();
        realmResults = mRealm.where(UtilValue.class).findAll();
        if(mRealm != null){
            initializing();
        }

        if(!realmResults.where().findFirst().isCheck()){
            startActivity(new Intent(getApplicationContext(), Tutorial.class));
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    mRealm.where(UtilValue.class).findFirst().setCheck(true);
                }
            });
            finish();
        } else {
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
