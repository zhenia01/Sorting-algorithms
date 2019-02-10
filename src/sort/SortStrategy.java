package sort;

import java.util.Comparator;

interface SortStrategy {

    void sortDec(Comparable[] arr); // decrease
    void sortInc(Comparable[] arr); // increase
    void sortDecComp(Object[] arr, Comparator comp);
    void sortIncComp(Object[] arr, Comparator comp);

}
