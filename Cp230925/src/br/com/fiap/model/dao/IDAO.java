package br.com.fiap.model.dao;

public interface IDAO {
	public String inserir(Object obj);
	
	public String alterar(Object obj);
	
	public String excluir(Object obj);
	
	public String listarTodos();
}
