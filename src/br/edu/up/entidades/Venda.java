package br.edu.up.entidades;
import java.util.ArrayList;


public class Venda {
	private int id;
	private String nomeCliente;
	private String nomeVendedor;
	private String data;
	private ArrayList<Item> itens = new ArrayList<Item>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(Cliente cliente) {
		this.nomeCliente = cliente.getNome();
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(Vendedor vendedor) {
		this.nomeVendedor = vendedor.getNome();
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
}