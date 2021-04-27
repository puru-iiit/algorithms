package com.puru.random;

public class LastOccurence {
    public static void main(String[] args) {
        //int arr[] = new int[] {8, 9, 10, 12, 12, 12}; //12
        //int arr[] = new int[] {1, 1, 2, 2, 2, 2, 3}; //2
        int arr[] = new int[]{4, 5, 5, 6, 6, 7, 7, 7, 7, 7, 9, 9}; //7

        int count = new LastOccurence().binarySearchLastOcc(arr, 0, arr.length - 1, 7);
    }
    int binarySearchLastOcc(int[] arr, int start, int end, int x) {
        int low = start;
        int high = end;
        int mid = start;
        boolean isFound = false;
        while (low <= high) {
            mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal < x) {
                low = mid + 1;
            }if(midVal == x) {
                low = mid + 1;
                isFound = true;
            }else if (midVal > x)
                high = mid - 1;
        }
        if (isFound) {
            return high;
        }
        return -1;  // key not found.
    }
}
