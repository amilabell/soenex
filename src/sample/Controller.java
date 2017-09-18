package sample;
import data.Packet;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.util.Duration;

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

    private int calcShippingCosts (int length, int height, int width, int weight) {

        Packet p1 = new Packet(300, 300, 150, 1000, 400);
        Packet p2 = new Packet(600, 300, 150, 2000, 450);
        Packet p3 = new Packet(1200, 600, 600, 5000, 699);
        Packet p4 = new Packet(1200, 600, 600, 10000, 949);
        Packet p5 = new Packet(1200, 600, 600, 10000, 1649);
        Packet user = new Packet(width, height, length, weight);
        Packet packets[] = new Packet[5];

        packets[0] = p1;
        packets[1] = p2;
        packets[3] = p3;
        packets[4] = p4;
        packets[5] = p5;

        int size[] = {length, height, width, weight};
        int pckS1[] = {300, 300, 150};
        int pckS2[] = {600, 300, 150};
        int pckS3[] = {1200, 600, 600};

        int sliderVal = 0;

        double price = 0;
        //größter Wert bei Array Pos 2, kleinster bei Array 0
        Arrays.sort(size);

        if (smallerArrayCompare(user.getPackageDiameters(), p1.getPackageDiameters())) {
            user.setPrice(p1.getPrice());
            sliderVal = 0;
        } else if (smallerArrayCompare(user.getPackageDiameters(), p2.getPackageDiameters())) {
            user.setPrice(p2.getPrice());
            sliderVal = 33;
        } else if (smallerArrayCompare(user.getPackageDiameters(), p3.getPackageDiameters())) {
            user.setPrice(p3.getPrice());
            sliderVal = 66;
        } else if (smallerArrayCompare(user.getPackageDiameters(), p4.getPackageDiameters())) {
            user.setPrice(p4.getPrice());
            sliderVal = 100;
        } else if (smallerArrayCompare(user.getPackageDiameters(), p5.getPackageDiameters())) {
            user.setPrice(p5.getPrice());
            sliderVal = 100;
        }

        inptSlider.setValue(sliderVal);
        return user.getPrice();
        }


    //Check if ArrayOne is smaller as ArrayTwo
    private boolean smallerArrayCompare(int[] arrayOne, int[] arrayTwo){
        boolean isSmaller = false;

        if(arrayOne.length == arrayTwo.length) {

            //Arrays.sort(arrayOne);
            //Arrays.sort(arrayTwo);

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
