package br.ufmg.coltec.tp.appacademico.Data.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.Professor;
import br.ufmg.coltec.tp.appacademico.Data.Interfaces.IRepositorioProfessor;

public class RepositorioProfessor extends Repositorio implements IRepositorioProfessor {

    private static final String TABELA = "professores";
    private static final String PROFESSOR_ID = "id";
    private static final String PROFESSOR_NOME = "nome";
    private static final String PROFESSOR_MATRICULA = "matricula";

    public RepositorioProfessor(Context context) {
        super(context);
    }

    @Override
    public void inserir(Integrante i) {
        SQLiteDatabase db = getWritableDatabase();db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(PROFESSOR_ID, i.getId());
            values.put(PROFESSOR_NOME, i.getNome());
            values.put(PROFESSOR_MATRICULA, i.getMatricula());

            db.insertOrThrow(TABELA, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("INSERT", "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public Integrante consultar(int id) {
        Professor professor = null;

        try (SQLiteDatabase db = getReadableDatabase()) {
            Cursor c = db.query(TABELA, null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    int idProfessor = c.getInt(c.getColumnIndex(PROFESSOR_ID));
                    if (idProfessor == id) {
                        String nomeProfessor = c.getString(c.getColumnIndex(PROFESSOR_NOME));
                        String matriculaProfessor = c.getString(c.getColumnIndex(PROFESSOR_MATRICULA));
                        professor = new Professor(idProfessor, nomeProfessor, matriculaProfessor);
                    }
                } while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            throw e;
        }
        return professor;
    }

    @Override
    public List<Integrante> consultarTodos() {
        return null;
    }

    @Override
    public void remover(int id) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SCRIPT_CREATE = "CREATE TABLE IF NOT EXISTS "+TABELA+
                "("+
                PROFESSOR_ID+" INTEGER PRIMARY KEY,"+
                PROFESSOR_NOME+" TEXT NOT NULL,"+
                PROFESSOR_MATRICULA+" TEXT NOT NULL "+
                ")";
        sqLiteDatabase.execSQL(SCRIPT_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
