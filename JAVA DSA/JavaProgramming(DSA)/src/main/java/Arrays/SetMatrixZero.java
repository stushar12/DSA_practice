package Arrays;

import java.util.*;

public class SetMatrixZero {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(6, 5, 1, 6, 8)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(2, 8, 0, 7, 5)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(4, 4, 0, 6, 2)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(9, 6, 3, 7, 5)));

        System.out.println("Before");
        for (ArrayList<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        System.out.println("After");
        for (ArrayList<Integer> integers : zeroMatrix(matrix, matrix.size(), matrix.get(0).size())) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer numberOfRows, Integer numberOfColumns) {

        int[] rows = new int[numberOfRows];
        int[] columns = new int[numberOfColumns];

        Arrays.fill(rows, 0);
        Arrays.fill(columns, 0);

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (matrix.get(i).get(j) == 0) {
                    rows[i] = Integer.MAX_VALUE;
                    columns[j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (rows[i] == Integer.MAX_VALUE || columns[j] == Integer.MAX_VALUE) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

    static ArrayList<ArrayList<Integer>> zeroMatrixOptimalSolution(ArrayList<ArrayList<Integer>> matrix, Integer numberOfRows, Integer numberOfColumns) {

        int col0 = 1;
        for (int i = 0; i < numberOfRows; i++) {                /*marking 1st row except (0,0) for all columns */

            for (int j = 0; j < numberOfColumns; j++) {         /*marking 1st column for all the rows*/
                if (matrix.get(i).get(j) == 0) {
                    matrix.get(i).set(0, 0);
                    if (j != 0) {
                        matrix.get(0).set(j, 0);
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < numberOfRows; i++) {        /*// Step 2: Mark with 0 from (1,1) to (n-1, m-1):*/
            for (int j = 1; j < numberOfColumns; j++) {
                if (matrix.get(i).get(j) != 0) {
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        //step 3: Finally mark the 1st col & then 1st row:
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < numberOfColumns; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < numberOfRows; i++) {
                matrix.get(i).set(0, 0);
            }
        }


        return matrix;
    }
}

/*
6 5 1 6 8
2 8 0 7 5
4 4 0 6 2
9 6 3 7 5
*/


/*
6 5 0 6 8
0 0 0 0 0
0 0 0 0 0
9 6 0 7 5
*/