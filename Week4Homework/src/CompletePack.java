import java.util.Arrays;

/**
 * Created by liukx08 on 4/18/2017.
 *
 *      01 pack problem follow-up: what if item can be duplicated
 *      like coin change problem
 *      induction: f(V) = max(f(V-volume[n]) + value[n], f(N, V))
 */
public class CompletePack {
    // case 1: exactly full
    public int completePack(int[] volume, int[] value, int V) {
        int[] res = new int[V + 1];
        Arrays.fill(res, Integer.MIN_VALUE);
        res[0] = 0;
        for(int i = 0; i <= V; i++) {
            if(res[i] == Integer.MIN_VALUE)continue;
            for(int j = 0; j < volume.length; j++) {
                if(i + volume[j] <= V) {
                    res[i + volume[j]] = Math.max(res[i + volume[j]], res[i] + value[j]);
                }
            }
        }
        return res[V]; // Integer.MIN_VALUE indicates no solution
    }
    // case 2: cannot be fully filled
    public int completePack2(int[] volume, int[] value, int V) {
        int[] res = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            for (int j = 0; j < volume.length; j++) {
                if (i + volume[j] <= V) {
                    res[i + volume[j]] = Math.max(res[i + volume[j]], res[i] + value[j]);
                }
            }
        }
        return res[V];
    }

    public static void main(String[] args) {
        CompletePack test = new CompletePack();
        System.out.println(test.completePack(new int[]{2,3,4}, new int[]{5,6,100},5));
        System.out.println(test.completePack2(new int[]{2,3,4}, new int[]{5,6,100},5));
    }
}
