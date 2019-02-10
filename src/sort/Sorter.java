package sort;

import java.util.Comparator;

class Sorter{
    private SortStrategy sortStrategy;

    Sorter(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    void changeStrategy(SortStrategy newStrategy) {
        sortStrategy = newStrategy;
    }

    public void sortDec(Comparable[] arr) {
        sortStrategy.sortDec(arr);
    }

    public void sortInc(Comparable[] arr) {
        sortStrategy.sortInc(arr);
    }

    public void sortIncComp(Object[] arr, Comparator comp) {
        sortStrategy.sortIncComp(arr, comp);
    }

    public void sortDecComp(Object[] arr, Comparator comp) {
        sortStrategy.sortDecComp(arr, comp);
    }

}
