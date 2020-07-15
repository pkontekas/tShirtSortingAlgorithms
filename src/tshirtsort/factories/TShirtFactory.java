package tshirtsort.factories;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.models.TShirt;
import tshirtsort.randomizer.RandomTShirt;

/**
 * @author pkontekas
 */
public class TShirtFactory {

    public static List<TShirt> tShirtGenerateX(int x) {
        //method to generate X random Tshirts from our factory and return a list with them
        RandomTShirt rt = new RandomTShirt();
        List<TShirt> listOfTShirts = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            listOfTShirts.add(rt.generate());
        }
        return listOfTShirts;
    }
}
