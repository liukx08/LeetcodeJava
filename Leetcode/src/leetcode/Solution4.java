package leetcode;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int idxa=0;
        int idxb=0;
        int leftmax,rightmin;
        if(nums1.length>nums2.length){
            int[] tmp=nums1;
            nums1=nums2;
            nums2=tmp;
        }
        int m=nums1.length;
        int n=nums2.length;
        int min=0;
        int max=nums1.length;
        while(min<=max){
        	idxa=(min+max)/2;
        	idxb=(m+n)/2-idxa;
        	if(idxa!=0&&idxa!=m){
        		if(nums1[idxa-1]<=nums2[idxb]&&nums2[idxb-1]<=nums1[idxa])break;
        		else if(nums1[idxa-1]>nums2[idxb])max=idxa-1;
        		else min=idxa+1;
        	}
        	else if(idxa==0){
        		if(nums2[idxb-1]<=nums1[idxa])break;
        		else min=idxa+1;
        	}
        	else {
        		if(nums1[idxa-1]<=nums2[idxb])break;
        		else max=idxa-1;
        	}
        }
        if(idxa==m)rightmin=nums2[idxb];
        else if(idxb==n)rightmin=nums1[idxa];
        else rightmin=nums1[idxa]<=nums2[idxb]?nums1[idxa]:nums2[idxb];
        if ((m+n)%2==1)return rightmin;
        if(idxa==0)leftmax=nums2[idxb-1];
        else if(idxb==0)leftmax=nums1[idxa-1];
        else leftmax=nums1[idxa-1]>=nums2[idxb-1]?nums1[idxa-1]:nums2[idxb-1];
        return (leftmax+rightmin)/2.0;
    }
}
