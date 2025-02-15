package Arrays;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int [] arr = {0,0,0,0,0,1};

        int currentCounter = 0;
        int onesCounter =0;
        for (int j : arr) {
            if (j == 1) {
                currentCounter++;
            } else {
                onesCounter = Math.max(onesCounter, currentCounter);
                currentCounter = 0;
            }
        }

        System.out.println("Maximum Consecutive ones: "+ Math.max(onesCounter,currentCounter));
    }
}
