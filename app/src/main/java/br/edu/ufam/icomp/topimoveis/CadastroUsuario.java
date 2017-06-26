package br.edu.ufam.icomp.topimoveis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class CadastroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        Log.i("HelloDebug", "Atividade principal iniciada!");
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

    public void cadastraCliente(View view)//Compara as duas senhas para escolher se cadastra ou impede
    {

    }


}
