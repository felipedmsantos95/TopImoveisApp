package br.edu.ufam.icomp.topimoveis;

import android.app.ListActivity;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class ListaClientes extends ListActivity {

    private UsuarioDAO usuarioDAO;
    private SimpleCursorAdapter dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.usuarioDAO = new UsuarioDAO(this);

        dados = new SimpleCursorAdapter(this,
                R.layout.cliente_linha,
                usuarioDAO.getUsuarios(),//
                new String[] {"login", "nome"},
                new int[] {R.id.linhaEmail,
                        R.id.linhaNome}, 0);

        setListAdapter(dados);
        Log.i("HelloDebug","Atividade ListaClientes iniciada!");
    }

    public void onListItemClick(ListView l, View v,int pos, long id)
    {

    }
}
