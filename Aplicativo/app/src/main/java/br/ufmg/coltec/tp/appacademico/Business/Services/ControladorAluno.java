package br.ufmg.coltec.tp.appacademico.Business.Services;

import android.content.Context;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Data.Repository.RepositorioAluno;

class ControladorAluno {

    private RepositorioAluno repositorioAluno;

    public ControladorAluno(Context context){
        this.repositorioAluno = new RepositorioAluno(context);
    }

    public void inserirAluno(Integrante i) {
        this.repositorioAluno.inserir(i);
    }

    public Integrante consultarAluno(int id) {
        return this.repositorioAluno.consultar(id);
    }
}
