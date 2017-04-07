package week3;

/**
 * Created by liukx08 on 4/7/2017.
 */
public class Test {
    public static void main(String[] args){
        test();
    }

    public static void test(){
        SelectionSort test=new SelectionSort();
        int[] nums=new int[]{3,5,1,7,2,8,4,6};
        for (int num1 : nums) System.out.print(num1);
        System.out.println("");
        nums=test.selectionSort(nums);
        for (int num : nums) System.out.print(num);
        System.out.println("");
    }
}
