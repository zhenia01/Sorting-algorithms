package sort;

import java.util.Arrays;
import java.util.Comparator;

public class Tester {

    private static void print(Sorter sorter) {
        Integer[] arr1 = {-10, 0, 1, -5, 6, 3, 2, -9, 5, -7, 9, 4, 10, -4, -3, -2, -1, 7, 8, -8, -6};
        sorter.sortInc(arr1);
        System.out.println("Sort by inc: " + Arrays.toString(arr1));
        sorter.sortDec(arr1);
        System.out.println("Sort by dec: " + Arrays.toString(arr1));

        Worker[] arr2 = {new Worker("Masha", 1000), new Worker("Sasha", 750), new Worker("Kyrylo", 800), new Worker("Serhiy", 1100), new Worker("Adam", 100), new Worker("Ira", 500), new Worker("Zhenia", 9000), new Worker("Denys", 500), new Worker("Artem", 50), new Worker("Sofiia", 1000),};
        sorter.sortIncComp(arr2, new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
        System.out.println("Sort by salary by inc: " + Arrays.toString(arr2));
        sorter.sortDecComp(arr2, new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                return o1.getSalary() - o2.getSalary();
            }
        });
        System.out.println("Sort by salary by dec: " + Arrays.toString(arr2));
        sorter.sortIncComp(arr2, new Comparator<Worker>() {

            @Override
            public int compare(Worker o1, Worker o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Sort by name by inc: " + Arrays.toString(arr2));
        sorter.sortDecComp(arr2, new Comparator<Worker>() {

            @Override
            public int compare(Worker o1, Worker o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Sort by name by dec: " + Arrays.toString(arr2));
        System.out.println();
    }


    public static void main(String[] args) {

        Sorter sorter = new Sorter(new BubbleSort());
        System.out.println("Bubble:");
        print(sorter);

        sorter.changeStrategy(new SelectionSort());
        System.out.println("Selection:");
        print(sorter);

        sorter.changeStrategy(new InsertionSort());
        System.out.println("Insertion:");
        print(sorter);

        sorter.changeStrategy(new CombSort());
        System.out.println("Comb:");
        print(sorter);

        sorter.changeStrategy(new ShellSort());
        System.out.println("Shell:");
        print(sorter);

        sorter.changeStrategy(new QuickSort());
        System.out.println("Quick:");
        print(sorter);

        sorter.changeStrategy(new MergeSort());
        System.out.println("Merge:");
        print(sorter);

        sorter.changeStrategy(new HeapSort());
        System.out.println("Heap:");
        print(sorter);
    }
}
