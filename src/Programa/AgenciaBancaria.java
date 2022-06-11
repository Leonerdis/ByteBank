package Programa;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AgenciaBancaria {
		
		static ArrayList<Conta> contasBancarias;
		
		public static void main(String[] args) {
			contasBancarias = new ArrayList<Conta>();
			operacoes();			
		}
		
		public static void operacoes() {
			
			int operacao = Integer.parseInt(JOptionPane.showInputDialog("       Selecione uma operação: " +
			
			      "    \n 1 - Criar conta"    +
			      "    \n 2 - Depositar"	  +
			      "    \n 3 - Sacar"		  +
			      "    \n 4 - Transferir"	  +
			      "    \n 5 - Listar"		  +
				  "    \n 6 - Sair"		    ));
			
			
			
			switch(operacao) {
			case 1:
				criarConta();
				break;
			case 2:
				depositar();
				break;
			case 3:
				sacar();
				break;
			case 4:
				transferir();
				break;
			case 5:
				listaContas();
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Obrigado por utilizar nossos serviços");
				System.exit(0);
				
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
				operacoes();
				break;
			}
		}
		
		public static void criarConta() {
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
			
			pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
			
			pessoa.setEmail(JOptionPane.showInputDialog("Email: "));
						
			Conta conta = new Conta(pessoa);
			contasBancarias.add(conta);
			JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
			JOptionPane.showMessageDialog(null, conta);
			operacoes();
		}
		
		private static Conta encontrarConta(int numeroConta) {
			Conta conta = null;
			if(contasBancarias.size() > 0) {
				for(Conta c: contasBancarias) {
					if(c.getNumeroConta() == numeroConta) {
						conta = c;
					}
				}
			}return conta;
		}
		
		public static void depositar() {
			int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
			
			Conta conta = encontrarConta(numeroConta);
			if(conta != null) {
				Double valorDeposito = 
						Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar?"));
				conta.depositar(valorDeposito);
				//JOptionPane.showMessageDialog(null, "Valor depositado com sucesso");
			}else {
				JOptionPane.showMessageDialog(null, "Conta não encontrada");
			}
			operacoes();
		}
		
		public static void sacar() {
			int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
			
			Conta conta = encontrarConta(numeroConta);
			
			if(conta != null) {
				Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar?"));
				conta.sacar(valorSaque);
			}else {
				JOptionPane.showMessageDialog(null, "Conta não encontrada");
			}
			operacoes();
		}
		
		public static void transferir() {
			int numeroContaOrigem = Integer.parseInt(JOptionPane.showInputDialog("Número da conta do origem: "));
			
			Conta contaOrigem = encontrarConta(numeroContaOrigem);
			
			if(contaOrigem != null) {
				int numeroContaDestino = Integer.parseInt(JOptionPane.showInputDialog("Número da conta destino: "));
				
				Conta contaDestino = encontrarConta(numeroContaDestino);
				if(contaDestino != null) {
					Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência: "));
					
					contaOrigem.transferir(contaDestino, valor);
				}else {
					JOptionPane.showMessageDialog(null, "A conta para depósito não foi encontrada");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Conta para transferência não encontrada");
			}
			operacoes();
		}
		
		public static void listaContas() {
			if(contasBancarias.size() > 0) {
				for(Conta conta: contasBancarias) {
					JOptionPane.showMessageDialog(null, conta);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Não há contas cadastradas!");
			}
			operacoes();
		}
	}


