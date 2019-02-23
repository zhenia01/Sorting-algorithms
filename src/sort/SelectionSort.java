package sort;

import java.util.Comparator;

public class SelectionSort implements SortStrategy {
    @Override
    public void sortDec(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index].compareTo(arr[j]) < 0) {
                    index = j;
                }
            }

            if (i != index) {
                Comparable temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    @Override
    public void sortInc(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index].compareTo(arr[j]) > 0) {
                    index = j;
                }
            }

            if (i != index) {
                Comparable temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    @Override
    public void sortDecComp(Object[] arr, Comparator comp) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comp.compare(arr[index], arr[j]) < 0) {
                    index = j;
                }
            }

            if (i != index) {
                Object temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    @Override
    public void sortIncComp(Object[] arr, Comparator comp) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comp.compare(arr[index], arr[j]) > 0) {
                    index = j;
                }
            }

            if (i != index) {
                Object temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }
}
