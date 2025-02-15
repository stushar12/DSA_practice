package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int [] arr = {10, 22, 12, 3, 0, 6};
        for (Integer elem: getLeaders(arr)){
            System.out.print(elem+ " ");
        }


    }

    static List<Integer> getLeaders(int[] arr){
        List<Integer> ans = new ArrayList<>();
        int size = arr.length;
        ans.add(arr[size-1]);   // last element is always the leader

        int max = arr[size-1];

        for(int i = size-1; i>=0;i--){
            if(arr[i]>max){ //maintaining max and if current value is greater than max then it's also a leader
                ans.add(arr[i]);
                max=arr[i]; // update your current leader
            }
        }
        return ans;
    }
}
