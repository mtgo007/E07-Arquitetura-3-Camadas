package br.ufmg.coltec.tp.appacademico.Data.Interfaces;

import java.util.ArrayList;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteProfessor;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public interface IRepositorioProfessor {
    void inserir(IntegranteProfessor i);
    void update(IntegranteProfessor i);
    IntegranteProfessor consultar(int id);
    ArrayList<IntegranteProfessor> consultarTodos();
    void remover(int id);
}
