package Arrays;

import java.util.Arrays;

public class Merge2SortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        long[] arr1 = {1, 4, 5, 7};
        long[] arr2 = {2, 3, 6};
        optimalSolution2(arr1, arr2);

    }

    static void optimalSolution1(long[] arr1, long[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;

        int left = length1 - 1, right = 0;

        while (left >= 0 && right < length2) {
            if (arr1[left] > arr2[right]) {
                swapValues(arr1, left, arr2, right);
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        displayArray(arr1);
        displayArray(arr2);
    }

    static void swapValues(long[] arr1, int left, long[] arr2, int right) {
        long temp = arr1[left];
        arr1[left] = arr2[right];
        arr2[right] = temp;
    }

    static void displayArray(long[] arr) {
        for (long elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    static void optimalSolution2(long[] arr1, long[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;

        int totalLength = length1 + length2;
        int gap = (totalLength / 2) + (totalLength % 2);    /*always find the Math.ceil() value for gap*/

        while (gap > 0) {
            // initialize left and right pointers
            int left = 0;
            int right = left + gap;

            while (right < totalLength) {
                // left pointer on arr1 and right pointer on arr2
                if (left < length1 && right >= length1) {
                    compareBeforeSwapping(arr1, left, arr2, right - length1);
                }

                // both pointer in arr2
                else if (left >= length1) {
                    compareBeforeSwapping(arr2, left - length1, arr2, right - length1);
                }

                //both pointer in arr1
                else {
                    compareBeforeSwapping(arr1, left, arr1, right);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }

        displayArray(arr1);
        displayArray(arr2);
    }

    static void compareBeforeSwapping(long[] arr1, int index1, long[] arr2, int index2) {
        if (arr1[index1] > arr2[index2]) {
            long temp = arr1[index1];
            arr1[index1] = arr2[index2];
            arr2[index2] = temp;
        }
    }
}
