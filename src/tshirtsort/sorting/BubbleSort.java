package tshirtsort.sorting;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.models.TShirt;
import tshirtsort.utils.Utils;

/**
 * @author pkontekas
 */
public class BubbleSort {

    // boolean sortType, sortType == true, ASC --  sortType == false, DESC
    // int sortByProperty 
    // sortByProperty == 1 -- Size
    // sortByProperty == 2 -- Color 
    // sortByProperty == 3 -- Fabric 
    public List<TShirt> sort(List<TShirt> shirts, boolean sortType, int sortByProperty) {
        int n = shirts.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                switch (sortByProperty) {
                    // Size - 1
                    case 1:
                        // ASC
                        if (sortType) {
                            if (shirts.get(j).getSize().ordinal() > shirts.get(j + 1).getSize().ordinal()) {
                                Utils.swap(shirts, j, j + 1);
                            }
                        } else { // DESC
                            if (shirts.get(j).getSize().ordinal() < shirts.get(j + 1).getSize().ordinal()) {
                                Utils.swap(shirts, j, j + 1);
                            }
                        }
                        break;
                    // Color - 2    
                    case 2:
                        // ASC
                        if (sortType) {
                            if (shirts.get(j).getColor().ordinal() > shirts.get(j + 1).getColor().ordinal()) {
                                Utils.swap(shirts, j, j + 1);
                            }
                        } else { // DESC
                            if (shirts.get(j).getColor().ordinal() < shirts.get(j + 1).getColor().ordinal()) {
                                Utils.swap(shirts, j, j + 1);
                            }
                        }
                        break;
                    // Fabric - 3
                    case 3:
                        // ASC
                        if (sortType) {
                            if (shirts.get(j).getFabric().ordinal() > shirts.get(j + 1).getFabric().ordinal()) {
                                Utils.swap(shirts, j, j + 1);
                            }
                        } else { // DESC
                            if (shirts.get(j).getFabric().ordinal() < shirts.get(j + 1).getFabric().ordinal()) {
                                Utils.swap(shirts, j, j + 1);
                            }
                        }
                        break;
                }
            }
        }
        return shirts;
    }

    // bubbleSort
    private static void bubbleSort(BubbleSort bubbleSort, List<TShirt> shirts, boolean sortType, int sortByProperty) {
        double startTime, endTime;
        switch (sortByProperty) {
            // Size - 1
            case 1:
                startTime = System.currentTimeMillis();
                bubbleSort.sort(shirts, sortType, 1);
                endTime = System.currentTimeMillis();
                if (sortType) {
                    System.out.println("Time Lapsed for Bubblesort by Size ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for Bubblesort by Size DESC: " + (endTime - startTime));
                }
                break;
            // Color - 2
            case 2:
                startTime = System.currentTimeMillis();
                bubbleSort.sort(shirts, sortType, 2);
                endTime = System.currentTimeMillis();
                if (sortType) {
                    System.out.println("Time Lapsed for Bubblesort by Color ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for Bubblesort by Color DESC: " + (endTime - startTime));
                }
                break;
            // Fabric - 3
            case 3:
                startTime = System.currentTimeMillis();
                bubbleSort.sort(shirts, sortType, 3);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for Bubblesort by Fabric ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for Bubblesort by Fabric DESC: " + (endTime - startTime));
                }
                break;
        }
        Utils.printShirtList(shirts);
    }

    public static void performBubbleSortBySize(BubbleSort bubble, List<TShirt> shirts) {
        bubbleSort(bubble, shirts, true, 1); // Size ASC
        bubbleSort(bubble, shirts, false, 1); // Size DESC
    }

    public static void performBubbleSortByColor(BubbleSort bubble, List<TShirt> shirts) {
        bubbleSort(bubble, shirts, true, 2); // Color ASC
        bubbleSort(bubble, shirts, false, 2); // Color DESC
    }

    public static void performBubbleSortByFabric(BubbleSort bubble, List<TShirt> shirts) {
        bubbleSort(bubble, shirts, true, 3); // Fabric ASC
        bubbleSort(bubble, shirts, false, 3); // Fabric DESC
    }

    public static void performBubbleSortPerProperty(BubbleSort bubble, List<TShirt> shirts, boolean sortType) {
        // sortType -> true = ASC, false = DESC

        /*
        1. Make a BUBBLESORT per Size
        2. Find which TShirts have the same Size on the sorted (previous)list
        3. Get the ones of the same Size in a sublist
        4. Make a BUBBLESORT per Color on the previous sublist
        5. Find which TShirts have the same Color on the previous sorted list (from step 4)
        6. Make a BUBBLESORT per Fabric
         */
        List<List<TShirt>> subLists = new ArrayList<>(); // instantiate a List of Lists!
        double startTime, endTime;
        //variables to count time elapsed
        startTime = System.currentTimeMillis();
        
        // step 1 - Make a BUBBLESORT per Size
        List<TShirt> shirtsBySize = bubble.sort(shirts, sortType, 1);

        // step 2 - Find which TShirts have the same Size on the sorted (previous)list
        int[] sBySize = new int[7];
        for (int i = 0; i < 7; i++) {
            sBySize[i] = 0;
        }
        for (TShirt tShirt : shirtsBySize) {
            sBySize[tShirt.getSize().ordinal()]++; //sBySize[0] == 2
        }

        // step 3 - Get the ones of the same Size in a sublist
        subLists = SublistBounds.getSubListsOfSameSize(sortType, sBySize, subLists, shirtsBySize);

        // step 4 - Make a BUBBLESORT per Color on the previous sublist
        List<TShirt> bySizeAndColor = new ArrayList<>();
        for (List<TShirt> tlist : subLists) {
            bySizeAndColor.addAll(bubble.sort(tlist, sortType, 2));
            tlist = bySizeAndColor;
            //System.out.println("Sorted by Size and color: " + tlist.toString());
        }

        //step5&6 my version , find which TShirts have the same Color on the
        //previous sorted list (from step 4) and sort them per Fabric
        List<TShirt> bySizeColorAndFabric = new ArrayList<>();
        List<TShirt> temp = new ArrayList<>();
        int currentSize = 0, currentColor = 0;
        for (TShirt tShirt : bySizeAndColor) {
            if (tShirt.getColor().ordinal() == currentColor && tShirt.getSize().ordinal() == currentSize) {
                //found same tshirt size and color, add to temp list
                temp.add(tShirt);
            } else {
                //different tshirt, put temp list to bySize and Color and Fabric then empty temp list
                if (temp.size() > 0) {
                    temp = bubble.sort(temp, sortType, 3);
                    bySizeColorAndFabric.addAll(temp);
                    temp.clear();
                }
                temp.add(tShirt);
                currentSize = tShirt.getSize().ordinal();
                currentColor = tShirt.getColor().ordinal();
            }
        }
        if (temp.size() > 0) {
            temp = bubble.sort(temp, sortType, 3);
            bySizeColorAndFabric.addAll(temp);
        }
        endTime = System.currentTimeMillis();
        System.out.println("/// ---------------------------------- ///");
        if (sortType) {
            System.out.println("Time Lapsed for Bubblesort per Property ASC: " + (endTime - startTime));
        } else {
            System.out.println("Time Lapsed for Bubblesort per Property DESC: " + (endTime - startTime));
        }
        Utils.printShirtList(bySizeColorAndFabric);
    }
}
