package Patterns;

import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int numberOfRows = sc.nextInt();
        System.out.println("Enter number of columns: ");
        int numberOfColumns = sc.nextInt();

        for(int i =0;i<numberOfRows;i++){
            for(int j=0;j<numberOfColumns;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
