/**
 * Created by liukx08 on 5/19/2017.
 */
public class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        int prev = 1, sum = 1, count = 0;
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] < ratings[i - 1]) {
                count++;
            } else {
                if(count != 0) {
                    sum += (1 + count) * count / 2 + Math.max(count + 1 - prev, 0);
                    prev = 1;
                    count = 0;
                }
                if(ratings[i] == ratings[i - 1]) {
                    sum += 1;
                    prev = 1;
                } else {
                    sum += ++prev;
                }
            }
        }
        if(count != 0) {
            sum += (1 + count) * count / 2 + Math.max(count + 1 - prev, 0);
        }
        return sum;
    }
}
