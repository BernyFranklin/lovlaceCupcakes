package com.cis055;

public class InsertionSort {
    private static int count = 0;
    public static void main( String[] args )
    {
        String[] array = {"poop", "goop", "loop", "coop", "woop"};
        array = insertionSort(array);

        for(String item: array) {
            System.out.println(item);
        }
        System.out.printf ("\n Total passes: %d", count);
    }
    // insertionSort implements my version of insertion sorting
    public static String[] insertionSort (String[] arr) {
        // Iterate through each item in array
        for (int i = 1; i < arr.length; i++) {
            // If initial index  is less than previous, swap
            if (arr[i].compareTo(arr[i-1]) < 0) {
                // Swap values
                swap(arr, i, (i-1));
                // Enter new loop iterating back
                for (int j = (i-1); j != 0; j--) {
                    if (j == 0)
                        break;
                    else if (arr[j].compareTo(arr[j-1]) < 0) {
                        swap(arr, j, (j-1));
                    }
                    else 
                        break;

                    count++;
                }
            }
        }

        return arr;
    }
    
    // swap swaps places of two indexes in an array
    public static String[] swap (String[] arr, int i, int j) {
        String temp = "";
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }
}
