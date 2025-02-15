package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestZeroSumSubArray {
    public static void main(String[] args) {
        int[] arr = {6, -2, 2, -8, 1, 7, 4, -10};
        System.out.println("Length of longest subArray with sum 0 : " + getLongestZeroSumSubArrayLength(arr));
    }

    public static int getLongestZeroSumSubArrayLength(int []arr){
        Map<Integer,Integer> map =new HashMap<>();
        int maxLength = 0;
        int sum =0;
        int k = 0; /* so the problem is same as longest subArray with sum k but here k is 0*/

        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum == 0){
                maxLength = Math.max(maxLength, i+1);
            }
            else if(map.get(sum-k)!=null){
                maxLength = Math.max(maxLength, i-map.get(sum));
            }
            map.putIfAbsent(sum, i);    /*no need to update index because here we want longest subArray not the count of subArrays with sum 0*/
        }

        return maxLength;
    }

}
