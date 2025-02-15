package Recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionBasics {
    public static void main(String[] args) {
        parameterDeclaration();
    }

    static void parameterDeclaration() {
        int num = 10;
        printNumbersRecursively1toN(num, num);
        System.out.println();
        int secondNum = 1;
        printNumbersRecursivelyNto1(secondNum, num);
        System.out.println();
        System.out.println(sum1toN(num));
        System.out.println(factorial(num));
        int[] arr = {1, 2, 3, 4};
        reverseArray(arr, 0, arr.length);
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
        String str = "NAMAN";
        System.out.println(palindrome(str.toLowerCase(), 0, str.length()));
        System.out.println(fibonacciNumbers(num));

    }

    /**
     * prints numbers from 1 to n
     *
     * @param currentValue
     * @param num
     */
    private static void printNumbersRecursively1toN(int currentValue, int num) {
        if (currentValue <= 0)
            return;
        printNumbersRecursively1toN(currentValue - 1, num);
        System.out.print(currentValue + " ");
    }

    /**
     * print numbers from N to 1
     *
     * @param currentValue
     * @param num
     */
    private static void printNumbersRecursivelyNto1(int currentValue, int num) {
        if (currentValue > num)
            return;
        printNumbersRecursivelyNto1(currentValue + 1, num);
        System.out.print(currentValue + " ");
    }

    /**
     * find sum of numbers from 1 to n
     *
     * @param num
     * @return int
     */
    private static int sum1toN(int num) {
        if (num == 0)
            return 0;
        else
            return num + sum1toN(num - 1);
    }

    /**
     * returns factorial of a number
     *
     * @param num
     * @return int
     */
    private static int factorial(int num) {
        if (num == 0 || num == 1)
            return 1;
        else
            return num * factorial(num - 1);
    }

    /**
     * reverses the array
     *
     * @param arr
     * @param currentIndex
     * @param length
     */
    private static void reverseArray(int[] arr, int currentIndex, int length) {

        if (currentIndex == length / 2) {
            return;
        } else {
            int temp = arr[currentIndex];
            arr[currentIndex] = arr[length - currentIndex - 1];
            arr[length - currentIndex - 1] = temp;
            reverseArray(arr, currentIndex + 1, length);
        }
    }

    /**
     * checks whether the given string is palindrome or not
     *
     * @param str
     * @param currentIndex
     * @param size
     * @return
     */
    private static boolean palindrome(String str, int currentIndex, int size) {
        if (currentIndex > size / 2) {
            return true;
        }
        if (str.charAt(currentIndex) != str.charAt(size - currentIndex - 1)) {
            return false;
        }
        return palindrome(str, currentIndex + 1, size);
    }


    private static int fibonacciNumbers(int num) {
        if (num <= 1) {
            return num;
        }
        return fibonacciNumbers(num - 1) + fibonacciNumbers(num - 2);
    }
}
