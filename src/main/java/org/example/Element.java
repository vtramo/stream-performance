package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Element {
    private int[] numbers;

    public Element(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return this.numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public static Element fromArray(int[] numbers) {
        int[] res = new int[numbers.length];
        System.arraycopy(numbers, 0, res, 0, numbers.length);
        return new Element(res);
    }

    public static Element[] makeElements(int volume, int numbersVolume) {
        Element[] elements = new Element[volume];
        for (int i = 0; i < volume; i++) {
            int[] numbers = new int[numbersVolume];
            for (int j = 0; j < numbersVolume; j++) {
                numbers[j] = ThreadLocalRandom.current().nextInt(10000);
            }
            elements[i] = new Element(numbers);
        }
        return elements;
    }
}