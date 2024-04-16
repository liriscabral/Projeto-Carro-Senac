package com.carro.model;

import java.sql.Timestamp;

public class Carro {
    private Long id;
    private String nome;
    private String fabricante;
    private String placa;
    private Timestamp dataEntrada; 

    public Carro(String nome, String fabricante, String placa, Timestamp dataEntrada, Long id) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.placa = placa;
        this.dataEntrada = dataEntrada;
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Timestamp getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(Timestamp dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}

