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
     * @param width of the package in
     * @param height of the package
     * @param length of the package
     * @param weight of the package
     * @param price if it is a package category, you can set there the price, then the values above are boundary values
     */
   public Packet(int width, int height, int length, int weight, int price){
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.price = price;
    }

    /**
     * Look at the other fnc. there is a good explanation about everything you need to know
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
     * It sets the price...
     * @param price
     */
    public void setPrice(int price){
        this.price = price;
    }

    /**
     * Returns the weight...
     * @return
     */
    public int getWeight(){
        return weight;
    }

    /**
     * will return the price
     * @return the price in cent int
     */
    public int getPrice(){
        return (int) price;
    }

    /**
     * returns all diameters in an array
     * @return
     */
    public int[] getPackageDiameters(){
        int ret[] = {width, height, length, weight};
        return ret;
    }

}
