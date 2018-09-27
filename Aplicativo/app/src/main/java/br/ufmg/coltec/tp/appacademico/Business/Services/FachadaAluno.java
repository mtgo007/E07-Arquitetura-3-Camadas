package br.ufmg.coltec.tp.appacademico.Business.Services;

import android.content.Context;

import br.ufmg.coltec.tp.appacademico.Business.Interfaces.IFachadaAluno;
import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public class FachadaAluno implements IFachadaAluno {

    private ControladorAluno controladorAluno;

    public FachadaAluno(Context context){
        this.controladorAluno = new ControladorAluno(context);
    }

    @Override
    public void inserir(Integrante i) {
        this.controladorAluno.inserirAluno(i);
    }

    @Override
    public Integrante consultar(int id) {
        return this.controladorAluno.consultarAluno(id);
    }

    @Override
    public Integrante consultarTodos() {
        return null;
    }

    @Override
    public void remover(int id) {

    }
}
