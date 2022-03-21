package com.ModifiedBinarySearch;

class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}

public class SearchInaSortedInfiniteArray {

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30});
        System.out.println(SearchInaSortedInfiniteArray.search(reader, 11));
        reader = new ArrayReader(new int[]{1, 3, 8, 10, 15});
        System.out.println(SearchInaSortedInfiniteArray.search(reader, 15));
        System.out.println(SearchInaSortedInfiniteArray.search(reader, 200));

    }

    public static int search(ArrayReader reader, int key) {
        // TODO: Write your code here
        int start = 0;
        int end = 0;
        //let figure out start and end

        while (key > reader.get(end)) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(reader, key, start, end);

    }

    public static int binarySearch(ArrayReader reader, int key, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < reader.get(mid))
                end = mid - 1;
            else if (key > reader.get(mid))
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }


}
