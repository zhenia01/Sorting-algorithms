package sort;

import java.util.Comparator;

public class QuickSort implements SortStrategy {
    @Override
    public void sortDec(Comparable[] arr) {
        quickSortDec(arr, 0, arr.length - 1);
    }

    @Override
    public void sortInc(Comparable[] arr) {
        quickSortInc(arr, 0, arr.length - 1);
    }

    @Override
    public void sortDecComp(Object[] arr, Comparator comp) {
        quickSortDec(arr, 0, arr.length - 1, comp);
    }

    @Override
    public void sortIncComp(Object[] arr, Comparator comp) {
        quickSortInc(arr, 0, arr.length - 1, comp);

    }

    private void quickSortInc(Object[] arr, int begin, int end, Comparator comp) {

        if (end - begin <= 10) {
            insertionSortInc(arr, comp, begin, end);
            return;
        }

        Object mid = arr[(end + begin) / 2]; //element, not index!
        int i = begin;
        int j = end;

        do {
            while (comp.compare(arr[i], mid) < 0) {
                i++;
            }

            while (comp.compare(arr[j], mid) > 0) {
                j--;
            }

            if (i <= j) {
                Object temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (i < end) {
            quickSortInc(arr, i, end, comp);
        }

        if (j > begin) {
            quickSortInc(arr, begin, j, comp);
        }

    }

    private void quickSortDec(Object[] arr, int begin, int end, Comparator comp) {

        if (end - begin <= 10) {
            insertionSortDec(arr, comp, begin, end);
            return;
        }

        Object mid = arr[(end + begin) / 2]; //element, not index!
        int i = begin;
        int j = end;

        do {
            while (comp.compare(arr[i], mid) > 0) {
                i++;
            }

            while (comp.compare(arr[j], mid) < 0) {
                j--;
            }

            if (i <= j) {
                Object temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (i < end) {
            quickSortDec(arr, i, end, comp);
        }

        if (j > begin) {
            quickSortDec(arr, begin, j, comp);
        }

    }

    private void quickSortInc(Comparable[] arr, int begin, int end) {

        if (end - begin <= 10) {
            insertionSortInc(arr, begin, end);
            return;
        }

        Comparable mid = arr[(end + begin) / 2]; //element, not index!
        int i = begin;
        int j = end;

        do {
            while (arr[i].compareTo(mid) < 0) {
                i++;
            }

            while (arr[j].compareTo(mid) > 0) {
                j--;
            }

            if (i <= j) {
                Comparable temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (i < end) {
            quickSortInc(arr, i, end);
        }

        if (j > begin) {
            quickSortInc(arr, begin, j);
        }

    }

    private void quickSortDec(Comparable[] arr, int begin, int end) {

        if (end - begin <= 10) {
            insertionSortDec(arr, begin, end);
            return;
        }

        Comparable mid = arr[(end + begin) / 2]; //element, not index!
        int i = begin;
        int j = end;

        do {
            while (arr[i].compareTo(mid) > 0) {
                i++;
            }

            while (arr[j].compareTo(mid) < 0) {
                j--;
            }

            if (i <= j) {
                Comparable temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (i < end) {
            quickSortDec(arr, i, end);
        }

        if (j > begin) {
            quickSortDec(arr, begin, j);
        }

    }

    private void insertionSortInc(Comparable[] arr, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            int j = i;

            while (j != 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                Comparable temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }

    private void insertionSortDec(Comparable[] arr, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            int j = i;

            while (j != 0 && arr[j].compareTo(arr[j - 1]) > 0) {
                Comparable temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }

    private void insertionSortInc(Object[] arr, Comparator comp, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            int j = i;

            while (j != 0 && comp.compare(arr[j], arr[j - 1]) < 0) {
                Object temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }

    private void insertionSortDec(Object[] arr, Comparator comp, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            int j = i;

            while (j != 0 && comp.compare(arr[j], arr[j - 1]) > 0) {
                Object temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }

}
