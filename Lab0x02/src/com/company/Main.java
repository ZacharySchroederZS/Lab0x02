package com.company;
import java.util.Arrays;
import java.io.*;
import java.lang.management.*;

public class Main {
    public static void selectionSort(int[] array){
        for (int i = 0; i <array.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[index]){
                    index = j;
                }
            }
            int x = array[index];
            array[index] = array[i];
            array[i] = x;
        }
    }

    public static void mergeSort(int[] input, int start, int end){
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(input, start, mid);
            mergeSort(input, mid + 1, end);
        }
        int i = 0, first = start, last = mid + 1;
        int[] tmp = new int[end - start + 1];
        while (first <= mid && last <= end) {
            tmp[i++] = input[first] < input[last] ? input[first++] : input[last++];
        }
        while (first <= mid) {
            tmp[i++] = input[first++];
        }
        while (last <= end) {
            tmp[i++] = input[last++];
        }
        i = 0;
        while (start <= end) {
            input[start++] = tmp[i++];
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if (arr == null || arr.length == 0){
            return;
        }
        if (low >= high){
            return;
        }
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;

        while (i <= j)
        {
            while (arr[i] < pivot)
            {
                i++;
            }
            while (arr[j] > pivot)
            {
                j--;
            }
            if (i <= j)
            {
                swap (arr, i, j);
                i++;
                j--;
            }
        }
        if (low < j){
            quickSort(arr, low, j);
        }
        if (high > i){
            quickSort(arr, i, high);
        }
    }
    public static void swap (int array[], int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // radix start
    public static int getMax(int arr[] , int n){
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    public static void countSort(int arr[], int n, int exp){
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void radixsort(int arr[], int n){
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        //This eats up the ram
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    public static int binarySearch(int[] array, int key){
        int l = 0, r = array.length -1;
        while (1 <= r){
            int m = l + (r - 1) / 2;
            if (array[m] == key){
                return m;
            }
            if (array[m] < key){
                l = m + 1;
            }
            else{
                r = m - l;
            }
        }
        return -1;
    }
//***********************************************************************************************************************
    public static void main(String[] args) {
        long timeStampBefore = getCpuTime();
        long timeStampAfter = getCpuTime();
        long timeMeasureForNothing = timeStampAfter - timeStampBefore;
        System.out.println(timeMeasureForNothing);

        timeStampBefore = getCpuTime();
        System.out.printf("\tN \t\t\t\t Time\n");
//********** Makes random numbers ********** //
        for (int N = 100; N < 19900000; N += N) {
            timeStampAfter = getCpuTime();
            long timeMeasureForPrintln = timeStampAfter - timeStampBefore;
        int size = N;               // This will make the array any random size
        int[] list = new int[size];
        for (int k = 0; k < size; k++) {
            int n = (int) (Math.random() * 99999 + 1);
            list[k] = n;
            //System.out.println(list[i] + " ");
            //System.out.printf("%d \t %d\n",k, list[k]);
        }


//********** End of makes random numbers ********** //
            //int arr1[] = {5,4,3,2,1};
//********** Selection Sort ********** //
            //  selectionSort(list);//sorting array using selection sort
            //System.out.println("After Selection Sort");
            for (int i : list) {
                //System.out.print(i+", ");
            }
//********** End of Selection Sort ********** //
//********** Merge Sort ********** //
             //mergeSort(list,0,list.length-1);                //uncomment for merge sort
            //System.out.println("\nAfter Merge Sort");
            //System.out.println(Arrays.toString(list));
//********** End of Merge Sort ********** //
//********** Quick Sort ********** //
             //quickSort(list, 0, list.length-1);               //uncomment for quick sort
            //System.out.println("\nAfter Merge Sort");
            //System.out.println(Arrays.toString(list));
//********** End of Quick Sort ********** //
//********** Radix Sort ********** //
            radixsort(list, list.length - 1);               //uncomment for radix sort
           // System.out.println(Arrays.toString(list));
//********** End of Radix Sort ********** //

            int key = 99;

            int result = binarySearch(list, key);
            //System.out.println((result != -1) ? "\nkey: " + key + " found at index: " + result : "\nKey " + key + " not found");





                System.out.printf("%7d \t\t %9d\n",N, timeMeasureForPrintln);

            }
    }
    public static long getCpuTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
                bean.getCurrentThreadCpuTime( ) : 0L;
    }
}
