package br.ufmg.coltec.tp.appacademico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mtgo0 on 26/09/2018.
 */

class RepositorioAluno extends SQLiteOpenHelper implements IRepositorioAluno {

    // nome do banco
    private static String DB_NAME = "Alunos";

    // versão do banco
    private static final int DB_VERSION = 1;

    // script para criação do banco
    private static final String SCRIPT_CREATE = "CREATE TABLE IF NOT EXISTS Professores( matricula TEXT PRIMARY KEY NOT NULL, nome TEXT NOT NULL);";

    public RepositorioAluno(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    public Aluno consultaAluno(String matricula) {
        SQLiteDatabase db = getReadableDatabase();

        try {
            // faz a leitura dos dados do banco
            Cursor c = db.query("Alunos", null, null, null, null, null, null);

            if(c.moveToFirst()) {
                do {
                    String matriculaAluno = c.getString(c.getColumnIndex("matricula"));
                    if (matriculaAluno.equals(matricula)){
                        String nome = c.getString(c.getColumnIndex("nome"));
                        return new Aluno(matriculaAluno, nome);
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

    public void inserirAluno(Aluno aluno) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("nome", aluno.getNome());
            cv.put("matricula", aluno.getMatricula());
            db.insert("Alunos", null, cv);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SCRIPT_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
