package sort;

import java.util.Comparator;

public class BubbleSort implements SortStrategy{
    @Override
    public void sortDec(Comparable[] arr) {
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) < 0) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                return;
            }

            flag = false;

        }
    }

    @Override
    public void sortInc(Comparable[] arr) {
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                return;
            }

            flag = false;

        }
    }

    @Override
    public void sortDecComp(Object[] arr, Comparator comp) {
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (comp.compare(arr[j], arr[j + 1]) < 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                return;
            }

            flag = false;

        }
    }

    @Override
    public void sortIncComp(Object[] arr, Comparator comp) {
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (comp.compare(arr[j], arr[j + 1]) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                return;
            }

            flag = false;

        }
    }
}
