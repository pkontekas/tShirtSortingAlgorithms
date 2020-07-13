package tshirtsort;

import java.util.List;
import tshirtsort.factories.TShirtFactory;
import tshirtsort.models.TShirt;
import tshirtsort.utils.Utils;

/**
 * @author pkontekas
 */
public class MainClass {

    protected static List<TShirt> shirts;

    public static void main(String[] args) {

        //Make 40 random T-Shirts through factory
        shirts = TShirtFactory.tShirtGenerateX(40);

        System.out.println("\nWelcome to our Custom T-SHIRT PeopleFactory!\n");
        System.out.println("Your Warehouse recently received these 40 T-Shirts : ");
        Utils.printShirtList(shirts);

        //Choose what to do through menu
        Menu menu = new Menu();
        menu.welcomeMenu();
    }
}
