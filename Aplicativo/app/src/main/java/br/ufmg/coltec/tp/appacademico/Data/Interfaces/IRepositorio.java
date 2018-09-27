package br.ufmg.coltec.tp.appacademico.Data.Interfaces;

import java.util.List;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;

interface IRepositorio {
    void inserir(Integrante i);
    Integrante consultar(int id);
    List<Integrante> consultarTodos();
    void remover(int id);
}
