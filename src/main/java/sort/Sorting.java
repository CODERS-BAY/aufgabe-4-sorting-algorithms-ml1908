package sort;

import java.util.Arrays;
import java.util.Random;
public class Sorting {

    // TODO Write a method to generate an array of size N initialised with random numbers

    private static final int upperBound = 100;

    private static int itCounterMergeSort = 0;
    private static int itCounterBubbleSort = 0;
    private static int itCounterQuickSort = 0;
    public static int[] generateRandomArray(int size) {
        int[] newArray = new int[size];
        for(int i = 0; i < newArray.length; i++) {
            newArray[i] = new Random().nextInt(upperBound);
        }
        return newArray;
    }



//    public static int[] generateRandomArray(int N) {
//        int[] randomArray = new int[N];
//        Random random = new Random();
//
//        for (int i = 0; i < N; i++) {
//            randomArray[i] = random.nextInt(100);
//            //System.out.println(i);
//        }
//
//        return randomArray;
//        }


        // TODO Implement a sorting algorithm of your choice


    public static void mergeSort(int[] array) {
        itCounterMergeSort = 0;
        mergeSort(array, array.length);
    }

    private static void mergeSort(int[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
            itCounterMergeSort++;
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = array[i];
            itCounterMergeSort++;
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(array, l, r, mid, n - mid);
    }

    private static void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k++] = l[i++];
            }
            else {
                array[k++] = r[j++];
            }
            itCounterMergeSort++;
        }
        while (i < left) {
            array[k++] = l[i++];
            itCounterMergeSort++;
        }
        while (j < right) {
            array[k++] = r[j++];
            itCounterMergeSort++;
        }
    }





//    public static void mergeSort(int[] generateRandomArray) {
//        if (generateRandomArray == null || generateRandomArray.length <= 1) {
//            return; // Bereits sortiert oder leere Liste
//        }
//
//        int middle = generateRandomArray.length / 2;
//        int[] left = new int[middle];
//        int[] right = new int[generateRandomArray.length - middle];
//
//        // Kopieren der Elemente in die linken und rechten Teillisten
//        for (int i = 0; i < middle; i++) {
//            left[i] = generateRandomArray[i];
//        }
//        for (int i = middle; i < generateRandomArray.length; i++) {
//            right[i - middle] = generateRandomArray[i];
//        }
//
//        // Rekursiv die Teillisten sortieren
//        mergeSort(left);
//        mergeSort(right);
//
//        // Die sortierten Teillisten zusammenführen
//        merge(generateRandomArray, left, right);
//    }
//
//    private static void merge(int[] arr, int[] left, int[] right) {
//        int i = 0; // Zeiger für die linke Teilliste
//        int j = 0; // Zeiger für die rechte Teilliste
//        int k = 0; // Zeiger für das ursprüngliche Array
//
//        while (i < left.length && j < right.length) {
//            if (left[i] <= right[j]) {
//                arr[k] = left[i];
//                i++;
//            } else {
//                arr[k] = right[j];
//                j++;
//            }
//            k++;
//        }
//
//        while (i < left.length) {
//            arr[k] = left[i];
//            i++;
//            k++;
//        }
//
//        while (j < right.length) {
//            arr[k] = right[j];
//            j++;
//            k++;
//        }
//    }





        // TODO Implement a printArray method
        public static void printArray(int[] array) {
            StringBuilder builder = new StringBuilder("Print Array: ");
            for (int i = 0; i < array.length; i++) {
                builder.append(array[i]);
                if(i < array.length-1) {
                    builder.append(", ");
                }
            }
            System.out.println(builder.toString());
        }
