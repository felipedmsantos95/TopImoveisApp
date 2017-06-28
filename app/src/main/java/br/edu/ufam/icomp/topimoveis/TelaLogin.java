package br.edu.ufam.icomp.topimoveis;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        Log.i("HelloDebug", "Atividade principal iniciada!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sobre:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("TopImóveis App v1.0\n Desenvolvido por Felipe Santos").setNeutralButton("Ok", null).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void irTelaCadastroCliente(View view)
    {
        Intent intent =  new Intent(this, CadastroUsuario.class);
        startActivity(intent);
    }

    public void entrarClicado (View view)
    {
        Intent intentCli = new Intent(this, TelaCliente.class);
        Intent intentAdm = new Intent(this, TelaAdm.class);

        EditText inputLogin = (EditText) findViewById(R.id.editTextLogin);
        EditText inputSenha = (EditText) findViewById(R.id.editTextSenha);
        RadioButton radioCliente = (RadioButton) findViewById(R.id.radioButtonCliente);
        int tipo = radioCliente.isChecked() ? 1 : 2;

        UsuarioDAO usr = new UsuarioDAO(this);
        Usuario usuario = usr.getUsuario(inputLogin.getText().toString(), inputSenha.getText().toString(), tipo);

        if(usuario != null && tipo == 1)
        {
            intentCli.putExtra("usuario", usuario);
            startActivity(intentCli);
        }
        else if(usuario != null && tipo == 2)
        {
            intentCli.putExtra("administrador", usuario);
            startActivity(intentAdm);
        }
        else
        {
            Toast.makeText(this, "Usuário e/ou Senha inválidos!", Toast.LENGTH_SHORT).show();
        }


    }


}
