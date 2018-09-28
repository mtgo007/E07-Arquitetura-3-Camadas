package br.ufmg.coltec.tp.appacademico.Data.Interfaces;

import java.util.ArrayList;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteAluno;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public interface IRepositorioAluno {
    void inserir(IntegranteAluno i);
    void update(IntegranteAluno i);
    IntegranteAluno consultar(int id);
    ArrayList<IntegranteAluno> consultarTodos();
    void remover(int id);
}