//    public static void printArray(int[] array) {
//        StringBuilder builder = new StringBuilder("Print Array: ");
//        for (int i = 0; i < array.length; i++) {
//            builder.append(array[i]);
//            if(i < array.length - 1) {
//                builder.append(", ");
//            }
//        }
//        System.out.println(builder.toString());
//    }

        // TODO Write a method to do a runtime analysis of your algorithm.
        //  For which array size does the execution time start to rise significantly?
        public static long analyseExecTimeMergeSort(int[] array) {
            long start = System.nanoTime();
            mergeSort(array);
            long end = System.nanoTime();
            long elapsedTime = end - start;
            System.out.println(String.format("Elapsed time - Merge Sort: %d ns", elapsedTime));
            return elapsedTime;
        }

    public static long analyseExecTimeQuickSort(int[] array) {
        long start = System.nanoTime();
        quickSort(array);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println(String.format("Elapsed time - Quick Sort: %d ns", elapsedTime));
        return elapsedTime;
    }

    public static long analyseExecTimeBubbleSort(int[] array) {
        long start = System.nanoTime();
        bubbleSort(array);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println(String.format("Elapsed time - Bubble Sort: %d ns", elapsedTime));
        return elapsedTime;
    }

    public static void compareExecTimes(int[] array) {
        System.out.println("Comparison of algorithms: ");
        int[] quickArray = Arrays.copyOf(array, array.length);
        int[] bubbleArray = Arrays.copyOf(array, array.length);
        long execTimeMerge = analyseExecTimeMergeSort(array);
        long execTimeQuick = analyseExecTimeQuickSort(quickArray);
        long execTimeBubble = analyseExecTimeBubbleSort(bubbleArray);

        printFastestExecTime(execTimeMerge, execTimeQuick, execTimeBubble);
    }

        // TODO Add global static counter variables to count the number of iterations for each algorithm
        private static void printFastestExecTime(long execTimeMerge, long execTimeQuick, long execTimeBubble){
            String fastestAlgorithm;
            long fastest;
            if (execTimeMerge < execTimeQuick && execTimeMerge < execTimeBubble) {
                fastestAlgorithm = "Merge Sort";
                fastest = execTimeMerge;
            } else if (execTimeQuick < execTimeMerge && execTimeQuick < execTimeBubble) {
                fastestAlgorithm = "Quick Sort";
                fastest = execTimeQuick;
            } else if (execTimeBubble < execTimeMerge && execTimeBubble < execTimeQuick) {
                fastestAlgorithm = "Bubble Sort";
                fastest = execTimeBubble;
            } else {
                fastestAlgorithm = "None";
                fastest = 0;
            }
            System.out.printf("Fastest Algorithm:\n  Name: %s\n  Time: %d ns\n", fastestAlgorithm, fastest);
        }

    public static int getItCounterMergeSort() {
        return itCounterMergeSort;
    }

    public static int getItCounterBubbleSort() {
        return itCounterBubbleSort;
    }

    public static int getItCounterQuickSort() {
        return itCounterQuickSort;
    }


        // TODO Compare the execution time of your algorithm with the execution time of your QuickSort or BubbleSort implementation

    public static void quickSort(int[] array) {
        itCounterQuickSort = 0;
        quickSort(array, 0, array.length-1);
    }

    private static void quickSort(int[] numbers, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(numbers, begin, end);
            quickSort(numbers, begin, partitionIndex - 1);
            quickSort(numbers, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] numbers, int begin, int end) {
        int pivot = numbers[end];
        int i = begin;
        for (int j = begin; j < end; j++) {
            if (numbers[j] <= pivot) {
                int swapTemp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = swapTemp;
                i++;
            }
            itCounterQuickSort++;
        }
        int swapTemp = numbers[i];
        numbers[i] = numbers[end];
        numbers[end] = swapTemp;
        return i;
    }





    public static void bubbleSort(int[] array) {
            itCounterBubbleSort = 0;
            boolean sorted;
            do {
                sorted = true;
                for(int i = 0; i < array.length-1; i++) {
                    if(array[i] > array[i+1]) {
                        int temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        sorted = false;
                    }
                    itCounterBubbleSort++;
                }
            }while(!sorted);
        }

    }
