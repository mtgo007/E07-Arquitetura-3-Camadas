package br.ufmg.coltec.tp.appacademico.Data.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteAluno;
import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Data.Interfaces.IRepositorioAluno;

public class RepositorioAluno extends Repositorio implements IRepositorioAluno {

    public static final String TABELA = "alunos";
    public static final String ALUNO_ID = "id";
    public static final String ALUNO_NOME = "nome";
    public static final String ALUNO_MATRICULA = "matricula";

    public RepositorioAluno(Context context) {
        super(context);
    }

    @Override
    public void inserir(IntegranteAluno i) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
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
    public void update(IntegranteAluno i) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(ALUNO_NOME, i.getNome());
            values.put(ALUNO_MATRICULA, i.getMatricula());

            db.update(TABELA, values, ALUNO_ID + "=" + i.getId(), null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("UPDATE", "Error while trying to update database");
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public IntegranteAluno consultar(int id) {
        IntegranteAluno aluno = null;

        try (SQLiteDatabase db = getReadableDatabase()) {
            Cursor c = db.query(TABELA, null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    int idAluno = c.getInt(c.getColumnIndex(ALUNO_ID));
                    if (idAluno == id) {
                        String nomeAluno = c.getString(c.getColumnIndex(ALUNO_NOME));
                        String matriculaAluno = c.getString(c.getColumnIndex(ALUNO_MATRICULA));
                        aluno = new IntegranteAluno(idAluno, nomeAluno, matriculaAluno);
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
    public ArrayList<IntegranteAluno> consultarTodos() {
        ArrayList<IntegranteAluno> alunos = new ArrayList<>();
        try (SQLiteDatabase db = getReadableDatabase()) {
            Cursor c = db.query(TABELA, null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    alunos.add(new IntegranteAluno(
                            c.getInt(c.getColumnIndex(ALUNO_ID)),
                            c.getString(c.getColumnIndex(ALUNO_NOME)),
                            c.getString(c.getColumnIndex(ALUNO_MATRICULA))));
                } while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            throw e;
        }
        return alunos;
    }

    @Override
    public void remover(int id) {
        if(this.consultar(id) == null) {
            return;
        }
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(TABELA, ALUNO_ID + "=" + id, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("DELETE", "Error while trying to delete item in database");
        } finally {
            db.endTransaction();
        }
    }
}