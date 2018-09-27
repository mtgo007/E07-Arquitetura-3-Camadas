package br.ufmg.coltec.tp.appacademico.Business.Models;

public class Integrante {
    private int Id;
    private String Nome;
    private String Matricula;

    public Integrante(int id, String nome, String matricula) {
        Id = id;
        Nome = nome;
        Matricula = matricula;
    }

    public int getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setMatrícula(String matricula) {
        Matricula = matricula;
    }
}
