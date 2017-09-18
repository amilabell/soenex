package data;

/**
 * Created by marchid on 18.09.2017.
 */
public class Packet {

    private int width;
    private int height;
    private int length;
    private int weigth;
    private int price;

    Packet(int width, int height, int length, int weigth, int price){
        this.width = width;
        this.height = height;
        this.length = length;
        this.weigth = weigth;
        this.price = price;
    }

    public int getWeigth(){
        return weigth;
    }

    public int getPrice(){
        return price;
    }

    public int[] getPackageDiameters(){
        int ret[] = {width, height, length};
        return ret;
    }

}
