package Arrays;

import java.util.*;

public class RotateMatrixBy90Degree {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(5,6,7,8)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(9,10,11,12)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(13,14,15,16)));

        System.out.println("Before");
        for (ArrayList<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        System.out.println("After");
        for (ArrayList<Integer> integers : rotateMatrix(matrix, matrix.size(), matrix.get(0).size())) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> rotateMatrix(ArrayList<ArrayList<Integer>> matrix, Integer numberOfRows, Integer numberOfColumns) {
        transposeMatrix(matrix,numberOfRows,numberOfColumns);
//        reverseTransposedMatrixColumnLevel(matrix,numberOfRows,numberOfColumns);    //90 degree clockwise
        reverseTransposedMatrixRowLevel(matrix,numberOfRows,numberOfColumns);       //90 degree anticlockwise
        return matrix;
    }

    static void transposeMatrix(ArrayList<ArrayList<Integer>> matrix, Integer numberOfRows, Integer numberOfColumns) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if(i<=j){
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j,matrix.get(j).get(i));
                matrix.get(j).set(i,temp);
                }
            }
        }
    }

    static void reverseTransposedMatrixColumnLevel(ArrayList<ArrayList<Integer>> matrix, Integer numberOfRows, Integer numberOfColumns) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns/2; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j,matrix.get(i).get(numberOfColumns-j-1));
                matrix.get(i).set(numberOfColumns-j-1,temp);
            }
        }
    }

    static void reverseTransposedMatrixRowLevel(ArrayList<ArrayList<Integer>> matrix, Integer numberOfRows, Integer numberOfColumns) {
        for (int i = 0; i < numberOfRows/2; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j,matrix.get(numberOfRows-i-1).get(j));
                matrix.get(numberOfRows-i-1).set(j,temp);
            }
        }
    }
}
