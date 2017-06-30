package br.edu.ufam.icomp.topimoveis;

import android.app.ListActivity;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class TelaCliente extends ListActivity {

    private ImovelDAO imovelDAO;
    private SimpleCursorAdapter dados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.imovelDAO = new ImovelDAO(this);

        dados = new SimpleCursorAdapter(this,
                R.layout.imovel_linha,
                imovelDAO.getImoveis(),
                new String[] {"endereco", "quartos", "suites", "vagas", "custo"},
                new int[] {R.id.linhaEndereco,
                        R.id.linhaQuartos,
                        R.id.linhaSuites,
                        R.id.linhaVagas,
                        R.id.linhaCusto}, 0);

        setListAdapter(dados);
        Log.i("HelloDebug","Atividade TelaCliente iniciada!");
    }

    public void onListItemClick(ListView l, View v, int pos, long id)
    {

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("HelloDebug", "Método onStart TelaCliente executado...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("HelloDebug", "Método onResume TelaCliente executado...");
    }
}
