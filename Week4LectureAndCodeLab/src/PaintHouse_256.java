/**
 * Created by liukx08 on 4/16/2017.
 *      costs:   R  B  G  ----|
 *               R  B  G  <---|  RB->G, RG->B, BG->R
 *               R  B  G
 *               R  B  G
 *               R  B  G
 *               ......
 */
public class PaintHouse_256 {
    // DP
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int[] curr = new int[]{costs[0][0], costs[0][1], costs[0][2]};
        for(int i = 1; i < costs.length; i++) {
            int[] next = new int[3];
            next[0] = Math.min(curr[1], curr[2]) + costs[i][0];
            next[1] = Math.min(curr[0], curr[2]) + costs[i][1];
            next[2] = Math.min(curr[0], curr[1]) + costs[i][2];
            int[] tmp = next;
            next = curr;
            curr = tmp;
        }
        return Math.min(Math.min(curr[0], curr[1]), curr[2]);
    }
}
