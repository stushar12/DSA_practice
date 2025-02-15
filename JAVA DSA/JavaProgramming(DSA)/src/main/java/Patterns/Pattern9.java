package Patterns;

import java.util.Scanner;

public class Pattern9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int numberOfRows = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int numberOfColumns = sc.nextInt();
        int flag;
        for (int i = 0; i < numberOfRows; i++) {
            flag = i % 2 == 0 ? 1 : 0;
            for (int j = 0; j < numberOfColumns; j++) {
                if (i >= j) {
                    System.out.print(flag + " ");
                    flag = flag == 1 ? 0 : 1;
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
