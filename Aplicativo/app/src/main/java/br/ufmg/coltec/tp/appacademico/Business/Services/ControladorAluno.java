package br.ufmg.coltec.tp.appacademico.Business.Services;

import android.content.Context;

import java.util.ArrayList;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteAluno;
import br.ufmg.coltec.tp.appacademico.Data.Repository.RepositorioAluno;

class ControladorAluno {

    private RepositorioAluno repositorioAluno;

    public ControladorAluno(Context context){
        this.repositorioAluno = new RepositorioAluno(context);
    }

    public void inserirAluno(IntegranteAluno i) {
        this.repositorioAluno.inserir(i);
    }

    public void atualizarAluno(IntegranteAluno i) {
        this.repositorioAluno.update(i);
    }

    public IntegranteAluno consultarAluno(int id) {
        return this.repositorioAluno.consultar(id);
    }

    public ArrayList<IntegranteAluno> consultarTodosAlunos() {
        return this.repositorioAluno.consultarTodos();
    }

    public void deletarAluno(int id) {
        this.repositorioAluno.remover(id);
    }
}
