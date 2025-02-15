package Arrays;

import java.util.ArrayList;

public class RearrangePositiveNegativesElementsAlternate {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, -1, -2, -3, -4};

        variation2();

        for (int elem : rearrangeArrayInAlternatingFashion(arr)) {
            System.out.print(elem + " ");
        }
    }

    // variation1 (when equal number of positive and negatives are there)
    static int[] rearrangeArrayInAlternatingFashion(int[] arr) {
        int n = arr.length;
        int[] resArr = new int[n];

        int posInd = 0;
        int negInd = 1;
        for (int j : arr) {
            if (j >= 0) {
                if (posInd < n)
                    resArr[posInd] = j;
                posInd += 2;
            } else {
                if (negInd < n)
                    resArr[negInd] = j;
                negInd += 2;
            }
        }

        return resArr;
    }

    // variation2 (when unequal number of positive and negatives are there)

    static void variation2() {
        int[] arr = {1, 2, -4, 5, 2, 3, 1, 3};

        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();
        ArrayList<Integer> resList = new ArrayList<>();

        for (int j : arr) {
            if (j >= 0) {
                posList.add(j);
            } else {
                negList.add(j);
            }
        }

        if (posList.size() > negList.size()) {  /*if negative length arraylist is smaller than than the positive
        length */

            //till equal number of positives and negatives are there
            for (int i = 0; i < negList.size(); i++) {
                resList.add(2 * i, posList.get(i));
                resList.add(2 * i + 1, negList.get(i));
            }

            int index = 2 * negList.size();

            for (int i = negList.size(); i < posList.size(); i++) {     /*copy remaining elements of positive array*/
                resList.add(index, posList.get(i));
                index++;
            }
        } else {
            //till equal number of positives and negatives are there
            for (int i = 0; i < posList.size(); i++) {
                resList.add(2 * i, posList.get(i));
                resList.add(2 * i + 1, negList.get(i));
            }

            int index = 2 * posList.size();

            for (int i = posList.size(); i < negList.size(); i++) {  /*copy remaining elements of negative array*/
                resList.add(index, negList.get(i));
                index++;
            }
        }

        System.out.println(resList);
    }
}
