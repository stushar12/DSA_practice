package Arrays;

public class MajorityElementInAnArray {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 4, 2, 2, 4, 3, 2, 2};
        /*
         which means if (>n/2) needed then only one majority element can be present in the array for eg. array length is 10 so for majority element
         to happen minimum 6 occurrence needs to be there then we are left with 4 elements which can't form majority element.
        */


        int n = arr.length;

        int majorityElement = arr[0];
        int count = 0;

        for (int j : arr) {

            if (count == 0) {
                majorityElement = j;
                count = 1;
            } else if (majorityElement == j) {
                count++;
            } else {
                count--;
            }

        }

        count = 0;
        for (int j : arr) {
            if (j == majorityElement) {
                count++;
            }
        }

        if (count > n / 2)
            System.out.println("Majority Element is: " + majorityElement);
        else
            System.out.println("No Majority element.");
    }
}
