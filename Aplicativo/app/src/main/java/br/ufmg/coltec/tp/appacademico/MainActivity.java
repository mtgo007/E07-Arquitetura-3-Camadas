package br.ufmg.coltec.tp.appacademico;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FachadaAluno f = new FachadaAluno(this);
        Aluno a = new Aluno("2016952826", "Mathias");

        f.inserirAluno(a);

        Aluno b = f.consultaAluno("2016952827");

        Toast.makeText(this, b.getNome(), Toast.LENGTH_SHORT).show();

    }
}
