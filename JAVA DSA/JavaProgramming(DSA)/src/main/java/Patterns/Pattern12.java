package Patterns;

import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int numberOfRows = sc.nextInt();

        for (int i = 0; i < numberOfRows; i++) {

            //spaces
            for (int j = 0; j < numberOfRows - i - 1; j++) {
                System.out.print(" ");
            }

            //value
            for (int j = 0; j <= i; j++) {
                System.out.print(i + 1 + " ");
            }

            System.out.println();
        }
    }
}
