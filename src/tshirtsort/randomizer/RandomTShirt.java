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
        double materialCost = color.getPrice() + size.getPrice() + fabric.getPrice();
        TShirt t1 = new TShirt(Random.getRandomType(), color, size, fabric,
                r.getRandomNumberInRange(0, 20) + materialCost);
        return (t1);
    }
}