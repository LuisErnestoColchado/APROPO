package com.fabrizziochavez.apropo.services;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fabrizziochavez.apropo.data.DatabaseHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SyncService extends IntentService {

    private static DatabaseHandler dbh;
    private static SessionManager session;
    public static AppCompatActivity activity;
    public static final String actionFinish = "FINISH";
    public static final String actionError = "ERROR";
    public static boolean newLogin=false;

    private int counter;
    private int counter_helper;

    public SyncService() {
        super("SyncService");
    }

    @Override
    protected void onHandleIntent(Intent intent){
        int actionType = intent.getIntExtra("actionType", 0);
        switch (actionType){
            case 1://Sync
                sync_ejemplo(actionType, "Ejemplo sincronizado");
                break;
            case 2:

                break;
            case 3:

                break;
        }
    }
    public void sync_ejemplo(int actionType, String message){
        if (true){
            sendActionBC(actionFinish, message, actionType);
        }
        else{
            sendActionBC(actionError, "Response error", actionType);
        }
    }
    private void sendActionBC(String action, String message, int actionType){
        Intent bcIntent = new Intent();
        bcIntent.setAction(action);
        bcIntent.putExtra("message", message);
        bcIntent.putExtra("actionType", actionType);
        sendBroadcast(bcIntent);
    }
}
