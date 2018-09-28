package br.ufmg.coltec.tp.appacademico.Data.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteAluno;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteProfessor;
import br.ufmg.coltec.tp.appacademico.Data.Interfaces.IRepositorioProfessor;

public class RepositorioProfessor extends Repositorio implements IRepositorioProfessor {

    public static final String TABELA = "professores";
    public static final String PROFESSOR_ID = "id";
    public static final String PROFESSOR_NOME = "nome";
    public static final String PROFESSOR_MATRICULA = "matricula";

    public RepositorioProfessor(Context context) {
        super(context);
    }

    @Override
    public void inserir(IntegranteProfessor i) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
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
    public void update(IntegranteProfessor i) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(PROFESSOR_NOME, i.getNome());
            values.put(PROFESSOR_MATRICULA, i.getMatricula());

            db.update(TABELA, values, PROFESSOR_ID + "=" + i.getId(), null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("UPDATE", "Error while trying to update database");
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public IntegranteProfessor consultar(int id) {
        IntegranteProfessor professor = null;

        try (SQLiteDatabase db = getReadableDatabase()) {
            Cursor c = db.query(TABELA, null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    int idProfessor = c.getInt(c.getColumnIndex(PROFESSOR_ID));
                    if (idProfessor == id) {
                        String nomeProfessor = c.getString(c.getColumnIndex(PROFESSOR_NOME));
                        String matriculaProfessor = c.getString(c.getColumnIndex(PROFESSOR_MATRICULA));
                        professor = new IntegranteProfessor(idProfessor, nomeProfessor, matriculaProfessor);
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
    public ArrayList<IntegranteProfessor> consultarTodos() {
        ArrayList<IntegranteProfessor> professores = new ArrayList<>();
        try (SQLiteDatabase db = getReadableDatabase()) {
            Cursor c = db.query(TABELA, null, null, null, null, null, null);
            if (c.moveToFirst()) {
                do {
                    professores.add(new IntegranteProfessor(
                            c.getInt(c.getColumnIndex(PROFESSOR_ID)),
                            c.getString(c.getColumnIndex(PROFESSOR_NOME)),
                            c.getString(c.getColumnIndex(PROFESSOR_MATRICULA))
                    ));
                } while (c.moveToNext());
            }
            c.close();
        } catch (Exception e) {
            throw e;
        }
        return professores;
    }

    @Override
    public void remover(int id) {
        if(this.consultar(id) == null) {
           return;
        }
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(TABELA, PROFESSOR_ID + "=" + id, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("DELETE", "Error while trying to delete item in database");
        } finally {
            db.endTransaction();
        }
    }
}
