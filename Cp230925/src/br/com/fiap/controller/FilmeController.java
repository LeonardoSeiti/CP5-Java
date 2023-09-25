package br.com.fiap.controller;
  

import java.sql.Connection;

import br.com.fiap.model.bean.Filme;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dao.Conexao;

public class FilmeController {
	public String insereFilme(String codigo, String titulo, String genero, String produtora) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Filme filmeBean = new Filme();
		filmeBean.setCodigo(codigo);
		filmeBean.setTitulo(titulo);
		filmeBean.setGenero(genero);
		filmeBean.setProdutora(produtora);
		FilmeDAO filmeDao = new FilmeDAO(con);
		resultado = filmeDao.inserir(filmeBean);
		Conexao.fecharConexao(con);
		return resultado;
	}

	public String alteraFilme(String codigo, String titulo, String genero, String produtora) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Filme filmeBean = new Filme();
		filmeBean.setCodigo(codigo);
		filmeBean.setTitulo(titulo);
		filmeBean.setGenero(genero);
		filmeBean.setProdutora(produtora);
		FilmeDAO filmeDao = new FilmeDAO(con);
		resultado = filmeDao.alterar(filmeBean);
		Conexao.fecharConexao(con);
		return resultado;
	}

	public String excluiFilme(String codigo) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		Filme filmeBean = new Filme();
		filmeBean.setCodigo(codigo);
		FilmeDAO filmeDao = new FilmeDAO(con);
		resultado = filmeDao.excluir(filmeBean);
		Conexao.fecharConexao(con);
		return resultado;
	}

	public String listaTodosFilmes() {
		String resultado = "";
		Connection con = Conexao.abrirConexao();
		FilmeDAO filmeDao = new FilmeDAO(con);
		resultado = filmeDao.listarTodos();
		Conexao.fecharConexao(con);
		if (resultado != null) {
			return resultado;
		} else {
			return null;
		}
	}
}