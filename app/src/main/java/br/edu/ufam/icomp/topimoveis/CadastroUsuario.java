package br.edu.ufam.icomp.topimoveis;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

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
        EditText inputNome = (EditText) findViewById(R.id.editTextNome);
        EditText inputLogin = (EditText) findViewById(R.id.editTextLogin);
        EditText inputSenha = (EditText) findViewById(R.id.editTextSenha);
        EditText inputConfSenha = (EditText) findViewById(R.id.editTextConfSenha);
        RadioButton radioCliente = (RadioButton) findViewById(R.id.radioButtonCliente);
        int tipo = radioCliente.isChecked() ? 1 : 2;

        Usuario usr = new Usuario(inputLogin.getText().toString(), inputNome.getText().toString(), inputSenha.getText().toString(), tipo);


        if (inputSenha.getText().toString().equals(inputConfSenha.getText().toString()))
        {
            UsuarioDAO usuarioDAO = new UsuarioDAO(this);
            Intent intent =  new Intent(this, TelaLogin.class);
            Usuario consulta = usuarioDAO.getUsuario(inputLogin.getText().toString(),inputNome.getText().toString(),tipo);//Verificação se já existe usuário igual
            //Continuars
            if(usuarioDAO.addUsuario(usr))
            {
                Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
            else
            {   Toast.makeText(this, "Usuário já existente!", Toast.LENGTH_SHORT).show();
                Log.i("Hello Debug", "Erro na funcao cadastro");
            }

        }
        else
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Senhas não conferem!").setNeutralButton("Ok", null).show();
        }

    }


}
