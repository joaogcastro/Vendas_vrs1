package br.edu.up.entidades;

public class Item {
	private String nomeProduto;
	private int quantidade;
	private double unitario;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(Produto produto) {
		this.nomeProduto = produto.getNome();
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getUnitario() {
		return unitario;
	}
	public void setUnitario(double unitario) {
		this.unitario = unitario;
	}
}