package br.ufmg.coltec.tp.appacademico;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public interface IRepositorioProfessor {

    public void insereProfessor(Professor p);

    public Professor consultaProfessor(String matricula);
}
