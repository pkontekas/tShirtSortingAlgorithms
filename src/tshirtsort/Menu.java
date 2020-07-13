/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort;

import java.util.Scanner;
import static tshirtsort.MainClass.shirts;
import tshirtsort.sorting.BubbleSort;
import tshirtsort.sorting.BucketSort;
import tshirtsort.sorting.QuickSort;
import tshirtsort.utils.Validator;

/**
 *
 * @author pkontekas
 */
public class Menu {

    private final Scanner scan;

    protected Menu() {
        this.scan = new Scanner(System.in);
    }

    protected void welcomeMenu() {

        System.out.println("\nPlease proceed with one of the following sorting choices: ");
        System.out.println("1. QuickSort.\n2. BubbleSort.\n3. BucketSort.\n");
        int choice = Validator.getValidMenuChoice(3, scan);
        switch (choice) {
            case 1:
                quickSortMenu();
                break;
            case 2:
                bubbleSortMenu();
                break;
            case 3:
                bucketSortMenu();
                break;
        }
    }

    private void quickSortMenu() {
        int choice = 0;
        QuickSort quick = new QuickSort();
        while (choice != 6) {
            System.out.println("Please proceed with one of the following sorting choices: ");
            System.out.println("1. QuickSort by Size.\n2. QuickSort by Color.\n3. QuickSort by Fabric.\n"
                    + "4. QuickSort by Size/Color/Fabric ASC.\n5. QuickSort by Size/Color/Fabric DESC.\n6. Exit");
            choice = Validator.getValidMenuChoice(6, scan);
            //System.out.println("---------------------");
            switch (choice) {
                case 1:
                    QuickSort.performQuickSortBySize(quick, shirts);
                    break;
                case 2:
                    QuickSort.performQuickSortByColor(quick, shirts);
                    break;
                case 3:
                    QuickSort.performQuickSortByFabric(quick, shirts);
                    break;
                case 4:
                    System.out.println("TShirts sorted per Property ASC (Size, then Color, then Fabric) with QuickSort: ");
                    QuickSort.performQuickSortPerProperty(quick, shirts, true);
                    break;
                case 5:
                    System.out.println("TShirts sorted per Property DESC (Size, then Color, then Fabric) with QuickSort: ");
                    QuickSort.performQuickSortPerProperty(quick, shirts, false);
                    break;
                case 6:
                    System.out.println("Thank you, have a nice Day!");
                    break;
            }
        }
    }

    private void bubbleSortMenu() {
        int choice = 0;
        BubbleSort bubble = new BubbleSort();
        while (choice != 6) {
            System.out.println("Please proceed with one of the following sorting choices: ");
            System.out.println("1. BubbleSort by Size.\n2. BubbleSort by Color.\n3. BubbleSort by Fabric.\n"
                    + "4. BubbleSort by Size/Color/Fabric ASC.\n5. BubbleSort by Size/Color/Fabric DESC.\n6. Exit.");
            choice = Validator.getValidMenuChoice(6, scan);
            //System.out.println("---------------------");
            switch (choice) {
                case 1:
                    BubbleSort.performBubbleSortBySize(bubble, shirts);
                    break;
                case 2:
                    BubbleSort.performBubbleSortByColor(bubble, shirts);
                    break;
                case 3:
                    BubbleSort.performBubbleSortByFabric(bubble, shirts);
                    break;
                case 4:
                    System.out.println("TShirts sorted per Property ASC (Size, then Color, then Fabric) with BubbleSort: ");
                    BubbleSort.performBubbleSortPerProperty(bubble, shirts, true);
                    break;
                case 5:
                    System.out.println("TShirts sorted per Property DESC (Size, then Color, then Fabric) with BubbleSort: ");
                    BubbleSort.performBubbleSortPerProperty(bubble, shirts, false);
                    break;
                case 6:
                    System.out.println("Thank you, have a nice Day!");
                    break;
            }
        }
    }

    private void bucketSortMenu() {
        int choice = 0;
        BucketSort bucket = new BucketSort();
        while (choice != 6) {
            System.out.println("Please proceed with one of the following sorting choices: ");
            System.out.println("1. BucketSort by Size.\n2. BucketSort by Color.\n3. BucketSort by Fabric.\n"
                    + "4. BucketSort by Size/Color/Fabric ASC.\n5. BucketSort by Size/Color/Fabric DESC.\n6. Exit.");
            choice = Validator.getValidMenuChoice(6, scan);
            //System.out.println("---------------------");
            switch (choice) {
                case 1:
                    BucketSort.performBucketSortBySize(bucket, shirts);
                    break;
                case 2:
                    BucketSort.performBucketSortByColor(bucket, shirts);
                    break;
                case 3:
                    BucketSort.performBucketSortByFabric(bucket, shirts);
                    break;
                case 4:
                    System.out.println("TShirts sorted per Property ASC (Size, then Color, then Fabric) with BubbleSort: ");
                    BucketSort.performBucketSortPerProperty(bucket, shirts, true);
                    break;
                case 5:
                    System.out.println("TShirts sorted per Property DESC (Size, then Color, then Fabric) with BubbleSort: ");
                    BucketSort.performBucketSortPerProperty(bucket, shirts, false);
                    break;
                case 6:
                    System.out.println("Thank you, have a nice Day!");
                    break;
            }
        }
    }
}
