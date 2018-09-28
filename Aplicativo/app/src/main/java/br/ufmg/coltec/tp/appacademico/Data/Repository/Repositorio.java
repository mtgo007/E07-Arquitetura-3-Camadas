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
        String SCRIPT_CREATE = "CREATE TABLE IF NOT EXISTS "+ RepositorioAluno.TABELA+
                "("+
                RepositorioAluno.ALUNO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                RepositorioAluno.ALUNO_NOME+" TEXT NOT NULL,"+
                RepositorioAluno.ALUNO_MATRICULA+" TEXT NOT NULL "+
                ")";
        db.execSQL(SCRIPT_CREATE);

        SCRIPT_CREATE = "CREATE TABLE IF NOT EXISTS "+RepositorioProfessor.TABELA+
                "("+
                RepositorioProfessor.PROFESSOR_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                RepositorioProfessor.PROFESSOR_NOME+" TEXT NOT NULL,"+
                RepositorioProfessor.PROFESSOR_MATRICULA+" TEXT NOT NULL "+
                ")";
        db.execSQL(SCRIPT_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
