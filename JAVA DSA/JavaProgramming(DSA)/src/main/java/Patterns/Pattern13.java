package Patterns;

import java.util.Scanner;

public class Pattern13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int numberOfRows = sc.nextInt();

        for (int i = 0; i < numberOfRows; i++) {

            //spaces and left side numbers
            for (int j = 0; j < numberOfRows; j++) {
                if (i + j >= numberOfRows - 1) {
                    System.out.print(numberOfRows - j);
                } else {
                    System.out.print(" ");
                }
            }

//            //right side numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j + 1);
            }

            System.out.println();
        }
    }
}
