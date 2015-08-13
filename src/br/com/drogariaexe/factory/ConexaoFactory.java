package br.com.drogariaexe.factory;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	/*
	 * MATERIA PRIMA DA CONEXAO
	 * */
	private static final String USUARIO = "root";
	private static final String SENHA = "123";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria";
	
	public static Connection conectar() throws SQLException{
		Connection conexao = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
		
	}
	/*
	 * METODO APENAS PARA TESTAR A CONEXAO VIA CONSOLE JAVA
	 * */
	public static void main(String[] args) {
		try{
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexao realizada");
		} catch (SQLException ex){
			ex.printStackTrace();
			System.out.println("falha");
			
		}
	}
}
