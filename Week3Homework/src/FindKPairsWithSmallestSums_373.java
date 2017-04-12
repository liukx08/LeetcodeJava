import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by liukx08 on 4/11/2017.
 */
public class FindKPairsWithSmallestSums_373 {
    // the same as 378
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m=nums1.length,n=nums2.length;
        List<int[]> res=new ArrayList<>();
        if(m==0||n==0||k==0)return res;
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        for(int i=0;i<m;i++){
            minHeap.offer(new int[]{nums1[i],nums2[0],0});
        }
        for(int i=0;i<k&&!minHeap.isEmpty();i++){
            int[] tmp=minHeap.poll();
            res.add(new int[]{tmp[0],tmp[1]});
            if(tmp[2]<n-1)minHeap.offer(new int[]{tmp[0],nums2[tmp[2]+1],tmp[2]+1});
        }
        return res;
    }
}
