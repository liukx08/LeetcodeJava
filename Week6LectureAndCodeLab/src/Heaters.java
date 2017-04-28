import java.util.Arrays;

/**
 * Created by liukx08 on 4/28/2017.
 *
 *          n   n   n   n   n   n   n   n   n   n   n
 *                      H       H   H           H
 *                  |   |           |   |
 *                  |           |       |       |
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        if(houses == null || heaters == null || houses.length == 0 || heaters.length == 0) {
            return 0;
        }
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int idxHouse = 0, idxHeater = 0;
        int radius = 0;
        while(idxHouse < houses.length) {
            while(idxHeater < heaters.length - 1 && houses[idxHouse] - heaters[idxHeater] > heaters[idxHeater + 1] - houses[idxHouse]) {
                idxHeater++;
            }
            radius = Math.max(radius, Math.abs(houses[idxHouse++] - heaters[idxHeater]));
        }
        return radius;
    }
}
