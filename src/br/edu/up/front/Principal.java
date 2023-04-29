package br.edu.up.front;
import br.edu.up.entidades.*;
import br.edu.up.persistencia.*;
import br.edu.up.negocio.*;

public class Principal {
	public static void main(String[] args) {
		
		int opc;
		String resposta= "";
		do {
			System.out.println("\n\n------------------------------------"
					+ "\n1 - Cadastrar cliente"
					+ "\n2 - Cadastrar vendedor"
					+ "\n3 - Cadastrar produto"
					+ "\n4 - Nova venda"
					+ "\n5 - Consultar venda"
					+ "\n6 - Listar vendas"
					+ "\n7 - Sair"
					+ "\n------------------------------------");
			opc= Console.readInt("Informe a opção: ");
			
			switch(opc) {
			case 1:
				System.out.println("\n--- Cadastrar cliente ---");
				Cliente cliente = new Cliente();
				cliente.setNome(Console.readString("Informe o nome do cliente: "));
				cliente.setCpf(Console.readString("Informe o CPF do cliente: "));
				if(Negocio.validarCPF(cliente.getCpf())==true) {
					if(PersistenciaCliente.verificarClienteCadastrado(cliente)==false) {
						PersistenciaCliente.adicionarCliente(cliente);
						System.out.println("Cliente cadastrado com sucesso!");
					}else {
						System.out.println("Este cliente já foi cadastrado.");
					}
				}else {
					System.out.println("CPF inválido.");
				}
				break;
				
			case 2:
				System.out.println("\n--- Cadastrar vendedor ---");
				Vendedor vendedor = new Vendedor();
				vendedor.setNome(Console.readString("Informe o nome do vendedor: "));
				vendedor.setCpf(Console.readString("Informe o CPF do vendedor: "));
				if(Negocio.validarCPF(vendedor.getCpf())==true) {
					if(PersistenciaVendedor.verificarVendedorCadastrado(vendedor)==false) {
						vendedor.setComissao(Console.readDouble("Informe a taxa de comissão do vendedor, em porcentagem: "));
						PersistenciaVendedor.adicionarVendedor(vendedor);
						System.out.println("Vendedor cadastrado com sucesso!");
					}else {
						System.out.println("Este vendedor já foi cadastrado.");
					}
				}else {
					System.out.println("CPF inválido.");
				}
				break;
				
			case 3:
				System.out.println("\n--- Cadastrar produto ---");
				Produto produto = new Produto();
				produto.setNome(Console.readString("Informe o nome do produto: "));
				if(PersistenciaProduto.verificarProdutoCadastrado(produto)==false) {
					produto.setPreco(Console.readDouble("Informe o preço de compra do produto: "));
					produto.setMarkup(Console.readDouble("Informe o markup do produto: "));
					PersistenciaProduto.adicionarProduto(produto);
					System.out.println("Produto cadastrado com sucesso!");
				}else {
					System.out.println("Este produto já está cadastrado.");
				}
				break;
				
			case 4:
				System.out.println("\n--- Nova Venda ---");
				Venda venda = new Venda();
				venda.setId(Console.readInt("Informe o Id da venda: "));
				if(PersistenciaVenda.verificarVendaCadastrada(venda)==false) {
					
					cliente = new Cliente();
					cliente.setCpf(Console.readString("Informe o CPF do cliente: "));
					if(Negocio.validarCPF(cliente.getCpf())==true) {
						cliente= PersistenciaCliente.retornarCliente(cliente);
						//verificar se o cliente existe, se não existir o objeto estará null
						if(cliente !=null) {
								System.out.println("Cliente encontrado.");
								venda.setNomeCliente(cliente);
								
								vendedor = new Vendedor();
								vendedor.setCpf(Console.readString("Informe o CPF do vendedor"));
								if(Negocio.validarCPF(vendedor.getCpf())==true) {
									vendedor= PersistenciaVendedor.retornarVendedor(vendedor);
									//verificar se o vendedor existe, se não exisitr o objeto estará null
									if(vendedor!=null) {
										System.out.println("Vendedor encontrado.");
										venda.setNomeVendedor(vendedor);
										
										venda.setData(Console.readString("Informe a data da venda: "));
										//Adicionar itens à venda
										do {
											Item itemVenda = new Item();
											produto= new Produto();
											produto.setNome(Console.readString("\nInforme o nome do produto: "));
											produto= PersistenciaProduto.retornarProduto(produto);
											if(produto!=null) {
												System.out.println("Produto encontrado.");
												itemVenda.setNomeProduto(produto);
												itemVenda.setQuantidade(Console.readInt("Informe a quantidade do produto: "));
												itemVenda.setUnitario(NegocioProduto.calcularPrecoVenda(produto));
												System.out.println("Valor unitário: "+NegocioProduto.calcularPrecoVenda(produto));
												System.out.println(PersistenciaVenda.adicionarItem(venda, itemVenda));
												resposta = Console.readString("\nDeseja adicionais mais itens nessa venda?\nDigite S para sim e N para não: ");
												
											}else {
												System.out.println("Produto não cadastrado.");
												continue;
											}
										}while(resposta.equals("S") || (resposta.equals("s")));
										System.out.println("\nResumo da Venda: "
												+"\nId: "+venda.getId()
												+"\nData: "+venda.getData()
												+"\nCliente: "+venda.getNomeCliente()
												+"\nVendedor: "+venda.getNomeVendedor()
												+"\nItens: ");
										PersistenciaVenda.listarItens(venda);
										PersistenciaVenda.adicionarVenda(venda);
										System.out.println("\nVenda finalizada!");
										
									}else {
										System.out.println("Vendedor não cadastrado, cadastre-o na opção 2.");
									}
								}else {
									System.out.println("CPF inválido.");
								}
							
						}else {
							System.out.println("Cliente não cadastrado, cadastre-o na opção 1. ");
						}
						
					}else {
						System.out.println("CPF inválido.");
					}
				}else {
					System.out.println("Esta venda já está cadastrada.");
				}
			break;
			
			case 5:
				System.out.println("\n--- Consultar Venda ---");
				venda= new Venda();
				venda.setId(Console.readInt("Informe o Id da venda: "));
				venda=PersistenciaVenda.retornarVenda(venda);
				if(venda!=null) {
					System.out.println("Venda encontrada.");
					System.out.println("\nResumo desta Venda: "
							+"\nId: "+venda.getId()
							+"\nData: "+venda.getData()
							+"\nCliente: "+venda.getNomeCliente()
							+"\nVendedor: "+venda.getNomeVendedor()
							+"\nItens: ");
					PersistenciaVenda.listarItens(venda);
				}else {
					System.out.println("Não há nenhuma venda com esse Id.");
				}
				break;
			
			case 6:
				System.out.println("\n--- Listar Vendas ---");
				if(PersistenciaVenda.verificarSeHaVendas()==true) {
					System.out.println("Vendas realizadas até o período: ");
					PersistenciaVenda.listarVendas();
				}else {
					System.out.println("Não há vendas cadastradas.");
				}
				break;
				
			case 7:
				System.out.println("O programa será finalizado.");
				break;
				
			default:
				System.out.println("A opção selecionada não existe.");
				break;
			}
			
		}while(opc!=7);
	}
}