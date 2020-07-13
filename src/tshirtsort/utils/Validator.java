package tshirtsort.utils;

import java.util.Scanner;

/**
 * @author pkontekas
 */
public class Validator {
    
    public static int getValidMenuChoice(int numChoices, Scanner scan) {
        //validation for number of Choices up to numChoices, for Menus and not only
        int number;
        do {
            System.out.print("Please enter a valid choice: ");
            while (!scan.hasNextInt()) {
                String input = scan.next();
                System.out.println(input + " is not a valid choice. You will have to retry.");
            }
            number = scan.nextInt();
        } while (number < 1 || number > numChoices);
        return number;
    }

    public static boolean yesNoChoice(Scanner scan) 
    //method for Yes/No Choices
    {
        String decision;
        boolean choice;
        do {
            System.out.print("(Y)es/(N)o ?");
            //next line seems reduntant but its to avoid an issue/bug with the Scanner feature
            scan.nextLine();
            decision = scan.nextLine();
            switch (decision.toLowerCase()) {
                case "yes":
                    choice = true;
                    return choice;
                case "y":
                    choice = true;
                    return choice;
                case "no":
                    choice = false;
                    return choice;
                case "n":
                    choice = false;
                    return choice;
                default:
                    choice = false;
            }
        } while (choice == false);
        return choice;
    }
}
