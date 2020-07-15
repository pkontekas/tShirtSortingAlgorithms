package tshirtsort.sorting;

import java.util.List;
import tshirtsort.models.TShirt;

/**
 * @author pkontekas
 */
public class SublistBounds {

    private int start;
    private int end;

    protected static List<List<TShirt>> getSubListsOfSameSize(boolean sortType, int[] sBySize, List<List<TShirt>> subLists, List<TShirt> shirtsBySize) {

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
                    subLists.add(shirtsBySize.subList(bounds[i].start, bounds[i].end + 1)); // found the error end was exclusive, so we needed end + 1 !
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
        return subLists;
    }
}
