/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epconstrucao.controller;

import epconstrucao.model.dao.UtilizadorDAO;
import epconstrucao.model.database.Database;
import epconstrucao.model.database.DatabaseFactory;
import epconstrucao.model.domain.Utilizador;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jair
 */
public class LoginController implements Initializable {

    @FXML 
    private AnchorPane loginAnchorPane;
    @FXML
    private TextField nomeTextField;    
    @FXML
    private TextField senhaTextFiled;
    @FXML
    private Button entrarButton;
    
    private final UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
    private Utilizador utilizador = new Utilizador();
    private boolean controlo;    
    
    private final Database database = DatabaseFactory.getDatabase();
    private final Connection conexao = database.conectar();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utilizadorDAO.setConexao(conexao);
        
        entrarButton.setOnMouseClicked((MouseEvent e) -> {
            try {
                login();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
    
    public void login() throws IOException{
        Utilizador utilizadorForm = new Utilizador();
        utilizadorForm.setNome( nomeTextField.getText());
        utilizadorForm.setSenha(senhaTextFiled.getText());
        
        utilizador = utilizadorDAO.SelecionarUsuario(utilizadorForm);
        
        if(utilizador.getNome().equals(utilizadorForm.getNome()) && utilizador.getSenha().equals(utilizadorForm.getSenha()) /*&& utilizador.getTipo().equals("admin")*/){            
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/epconstrucao/view/PaginaInicialAdmin.fxml"));
            loginAnchorPane.getChildren().setAll(a);
        }/*else if(utilizador.getNome().equals(utilizadorForm.getNome()) && utilizador.getSenha().equals(utilizadorForm.getSenha()) && utilizador.getTipo().equals("vendedor")){
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/epconstrucao/view/PaginaInicialVendedor.fxml"));
        loginAnchorPane.getChildren().setAll(a);
        }*/else{
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }
}
