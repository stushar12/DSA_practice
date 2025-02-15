package Patterns;

import java.util.Scanner;

public class Pattern14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int numberOfRows = sc.nextInt();

        //upper half
        for (int i = 0; i < numberOfRows; i++) {

            //first half
            for (int j = 0; j < numberOfRows; j++) {
                if (i + j >= numberOfRows - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int j = 0; j < i; j++) {
                    System.out.print("*");
            }
            System.out.println();
        }

        //lower half
        for (int i = numberOfRows-1 ; i >= 0; i--) {

            //first half
            for (int j = 0; j < numberOfRows; j++) {
                if (i + j >= numberOfRows - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
