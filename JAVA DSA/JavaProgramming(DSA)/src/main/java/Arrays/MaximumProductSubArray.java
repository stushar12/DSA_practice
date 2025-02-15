package Arrays;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, -10, 9, -1};
        int n = arr.length;
        System.out.println("Maximum subArray product is : " + getMaximumProductSubArray(arr, n));
    }

    static int getMaximumProductSubArray(int[] arr, int n) {
        int maxiProd = Integer.MIN_VALUE;
        int prefixProduct = 1;
        int suffixProduct = 1;

        for (int i = 0; i < n; i++) {

            prefixProduct = prefixProduct == 0 ? 1 : prefixProduct;
            suffixProduct = suffixProduct == 0 ? 1 : suffixProduct;

            prefixProduct *= arr[i];
            suffixProduct *= arr[n - i - 1];

            maxiProd = Math.max(maxiProd, Math.max(prefixProduct, suffixProduct));
        }
        return maxiProd;
    }
}
