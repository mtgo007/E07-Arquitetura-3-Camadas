package br.ufmg.coltec.tp.appacademico.GUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import br.ufmg.coltec.tp.appacademico.R;

public class MainActivity extends Activity {

    private Button btn_alunos;
    private Button btn_professor;

    private Button btn_new_aluno;
    private Button btn_new_professor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_alunos = findViewById(R.id.btn_aluno);
        btn_professor = findViewById(R.id.btn_professor);
        btn_new_aluno = findViewById(R.id.btn_new_aluno);
        btn_new_professor = findViewById(R.id.btn_new_professor);

        btn_alunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alunos = new Intent(MainActivity.this, AlunoActivity.class);
                startActivity(alunos);
            }
        });

        btn_professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent professores = new Intent(MainActivity.this, ProfessorActivity.class);
                startActivity(professores);
            }
        });

        btn_new_aluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createAluno = new Intent(MainActivity.this, AlunoCreateActivity.class);
                startActivity(createAluno);
            }
        });

        btn_new_professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createProfessor = new Intent(MainActivity.this, ProfessorCreateActivity.class);
                startActivity(createProfessor);
            }
        });
    }
}
