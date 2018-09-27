package br.ufmg.coltec.tp.appacademico.Business.Services;

import android.content.Context;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Data.Repository.RepositorioProfessor;

/**
 * Created by mtgo0 on 26/09/2018.
 */

class ControladorProfessor {

    private RepositorioProfessor repositorioProfessor;

    public ControladorProfessor(Context context){
        this.repositorioProfessor = new RepositorioProfessor(context);
    }

    public void inserirProfessor(Integrante i) {
        this.repositorioProfessor.inserir(i);
    }

    public Integrante consultarProfessor(int id) {
        return this.repositorioProfessor.consultar(id);
    }
}
