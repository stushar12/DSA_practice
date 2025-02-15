package Arrays;

import java.util.*;

public class TwoSumProblem {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4};
        int n = arr.length;
        int target = 3;
        for (int element : betterMethod(arr,n,target)){
            System.out.print(element+ " ");
        }
        System.out.println();
    }

    static String optimalMethod(int[] arr, int n, int target) {
        int i=0;
        int j=n-1;
        Arrays.sort(arr);
        while(i<j){
            int sum = arr[i]+arr[j];
            if(sum<target){
                i++;
            }
            else if(sum>target){
                j--;
            }
            else
            {
                return "YES";
            }
        }
        return "NO";
    }


    static int[] betterMethod(int[] arr, int n, int target){
        int[] resultArray = new int[2];
        Arrays.fill(resultArray, -1);

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if(map.get(target-arr[i])!= null){
                resultArray[0] = map.get(target-arr[i]);
                resultArray[1] = i;
                return  resultArray;
            }
            map.putIfAbsent(arr[i],i);
        }
        return  resultArray;
    }
}
