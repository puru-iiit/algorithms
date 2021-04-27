package com.puru.random;

class Main {
    static int segregate(int arr[], int size) {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive integers
                j++;
            }
        }
        return j;
    }
    static int findMissingPositive(int arr[], int start, int size) {
        if(start==size){
            return 1;
        }
        int i;
        // Mark arr[i] as visited by making arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start from 0 and positive numbers start from 1
        for (i = start; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x <= size && arr[x-1] >= 0)
                arr[x-1] = -arr[i];
        }
        // Return the first index value at which is positive
        for (i = start-1; i < size; i++)
            if (Math.abs(arr[i])!=(i-start+2))
                return i-start + 2; // 1 is added because of indexes
        return size+1;
    }
    static int findMissing(int arr[], int size) {
        // First separate positive and negative numbers
        int shift = segregate(arr, size);
        return findMissingPositive(arr,shift, size);
    }
    public static void main(String[] args) {
        //int arr[] = {0 ,1, 2 ,3 ,4 ,5, 6, 7 ,8 ,9, 10, 11, 12};
        //int arr[] = {28, 7, -36, 21, -21 ,-50, 9, -32};
       /* int arr[] = {37, 6 ,-7 ,41 ,-23 ,15, 9 ,-14, -18, 1, -13, -22, 25, -43, 24};
        int arr_size = arr.length;
        int missing = findMissing(arr, arr_size);
        System.out.println("The smallest positive missing number is " + missing);*/

        String str = "geksfor";

        System.out.println("Str " + removeDuplicates(str));
    }

    public static String removeDuplicates(String str) {
        char[] sArray = str.toCharArray();
        boolean[] dArray = new boolean[256];
        //Map<Character, Boolean> map = new HashMap<>();
        int j=0;
        for(int i=0;i<str.length();i++){
            if(!dArray[sArray[i]-'A']){
                dArray[sArray[i]-'A']=true;
                sArray[j++] = sArray[i];
            }
        }
        return new String(sArray,0,j);
    }

}