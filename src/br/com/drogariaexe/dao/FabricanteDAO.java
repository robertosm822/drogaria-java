package br.com.drogariaexe.dao;

import java.sql.ResultSet;
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
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());  // setLong porque o tipo de dado eh do tipo Long
		
		/* executar o comando */
		comando.executeUpdate();
	}  
	
	public void editar(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		
		comando.executeUpdate();
	}
	
	public Fabricante buscarPorCodigo(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao FROM fabricante ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		
		
		ResultSet resultado = comando.executeQuery();
		
		//converter ResultSet para Fabricante
		Fabricante retorno = null;
		
		if(resultado.next()){
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		
		return retorno;
	}
	
	/*
	 * METODO DE DEPURACAO - OK
	 * */
	public static void main(String[] args) {

			/*
			 * 
			//INCLUIDNO DADOS
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
		
		
		//EXCLUIR DADOS
		Fabricante f1 = new Fabricante();
		f1.setCodigo(5L);  // tem de colocar a letra "L" para o tipo ficar correto
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(6L);
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			fdao.excluir(f1);
			fdao.excluir(f2);
			System.out.println("Excluido com sucesso");
		} catch (SQLException e) {
			// TODO: handle exceptio
			System.out.println("Erro ao excluir");
			e.printStackTrace();
		}
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(2L);
		f1.setDescricao("Aprendendo Java Webs");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			fdao.editar(f1);
			System.out.println("Editado com sucesso!");
		} catch (SQLException e) {
			// TODO: handle exception
			
			System.out.println("Erro ao editar");
			e.printStackTrace();
		}
		*/
		//RETORNANDO UM UNICO CONTEUDO CADASTRADO
		Fabricante f1 = new Fabricante();
		f1.setCodigo(2L);
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			Fabricante f3 = fdao.buscarPorCodigo(f1);
			
			//imprimir o objeto
			System.out.println("Resultado 1:  "+f3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao realizar consulta");
			e.printStackTrace();
		}
		
	}
	
	
}
