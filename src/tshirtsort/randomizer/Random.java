package tshirtsort.randomizer;

import tshirtsort.models.Color;
import tshirtsort.models.Fabric;
import tshirtsort.models.Size;
import static tshirtsort.models.TShirt.names;

/**
 * @author pkontekas
 */
public class Random {

    public Color getRandomColor() {
        Color color1 = Color.values()[getRandomNumberInRange(0, 6)];
        return color1;
    }

    public Size getRandomSize() {
        Size size1 = Size.values()[getRandomNumberInRange(0, 6)];
        return size1;
    }

    public Fabric getRandomFabric() {
        Fabric fabric1 = Fabric.values()[getRandomNumberInRange(0, 6)];
        return fabric1;
    }

    public int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("Maximum must be greater than minimum!");
        }

        java.util.Random r = new java.util.Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomName() {
        java.util.Random random = new java.util.Random();
        return names[random.nextInt(names.length)];
    }

}
