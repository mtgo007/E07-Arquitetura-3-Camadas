package br.ufmg.coltec.tp.appacademico.GUI;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.ufmg.coltec.tp.appacademico.Business.Models.Integrante;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteProfessor;
import br.ufmg.coltec.tp.appacademico.Business.Services.FachadaAluno;
import br.ufmg.coltec.tp.appacademico.Business.Services.FachadaProfessor;
import br.ufmg.coltec.tp.appacademico.R;

public class ProfessorActivity extends ListActivity {

    private ArrayList<IntegranteProfessor> professores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FachadaProfessor fachadaProfessor= new FachadaProfessor(this);
        professores = fachadaProfessor.consultarTodosProfessores();

        ArrayList<String> alunosString = new ArrayList<>();
        for (Integrante i: professores) {
            alunosString.add(i.getNome() + "\n" + i.getMatricula());
        }

        ArrayAdapter<String> listDataAdapter = new ArrayAdapter<>(
                this, R.layout.activity_professor, R.id.list_professores, alunosString);

        this.setListAdapter(listDataAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}
