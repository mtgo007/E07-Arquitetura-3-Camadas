package br.ufmg.coltec.tp.appacademico.GUI;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteAluno;
import br.ufmg.coltec.tp.appacademico.Business.Services.FachadaAluno;
import br.ufmg.coltec.tp.appacademico.R;

public class AlunoActivity extends ListActivity {

    private ArrayList<IntegranteAluno> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FachadaAluno fachadaAluno = new FachadaAluno(this);
        alunos = fachadaAluno.consultarTodosAlunos();

        ArrayList<String> alunosString = new ArrayList<>();
        for (Integrante i: alunos) {
            alunosString.add(i.getNome() + "\n" + i.getMatricula());
        }

        ArrayAdapter<String> listDataAdapter = new ArrayAdapter<>(
                this, R.layout.activity_aluno, R.id.list_aluno, alunosString);

        this.setListAdapter(listDataAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}
