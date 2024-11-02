package br.com.control.model;

import java.util.Date;

public abstract class  Produtos {

    private String nome;
    private Integer quantidadeTotal;
    private Date quantidadeSaida;
    private Integer quantidadeEntrada;
    private Date dataEntrada;
    private Date dataSaida;


    public Produtos(String nome) {
        this.nome = nome;
        this.quantidadeTotal = 0;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeEntrada() {
        return quantidadeEntrada;
    }

    public void setQuantidadeEntrada(Integer quantidadeEntrada) {
        this.quantidadeEntrada = quantidadeEntrada;
    }

    public Date getQuantidadeSaida() {
        return quantidadeSaida;
    }

    public void setQuantidadeSaida(Date quantidadeSaida) {
        this.quantidadeSaida = quantidadeSaida;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public void entradaMaterial(){
        if (quantidadeEntrada != null && quantidadeEntrada > 0){
            quantidadeTotal += quantidadeEntrada;
        }else{
            System.out.println("Quantidade inválida");
        }
    }
    public void saidaMaterial(Integer quantidadeSaida){
        if(quantidadeSaida != null && quantidadeSaida > 0 && quantidadeSaida<=quantidadeTotal){
            quantidadeTotal -= quantidadeSaida;
        }else{
            System.out.println("Erro ao dar baixa");
        }

    }
}
