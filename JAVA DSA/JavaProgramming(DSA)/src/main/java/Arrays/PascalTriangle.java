package Arrays;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 5, row = 5, column = 3;
        type1(row-1, column-1); //  formula is: r-1Nc-1
        type2(n-1); // formula is: n-1Nr-1
//        type3(n);
    }

    static void type1(int row, int column) {
        long total = 1;
        for (int i = 0; i < column; i++) {
            total = total * (row - i);
            total = total / (i + 1);
        }

        System.out.println("Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle. " + total);
    }

    static void type2(int n) {
        long total = 1;
//        System.out.print("Given the row number n. Print the n-th row of Pascal’s triangle. ");
        System.out.print(total + " ");
        for (int i=1; i<= n;i++){
            total = total * (n-i+1);
            total = total / i;
            System.out.print(total+ " ");
        }
    }

    static void type3(int n) {
        System.out.println("Pascal triangle is ");
        for(int i=1;i<=n;i++){
            type2(i-1);
            System.out.println();
        }
    }
}
