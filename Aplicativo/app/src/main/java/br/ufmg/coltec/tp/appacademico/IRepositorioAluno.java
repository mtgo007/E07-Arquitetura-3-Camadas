package br.ufmg.coltec.tp.appacademico;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public interface IRepositorioAluno {

    public void inserirAluno(Aluno aluno);

    public Aluno consultaAluno(String matricula);
}
