package sort;

import java.util.Comparator;

public class InsertionSort implements SortStrategy {
    @Override
    public void sortDec(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) > 0; j--) {
                Comparable temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    @Override
    public void sortInc(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
                Comparable temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    @Override
    public void sortDecComp(Object[] arr, Comparator comp) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && comp.compare(arr[j], arr[j-1]) > 0; j--) {
                Object temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    @Override
    public void sortIncComp(Object[] arr, Comparator comp) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && comp.compare(arr[j], arr[j-1]) < 0; j--) {
                Object temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }
}
