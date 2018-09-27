package br.ufmg.coltec.tp.appacademico;

import android.content.Context;

/**
 * Created by mtgo0 on 26/09/2018.
 */

class ControladorProfessor {

    private RepositorioProfessor repositorioProfessor;

    public ControladorProfessor(Context c){
        this.repositorioProfessor = new RepositorioProfessor(c);
    }

    public void insereProfessor(Professor p){
        this.repositorioProfessor.insereProfessor(p);
    }

    public Professor consultaProfessor(String matricula){
        return this.repositorioProfessor.consultaProfessor(matricula);
    }
}
