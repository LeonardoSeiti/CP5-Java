package br.com.fiap.model.dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.model.bean.Filme;

public class FilmeDAO implements IDAO{
	private Connection con;
	private Filme filme;
	public FilmeDAO(Connection con) {
		this.con = con;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Object obj){
		filme = (Filme) obj;
		String sql = "insert into tb_ddd_filmes(codigo, titulo, genero, produtora) values (?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			ps.setString(2, filme.getTitulo());
			ps.setString(3, filme.getGenero());
			ps.setString(4, filme.getProdutora());
			if (ps.executeUpdate() > 0) {
				return "inserido com sucesso";
			} else {
				return "erro ao inseirir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	public String alterar(Object obj) {
		filme = (Filme) obj;
		String sql = "update tb_ddd_filmes set titulo = ?, genero = ?, produtora = ? where codigo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			ps.setString(2, filme.getTitulo());
			ps.setString(3, filme.getGenero());
			ps.setString(4, filme.getProdutora());
			if (ps.executeUpdate() > 0) {
				return "alterado com sucesso";
			} else {
				return "erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	public String excluir(Object obj) {
		filme = (Filme) obj;
		String sql = "delete from tb_ddd_filmes where codigo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	public String listarTodos() {
		String sql = "select * from tb_ddd_filmes";
		String listaFilme = "Lista dos Filmes \n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next())
				{
					listaFilme += "codigo: " + rs.getString(1) + "\n";
					listaFilme += "titulo: " + rs.getString(2) + "\n";
					listaFilme += "genero: " + rs.getString(3) + "\n";
					listaFilme += "produtora: " + rs.getString(4) + "\n\n";
				}
				return listaFilme;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
