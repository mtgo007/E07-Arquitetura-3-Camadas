package br.ufmg.coltec.tp.appacademico;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public interface IFachadaProfessor {

    public void inserirAluno(Professor professor);

    public Professor consultaAluno(String matricula);
}
