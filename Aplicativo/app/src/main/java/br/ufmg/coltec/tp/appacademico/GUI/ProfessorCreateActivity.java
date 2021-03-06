package br.ufmg.coltec.tp.appacademico.GUI;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteAluno;
import br.ufmg.coltec.tp.appacademico.Business.Models.IntegranteProfessor;
import br.ufmg.coltec.tp.appacademico.Business.Services.FachadaAluno;
import br.ufmg.coltec.tp.appacademico.Business.Services.FachadaProfessor;
import br.ufmg.coltec.tp.appacademico.R;

public class ProfessorCreateActivity extends Activity {

    private Button btn_save;
    private EditText in_nome;
    private EditText in_matricula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_create);

        btn_save = findViewById(R.id.btn_save);
        in_nome = findViewById(R.id.in_nome);
        in_matricula = findViewById(R.id.in_matricula);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FachadaProfessor fachadaProfessor = new FachadaProfessor(ProfessorCreateActivity.this);
                fachadaProfessor.inserirProfessor(new IntegranteProfessor(0, in_nome.getText().toString(), in_matricula.getText().toString()));
                finish();
            }
        });
    }
}
