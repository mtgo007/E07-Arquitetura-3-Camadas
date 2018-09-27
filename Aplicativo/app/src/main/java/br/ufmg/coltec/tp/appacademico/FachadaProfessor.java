package br.ufmg.coltec.tp.appacademico;

import android.content.Context;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public class FachadaProfessor implements IFachadaProfessor {

    private ControladorProfessor controladorProfessor;

    public FachadaProfessor(Context c){
        this.controladorProfessor = new ControladorProfessor(c);
    }
    @Override
    public void inserirAluno(Professor professor) {
        this.controladorProfessor.insereProfessor(professor);
    }

    @Override
    public Professor consultaAluno(String matricula) {
        return this.controladorProfessor.consultaProfessor(matricula);
    }
}
