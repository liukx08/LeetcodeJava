package week1;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0)return;
        while(m>0&&n>0){
            if(nums1[m-1]>nums2[n-1]){
                nums1[m+n-1]=nums1[m-1];
                m--;
            } else {
                nums1[m+n-1]=nums2[n-1];
                n--;
            }
        }
        for(int i=n-1;i>=0;i--){
            nums1[i]=nums2[i];
        }
    }
}
