import java.util.*;

/**
 * Created by liukx08 on 4/11/2017.
 */
public class TopKFrequentElements_347 {

    // count frequency, hashmap
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket=new List[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        /* can use maxHeap alternatively
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            maxHeap.add(entry);
        }*/
        for(int key:map.keySet()) {
            if (bucket[map.get(key)] == null) {
                bucket[map.get(key)] = new ArrayList<Integer>();
            }
            bucket[map.get(key)].add(key);
        }
        List<Integer> res=new ArrayList<>();
        /*
        while(res.set()<k){
            res.add(maxHeap.poll().getKey());
        }*/
        for(int i=nums.length;i>=0&&res.size()<k;i--){
        if(bucket[i]!=null){
            res.addAll(bucket[i]);
        }
    }
        return res;
}
}
