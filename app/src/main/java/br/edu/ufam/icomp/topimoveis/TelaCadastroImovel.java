package br.edu.ufam.icomp.topimoveis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class TelaCadastroImovel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_imovel);
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

    public void cadastarImovel(View view)
    {
        Intent intent = new Intent(this, TelaAdm.class);

        EditText inputEndereco = (EditText) findViewById(R.id.editTextEndereco);
        EditText inputQuartos = (EditText) findViewById(R.id.editTextQuartos);
        EditText inputSuites = (EditText) findViewById(R.id.editTextSuites);
        EditText inputVagas = (EditText) findViewById(R.id.editTextGaragem);
        EditText inputCusto = (EditText) findViewById(R.id.editTextCusto);

        ImovelDAO imovelDAO =new ImovelDAO(this);
        Imovel imv = imovelDAO.addImovel(inputEndereco.getText().toString())//Completar Construtor



    }
}
