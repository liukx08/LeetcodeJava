import java.util.Arrays;

/**
 * Created by liukx08 on 4/19/2017.
 *
 *      01 pack problem follow-up: what if each item has a quantity of M(i)
 *      induction: f(V) = max(f(N-1, V-k*volume[n]) + k*value[n] | k = 0, 1, ..., M[N])
 *      If we put amount[i] of duplicated item i into items, then the multiple pack problem
 *      is 01 pack problem
 *      O(V sum(amount))
 *
 *      O(V sum(log amount)) time complexity optimization: the amount[i] of duplicated item i
 *      can be divided to log(amount[i]) items, with each item consists of following copies of
 *      item i : 1, 2, 4, 8 ... 2^(k-1), amount[i] - 2^k + 1 satisfying:
 *      1. the total amount is amount[i].
 *      2. each number among 1 ~ amount[i] can be reproduced with the above items set
 *      (binary count)
 *
 *      follow-up 2: feasibility problem, O(VN) solution
 *      f(N, V) represents the most amount of item N left after previous N type of items filling the pack,
 *      0 <= f <= amount[N], -1 means no solution       1. initialization: if(f(i-1,j) >= 0 => Mi, else => -1
 *              Volume: (Mi represents volume[i])       2. induction: from 0 to V, f(i,j) = max(f(i,j),f(i,j-Mi) - 1)
 *              0   1   2   3   4 .. M1 .. V              0   1   2   3 .. M1 .. V
 *     item:  0 0  -1  -1  -1  -1    -1   -1
 *            1 M1 -1  -1  -1  -1    -1   -1 (initial) => M1 -1  -1  -1 . M1-1 ...
 *            2
 *            3
 *            .
 *            .
 *            .
 *
 *
 *      from this follow-up, only consider case 2, for case 1, only the initialization is different
 */
public class MultiplePack {
    // volume, value, and amount of each item
    public int multiplePack(int[] volume, int[] value, int[] amount, int V) {
        int[] res = new int[V + 1];
        for (int j = 0; j < volume.length; j++) {
            // if there are enough item j to fill up pack => complete pack problem
            if(volume[j] * amount[j] >= V) {
                for (int i = volume[j]; i <= V; i++) {
                    res[i] = Math.max(res[i], res[i - volume[j]] + value[j]);
                }
            } else {  // no enough item j, use the above equivalent item set
                int k = 1;
                while(k < amount[j]) {
                    int vol = k * volume[j], val = k * value[j];
                    for(int v = V; v >= vol; v--) {
                        res[v] = Math.max(res[v], res[v - vol] + val);
                    }
                    amount[j] -= k;
                    k = k << 1; // itemj, 2*itemj, 4*itemj ... 2^(k-1)*itemj
                }
                // amount[j] has (amount[j] - 2^k + 1) left
                int vol = amount[j] * volume[j], val = amount[j] * value[j];
                for(int v = V; v >= vol; v--) {
                    res[v] = Math.max(res[v], res[v - vol] + val);
                }
            }
        }
        return res[V];
    }
    // feasibiliti problem
    public boolean multiplePackFeasible(int[] volume, int[] amount, int V) {
        int[] res = new int[V + 1];
        Arrays.fill(res, -1);
        res[0] = 0;
        for (int j = 1; j < volume.length; j++) {
            int[] initial = new int[V + 1];
            for(int i = 0; i <= V; i++) {
                if(res[i] >= 0) {
                    initial[i] = amount[j];
                } else {
                    initial[i] = -1;
                }
            }
            for(int i = 0; i <= V - volume[j]; i++) {
                res[i + volume[j]] = Math.max(res[i] - 1, initial[i + volume[j]]);
            }
        }
        return res[V] == -1 ? false : true;
    }
}
