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

    /**
     *
     * @param width
     * @param height
     * @param length
     * @param weight
     * @param price
     */
   public Packet(int width, int height, int length, int weight, int price){
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.price = price;
    }

    /**
     *
     * @param width
     * @param height
     * @param length
     * @param weight
     */
    public Packet(int width, int height, int length, int weight){
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.price = 0;
    }

    /**
     *
     * @param price
     */
    public void setPrice(int price){
        this.price = price;
    }

    /**
     *
     * @return
     */
    public int getWeight(){
        return weight;
    }

    /**
     *
     * @return
     */
    public int getPrice(){
        return (int) price;
    }

    /**
     *
     * @return
     */
    public int[] getPackageDiameters(){
        int ret[] = {width, height, length, weight};
        return ret;
    }

}
