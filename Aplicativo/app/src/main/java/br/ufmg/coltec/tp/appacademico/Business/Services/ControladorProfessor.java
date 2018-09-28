package br.ufmg.coltec.tp.appacademico.Business.Services;

import android.content.Context;

import java.util.ArrayList;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteProfessor;
import br.ufmg.coltec.tp.appacademico.Data.Repository.RepositorioProfessor;

/**
 * Created by mtgo0 on 26/09/2018.
 */

class ControladorProfessor {

    private RepositorioProfessor repositorioProfessor;

    public ControladorProfessor(Context context){
        this.repositorioProfessor = new RepositorioProfessor(context);
    }

    public void inserirProfessor(IntegranteProfessor i) {
        this.repositorioProfessor.inserir(i);
    }

    public void atualizarProfessor(IntegranteProfessor i) {
        this.repositorioProfessor.update(i);
    }

    public IntegranteProfessor consultarProfessor(int id) {
        return this.repositorioProfessor.consultar(id);
    }

    public ArrayList<IntegranteProfessor> consultarTodosProfessores() {
        return this.repositorioProfessor.consultarTodos();
    }

    public void deletarProfessor(int id) {
        this.repositorioProfessor.remover(id);
    }
}
