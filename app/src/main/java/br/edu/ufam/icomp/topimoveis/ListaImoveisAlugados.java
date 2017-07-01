package br.edu.ufam.icomp.topimoveis;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaImoveisAlugados extends ListActivity {

    private ImovelDAO imovelDAO;
    private SimpleCursorAdapter dados;
    private AlertDialog alerta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.imovelDAO = new ImovelDAO(this);
        //setContentView(R.layout.activity_tela_cliente);

        dados = new SimpleCursorAdapter(this,
                R.layout.imovel_alugado_linha,
                imovelDAO.getImoveisA(),
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
        TextView textEndereco = (TextView) v.findViewById(R.id.linhaEndereco);
        TextView textQuartos = (TextView) v.findViewById(R.id.linhaQuartos);
        TextView textSuites = (TextView) v.findViewById(R.id.linhaSuites);
        TextView textVagas = (TextView) v.findViewById(R.id.linhaVagas);
        TextView textCusto = (TextView) v.findViewById(R.id.linhaCusto);

        final ImovelDAO imovelDAO = new ImovelDAO(this);

        final int idImovel = imovelDAO.getImovelID(textEndereco.getText().toString(), Integer.parseInt(textQuartos.getText().toString().trim()), Integer.parseInt(textSuites.getText().toString().trim()), Integer.parseInt(textVagas.getText().toString().trim()), Float.parseFloat(textCusto.getText().toString().trim()));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Deseja disponibilizar este imóvel para os clientes?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface arg0, int arg1)
            {
                imovelDAO.desalugaImovel(idImovel);
                Toast.makeText(ListaImoveisAlugados.this, "O imóvel agora é exibido para os clientes!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListaImoveisAlugados.this, ListaImoveisAlugados.class);//Atualizar Tela
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface arg0, int arg1)
            {

            }
        });

        alerta = builder.create();
        alerta.show();



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
