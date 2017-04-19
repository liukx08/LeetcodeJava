/**
 * Created by liukx08 on 4/18/2017.
 *
 *          01 pack problem:
 *          N items with volume[i] and value[i] for i th item
 *          For a pack with volume V, what's the largest value this pack can load?
 *          Case 1: If the pack has to be just full (exactly V items loaded).
 *          Case 2: Not has to be full.
 *
 *          Induction: f(N, V) refers to the solution of N items filling V volume pack
 *                     1. item[N] in the pack: f(N-1, V-volume[N]) + value[N]
 *                     2. item[N] not in the pack: f(N-1, V)
 *                     Thus, f(N, V) = max(f(N-1, V-volume[N]) + value[N], f(N-1, V));
 *
 *           Volume:                    Initialization:
 *           0   1   2   3   4 ... V    case 1: 0    1    2    3    4 ... V         case 2: 0  1  2 ... V
 *  item:  0                                  0 0  -INF -INF -INF -INF  -INF             0: 0  0  0 ... 0
 *         1
 *         2       f(2,2)                0 volume pack is just fully filled         each V volume pack can
 *         3                             by an item with volume 0, total value      be filled with 0 volume
 *         .                             is 0. Other volume pack cannot be          item with total value
 *         .                             filled with 0 volume item, total value     of 0.
 *         .                             is minus infinity (no valid solution)
 *         N
 *
 *         Optimize space complexity: original O(NV)
 *         Since n is induced from n - 1, it can only keep one row.
 *         Since v is induced from v - volume[N] and v, those solutions > v are no longer needed.
 *         It can update solution from V to 0, and store results in the original row.
 */
public class Pack01 {
    // case 1:
    public int packFull(int[] volume, int[] value, int V) {
        int[] max = new int[V + 1];
        for(int i = 1; i <= volume.length; i++) {
            max[i] = Integer.MIN_VALUE;
        }
        for(int i = 0; i < volume.length; i++) {
            for(int v = V; v >= volume[i]; v--) {
                max[v] = Math.max(max[v], max[v - volume[i]] + value[i]);
                if(max[v] < 0) {
                    max[v] = Integer.MIN_VALUE;
                }
            }
        }
        return max[V] == Integer.MIN_VALUE ? 0 : max[V];
    }
    // cass 2:
    public int pack(int[] volume, int[] value, int V) {
        int[] max = new int[V + 1];
        for(int i = 0; i < volume.length; i++) {
            for(int v = V; v >= volume[i]; v--) {
                max[v] = Math.max(max[v], max[v - volume[i]] + value[i]);
            }
        }
        return max[V];
    }

    public static void main(String[] args) {
        Pack01 test = new Pack01();
        System.out.println(test.pack(new int[]{1,2,3},new int[]{11,10,20},5));
        System.out.println(test.packFull(new int[]{1,2,3},new int[]{11,10,20},5));
    }
}
