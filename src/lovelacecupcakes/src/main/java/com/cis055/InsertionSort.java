package com.cis055;

// Using json editing library
import org.json.simple.*;

// Start class
public class InsertionSort {
    private static int count = 0;
    public static void main( String[] args ) {

        // 3 different files available. Uncomment to use.
        String fileName =
        // "/Users/frankbernal/Documents/GitHub/sjccFall22/lovlaceCupcakes/src/lovelacecupcakes/src/main/java/com/cis055/cupcake_3906.json";
         "/Users/frankbernal/Documents/GitHub/sjccFall22/lovlaceCupcakes/src/lovelacecupcakes/src/main/java/com/cis055/cupcake_test_10.json";
        // "/Users/frankbernal/Documents/GitHub/sjccFall22/lovlaceCupcakes/src/lovelacecupcakes/src/main/java/com/cis055/cupcake_test_5.json";

        // read cupcake names
        JSONArray cupcakeArray = JSONFile.readArray(fileName);
        String[] cupcakeNameArray = nameArray(cupcakeArray);
        System.out.println(cupcakeNameArray);

        // print unsorted list
        System.out.println("----- Unsorted array -----");
        print(cupcakeNameArray);

        // sort
        insertionSort(cupcakeNameArray);

        // print sorted list
        System.out.println("----- Sorted array----- ");
        print(cupcakeNameArray);

        // print statistics
        System.out.println("----- Statistics -----");
        System.out.printf("Size of array = %d\n", cupcakeNameArray.length);
        System.out.printf("Count = %d\n", count);
    }

    // print cupcake array
    public static void print(String[] cupcakeNameArray) {
        System.out.printf("Number\tName\n");
        System.out.printf("------\t---------------\n");
        for (int i = 0; i < cupcakeNameArray.length; i++) {
        System.out.printf("%04d\t%s\n", i, cupcakeNameArray[i]);
        }
    }

    // get array of cupcake names
    public static String[] nameArray(JSONArray cupcakeArray) {
        String[] arr = new String[cupcakeArray.size()];

        // get names from json object
        for (int i = 0; i < cupcakeArray.size(); i++) {
        JSONObject o = (JSONObject) cupcakeArray.get(i);
        String name = (String) o.get("name");
        arr[i] = name;
        }
        return arr;
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
                    count++;
                    if (j == 0)
                        break;
                    else if (arr[j].compareTo(arr[j-1]) < 0) {
                        swap(arr, j, (j-1));
                    }
                    else 
                        break;
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
