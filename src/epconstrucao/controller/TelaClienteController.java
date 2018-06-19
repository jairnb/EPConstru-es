/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epconstrucao.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ne
 */
public class TelaClienteController implements Initializable {
    
      
    
     @FXML
    private JFXButton btnApagar;
     
      @FXML
    private JFXButton btnEditar;
      
       @FXML
    private JFXButton btnDetalhes;
       
     @FXML
    private JFXButton btnAdicionar;
    
    @FXML
    private JFXButton btnFun;

    @FXML
    private JFXButton btnMat;

    @FXML
    private JFXButton btnUtil;

    @FXML
    private JFXButton btnVenda;

    @FXML
    private JFXButton btnVoltar;

    @FXML
    private JFXButton btnCliente;

    @FXML
    private JFXButton btnFor;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
        
        btnApagar.setVisible(false);
        btnEditar.setVisible(false);
        
    }    
    
}
