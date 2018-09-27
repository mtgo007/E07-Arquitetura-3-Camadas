package br.ufmg.coltec.tp.appacademico;

import android.content.Context;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public class FachadaAluno implements IFachadaAluno {

    private ControladorAluno controladorAluno;

    public FachadaAluno(Context c){
        this.controladorAluno = new ControladorAluno(c);
    }

    @Override
    public void inserirAluno(Aluno aluno) {
        this.controladorAluno.inserirAluno(aluno);
    }

    @Override
    public Aluno consultaAluno(String matricula) {
        return this.controladorAluno.consultaAluno(matricula);
    }
}
