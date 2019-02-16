package sort;

import java.util.Comparator;

public class MergeSort implements SortStrategy {

    @Override
    public void sortDec(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        mergeSortDec(arr, aux, 0, arr.length - 1);
    }

    @Override
    public void sortInc(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        mergeSortInc(arr, aux, 0, arr.length - 1);
    }

    @Override
    public void sortDecComp(Object[] arr, Comparator comp) {
        Object[] aux = new Object[arr.length];
        mergeSortDecComp(arr, aux, 0, arr.length - 1, comp);
    }

    @Override
    public void sortIncComp(Object[] arr, Comparator comp) {
        Object[] aux = new Object[arr.length];
        mergeSortIncComp(arr, aux, 0, arr.length - 1, comp);
    }

    private void mergeInc(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private void mergeSortInc(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSortInc(a, aux, lo, mid);
        mergeSortInc(a, aux, mid + 1, hi);
        mergeInc(a, aux, lo, mid, hi);
    }

    private void mergeDec(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) > 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private void mergeSortDec(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSortDec(a, aux, lo, mid);
        mergeSortDec(a, aux, mid + 1, hi);
        mergeDec(a, aux, lo, mid, hi);
    }

    private void mergeIncComp(Object[] a, Object[] aux, int lo, int mid, int hi, Comparator comp) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (comp.compare(aux[j], aux[i]) < 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private void mergeSortIncComp(Object[] a, Object[] aux, int lo, int hi, Comparator comp) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSortIncComp(a, aux, lo, mid, comp);
        mergeSortIncComp(a, aux, mid + 1, hi, comp);
        mergeIncComp(a, aux, lo, mid, hi, comp);
    }

    private void mergeDecComp(Object[] a, Object[] aux, int lo, int mid, int hi, Comparator comp) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (comp.compare(aux[j], aux[i]) > 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private void mergeSortDecComp(Object[] a, Object[] aux, int lo, int hi, Comparator comp) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSortDecComp(a, aux, lo, mid, comp);
        mergeSortDecComp(a, aux, mid + 1, hi, comp);
        mergeDecComp(a, aux, lo, mid, hi, comp);
    }

}
