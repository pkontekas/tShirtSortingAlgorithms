package tshirtsort.randomizer;

import tshirtsort.models.Color;
import tshirtsort.models.Fabric;
import tshirtsort.models.Size;
import tshirtsort.models.TShirt;

/**
 * @author pkontekas
 */
public class RandomTShirt {

    public TShirt generate() {
        Random r = new Random();
        Color color = r.getRandomColor();
        Size size = r.getRandomSize();
        Fabric fabric = r.getRandomFabric();

        TShirt t1 = new TShirt(Random.getRandomName(), color, size, fabric, r.getRandomNumberInRange(0, 20));
        return (t1);
    }

}
