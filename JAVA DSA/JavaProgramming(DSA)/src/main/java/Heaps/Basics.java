package Heaps;

import java.util.Arrays;

public class Basics {
    int[] arr = new int[100];
    int size = 0;

    void insertElement(int val) {
        size++;
        int index = size;
        arr[index] = val;
        while (index > 1) {
            int parent = index / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                return;
            }
        }
    }

    void traverse(){
        for(int i=1;i<=size;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Basics obj = new Basics();
        obj.insertElement(10);
        obj.insertElement(5);
        obj.insertElement(15);
        obj.insertElement(50);
        obj.insertElement(20);
        obj.insertElement(25);

        obj.traverse();
    }
}
