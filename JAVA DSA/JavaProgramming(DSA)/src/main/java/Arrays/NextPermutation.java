package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,2, 1, 5, 4, 3, 0, 0);

        for (Integer elem: nextGreaterPermutation(list)){
            System.out.print(elem+ " ");
        }
    }

    public static ArrayList< Integer > nextGreaterPermutation(ArrayList< Integer > arr) {
        // find the break-point where array starts decreasing
        int index =-1, size = arr.size();

        for (int i = size-2; i >=0 ; i--) {
            if(arr.get(i)<arr.get(i+1)){
                index = i;
                break;
            }
        }

        // handle corner case if array is already at the last permutation return the very first permutation
        if(index ==-1){
            Collections.reverse(arr);
            return arr;
        }

        // find just bigger element than your breakpoint element from back

        for (int i = size-1; i >=0 ; i--) {
            if(arr.get(i)>arr.get(index)){
                Collections.swap(arr,i,index);
                break;
            }
        }

        //form next permutation

        swapElementsWithinRange(arr,index+1,size-1);

        return arr;
    }

    static void swapElementsWithinRange(List<Integer> arr, int start, int end){
        while(start<=end){
            int temp = arr.get(start);
            arr.set(start,arr.get(end));
            arr.set(end,temp);
            start++;
            end--;
        }
    }
}
