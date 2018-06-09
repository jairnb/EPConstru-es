/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epconstrucao.model.dao;

import epconstrucao.model.domain.Utilizador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jair
 */
public class UtilizadorDAO {
    
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    public Utilizador SelecionarUsuario(Utilizador utilizador){
        String sql = "SELECT * FROM utilizador where nome=? and senha=?";        
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, utilizador.getNome());
            stmt.setString(2, utilizador.getSenha());
            //stmt.setString(3, utilizador.getTipo());
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()){
                return utilizador;
            }
        }catch(SQLException ex){
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
