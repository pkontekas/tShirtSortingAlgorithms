package tshirtsort.sorting;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.models.TShirt;
import tshirtsort.utils.Utils;

/**
 * @author pkontekas
 */
public class QuickSort {

    // low = shirts.get(low), low = 4
    // high = shirts.get(high), high = 0
    // boolean sortType, sortType == true, ASC --  sortType == false, DESC
    // int sortByProperty 
    // sortByProperty == 1 -- Size
    // sortByProperty == 2 -- Color 
    // sortByProperty == 3 -- Fabric 
    public List<TShirt> sort(List<TShirt> shirts, int low, int high, boolean sortType, int sortByProperty) {
        if (low < high) {
            /* pi is partitioning index, shirts[pi] is  
              now at right place */
            int pi = partition(shirts, low, high, sortType, sortByProperty);

            // Recursively sort elements before 
            // partition and after partition 
            sort(shirts, low, pi - 1, sortType, sortByProperty);
            sort(shirts, pi + 1, high, sortType, sortByProperty);
        }
        return shirts;
    }

    // boolean sortType, sortType == true, ASC --  sortType == false, DESC
    // int sortByProperty 
    // sortByProperty == 1 -- Size
    // sortByProperty == 2 -- Color 
    // sortByProperty == 3 -- Fabric 
    int partition(List<TShirt> shirts, int low, int high, boolean sortType, int sortByProperty) {
        TShirt pivot = shirts.get(high);
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot 
            switch (sortByProperty) {
                // Size
                case 1:
                    if (sortType) {
                        if (shirts.get(j).getSize().ordinal() < pivot.getSize().ordinal()) {
                            i++;
                            // swap shirts[i] and shirts[j] 
                            Utils.swap(shirts, i, j);
                        }
                    } else {
                        if (shirts.get(j).getSize().ordinal() > pivot.getSize().ordinal()) {
                            i++;
                            // swap shirts[i] and shirts[j] 
                            Utils.swap(shirts, i, j);
                        }
                    }
                    break;
                // Color
                case 2:
                    if (sortType) {
                        if (shirts.get(j).getColor().ordinal() < pivot.getColor().ordinal()) {
                            i++;
                            // swap shirts[i] and shirts[j] 
                            Utils.swap(shirts, i, j);
                        }
                    } else {
                        if (shirts.get(j).getColor().ordinal() > pivot.getColor().ordinal()) {
                            i++;
                            // swap shirts[i] and shirts[j] 
                            Utils.swap(shirts, i, j);
                        }
                    }
                    break;
                // Fabric
                case 3:
                    if (sortType) {
                        if (shirts.get(j).getFabric().ordinal() < pivot.getFabric().ordinal()) {
                            i++;
                            // swap shirts[i] and shirts[j] 
                            Utils.swap(shirts, i, j);
                        }
                    } else {
                        if (shirts.get(j).getFabric().ordinal() > pivot.getFabric().ordinal()) {
                            i++;
                            // swap shirts[i] and shirts[j] 
                            Utils.swap(shirts, i, j);
                        }
                    }
                    break;
            }
        }
        // swap shirts[i+1] and shirts[high] (or pivot)
        Utils.swap(shirts, i + 1, high);
        return i + 1;
    }

    // quicksort
    private static void quickSort(QuickSort qs, List<TShirt> shirts, boolean sortType, int sortByProperty) {
        System.out.println("/// ---------------------------------- ///");
        double startTime;
        double endTime;
        switch (sortByProperty) {
            // Size - 1
            case 1:
                startTime = System.currentTimeMillis();
                qs.sort(shirts, 0, shirts.size() - 1, sortType, 1);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for Quicksort by Size ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for Quicksort by Size DESC: " + (endTime - startTime));
                }
                break;
            // Color - 2
            case 2:
                startTime = System.currentTimeMillis();
                qs.sort(shirts, 0, shirts.size() - 1, sortType, 2);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for Quicksort by Color ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for Quicksort by Color DESC: " + (endTime - startTime));
                }
                break;
            // Fabric - 3
            case 3:
                startTime = System.currentTimeMillis();
                qs.sort(shirts, 0, shirts.size() - 1, sortType, 3);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for Quicksort by Fabric ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for Quicksort by Fabric DESC: " + (endTime - startTime));
                }
                break;
        }
        Utils.printShirtList(shirts);
    }

    public static void performQuickSortBySize(QuickSort qs, List<TShirt> shirts) {
        quickSort(qs, shirts, true, 1); // Size ASC
        quickSort(qs, shirts, false, 1); // Size DESC
    }

    public static void performQuickSortByColor(QuickSort qs, List<TShirt> shirts) {
        quickSort(qs, shirts, true, 2); // Color ASC
        quickSort(qs, shirts, false, 2); // Color DESC
    }

    public static void performQuickSortByFabric(QuickSort qs, List<TShirt> shirts) {
        quickSort(qs, shirts, true, 3); // Fabric ASC
        quickSort(qs, shirts, false, 3); // Fabric DESC
    }

    public static void performQuickSortPerProperty(QuickSort qs, List<TShirt> shirts, boolean sortType) {
        // sortType -> true = ASC, false = DESC

        /*
        1. Make a qs per Size
        2. Find which TShirts have the same Size on the sorted (previous)list
        3. Get the ones of the same Size in a sublist
        4. Make a qs per Color on the previous sublist
        5. Find which TShirts have the same Color on the previous sorted list (from step 4)
        6. Make a qs per Fabric
         */
        List<List<TShirt>> subLists = new ArrayList<>(); // instantiate a List of Lists!
        double startTime;
        double endTime;
        // step 1 - Make a qs per Size ASC
        startTime = System.currentTimeMillis();
        List<TShirt> shirtsBySize = qs.sort(shirts, 0, shirts.size() - 1, sortType, 1);

        // step 2 - Find which TShirts have the same Size on the sorted (previous)list
        int[] sBySize = new int[7];
        for (int i = 0; i < 7; i++) {
            sBySize[i] = 0;
        }
        for (TShirt tShirt : shirtsBySize) {
            sBySize[tShirt.getSize().ordinal()]++; //sBySize[0] == 2
        }
//        int sizeCounter = 0;
//        for (int i : sBySize) {
//            System.out.println("Shirt Size " + Size.values()[sizeCounter++] + " quicksort count : " + i);
//        }

        // step 3 - Get the ones of the same Size in a sublist
        SublistBounds[] bounds = new SublistBounds[7];
        int counter = 0; // shirts.get(counter) <-- 0 
        if (sortType == true) {//ASC
            for (int i = 0; i < 7; i++) {
                bounds[i] = new SublistBounds();
                if (sBySize[i] == 0) {
                    bounds[i].start = -1;
                    bounds[i].end = -1;
                } else {
                    bounds[i].start = counter; // 0
                    bounds[i].end = counter + sBySize[i] - 1;
                    subLists.add(shirtsBySize.subList(bounds[i].start, bounds[i].end + 1)); // found the error end was exclusive so we needed end + 1 !
                    //System.out.println(shirtsBySize.subList(bounds[i].start, bounds[i].end+1));
                }
                counter += sBySize[i];
            }
        } else {//DESC
            for (int i = 6; i >= 0; i--) {
                bounds[i] = new SublistBounds();
                if (sBySize[i] == 0) {
                    bounds[i].start = -1;
                    bounds[i].end = -1;
                } else {
                    bounds[i].start = counter; // 0
                    bounds[i].end = counter + sBySize[i] - 1;
                    subLists.add(shirtsBySize.subList(bounds[i].start, bounds[i].end + 1));
                    //System.out.println(shirtsBySize.subList(bounds[i].start, bounds[i].end+1));
                }
                counter += sBySize[i];
            }
        }

        // step 4 - Make a qs per Color on the previous sublist
        List<TShirt> bySizeAndColor = new ArrayList<>();
        for (List<TShirt> tlist : subLists) {

            bySizeAndColor.addAll(qs.sort(tlist, 0, tlist.size() - 1, sortType, 2));
            tlist = bySizeAndColor;
            //System.out.println("Sorted by Size and color: " + tlist.toString());
        }

        //step5&6 my version , find which TShirts have the same Color on the
        //previous sorted list (from step 4) and sort them per Fabric
        List<TShirt> bySizeColorAndFabric = new ArrayList<>();
        List<TShirt> temp = new ArrayList<>();
        int currentSize = 0;
        int currentColor = 0;
        for (TShirt tShirt : bySizeAndColor) {
            if (tShirt.getColor().ordinal() == currentColor && tShirt.getSize().ordinal() == currentSize) {
                //found same tshirt size and color, add to temp list
                temp.add(tShirt);
            } else {
                //different tshirt, put temp list to bySizeColorAndFabric List then empty temp list
                if (temp.size() > 0) {
                    temp = qs.sort(temp, 0, temp.size() - 1, sortType, 3);
                    bySizeColorAndFabric.addAll(temp);
                    temp.clear();
                }
                temp.add(tShirt);
                currentSize = tShirt.getSize().ordinal();
                currentColor = tShirt.getColor().ordinal();
            }
        }
        if (temp.size() > 0) {
            temp = qs.sort(temp, 0, temp.size() - 1, sortType, 3);
            bySizeColorAndFabric.addAll(temp);
        }
        endTime = System.currentTimeMillis();
        System.out.println("/// ---------------------------------- ///");
        if (sortType) {
            System.out.println("Time Lapsed for QuickSort per Property ASC: " + (endTime - startTime));
        } else {
            System.out.println("Time Lapsed for QuickSort per Property DESC: " + (endTime - startTime));
        }
        Utils.printShirtList(bySizeColorAndFabric);
    }
}
