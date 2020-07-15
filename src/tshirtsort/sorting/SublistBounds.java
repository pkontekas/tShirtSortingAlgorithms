package tshirtsort.sorting;

import java.util.List;
import tshirtsort.models.TShirt;

/**
 * @author pkontekas
 */
public class SublistBounds {

    private int startPosition;
    private int endPosition;

    protected static List<List<TShirt>> getSubListsOfSameSize(boolean sortType, int[] sBySize, List<List<TShirt>> subLists, List<TShirt> shirtsBySize) {
    // boolean sortType, sortType == true, ASC --  sortType == false, DESC
        
        // step 3 - for the perform per property sort methods - Get the ones of the same Size in a sublist
        SublistBounds[] bounds = new SublistBounds[7];
        int counter = 0; // shirts.get(counter) <-- 0 
        if (sortType == true) {//ASC
            for (int i = 0; i < 7; i++) {
                bounds[i] = new SublistBounds();
                if (sBySize[i] == 0) {
                    bounds[i].startPosition = -1;
                    bounds[i].endPosition = -1;
                } else {
                    bounds[i].startPosition = counter; // 0
                    bounds[i].endPosition = counter + sBySize[i] - 1;
                    subLists.add(shirtsBySize.subList(bounds[i].startPosition, bounds[i].endPosition + 1)); // found the error endPosition was exclusive, so we needed endPosition + 1 !
                    //System.out.println(shirtsBySize.subList(bounds[i].startPosition, bounds[i].endPosition+1));
                }
                counter += sBySize[i];
            }
        } else {//DESC
            for (int i = 6; i >= 0; i--) {
                bounds[i] = new SublistBounds();
                if (sBySize[i] == 0) {
                    bounds[i].startPosition = -1;
                    bounds[i].endPosition = -1;
                } else {
                    bounds[i].startPosition = counter; // 0
                    bounds[i].endPosition = counter + sBySize[i] - 1;
                    subLists.add(shirtsBySize.subList(bounds[i].startPosition, bounds[i].endPosition + 1));
                    //System.out.println(shirtsBySize.subList(bounds[i].startPosition, bounds[i].endPosition+1));
                }
                counter += sBySize[i];
            }

        }
        return subLists;
    }
}
