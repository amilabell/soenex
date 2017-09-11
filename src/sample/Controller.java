package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField txfInptMesA;

    @FXML
    private TextField txfInptMesB;

    @FXML
    private TextField txfInptMesC;

    @FXML
    private TextField txfInptMesW;


    @FXML
    private void calculatePackage(){
        int mesAcm = (int) Integer.parseInt(txfInptMesA.getText());
        System.out.println(mesAcm);

    }
}
