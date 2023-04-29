package br.edu.up.persistencia;
import java.util.ArrayList;
import br.edu.up.entidades.Cliente;

public class PersistenciaCliente {
	
	private static ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	public static void adicionarCliente (Cliente cliente) {
		listaClientes.add(cliente);
	}
	
	public static boolean verificarClienteCadastrado (Cliente cliente) {
		for(Cliente item: listaClientes) {
			if(item.getCpf().equals(cliente.getCpf())) {
				return true;
			}
		}
		return false;
	}
	
	public static Cliente retornarCliente (Cliente cliente) {
		for(Cliente item: listaClientes) {
			if(item.getCpf().equals(cliente.getCpf())) {
				return item;
			}
		}
		return null;
	}
	
}