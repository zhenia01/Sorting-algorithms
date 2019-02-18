package sort;

import java.util.Comparator;

public class MergeSort implements SortStrategy {

    @Override
    public void sortDec(Comparable[] arr) {
        Comparable[] temp = new Comparable[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        mergeSortDec(arr, temp, 0, arr.length - 1);
    }

    @Override
    public void sortInc(Comparable[] arr) {
        Comparable[] temp = new Comparable[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        mergeSortInc(arr, temp, 0, arr.length - 1);
    }

    @Override
    public void sortDecComp(Object[] arr, Comparator comp) {
        Object[] temp = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        mergeSortDecComp(arr, temp, 0, arr.length - 1, comp);
    }

    @Override
    public void sortIncComp(Object[] arr, Comparator comp) {
        Object[] temp = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        mergeSortIncComp(arr, temp, 0, arr.length - 1, comp);
    }

    private void mergeInc(Comparable[] a, Comparable[] temp, int begin, int mid, int end) {
        int i = begin, j = mid + 1;
        for (int k = begin; k <= end; k++) {
            if (i > mid) temp[k] = a[j++];
            else if (j > end) temp[k] = a[i++];
            else if (temp[j].compareTo(temp[i]) < 0) temp[k] = a[j++];
            else temp[k] = a[i++];
        }
    }

    private void mergeSortInc(Comparable[] a, Comparable[] temp, int begin, int end) {
        if (end <= begin) return;
        int mid = begin + (end - begin) / 2;
        mergeSortInc(temp, a, begin, mid);
        mergeSortInc(temp, a, mid + 1, end);
        if (a[mid].compareTo(a[mid+1]) >= 0) return;
        mergeInc(a, temp, begin, mid, end);
    }

    private void mergeDec(Comparable[] a, Comparable[] temp, int begin, int mid, int end) {
        int i = begin, j = mid + 1;
        for (int k = begin; k <= end; k++) {
            if (i > mid) temp[k] = a[j++];
            else if (j > end) temp[k] = a[i++];
            else if (temp[j].compareTo(temp[i]) > 0) temp[k] = a[j++];
            else temp[k] = a[i++];
        }
    }

    private void mergeSortDec(Comparable[] a, Comparable[] temp, int begin, int end) {
        if (end <= begin) return;
        int mid = begin + (end - begin) / 2;
        mergeSortDec(a, temp, begin, mid);
        mergeSortDec(a, temp, mid + 1, end);
        if (a[mid].compareTo(a[mid+1]) >= 0) return;
        mergeDec(a, temp, begin, mid, end);
    }

    private void mergeIncComp(Object[] a, Object[] temp, int begin, int mid, int end, Comparator comp) {
        int i = begin, j = mid + 1;
        for (int k = begin; k <= end; k++) {
            if (i > mid) temp[k] = a[j++];
            else if (j > end) temp[k] = a[i++];
            else if (comp.compare(temp[j], temp[i]) < 0) temp[k] = a[j++];
            else temp[k] = a[i++];
        }
    }

    private void mergeSortIncComp(Object[] a, Object[] temp, int begin, int end, Comparator comp) {
        if (end <= begin) return;
        int mid = begin + (end - begin) / 2;
        mergeSortIncComp(a, temp, begin, mid, comp);
        mergeSortIncComp(a, temp, mid + 1, end, comp);
        if (comp.compare(a[mid], a[mid+1]) >= 0) return;
        mergeIncComp(a, temp, begin, mid, end, comp);
    }

    private void mergeDecComp(Object[] a, Object[] temp, int begin, int mid, int end, Comparator comp) {
        int i = begin, j = mid + 1;
        for (int k = begin; k <= end; k++) {
            if (i > mid) temp[k] = a[j++];
            else if (j > end) temp[k] = a[i++];
            else if (comp.compare(temp[j], temp[i]) > 0) temp[k] = a[j++];
            else temp[k] = a[i++];
        }

    }

    private void mergeSortDecComp(Object[] a, Object[] temp, int begin, int end, Comparator comp) {
        if (end <= begin) return;
        int mid = begin + (end - begin) / 2;
        mergeSortDecComp(a, temp, begin, mid, comp);
        mergeSortDecComp(a, temp, mid + 1, end, comp);
        if (comp.compare(a[mid], a[mid+1]) >= 0) return;
        mergeDecComp(a, temp, begin, mid, end, comp);
    }
}
