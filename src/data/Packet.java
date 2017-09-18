package data;

/**
 * Created by marchid on 18.09.2017.
 */
public class Packet {

    private int width;
    private int height;
    private int length;
    private int weight;
    private double price;

   public Packet(int width, int height, int length, int weight, int price){
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.price = price;
    }
    public Packet(int width, int height, int length, int weight){
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getWeight(){
        return weight;
    }

    public int getPrice(){
        return (int) price;
    }

    public int[] getPackageDiameters(){
        int ret[] = {width, height, length, weight};
        return ret;
    }

}
