package br.ufms.gerenciadordedespesas;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Gabriel on 27/05/2015.
 */
@Table(name = "Financas")
public class Financas{

    @Column(name = "categoria")
    String categoria;

    @Column(name = "descricao")
    String descricao;

    @Column(name = "evento_previsto")
    boolean eventoPrevisto;

    @Column(name = "data")
    String data;

    @Column(name = "modo_pagamento")
    String modoPagamento;

    @Column(name = "valor")
    double valor;


    public Financas(String categoria, String descricao, boolean eventoPrevisto, String data, String modoPagamento, double valor) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.eventoPrevisto = eventoPrevisto;
        this.data = data;
        this.modoPagamento = modoPagamento;
        this.valor = valor;

        setValor(valor);

    }



    /***********************************/

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEventoPrevisto() {
        return eventoPrevisto;
    }

    public void setEventoPrevisto(boolean eventoPrevisto) {
        this.eventoPrevisto = eventoPrevisto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getModoPagamento() {
        return modoPagamento;
    }

    public void setModoPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
