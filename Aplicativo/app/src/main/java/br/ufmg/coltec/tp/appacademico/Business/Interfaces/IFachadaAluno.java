package br.ufmg.coltec.tp.appacademico.Business.Interfaces;

import java.util.ArrayList;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteAluno;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public interface IFachadaAluno{
    void inserirAluno(IntegranteAluno i);
    void atualizarAluno(IntegranteAluno i);
    IntegranteAluno consultarAluno(int id);
    ArrayList<IntegranteAluno> consultarTodosAlunos();
    void removerAluno(int id);
}
