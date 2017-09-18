package sample;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.transform.Scale;
import javafx.util.Duration;
import sun.plugin.javascript.navig.Anchor;

import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.Arrays;


public class Controller {
    @FXML
    private TextField txfInptMesA, txfInptMesB, txfInptMesC, txfInptMesW;
    @FXML
    private Slider inptSlider;
    @FXML
    private Label lblOutpPrice, lblOutputError;
    @FXML
    private SplitPane splitPane;

    public  void initialize(){
        inptSlider.setMax(100);
        inptSlider.setMin(0);
    }

    @FXML
    private void resetSPane(){
        ScaleTransition st = new ScaleTransition(Duration.seconds(2), splitPane);
        st.setToX(100);
        st.play();
    }

    @FXML
    private void calculatePackage(){
        int mesAcm, mesBcm, mesCcm, mesWcm;

        try{
            mesAcm = (int) Integer.parseUnsignedInt(txfInptMesA.getText());
            mesBcm = (int) Integer.parseUnsignedInt(txfInptMesB.getText());
            mesCcm = (int) Integer.parseUnsignedInt(txfInptMesC.getText());
            mesWcm = (int) Integer.parseUnsignedInt(txfInptMesW.getText());

        }catch (Exception e){
            mesAcm = mesBcm = mesCcm = mesWcm = 99999999;
            ScaleTransition st = new ScaleTransition(Duration.seconds(2), splitPane);
            st.setToX(0);
            st.play();


        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        lblOutputError.setVisible(false);
        lblOutpPrice.setVisible(true);
        double calc = calcShippingCosts(mesAcm, mesBcm, mesCcm, mesWcm);
        if(calc==0){
            lblOutpPrice.setVisible(false);
            lblOutputError.setVisible(true);
            lblOutputError.setText("der Maße sint ned rischdig");}else{
        lblOutpPrice.setText(formatter.format(calc) + "");}



    }

    private double calcShippingCosts (int length, int height, int width, int weight){
        int size[] = {length, height, width};
        int pckS1[] = {300, 300, 150};
        int pckS2[] = {600, 300, 150};
        int pckS3[] = {1200, 600, 600};

        int sliderVal = 0;

        double price = 0;
        //größter Wert bei Array Pos 2, kleinster bei Array 0
        Arrays.sort(size);

        if(smallerArrayCompare(size, pckS1) && weight <= 1000){
            price = 4.00;
            sliderVal = 0;
        }else if(smallerArrayCompare(size, pckS2) && weight <= 2000){
            price = 4.50;
            sliderVal = 33;
        }else if(smallerArrayCompare(size, pckS3)){
            if(weight <= 5000){
                price = 6.99;
                sliderVal = 66;
            }else if(weight <= 10000){
                price = 9.49;
                sliderVal = 100;
            }else if(weight <= 31500){
                price = 16.49;
                sliderVal = 100;
            }
        }
        inptSlider.setValue(sliderVal);

        return price;
    }

    //Check if ArrayOne is smaller as ArrayTwo
    private boolean smallerArrayCompare(int[] arrayOne, int[] arrayTwo){
        boolean isSmaller = false;

        if(arrayOne.length == arrayTwo.length) {

            Arrays.sort(arrayOne);
            Arrays.sort(arrayTwo);

            isSmaller = true;
            for (int i = 0; i < arrayOne.length; i++){
                if(arrayOne[i] > arrayTwo[i]){
                    isSmaller = false;
                }
            }

        }

        return isSmaller;
    }
}
