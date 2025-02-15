package Arrays;

import java.util.*;

public class SpiralTraversalOfMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(9, 10, 11, 12)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(13, 14, 15, 16)));
        System.out.println("Spiral traversal");
        spiralTraversal(matrix, matrix.size(), matrix.get(0).size());
    }

    static void spiralTraversal(ArrayList<ArrayList<Integer>> matrix, int numberOfRows, int numberOfColumns) {
        int top = 0, bottom = numberOfRows - 1, right = numberOfColumns - 1, left = 0;
        while (top <= bottom && left <= right) {

            // from left to right

            for (int i = left; i <= right; i++) {
                System.out.print(matrix.get(top).get(i) + " ");
            }
            top++;


            //from top to bottom

            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix.get(i).get(right) + " ");
            }
            right--;

            // from bottom right to left

            if (top <= bottom) {    // check for single row array
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix.get(bottom).get(i) + " ");
                }
                bottom--;
            }

            // from bottom to top

            if (left <= right) {    //check for single column array
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix.get(i).get(left) + " ");
                }
                left++;
            }
        }
    }
}
