package br.edu.ufam.icomp.topimoveis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by felipedmsantos on 26/06/17.
 */

public class BancoDeDados extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TopImoveis.db";
    private static final String SQL_CREATE_TABLE_USR = "CREATE TABLE Usuarios(login TEXT PRIMARY KEY, nome TEXT, senha TEXT, tipo INT)";
    private static final String SQL_CREATE_TABLE_IMV = "CREATE TABLE Imoveis(id INTEGER PRIMARY KEY AUTOINCREMENT, endereco TEXT, quartos INT, suites INT, vagas INT, custo FLOAT, alugado INT)";
    private static final String SQL_DELETE_TABLE_USR = "DROP TABLE IF EXISTS Usuarios";
    private static final String SQL_DELETE_TABLE_IMV = "DROP TABLE IF EXISTS Imoveis";

    public BancoDeDados(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_TABLE_USR);
        db.execSQL(SQL_CREATE_TABLE_IMV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(SQL_DELETE_TABLE_USR);
        db.execSQL(SQL_DELETE_TABLE_IMV);
        onCreate(db);
    }
}
