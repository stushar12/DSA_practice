package Sorting;

public class SelectionSorting {
    public static void main(String[] args) {

        int[] arr = {14, 9, 15, 12, 6, 8, 19};
        int n = arr.length;

//        selectionSortingIterative(arr,n);
        selectionSortingRecursive(arr,0,n-1);

        for (int val: arr) {
            System.out.print(val + " ");
        }
    }
    static void swapValues(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void selectionSortingIterative(int[]arr,int n){
        for (int i = 0; i < n-1; i++) {
            int minimumValue = arr[i];
            int indexToBeSwapped = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < minimumValue) {
                    minimumValue = arr[j];
                    indexToBeSwapped = j;
                }
            }
            swapValues(arr,i,indexToBeSwapped);
        }
    }

    static void selectionSortingRecursive(int[]arr,int i,int n){
        if(i==n)
            return;
        int minimumValue = arr[i];
        int indexToBeSwapped = i;
        for (int j = i+1; j < n; j++) {
            if(arr[j] < minimumValue) {
                minimumValue = arr[j];
                indexToBeSwapped = j;
            }
        }
        swapValues(arr,i,indexToBeSwapped);
        selectionSortingRecursive(arr,i+1,n);
    }

    static void abc(int []arr,int n){
        for(int i=0;i<n-1;i++){
            int smallst = arr[i];
            int smallest_pos = i;

            for(int j=i;j<n;j++){
                if(arr[j]<smallst){
                    smallst=arr[j];
                    smallest_pos=j;
                }
            }
    //swap(arr,i,smallest_pos);
        }
    }
}


