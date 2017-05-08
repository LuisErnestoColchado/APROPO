package com.fabrizziochavez.apropo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DB_Version = 1;
    private static final String DB_Name = "db_apropo";

    //tablas
    public static final String TB_Puntos = "tb_puntos";

    public DatabaseHandler(Context context){
        super(context, DB_Name, null, DB_Version);
    }

    public void truncateTabla(String table_name, String condicion){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + table_name + condicion);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TB_Puntos + "(" +
                "bcId TEXT," +
                "bcNombre TEXT," +
                "bcNombreCorto TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TB_Puntos);
        onCreate(db);
    }
    //EJEMPLO AÑADIR BANCO
//    public void addBanco(BancosModel bc){
//        SQLiteDatabase db = this.getReadableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("bcId", bc.getBcId());
//        values.put("bcNombre", bc.getBcDescripcion());
//        values.put("bcNombreCorto", bc.getBcDescripcionCorta());
//        try {
//            db.insert(TB_Puntos, null, values);
//        }catch (Throwable t){
//            Log.e("Error", t.getMessage());
//        }
//    }

}
