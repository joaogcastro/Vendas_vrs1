package br.edu.up.entidades;

public class Produto {
	private String nome;
	private double preco;
	private double markup;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getMarkup() {
		return markup;
	}
	public void setMarkup(double markup) {
		this.markup = markup/100;
	}
}