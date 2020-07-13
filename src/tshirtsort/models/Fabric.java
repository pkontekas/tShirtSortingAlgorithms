package tshirtsort.models;

/**
 * @author pkontekas
 */

/*
          2.5    4.5      5         7.5   8.2      12.3     22
Fabric, {WOOL, COTTON, POLYESTER, RAYON, LINEN, CASHMERE, SILK}
 */
public enum Fabric {
    WOOL, COTTON, POLYESTER, RAYON, LINEN, CASHMERE, SILK;

    static {
        WOOL.price = 2.5;
        COTTON.price = 4.5;
        POLYESTER.price = 5.0;
        RAYON.price = 7.5;
        LINEN.price = 8.2;
        CASHMERE.price = 12.3;
        SILK.price = 22.0;
    }

    private double price;

    public double getPrice() {
        return price;
    }
}
