package BinarySearch;
import java.util.*;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,1,2,2,4,5,5));
        System.out.println("Single Element is: "+singleNonDuplicate(arrayList));
    }
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        int size = arr.size();

        if(size == 1) return arr.get(0); /*if array is of 1 element*/

        if(!Objects.equals(arr.get(0), arr.get(1))) return  arr.get(0); /*eliminating corner cases*/

        if(!Objects.equals(arr.get(size-1), arr.get(size-2))) return  arr.get(size-1); /*eliminating corner cases*/


        /*reduced our search space by eliminating corner cases so that no need to place if else during
        * main binary search*/

        int low =1;
        int high = size-2;

        while (low<=high){
            int mid = (low+high)/2;

            if(!Objects.equals(arr.get(mid), arr.get(mid - 1)) && !Objects.equals(arr.get(mid),arr.get(mid+1))){
                /* if the arr[mid] element is not equal to left and right then that's the single element */
                return arr.get(mid);
            }

            /*now eliminating search space*/

            if((mid%2)==1 && Objects.equals(arr.get(mid),arr.get(mid-1)) || (mid%2)==0 && Objects.equals(arr.get(mid),arr.get(mid+1)))
                /*mid is at odd position so if it's left half then
            duplicate element will be at even position to maintain even-odd position then we will move to right half or
             if we are at even position and next element which is at odd position is same then also we are maintaining
             even odd pattern, and we are on left half, so we need to move to right half to find the unique element.*/{
                low = mid+1;
            }
            else {
                high = mid-1;
            }

        }

        return -1;
    }
}
