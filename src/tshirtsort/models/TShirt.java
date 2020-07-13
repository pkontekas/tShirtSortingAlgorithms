package tshirtsort.models;

/**
 * @author pkontekas
 */

/*
       .5     .10      .15     .20   .25    .30     .35
Color, {RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET}

       .22 .23 .25 .30 .35 .45   .60  
Size, {XS, S,   M, L,  XL, XXL, XXXL}
          
          2.5    4.5      5         7.5   8.2      12.3     22
Fabric, {WOOL, COTTON, POLYESTER, RAYON, LINEN, CASHMERE, SILK}
 */
public class TShirt {

    private final double basePrice = 8;
    private String type;
    private Color color;
    private Size size;
    private Fabric fabric;
    private double price;
    public static String[] types;

    static {
        types = new String[]{"Aloha", "Baseball", "Camp", "Henley", "Pocket", "Douche Bag",
            "Epaulette", "Lumberjack", "Granddad", "Golf", "Polo", "Ringer", "Muscle",
            "Tuxedo", "Tunic", "Sweatshirt", "Crew-Neck", "V-Neck", "Baby Doll"};
    }

    public TShirt() {
    }

    public TShirt(String name, Color color, Size size, Fabric fabric, double price) {
        this.type = name;
        this.color = color;
        this.size = size;
        this.fabric = fabric;
        setPrice(price); // this.price = price; this is wrong!!!
    }

    // base price = 8
    // setPrice(22.75)
    // price 8+22.75 = 30.75 + material price
    public void setPrice(double price) {
        this.price = this.basePrice + price;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public Fabric getFabric() {
        return fabric;
    }

    @Override
    public String toString() {
        String strPrice = String.format("%.3f", price);
        return "TShirt{" + "Type = " + type + ", Size = " + size + ", Color = " + color + ", Fabric = " + fabric + ", Price = " + strPrice + '}';
    }
}
