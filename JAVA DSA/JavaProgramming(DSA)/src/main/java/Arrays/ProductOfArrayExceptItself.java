package Arrays;

public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        int[] arr = {1993232,2993323,3933239,49931212};
        for (int elem : getProductArrayExceptSelf(arr)) {
            System.out.print(elem + " ");
        }
    }

    /*
    https://www.codingninjas.com/studio/problems/product-of-array-except-self_630271?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=PROBLEM&customSource=studio_nav
    * */
    public static int[] getProductArrayExceptSelf(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        if (n == 0)
            return res;
        if (n == 1) {
            res[0] = 1;
            return res;
        }
        int mod = 1000000007;

        res[0] = (arr[0]%mod);
        for (int i = 1; i < n; i++) {   /*left cumulative product calculation and storing in
        result array */
            res[i] = multiply(res[i-1], arr[i]);
        }

        int rightCumulativeProduct = 1;
        res[n - 1] = multiply(rightCumulativeProduct , res[n - 2]);
        rightCumulativeProduct = arr[n - 1];
        for (int i = n - 2; i > 0; i--) {
            res[i] =  multiply(res[i - 1] , rightCumulativeProduct);/*left cumulative product * right cumulative product*/
            rightCumulativeProduct = multiply(rightCumulativeProduct,arr[i]); /*update right cumulative product*/
        }
        res[0] = rightCumulativeProduct;
        return res;
    }

    public static int multiply(int a, int b){
        int mod = 1000000007;
        long res = (a%mod);
        res*=(b%mod);
        res = (res%mod);
        return (int)res;
    }


}
