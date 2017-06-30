package br.edu.ufam.icomp.topimoveis;

import java.io.Serializable;

/**
 * Created by felipedmsantos on 29/06/17.
 */

public class Imovel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String endereco;
    private int quartos, suites, vagas, alugado;
    private float custo;


    public Imovel(String endereco, int quartos, int suites, int vagas,  float custo)
    {
        setEndereco(endereco);
        setQuartos(quartos);
        setSuites(suites);
        setVagas(vagas);
        setAlugado(0);
        setCusto(custo);
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setQuartos(int quartos)
    {
        this.quartos = quartos;
    }

    public int getQuartos()
    {
        return quartos;
    }

    public void setSuites(int suites)
    {
        this.suites = suites;
    }

    public int getSuites()
    {
        return suites;
    }

    public void setVagas(int vagas)
    {
        this.vagas = vagas;
    }

    public int getVagas()
    {
        return vagas;
    }

    public void setAlugado(int alugado)
    {
        if(alugado >= 1)this.alugado = 1;
        else this.alugado = 0;
    }

    public int getAlugado()
    {
        return alugado;
    }

    public void setCusto(float custo)
    {
        this.custo = custo;
    }

    public float getCusto()
    {
        return custo;
    }

    public String getAlugadoString(int alugado)
    {
        if (alugado == 1) return "Alugado";
        else return "Disponível";
    }

}
