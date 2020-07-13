package tshirtsort.sorting;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.MainClass;
import tshirtsort.models.TShirt;
import tshirtsort.utils.Utils;

/**
 * @author pkontekas
 */
public class BucketSort {

    // sortType = true - ASC, false = DESC
    // int sortByProperty 
    // sortByProperty == 1 -- Size
    // sortByProperty == 2 -- Color 
    // sortByProperty == 3 -- Fabric 
    public List<TShirt> sort(List<TShirt> shirts, int maxValue, boolean sortType, int sortByProperty) {
        // Bucket Sort
        List<TShirt> sortedShirts = new ArrayList<>();
        List<TShirt>[] buckets = new ArrayList[maxValue + 1];
        for (int i = 0; i <= maxValue; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i <= maxValue; i++) {
            for (int j = 0; j < shirts.size(); j++) {
                switch (sortByProperty) {
                    case 1: // SIZE
                        if (i == shirts.get(j).getSize().ordinal()) {
                            buckets[i].add(shirts.get(j));
                        }
                        break;
                    case 2: // COLOR
                        if (i == shirts.get(j).getColor().ordinal()) {
                            buckets[i].add(shirts.get(j));
                        }
                        break;
                    case 3: // FABRIC
                        if (i == shirts.get(j).getFabric().ordinal()) {
                            buckets[i].add(shirts.get(j));
                        }
                        break;
                }
            }
        }
        if (sortType == true) {
            for (int i = 0; i <= maxValue; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    sortedShirts.add(buckets[i].get(j));
                }
            }
        } else {
            for (int i = maxValue; i >= 0; i--) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    sortedShirts.add(buckets[i].get(j));
                }
            }
        }
        return sortedShirts;
    }

    public static void performBucketSortBySize(BucketSort bucket, List<TShirt> shirts) {
        bucketSort(bucket, shirts, true, 1); // Size ASC
        bucketSort(bucket, shirts, false, 1); // Size DESC
    }

    public static void performBucketSortByColor(BucketSort bucket, List<TShirt> shirts) {
        bucketSort(bucket, shirts, true, 2); // Color ASC
        bucketSort(bucket, shirts, false, 2); // Color DESC
    }

    public static void performBucketSortByFabric(BucketSort bucket, List<TShirt> shirts) {
        bucketSort(bucket, shirts, true, 3); // Fabric ASC
        bucketSort(bucket, shirts, false, 3); // Fabric DESC
    }

    // bucketSort
    public static void bucketSort(BucketSort bucket, List<TShirt> shirts, boolean sortType, int sortByProperty) {
        // sortType = true - ASC, false = DESC
        // int sortByProperty 
        // sortByProperty == 1 -- Size
        // sortByProperty == 2 -- Color 
        // sortByProperty == 3 -- Fabric 
        System.out.println("/// ---------------------------------- ///");
        double startTime;
        double endTime;
        List<TShirt> sorted_shirts = new ArrayList<>();
        switch (sortByProperty) {
            // Size - 1
            case 1:
                startTime = System.currentTimeMillis();
                sorted_shirts = bucket.sort(shirts, 6, sortType, 1);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for Bucketsort by Size ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for Bucketsort by Size DESC: " + (endTime - startTime));
                }
                break;
            // Color - 2
            case 2:
                startTime = System.currentTimeMillis();
                sorted_shirts = bucket.sort(shirts, 6, sortType, 2);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for Bucketsort by Color ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for Bucketsort by Color DESC: " + (endTime - startTime));
                }
                break;
            // Fabric - 3
            case 3:
                startTime = System.currentTimeMillis();
                sorted_shirts = bucket.sort(shirts, 6, sortType, 3);
                endTime = System.currentTimeMillis();

                if (sortType) {
                    System.out.println("Time Lapsed for Bucketsort by Fabric ASC: " + (endTime - startTime));
                } else {
                    System.out.println("Time Lapsed for Bucketsort by Fabric DESC: " + (endTime - startTime));
                }
                break;
        }
        Utils.printShirtList(sorted_shirts);
    }

    public static void performBucketSortPerProperty(BucketSort bucket, List<TShirt> shirts, boolean sortType) {
        // sortType -> true = ASC, false = DESC

        /*
        1. Make a BUCKETSORT per Size
        2. Find which TShirts have the same Size on the sorted (previous)list
        3. Get the ones of the same Size in a sublist
        4. Make a BUCKETSORT per Color on the previous sublist
        5. Find which TShirts have the same Color on the previous sorted list (from step 4)
        6. Make a BUCKETSORT per Fabric
         */
        List<List<TShirt>> subLists = new ArrayList<>(); // instantiate a List of Lists!
        double startTime;
        double endTime;
        startTime = System.currentTimeMillis();

        // step 1 - Make a BUCKETSORT per Size
        List<TShirt> shirtsBySize = bucket.sort(shirts, 6, sortType, 1);

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
//            System.out.println("Shirt Size " + Size.values()[sizeCounter++] + " bucket count : " + i);
//        }

        // step 3 - Get the ones of the same Size in a sublist
        MainClass.SublistBounds[] bounds = new MainClass.SublistBounds[7];
        int counter = 0; // shirts.get(counter) <-- 0
        if (sortType == true) {//ASC
            for (int i = 0; i < 7; i++) {
                bounds[i] = new MainClass.SublistBounds();
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
                bounds[i] = new MainClass.SublistBounds();
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

        // step 4 - Make a BUCKETSORT per Color on the previous sublist
        List<TShirt> bySizeAndColor = new ArrayList<>();
        for (List<TShirt> tlist : subLists) {
            bySizeAndColor.addAll(bucket.sort(tlist, 6, sortType, 2));
            tlist = bySizeAndColor;
            //System.out.println("Sorted by Size and color: " + tlist.toString());
        }

        //step5&6 my version , find which TShirts have the same Color on the
        //previous sorted list (from step 4) and sort them per Fabric
        List<TShirt> bySizeColorAndFabric = new ArrayList<>();
        List<TShirt> temp = new ArrayList<>();
        int currentSize = 0;
        int currentColor = 0;
        for (TShirt ts : bySizeAndColor) {
            if (ts.getColor().ordinal() == currentColor && ts.getSize().ordinal() == currentSize) {
                //found same tshirt size and color, add to temp list
                temp.add(ts);
            } else {
                //different tshirt, put temp list to bySize and Color and Fabric then empty temp list
                if (temp.size() > 0) {
                    temp = bucket.sort(temp, 6, sortType, 3);
                    bySizeColorAndFabric.addAll(temp);
                    temp.clear();
                }
                temp.add(ts);
                currentSize = ts.getSize().ordinal();
                currentColor = ts.getColor().ordinal();
            }
        }
        if (temp.size() > 0) {
            temp = bucket.sort(temp, 6, sortType, 3);
            bySizeColorAndFabric.addAll(temp);
        }
        endTime = System.currentTimeMillis();
        System.out.println("/// ---------------------------------- ///");
        if (sortType) {
            System.out.println("Time Lapsed for BucketSort per Property ASC: " + (endTime - startTime));
        } else {
            System.out.println("Time Lapsed for BucketSort per Property DESC: " + (endTime - startTime));
        }
        Utils.printShirtList(bySizeColorAndFabric);
    }
}
