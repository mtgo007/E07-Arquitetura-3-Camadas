package br.ufmg.coltec.tp.appacademico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mtgo0 on 26/09/2018.
 */

class RepositorioProfessor extends SQLiteOpenHelper implements IRepositorioProfessor{


    // nome do banco
    private static String DB_NAME = "Professores";

    // versão do banco
    private static final int DB_VERSION = 1;

    // script para criação do banco
    private static final String SCRIPT_CREATE = "CREATE TABLE IF NOT EXISTS Professores( matricula TEXT PRIMARY KEY NOT NULL, nome TEXT NOT NULL);";


    public RepositorioProfessor(Context c){
        super(c, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void insereProfessor(Professor p) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("nome", p.getNome());
            cv.put("matricula", p.getMatricula());
            db.insert("Professores", null, cv);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Professor consultaProfessor(String matricula) {
        SQLiteDatabase db = getReadableDatabase();

        try {
            // faz a leitura dos dados do banco
            Cursor c = db.query("Professores", null, null, null, null, null, null);

            if(c.moveToFirst()) {
                do {
                    String matriculaProfessor = c.getString(c.getColumnIndex("matricula"));
                    if (matriculaProfessor.equals(matricula)){
                        String nome = c.getString(c.getColumnIndex("nome"));
                        return new Professor(matriculaProfessor, nome);
                    }
                } while(c.moveToNext());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.close();
        }

        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SCRIPT_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
