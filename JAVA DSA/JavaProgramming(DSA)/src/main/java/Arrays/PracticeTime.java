package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PracticeTime {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix  = new ArrayList<ArrayList<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(5,6,7,8)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(9,10,11,12)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(13,14,15,16)));

        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(0).size();j++){
                if(i<=j){
                    int temp= matrix.get(i).get(j);
                    matrix.get(i).set(j,matrix.get(j).get(i));
                    matrix.get(j).set(i,temp);
                }
            }
        }

    }
}
