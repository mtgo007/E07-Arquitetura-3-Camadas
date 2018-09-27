package br.ufmg.coltec.tp.appacademico.Data.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import br.ufmg.coltec.tp.appacademico.Business.Models.Aluno;
import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Data.Interfaces.IRepositorioAluno;

public class RepositorioAluno extends Repositorio implements IRepositorioAluno {

    private static final String TABELA = "alunos";
    private static final String ALUNO_ID = "id";
    private static final String ALUNO_NOME = "nome";
    private static final String ALUNO_MATRICULA = "matricula";

    public RepositorioAluno(Context context) {
        super(context);
    }

    @Override
    public void inserir(Integrante i) {
        SQLiteDatabase db = getWritableDatabase();db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(ALUNO_ID, i.getId());
            values.put(ALUNO_NOME, i.getNome());
            values.put(ALUNO_MATRICULA, i.getMatricula());

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
        Aluno aluno = null;

        try (SQLiteDatabase db = getReadableDatabase()) {
            Cursor c = db.query(TABELA, null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    int idAluno = c.getInt(c.getColumnIndex(ALUNO_ID));
                    if (idAluno == id) {
                        String nomeAluno = c.getString(c.getColumnIndex(ALUNO_NOME));
                        String matriculaAluno = c.getString(c.getColumnIndex(ALUNO_MATRICULA));
                        aluno = new Aluno(idAluno, nomeAluno, matriculaAluno);
                    }
                } while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            throw e;
        }
        return aluno;
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
                    ALUNO_ID+" INTEGER PRIMARY KEY,"+
                    ALUNO_NOME+" TEXT NOT NULL,"+
                    ALUNO_MATRICULA+" TEXT NOT NULL "+
                ")";
        sqLiteDatabase.execSQL(SCRIPT_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
