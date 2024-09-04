package Ejercicios;

import java.util.Arrays;

public class ArrayProcessing {
    public static void main(String[] args) {
        // Create an array with 1000 random numbers

        int numbers[] = new int[1000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 1000);
        }

        System.out.println(Arrays.toString(numbers));

        // We are going to compute the mean and the mode in different threads
        Thread t1 = new Thread(new ThreadMean(numbers));
        Thread t2 = new Thread(new ThreadMode(numbers));

        t1.start();
        t2.start();
    }
}
