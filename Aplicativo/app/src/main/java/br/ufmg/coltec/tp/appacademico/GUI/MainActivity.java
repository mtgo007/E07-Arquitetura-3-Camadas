package br.ufmg.coltec.tp.appacademico.GUI;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import br.ufmg.coltec.tp.appacademico.Business.Models.Aluno;
import br.ufmg.coltec.tp.appacademico.Business.Services.FachadaAluno;
import br.ufmg.coltec.tp.appacademico.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FachadaAluno f = new FachadaAluno(this);
        Aluno a = new Aluno(0, "Dener", "2016952916");

        f.inserir(a);

        /*Integrante b = f.consultar(0);
        if (b != null) {
            Toast.makeText(this, b.getNome(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Não encontrado", Toast.LENGTH_SHORT).show();
        }

        FachadaAluno f = new FachadaAluno(this);
        Professor a = new Professor(0, "Dener", "2016952916");

        f.inserir(a);

        Integrante b = f.consultar(1);
        if (b != null) {
            Toast.makeText(this, b.getNome(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Não encontrado", Toast.LENGTH_SHORT).show();
        }*/

        Spinner spinner_tipo = findViewById(R.id.spinner_tipo);
        String[] tipos = new String[] {"Alunos", "Professores"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tipos);
        spinner_tipo.setAdapter(adapter);
    }
}
