package br.edu.up.persistencia;
import java.util.ArrayList;

import br.edu.up.entidades.Item;
import br.edu.up.entidades.Venda;

public class PersistenciaVenda {
	
	private static ArrayList<Venda> listaVendas = new ArrayList<Venda>();
	
	public static void adicionarVenda (Venda venda) {
		listaVendas.add(venda);
	}
	
	public static boolean verificarVendaCadastrada (Venda venda) {
		for(Venda item: listaVendas) {
			if(item.getId()==venda.getId()) {
				return true;
			}
		}
		return false;
	}
	
	public static Venda retornarVenda (Venda venda) {
		for(Venda item: listaVendas) {
			if(item.getId()==venda.getId()) {
				return item;
			}
		}
		return null;
	}
	
	public static String adicionarItem(Venda venda, Item item) {
        // Verificar se o item já foi adicionado
        for (Item i : venda.getItens()) {
            if (i.getNomeProduto().equals(item.getNomeProduto())) {
                return "Erro: O item já foi adicionado!"; // Item já foi adicionado, não permitir a adição novamente
            }
        }

        // Adicionar o item à lista
        venda.getItens().add(item);
        return "Item adicionado com sucesso!";
    }
	
	public static void listarItens(Venda venda) {
		double total=0;
		for(Item item: venda.getItens()) {
			total+=item.getUnitario()*item.getQuantidade();
			System.out.println("Produto: "+ item.getNomeProduto()+
							"  Quantidade: "+item.getQuantidade()+
							"  Unitario: "+item.getUnitario()+
							"  Subtotal: R$"+item.getQuantidade()*item.getUnitario());
		}
		System.out.println("Total geral: R$"+total);
	}
	
	public static void listarVendas () {
		for(Venda item: listaVendas) {
			System.out.println("Id: "+item.getId()+"   Data: "+item.getData()+"   Vendedor: "+item.getNomeVendedor()+"   Cliente: "+item.getNomeCliente()+"   Total: "+totalVenda(item));
		}
	}
	
	public static boolean verificarSeHaVendas () {
		for(Venda item: listaVendas) {
			if(item.getId()==1) {
				return true;
			}
		}
		return false;
	}
	
	public static double totalVenda (Venda venda) {
		double total=0;
		for(Item item: venda.getItens()) {
			total+=item.getUnitario()*item.getQuantidade();
		}
		return total;
	}
}
