package br.edu.ufam.icomp.topimoveis;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by felipedmsantos on 26/06/17.
 */

public class UsuarioDAO {
    private SQLiteDatabase bancoDeDados;

    public UsuarioDAO(Context context)
    {
        this.bancoDeDados = (new BancoDeDados(context).getWritableDatabase());
    }

    public Usuario getUsuario(String login, String senha, int tipo)
    {
        Usuario usuario = null;

        String sqlQuery = "SELECT * FROM Usuarios WHERE " + "login='" + login + "'AND senha ='" + senha + "' AND tipo = " + tipo;

        Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

        if(cursor.moveToNext())
        {
            usuario = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
        }
        cursor.close();
        return usuario;
    }

    public boolean addUsuario(Usuario u)
    {
        try
        {
            String sqlCmd = "INSERT INTO Usuarios VALUES ('" + u.getLogin() + "', '" + u.getNome() + "', '" + u.getSenha() + "' , " + u.getTipo() + ")";
            this.bancoDeDados.execSQL(sqlCmd);
            return true;
        }
        catch (SQLException e)
        {
            Log.e("HelloDebug", e.getMessage());
            return false;
        }
    }
}
