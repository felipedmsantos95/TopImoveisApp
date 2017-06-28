package br.edu.ufam.icomp.topimoveis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TelaAdm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_adm);
        Log.i("HelloDebug","Atividade TelaAdm iniciada!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("HelloDebug", "Método onStart executado...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("HelloDebug", "Método onResume executado...");
    }



}
