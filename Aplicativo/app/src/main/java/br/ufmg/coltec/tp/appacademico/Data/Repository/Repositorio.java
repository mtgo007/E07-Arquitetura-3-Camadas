package br.ufmg.coltec.tp.appacademico.Data.Repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Repositorio extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Camadas";
    private static final int DATABASE_VERSION = 1;

    public Repositorio(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
