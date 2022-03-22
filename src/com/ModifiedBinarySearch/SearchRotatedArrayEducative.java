package com.ModifiedBinarySearch;

class SearchRotatedArrayEducative {

    public static int search(int[] arr, int key) { //15
        // TODO: Write your code here
        //10,15, 1, 3, 8
        //s      m     e

        //4, 5, 7, 9, 10, -1, 2
        //s        m           e

        int start = 0;
        int end = arr.length-1;

        while(start <= end){

            int mid = start + (end-start)/2;

            if(arr[mid] == key)
                return mid;
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                start++;
                end--;
            }

            if(arr[start] <= arr[mid]){
                if(key >= arr[start] && key < arr[mid])
                    end = mid -1;
                else
                    start = mid + 1;
            }
            else{                               //(arr[start] > arr[mid])
                if(key > arr[mid] && key <= arr[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchRotatedArrayEducative.search(new int[] { 3,7,3,3,3 }, 7));
        System.out.println(SearchRotatedArrayEducative.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }
}
