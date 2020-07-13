package tshirtsort.models;

/**
 * @author pkontekas
 */

/*       .5     .10      .15     .20   .25    .30     .35
Color, {RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET}
 */
public enum Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;

    public double getColorPrice(Color color) {
        double result = 0;
        switch (color) {
            case RED:
                result = 0.5;
                break;
            case ORANGE:
                result = 0.10;
                break;
            case YELLOW:
                result = 0.15;
                break;
            case GREEN:
                result = 0.20;
                break;
            case BLUE:
                result = 0.25;
                break;
            case INDIGO:
                result = 0.30;
                break;
            case VIOLET:
                result = 0.35;
                break;
        }
        return result;
    }
}
