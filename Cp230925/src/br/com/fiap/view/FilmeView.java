package br.com.fiap.view;

import javax.swing.JOptionPane; 

import br.com.fiap.controller.FilmeController;

public class FilmeView {

	public static void main(String[] args) {
		String aux, escolha = "sim", codigo, titulo, genero, produtora;
		int opcao;
		FilmeController filme = new FilmeController();
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog("Escolhas: \n (1)Inserir\n (2) Alterar \n (3)Excluir");
				opcao = Integer.parseInt(aux);
				codigo = JOptionPane.showInputDialog("Código do filme: ");
				switch (opcao) {
				case 1: 
					titulo = JOptionPane.showInputDialog("Titulo do filme: ");
					genero = JOptionPane.showInputDialog("Genero do filme: ");
					produtora = JOptionPane.showInputDialog("Produtora do filme: ");
					System.out.println(filme.insereFilme(codigo, titulo, genero, produtora));
					JOptionPane.showMessageDialog(null, filme.listaTodosFilmes());
					break;
				case 2: 
					titulo = JOptionPane.showInputDialog("Titulo do filme: ");
					genero = JOptionPane.showInputDialog("Genero do filme: ");
					produtora = JOptionPane.showInputDialog("Produtora do filme: ");
					System.out.println(filme.alteraFilme(codigo, titulo, genero, produtora));
					JOptionPane.showMessageDialog(null, filme.listaTodosFilmes());
					break;
				case 3: 
					System.out.println(filme.excluiFilme(codigo));
					JOptionPane.showMessageDialog(null,filme.listaTodosFilmes());
					break;
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + opcao);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar");
		}
		JOptionPane.showMessageDialog(null, "Finalizando programa");
	}

}
