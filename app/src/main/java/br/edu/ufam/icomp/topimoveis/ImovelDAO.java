package br.edu.ufam.icomp.topimoveis;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by felipedmsantos on 29/06/17.
 */

public class ImovelDAO {
    private SQLiteDatabase bancoDeDados;

    public ImovelDAO(Context context)
    {
        this.bancoDeDados = (new BancoDeDados(context).getWritableDatabase());
    }

    public Imovel getImovel(String endereco, int quartos, int suites, int vagas, float custo)
    {
        Imovel imovel = null;

        String sqlQuery = "SELECT * FROM Imoveis WHERE " + "endereco='" + endereco + "'AND quartos =" + quartos + " AND suites = " + suites + " AND vagas = " + vagas + " AND custo = " + custo;

        Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

        if(cursor.moveToNext())
        {
            imovel = new Imovel(cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getFloat(5), cursor.getInt(6));
        }
        cursor.close();
        return imovel;
    }

    public boolean addImovel (Imovel i)
    {
        try
        {
            String sqlCmd = "INSERT INTO Imoveis VALUES (NULL, '" + i.getEndereco() + "', " + i.getQuartos() + ", " + i.getSuites() + " , " + i.getVagas() + ", " + i.getCusto() + ", 0)";
            this.bancoDeDados.execSQL(sqlCmd);
            return true;
        }
        catch (SQLException e)
        {
            Log.e("HelloDebug", e.getMessage());
            return false;
        }
    }

    public boolean removeImovel(int id)
    {
        try
        {
            String sqlCmd = "DELETE FROM Imoveis WHERE id = " + id;
            this.bancoDeDados.execSQL(sqlCmd);
            return true;
        }
        catch (SQLException e)
        {
            Log.e("HelloDebug", e.getMessage());
            return false;
        }
    }

    public Cursor getImoveis()
    {
        return this.bancoDeDados.rawQuery("SELECT rowid AS _id, " + "endereco, quartos, suites, vagas, custo, " + "CASE WHEN alugado = 1 THEN 'Alugado' ELSE 'Disponível' END AS alugado " + "FROM Imoveis ORDER BY custo", null);
    }


}
