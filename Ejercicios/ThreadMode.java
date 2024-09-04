package Ejercicios;

import java.util.HashMap;

public class ThreadMode implements Runnable {
    private int numbers[];

    public ThreadMode(int numbers[]) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        // Mode is the number that appears the most in the array

        HashMap<Integer, Integer> ocurrences = new HashMap<>();
        
        for (int number : numbers) {
            if (ocurrences.containsKey(number)) {
                ocurrences.put(number, ocurrences.get(number) + 1);
            } else {
                ocurrences.put(number, 1);
            }
        }

        // Find the key with the highest value (the number that appears the most)

        int resultKey = 1;
        int highestValue = 0;

        for (int key : ocurrences.keySet()) {
            if (ocurrences.get(key) > highestValue) {
                resultKey = key;
                highestValue = ocurrences.get(key);
            }
        }

        System.out.printf("The mode is %d, and it appears %d times \n", resultKey, highestValue);
    }
}
