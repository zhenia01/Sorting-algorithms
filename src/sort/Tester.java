package sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

class Stopwatch {
    private final long start;
    public Stopwatch() {
        start = System.nanoTime();
    }
    public double elapsedTime() {
        long now = System.nanoTime();
        return (now - start)/1000.0;
    }
}

public class Tester {

    public static void main(String[] args) {
        Random random = new Random();
        Sorter[] sorters = {new Sorter(new BubbleSort()), new Sorter(new SelectionSort()), new Sorter(new InsertionSort()), new Sorter(new CombSort()), new Sorter(new ShellSort()), new Sorter(new QuickSort()), new Sorter(new MergeSort()), new Sorter(new HeapSort())};

        try (BufferedWriter fout = new BufferedWriter(new FileWriter("output.txt"))){

            for (int i = 0; i < sorters.length; i++) {

                fout.write(sorters[i].sortStrategy.getClass().toString().substring(11) + "\n");

                fout.write("\tRandom numbers: \n");

                for (int size = 1; size <= 32; size *= 2) {
                    Integer[] arr = new Integer[1024 * size];

                    for (int j = 0; j < arr.length; j++) {
                        arr[j] = random.nextInt();
                    }

                    Stopwatch stopwatch = new Stopwatch();
                    sorters[i].sortInc(arr);
                    double time = stopwatch.elapsedTime();

                    fout.write("\t\t" + arr.length + ": " + time + "\n");
                }

                fout.write("\tSorted by inc numbers: \n");

                for (int size = 1; size <= 32; size *= 2) {
                    Integer[] arr = new Integer[1024 * size];

                    for (int j = 0; j < arr.length; j++) {
                        arr[j] = random.nextInt();
                    }

                    sorters[5].sortInc(arr);

                    Stopwatch stopwatch = new Stopwatch();
                    sorters[i].sortInc(arr);
                    double time = stopwatch.elapsedTime();

                    fout.write("\t\t" + arr.length + ": " + time + "\n");
                }

                fout.write("\tSorted by dec numbers: \n");

                for (int size = 1; size <= 32; size *= 2) {
                    Integer[] arr = new Integer[1024 * size];

                    for (int j = 0; j < arr.length; j++) {
                        arr[j] = random.nextInt();
                    }

                    sorters[5].sortDec(arr);

                    Stopwatch stopwatch = new Stopwatch();
                    sorters[i].sortInc(arr);
                    double time = stopwatch.elapsedTime();

                    fout.write("\t\t" + arr.length + ": " + time + "\n");
                }

                fout.write("\tEqual numbers: \n");

                for (int size = 1; size <= 32; size *= 2) {
                    Integer[] arr = new Integer[1024 * size];

                    int number = random.nextInt();

                    for (int j = 0; j < arr.length; j++) {
                        arr[j] = number;
                    }

                    Stopwatch stopwatch = new Stopwatch();
                    sorters[i].sortInc(arr);
                    double time = stopwatch.elapsedTime();

                    fout.write("\t\t" + arr.length + ": " + time + "\n");
                }


            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}
