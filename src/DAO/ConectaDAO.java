/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

 

  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.SQLException;

public class ConectaDAO {
    

      public static void main(String[] args) {

          ConectaDAO conexao = new ConectaDAO();
          Connection conn = conexao.conectar();
          conexao.desconectar(conn);
      }

      public Connection conectar() {
          Connection conn = null;
          try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11", "root", "8456Thaisjosemar#");
              System.out.println("Conectou com o banco de dados!!!!");
          } catch (SQLException ex) {
              System.out.println("Erro: Não foi possivel se conectar no banco de dados!");
          } catch (ClassNotFoundException ex) {
              System.out.println("Erro: Driver JDBC nao encontrado!.");
          }

          return conn;
      }

      public void desconectar(Connection conn) {
          try {
              if (conn != null && !conn.isClosed()) {
                  conn.close();
                  System.out.println("Voce se desconectou do banco de dados.");
              }
          } catch (SQLException ex) {
              System.out.println("Nao foi possivel desconectar do banco dados.");
          }
      }
  }    
