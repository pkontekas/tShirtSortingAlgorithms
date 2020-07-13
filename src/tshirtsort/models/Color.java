package tshirtsort.models;

/**
 * @author pkontekas
 */
/*       .5     .10      .15     .20   .25    .30     .35
Color, {RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET}
 */
public enum Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;

    static {
        RED.price = 0.5;
        ORANGE.price = 0.10;
        YELLOW.price = 0.15;
        GREEN.price = 0.20;
        BLUE.price = 0.25;
        INDIGO.price = 0.30;
        VIOLET.price = 0.35;
    }

    private double price;

    public double getPrice() {
        return price;
    }

}
