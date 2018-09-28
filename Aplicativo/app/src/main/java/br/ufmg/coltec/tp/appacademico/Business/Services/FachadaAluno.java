package br.ufmg.coltec.tp.appacademico.Business.Services;

import android.content.Context;

import java.util.ArrayList;

import br.ufmg.coltec.tp.appacademico.Business.Interfaces.IFachadaAluno;
import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteAluno;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public class FachadaAluno implements IFachadaAluno {

    private ControladorAluno controladorAluno;

    public FachadaAluno(Context context){
        this.controladorAluno = new ControladorAluno(context);
    }

    @Override
    public void inserirAluno(IntegranteAluno i) {
        this.controladorAluno.inserirAluno(i);
    }

    @Override
    public void atualizarAluno(IntegranteAluno i) {
        this.controladorAluno.atualizarAluno(i);
    }

    @Override
    public IntegranteAluno consultarAluno(int id) {
        return this.controladorAluno.consultarAluno(id);
    }

    @Override
    public ArrayList<IntegranteAluno> consultarTodosAlunos() {
        return this.controladorAluno.consultarTodosAlunos();
    }

    @Override
    public void removerAluno(int id) {
        this.controladorAluno.deletarAluno(id);
    }
}
