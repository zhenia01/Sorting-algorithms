package sort;

import java.util.Comparator;

public class MergeSort implements SortStrategy {

    private final InsertionSort insert;
    public MergeSort () {
        insert = new InsertionSort();
    }

    @Override
    public void sortDec(Comparable[] arr) {
        mergeSortDec(arr, 0, arr.length - 1);
    }

    @Override
    public void sortInc(Comparable[] arr) {
        mergeSortInc(arr, 0, arr.length - 1);
    }

    @Override
    public void sortDecComp(Object[] arr, Comparator comp) {
        mergeSortDec(arr, 0, arr.length - 1, comp);

    }

    @Override
    public void sortIncComp(Object[] arr, Comparator comp) {
        mergeSortInc(arr, 0, arr.length - 1, comp);
    }

    private void mergeSortInc(Comparable[] arr, int begin, int end) {

        if (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (end - begin <= 7) {
                insert.sortInc(arr);
            } else {
                mergeSortInc(arr, begin, mid);
                mergeSortInc(arr, mid + 1, end);

                mergeInc(arr, begin, mid, end);
            }
        }
    }

    private void mergeInc(Comparable[] arr, int begin, int mid, int end) {
        Comparable[] temp = new Comparable[arr.length];

        for (int i = begin; i <= end; i++) {
            temp[i] = arr[i];
        }

        int leftIndex = begin, rightIndex = mid + 1, globalIndex = begin;

        while (leftIndex <= mid && rightIndex <= end) {
            if (temp[leftIndex].compareTo(temp[rightIndex]) <= 0) {
                arr[globalIndex++] = temp[leftIndex++];
            } else {
                arr[globalIndex++] = temp[rightIndex++];
            }
        }

        if (leftIndex > mid) {
            while (rightIndex <= end) {
                arr[globalIndex++] = temp[rightIndex++];
            }
        } else {
            while (leftIndex <= mid) {
                arr[globalIndex++] = temp[leftIndex++];
            }
        }

    }

    private void mergeSortInc(Object[] arr, int begin, int end, Comparator comp) {

        if (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (end - begin <= 7) {
                insert.sortIncComp(arr, comp);
            } else {
                mergeSortInc(arr, begin, mid, comp);
                mergeSortInc(arr, mid + 1, end, comp);

                mergeInc(arr, begin, mid, end, comp);
            }
        }
    }

    private void mergeInc(Object[] arr, int begin, int mid, int end, Comparator comp) {
        Object[] temp = new Object[arr.length];

        for (int i = begin; i <= end; i++) {
            temp[i] = arr[i];
        }

        int leftIndex = begin, rightIndex = mid + 1, globalIndex = begin;

        while (leftIndex <= mid && rightIndex <= end) {
            if (comp.compare(temp[leftIndex], temp[rightIndex]) <= 0) {
                arr[globalIndex++] = temp[leftIndex++];
            } else {
                arr[globalIndex++] = temp[rightIndex++];
            }
        }

        if (leftIndex > mid) {
            while (rightIndex <= end) {
                arr[globalIndex++] = temp[rightIndex++];
            }
        } else {
            while (leftIndex <= mid) {
                arr[globalIndex++] = temp[leftIndex++];
            }
        }

    }

    private void mergeSortDec(Comparable[] arr, int begin, int end) {

        if (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (end - begin <= 7) {
                insert.sortDec(arr);
            } else {
                mergeSortDec(arr, begin, mid);
                mergeSortDec(arr, mid + 1, end);

                mergeDec(arr, begin, mid, end);
            }
        }
    }

    private void mergeDec(Comparable[] arr, int begin, int mid, int end) {
        Comparable[] temp = new Comparable[arr.length];

        for (int i = begin; i <= end; i++) {
            temp[i] = arr[i];
        }

        int leftIndex = begin, rightIndex = mid + 1, globalIndex = begin;

        while (leftIndex <= mid && rightIndex <= end) {
            if (temp[leftIndex].compareTo(temp[rightIndex]) >= 0) {
                arr[globalIndex++] = temp[leftIndex++];
            } else {
                arr[globalIndex++] = temp[rightIndex++];
            }
        }

        if (leftIndex > mid) {
            while (rightIndex <= end) {
                arr[globalIndex++] = temp[rightIndex++];
            }
        } else {
            while (leftIndex <= mid) {
                arr[globalIndex++] = temp[leftIndex++];
            }
        }

    }

    private void mergeSortDec(Object[] arr, int begin, int end, Comparator comp) {

        if (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (end - begin <= 7) {
                insert.sortDecComp(arr, comp);
            } else {
                mergeSortDec(arr, begin, mid, comp);
                mergeSortDec(arr, mid + 1, end, comp);

                mergeDec(arr, begin, mid, end, comp);
            }
        }
    }

    private void mergeDec(Object[] arr, int begin, int mid, int end, Comparator comp) {
        Object[] temp = new Object[arr.length];

        for (int i = begin; i <= end; i++) {
            temp[i] = arr[i];
        }

        int leftIndex = begin, rightIndex = mid + 1, globalIndex = begin;

        while (leftIndex <= mid && rightIndex <= end) {
            if (comp.compare(temp[leftIndex], temp[rightIndex]) >= 0) {
                arr[globalIndex++] = temp[leftIndex++];
            } else {
                arr[globalIndex++] = temp[rightIndex++];
            }
        }

        if (leftIndex > mid) {
            while (rightIndex <= end) {
                arr[globalIndex++] = temp[rightIndex++];
            }
        } else {
            while (leftIndex <= mid) {
                arr[globalIndex++] = temp[leftIndex++];
            }
        }

    }
}
