package br.ufmg.coltec.tp.appacademico.Business.Services;

import android.content.Context;

import java.util.ArrayList;

import br.ufmg.coltec.tp.appacademico.Business.Interfaces.IFachadaProfessor;
import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteProfessor;

/**
 * Created by mtgo0 on 26/09/2018.
 */

public class FachadaProfessor implements IFachadaProfessor {

    private ControladorProfessor controladorProfessor;

    public FachadaProfessor(Context context){
        this.controladorProfessor = new ControladorProfessor(context);
    }

    @Override
    public void inserirProfessor(IntegranteProfessor i) {
        this.controladorProfessor.inserirProfessor(i);
    }

    @Override
    public void atualizarProfessor(IntegranteProfessor i) {
        this.controladorProfessor.atualizarProfessor(i);
    }

    @Override
    public IntegranteProfessor consultarProfessor(int id) {
        return this.controladorProfessor.consultarProfessor(id);
    }

    @Override
    public ArrayList<IntegranteProfessor> consultarTodosProfessores() {
        return this.controladorProfessor.consultarTodosProfessores();
    }

    @Override
    public void removerProfessores(int id) {
        this.controladorProfessor.deletarProfessor(id);
    }
}
