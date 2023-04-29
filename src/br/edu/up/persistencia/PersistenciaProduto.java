package br.edu.up.persistencia;
import java.util.ArrayList;
import br.edu.up.entidades.Produto;

public class PersistenciaProduto {
	
	private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	public static void adicionarProduto(Produto produto) {
		listaProdutos.add(produto);
	}
	
	public static boolean verificarProdutoCadastrado (Produto produto) {
		for(Produto item: listaProdutos) {
			if(item.getNome().equals(produto.getNome())==true) {
				return true;
			}
		}
		return false;
	}
	
	public static Produto retornarProduto (Produto produto) {
		for(Produto item: listaProdutos) {
			if(item.getNome().equals(produto.getNome())==true) {
				return item;
			}
		}
		return null;
	}
}