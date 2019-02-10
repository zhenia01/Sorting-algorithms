package sort;

import java.util.Comparator;

public class CombSort implements SortStrategy {

    private final BubbleSort bubble;
    public CombSort() {
        bubble = new BubbleSort();
    }


    @Override
    public void sortDec(Comparable[] arr) {
        int step = (int) (arr.length / 1.247330950103979);

        while (step >= 1) {

            for (int i = 0; i < arr.length - step; i++) {
                if (arr[i].compareTo(arr[i + step]) < 0) {
                    Comparable temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            step = (int) (step / 1.247330950103979);
        }

        bubble.sortDec(arr);
    }

    @Override
    public void sortInc(Comparable[] arr) {
        int step = (int) (arr.length / 1.247330950103979);

        while (step >= 1) {

            for (int i = 0; i < arr.length - step; i++) {
                if (arr[i].compareTo(arr[i + step]) > 0) {
                    Comparable temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            step = (int) (step / 1.247330950103979);
        }

        bubble.sortInc(arr);
    }

    @Override
    public void sortDecComp(Object[] arr, Comparator comp) {
        int step = (int) (arr.length / 1.247330950103979);

        while (step >= 1) {

            for (int i = 0; i < arr.length - step; i++) {
                if (comp.compare(arr[i], arr[i + step]) < 0) {
                    Object temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            step = (int) (step / 1.247330950103979);
        }

        bubble.sortDecComp(arr, comp);
    }

    @Override
    public void sortIncComp(Object[] arr, Comparator comp) {
        int step = (int) (arr.length / 1.247330950103979);

        while (step >= 1) {

            for (int i = 0; i < arr.length - step; i++) {
                if (comp.compare(arr[i], arr[i + step]) > 0) {
                    Object temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            step = (int) (step / 1.247330950103979);
        }

        bubble.sortIncComp(arr, comp);
    }
}
