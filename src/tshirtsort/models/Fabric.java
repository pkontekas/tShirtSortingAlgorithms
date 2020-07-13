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

    public double getFabricPrice(Fabric fabric) {
        double result = 0;
        switch (fabric) {
            case WOOL:
                result = 2.5;
                break;
            case COTTON:
                result = 4.5;
                break;
            case POLYESTER:
                result = 5.0;
                break;
            case RAYON:
                result = 7.5;
                break;
            case LINEN:
                result = 8.2;
                break;
            case CASHMERE:
                result = 12.3;
                break;
            case SILK:
                result = 22.0;
                break;
        }
        return result;
    }
}
