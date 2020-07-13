package tshirtsort.utils;

import java.util.List;
import tshirtsort.models.TShirt;

/**
 * @author pkontekas
 */
public class Utils {

    public static void printShirtList(List<TShirt> shirts) {
        System.out.println("/// ---------------------------------- ///");
        shirts.forEach((shirt) -> {
            System.out.println(shirt);
        });
        System.out.println("/// ---------------------------------- ///");
    }

    public static void swap(List<TShirt> shirts, int a, int b) {
        //method to swap a with b in a list
        TShirt temp = shirts.get(a);
        shirts.set(a, shirts.get(b));
        shirts.set(b, temp);
    }
}
