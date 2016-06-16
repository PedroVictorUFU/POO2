package com.pedro.aplicacaopoo2.model;

import java.util.ArrayList;

/**
 * Created by pedro on 16/06/16.
 */
public class Table {

    private String numero;
    private String lugares;
    private ArrayList<Pedido> pedidos;


    public Table(String numero,String lugares){
        this.numero = numero;
        this.lugares = lugares;
    }

    public String getNumero() {
        return numero;
    }
    public String getLugares() {
        return lugares;
    }
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

}
