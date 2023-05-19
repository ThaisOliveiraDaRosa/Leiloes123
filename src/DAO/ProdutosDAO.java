/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ProdutosDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class ProdutosDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ProdutosDTO> lista = new ArrayList<>();
    
    public void cadastrarProdutos(ProdutosDTO produtos)  {
    String sql = "insert into produtos (id,nome, valor, status) values (?,?,?,?) ";
    
    conn = new ConectaDAO().conectar(); 
    
    try{
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1, produtos.getId());
        pstm.setString(2, produtos.getNome());
        pstm.setInt(3, produtos.getValor());
        pstm.setString(4, produtos.getStatus());
        
        pstm.execute();
        pstm.close();
        
    }catch (Exception erro){
        JOptionPane.showMessageDialog(null,"ProdutosDAO"+ erro);
    }
    }
    public ArrayList<ProdutosDTO>ConsultarProdutos(){
    String sql = "Select * from produtos";
    
    conn = new ConectaDAO().conectar(); 
    
    try{
       pstm = conn.prepareStatement(sql);
       rs = pstm.executeQuery();
       
       while(rs.next()){
           ProdutosDTO produtos = new ProdutosDTO();
           produtos.setId(rs.getInt("id"));
           produtos.setNome(rs.getString("nome"));
           produtos.setValor(rs.getInt("valor"));
           produtos.setStatus(rs.getString("status"));
           
           lista.add(produtos);
       }
       
    }catch (SQLException erro){
        JOptionPane.showMessageDialog(null,"ProdutosDAO Consultar: "+ erro);
    }
    return lista;
}
    
     public void UpdateProdutos(ProdutosDTO produtos)  {
    String sql = "UPDATE  produtos SET status=? WHERE id=? and nome=? and valor=?"; 
    
    conn = new ConectaDAO().conectar(); 
    
    try{
        pstm = conn.prepareStatement(sql);
        pstm.setString(1, produtos.getStatus());
        pstm.setInt(2, produtos.getId());
        pstm.setString(3, produtos.getNome());
        pstm.setInt(4, produtos.getValor());
       
        
        pstm.execute();
        pstm.close();
        
    }catch (Exception erro){
        JOptionPane.showMessageDialog(null,"Atualizar"+ erro);
    }
    }

   public ArrayList<ProdutosDTO>ConsultarProdutosVendidos(){
    String sql = "Select * from produtos WHERE (status = 'Vendido')";
    
    conn = new ConectaDAO().conectar(); 
    
    try{
       pstm = conn.prepareStatement(sql);
       rs = pstm.executeQuery();
       
       while(rs.next()){
           ProdutosDTO produtos = new ProdutosDTO();
           produtos.setId(rs.getInt("id"));
           produtos.setNome(rs.getString("nome"));
           produtos.setValor(rs.getInt("valor"));
           produtos.setStatus(rs.getString("status"));
           
           lista.add(produtos);
       }
            
    }catch (SQLException erro){
        JOptionPane.showMessageDialog(null,"ProdutosDAO ConsultarVendido: "+ erro);
    }
    return lista;
}
    } 



