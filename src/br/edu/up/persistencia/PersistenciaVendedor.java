package br.edu.up.persistencia;
import java.util.ArrayList;
import br.edu.up.entidades.Vendedor;

public class PersistenciaVendedor {
	
	private static ArrayList<Vendedor> listaVendedores = new ArrayList<>();
	
	public static void adicionarVendedor (Vendedor vendedor) {
		listaVendedores.add(vendedor);
	}
	
	public static boolean verificarVendedorCadastrado (Vendedor vendedor) {
		for(Vendedor item: listaVendedores) {
			if(item.getCpf().equals(vendedor.getCpf())) {
				return true;
			}
		}
		return false;
	}
	
	public static Vendedor retornarVendedor (Vendedor vendedor) {
		for(Vendedor item: listaVendedores) {
			if(item.getCpf().equals(vendedor.getCpf())) {
				return item;
			}
		}
		return null;
	}
}