package br.ufmg.coltec.tp.appacademico.Business.Interfaces;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;

interface IFachada {
    void inserir(Integrante i);
    Integrante consultar(int id);
    Integrante consultarTodos();
    void remover(int id);
}
