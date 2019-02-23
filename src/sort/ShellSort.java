package sort;

import java.util.Comparator;

public class ShellSort implements SortStrategy {

    private void insertionStepsSortInc(Comparable[] arr, int start, int h) {
        for (int i = start; i < arr.length; i += h) {
            int j = i;

            while (j >= h && arr[j].compareTo(arr[j - h]) < 0) {
                Comparable temp = arr[j - h];
                arr[j - h] = arr[j];
                arr[j] = temp;

                j -= h;
            }
        }

    }

    private void insertionStepsSortDec(Comparable[] arr, int start, int h) {
        for (int i = start; i < arr.length; i += h) {
            int j = i;

            while (j >= h && arr[j].compareTo(arr[j - h]) > 0) {
                Comparable temp = arr[j - h];
                arr[j - h] = arr[j];
                arr[j] = temp;

                j -= h;
            }
        }

    }

    private static void insertionStepsSortInc(Object[] arr, Comparator comp, int start, int h) {
        for (int i = start; i < arr.length; i += h) {
            int j = i;

            while (j >= h && comp.compare(arr[j], arr[j - h]) < 0) {
                Object temp = arr[j - h];
                arr[j - h] = arr[j];
                arr[j] = temp;

                j -= h;
            }
        }
    }

    private static void insertionStepsSortDec(Object[] arr, Comparator comp, int start, int h) {
        for (int i = start; i < arr.length; i += h) {
            int j = i;

            while (j >= h && comp.compare(arr[j], arr[j - h]) > 0) {
                Object temp = arr[j - h];
                arr[j - h] = arr[j];
                arr[j] = temp;

                j -= h;
            }
        }
    }

    @Override
    public void sortDec(Comparable[] arr) {
        int h = 1;
        while (h < (arr.length / 3)) {
            h = 3 * h + 1;
        }

        while (h >= 1) {

            for (int i = 0; i < h; i++) {
                insertionStepsSortDec(arr, i, h);
            }

            h = h / 3;
        }
    }

    @Override
    public void sortInc(Comparable[] arr) {
        int h = 1;
        while (h < (arr.length / 3)) {
            h = 3 * h + 1;
        }

        while (h >= 1) {

            for (int i = 0; i < h; i++) {
                insertionStepsSortInc(arr, i, h);
            }

            h = h / 3;
        }
    }

    @Override
    public void sortDecComp(Object[] arr, Comparator comp) {
        int h = 1;
        while (h < (arr.length / 3)) {
            h = 3 * h + 1;
        }

        while (h >= 1) {

            for (int i = 0; i < h; i++) {
                insertionStepsSortDec(arr, comp, i, h);
            }

            h = h / 3;
        }
    }


    @Override
    public void sortIncComp(Object[] arr, Comparator comp) {
        int h = 1;
        while (h < (arr.length / 3)) {
            h = 3 * h + 1;
        }

        while (h >= 1) {

            for (int i = 0; i < h; i++) {
                insertionStepsSortInc(arr, comp, i, h);
            }

            h = h / 3;
        }
    }
}
