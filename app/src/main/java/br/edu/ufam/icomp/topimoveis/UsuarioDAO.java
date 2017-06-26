package br.edu.ufam.icomp.topimoveis;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by felipedmsantos on 26/06/17.
 */

public class UsuarioDAO {
    private SQLiteDatabase bancoDeDados;

    public UsuarioDAO(Context context)
    {
        this.bancoDeDados = (new BancoDeDados(context).getWritableDatabase());
    }

    public Usuario getUsuario(String login, String senha)
    {
        Usuario usuario = null;

        String sqlQuery = "SELECT * FROM Usuarios WHERE " + "login='" + login + "'AND senha ='" + senha + "'";

        Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

        if(cursor.moveToNext())
        {
            usuario = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
        }
        cursor.close();
        return usuario;
    }

    
}
