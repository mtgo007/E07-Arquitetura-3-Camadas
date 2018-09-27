package br.ufmg.coltec.tp.appacademico;

import android.content.Context;

/**
 * Created by mtgo0 on 26/09/2018.
 */

class ControladorAluno {

    private RepositorioAluno repositorioAluno;

    public ControladorAluno(Context c){
        this.repositorioAluno = new RepositorioAluno(c);
    }

    public void inserirAluno(Aluno aluno) {
        this.repositorioAluno.inserirAluno(aluno);
    }

    public Aluno consultaAluno(String matricula) {
        return this.repositorioAluno.consultaAluno(matricula);
    }
}
