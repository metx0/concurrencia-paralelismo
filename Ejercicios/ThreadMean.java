package Ejercicios;

public class ThreadMean implements Runnable {
    private int numbers[];

    public ThreadMean(int numbers[]) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        // Mean is computed as the sum of all the elements 
        // divided by the number of elements (the length of the array)

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        double mean = sum / numbers.length;
        System.out.println("The mean of the integers array is: " + mean);
    }
}
