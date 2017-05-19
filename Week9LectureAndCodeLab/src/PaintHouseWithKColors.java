/**
 * Created by liukx08 on 5/19/2017.
 */
public class PaintHouseWithKColors {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        for(int i = 0; i < costs.length - 1; i ++) {
            int min = 0, min2 = 1;
            if(costs[i][0] > costs[i][1]) {
                min = 1;
                min2 = 0;
            }
            for(int j = 2; j < costs[0].length; j++) {
                if(costs[i][j] < costs[i][min2]) {
                    if(costs[i][j] < costs[i][min]){
                        min2 = min;
                        min = j;
                    } else {
                        min2 = j;
                    }
                }
            }
            for(int j = 0; j < costs[0].length; j++) {
                if(costs[i][j] == costs[i][min]) {
                    costs[i + 1][j] += costs[i][min2];
                } else {
                    costs[i + 1][j] += costs[i][min];
                }
            }
        }
        int res = costs[costs.length - 1][0];
        for(int i = 1; i < costs[0].length; i++) {
            if(costs[costs.length - 1][i] < res) {
                res = costs[costs.length - 1][i];
            }
        }
        return res;
    }
}
