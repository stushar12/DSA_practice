package Arrays;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubArraysWithXORAsK {
    public static void main(String[] args) {
        int []arr = {4, 2, 2, 6, 4};
        int target = 6;
        System.out.println("Count of subArrays with XOR as target is: "+ countSubArrays(arr,target));
    }

    static int countSubArrays(int[]arr,int target){
        int preXOR = 0, count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int j : arr) {
            preXOR = preXOR ^ j;
            count += map.getOrDefault(preXOR ^ target, 0);      /*
            x^target = preXOR;
            doing ^target both sides
            x = preXOR ^ target,
            so we need to find x = (preXOR ^ target) in the hashmap. if it exists, then we can achieve the given target value
            */
            map.put(preXOR, map.getOrDefault(preXOR, 0) + 1);
        }
        return count;
    }
}
