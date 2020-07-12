package tshirtsort;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.factories.TShirtFactory;
import tshirtsort.models.TShirt;
import tshirtsort.sorting.BubbleSort;
import tshirtsort.sorting.BucketSort;
import tshirtsort.sorting.QuickSort;

/**
 * @author pkontekas
 */
public class MainClass {

    public static void main(String[] args) {
        TShirtFactory tFactory = new TShirtFactory();
        List<TShirt> shirts = tFactory.tShirtGenerateX(40);
        QuickSort qs = new QuickSort();
        BubbleSort bubble = new BubbleSort();
        BucketSort bucket = new BucketSort();
        System.out.println("Unsorted List : ");
        System.out.println("---------------------");
        for (TShirt shirt : shirts) {
            System.out.println(shirt);
        }
//        QuickSort.performQuickSort(qs, shirts);
//        BubbleSort.performBubbleSort(bubble, shirts);
//        BucketSort.performBucketSort(bucket, shirts);
        System.out.println("---------------------");
        System.out.println("TShirts sorted per Property ASC (Size, then Color, then Fabric) with BucketSort: ");
        BucketSort.performBucketSortPerProperty(bucket, shirts, true);
        System.out.println("---------------------");
        System.out.println("TShirts sorted per Property DESC (Size, then Color, then Fabric) with BucketSort: ");
        BucketSort.performBucketSortPerProperty(bucket, shirts, false);
//        System.out.println("---------------------");
//        System.out.println("TShirts sorted per Property ASC (Size, then Color, then Fabric) with QuickSort: ");
//        QuickSort.performQuickSortPerProperty(qs, shirts, true);
//        System.out.println("---------------------");
//        System.out.println("TShirts sorted per Property DESC (Size, then Color, then Fabric) with QuickSort: ");
//        QuickSort.performQuickSortPerProperty(qs, shirts, false);
//        
//        System.out.println("---------------------");
//        System.out.println("TShirts sorted per Property ASC (Size, then Color, then Fabric) with BubbleSort: ");
//        BubbleSort.performBubbleSortPerProperty(bubble, shirts, true);
//        System.out.println("---------------------");
//        System.out.println("TShirts sorted per Property DESC (Size, then Color, then Fabric) with BubbleSort: ");
//        BubbleSort.performBubbleSortPerProperty(bubble, shirts, false);
    }

    public static class SublistBounds {

        public int start;
        public int end;
    }
}
