package sort;

import java.util.Comparator;

public class InsertionSort implements SortStrategy {
    @Override
    public void sortDec(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;

            while (j != 0 && arr[j].compareTo(arr[j - 1]) > 0) {
                Comparable temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }

    @Override
    public void sortInc(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;

            while (j != 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                Comparable temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }

    @Override
    public void sortDecComp(Object[] arr, Comparator comp) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;

            while (j != 0 && comp.compare(arr[j], arr[j - 1]) > 0) {
                Object temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }

    @Override
    public void sortIncComp(Object[] arr, Comparator comp) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;

            while (j != 0 && comp.compare(arr[j], arr[j - 1]) < 0) {
                Object temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }
}
