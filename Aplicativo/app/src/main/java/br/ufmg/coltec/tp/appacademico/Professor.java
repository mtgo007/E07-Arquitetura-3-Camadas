package br.ufmg.coltec.tp.appacademico;

/**
 * Created by mtgo0 on 26/09/2018.
 */

class Professor {
    private String matricula;
    private String nome;

    public Professor(String matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
