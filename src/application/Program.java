package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
	/*	Primeiro Exemplo de recuperação
	 * 
	 * Connection conn = null;
		//statement serve para montar um comando sql
		Statement st = null;
		//ResultSet representa um objeto contendo o resultado na nossa consulta em forma de tabela, e tem funções:.
		//first() posiciona na posição 1 se houver onde tem dados, não nome da coluna que é o 0.
		//BeforeFirst() na posição 0
		//next move uma posição e retorna falso se estiver no ultimo
		//absolute(int) move para a posição dada, lembrando que começam na posição 1
		
		ResultSet rs = null;
		try {
			conn = DB.GetConnection();
			
			st = conn.createStatement();
			// o resultado da consulta vai para a variavel resultSet
			rs = st.executeQuery("select * from department");
			//rs ta em formato de tabela
			while(rs.next()) {
				//pega o Inteiro que está lá no campo ID
				System.out.println(rs.getInt("id") + ", " + rs.getString("Name"));
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			//como são recursos externos que não são controlados pela JVM, temos q fechar para não haver vazamento de memoria
		DB.closeStatement(st);
		DB.closetResultSet(rs);
		DB.closeConnection();
		}
		=========================================================================================================================
		*/
		
		
		/*Inserção
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		//PreparedStatement permite montar consulta SQL e deixando para colocar os parametros depois
		PreparedStatement st = null;
		try {
			conn = DB.GetConnection();
			st = conn.prepareStatement("INSERT INTO seller (name,Email,BirthDate,BaseSalary,DepartamentId) VALUES "
					+ "(?,?,?,?,?)"{Para colocarmos mais de uma vez só colocarmos mais ??},Statement.RETURN_GENERATED_KEYS);
					
			//trocar o primeiro interrogação pelo valor
			st.setString(1,"Carl purple");
			st.setString(2, "carl@");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4,3000.0);
			st.setInt(5, 4);
			//o resultado a operação vai ser num. int, indicando quantas linhas foram afetadas
			int rows =	st.executeUpdate();
			//Generate retorna para uma variavel de resultSet
			if(rows >0) {
				ResultSet rs = st.getGeneratedKeys();
				//percore o result
				while(rs.next()) {
					//o 1 é pq é a coluna contendo os id, valor da primeira coluna
					int id = rs.getInt(1);
					System.out.println("Done! ID = " + id);
				}
			}
			else {
				System.out.println("no rows affected");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			
			DB.closeConnection();
		}
		===============================================================================================
		*/	
		
		/* Para Atualizar
		 * Impede que atualize automaticamente
		 * conn.setAutoCommit(false);
		 * st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");

			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			conn.commit();
			int rowsAffected = st.executeUpdate();
			
			catch (SQLException e) {
			try {
			rollback também pode gerar uma excessão por isso colcoamos outro
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
				} 
			catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
			*/

	}

}
