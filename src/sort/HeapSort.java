package sort;

import java.util.Comparator;

public class HeapSort implements SortStrategy {
    @Override
    public void sortDec(Comparable[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapifyDec(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            Comparable temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapifyDec(arr, i, 0);
        }
    }

    @Override
    public void sortInc(Comparable[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapifyInc(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            Comparable temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapifyInc(arr, i, 0);
        }
    }

    @Override
    public void sortDecComp(Object[] arr, Comparator comp) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapifyDec(arr, arr.length, i, comp);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            Object temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapifyDec(arr, i, 0, comp);
        }
    }

    @Override
    public void sortIncComp(Object[] arr, Comparator comp) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapifyInc(arr, arr.length, i, comp);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            Object temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapifyInc(arr, i, 0, comp);
        }
    }

    private static void heapifyInc(Comparable[] arr, int n, int index) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftIndex < n && arr[leftIndex].compareTo(arr[largestIndex]) > 0) {
            largestIndex = leftIndex;
        }

        if (rightIndex < n && arr[rightIndex].compareTo(arr[largestIndex]) > 0) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            Comparable temp = arr[index];
            arr[index] = arr[largestIndex];
            arr[largestIndex] = temp;
            heapifyInc(arr, n, largestIndex);
        }
    }
    private static void heapifyDec(Comparable[] arr, int n, int index) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftIndex < n && arr[leftIndex].compareTo(arr[largestIndex]) < 0) {
            largestIndex = leftIndex;
        }

        if (rightIndex < n && arr[rightIndex].compareTo(arr[largestIndex]) < 0) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            Comparable temp = arr[index];
            arr[index] = arr[largestIndex];
            arr[largestIndex] = temp;
            heapifyDec(arr, n, largestIndex);
        }
    }

    private static void heapifyInc(Object[] arr, int n, int index, Comparator comp) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftIndex < n && comp.compare(arr[leftIndex], arr[largestIndex]) > 0) {
            largestIndex = leftIndex;
        }

        if (rightIndex < n && comp.compare(arr[rightIndex], arr[largestIndex]) > 0) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            Object temp = arr[index];
            arr[index] = arr[largestIndex];
            arr[largestIndex] = temp;
            heapifyInc(arr, n, largestIndex, comp);
        }
    }


    private static void heapifyDec(Object[] arr, int n, int index, Comparator comp) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftIndex < n && comp.compare(arr[leftIndex], arr[largestIndex]) < 0) {
            largestIndex = leftIndex;
        }

        if (rightIndex < n && comp.compare(arr[rightIndex], arr[largestIndex]) < 0) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            Object temp = arr[index];
            arr[index] = arr[largestIndex];
            arr[largestIndex] = temp;
            heapifyDec(arr, n, largestIndex, comp);
        }
    }
}
