package br.ufmg.coltec.tp.appacademico.Business.Services;

import android.content.Context;

import br.ufmg.coltec.tp.appacademico.Business.Interfaces.IFachadaProfessor;
import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public class FachadaProfessor implements IFachadaProfessor {

    private ControladorProfessor controladorProfessor;

    public FachadaProfessor(Context context){
        this.controladorProfessor = new ControladorProfessor(context);
    }

    @Override
    public void inserir(Integrante i) {
        this.controladorProfessor.inserirProfessor(i);
    }

    @Override
    public Integrante consultar(int id) {
        return this.controladorProfessor.consultarProfessor(id);
    }

    @Override
    public Integrante consultarTodos() {
        return null;
    }

    @Override
    public void remover(int id) {

    }
}
