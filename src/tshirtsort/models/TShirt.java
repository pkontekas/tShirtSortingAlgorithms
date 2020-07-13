package tshirtsort.models;

import java.util.Objects;

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

    private final float basePrice = 8;
    private String type;
    private Color color;
    private Size size;
    private Fabric fabric;
    private float price;
    public static String[] types;

    static {
        types = new String[]{"Aloha", "Baseball", "Camp", "Henley", "Pocket", "Douche Bag",
            "Epaulette", "Lumberjack", "Granddad", "Golf", "Polo", "Ringer", "Muscle",
            "Tuxedo", "Tunic", "Sweatshirt", "Crew-Neck", "V-Neck", "Baby Doll"};
    }

    public TShirt() {
    }

    public TShirt(String name, Color color, Size size, Fabric fabric, float price) {
        this.type = name;
        this.color = color;
        this.size = size;
        this.fabric = fabric;
        setPrice(price); // this.price = price; this is wrong!!!
    }

    public float getPrice() {
        return price;
    }

    // base price = 8
    // setPrice(22.75)
    // price 8+22.75 = 30.75 
    public void setPrice(float price) {
        this.price = this.basePrice + price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.color);
        hash = 53 * hash + Objects.hashCode(this.size);
        hash = 53 * hash + Objects.hashCode(this.fabric);
        hash = 53 * hash + Float.floatToIntBits(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TShirt other = (TShirt) obj;
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        return this.fabric == other.fabric;
    }

    @Override
    public String toString() {
        return "TShirt{" + "type = " + type + ", size = " + size + ", color = " + color + ", fabric = " + fabric + ", price = " + price + '}';
    }
}
