package Patterns;

import java.util.Scanner;

public class Pattern11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int numberOfRows = sc.nextInt();

        for (int i = 0; i < numberOfRows; i++) {

            //print spaces
            for (int j = 0; j < numberOfRows-i-1; j++) {
                System.out.print(" ");
            }

            //print stars
            for (int j = 0; j < numberOfRows; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
