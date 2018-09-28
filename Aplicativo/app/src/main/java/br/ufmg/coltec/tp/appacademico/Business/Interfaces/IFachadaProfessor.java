package br.ufmg.coltec.tp.appacademico.Business.Interfaces;

import java.util.ArrayList;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteProfessor;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public interface IFachadaProfessor {
    void inserirProfessor(IntegranteProfessor i);
    void atualizarProfessor(IntegranteProfessor i);
    IntegranteProfessor consultarProfessor(int id);
    ArrayList<IntegranteProfessor> consultarTodosProfessores();
    void removerProfessores(int id);
}
