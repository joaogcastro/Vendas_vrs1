package br.edu.up.negocio;

import br.edu.up.entidades.Produto;

public class NegocioProduto {
	
	public static double calcularPrecoVenda (Produto produto) {
		return produto.getPreco() + (produto.getMarkup()*produto.getPreco());
	}

}
