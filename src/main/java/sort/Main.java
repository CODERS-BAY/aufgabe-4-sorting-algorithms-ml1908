package sort;

import sort.Sorting;

public class Main {

    public static void main(String[] args) {
        final int arraySize = (int) 80;
        // TODO Initialise an int array with random numbers
        int[] array = Sorting.generateRandomArray(arraySize);
        //int[] N = Sorting.generateRandomArray(10);


        //Sorting sorting = new Sorting();
        //int[] randomArray = Sorting.generateRandomArray(50);
        //for (int i = 0; i < randomArray.length; i++){
        //     System.out.println(i);
        // }
        // Erstelle eine Instanz der Klasse oder rufe eine statische Methode auf
        Sorting myObject = new Sorting();

        // Rufe die Methode der Klasse auf


        // TODO Sort the array with your sorting algorithm
        Sorting.mergeSort(array);
//        Sorting sorting = new Sorting();
//
//        // Rufe die Methode über die Instanz auf
//        int[] myArray = sorting.generateRandomArray(100);
//
//        // Vor der Sortierung ausgeben
//        System.out.println("Vor der Sortierung:");
//        for (int num : myArray) {
//            System.out.print(num + " ");
//        }
//
//        // Sortiere das Array
//        sorting.mergeSort(myArray);

        // Nach der Sortierung ausgeben
        //System.out.println("\nNach der Sortierung:");
        //for (int num : myArray) {
        //    System.out.print(num + " ");
        //}

        // TODO Print the array to the console

        Sorting.printArray(array);
//        Sorting printArr = new Sorting();
//
//        // Rufe die Methode über die Instanz auf
//        int[] myArrayli = printArr.generateRandomArray(100);

        // Vor der Sortierung ausgeben
        //System.out.println("Vor der Sortierung:");
        //sorting.printArray(myArrayli);

        // Sortiere das Array
        //sorting.mergeSort(myArrayli);

        // Nach der Sortierung ausgeben
        //System.out.println("\nNach der Sortierung:");
        //sorting.printArray(myArrayli);


        // TODO Do a runtime analysis of your algorithm
        //  For which array size does the execution time start to rise significantly?

        //Sorting.analyseExecTimeMergeSort(array);

        // TODO Compare the execution time of your algorithm with the execution time of your QuickSort or BubbleSort implementation
        array = Sorting.generateRandomArray(arraySize);
        Sorting.compareExecTimes(array);

        // TODO Print the iterations counters on the console



        System.out.println("Merge Sort Counter: " + Sorting.getItCounterMergeSort());
        System.out.println("Quick Sort Counter: " + Sorting.getItCounterQuickSort());
        System.out.println("Bubble Sort Counter: " + Sorting.getItCounterBubbleSort());
    }
}
