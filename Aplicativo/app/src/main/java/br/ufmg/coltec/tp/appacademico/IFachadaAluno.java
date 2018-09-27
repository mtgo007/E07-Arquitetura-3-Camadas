package br.ufmg.coltec.tp.appacademico;

import java.util.List;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public interface IFachadaAluno {

    public void inserirAluno(Aluno aluno);

    public Aluno consultaAluno(String matricula);

}
