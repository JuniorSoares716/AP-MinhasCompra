package com.example.comprascerta;

import java.io.Serializable;

public class Produto implements Serializable {

    private Integer Id;
    private String NomeProduto;
    private float precoProduto;
    private  int QtdProduto;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQtdProduto() {
        return QtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        QtdProduto = qtdProduto;
    }

    @Override
    public String toString(){
        return NomeProduto;
    }
}
