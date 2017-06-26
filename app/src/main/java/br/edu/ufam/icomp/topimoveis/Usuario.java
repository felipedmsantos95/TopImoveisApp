package br.edu.ufam.icomp.topimoveis;

import java.io.Serializable;

/**
 * Created by felipedmsantos on 26/06/17.
 */

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome, login, senha;
    private int tipo;

    public Usuario(String login, String nome, String senha, int tipo)
    {
        setLogin(login);
        setNome(nome);
        setSenha(senha);
        setTipo(tipo);
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getLogin()
    {
        return login;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }

    public int getTipo()
    {
        return tipo;
    }

    public String getTipoString()
    {
        if (this.tipo == 1) return "Cliente";
        else return "Administrador";
    }

}
