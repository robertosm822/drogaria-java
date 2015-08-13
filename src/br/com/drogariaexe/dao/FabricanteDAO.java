package br.com.drogariaexe.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import br.com.drogariaexe.domain.Fabricante;
import br.com.drogariaexe.factory.ConexaoFactory;

public class FabricanteDAO {
	public void salvar(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		
		/* executar o comando */
		comando.executeUpdate();
	}
	
	public  void excluir(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo=?");
	}  
	
	/*
	 * METODO DE DEPURACAO - OK
	 * */
	public static void main(String[] args) {

			Fabricante f1 = new Fabricante();
			f1.setDescricao("DECRICAO 3");
			
			Fabricante f2 = new Fabricante();
			f2.setDescricao("DECRICAO 4");
			
			FabricanteDAO fdao = new FabricanteDAO();
			
			try {
				fdao.salvar(f1);
				fdao.salvar(f2);
				System.out.println("Fabricante foi salvo");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				System.out.println("falhou a insercao");
				
			}
	
	}
	
	
}
